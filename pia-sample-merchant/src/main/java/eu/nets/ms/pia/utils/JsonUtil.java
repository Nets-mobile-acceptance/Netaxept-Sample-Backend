package eu.nets.ms.pia.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonUtil {
    private static final ObjectMapper MAPPER;
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

    static {
        MAPPER = new ObjectMapper();
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        MAPPER.registerModule(new JavaTimeModule());
        MAPPER.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
    
    private JsonUtil(){
    	throw new AssertionError();
    }

    public static ObjectMapper getJsonMapper() {
        return MAPPER;
    }

	public static String writeObjAsString(Object obj) {
		try {
			return getJsonMapper().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			LOGGER.error("Unable to write object",e);
			return e.getMessage();
		}
	}
}
