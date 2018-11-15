package eu.nets.ms.pia.business.logic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import javax.inject.Inject;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.EnvironmentVariables;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import eu.nets.ms.pia.business.logic.persistence.PaymentPersistenceService;
import eu.nets.ms.pia.business.logic.persistence.PersistenceTestConfig;
import eu.nets.ms.pia.testutils.EnvTestHelper;

@RunWith(SpringRunner.class)
@ActiveProfiles("default")
@SpringBootTest
@ContextConfiguration(classes = {PersistenceTestConfig.class,})
public class OrderServiceImplTest {
	
	@Inject
	private OrderService orderService;
	
	@ClassRule
	public static EnvironmentVariables environmentVariables = new EnvironmentVariables();
	
	
	@Inject
	PaymentPersistenceService persistence;
	
	@BeforeClass
	public static void setEnv(){
		EnvTestHelper.setEnv(environmentVariables);
	}
	
	
	@Test
	public void shouldRejectPlacingOrderWhenForceAnnulIsTrue() {
		assertThat(orderService.placeOrder("123456"), is(equalTo(false)));
	}
	
	

}
