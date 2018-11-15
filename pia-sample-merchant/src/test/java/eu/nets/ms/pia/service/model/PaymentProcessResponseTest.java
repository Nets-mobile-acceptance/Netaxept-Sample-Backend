package eu.nets.ms.pia.service.model;

import javax.validation.ConstraintViolationException;
import javax.xml.datatype.DatatypeConfigurationException;

import org.junit.Test;

import eu.nets.ms.pia.testutils.Utils;

public class PaymentProcessResponseTest {

	@Test
	public void shouldCreateOKProcessResponse() throws DatatypeConfigurationException {
		PaymentProcessResponse.newBuilder()
		.operation(Operation.AUTHORIZE)
		.transactionId("aa80df20441e42eeaaff76e898c0c7bb")
   		.authorizationId("131377")
   		.executionTimestamp(Utils.getXMLGregorianCalendar("2018-04-03T20:58:08.9567916+02:00"))
   		.batch("559")
   		.responseCode("OK")
   		.responseSource(null)
   		.responseText(null)
   		.build();
	}
	
	@Test(expected=ConstraintViolationException.class)
	public void shouldShouldFailOnMissingAuthId() throws DatatypeConfigurationException {
		PaymentProcessResponse.newBuilder()
		.operation(Operation.AUTHORIZE)
		.transactionId("aa80df20441e42eeaaff76e898c0c7bb")
   		.executionTimestamp(Utils.getXMLGregorianCalendar("2018-04-03T20:58:08.9567916+02:00"))
   		.batch("559")
   		.responseCode("OK")
   		.responseSource(null)
   		.responseText(null)
   		.build();
	}
	@Test
	public void shouldAcceptMissingAuthId() throws DatatypeConfigurationException {
		PaymentProcessResponse.newBuilder()
		.operation(Operation.COMMIT)
		.transactionId("aa80df20441e42eeaaff76e898c0c7bb")
   		.executionTimestamp(Utils.getXMLGregorianCalendar("2018-04-03T20:58:08.9567916+02:00"))
   		.batch("559")
   		.responseCode("OK")
   		.responseSource(null)
   		.responseText(null)
   		.build();
	}

	
}
