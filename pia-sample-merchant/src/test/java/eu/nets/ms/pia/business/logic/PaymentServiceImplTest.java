package eu.nets.ms.pia.business.logic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import eu.nets.ms.pia.business.domain.AdditionalData;
import eu.nets.ms.pia.business.domain.CardToken;
import eu.nets.ms.pia.business.domain.Consumer;
import eu.nets.ms.pia.business.domain.Order;
import eu.nets.ms.pia.business.domain.PaymentQueryResponse;
import eu.nets.ms.pia.business.domain.PaymentState;
import eu.nets.ms.pia.business.logic.persistence.PaymentPersistenceService;
import eu.nets.ms.pia.exception.BusinessServiceException;
import eu.nets.ms.pia.integration.PspConnector;
import eu.nets.ms.pia.service.model.Amount;
import eu.nets.ms.pia.service.model.Method;
import eu.nets.ms.pia.service.model.MethodEnum;
import eu.nets.ms.pia.service.model.Operation;
import eu.nets.ms.pia.service.model.PaymentMethods;
import eu.nets.ms.pia.service.model.PaymentProcessRequest;
import eu.nets.ms.pia.service.model.PaymentProcessResponse;
import eu.nets.ms.pia.service.model.PaymentRegisterRequest;
import eu.nets.ms.pia.service.model.PaymentRegisterResponse;

@RunWith(MockitoJUnitRunner.class)
public class PaymentServiceImplTest {
	
	private static final String TOKEN_VALUE = "UnVuIFRvIHRoZSBoaWxscy4uLi4=";
	private static final String TOKEN_NAME = "123456XXXXXX0000";
	private static final String TEST_CONSUMER_WITH_TOKEN = "000001";
	private static final String TEST_CONSUMER_WITHOUT_TOKEN = "000002";
	private static final String TEST_INVALID_PAYMENT_ID = "1234567890abcdef";
	private static final String TEST_FAKED_OK_TRANSACTION_ID = "1234567890aabbcc";
	private static final String TEST_FAKED_OK_TRANSACTION_ID_WITH_TOKEN = "1234567890aabbdd";
	
	@Mock
	private PaymentPersistenceService persistenceService;
	
	@Mock
	private PspConnector pspService;

	@Mock
	private OrderService orderService;
	
	@Captor
	ArgumentCaptor<PaymentRegisterRequest> registerCaptor;
	
	@Captor
	ArgumentCaptor<Map<String, String>> paramsCaptor;
	
	@InjectMocks
	PaymentService service = new PaymentServiceImpl();
	
	@Before
	public void setUp() throws Exception {
		when(persistenceService.findConsumer(TEST_CONSUMER_WITH_TOKEN)).thenReturn(createMockConsumerWithToken());
		when(persistenceService.findConsumer(TEST_CONSUMER_WITHOUT_TOKEN)).thenReturn(createMockConsumer(TEST_CONSUMER_WITHOUT_TOKEN));
		when(pspService.queryTransaction(TEST_FAKED_OK_TRANSACTION_ID, Optional.ofNullable(null))).thenReturn(PaymentQueryResponse.newBuilder().responseCode("OK").transactionId(TEST_FAKED_OK_TRANSACTION_ID).build());
		when(pspService.queryTransaction(TEST_FAKED_OK_TRANSACTION_ID_WITH_TOKEN, Optional.ofNullable(null))).thenReturn(PaymentQueryResponse.newBuilder()
				.responseCode("OK")
				.transactionId(TEST_FAKED_OK_TRANSACTION_ID_WITH_TOKEN)
				.withToken(createDummyToken())
				.build());
	}
	
	@Test
	public void shouldReturnVanillaPaymentMethodListForAnonymousConsumer() throws BusinessServiceException {
		PaymentMethods methods = service.getPaymentMethods(null);
		assertThat(methods.getMethods(), not(hasItem(PaymentServiceImpl.EASY_PAY)));
	}
	
	@Test
	public void shouldReturnVanillaPaymentMethodListForUnknownConsumer() throws BusinessServiceException {
		PaymentMethods methods = service.getPaymentMethods("UnKnownConsumer");
		assertThat(methods.getMethods(), not(hasItem(PaymentServiceImpl.EASY_PAY)));
	}
	
	@Test
	public void shouldReturnStoredCardAlternative() throws BusinessServiceException {
		PaymentMethods methods = service.getPaymentMethods(TEST_CONSUMER_WITH_TOKEN);
		assertThat(methods.getMethods(), hasItem(PaymentServiceImpl.EASY_PAY));
		assertThat(methods.getTokens(), is(not(empty())));
	}
	
