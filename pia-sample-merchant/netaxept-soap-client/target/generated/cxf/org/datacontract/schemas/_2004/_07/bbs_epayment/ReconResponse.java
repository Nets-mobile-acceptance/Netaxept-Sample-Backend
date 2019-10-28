
package org.datacontract.schemas._2004._07.bbs_epayment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReconResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReconResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AmountCredits" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AmountDebits" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AmountNet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="NumberCredits" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="NumberDebits" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="SessionNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReconResponse", propOrder = {
    "amountCredits",
    "amountDebits",
    "amountNet",
    "numberCredits",
    "numberDebits",
    "sessionNumber"
})
public class ReconResponse {

    @XmlElement(name = "AmountCredits", nillable = true)
    protected String amountCredits;
    @XmlElement(name = "AmountDebits", nillable = true)
    protected String amountDebits;
    @XmlElement(name = "AmountNet", nillable = true)
    protected String amountNet;
    @XmlElement(name = "NumberCredits")
    protected Integer numberCredits;
    @XmlElement(name = "NumberDebits")
    protected Integer numberDebits;
    @XmlElement(name = "SessionNumber", nillable = true)
    protected String sessionNumber;

    /**
     * Gets the value of the amountCredits property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmountCredits() {
        return amountCredits;
    }

    /**
     * Sets the value of the amountCredits property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmountCredits(String value) {
        this.amountCredits = value;
    }

    /**
     * Gets the value of the amountDebits property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmountDebits() {
        return amountDebits;
    }

    /**
     * Sets the value of the amountDebits property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmountDebits(String value) {
        this.amountDebits = value;
    }

    /**
     * Gets the value of the amountNet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmountNet() {
        return amountNet;
    }

    /**
     * Sets the value of the amountNet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmountNet(String value) {
        this.amountNet = value;
    }

    /**
     * Gets the value of the numberCredits property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberCredits() {
        return numberCredits;
    }

    /**
     * Sets the value of the numberCredits property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberCredits(Integer value) {
        this.numberCredits = value;
    }

    /**
     * Gets the value of the numberDebits property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumberDebits() {
        return numberDebits;
    }

    /**
     * Sets the value of the numberDebits property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumberDebits(Integer value) {
        this.numberDebits = value;
    }

    /**
     * Gets the value of the sessionNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionNumber() {
        return sessionNumber;
    }

    /**
     * Sets the value of the sessionNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionNumber(String value) {
        this.sessionNumber = value;
    }

}
