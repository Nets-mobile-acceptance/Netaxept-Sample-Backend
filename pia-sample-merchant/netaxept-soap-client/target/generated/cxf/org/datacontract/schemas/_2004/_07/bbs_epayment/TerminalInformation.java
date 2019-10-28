
package org.datacontract.schemas._2004._07.bbs_epayment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TerminalInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TerminalInformation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Browser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CustomerEntered" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CustomerRedirected" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TerminalInformation", propOrder = {
    "browser",
    "customerEntered",
    "customerRedirected"
})
public class TerminalInformation {

    @XmlElement(name = "Browser", nillable = true)
    protected String browser;
    @XmlElement(name = "CustomerEntered", nillable = true)
    protected String customerEntered;
    @XmlElement(name = "CustomerRedirected", nillable = true)
    protected String customerRedirected;

    /**
     * Gets the value of the browser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrowser() {
        return browser;
    }

    /**
     * Sets the value of the browser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrowser(String value) {
        this.browser = value;
    }

    /**
     * Gets the value of the customerEntered property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerEntered() {
        return customerEntered;
    }

    /**
     * Sets the value of the customerEntered property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerEntered(String value) {
        this.customerEntered = value;
    }

    /**
     * Gets the value of the customerRedirected property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerRedirected() {
        return customerRedirected;
    }

    /**
     * Sets the value of the customerRedirected property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerRedirected(String value) {
        this.customerRedirected = value;
    }

}
