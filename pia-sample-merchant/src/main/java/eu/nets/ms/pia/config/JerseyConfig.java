package eu.nets.ms.pia.config;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import eu.nets.ms.pia.service.rest.JsonProcessingExceptionMapper;
import eu.nets.ms.pia.service.rest.MerchantPaymentRESTService;
import eu.nets.ms.pia.service.rest.MerchantPaymentRESTServiceImpl;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

@Configuration
@Component
@ApplicationPath("/pia/merchantdemo/v1")
public class JerseyConfig extends ResourceConfig {
	private static final String LOGGER_ID = "serviceLogger";
	private static final int MAX_ENTITY_SIZE = 3000;
    public JerseyConfig() {
        registerEndpoints();
        configureSwagger();
    }

    private void registerEndpoints() {
    	register(MerchantPaymentRESTServiceImpl.class);
    	register(JsonProcessingExceptionMapper.class);
    	register(WadlResource.class);
    	register(new LoggingFeature(Logger.getLogger(LOGGER_ID), Level.FINE, LoggingFeature.Verbosity.PAYLOAD_ANY, MAX_ENTITY_SIZE));
    }
    
    private void configureSwagger() {
    	
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/pia/merchantdemo/v1");
        beanConfig.setVersion(MerchantPaymentRESTService.API_VERSION);
        beanConfig.setTitle("Merchant backend demo");
        beanConfig.setResourcePackage(MerchantPaymentRESTService.class.getPackage().getName());
        beanConfig.setPrettyPrint(true);
        beanConfig.setScan(false);
        
        register(ApiListingResource.class);
        register(SwaggerSerializers.class );
    }
}
