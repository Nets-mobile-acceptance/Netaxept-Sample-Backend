
package org.datacontract.schemas._2004._07.bbs_epayment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RegisterRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegisterRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AcquirerInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AvtaleGiro" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}AvtaleGiro" minOccurs="0"/&gt;
 *         &lt;element name="CardInfo" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}CardInfo" minOccurs="0"/&gt;
 *         &lt;element name="Customer" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}Customer" minOccurs="0"/&gt;
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DnBNorDirectPayment" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}DnBNorDirectPayment" minOccurs="0"/&gt;
 *         &lt;element name="Environment" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}Environment" minOccurs="0"/&gt;
 *         &lt;element name="Fraud" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}Fraud" minOccurs="0"/&gt;
 *         &lt;element name="LoyaltyInformation" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}LoyaltyInformation" minOccurs="0"/&gt;
 *         &lt;element name="MicroPayment" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}MicroPayment" minOccurs="0"/&gt;
 *         &lt;element name="Order" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}Order" minOccurs="0"/&gt;
 *         &lt;element name="PaymentFacilitator" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}PaymentFacilitatorInformation" minOccurs="0"/&gt;
 *         &lt;element name="Recurring" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}Recurring" minOccurs="0"/&gt;
 *         &lt;element name="ServiceType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Terminal" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}Terminal" minOccurs="0"/&gt;
 *         &lt;element name="Token" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}Token" minOccurs="0"/&gt;
 *         &lt;element name="TransactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TransactionReconRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegisterRequest", propOrder = {
    "acquirerInfo",
    "avtaleGiro",
    "cardInfo",
    "customer",
    "description",
    "dnBNorDirectPayment",
    "environment",
    "fraud",
    "loyaltyInformation",
    "microPayment",
    "order",
    "paymentFacilitator",
    "recurring",
    "serviceType",
    "terminal",
    "token",
    "transactionId",
    "transactionReconRef"
})
public class RegisterRequest {

    @XmlElement(name = "AcquirerInfo", nillable = true)
    protected String acquirerInfo;
    @XmlElement(name = "AvtaleGiro", nillable = true)
    protected AvtaleGiro avtaleGiro;
    @XmlElement(name = "CardInfo", nillable = true)
    protected CardInfo cardInfo;
    @XmlElement(name = "Customer", nillable = true)
    protected Customer customer;
    @XmlElement(name = "Description", nillable = true)
    protected String description;
    @XmlElement(name = "DnBNorDirectPayment", nillable = true)
    protected DnBNorDirectPayment dnBNorDirectPayment;
    @XmlElement(name = "Environment", nillable = true)
    protected Environment environment;
    @XmlElement(name = "Fraud", nillable = true)
    protected Fraud fraud;
    @XmlElement(name = "LoyaltyInformation", nillable = true)
    protected LoyaltyInformation loyaltyInformation;
    @XmlElement(name = "MicroPayment", nillable = true)
    protected MicroPayment microPayment;
    @XmlElement(name = "Order", nillable = true)
    protected Order order;
    @XmlElement(name = "PaymentFacilitator", nillable = true)
    protected PaymentFacilitatorInformation paymentFacilitator;
    @XmlElement(name = "Recurring", nillable = true)
    protected Recurring recurring;
    @XmlElement(name = "ServiceType", nillable = true)
    protected String serviceType;
    @XmlElement(name = "Terminal", nillable = true)
    protected Terminal terminal;
    @XmlElement(name = "Token", nillable = true)
    protected Token token;
    @XmlElement(name = "TransactionId", nillable = true)
    protected String transactionId;
    @XmlElement(name = "TransactionReconRef", nillable = true)
    protected String transactionReconRef;

    /**
     * Gets the value of the acquirerInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcquirerInfo() {
        return acquirerInfo;
    }

    /**
     * Sets the value of the acquirerInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcquirerInfo(String value) {
        this.acquirerInfo = value;
    }

    /**
     * Gets the value of the avtaleGiro property.
     * 
     * @return
     *     possible object is
     *     {@link AvtaleGiro }
     *     
     */
    public AvtaleGiro getAvtaleGiro() {
        return avtaleGiro;
    }

