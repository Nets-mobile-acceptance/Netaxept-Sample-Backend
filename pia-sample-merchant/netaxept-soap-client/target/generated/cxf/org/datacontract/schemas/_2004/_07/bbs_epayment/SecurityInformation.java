
package org.datacontract.schemas._2004._07.bbs_epayment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SecurityInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SecurityInformation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CustomerIPCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IPCountryMatchesIssuingCountry" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SecurityInformation", propOrder = {
    "customerIPCountry",
    "ipCountryMatchesIssuingCountry"
})
public class SecurityInformation {

    @XmlElement(name = "CustomerIPCountry", nillable = true)
    protected String customerIPCountry;
    @XmlElement(name = "IPCountryMatchesIssuingCountry")
    protected Boolean ipCountryMatchesIssuingCountry;

    /**
     * Gets the value of the customerIPCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerIPCountry() {
        return customerIPCountry;
    }

    /**
     * Sets the value of the customerIPCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerIPCountry(String value) {
        this.customerIPCountry = value;
    }

    /**
     * Gets the value of the ipCountryMatchesIssuingCountry property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIPCountryMatchesIssuingCountry() {
        return ipCountryMatchesIssuingCountry;
    }

    /**
     * Sets the value of the ipCountryMatchesIssuingCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIPCountryMatchesIssuingCountry(Boolean value) {
        this.ipCountryMatchesIssuingCountry = value;
    }

}