	@Test
	public void shouldPassRegisterWithoutMethodSpec() throws BusinessServiceException {

		PaymentRegisterRequest req = createMockPaymentRegisterRequestForSuccessfulRegister();
		PaymentRegisterResponse resp = PaymentRegisterResponse.newBuilder().transactionId(TEST_FAKED_OK_TRANSACTION_ID).build();
	
		when(pspService.registerTransaction(registerCaptor.capture(), paramsCaptor.capture()))
			.thenReturn(resp);
	
		service.register(req, "test");
		Mockito.verify(orderService, Mockito.times(1)).prepareOrder(Mockito.any(Order.class));
		assertThat(paramsCaptor.getValue().containsKey(AdditionalData.CARD_TOKEN_VALUE), is(equalTo(false)));
	}
	@Test
	public void shouldPassRegisterWithACardSpecified() throws BusinessServiceException {

		PaymentRegisterRequest req = createMockPaymentRegisterRequestForSuccessfulRegister(MethodEnum.VISA);
		PaymentRegisterResponse resp = PaymentRegisterResponse.newBuilder().transactionId(TEST_FAKED_OK_TRANSACTION_ID).build();
	
		when(pspService.registerTransaction(registerCaptor.capture(), paramsCaptor.capture()))
			.thenReturn(resp);
	
		service.register(req, "test");
		Mockito.verify(orderService, Mockito.times(1)).prepareOrder(Mockito.any(Order.class));
		assertThat(paramsCaptor.getValue().containsKey(AdditionalData.CARD_TOKEN_VALUE), is(equalTo(false)));
	}
	@Test
	public void shouldPassRegisterWithStoredCard() throws BusinessServiceException {

		PaymentRegisterRequest req = createPaymentRegisterWithToken();
		PaymentRegisterResponse resp = PaymentRegisterResponse.newBuilder().transactionId(TEST_FAKED_OK_TRANSACTION_ID).build();
	
		when(pspService.registerTransaction(registerCaptor.capture(), paramsCaptor.capture()))
			.thenReturn(resp);
	
		service.register(req, "test");
		Mockito.verify(orderService, Mockito.times(1)).prepareOrder(Mockito.any(Order.class));
		assertThat(paramsCaptor.getValue().containsKey(AdditionalData.CARD_TOKEN_VALUE), is(equalTo(true)));
		assertThat(paramsCaptor.getValue().get(AdditionalData.CARD_TOKEN_VALUE), is(equalTo(TOKEN_VALUE)));
	}
	
	@Test(expected = BusinessServiceException.class)
	public void shouldThrowExceptionWhenWantedStoredCardIsMissing() throws BusinessServiceException {
		PaymentRegisterRequest req = createPaymentRegisterWithToken("BOGUS");
		service.register(req, "test");
	}

	
	@Test (expected = BusinessServiceException.class)
	public void shouldThrowOrderNotFound() throws BusinessServiceException {
		service.process(TEST_INVALID_PAYMENT_ID, null);	
	}
	
	@Test (expected = BusinessServiceException.class)
	public void shouldThrowOrderNotInCorrectState() throws BusinessServiceException {
		when(persistenceService.findOrderByTransactionId(TEST_FAKED_OK_TRANSACTION_ID))
			.thenReturn(createMockOkOrder(TEST_FAKED_OK_TRANSACTION_ID, PaymentState.PAID));
		
		service.process(TEST_FAKED_OK_TRANSACTION_ID, null);
	}
	
	@Test
	public void shouldFailInAuthPhase() throws BusinessServiceException {
		
		when(persistenceService.findOrderByTransactionId(TEST_FAKED_OK_TRANSACTION_ID))
			.thenReturn(createMockOkOrder(TEST_FAKED_OK_TRANSACTION_ID, PaymentState.INITIALIZED));
		
		PaymentProcessResponse resp = createMockPaymentResponseForFailingAuthProcess(TEST_FAKED_OK_TRANSACTION_ID);
		
		when(pspService.authorizeTransaction(Mockito.any(PaymentProcessRequest.class))).thenReturn(resp);
		
		service.process(TEST_FAKED_OK_TRANSACTION_ID, null);
		Mockito.verify(orderService, Mockito.times(1)).finalizeOrder(TEST_FAKED_OK_TRANSACTION_ID, PaymentState.CANCELLED);
	}

