
package org.datacontract.schemas._2004._07.bbs_epayment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PaymentInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}QueryResponse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AuthenticationInformation" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}AuthenticationInformation" minOccurs="0"/&gt;
 *         &lt;element name="AvtaleGiroInformation" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}AvtaleGiroInformation" minOccurs="0"/&gt;
 *         &lt;element name="CardInformation" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}CardInformation" minOccurs="0"/&gt;
 *         &lt;element name="CustomerInformation" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}CustomerInformation" minOccurs="0"/&gt;
 *         &lt;element name="DnBNorDirectPaymentInformation" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}DnBNorDirectPaymentInformation" minOccurs="0"/&gt;
 *         &lt;element name="Error" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}PaymentError" minOccurs="0"/&gt;
 *         &lt;element name="ErrorLog" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}ArrayOfPaymentError" minOccurs="0"/&gt;
 *         &lt;element name="History" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}ArrayOfTransactionLogLine" minOccurs="0"/&gt;
 *         &lt;element name="InvoiceInformation" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}InvoiceInformation" minOccurs="0"/&gt;
 *         &lt;element name="OrderInformation" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}OrderInformation" minOccurs="0"/&gt;
 *         &lt;element name="Recurring" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}Recurring" minOccurs="0"/&gt;
 *         &lt;element name="SecurityInformation" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}SecurityInformation" minOccurs="0"/&gt;
 *         &lt;element name="Summary" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}FinancialSummary" minOccurs="0"/&gt;
 *         &lt;element name="TerminalInformation" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}TerminalInformation" minOccurs="0"/&gt;
 *         &lt;element name="FraudAnalysis" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}FraudAnalysis" minOccurs="0"/&gt;
 *         &lt;element name="Mobile" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}MobileInformation" minOccurs="0"/&gt;
 *         &lt;element name="PaymentFacilitator" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}PaymentFacilitatorInformation" minOccurs="0"/&gt;
 *         &lt;element name="Wallet" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}WalletInformation" minOccurs="0"/&gt;
 *         &lt;element name="LoyaltyInformation" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}LoyaltyInformation" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentInfo", propOrder = {
    "authenticationInformation",
    "avtaleGiroInformation",
    "cardInformation",
    "customerInformation",
    "dnBNorDirectPaymentInformation",
    "error",
    "errorLog",
    "history",
    "invoiceInformation",
    "orderInformation",
    "recurring",
    "securityInformation",
    "summary",
    "terminalInformation",
    "fraudAnalysis",
    "mobile",
    "paymentFacilitator",
    "wallet",
    "loyaltyInformation"
})
public class PaymentInfo
    extends QueryResponse
{

    @XmlElement(name = "AuthenticationInformation", nillable = true)
    protected AuthenticationInformation authenticationInformation;
    @XmlElement(name = "AvtaleGiroInformation", nillable = true)
    protected AvtaleGiroInformation avtaleGiroInformation;
    @XmlElement(name = "CardInformation", nillable = true)
    protected CardInformation cardInformation;
    @XmlElement(name = "CustomerInformation", nillable = true)
    protected CustomerInformation customerInformation;
    @XmlElement(name = "DnBNorDirectPaymentInformation", nillable = true)
    protected DnBNorDirectPaymentInformation dnBNorDirectPaymentInformation;
    @XmlElement(name = "Error", nillable = true)
    protected PaymentError error;
    @XmlElement(name = "ErrorLog", nillable = true)
    protected ArrayOfPaymentError errorLog;
    @XmlElement(name = "History", nillable = true)
    protected ArrayOfTransactionLogLine history;
    @XmlElement(name = "InvoiceInformation", nillable = true)
    protected InvoiceInformation invoiceInformation;
    @XmlElement(name = "OrderInformation", nillable = true)
    protected OrderInformation orderInformation;
    @XmlElement(name = "Recurring", nillable = true)
    protected Recurring recurring;
    @XmlElement(name = "SecurityInformation", nillable = true)
    protected SecurityInformation securityInformation;
    @XmlElement(name = "Summary", nillable = true)
    protected FinancialSummary summary;
    @XmlElement(name = "TerminalInformation", nillable = true)
    protected TerminalInformation terminalInformation;
    @XmlElement(name = "FraudAnalysis", nillable = true)
    protected FraudAnalysis fraudAnalysis;
    @XmlElement(name = "Mobile", nillable = true)
    protected MobileInformation mobile;
    @XmlElement(name = "PaymentFacilitator", nillable = true)
    protected PaymentFacilitatorInformation paymentFacilitator;
    @XmlElement(name = "Wallet", nillable = true)
    protected WalletInformation wallet;
    @XmlElement(name = "LoyaltyInformation", nillable = true)
    protected LoyaltyInformation loyaltyInformation;

    /**
     * Gets the value of the authenticationInformation property.
     * 
     * @return
     *     possible object is
     *     {@link AuthenticationInformation }
     *     
     */
    public AuthenticationInformation getAuthenticationInformation() {
        return authenticationInformation;
    }

    /**
     * Sets the value of the authenticationInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthenticationInformation }
     *     
     */
    public void setAuthenticationInformation(AuthenticationInformation value) {
        this.authenticationInformation = value;
    }

    /**
     * Gets the value of the avtaleGiroInformation property.
     * 
     * @return
     *     possible object is
     *     {@link AvtaleGiroInformation }
     *     
     */
    public AvtaleGiroInformation getAvtaleGiroInformation() {
        return avtaleGiroInformation;
    }

    /**
     * Sets the value of the avtaleGiroInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link AvtaleGiroInformation }
     *     
     */
    public void setAvtaleGiroInformation(AvtaleGiroInformation value) {
        this.avtaleGiroInformation = value;
    }

    /**
     * Gets the value of the cardInformation property.
     * 
     * @return
     *     possible object is
     *     {@link CardInformation }
     *     
     */
    public CardInformation getCardInformation() {
        return cardInformation;
    }

    /**
     * Sets the value of the cardInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardInformation }
     *     
     */
    public void setCardInformation(CardInformation value) {
        this.cardInformation = value;
    }

    /**
     * Gets the value of the customerInformation property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerInformation }
     *     
     */
    public CustomerInformation getCustomerInformation() {
        return customerInformation;
    }

    /**
     * Sets the value of the customerInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerInformation }
     *     
     */
    public void setCustomerInformation(CustomerInformation value) {
        this.customerInformation = value;
    }

    /**
     * Gets the value of the dnBNorDirectPaymentInformation property.
     * 
     * @return
     *     possible object is
     *     {@link DnBNorDirectPaymentInformation }
     *     
     */
    public DnBNorDirectPaymentInformation getDnBNorDirectPaymentInformation() {
        return dnBNorDirectPaymentInformation;
    }

    /**
     * Sets the value of the dnBNorDirectPaymentInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link DnBNorDirectPaymentInformation }
     *     
     */
    public void setDnBNorDirectPaymentInformation(DnBNorDirectPaymentInformation value) {
        this.dnBNorDirectPaymentInformation = value;
    }

    /**
     * Gets the value of the error property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentError }
     *     
     */
    public PaymentError getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentError }
     *     
     */
    public void setError(PaymentError value) {
        this.error = value;
    }

    /**
     * Gets the value of the errorLog property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPaymentError }
     *     
     */
    public ArrayOfPaymentError getErrorLog() {
        return errorLog;
    }

    /**
     * Sets the value of the errorLog property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPaymentError }
     *     
     */
    public void setErrorLog(ArrayOfPaymentError value) {
        this.errorLog = value;
    }

    /**
     * Gets the value of the history property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTransactionLogLine }
     *     
     */
    public ArrayOfTransactionLogLine getHistory() {
        return history;
    }

    /**
     * Sets the value of the history property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTransactionLogLine }
     *     
     */
    public void setHistory(ArrayOfTransactionLogLine value) {
        this.history = value;
    }

    /**
     * Gets the value of the invoiceInformation property.
     * 
     * @return
     *     possible object is
     *     {@link InvoiceInformation }
     *     
     */
    public InvoiceInformation getInvoiceInformation() {
        return invoiceInformation;
    }

    /**
     * Sets the value of the invoiceInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvoiceInformation }
     *     
     */
    public void setInvoiceInformation(InvoiceInformation value) {
        this.invoiceInformation = value;
    }

    /**
     * Gets the value of the orderInformation property.
     * 
     * @return
     *     possible object is
     *     {@link OrderInformation }
     *     
     */
    public OrderInformation getOrderInformation() {
        return orderInformation;
    }

    /**
     * Sets the value of the orderInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderInformation }
     *     
     */
    public void setOrderInformation(OrderInformation value) {
        this.orderInformation = value;
    }

    /**
     * Gets the value of the recurring property.
     * 
     * @return
     *     possible object is
     *     {@link Recurring }
     *     
     */
    public Recurring getRecurring() {
        return recurring;
    }

    /**
     * Sets the value of the recurring property.
     * 
     * @param value
     *     allowed object is
     *     {@link Recurring }
     *     
     */
    public void setRecurring(Recurring value) {
        this.recurring = value;
    }

    /**
     * Gets the value of the securityInformation property.
     * 
     * @return
     *     possible object is
     *     {@link SecurityInformation }
     *     
     */
    public SecurityInformation getSecurityInformation() {
        return securityInformation;
    }

    /**
     * Sets the value of the securityInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecurityInformation }
     *     
     */
    public void setSecurityInformation(SecurityInformation value) {
        this.securityInformation = value;
    }

    /**
     * Gets the value of the summary property.
     * 
     * @return
     *     possible object is
     *     {@link FinancialSummary }
     *     
     */
    public FinancialSummary getSummary() {
        return summary;
    }

    /**
     * Sets the value of the summary property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialSummary }
     *     
     */
    public void setSummary(FinancialSummary value) {
        this.summary = value;
    }

    /**
     * Gets the value of the terminalInformation property.
     * 
     * @return
     *     possible object is
     *     {@link TerminalInformation }
     *     
     */
    public TerminalInformation getTerminalInformation() {
        return terminalInformation;
    }

    /**
     * Sets the value of the terminalInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link TerminalInformation }
     *     
     */
    public void setTerminalInformation(TerminalInformation value) {
        this.terminalInformation = value;
    }

    /**
     * Gets the value of the fraudAnalysis property.
     * 
     * @return
     *     possible object is
     *     {@link FraudAnalysis }
     *     
     */
    public FraudAnalysis getFraudAnalysis() {
        return fraudAnalysis;
    }

    /**
     * Sets the value of the fraudAnalysis property.
     * 
     * @param value
     *     allowed object is
     *     {@link FraudAnalysis }
     *     
     */
    public void setFraudAnalysis(FraudAnalysis value) {
        this.fraudAnalysis = value;
    }

    /**
     * Gets the value of the mobile property.
     * 
     * @return
     *     possible object is
     *     {@link MobileInformation }
     *     
     */
    public MobileInformation getMobile() {
        return mobile;
    }

    /**
     * Sets the value of the mobile property.
     * 
     * @param value
     *     allowed object is
     *     {@link MobileInformation }
     *     
     */
    public void setMobile(MobileInformation value) {
        this.mobile = value;
    }

    /**
     * Gets the value of the paymentFacilitator property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentFacilitatorInformation }
     *     
     */
    public PaymentFacilitatorInformation getPaymentFacilitator() {
        return paymentFacilitator;
    }

    /**
     * Sets the value of the paymentFacilitator property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentFacilitatorInformation }
     *     
     */
    public void setPaymentFacilitator(PaymentFacilitatorInformation value) {
        this.paymentFacilitator = value;
    }

    /**
     * Gets the value of the wallet property.
     * 
     * @return
     *     possible object is
     *     {@link WalletInformation }
     *     
     */
    public WalletInformation getWallet() {
        return wallet;
    }

    /**
     * Sets the value of the wallet property.
     * 
     * @param value
     *     allowed object is
     *     {@link WalletInformation }
     *     
     */
    public void setWallet(WalletInformation value) {
        this.wallet = value;
    }

    /**
     * Gets the value of the loyaltyInformation property.
     * 
     * @return
     *     possible object is
     *     {@link LoyaltyInformation }
     *     
     */
    public LoyaltyInformation getLoyaltyInformation() {
        return loyaltyInformation;
    }

    /**
     * Sets the value of the loyaltyInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoyaltyInformation }
     *     
     */
    public void setLoyaltyInformation(LoyaltyInformation value) {
        this.loyaltyInformation = value;
    }

}
