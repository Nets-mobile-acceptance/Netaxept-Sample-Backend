package eu.nets.ms.pia.integration.nets.netaxept.exception;

import eu.nets.ms.pia.exception.PspException;

@SuppressWarnings("serial")
public class NetAxeptProviderException extends PspException {
	public NetAxeptProviderException(String detailedInformation, Throwable cause) {
		super(detailedInformation, cause);
	}
	public NetAxeptProviderException(String detailedInformation) {
		super(detailedInformation);
	}
}
