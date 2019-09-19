package eu.nets.ms.pia.service.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import eu.nets.ms.pia.service.model.PaymentMethods;
import eu.nets.ms.pia.service.model.PaymentProcessResponse;
import eu.nets.ms.pia.service.model.PaymentRegisterRequest;
import eu.nets.ms.pia.service.model.PaymentRegisterResponse;
import eu.nets.ms.pia.service.model.ProcessingError;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@Api(value = "callback")
@Path("callback")
public interface CallbackRESTService {
    static final String API_VERSION="2.0";
    
    
    @Path("/status/{token}")
    @Consumes({ MediaType.APPLICATION_JSON})
    @POST 
    @ApiOperation(value = "Status update end point")
    @ApiResponses(value = { 
    		@ApiResponse(code = 200, message = "Status update processed"),
    		@ApiResponse(code = 404, message = ""),
            @ApiResponse(code = 500, message = "Error processing the request. Try again later.")
    		})
    public Response onStatusChange(@ApiParam(value = "Status change event", required = true)NetaxeptStatusChangeEvent statusChangeEvent, @PathParam("token") String token, @Context HttpServletRequest httpServletRequest);
   
    }
