package eu.nets.ms.pia.service.rest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import eu.nets.ms.pia.utils.JsonUtil;

public class NetaxeptStatusChangeEventTest {

	@Test
	public void shouldDeserializeObject() throws JsonParseException, JsonMappingException, IOException {
		String transactionId = "19a2540f-89c9-43bc-b8c4-870712789b5d";
		String json = "{\"TransactionId\":\""+transactionId+"\"}";
		
		NetaxeptStatusChangeEvent object = JsonUtil.getJsonMapper().readValue(json, NetaxeptStatusChangeEvent.class);
		assertThat(object.getTransactionId(), is(equalTo(transactionId)));
		
		
	}

}
