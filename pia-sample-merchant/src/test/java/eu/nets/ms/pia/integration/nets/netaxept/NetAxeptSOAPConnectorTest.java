package eu.nets.ms.pia.integration.nets.netaxept;

import static eu.nets.ms.pia.service.model.Operation.AUTHORIZE;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

import java.util.Optional;

import javax.xml.datatype.DatatypeConfigurationException;

import org.datacontract.schemas._2004._07.bbs_epayment.ProcessResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import epayment.bbs.INetaxept;
import epayment.bbs.INetaxeptProcessAuthenticationExceptionFaultFaultMessage;
import epayment.bbs.INetaxeptProcessBBSExceptionFaultFaultMessage;
import epayment.bbs.INetaxeptProcessGenericErrorFaultFaultMessage;
import epayment.bbs.INetaxeptProcessMerchantTranslationExceptionFaultFaultMessage;
import epayment.bbs.INetaxeptProcessNotSupportedExceptionFaultFaultMessage;
import epayment.bbs.INetaxeptProcessValidationExceptionFaultFaultMessage;
import eu.nets.ms.pia.integration.PspConnector;
import eu.nets.ms.pia.service.model.PaymentProcessRequest;
import eu.nets.ms.pia.service.model.PaymentProcessResponse;
import eu.nets.ms.pia.testutils.Utils;


@RunWith(MockitoJUnitRunner.class)
public class NetAxeptSOAPConnectorTest {
	
	@Mock
	private INetaxept netaxept;
	
	@Mock
	NetAxeptConfig config = new NetAxeptConfig();
	
	@InjectMocks
	@Spy
	private PspConnector connector = new NetAxeptSOAPConnector();
	
	@Before
	public void setup(){
		when(config.getCancelUrl()).thenReturn("https://cancel");
		when(config.getRedirectUrl()).thenReturn("https://redirect");
		when(config.getTimeout()).thenReturn(2000);
		when(config.getUserName()).thenReturn("DUMMY_USER");
		when(config.getPassword()).thenReturn("DUMMY_PASSWORD");
		when(config.getToken()).thenReturn("DUMMY_TOKEN");
		//Override the createEndpoint, returning a mock object.
		doAnswer(new Answer<Object>(){
			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				return netaxept;
			}     	
        }).when((NetAxeptSOAPConnector)connector).createEndPoint(any());
		
	}
	
	@Test
	public void shouldProcessTransactionOK() throws INetaxeptProcessValidationExceptionFaultFaultMessage, INetaxeptProcessAuthenticationExceptionFaultFaultMessage, INetaxeptProcessGenericErrorFaultFaultMessage, INetaxeptProcessMerchantTranslationExceptionFaultFaultMessage, INetaxeptProcessNotSupportedExceptionFaultFaultMessage, INetaxeptProcessBBSExceptionFaultFaultMessage, DatatypeConfigurationException {
		when(netaxept.process(Mockito.any())).thenReturn(okProcessResponse());
		PaymentProcessResponse resp = connector.finalizeTransaction(createOkRequest());
		assertThat(resp.getResponseCode(), equalTo("OK"));
		
	}
	@Test
	public void shouldProvideValidationErrorMessage() throws INetaxeptProcessValidationExceptionFaultFaultMessage, INetaxeptProcessAuthenticationExceptionFaultFaultMessage, INetaxeptProcessGenericErrorFaultFaultMessage, INetaxeptProcessMerchantTranslationExceptionFaultFaultMessage, INetaxeptProcessNotSupportedExceptionFaultFaultMessage, INetaxeptProcessBBSExceptionFaultFaultMessage, DatatypeConfigurationException {
		when(netaxept.process(Mockito.any())).thenReturn(respWithFaultyResponseCode());
		try {
			connector.finalizeTransaction(createOkRequest());
		} catch (Exception e) {
			assertThat(e.getMessage(), equalTo("Response code must be alfa numeric"));
		}	
	}
	
	private static PaymentProcessRequest createOkRequest(){
		return PaymentProcessRequest.newBuilder()
				.operation(AUTHORIZE)
				.transactionId("12312343454")
				.description("Some description")
				.transactionReference("666")
				.build();
	}
	private static epayment.bbs.ProcessResponse respWithFaultyResponseCode() throws DatatypeConfigurationException{
		epayment.bbs.ProcessResponse resp = okProcessResponse();
		resp.getProcessResult().setResponseCode("-1");
		return resp;
	}
	private static epayment.bbs.ProcessResponse okProcessResponse() throws DatatypeConfigurationException{
		epayment.bbs.ProcessResponse resp = new epayment.bbs.ProcessResponse();
		
		ProcessResponse schemaResp = new ProcessResponse();	
		resp.setProcessResult(schemaResp);
		schemaResp.setAuthorizationId("131377");
		schemaResp.setBatchNumber("559");
		schemaResp.setMerchantId("000000");
		schemaResp.setOperation("AUTH");
		schemaResp.setResponseCode("OK");
		schemaResp.setTransactionId("aa80df20441e42eeaaff76e898c0c7bb");
		schemaResp.setExecutionTime(Utils.getXMLGregorianCalendar("2018-04-03T20:58:08.9567916+02:00"));
		return resp;
	}

}
