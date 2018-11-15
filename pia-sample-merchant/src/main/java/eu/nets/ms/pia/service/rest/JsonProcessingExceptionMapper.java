package eu.nets.ms.pia.service.rest;


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.core.JsonProcessingException;

import eu.nets.ms.pia.service.model.ProcessingError;

@Provider
public class JsonProcessingExceptionMapper implements ExceptionMapper<JsonProcessingException> {

    @Override
    public Response toResponse(JsonProcessingException exception) {
        ProcessingError error = ProcessingError.newBuilder()
        							.explanationText("JsonProcessingError")
        							.addMessage(exception.getMessage())
        							.build();
        return ResponseUtils.createResponse(HttpStatus.BAD_REQUEST.value(), error);
    }
}
