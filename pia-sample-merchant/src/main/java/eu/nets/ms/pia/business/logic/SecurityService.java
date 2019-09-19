package eu.nets.ms.pia.business.logic;

import io.jsonwebtoken.Claims;

public interface SecurityService{
	Claims verifyToken(String token);
	

}