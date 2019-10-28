
package org.datacontract.schemas._2004._07.bbs_epayment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Token complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Token"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GenerateToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TokenExpiryDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TokenReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Token", propOrder = {
    "generateToken",
    "tokenExpiryDate",
    "tokenReference"
})
public class Token {

    @XmlElement(name = "GenerateToken", nillable = true)
    protected String generateToken;
    @XmlElement(name = "TokenExpiryDate", nillable = true)
    protected String tokenExpiryDate;
    @XmlElement(name = "TokenReference", nillable = true)
    protected String tokenReference;

    /**
     * Gets the value of the generateToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenerateToken() {
        return generateToken;
    }

    /**
     * Sets the value of the generateToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenerateToken(String value) {
        this.generateToken = value;
    }

    /**
     * Gets the value of the tokenExpiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTokenExpiryDate() {
        return tokenExpiryDate;
    }

    /**
     * Sets the value of the tokenExpiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTokenExpiryDate(String value) {
        this.tokenExpiryDate = value;
    }

    /**
     * Gets the value of the tokenReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTokenReference() {
        return tokenReference;
    }

    /**
     * Sets the value of the tokenReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTokenReference(String value) {
        this.tokenReference = value;
    }

}
