
package org.datacontract.schemas._2004._07.bbs_epayment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProcessRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProcessRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CustomerLoyaltyId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Goods" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}ArrayOfItem" minOccurs="0"/&gt;
 *         &lt;element name="LoyaltyAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Operation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PaymentMethodBenefitAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SubTransactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TransactionAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "ProcessRequest", propOrder = {
    "customerLoyaltyId",
    "description",
    "goods",
    "loyaltyAmount",
    "operation",
    "paymentMethodBenefitAmount",
    "subTransactionId",
    "transactionAmount",
    "transactionId",
    "transactionReconRef"
})
public class ProcessRequest {

    @XmlElement(name = "CustomerLoyaltyId", nillable = true)
    protected String customerLoyaltyId;
    @XmlElement(name = "Description", nillable = true)
    protected String description;
    @XmlElement(name = "Goods", nillable = true)
    protected ArrayOfItem goods;
    @XmlElement(name = "LoyaltyAmount", nillable = true)
    protected String loyaltyAmount;
    @XmlElement(name = "Operation", nillable = true)
    protected String operation;
    @XmlElement(name = "PaymentMethodBenefitAmount", nillable = true)
    protected String paymentMethodBenefitAmount;
    @XmlElement(name = "SubTransactionId", nillable = true)
    protected String subTransactionId;
    @XmlElement(name = "TransactionAmount", nillable = true)
    protected String transactionAmount;
    @XmlElement(name = "TransactionId", nillable = true)
    protected String transactionId;
    @XmlElement(name = "TransactionReconRef", nillable = true)
    protected String transactionReconRef;

    /**
     * Gets the value of the customerLoyaltyId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerLoyaltyId() {
        return customerLoyaltyId;
    }

    /**
     * Sets the value of the customerLoyaltyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerLoyaltyId(String value) {
        this.customerLoyaltyId = value;
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
     * Gets the value of the goods property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfItem }
     *     
     */
    public ArrayOfItem getGoods() {
        return goods;
    }

    /**
     * Sets the value of the goods property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfItem }
     *     
     */
    public void setGoods(ArrayOfItem value) {
        this.goods = value;
    }

    /**
     * Gets the value of the loyaltyAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoyaltyAmount() {
        return loyaltyAmount;
    }

    /**
     * Sets the value of the loyaltyAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoyaltyAmount(String value) {
        this.loyaltyAmount = value;
    }

    /**
     * Gets the value of the operation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Sets the value of the operation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperation(String value) {
        this.operation = value;
    }

    /**
     * Gets the value of the paymentMethodBenefitAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentMethodBenefitAmount() {
        return paymentMethodBenefitAmount;
    }

    /**
     * Sets the value of the paymentMethodBenefitAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentMethodBenefitAmount(String value) {
        this.paymentMethodBenefitAmount = value;
    }

    /**
     * Gets the value of the subTransactionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubTransactionId() {
        return subTransactionId;
    }

    /**
     * Sets the value of the subTransactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubTransactionId(String value) {
        this.subTransactionId = value;
    }

    /**
     * Gets the value of the transactionAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionAmount() {
        return transactionAmount;
    }

    /**
     * Sets the value of the transactionAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionAmount(String value) {
        this.transactionAmount = value;
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
