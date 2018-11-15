package eu.nets.ms.pia.business.logic;

import static eu.nets.ms.pia.service.model.Operation.AUTHORIZE;
import static eu.nets.ms.pia.service.model.Operation.COMMIT;
import static eu.nets.ms.pia.service.model.Operation.ROLLBACK;
import static eu.nets.ms.pia.service.model.Operation.VERIFY;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import eu.nets.ms.pia.business.domain.AdditionalData;
import eu.nets.ms.pia.business.domain.Amount;
import eu.nets.ms.pia.business.domain.CardToken;
import eu.nets.ms.pia.business.domain.Consumer;
import eu.nets.ms.pia.business.domain.Order;
import eu.nets.ms.pia.business.domain.PaymentQueryResponse;
import eu.nets.ms.pia.business.domain.PaymentState;
import eu.nets.ms.pia.business.logic.persistence.PaymentPersistenceService;
import eu.nets.ms.pia.exception.BusinessServiceException;
import eu.nets.ms.pia.integration.PspConnector;
import eu.nets.ms.pia.service.model.CardTokenDto;
import eu.nets.ms.pia.service.model.Method;
import eu.nets.ms.pia.service.model.MethodEnum;
import eu.nets.ms.pia.service.model.PaymentMethods;
import eu.nets.ms.pia.service.model.PaymentProcessRequest;
import eu.nets.ms.pia.service.model.PaymentProcessResponse;
import eu.nets.ms.pia.service.model.PaymentRegisterRequest;
import eu.nets.ms.pia.service.model.PaymentRegisterResponse;
import eu.nets.ms.pia.service.model.ResponseCode;

/**
 * <pre>
 * This class implements the payment logic.
 * The payment flow follows the following process:
 * 
 * 1) Register payment.
 *    This will stage a payment order in Netaxept using the parameters provided.
 *    The parameters define what type of payment is staged and will govern what steps are to follow.
 *    A unique reference to the staged transaction will be returned to the consumer and is to be used 
 *    during further processing.
 *    
 * 2) Terminal call
 *    This phase does not involve this component.
 *    During this phase the Client SDK will provide payment details directly to Netaxept.
 *    For card payments this is PCI sensitive data like card number, CVV/CVD/CID.
 *    This data will be appended to the transaction identified by the transactionId returned during phase 1).
 *    This secret data is never passes through this component. It is transmitted and stored in the PCI certified
 *    environment at Netaxept.
 *    When done this data will be available for further processing the payment.
 *  
 * 3) Authorization
 *    A call is made to Netaxept to authorize the transaction using the staged data.
 *    If the authorization succeeds the Order is placed to the Fake Order service.
 *    Once the order has been placed successfully the money can be captured in the next stage. 
 *    After successful authorization also the card token is stored for future use, if that option was selected during phase 1)
 *    
 * 4) Finalization
 *    During this phase the payment is either captured or cancelled.
 *    The criteria for this is if the goods was successfully processed via the fake order service.
 *    
 *    A cancellation at this stage will free the amount which was reserved to the card account during phase 2.
 *     
 *    After capture, the transaction is complete and cannot be reversed. In that case a refund needs to be 
 *    invoked which is out of scope for this demo.
 * </pre>
 */