    /**
     * Sets the value of the avtaleGiro property.
     * 
     * @param value
     *     allowed object is
     *     {@link AvtaleGiro }
     *     
     */
    public void setAvtaleGiro(AvtaleGiro value) {
        this.avtaleGiro = value;
    }

    /**
     * Gets the value of the cardInfo property.
     * 
     * @return
     *     possible object is
     *     {@link CardInfo }
     *     
     */
    public CardInfo getCardInfo() {
        return cardInfo;
    }

    /**
     * Sets the value of the cardInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardInfo }
     *     
     */
    public void setCardInfo(CardInfo value) {
        this.cardInfo = value;
    }

    /**
     * Gets the value of the customer property.
     * 
     * @return
     *     possible object is
     *     {@link Customer }
     *     
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Customer }
     *     
     */
    public void setCustomer(Customer value) {
        this.customer = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the dnBNorDirectPayment property.
     * 
     * @return
     *     possible object is
     *     {@link DnBNorDirectPayment }
     *     
     */
    public DnBNorDirectPayment getDnBNorDirectPayment() {
        return dnBNorDirectPayment;
    }

    /**
     * Sets the value of the dnBNorDirectPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link DnBNorDirectPayment }
     *     
     */
    public void setDnBNorDirectPayment(DnBNorDirectPayment value) {
        this.dnBNorDirectPayment = value;
    }

    /**
     * Gets the value of the environment property.
     * 
     * @return
     *     possible object is
     *     {@link Environment }
     *     
     */
    public Environment getEnvironment() {
        return environment;
    }

    /**
     * Sets the value of the environment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Environment }
     *     
     */
    public void setEnvironment(Environment value) {
        this.environment = value;
    }

    /**
     * Gets the value of the fraud property.
     * 
     * @return
     *     possible object is
     *     {@link Fraud }
     *     
     */
    public Fraud getFraud() {
        return fraud;
    }

    /**
     * Sets the value of the fraud property.
     * 
     * @param value
     *     allowed object is
     *     {@link Fraud }
     *     
     */
    public void setFraud(Fraud value) {
        this.fraud = value;
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

    /**
     * Gets the value of the microPayment property.
     * 
     * @return
     *     possible object is
     *     {@link MicroPayment }
     *     
     */
    public MicroPayment getMicroPayment() {
        return microPayment;
    }

    /**
     * Sets the value of the microPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link MicroPayment }
     *     
     */
    public void setMicroPayment(MicroPayment value) {
        this.microPayment = value;
    }

    /**
     * Gets the value of the order property.
     * 
     * @return
     *     possible object is
     *     {@link Order }
     *     
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     * 
     * @param value
     *     allowed object is
     *     {@link Order }
     *     
     */
    public void setOrder(Order value) {
        this.order = value;
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
     * Gets the value of the serviceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * Sets the value of the serviceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceType(String value) {
        this.serviceType = value;
    }

    /**
     * Gets the value of the terminal property.
     * 
     * @return
     *     possible object is
     *     {@link Terminal }
     *     
     */
    public Terminal getTerminal() {
        return terminal;
    }

    /**
     * Sets the value of the terminal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Terminal }
     *     
     */
    public void setTerminal(Terminal value) {
        this.terminal = value;
    }

    /**
     * Gets the value of the token property.
     * 
     * @return
     *     possible object is
     *     {@link Token }
     *     
     */
    public Token getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     * 
     * @param value
     *     allowed object is
     *     {@link Token }
     *     
     */
    public void setToken(Token value) {
        this.token = value;
    }

    /**
     * Gets the value of the transactionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the value of the transactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionId(String value) {
        this.transactionId = value;
    }

    /**
     * Gets the value of the transactionReconRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionReconRef() {
        return transactionReconRef;
    }

    /**
     * Sets the value of the transactionReconRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionReconRef(String value) {
        this.transactionReconRef = value;
    }

}
