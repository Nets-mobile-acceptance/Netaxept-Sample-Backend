package eu.nets.ms.pia.testutils;

import org.junit.contrib.java.lang.system.EnvironmentVariables;

public class EnvTestHelper {
	private static final String SERVICE_PORT_VALUE = "443";
	private static final String SERVICE_PORT_NAME = "NETAXEPT_PORT";
	private static final String SERVICE_HOST_NAME = "NETAXEPT_HOST";
	private static final String SERVICE_HOST_VALUE = "test.epayment.nets.eu";
	
	
	public static void setEnv(EnvironmentVariables environmentVariables){
		environmentVariables.set(SERVICE_PORT_NAME, SERVICE_PORT_VALUE);
		environmentVariables.set(SERVICE_HOST_NAME, SERVICE_HOST_VALUE);
	}
}
