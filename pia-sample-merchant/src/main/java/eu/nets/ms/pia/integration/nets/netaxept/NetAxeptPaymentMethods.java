package eu.nets.ms.pia.integration.nets.netaxept;

public enum NetAxeptPaymentMethods {
		VISA("Visa"),
		MC("MasterCard"),
		AMEX("AmericanExpress"),
		BANKAXESS("BankAxess"),
		BANKAXESS_MOBILE("BankAxessMobile"),
		BRING("Bring"),
		MOBILPENG("Mobilpenge"),
		DANKORT("Dankort"),
		DK_BANK_NORDEA("DanishBankNordea"),
		DANISHCONSUMERCARD("DanishConsumerCard"),
		DINERS_INT("DinersClubInternational"),
		DNBNOR_DIRECT_PAY("DnBNorDirectPayment"),
		FI_BANK_NORDEA("FinishBankNordea"),
		GIFTCARD("GiftCard"),
		GIFTCARD_CENTER("GiftCardCenter"),
		INVOICE_GOTIA("GothiaInvoice"),
		INSTALLMENT_SHB("HandelsbankenInstallment"),
		INVOICE_SHB("HandelsbankenInvoice"),
		JCB("JCB"),
		KLARNA("Klarna"),
		INSTALLMENT_KLARNA("KlarnaInstallment"),
		MAESTRO("Maestro"),
		NORDEA_FINANS("NordeaFinans"),
		PAYPAL("Paypal"),
		PBS_PREPAID("PBSPrepaidCard"),
		RESURSBANK("ResursBank"),
		SB1GIFTCARD("SB1GiftCard"),
		SB1GIFTCARD_CENTER("SB1GiftCardCenter"),
		SE_BANK_SHB("SwedishBankHandelsbanken"),
		SE_BANK_NORDEA("SwedishBankNordea"),
		SE_BANK_SEB("SwedishBankSEB"),
		SE_BANK_SWEDBANK("SwedishBankSwedbank"),
		SE_DEBIT_MC("SwedishDebitMasterCard"),
		SE_DEBIT_VISA("SwedishDebitVisa"),
		LICCARD("LICCard"),
		ACCEPTCARD("AcceptCard");
	String methodName;
	NetAxeptPaymentMethods(String methodName){
		this.methodName = methodName;
	}
	
	public String getMethodName(){
		return this.methodName;
	}
}
