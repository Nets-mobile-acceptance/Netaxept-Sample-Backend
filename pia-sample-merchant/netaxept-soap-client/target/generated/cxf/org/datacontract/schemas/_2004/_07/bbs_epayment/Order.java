
package org.datacontract.schemas._2004._07.bbs_epayment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Order complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Order"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Amount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DeliveryDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Force3DSecure" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Goods" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}ArrayOfItem" minOccurs="0"/&gt;
 *         &lt;element name="OrderNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UpdateStoredPaymentInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ValidateCustomer" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Order", propOrder = {
    "amount",
    "currencyCode",
    "deliveryDate",
    "force3DSecure",
    "goods",
    "orderNumber",
    "updateStoredPaymentInfo",
    "validateCustomer"
})
public class Order {

    @XmlElement(name = "Amount", nillable = true)
    protected String amount;
    @XmlElement(name = "CurrencyCode", nillable = true)
    protected String currencyCode;
    @XmlElement(name = "DeliveryDate", nillable = true)
    protected String deliveryDate;
    @XmlElement(name = "Force3DSecure", nillable = true)
    protected String force3DSecure;
    @XmlElement(name = "Goods", nillable = true)
    protected ArrayOfItem goods;
    @XmlElement(name = "OrderNumber", nillable = true)
    protected String orderNumber;
    @XmlElement(name = "UpdateStoredPaymentInfo", nillable = true)
    protected String updateStoredPaymentInfo;
    @XmlElement(name = "ValidateCustomer")
    protected Boolean validateCustomer;

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmount(String value) {
        this.amount = value;
    }

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the deliveryDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * Sets the value of the deliveryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryDate(String value) {
        this.deliveryDate = value;
    }

    /**
     * Gets the value of the force3DSecure property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForce3DSecure() {
        return force3DSecure;
    }

    /**
     * Sets the value of the force3DSecure property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForce3DSecure(String value) {
        this.force3DSecure = value;
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
     * Gets the value of the orderNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderNumber() {
        return orderNumber;
    }

    /**
     * Sets the value of the orderNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderNumber(String value) {
        this.orderNumber = value;
    }

    /**
     * Gets the value of the updateStoredPaymentInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdateStoredPaymentInfo() {
        return updateStoredPaymentInfo;
    }

    /**
     * Sets the value of the updateStoredPaymentInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdateStoredPaymentInfo(String value) {
        this.updateStoredPaymentInfo = value;
    }

    /**
     * Gets the value of the validateCustomer property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isValidateCustomer() {
        return validateCustomer;
    }

    /**
     * Sets the value of the validateCustomer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setValidateCustomer(Boolean value) {
        this.validateCustomer = value;
    }

}
