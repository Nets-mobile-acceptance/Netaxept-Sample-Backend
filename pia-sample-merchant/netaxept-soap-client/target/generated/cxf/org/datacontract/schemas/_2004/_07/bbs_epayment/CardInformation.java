
package org.datacontract.schemas._2004._07.bbs_epayment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CardInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CardInformation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ExpiryDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Issuer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IssuerCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MaskedPAN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PanHash" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PaymentMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IssuerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardInformation", propOrder = {
    "expiryDate",
    "issuer",
    "issuerCountry",
    "maskedPAN",
    "panHash",
    "paymentMethod",
    "issuerId"
})
public class CardInformation {

    @XmlElement(name = "ExpiryDate", nillable = true)
    protected String expiryDate;
    @XmlElement(name = "Issuer", nillable = true)
    protected String issuer;
    @XmlElement(name = "IssuerCountry", nillable = true)
    protected String issuerCountry;
    @XmlElement(name = "MaskedPAN", nillable = true)
    protected String maskedPAN;
    @XmlElement(name = "PanHash", nillable = true)
    protected String panHash;
    @XmlElement(name = "PaymentMethod", nillable = true)
    protected String paymentMethod;
    @XmlElement(name = "IssuerId", nillable = true)
    protected String issuerId;

    /**
     * Gets the value of the expiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the value of the expiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpiryDate(String value) {
        this.expiryDate = value;
    }

    /**
     * Gets the value of the issuer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuer() {
        return issuer;
    }

    /**
     * Sets the value of the issuer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuer(String value) {
        this.issuer = value;
    }

    /**
     * Gets the value of the issuerCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuerCountry() {
        return issuerCountry;
    }

    /**
     * Sets the value of the issuerCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuerCountry(String value) {
        this.issuerCountry = value;
    }

    /**
     * Gets the value of the maskedPAN property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaskedPAN() {
        return maskedPAN;
    }

    /**
     * Sets the value of the maskedPAN property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaskedPAN(String value) {
        this.maskedPAN = value;
    }

    /**
     * Gets the value of the panHash property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPanHash() {
        return panHash;
    }

    /**
     * Sets the value of the panHash property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPanHash(String value) {
        this.panHash = value;
    }

    /**
     * Gets the value of the paymentMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the value of the paymentMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentMethod(String value) {
        this.paymentMethod = value;
    }

    /**
     * Gets the value of the issuerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuerId() {
        return issuerId;
    }

    /**
     * Sets the value of the issuerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuerId(String value) {
        this.issuerId = value;
    }

}
