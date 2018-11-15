package eu.nets.ms.pia.integration.nets.netaxept.exception;

import eu.nets.ms.pia.exception.SystemException;

public class ServiceNotFoundException extends SystemException {
	private static final long serialVersionUID = 2548486097228679812L;

	public ServiceNotFoundException(String message) {
		super(message);
	}
	public ServiceNotFoundException(String message, Throwable exception) {
		super(message, exception);
	}
	

}