	@Test
	public void shouldFailInStoringOrder() throws BusinessServiceException {
		
		when(persistenceService.findOrderByTransactionId(TEST_FAKED_OK_TRANSACTION_ID))
			.thenReturn(createMockOkOrder(TEST_FAKED_OK_TRANSACTION_ID, PaymentState.INITIALIZED));
		
		PaymentProcessResponse resp = createMockPaymentResponseForOkAuthProcess(TEST_FAKED_OK_TRANSACTION_ID);
		
		when(pspService.authorizeTransaction(Mockito.any(PaymentProcessRequest.class))).thenReturn(resp);
		when(orderService.placeOrder(TEST_FAKED_OK_TRANSACTION_ID)).thenReturn(false);
		
		service.process(TEST_FAKED_OK_TRANSACTION_ID, null);
		Mockito.verify(orderService, Mockito.times(1)).finalizeOrder(TEST_FAKED_OK_TRANSACTION_ID, PaymentState.CANCELLED);
		Mockito.verify(pspService, Mockito.times(1)).finalizeTransaction(Mockito.any(PaymentProcessRequest.class));
	}	
	
	@Test
	public void verifyShouldFailInAuthPhase() throws BusinessServiceException {
		
		when(persistenceService.findOrderByTransactionId(TEST_FAKED_OK_TRANSACTION_ID))
			.thenReturn(createMockOkOrder(TEST_FAKED_OK_TRANSACTION_ID, PaymentState.INITIALIZED));
		
		PaymentProcessResponse resp = createMockPaymentResponseForFailingAuthProcess(TEST_FAKED_OK_TRANSACTION_ID);
		
		when(pspService.authorizeTransaction(Mockito.any(PaymentProcessRequest.class))).thenReturn(resp);
		
		service.verify(TEST_FAKED_OK_TRANSACTION_ID, null);
		Mockito.verify(orderService, Mockito.times(1)).finalizeOrder(TEST_FAKED_OK_TRANSACTION_ID, PaymentState.CANCELLED);
	}

	@Test
	public void verifyShouldPass() throws BusinessServiceException {
		
		when(persistenceService.findOrderByTransactionId(TEST_FAKED_OK_TRANSACTION_ID))
			.thenReturn(createMockOkOrder(TEST_FAKED_OK_TRANSACTION_ID, PaymentState.INITIALIZED));
		
		PaymentProcessResponse resp = createMockPaymentResponseForOkAuthProcess(TEST_FAKED_OK_TRANSACTION_ID);
		
		when(pspService.authorizeTransaction(Mockito.any(PaymentProcessRequest.class))).thenReturn(resp);
		
		service.verify(TEST_FAKED_OK_TRANSACTION_ID, null);
		Mockito.verify(orderService, Mockito.times(1)).finalizeOrder(TEST_FAKED_OK_TRANSACTION_ID, PaymentState.CARD_TOKENIZED);
	}
	
	@Test
	public void shouldFailInCapturePhase() throws BusinessServiceException {
		
		when(persistenceService.findOrderByTransactionId(TEST_FAKED_OK_TRANSACTION_ID))
			.thenReturn(createMockOkOrder(TEST_FAKED_OK_TRANSACTION_ID, PaymentState.INITIALIZED));
		
		PaymentProcessResponse resp = createMockPaymentResponseForOkAuthProcess(TEST_FAKED_OK_TRANSACTION_ID);
		PaymentProcessResponse respCapture = createMockPaymentResponseForFailingCaptureProcess(TEST_FAKED_OK_TRANSACTION_ID);
		
		when(pspService.authorizeTransaction(Mockito.any(PaymentProcessRequest.class))).thenReturn(resp);
		when(orderService.placeOrder(TEST_FAKED_OK_TRANSACTION_ID)).thenReturn(true);
		
		when(pspService.finalizeTransaction(Mockito.any(PaymentProcessRequest.class))).thenReturn(respCapture);
		
		service.process(TEST_FAKED_OK_TRANSACTION_ID, null);
		Mockito.verify(orderService, Mockito.times(1)).finalizeOrder(TEST_FAKED_OK_TRANSACTION_ID, PaymentState.CANCELLED);
		// two calls to finalize, once for failed commit and once for rollback
		Mockito.verify(pspService, Mockito.times(2)).finalizeTransaction(Mockito.any(PaymentProcessRequest.class));
	}
	
