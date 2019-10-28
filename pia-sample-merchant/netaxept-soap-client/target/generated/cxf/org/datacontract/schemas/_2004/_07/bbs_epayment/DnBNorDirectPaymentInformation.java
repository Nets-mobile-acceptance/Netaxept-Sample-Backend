
package org.datacontract.schemas._2004._07.bbs_epayment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DnBNorDirectPaymentInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DnBNorDirectPaymentInformation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BankRef" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FromAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="KID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ToAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DnBNorDirectPaymentInformation", propOrder = {
    "bankRef",
    "fromAccount",
    "kid",
    "message",
    "toAccount"
})
public class DnBNorDirectPaymentInformation {

    @XmlElement(name = "BankRef", nillable = true)
    protected String bankRef;
    @XmlElement(name = "FromAccount", nillable = true)
    protected String fromAccount;
    @XmlElement(name = "KID", nillable = true)
    protected String kid;
    @XmlElement(name = "Message", nillable = true)
    protected String message;
    @XmlElement(name = "ToAccount", nillable = true)
    protected String toAccount;

    /**
     * Gets the value of the bankRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankRef() {
        return bankRef;
    }

    /**
     * Sets the value of the bankRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankRef(String value) {
        this.bankRef = value;
    }

    /**
     * Gets the value of the fromAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromAccount() {
        return fromAccount;
    }

    /**
     * Sets the value of the fromAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromAccount(String value) {
        this.fromAccount = value;
    }

    /**
     * Gets the value of the kid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKID() {
        return kid;
    }

    /**
     * Sets the value of the kid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKID(String value) {
        this.kid = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the toAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToAccount() {
        return toAccount;
    }

    /**
     * Sets the value of the toAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToAccount(String value) {
        this.toAccount = value;
    }

}
