/*
 * 
 */
package eu.nets.ms.pia.integration.nets.netaxept;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

import javax.inject.Inject;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.AddressingFeature;

import org.datacontract.schemas._2004._07.bbs_epayment.PaymentInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.tempuri.Netaxept;

import epayment.bbs.INetaxept;
import epayment.bbs.Process;
import epayment.bbs.ProcessResponse;
import epayment.bbs.Query;
import epayment.bbs.Register;
import epayment.bbs.RegisterResponse;
import eu.nets.ms.pia.business.domain.PaymentQueryResponse;
import eu.nets.ms.pia.business.logic.PaymentServiceImpl;
import eu.nets.ms.pia.business.sync.SyncService;
import eu.nets.ms.pia.integration.PspConnector;
import eu.nets.ms.pia.integration.nets.netaxept.exception.NetAxeptProviderException;
import eu.nets.ms.pia.integration.nets.netaxept.exception.ServiceNotFoundException;
import eu.nets.ms.pia.service.model.Method;
import eu.nets.ms.pia.service.model.MethodEnum;
import eu.nets.ms.pia.service.model.Operation;
import eu.nets.ms.pia.service.model.PaymentProcessRequest;
import eu.nets.ms.pia.service.model.PaymentProcessResponse;
import eu.nets.ms.pia.service.model.PaymentRegisterRequest;
import eu.nets.ms.pia.service.model.PaymentRegisterResponse;

@Component(value = "NetaxeptSOAP")
public class NetAxeptSOAPConnector implements PspConnector {
	private static final String ERROR_COMMUNICATING_WITH_NETAXEPT = "Error communicating with Netaxept";
	private static final String PAYTRAIL = "Paytrail";
	private static final Logger LOGGER = LoggerFactory.getLogger(NetAxeptSOAPConnector.class);
	private static final String SERVICE_NAME = "NETAXEPT";
	private static final String SERVICE_PATH = "Netaxept.svc";
	private static final String SERVICE_HOST_SUFFIX = "_HOST";
	private static final String SERVICE_PORT_SUFFIX = "_PORT";
	private static final String ERROR_TEXT_UNAVAILABLE = "Unable to find env variables defining Netaxept end point";
	private static final long TMO_WAIT_CALLBACK = 10000;

	@Inject
	private NetAxeptConfig config;
	
	@Inject 
	private SyncService syncService;

	
	synchronized INetaxept createEndPoint(Optional<String> merchantId) {
		String serviceUrl = getServiceURL(SERVICE_NAME);
		LOGGER.debug(">>Create endpoint :{}", serviceUrl);
		Netaxept netAxeptService = new Netaxept();

		INetaxept port = netAxeptService.getEndpoint(new AddressingFeature(true, false));
		
		Map<String, Object> map = ((BindingProvider) port).getRequestContext();
		map.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, serviceUrl);
		map.put("javax.xml.ws.client.receiveTimeout", config.getTimeout());
		map.put(BindingProvider.USERNAME_PROPERTY, config.getUserName(merchantId.orElse(null)));
		map.put(BindingProvider.PASSWORD_PROPERTY, config.getPassword(merchantId.orElse(null)));

