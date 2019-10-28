package eu.nets.ms.pia.integration.nets.netaxept;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.util.HashMap;
import java.util.Optional;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.contrib.java.lang.system.EnvironmentVariables;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import eu.nets.ms.pia.business.domain.PaymentQueryResponse;
import eu.nets.ms.pia.business.sync.SyncServiceImpl;
import eu.nets.ms.pia.integration.PspConnector;
import eu.nets.ms.pia.service.model.Amount;
import eu.nets.ms.pia.service.model.Method;
import eu.nets.ms.pia.service.model.MethodEnum;
import eu.nets.ms.pia.service.model.PaymentRegisterRequest;
import eu.nets.ms.pia.service.model.PaymentRegisterResponse;


@RunWith(MockitoJUnitRunner.class)
public class NetAxeptConnectorTest {
	private static final String SERVICE_PORT_VALUE = "443";
	private static final String SERVICE_PORT_NAME = "NETAXEPT_PORT";
	private static final String SERVICE_HOST_NAME = "NETAXEPT_HOST";
	private static final String SERVICE_HOST_VALUE = "test.epayment.nets.eu";
	
	private static boolean once = false;
	
	@ClassRule
	public static EnvironmentVariables environmentVariables = new EnvironmentVariables();
	
	@Spy
	private static SyncServiceImpl syncService = new SyncServiceImpl();
	
	@Spy
	private NetAxeptConfig config = new NetAxeptConfig();
	
	@InjectMocks
	private PspConnector connector = new NetAxeptSOAPConnector();
	
	@BeforeClass
	public static void setEnv(){
		environmentVariables.set(SERVICE_PORT_NAME, SERVICE_PORT_VALUE);
		environmentVariables.set(SERVICE_HOST_NAME, SERVICE_HOST_VALUE);
	}
	
	@Before
	public void setup(){
		if(!once){
			syncService.init();
			once=true;
		}
		ReflectionTestUtils.setField(config, "secretsPath", "./etc/secrets/");
		ReflectionTestUtils.setField(config, "cancelUrl", "https://cancel");
		ReflectionTestUtils.setField(config, "redirectUrl", "https://redirect");
		ReflectionTestUtils.setField(config, "timeout", 2000);
		config.init();
	}
	@Test
	public void shouldRegisterTransactionOK() {
		PaymentRegisterResponse response = connector.registerTransaction(createValidRegisterRequest(), new HashMap<String, String>());
		assertThat(response, is(notNullValue()));
		System.out.println("Sucessfully invoked web service. response="+response.getTransactionId());
	}
	
	@Ignore
	@Test
	public void shouldRegisterSwishTransactionOK() {
		PaymentRegisterResponse response = connector.registerTransaction(createValidRegisterSwishRequest(), new HashMap<String, String>());
		assertThat(response, is(notNullValue()));
		System.out.println("Sucessfully invoked web service. response="+response.getTransactionId());
	}
	
	@Ignore
	@Test
	public void shouldRegisterVippsTransactionOK() {
		PaymentRegisterResponse response = connector.registerTransaction(createValidRegisterVippsRequest(), new HashMap<String, String>());
		assertThat(response, is(notNullValue()));
		System.out.println("Sucessfully invoked web service. response="+response.getTransactionId());
	}
	
	@Ignore
	@Test
	public void shouldRetrieveStatusOK() {
		PaymentRegisterResponse response = connector.registerTransaction(createValidRegisterRequest(),new HashMap<String, String>());
		assertThat(response, is(notNullValue()));
		PaymentQueryResponse queryResponse = connector.queryTransaction(response.getTransactionId(), Optional.ofNullable(null));
		assertThat(queryResponse, is(notNullValue()));
	}
	
	private static PaymentRegisterRequest.Builder createValidRegisterRequestBuilder(){
		return PaymentRegisterRequest.newBuilder()
				.amount(Amount.newBuilder()
						.currencyCode("SEK")
						.totalAmount(10000L)
						.vatAmount(2500L)
						.build())
				.orderNumber("1234567890");
	}
	
	private static PaymentRegisterRequest createValidRegisterSwishRequest(){
		return createValidRegisterRequestBuilder()
				.method(new Method.Builder()
						.id(MethodEnum.SWISH.getId())
						.build())
				.customerId("+46707999443")
				.amount(Amount.newBuilder()
						.currencyCode("SEK")
						.totalAmount(100L)
						.vatAmount(25L)
						.build())
				.build();
	}
	private static PaymentRegisterRequest createValidRegisterVippsRequest(){
		return createValidRegisterRequestBuilder()
				.method(new Method.Builder()
						.id(MethodEnum.VIPPS.getId())
						.build())
				.customerId("+4722898517")
				.amount(Amount.newBuilder()
						.currencyCode("NOK")
						.totalAmount(100L)
						.vatAmount(25L)
						.build())
				.build();
	}
	
	private static PaymentRegisterRequest createValidRegisterRequest(){
		return createValidRegisterRequestBuilder()
				.build();
	}

}
