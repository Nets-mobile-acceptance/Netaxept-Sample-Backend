package eu.nets.ms.pia.exception;

public class SystemException extends RuntimeException {
	private static final long serialVersionUID = -4743538214251747733L;
	public SystemException(String message, Throwable cause) {
		super(message, cause);
	}
	public SystemException(String message) {
		super(message);
	}
}
