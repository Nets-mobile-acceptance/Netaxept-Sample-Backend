package eu.nets.ms.pia.service.model;

public enum MethodEnum {
	VISA("Visa", "Visa", 0L),
	MASTERCARD("MasterCard", "Mastercard", 0L),
	AMEX("AmericanExpress", "American Express", 0L),
	EASY_PAY("EasyPayment", "Easy Payment", 0L),
	APPLE_PAY("ApplePay", "Apple Pay", 0L),
	DANKORT("Dankort", "Dankort", 0L),
	PAY_PAL("PayPal", "PayPal", 0L),
	DINERS_INT("DinersClubInternational", "Diners Club", 0L),
	JCB("JCB", "JCB", 0L),
	SWISH("SwishM", "Swish", 0L),
	VIPPS("Vipps", "Vipps", 0L),
	MAESTRO ("Maestro", "Maestro", 0L);
	
	private String id;
	private String displayName;
	private long fee;
	
	private MethodEnum(String id, String displayName, long fee){
		this.id = id;
		this.displayName = displayName;
		this.fee = fee;
	}
	public static MethodEnum create(String id){
		switch(id){
		case  "Visa":
			return MethodEnum.VISA;
		case "MasterCard":
			return MethodEnum.MASTERCARD;
		case "AmericanExpress":
			return MethodEnum.AMEX;
		case "EasyPayment":
			return MethodEnum.EASY_PAY;
		case "ApplePay":
			return MethodEnum.APPLE_PAY;
		case "PayPal":
			return MethodEnum.PAY_PAL;
		case "Dankort":
			return MethodEnum.DANKORT;
		case "DinersClubInternational":
			return MethodEnum.DINERS_INT;
		case "JCB":
			return MethodEnum.JCB;
		case "SwishM":
			return MethodEnum.SWISH;
		case "Vipps":
			return MethodEnum.VIPPS;
		case "Maestro":
			return MethodEnum.MAESTRO;
		default:
			return null;
		}
	}


	public String getId() {
		return id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public long getFee() {
		return fee;
	}
}
