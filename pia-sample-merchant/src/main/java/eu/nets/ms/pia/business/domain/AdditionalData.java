package eu.nets.ms.pia.business.domain;

public class AdditionalData {
	
	public static final String CARD_TOKEN_VALUE = "CARD_TOKEN_VALUE";
	public static final String APPLE_PAY_DATA = "APPLE_PAY_DATA";
	public static final String CARD_EXPIRATION_DATE = "CARD_EXPIRATION_DATE";
	public static final String REQUIRE_CVV_FROM_CONSUMER = "REQUIRE_CVV_FROM_CONSUMER";
	
	private AdditionalData(){
		throw new AssertionError();
	}

}
