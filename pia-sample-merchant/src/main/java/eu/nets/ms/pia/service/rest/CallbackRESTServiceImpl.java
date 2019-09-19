package eu.nets.ms.pia.service.rest;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import eu.nets.ms.pia.business.logic.SecurityService;
import eu.nets.ms.pia.business.sync.SyncService;

@Component
public class CallbackRESTServiceImpl implements CallbackRESTService{
	private static final Logger LOGGER = LoggerFactory.getLogger(CallbackRESTService.class);
	
	@Inject
	private SyncService syncService;
	
	@Inject
	private SecurityService securityService;
	
	
	@Override
	public Response onStatusChange(NetaxeptStatusChangeEvent statusChangeEvent, String token, HttpServletRequest httpServletRequest) {
			if(!isAuthorized(token)){
				return Response.status(401).build();
			}
			LOGGER.info("onStatusChange = {}", statusChangeEvent.getTransactionId());
			syncService.releaseLock(statusChangeEvent.getTransactionId());
			return Response.ok().build();
		
		
	}


	private boolean isAuthorized(String token) {
		try {
			securityService.verifyToken(token);
			return true;
		} catch (Exception e) {
			LOGGER.error("Error validating token", e);
			return false;
		}
	}
}