	@Test
	public void shouldSucceedOnPurchase() throws BusinessServiceException {
		
		when(persistenceService.findOrderByTransactionId(TEST_FAKED_OK_TRANSACTION_ID))
			.thenReturn(createMockOkOrder(TEST_FAKED_OK_TRANSACTION_ID, PaymentState.INITIALIZED));
		
		PaymentProcessResponse resp = createMockPaymentResponseForOkAuthProcess(TEST_FAKED_OK_TRANSACTION_ID);
		PaymentProcessResponse respCapture = createMockPaymentResponseForOkCommitProcess(TEST_FAKED_OK_TRANSACTION_ID);
		
		when(pspService.authorizeTransaction(Mockito.any(PaymentProcessRequest.class))).thenReturn(resp);
		when(orderService.placeOrder(TEST_FAKED_OK_TRANSACTION_ID)).thenReturn(true);
		
		when(pspService.finalizeTransaction(Mockito.any(PaymentProcessRequest.class))).thenReturn(respCapture);
		
		service.process(TEST_FAKED_OK_TRANSACTION_ID, null);
		Mockito.verify(persistenceService,Mockito.times(0)).save(Mockito.any(Consumer.class));
		Mockito.verify(orderService, Mockito.times(1)).finalizeOrder(TEST_FAKED_OK_TRANSACTION_ID, PaymentState.PAID);
		Mockito.verify(pspService, Mockito.times(1)).finalizeTransaction(Mockito.any(PaymentProcessRequest.class));
	}
	
	@Test
	public void shouldSucceedOnPurchaseWithTokenSave() throws BusinessServiceException {
		
		when(persistenceService.findOrderByTransactionId(TEST_FAKED_OK_TRANSACTION_ID_WITH_TOKEN))
			.thenReturn(createMockOkOrder(TEST_FAKED_OK_TRANSACTION_ID_WITH_TOKEN, PaymentState.INITIALIZED));
		
		PaymentProcessResponse resp = createMockPaymentResponseForOkAuthProcess(TEST_FAKED_OK_TRANSACTION_ID_WITH_TOKEN);
		PaymentProcessResponse respCapture = createMockPaymentResponseForOkCommitProcess(TEST_FAKED_OK_TRANSACTION_ID_WITH_TOKEN);
		
		when(pspService.authorizeTransaction(Mockito.any(PaymentProcessRequest.class))).thenReturn(resp);
		when(orderService.placeOrder(TEST_FAKED_OK_TRANSACTION_ID_WITH_TOKEN)).thenReturn(true);
		
		when(pspService.finalizeTransaction(Mockito.any(PaymentProcessRequest.class))).thenReturn(respCapture);
		
		service.process(TEST_FAKED_OK_TRANSACTION_ID_WITH_TOKEN, null);
		Mockito.verify(persistenceService,Mockito.times(1)).save(Mockito.any(Consumer.class));
		Mockito.verify(orderService, Mockito.times(1)).finalizeOrder(TEST_FAKED_OK_TRANSACTION_ID_WITH_TOKEN, PaymentState.PAID);
		Mockito.verify(pspService, Mockito.times(1)).finalizeTransaction(Mockito.any(PaymentProcessRequest.class));
	}
	@Test
	public void shouldSucceedOnPurchaseWithTokenReSave() throws BusinessServiceException {
		
		when(persistenceService.findOrderByTransactionId(TEST_FAKED_OK_TRANSACTION_ID_WITH_TOKEN))
			.thenReturn(createMockOkOrderRecurringCustomer(TEST_FAKED_OK_TRANSACTION_ID_WITH_TOKEN, PaymentState.INITIALIZED));
		
		PaymentProcessResponse resp = createMockPaymentResponseForOkAuthProcess(TEST_FAKED_OK_TRANSACTION_ID_WITH_TOKEN);
		PaymentProcessResponse respCapture = createMockPaymentResponseForOkCommitProcess(TEST_FAKED_OK_TRANSACTION_ID_WITH_TOKEN);
		
		when(pspService.authorizeTransaction(Mockito.any(PaymentProcessRequest.class))).thenReturn(resp);
		when(orderService.placeOrder(TEST_FAKED_OK_TRANSACTION_ID_WITH_TOKEN)).thenReturn(true);
		
		when(pspService.finalizeTransaction(Mockito.any(PaymentProcessRequest.class))).thenReturn(respCapture);
		
		service.process(TEST_FAKED_OK_TRANSACTION_ID_WITH_TOKEN, null);
		Mockito.verify(persistenceService,Mockito.times(0)).save(Mockito.any(Consumer.class));
		Mockito.verify(orderService, Mockito.times(1)).finalizeOrder(TEST_FAKED_OK_TRANSACTION_ID_WITH_TOKEN, PaymentState.PAID);
		Mockito.verify(pspService, Mockito.times(1)).finalizeTransaction(Mockito.any(PaymentProcessRequest.class));
	}
	
	@Test
	public void shouldNotReturnStoredCardAlternativeSinNoneIsStored() {
		
	}
	
