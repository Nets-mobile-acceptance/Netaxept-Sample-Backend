package eu.nets.ms.pia.integration.nets.netaxept;

import static eu.nets.ms.pia.business.logic.PaymentServiceImpl.APPLE_PAY;
import static eu.nets.ms.pia.business.logic.PaymentServiceImpl.EASY_PAY;
import static eu.nets.ms.pia.business.logic.PaymentServiceImpl.PAY_PAL;
import static eu.nets.ms.pia.business.logic.PaymentServiceImpl.SWISH;
import static eu.nets.ms.pia.business.logic.PaymentServiceImpl.VIPPS;
import static eu.nets.ms.pia.business.logic.PaymentServiceImpl.MOBILE_PAY;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.datacontract.schemas._2004._07.bbs_epayment.ArrayOfPaymentMethodAction;
import org.datacontract.schemas._2004._07.bbs_epayment.Customer;
import org.datacontract.schemas._2004._07.bbs_epayment.Environment;
import org.datacontract.schemas._2004._07.bbs_epayment.Order;
import org.datacontract.schemas._2004._07.bbs_epayment.PaymentInfo;
import org.datacontract.schemas._2004._07.bbs_epayment.PaymentMethodAction;
import org.datacontract.schemas._2004._07.bbs_epayment.ProcessRequest;
import org.datacontract.schemas._2004._07.bbs_epayment.QueryRequest;
import org.datacontract.schemas._2004._07.bbs_epayment.Recurring;
import org.datacontract.schemas._2004._07.bbs_epayment.RegisterRequest;
import org.datacontract.schemas._2004._07.bbs_epayment.Terminal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import epayment.bbs.Process;
import epayment.bbs.ProcessResponse;
import epayment.bbs.Query;
import epayment.bbs.QueryResponse;
import epayment.bbs.Register;
import epayment.bbs.RegisterResponse;
import eu.nets.ms.pia.business.domain.AdditionalData;
import eu.nets.ms.pia.business.domain.CardToken;
import eu.nets.ms.pia.business.domain.PaymentQueryResponse;
import eu.nets.ms.pia.integration.nets.netaxept.exception.NetAxeptProviderException;
import eu.nets.ms.pia.service.model.Operation;
import eu.nets.ms.pia.service.model.PaymentProcessRequest;
import eu.nets.ms.pia.service.model.PaymentProcessResponse;
import eu.nets.ms.pia.service.model.PaymentRegisterRequest;
import eu.nets.ms.pia.service.model.PaymentRegisterResponse;

public class NetAxeptRequestMapper {
	private static final String DEFAULT_DATE = "19700101";
	private static final String DEFAULT_COUNTRY_CODE = "GB";
	private static final String WS_PLATFORM = "JAX-WS";
	private static final String ENCODING = "UTF-8";
	private static final String PAYTRAIL = "Paytrail";
	private static final Logger LOGGER = LoggerFactory.getLogger(NetAxeptRequestMapper.class);
	private enum NetaxeptOperation { AUTH, SALE, CAPTURE, CREDIT, ANNUL,VERIFY };
	
