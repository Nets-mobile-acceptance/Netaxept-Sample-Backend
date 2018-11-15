package eu.nets.ms.pia.dto;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;

import eu.nets.ms.pia.service.model.Amount;

public class AmountTest {

	@Test
	public void shouldSerializeAndDeserialize() throws IOException {
		Amount amount = Amount.newBuilder()
							.currencyCode("SEKA")
							.totalAmount(10000L)
							.vatAmount(0L)
							.build();
		
		ObjectMapper mapper = new ObjectMapper();
        String serializedDto = mapper.writeValueAsString(amount);
        Amount amount2 = mapper.readValue(serializedDto, Amount.class);
        assertThat(amount, equalTo(amount2));
   }

}