	private static Consumer createMockConsumer(String consumerId) {
		Consumer consumer = new Consumer();
		consumer.setConsumerId(consumerId);
		consumer.setName("Name_"+consumerId);
		return consumer;
	}

	private static Consumer createMockConsumerWithToken() {
		Consumer consumer = createMockConsumer(TEST_CONSUMER_WITH_TOKEN);
		consumer.addCardToken(createDummyToken());
		return consumer;
	}

	private static CardToken createDummyToken() {
		CardToken token = new CardToken();
		token.setName(TOKEN_NAME);
		token.setIssuer("Visa");
		token.setValue(TOKEN_VALUE);
		token.setExpiryDate("11/20");
		return token;
	}
	
	private static PaymentRegisterRequest createMockPaymentRegisterRequestForSuccessfulRegister() {
		return createMockPaymentRegisterRequestForSuccessfulRegister(null);
	}
	private static PaymentRegisterRequest createMockPaymentRegisterRequestForSuccessfulRegister(MethodEnum method) {
		return PaymentRegisterRequest.newBuilder()
				.customerId("001")
				.orderNumber(TEST_FAKED_OK_TRANSACTION_ID)
				.method(method == null ? null : new Method(method))
				.amount(Amount.newBuilder()
						.currencyCode("EUR")
						.totalAmount(100L)
						.build())
				.cardId("testCard")
				.storeCard(false)
				.build();
	}
	
	private static PaymentRegisterRequest createPaymentRegisterWithToken() {
		return createPaymentRegisterWithToken(TOKEN_NAME);
	}
	private static PaymentRegisterRequest createPaymentRegisterWithToken(String tokenName) {
		return PaymentRegisterRequest.newBuilder()
			.customerId(TEST_CONSUMER_WITH_TOKEN)
			.amount(Amount.newBuilder()
					.currencyCode("EUR")
					.totalAmount(100L)
					.build())
			.orderNumber(TEST_FAKED_OK_TRANSACTION_ID_WITH_TOKEN)
			.method(new Method(MethodEnum.EASY_PAY))
			.cardId(tokenName)
			.storeCard(false)
			.build();
	}
	
	private static PaymentProcessResponse createMockPaymentResponseForFailingAuthProcess(String transactionid) {
		return PaymentProcessResponse.newBuilder()
				.authorizationId(null)
				.operation(Operation.AUTHORIZE)
				.responseCode("ERROR")
				.responseText("ERROR")
				.executionTimestamp(LocalDateTime.now())
				.authorizationId("123")
				.transactionId(transactionid)
				.build();
	}
	
	private static PaymentProcessResponse createMockPaymentResponseForFailingCaptureProcess(String transactionid) {
		return PaymentProcessResponse.newBuilder()
				.authorizationId(null)
				.operation(Operation.COMMIT)
				.responseCode("ERROR")
				.responseText("ERROR")
				.executionTimestamp(LocalDateTime.now())
				.authorizationId("123")
				.transactionId(transactionid)
				.build();
	}
	
	private PaymentProcessResponse createMockPaymentResponseForOkAuthProcess(String transactionid) {
		return PaymentProcessResponse.newBuilder()
				.authorizationId(null)
				.operation(Operation.AUTHORIZE)
				.responseCode("OK")
				.responseText("OK")
				.executionTimestamp(LocalDateTime.now())
				.authorizationId("123")
				.transactionId(transactionid)
				.build();
	}	
	
	private static PaymentProcessResponse createMockPaymentResponseForOkCommitProcess(String transactionid) {
		return PaymentProcessResponse.newBuilder()
				.authorizationId(null)
				.operation(Operation.COMMIT)
				.responseCode("OK")
				.responseText("OK")
				.executionTimestamp(LocalDateTime.now())
				.authorizationId("123")
				.transactionId(transactionid)
				.build();
	}	
	
	private static Order createMockOkOrder(String paymentId, PaymentState state) {	
		Order ord = new Order();
		ord.setPspTransactionid(paymentId);
		ord.setPaymentState(state);
		ord.setConsumer(createMockConsumer(TEST_CONSUMER_WITHOUT_TOKEN));
		ord.setOrderId(1L);	
		return ord;
	}
	private static Order createMockOkOrderRecurringCustomer(String paymentId, PaymentState state) {	
		Order ord = new Order();
		ord.setPspTransactionid(paymentId);
		ord.setPaymentState(state);
		ord.setConsumer(createMockConsumerWithToken());
		ord.setOrderId(1L);	
		return ord;
	}
	
}