	public static Register mapRegisterRequest(PaymentRegisterRequest request, Map<String, String> additionalData, NetAxeptConfig cfg){
		//Build the structure
		RegisterRequest registerRequest = new RegisterRequest();
		registerRequest.setOrder(new Order());
		registerRequest.setEnvironment(new Environment());
		registerRequest.setTerminal(new Terminal());
		boolean terminalUsedByConsumer = true;
		
		// reset redirectUrl to default value
		cfg.setRedirectUrl();
		
		//Setup Base data
		registerRequest.setTransactionReconRef(request.getOrderNumber());
		// For in-app payments set service type to 'M' except Paypal
		registerRequest.setServiceType("M");
		
		//Setup Order
		if(request.getAmount().getTotalAmount() != 0)
		{
			// normal transaction
			registerRequest.getOrder().setAmount(request.getAmount().getTotalAmount().toString());			
		}
		else
		{		
			// we are storing the card only, not making transaction
			registerRequest.getOrder().setUpdateStoredPaymentInfo("true");
		}

		registerRequest.getOrder().setCurrencyCode(request.getAmount().getCurrencyCode());
		registerRequest.getOrder().setForce3DSecure(Boolean.toString(cfg.isForce3Dsecure()));
		registerRequest.getOrder().setOrderNumber(request.getOrderNumber());
		
		//Stage transaction triggering storing of this card for future use
		if(request.getStoreCard() == true ){
			if(String.valueOf(false).equals(additionalData.get(AdditionalData.REQUIRE_CVV_FROM_CONSUMER))) {//CVC/CVV is NOT required for Subsequent transactions 
				registerRequest.setRecurring(new Recurring());
				registerRequest.getRecurring().setType("R");
				registerRequest.getRecurring().setFrequency("0");
				registerRequest.getRecurring().setExpiryDate(convertToRecuringExpiryDate(getDefaultRecuringExpiryDate()));
			}else {//CVC/CVV is required for Subsequent transactions 
				registerRequest.setRecurring(new Recurring());
				registerRequest.getRecurring().setType("S");
			}
			// Added this new parameter RecurringTransactionType due to EU regulatory framework PSD2 requested by Netaxept
			// for recurring or Easy payment transactions only
			registerRequest.getRecurring().setRecurringTransactionType(null);
		}
		
		//Stage transaction using stored card
		if(request.getMethod().isPresent() && request.getMethod().get().equals(EASY_PAY)){
			if(registerRequest.getRecurring() == null){
				registerRequest.setRecurring(new Recurring());
				if(String.valueOf(false).equals(additionalData.get(AdditionalData.REQUIRE_CVV_FROM_CONSUMER))){//Update recurring Expiry date after card is stored
					registerRequest.getRecurring().setType("R");
					registerRequest.getRecurring().setFrequency("0");
					registerRequest.getRecurring().setExpiryDate(convertToRecuringExpiryDate(additionalData.get(AdditionalData.CARD_EXPIRATION_DATE)));
				}else{
					registerRequest.getRecurring().setType("S");
				}
			}
			registerRequest.getRecurring().setPanHash(additionalData.get(AdditionalData.CARD_TOKEN_VALUE));
			registerRequest.getRecurring().setUse3DS(Boolean.toString(cfg.isSubsequent3Dsecure()));
			// Added this new parameter RecurringTransactionType due to EU regulatory framework PSD2 requested by Netaxept
			// for recurring or Easy payment transactions only
			registerRequest.getRecurring().setRecurringTransactionType(null);
		}
		//Stage transaction using ApplePay
		else if(request.getMethod().isPresent() && request.getMethod().get().equals(APPLE_PAY)){
			ArrayOfPaymentMethodAction actionList = new ArrayOfPaymentMethodAction();
			PaymentMethodAction action = new PaymentMethodAction();
			action.setPaymentMethod(APPLE_PAY.getId());
			actionList.getPaymentMethodAction().add(action);
			registerRequest.getTerminal().setPaymentMethodActionList(actionList);
			registerRequest.getTerminal().setPaymentData(additionalData.get(AdditionalData.APPLE_PAY_DATA));
		}
		//Stage transaction using Paypal
		else if(request.getMethod().isPresent() && request.getMethod().get().equals(PAY_PAL)){
			ArrayOfPaymentMethodAction actionList = new ArrayOfPaymentMethodAction();
			PaymentMethodAction action = new PaymentMethodAction();
			action.setPaymentMethod(PAY_PAL.getId());
			actionList.getPaymentMethodAction().add(action);
			registerRequest.getTerminal().setPaymentMethodActionList(actionList);

			//Setup Customer (optional)
			registerRequest.setCustomer(new Customer());
			registerRequest.getCustomer().setCountry(DEFAULT_COUNTRY_CODE);
			// For in-app payments set service type to 'M' except Paypal and paytrail bank payment
			registerRequest.setServiceType("B");
		}
		//Stage transaction using Swish / Vipps
		else if(request.getMethod().isPresent() && (request.getMethod().get().equals(SWISH) || request.getMethod().get().equals(VIPPS))){
			ArrayOfPaymentMethodAction actionList = new ArrayOfPaymentMethodAction();
			PaymentMethodAction action = new PaymentMethodAction();
			action.setPaymentMethod(request.getMethod().get().getId());
			actionList.getPaymentMethodAction().add(action);
			registerRequest.getTerminal().setPaymentMethodActionList(actionList);
			Customer customer = new Customer();
			customer.setPhoneNumber(request.getPhoneNumber().orElse(null));
			if(request.getRedirectUrl().isPresent()) {
				cfg.setRedirectUrl(request.getRedirectUrl().get());
			}
			registerRequest.setCustomer(customer);
		}
		//Stage transaction using MobilePay
		else if(request.getMethod().isPresent() && (request.getMethod().get().equals(MOBILE_PAY))){
			ArrayOfPaymentMethodAction actionList = new ArrayOfPaymentMethodAction();
			PaymentMethodAction action = new PaymentMethodAction();
			action.setPaymentMethod(request.getMethod().get().getId());
			actionList.getPaymentMethodAction().add(action);
			registerRequest.getTerminal().setPaymentMethodActionList(actionList);
			if(request.getRedirectUrl().isPresent()) {
				cfg.setRedirectUrl(request.getRedirectUrl().get());
			}
		}
		//Stage transaction using Paytrail bank payment
		else if(request.getMethod().isPresent() && (request.getMethod().get().getId() !=null && request.getMethod().get().getId().contains(PAYTRAIL))){
			ArrayOfPaymentMethodAction actionList = new ArrayOfPaymentMethodAction();
			PaymentMethodAction action = new PaymentMethodAction();
			action.setPaymentMethod(request.getMethod().get().getId());
			actionList.getPaymentMethodAction().add(action);
			registerRequest.getTerminal().setPaymentMethodActionList(actionList);

			//Setup Customer (mandatory)
			Customer customer = new Customer();
			customer.setEmail(request.getCustomerEmail().orElse(null));
			customer.setFirstName(request.getCustomerFirstNamer().orElse(null));
			customer.setLastName(request.getCustomerLastName().orElse(null));
			customer.setAddress1(request.getCustomerAddress1().orElse(null));
			customer.setPostcode(request.getCustomerPostCode().orElse(null));
			customer.setTown(request.getCustomerTown().orElse(null));
			customer.setCountry(request.getCustomerCountry().orElse(null));
			registerRequest.setCustomer(customer);

			// 3D Secure is not needed for bank payment
			registerRequest.getOrder().setForce3DSecure(Boolean.toString(false));

			// For in-app payments set service type to 'M' except Paypal and Paytrail bank payment
			registerRequest.setServiceType("B");
		}
		//Setup Env
		registerRequest.getEnvironment().setWebServicePlatform(WS_PLATFORM);
		
		//Setup terminal
		registerRequest.getTerminal().setRedirectUrl(cfg.getRedirectUrl());
		registerRequest.getTerminal().setRedirectOnError(cfg.getCancelUrl());
		registerRequest.getTerminal().setVat(request.getAmount().getVatAmount().toString());

		Register register = new Register();
		register.setRequest(registerRequest);
		register.setMerchantId(cfg.getUserName(request.getMerchantId().orElse(null)));
		register.setToken(cfg.getToken(request.getMerchantId().orElse(null)));
		return register;
	}

