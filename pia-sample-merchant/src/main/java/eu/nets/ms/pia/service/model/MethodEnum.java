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
	MOBILE_PAY("MobilePay", "MobilePay", 0L),
	MAESTRO ("Maestro", "Maestro", 0L),
	PAYTRAIL_AKTIA("PaytrailAktia" , "PaytrailAktiaFinland", 0L),
	PAYTRAIL_ALANDSBANKEN("PaytrailAlandsbanken" , "PaytrailAlandsbankenFinland", 0L),
	PAYTRAIL_DANSKEBANK("PaytrailDanskeBank" , "PaytrailDanskeBankFinland", 0L),
	PAYTRAIL_HANDELSBANKEN("PaytrailHandelsbanken" , "PaytrailHandelsbankenFinland", 0L),
	PAYTRAIL_NORDEA("PaytrailNordea" , "PaytrailNordeaFinland", 0L),
	PAYTRAIL_OMASAASTOPANKKI("PaytrailOmaSaastopankki" , "PaytrailOmaSaastopankkiFinland", 0L),
	PAYTRAIL_OP("PaytrailOP" , "PaytrailOPBankFinland", 0L),
	PAYTRAIL_POP("PaytrailPOP" , "PaytrailPOPFinland", 0L),
	PAYTRAIL_SAASTOPANKKI("PaytrailSaastopankki" , "PaytrailSaastopankkiFinland", 0L),
	PAYTRAIL_SPANKKI("PaytrailSPankki" , "PaytrailSPankkiFinland", 0L);
	
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
		case "MobilePay":
			return MethodEnum.MOBILE_PAY;
		case "PaytrailAktia":
			return MethodEnum.PAYTRAIL_AKTIA;
		case "PaytrailAlandsbanken":
			return MethodEnum.PAYTRAIL_ALANDSBANKEN;			
		case "PaytrailDanskeBank":
			return MethodEnum.PAYTRAIL_DANSKEBANK;
		case "PaytrailHandelsbanken":
			return MethodEnum.PAYTRAIL_HANDELSBANKEN;
		case "PaytrailNordea":
			return MethodEnum.PAYTRAIL_NORDEA;
		case "PaytrailOmaSaastopankki":
			return MethodEnum.PAYTRAIL_OMASAASTOPANKKI;
		case "PaytrailOP":
			return MethodEnum.PAYTRAIL_OP;
		case "PaytrailPOP":
			return MethodEnum.PAYTRAIL_POP;
		case "PaytrailSaastopankki":
			return MethodEnum.PAYTRAIL_SAASTOPANKKI;
		case "PaytrailSPankki":
			return MethodEnum.PAYTRAIL_SPANKKI;
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
