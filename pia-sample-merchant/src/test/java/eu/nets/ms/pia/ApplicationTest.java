package eu.nets.ms.pia;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.EnvironmentVariables;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import eu.nets.ms.pia.integration.nets.netaxept.NetAxeptConfig;

@RunWith(SpringRunner.class)
@ActiveProfiles("default")
@SpringBootTest
public class ApplicationTest {
	private static final String SERVICE_PORT_VALUE = "443";
	private static final String SERVICE_PORT_NAME = "NETAXEPT_PORT";
	private static final String SERVICE_HOST_NAME = "NETAXEPT_HOST";
	private static final String SERVICE_HOST_VALUE = "test.epayment.nets.eu";
	
	@ClassRule
	public static TemporaryFolder folder = new TemporaryFolder();
	
	@ClassRule
	public static EnvironmentVariables environmentVariables = new EnvironmentVariables();
	
	@Inject
	NetAxeptConfig netaxeptConfig;
	
	@BeforeClass
	public static void setup() throws IOException{
		environmentVariables.set(SERVICE_PORT_NAME, SERVICE_PORT_VALUE);
		environmentVariables.set(SERVICE_HOST_NAME, SERVICE_HOST_VALUE);
		
		//Copy the secrets resource to a temp file and override the secrets path to refer to this temp file 
		ClassLoader classLoader = ApplicationTest.class.getClassLoader();
		File source = new File(classLoader.getResource("secrets.properties").getFile());
		
		File dest = folder.newFile("secrets.properties");
		FileUtils.copyFile(source, dest);
		environmentVariables.set("secrets.path", folder.getRoot().getAbsolutePath());
	}
	
	
	@Test
	public void shouldLoadNetaxeptConfiguration() {
		assertThat(netaxeptConfig, is(notNullValue()));
		
		//Secrets 
		assertThat(netaxeptConfig.getPassword(), is(equalTo("TestPassword")));
		assertThat(netaxeptConfig.getUserName(), is(equalTo("TestUserName")));
		assertThat(netaxeptConfig.getToken(), is(equalTo("TestToken")));
		
		//Config params
		assertThat(netaxeptConfig.getTimeout(), is(equalTo(2000)));
		assertThat(netaxeptConfig.getRedirectUrl(), is(equalTo("http://localhost/redirect.php")));
		assertThat(netaxeptConfig.getCancelUrl(), is(equalTo("http://localhost/cancel.php")));
		assertThat(netaxeptConfig.getTerminalUrl(), is(equalTo("http://localhost/terminal.php")));		
		assertThat(netaxeptConfig.getTerminalPaymentMethods(), is(equalTo("Visa,MasterCard")));
		assertThat(netaxeptConfig.isForce3Dsecure(), is(equalTo(false)));
		assertThat(netaxeptConfig.isSubsequent3Dsecure(), is(equalTo(true)));
		
	}

}