	protected static String getDefaultRecuringExpiryDate() {
		Calendar dateMoreThreeYear = Calendar.getInstance();
		dateMoreThreeYear.setTime(new Date());
		// Add three years more
		dateMoreThreeYear.add(Calendar.YEAR, 3);
		SimpleDateFormat formatter = new SimpleDateFormat("MM/yy");
		return formatter.format(dateMoreThreeYear.getTime());
	}
	
	protected static String convertToRecuringExpiryDate(String cardExpiryDate) {
		if(cardExpiryDate == null){
			return DEFAULT_DATE;
		}
		Pattern pattern = Pattern.compile("(\\d\\d)\\/(\\d\\d)");
		
		Matcher matcher = pattern.matcher(cardExpiryDate);
		if(!matcher.matches()){
			return DEFAULT_DATE;
		}
		int month = 1 + Integer.parseInt(matcher.group(1));
		int year = 2000 + Integer.parseInt(matcher.group(2));
		
		if(month > 12){
			year++;
			month=1;
		}
		return String.format("%d%02d01", year, month);
	}


	public static PaymentRegisterResponse mapRegisterResponse(RegisterResponse response, NetAxeptConfig cfg ) {
		if(response == null || response.getRegisterResult() == null){
			throw new NetAxeptProviderException("Register response is null");
		}
		return PaymentRegisterResponse.newBuilder()
				.transactionId(response.getRegisterResult().getTransactionId())
				.walletUrl(response.getRegisterResult().getWalletURL())
				.redirectOK(cfg.getRedirectUrl())
				.redirectCancel(cfg.getCancelUrl())
				.build();
	}
	
	public static Query mapQueryRequest(String transactionId, Optional<String> merchantId, NetAxeptConfig cfg){
		//Build the structure
		QueryRequest queryRequest = new QueryRequest();
		
		queryRequest.setTransactionId(transactionId);
		
		Query query = new Query();
		query.setRequest(queryRequest);
		query.setMerchantId(cfg.getUserName(merchantId.orElse(null)));
		query.setToken(cfg.getToken(merchantId.orElse(null)));
		return query;
	}	
	
