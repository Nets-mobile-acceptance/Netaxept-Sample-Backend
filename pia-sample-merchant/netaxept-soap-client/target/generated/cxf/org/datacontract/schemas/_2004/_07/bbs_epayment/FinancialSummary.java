
package org.datacontract.schemas._2004._07.bbs_epayment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FinancialSummary complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FinancialSummary"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AmountCaptured" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AmountCredited" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Annulled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="AuthorizationId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Authorized" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FinancialSummary", propOrder = {
    "amountCaptured",
    "amountCredited",
    "annulled",
    "authorizationId",
    "authorized"
})
public class FinancialSummary {

    @XmlElement(name = "AmountCaptured", nillable = true)
    protected String amountCaptured;
    @XmlElement(name = "AmountCredited", nillable = true)
    protected String amountCredited;
    @XmlElement(name = "Annulled")
    protected Boolean annulled;
    @XmlElement(name = "AuthorizationId", nillable = true)
    protected String authorizationId;
    @XmlElement(name = "Authorized")
    protected Boolean authorized;

    /**
     * Gets the value of the amountCaptured property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmountCaptured() {
        return amountCaptured;
    }

    /**
     * Sets the value of the amountCaptured property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmountCaptured(String value) {
        this.amountCaptured = value;
    }

    /**
     * Gets the value of the amountCredited property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmountCredited() {
        return amountCredited;
    }

    /**
     * Sets the value of the amountCredited property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmountCredited(String value) {
        this.amountCredited = value;
    }

    /**
     * Gets the value of the annulled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAnnulled() {
        return annulled;
    }

    /**
     * Sets the value of the annulled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAnnulled(Boolean value) {
        this.annulled = value;
    }

    /**
     * Gets the value of the authorizationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizationId() {
        return authorizationId;
    }

    /**
     * Sets the value of the authorizationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizationId(String value) {
        this.authorizationId = value;
    }

    /**
     * Gets the value of the authorized property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAuthorized() {
        return authorized;
    }

    /**
     * Sets the value of the authorized property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAuthorized(Boolean value) {
        this.authorized = value;
    }

}