@Service
public class PaymentServiceImpl implements PaymentService {
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);
	public static final Method EASY_PAY = new Method(MethodEnum.EASY_PAY);
	public static final Method APPLE_PAY = new Method(MethodEnum.APPLE_PAY);
	public static final Method PAY_PAL = new Method(MethodEnum.PAY_PAL);
	
	@Inject
	@Qualifier("NetaxeptSOAP")
	PspConnector connector;

	@Inject
	OrderService orderservice;

	@Inject
	PaymentPersistenceService persistenceService;

	/* (non-Javadoc)
	 * @see eu.nets.ms.pia.business.logic.PaymentService#getPaymentMethods(java.lang.String)
	 */
	@Override
	public PaymentMethods getPaymentMethods(String consumerId) {
		// If consumer is defined check to see if there is a store card to be
		// used for payment.
		if (consumerId != null) {
			Consumer consumer = persistenceService.findConsumer(consumerId);
			if (consumer != null && consumer.getCardTokens() != null && !consumer.getCardTokens().isEmpty()) {
				List<CardTokenDto> tokenDtos = new ArrayList<>();
				for (CardToken token : consumer.getCardTokens()) {
					tokenDtos.add(CardTokenDto.newBuilder().tokenId(token.getName()).issuer(token.getIssuer())
							.expiryDate(token.getExpiryDate()).build());
				}
				return new PaymentMethods(tokenDtos, consumer.isRequiredCardVerificationSubsequent());
			}
		}
		return new PaymentMethods(true);
	}

	/* (non-Javadoc)
	 * @see eu.nets.ms.pia.business.logic.PaymentService#register(eu.nets.ms.pia.service.model.PaymentRegisterRequest, java.lang.String)
	 */
	@Override
	public PaymentRegisterResponse register(PaymentRegisterRequest request, String host) throws BusinessServiceException {
		LOGGER.info(">> Register payment: {}", request);
		try {
			Map<String, String> additionalData = new HashMap<>();
			Consumer consumer = persistenceService.findConsumer(request.getCustomerId());
			
			//Handle EasyPay as selected method
			if(request.getMethod().isPresent()  && request.getMethod().get().equals(EASY_PAY)){
				prepareEasyPayData(request, additionalData, consumer);
			}
			//Handle ApplePay as selected method
			else if(request.getMethod().isPresent()  && request.getMethod().get().equals(APPLE_PAY)){
				prepareApplePayData(request, additionalData);
			}
			
			additionalData.put(AdditionalData.REQUIRE_CVV_FROM_CONSUMER, (consumer==null) ? "true": String.valueOf(consumer.isRequiredCardVerificationSubsequent()));
			PaymentRegisterResponse response = connector.registerTransaction(request, additionalData);
			LOGGER.info("<< Register response: {}", response);

			Order order = createOrderFromRequest(request, response.getTransactionId());
			orderservice.prepareOrder(order);

			return response;
		} catch (Exception e) {
			throw new BusinessServiceException(e.getMessage(), e);
		}
	}

	

	/**
	 * Prepare easy pay data.
	 * 
	 * Uses the tokenId from the request to find the token stored by the consumer
	 * This, together with the expiration date is then populated to the aditional data map. 
	 *
	 * @param request the request
	 * @param additionalData the additional data
	 * @param consumer the consumer
	 * @throws BusinessServiceException the business service exception
	 */
	private void prepareEasyPayData(PaymentRegisterRequest request, Map<String, String> additionalData,	Consumer consumer) throws BusinessServiceException {
		LOGGER.info(consumer.toString());
		Optional<CardToken> wantedToken = consumer.getCardTokens().stream().filter(token -> token.getName().equals(request.getCardId().orElse(null))).findFirst();
		if(!wantedToken.isPresent()){
			throw new BusinessServiceException("Requested token is not registered");
		}
		additionalData.put(AdditionalData.CARD_TOKEN_VALUE, wantedToken.get().getValue());
		additionalData.put(AdditionalData.CARD_EXPIRATION_DATE, wantedToken.get().getExpiryDate());
	}
	
	/**
	 * Prepare ApplePay data.
	 *
	 * Populate the additional data map with the payment data received in the register request.
	 * @param request the request
	 * @param additionalData the additional data
	 */
	private void prepareApplePayData(PaymentRegisterRequest request, Map<String, String> additionalData) {
		additionalData.put(AdditionalData.APPLE_PAY_DATA, request.getPaymentData().get());
	}

	/* (non-Javadoc)
	 * @see eu.nets.ms.pia.business.logic.PaymentService#process(java.lang.String)
	 */
	@Override
	public PaymentProcessResponse process(String paymentId, String merchantId) throws BusinessServiceException {
		LOGGER.info(">> Process payment: {}", paymentId);

		Order order = getOrderIfCorrectState(paymentId);
		
		String reference = String.valueOf(order.getOrderId());
		// Authorize the transaction
		PaymentProcessRequest authorizationRq = PaymentProcessRequest.newBuilder()
				.operation(AUTHORIZE)
				.transactionId(paymentId)
				.merchantId(merchantId)
				.description("Some description")
				.transactionReference(reference)
				.build();

		PaymentProcessResponse authResponse = connector.authorizeTransaction(authorizationRq);

		if (ResponseCode.OK.name().equals(authResponse.getResponseCode())) {
			// Process the order and if OK capture the previously authorized
			// amount

			//Check if we have card to store
			storeCardToken(authResponse.getTransactionId(), order.getConsumer(), authorizationRq.getMerchantId());
			
			PaymentProcessResponse finalizeResponse;

			if (orderservice.placeOrder(paymentId) == true) {
				finalizeResponse = connector.finalizeTransaction(PaymentProcessRequest.newBuilder()
						.operation(COMMIT)
						.transactionId(authResponse.getTransactionId())
						.merchantId(merchantId)
						.description(authorizationRq.getDescription())
						.transactionReference(reference)
						.build());
				if (ResponseCode.OK.name().equals(finalizeResponse.getResponseCode())) {
					orderservice.finalizeOrder(paymentId, PaymentState.PAID);
				} else {
					// COMMIT failed, revert auth, and mark order as cancelled
					connector.finalizeTransaction(PaymentProcessRequest.newBuilder()
							.operation(ROLLBACK)
							.transactionId(authResponse.getTransactionId())
							.merchantId(merchantId)
							.transactionReference(reference)
							.description(authorizationRq.getDescription())
							.build());

					orderservice.finalizeOrder(paymentId, PaymentState.CANCELLED);

				}
			} else {
				LOGGER.error("Order " + paymentId + " Not placed. Rolling back transaction");
				finalizeResponse = connector.finalizeTransaction(PaymentProcessRequest.newBuilder().operation(ROLLBACK)
						.transactionId(authResponse.getTransactionId())
						.merchantId(merchantId)
						.transactionReference(reference)
						.description(authorizationRq.getDescription()).build());

				orderservice.finalizeOrder(paymentId, PaymentState.CANCELLED);
			}
			LOGGER.info("<< Process response: {}", finalizeResponse);
			return finalizeResponse;
		}
		// Transaction was not authorized
		LOGGER.info("<< Process response: {}", authResponse);

		// Mark order as cancelled
		orderservice.finalizeOrder(paymentId, PaymentState.CANCELLED);

		return authResponse;
	}

	/* (non-Javadoc)
	 * @see eu.nets.ms.pia.business.logic.PaymentService#verify(java.lang.String)
	 */
	@Override
	public PaymentProcessResponse verify(String paymentId, String merchantId) throws BusinessServiceException {
		LOGGER.info(">> Verify payment: {}", paymentId);

		Order order = getOrderIfCorrectState(paymentId);
		
		String reference = String.valueOf(order.getOrderId());
		// Authorize the transaction
		PaymentProcessRequest verifyReq = PaymentProcessRequest.newBuilder()
				.operation(VERIFY)
				.transactionId(paymentId)
				.merchantId(merchantId)
				.description("Tokenizing card")
				.transactionReference(reference)
				.build();

		PaymentProcessResponse verifyResponse = connector.authorizeTransaction(verifyReq);

		LOGGER.info("<< Verify response: {}", verifyResponse);
		
		if (ResponseCode.OK.name().equals(verifyResponse.getResponseCode())) {
			//Check if we have card to store
			storeCardToken(verifyResponse.getTransactionId(), order.getConsumer(),verifyReq.getMerchantId());
			
			// Mark order as succesful tokenization
			orderservice.finalizeOrder(paymentId, PaymentState.CARD_TOKENIZED);

			return verifyResponse;
		}
		// Failure occurred

		// Mark order as cancelled
		orderservice.finalizeOrder(paymentId, PaymentState.CANCELLED);

		return verifyResponse;
	}
	
	/**
	 * Store card token.
	 * 
	 * This is only possible when there is an identifyable consumer to store to.
	 * 
	 * Retrieve the card token from Netaxept by querying the transaction.
	 * If storage is selected, the token is stored to the DB, to the consumer profile.
	 * 
	 * @param transactionId the transaction id
	 * @param consumer the consumer
	 */
	private void storeCardToken(String transactionId, Consumer consumer, Optional<String> merchantId) {
		if(consumer != null){
			PaymentQueryResponse queryResponse = connector.queryTransaction(transactionId, merchantId);
			CardToken token = queryResponse.getToken();
			if(shouldStoreToken(token, consumer)){
				LOGGER.info("Storing card {} to consumer: {} ({})", token.getName(), consumer.getConsumerId(), consumer.getName());
				token.setConsumer(consumer);
				consumer.addCardToken(token);
				persistenceService.save(consumer);
			}
		}
	}
	
	private Order getOrderIfCorrectState(String paymentId) throws BusinessServiceException {
		Order order = persistenceService.findOrderByTransactionId(paymentId);
		if (order == null) {
			// Order does not exist, return error
			LOGGER.info("Order for payment " + paymentId + " does not exist");
			throw new BusinessServiceException("Order does not exist", new Exception());
		} else if (!PaymentState.INITIALIZED.equals(order.getPaymentState())) {
			//  Check that order is in correct state
			LOGGER.info("Order " + paymentId + " is not in processable state");
			throw new BusinessServiceException("Order not in processable state", new Exception());
		}
		
		return order;
	}
	
	/**
	 * Checks if the token should be stored.
	 * 
	 * If the token represents a card already stored this will NOT be overwritten.
	 * 
	 * @param token the token
	 * @param consumer the consumer
	 * @return true, if token is to be stored
	 */
	private static boolean shouldStoreToken(CardToken token, Consumer consumer){
		if(token == null){
			return false;
		}
		Optional<CardToken> oldToken = consumer.getCardTokens().stream().filter(tok -> tok.getName().equals(token.getName())).findFirst();
		return !oldToken.isPresent();
	}

	/* (non-Javadoc)
	 * @see eu.nets.ms.pia.business.logic.PaymentService#deletePayment(java.lang.String)
	 */
	@Override
	public void deletePayment(String paymentId, String merchantId) {

	}

	private Order createOrderFromRequest(PaymentRegisterRequest request, String transactionId) {
		Order order = new Order();
		Amount amount = new Amount();

		amount.setCurrencyCode(request.getAmount().getCurrencyCode());
		amount.setTotalAmount(request.getAmount().getTotalAmount());
		amount.setVatAmount(request.getAmount().getVatAmount());

		order.setTimeStampNow();
		order.setAmount(amount);
		order.setConsumer(persistenceService.findConsumer(request.getCustomerId()));
		order.setPspTransactionid(transactionId);
		order.setPaymentState(PaymentState.INITIALIZED);
		return order;
	}

}