	public static PaymentQueryResponse mapQueryResponse(QueryResponse response, NetAxeptConfig cfg ) {
		if(response == null || response.getQueryResult() == null){
			throw new NetAxeptProviderException("Query response is null");
		}
		CardToken cardToken = null;
		PaymentInfo paymantInfo = (PaymentInfo)response.getQueryResult();
		if(paymantInfo.getCardInformation() != null && paymantInfo.getCardInformation().getPanHash() != null){
			cardToken = new CardToken();
			cardToken.setName(paymantInfo.getCardInformation().getMaskedPAN());
			cardToken.setIssuer(paymantInfo.getCardInformation().getIssuer());
			if(paymantInfo.getCardInformation().getExpiryDate() != null){
				cardToken.setExpiryDate(paymantInfo.getCardInformation().getExpiryDate().replaceAll("(.{2})(.{2})", "$2/$1"));
			}
			cardToken.setValue(paymantInfo.getCardInformation().getPanHash());
		}
		return PaymentQueryResponse.newBuilder()
				.transactionId(response.getQueryResult().getTransactionId())
				.withToken(cardToken)
				.build();
	}
	public static PaymentProcessResponse mapPaymentInfoToProcessResponse(PaymentInfo paymentInfo) {
		String responseCode = "ERROR";
		String operation = "SALE";
		if(paymentInfo.getSummary().isAuthorized()){
			responseCode = "OK";
			if(paymentInfo.getSummary().getAmountCaptured().equals(paymentInfo.getOrderInformation().getAmount())){
				operation = "CREDIT";
			}
		}
		 return PaymentProcessResponse.newBuilder()
			   		.operation(mapOperation(operation))
			   		.transactionId(paymentInfo.getTransactionId())
			   		.authorizationId(paymentInfo.getSummary().getAuthorizationId())
			   		.executionTimestamp(paymentInfo.getQueryFinished())
			   		.responseCode(responseCode)
			   		.build();
	}
	
	public static Process mapAuthorizationRequest(PaymentProcessRequest request, NetAxeptConfig cfg) {
		return createProcessRequest(request, cfg);
	}
	
	public static PaymentProcessResponse mapAuthorizationResponse(ProcessResponse response) {
		return createProcessResponse(response);
	}
	
	public static Process mapFinalizationRequest(PaymentProcessRequest request, NetAxeptConfig cfg) {
		return createProcessRequest(request, cfg);
	}
	public static PaymentProcessResponse mapFinalizationResponse(ProcessResponse response) {
		return createProcessResponse(response);
	}


	private static Process createProcessRequest(PaymentProcessRequest request, NetAxeptConfig cfg) {
		Process processAuth = new Process();
		ProcessRequest processRq = new ProcessRequest();
		processRq.setOperation(mapOperation(request.getOperation()));
		processRq.setTransactionId(request.getTransactionId());
		processRq.setDescription(request.getDescription());
		processRq.setTransactionReconRef(request.getTransactionReference());
		
		processAuth.setMerchantId(cfg.getUserName(request.getMerchantId().orElse(null)));
		processAuth.setToken(cfg.getToken(request.getMerchantId().orElse(null)));
		processAuth.setRequest(processRq);
		return processAuth;
	}
	private static PaymentProcessResponse createProcessResponse(ProcessResponse response) {
		if(response == null || response.getProcessResult() == null){
			throw new NetAxeptProviderException("Process response is null");
		}
	   return PaymentProcessResponse.newBuilder()
			   		.operation(mapOperation(response.getProcessResult().getOperation()))
			   		.transactionId(response.getProcessResult().getTransactionId())
			   		.authorizationId(response.getProcessResult().getAuthorizationId())
			   		.executionTimestamp(response.getProcessResult().getExecutionTime())
			   		.batch(getBatchNumber(response))
			   		.responseCode(response.getProcessResult().getResponseCode())
			   		.responseSource(response.getProcessResult().getResponseSource())
			   		.responseText(response.getProcessResult().getResponseText())
			   		.build();
	}

	private static String getBatchNumber(ProcessResponse response) {
		Operation op = mapOperation(response.getProcessResult().getOperation());
		if( op == Operation.VERIFY ) {
			return "0";
		} else {
			return response.getProcessResult().getBatchNumber();
		}
	}
	
	private static String mapOperation(Operation operation) {
		switch(operation){
		case COMMIT:
			return NetaxeptOperation.CAPTURE.toString();
		case ROLLBACK:
			return NetaxeptOperation.ANNUL.toString();
		case REFUND:
			return NetaxeptOperation.CREDIT.toString();
		case AUTHORIZE:
			return NetaxeptOperation.AUTH.toString();
		case PAY:
			return NetaxeptOperation.SALE.toString();
		case VERIFY:
			return NetaxeptOperation.VERIFY.toString();
		default:
			return null;
	}
	}
	private static Operation mapOperation(String netaxeptOperation) {
		switch(netaxeptOperation){
		case "CAPTURE":
			return Operation.COMMIT;
		case "ANNUL":
			return Operation.ROLLBACK;
		case "CREDIT":
			return Operation.REFUND;
		case "AUTH":
			return Operation.AUTHORIZE;
		case "SALE":
			return Operation.PAY;
		case "VERIFY":
			return Operation.VERIFY;
		default:
			return null;
	}
	}
}