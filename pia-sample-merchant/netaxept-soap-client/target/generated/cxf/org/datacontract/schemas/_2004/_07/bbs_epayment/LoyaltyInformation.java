
package org.datacontract.schemas._2004._07.bbs_epayment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LoyaltyInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoyaltyInformation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CustomerLoyaltyId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TransactionLoyaltyAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PaymentMethodBenefitAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="EnableCardLink" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoyaltyInformation", propOrder = {
    "customerLoyaltyId",
    "transactionLoyaltyAmount",
    "paymentMethodBenefitAmount",
    "enableCardLink",
    "status"
})
public class LoyaltyInformation {

    @XmlElement(name = "CustomerLoyaltyId", nillable = true)
    protected String customerLoyaltyId;
    @XmlElement(name = "TransactionLoyaltyAmount", nillable = true)
    protected String transactionLoyaltyAmount;
    @XmlElement(name = "PaymentMethodBenefitAmount", nillable = true)
    protected String paymentMethodBenefitAmount;
    @XmlElement(name = "EnableCardLink", nillable = true)
    protected String enableCardLink;
    @XmlElement(name = "Status", nillable = true)
    protected String status;

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
     * Gets the value of the transactionLoyaltyAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionLoyaltyAmount() {
        return transactionLoyaltyAmount;
    }

    /**
     * Sets the value of the transactionLoyaltyAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionLoyaltyAmount(String value) {
        this.transactionLoyaltyAmount = value;
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
     * Gets the value of the enableCardLink property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnableCardLink() {
        return enableCardLink;
    }

    /**
     * Sets the value of the enableCardLink property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnableCardLink(String value) {
        this.enableCardLink = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

}
