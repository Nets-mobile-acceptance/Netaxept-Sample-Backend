package eu.nets.ms.pia.business.logic.persistence;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import java.util.List;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.EnvironmentVariables;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import eu.nets.ms.pia.business.domain.Amount;
import eu.nets.ms.pia.business.domain.CardToken;
import eu.nets.ms.pia.business.domain.Consumer;
import eu.nets.ms.pia.business.domain.Order;
import eu.nets.ms.pia.business.domain.PaymentState;
import eu.nets.ms.pia.testutils.EnvTestHelper;

@RunWith(SpringRunner.class)
@ActiveProfiles("default")
@SpringBootTest
@ContextConfiguration(classes = {PersistenceTestConfig.class,})
public class PaymentPersistenceServiceTest {
	private static final String TOKEN_ID_1 = "123456xxxxxx1111";
	private static final String CONSUMER1 = "111111";
	
	private int transactionIdSequence = 1;
	
	@ClassRule
	public static EnvironmentVariables environmentVariables = new EnvironmentVariables();
	
	
	@Inject
	PaymentPersistenceService persistence;
	
	
	@BeforeClass
	public static void setEnv(){
		EnvTestHelper.setEnv(environmentVariables);
	}
	
	@Before
	public void setup(){
		Consumer consumer1 = new Consumer();
		Consumer consumer2 = new Consumer();
		
		consumer1.setName("Consumer1");
		consumer1.setConsumerId(CONSUMER1);
		consumer2.setName("Consumer2");
		consumer2.setConsumerId("222222");
		persistence.save(consumer1);
		persistence.save(consumer2);
	}
	
	
	@Test
	public void shouldInjectService() {
		assertThat(persistence, is(not(nullValue())));
	}
	
	@Test
	public void shouldRetrieveConsumer() {
		Consumer consumer = persistence.findConsumer(CONSUMER1);
		assertThat(consumer, is(not(nullValue())));
		assertThat(consumer.getName(), is(equalTo("Consumer1")));
		assertThat(consumer.isRequiredCardVerificationSubsequent(), is(equalTo(true)));
	}
	
	@Test
	public void shouldSaveOrder() {
		Order order = createOrderFor(CONSUMER1);
		order.setPspTransactionid(generateTransactionId());
		order = persistence.save(order);
		
		Order savedOrder = persistence.findOrder(order.getOrderId());
		
		assertThat(savedOrder.getConsumer(), is(not(nullValue())));
		assertThat(savedOrder.getConsumer().getName(), is(equalTo("Consumer1")));
	}
	
	@Test
	public void shouldFindTwoOrdersForConsumer() {
		Order order1 = createOrderFor(CONSUMER1);
		Order order2 = createOrderFor(CONSUMER1);
		order1 = persistence.save(order1);
		order2 = persistence.save(order2);
		
		List<Order> orders = persistence.findOrdersForConsumer(CONSUMER1);
		
		assertThat(orders, hasSize(2));
	}
	
	@Test
	public void consumerShouldHaveNoTokens() {
		Consumer consumer = persistence.findConsumer(CONSUMER1);
		assertThat(consumer.getCardTokens().isEmpty(), is(true));
	}
	
	@Test
	public void shouldPersistTokenToConsumer() {
		Consumer consumer = persistence.findConsumer(CONSUMER1);
		CardToken token = new CardToken();
		token.setName(TOKEN_ID_1);
		token.setValue("ABCD010203EEFFAA");
		consumer.addCardToken(token);
		persistence.save(consumer);
		
		//Verify token saved
		Consumer savedConsumer = persistence.findConsumer(CONSUMER1);
		assertThat(savedConsumer.getCardTokens().iterator().next().getName(), is(equalTo(TOKEN_ID_1)));
		
		persistence.deleteToken(CONSUMER1, TOKEN_ID_1);
		//Verify token deleted
		Consumer consumer1 = persistence.findConsumer(CONSUMER1);
		assertThat(consumer1.getCardTokens().isEmpty(), is(true));
		
		
	}
	
	
	private Order createOrderFor(String consumerId){
		Order order = new Order();
		Amount amount = new Amount();
		
		amount.setCurrencyCode("EUR");
		amount.setTotalAmount(1000L);
		amount.setVatAmount(250L);
		
		order.setTimeStampNow();
		order.setAmount(amount);
		order.setConsumer(persistence.findConsumer(CONSUMER1));
		order.setPaymentState(PaymentState.INITIALIZED);
		order.setPspTransactionid(generateTransactionId());
		return order;
	}
	
	private String generateTransactionId(){
		return Integer.toString(transactionIdSequence++);
	}
	
	
	
}
