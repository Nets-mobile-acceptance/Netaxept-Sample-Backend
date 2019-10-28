
package org.datacontract.schemas._2004._07.bbs_epayment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RegisterResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegisterResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TransactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TransactionString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="WalletURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegisterResponse", propOrder = {
    "transactionId",
    "transactionString",
    "walletURL"
})
public class RegisterResponse {

    @XmlElement(name = "TransactionId", nillable = true)
    protected String transactionId;
    @XmlElement(name = "TransactionString", nillable = true)
    protected String transactionString;
    @XmlElement(name = "WalletURL", nillable = true)
    protected String walletURL;

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
     * Gets the value of the transactionString property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionString() {
        return transactionString;
    }

    /**
     * Sets the value of the transactionString property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionString(String value) {
        this.transactionString = value;
    }

    /**
     * Gets the value of the walletURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWalletURL() {
        return walletURL;
    }

    /**
     * Sets the value of the walletURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWalletURL(String value) {
        this.walletURL = value;
    }

}
