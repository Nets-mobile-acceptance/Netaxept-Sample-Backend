
package org.datacontract.schemas._2004._07.bbs_epayment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Recurring complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Recurring"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ExpiryDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Frequency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PanHash" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PanHashSecret" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PanhashType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Use3DS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Recurring", propOrder = {
    "expiryDate",
    "frequency",
    "panHash",
    "panHashSecret",
    "panhashType",
    "type",
    "use3DS"
})
public class Recurring {

    @XmlElement(name = "ExpiryDate", nillable = true)
    protected String expiryDate;
    @XmlElement(name = "Frequency", nillable = true)
    protected String frequency;
    @XmlElement(name = "PanHash", nillable = true)
    protected String panHash;
    @XmlElement(name = "PanHashSecret", nillable = true)
    protected String panHashSecret;
    @XmlElement(name = "PanhashType", nillable = true)
    protected String panhashType;
    @XmlElement(name = "Type", nillable = true)
    protected String type;
    @XmlElement(name = "Use3DS", nillable = true)
    protected String use3DS;

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
     * Gets the value of the frequency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrequency() {
        return frequency;
    }

    /**
     * Sets the value of the frequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrequency(String value) {
        this.frequency = value;
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
     * Gets the value of the panHashSecret property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPanHashSecret() {
        return panHashSecret;
    }

    /**
     * Sets the value of the panHashSecret property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPanHashSecret(String value) {
        this.panHashSecret = value;
    }

    /**
     * Gets the value of the panhashType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPanhashType() {
        return panhashType;
    }

    /**
     * Sets the value of the panhashType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPanhashType(String value) {
        this.panhashType = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the use3DS property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUse3DS() {
        return use3DS;
    }

    /**
     * Sets the value of the use3DS property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUse3DS(String value) {
        this.use3DS = value;
    }

}
