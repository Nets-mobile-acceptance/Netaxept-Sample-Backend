package eu.nets.ms.pia.service.rest;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

public class ResponseUtils {
	private ResponseUtils(){
        throw new AssertionError();
    }
	
	public static Response createResponse(int status) {
    	return createResponse(status, null, null);
    }
	public static Response createResponse(int status, Object entity) {
    	return createResponse(status, entity, null);
    }
    public static Response createResponse(int status, Object entity, List<Header> headers) {
        ResponseBuilder builder = Response.status(status);
        
        if (headers != null) {
            for (Header header : headers) {
                builder.header(header.getName(), header.getValue());
            }
        }
        if(entity == null){
        	return builder.build();
        }else{
        	return builder.entity(entity).build();
        }
    }
    
    public static class Header {
        private final String name;
        private final Object value;

        public Header(String name, Object value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public Object getValue() {
            return value;
        }
    }
}