		LOGGER.debug("<<CreateEndPoint");
		return port;
	}
	

	/**
	 * <pre>
	 * Registers a payment transaction at Netaxept
	 * 
	 * <b>Important parameters:</b>
	 * Service type Set to 'M'
	 * 
	 * Two types of payments using stored card tokens are used, with and without the need for entry of security code.
	 * 
	 * <b>Without security code</b>
	 * In Netaxept:
	 *      recurring type set to 'R'
	 *      recurring frequency set to 0
	 *      expiration date set to that of the card
	 * 
	 * <b>With security code and 3DS</b>
	 * In Netaxept:
	 *      recurring type set to 'S'
	 *      
	 * 
	 * For registration only, of a card: order.updateStoredPaymentInfo should be set to true
	 * 
	 * The following parameters in the Netaxept API are set through configuration properties of this demo backend:
	 * <b>  
     *   force3Dsecure
     *   redirectUrl
     *   cancelUrl
     *   terminalPaymentMethods
     *   merchantName
     *   token
     *   customerCountry(Paypal only)
     * </b>
	 * 
	 * 
	 * </pre>
	 * @see <a href=https://shop.nets.eu/web/partners/register> Netaxept API - Register</a>
	 * 
	 * 
	 */
	@Override
	public PaymentRegisterResponse registerTransaction(PaymentRegisterRequest request, Map<String, String> additionalData) {
		try {
			Register regRequest = NetAxeptRequestMapper.mapRegisterRequest(request,additionalData, config);
			LOGGER.info("registerTransaction for order:'{}' {} {}", request.getOrderNumber(), request.getAmount().getTotalAmount(), request.getAmount().getCurrencyCode());
			RegisterResponse response = createEndPoint(request.getMerchantId()).register(regRequest);
			setupSynchronization(request, response);
			return NetAxeptRequestMapper.mapRegisterResponse(response, config);
		} catch (Exception e) {
			LOGGER.error(ERROR_COMMUNICATING_WITH_NETAXEPT, e);
			throw new NetAxeptProviderException(e.getMessage(), e);
		}
	}
	
	/**
	 * Setup synchronization.
	 * 
	 * This method creates a lock for payment methods for which callbacks will be issued in the future.
	 * These lock are used to synchronize between the threads of the callback and client calls.
	 *
	 * @param request the request
	 * @param response the response
	 */
	private void setupSynchronization(PaymentRegisterRequest request, RegisterResponse response) {
		Method method = request.getMethod().orElse(null);
		if(method != null){
			MethodEnum methodEnum = MethodEnum.create(method.getId());
			if(MethodEnum.SWISH.equals(methodEnum) || 
			   MethodEnum.VIPPS.equals(methodEnum) || 
			   methodEnum.getId().contains(PAYTRAIL) ||
			   MethodEnum.MOBILE_PAY.equals(methodEnum)){
				syncService.createLock(response.getRegisterResult().getTransactionId());
			}
		}
	}
	
	/**
	 * Two scenarios:
	 * 1) the payment method used is such that authorization is done inside a Payment wallet or bank payment.
	 *    in these cases we need to wait for the Netaxept callback and query for this result.
	 *    We do not trigger an authorization from here.
	 *    
	 * 2) Process method is called with the operation AUTH
	 *    This is used for payment methods like e.g. Card.
	 * 
	 * @see <a href=https://shop.nets.eu/web/partners/process>Netaxept API - Process(AUTH)</a>
	 */
	@Override
	public PaymentProcessResponse authorizeTransaction(PaymentProcessRequest request) {
		try {
			if (syncService.lockExists(request.getTransactionId()) && !request.getAuthRequired()){
				syncService.waitForLockAvailable(request.getTransactionId(), TMO_WAIT_CALLBACK);
				PaymentInfo paymentInfo = getPaymentInfo(request.getTransactionId(), request.getMerchantId());
				return NetAxeptRequestMapper.mapPaymentInfoToProcessResponse(paymentInfo);
			} else if (!syncService.lockExists(request.getTransactionId()) && !request.getAuthRequired()){
				PaymentInfo paymentInfo = getPaymentInfo(request.getTransactionId(), request.getMerchantId());
				return NetAxeptRequestMapper.mapPaymentInfoToProcessResponse(paymentInfo);				
			} else {
				Process authRequest = NetAxeptRequestMapper.mapAuthorizationRequest(request, config);
				ProcessResponse processResponse = createEndPoint(request.getMerchantId()).process(authRequest);
				return NetAxeptRequestMapper.mapAuthorizationResponse(processResponse);
			}
		} catch (Exception e) {
			LOGGER.error(ERROR_COMMUNICATING_WITH_NETAXEPT, e);
			throw new NetAxeptProviderException(e.getMessage(), e);
		}
	}
	/**
	 * 
	 * Process method is called with the operation VERIFY
	 * 
	 * @see <a href=https://shop.nets.eu/web/partners/process>Netaxept API - Process(VERIFY)</a>
	 */
	@Override
	public PaymentProcessResponse verifyTransaction(PaymentProcessRequest request) {
		try {

			Process verifyRequest = NetAxeptRequestMapper.mapAuthorizationRequest(request, config);

			ProcessResponse processResponse = createEndPoint(request.getMerchantId()).process(verifyRequest);
			return NetAxeptRequestMapper.mapAuthorizationResponse(processResponse);
		} catch (Exception e) {
			LOGGER.error(ERROR_COMMUNICATING_WITH_NETAXEPT, e);
			throw new NetAxeptProviderException(e.getMessage(), e);
		}
	}
	
	/**
	 * 
	 * Process method is called with the operation CAPTURE if finalization is to be done with success, i.e COMMIT
	 * 
	 * Otherwise operation = ANNUL for rolling back
	 * 
	 * @see <a href=https://shop.nets.eu/web/partners/process>Netaxept API - Process(CAPTURE/ANNUL</a>
	 */
	@Override
	public PaymentProcessResponse finalizeTransaction(PaymentProcessRequest request) {
		try {
			Process finalizeRequest = NetAxeptRequestMapper.mapFinalizationRequest(request, config);

			ProcessResponse processResponse = createEndPoint(request.getMerchantId()).process(finalizeRequest);
			return NetAxeptRequestMapper.mapFinalizationResponse(processResponse);
			
		} catch (Exception e) {
			LOGGER.error(ERROR_COMMUNICATING_WITH_NETAXEPT, e);
			throw new NetAxeptProviderException(e.getMessage(), e);
		}
	}

	public static String getServiceURL(String serviceName) {
		String host = getEnvOrDefault(serviceName + SERVICE_HOST_SUFFIX, null);
		String port = getEnvOrDefault(serviceName + SERVICE_PORT_SUFFIX, "443");
		if (host == null) {
			throw new ServiceNotFoundException(ERROR_TEXT_UNAVAILABLE + ":" + serviceName);
		}
		String url = new StringBuilder("http").append("443".equals(port) ? "s://" : "://").append(host).append("/")
				.append(SERVICE_PATH).toString();

		LOGGER.debug(serviceName + ":" + url);
		return url;
	}

	private static String getEnvOrDefault(String var, String def) {
		String val = System.getenv(var);
		if (val == null) {
			val = def;
		}
		LOGGER.debug(var + "=" + val);
		return val;
	}
	
	/**
	 * 
	 * @see <a href=https://shop.nets.eu/web/partners/query> Netaxept API - Query</a>
	 */
	@Override
	public PaymentQueryResponse queryTransaction(String transactionId, Optional<String> merchantId) {
		try {
			Query query = NetAxeptRequestMapper.mapQueryRequest(transactionId, merchantId, config);

			epayment.bbs.QueryResponse response = createEndPoint(merchantId).query(query);
			return NetAxeptRequestMapper.mapQueryResponse(response, config);
		} catch (Exception e) {
			LOGGER.error(ERROR_COMMUNICATING_WITH_NETAXEPT, e);
			throw new NetAxeptProviderException(e.getMessage(), e);
		}
	}
	
	private PaymentInfo getPaymentInfo(String transactionId, Optional<String> merchantId) {
		try {
			Query query = NetAxeptRequestMapper.mapQueryRequest(transactionId, merchantId, config);

			epayment.bbs.QueryResponse response = createEndPoint(merchantId).query(query);
			if(response == null || response.getQueryResult() == null){
				throw new NetAxeptProviderException("Query response is null");
			}
			return (PaymentInfo)response.getQueryResult();
		} catch (Exception e) {
			LOGGER.error(ERROR_COMMUNICATING_WITH_NETAXEPT, e);
			throw new NetAxeptProviderException(e.getMessage(), e);
		}
	}

}
