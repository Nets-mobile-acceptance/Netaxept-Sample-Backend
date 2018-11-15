package eu.nets.ms.pia.exception;

public class PspException extends SystemException{
	private static final long serialVersionUID = 6298987863489069390L;

	public PspException(String message) {
		super(message);
	}

	public PspException(String message, Throwable cause) {
		super(message, cause);
	}

}
