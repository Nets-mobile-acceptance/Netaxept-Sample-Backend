package eu.nets.ms.pia.exception;

public class BusinessServiceException extends Exception {
	private static final long serialVersionUID = 1762275110051222152L;
	
	public BusinessServiceException(String message) {
		super(message);
	}
	public BusinessServiceException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
