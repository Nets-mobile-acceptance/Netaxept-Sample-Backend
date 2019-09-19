package eu.nets.ms.pia.business.logic;

import javax.inject.Inject;
import eu.nets.ms.pia.integration.nets.netaxept.NetAxeptConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.TextCodec;

/**
 * The Class SecurityServiceImpl.
 * 
 * This service uses a hard coded symmetric key to validate the token. Any JWT using a HS256 algo with this key will be validated as OK.
 */
@Service
public class SecurityServiceImpl implements SecurityService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityService.class);

	@Inject
	private NetAxeptConfig config;

	@Override
	public Claims verifyToken(String jwt){
		Claims claims = Jwts.parser()         
	       .setSigningKey(TextCodec.BASE64.encode(config.getJwtSecret()))
	       .parseClaimsJws(jwt).getBody();
		LOGGER.info("Token verified");
		return claims;
	}

}
