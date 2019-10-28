
package org.datacontract.schemas._2004._07.bbs_epayment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Result complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Result"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AuthenticatedStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AuthenticatedWith" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AuthorizationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AuthorizationId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CardExpiryDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CustomerIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ExecutionTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="IssuerCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IssuerCountryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IssuerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MerchantId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PanHash" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RecurringType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ResponseCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ResponseSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ResponseText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SessionNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TransactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Result", propOrder = {
    "authenticatedStatus",
    "authenticatedWith",
    "authorizationCode",
    "authorizationId",
    "cardExpiryDate",
    "customerIP",
    "executionTime",
    "issuerCountry",
    "issuerCountryCode",
    "issuerId",
    "merchantId",
    "panHash",
    "recurringType",
    "responseCode",
    "responseSource",
    "responseText",
    "sessionId",
    "sessionNumber",
    "transactionId"
})
public class Result {

    @XmlElement(name = "AuthenticatedStatus", nillable = true)
    protected String authenticatedStatus;
    @XmlElement(name = "AuthenticatedWith", nillable = true)
    protected String authenticatedWith;
    @XmlElement(name = "AuthorizationCode", nillable = true)
    protected String authorizationCode;
    @XmlElement(name = "AuthorizationId", nillable = true)
    protected String authorizationId;
    @XmlElement(name = "CardExpiryDate", nillable = true)
    protected String cardExpiryDate;
    @XmlElement(name = "CustomerIP", nillable = true)
    protected String customerIP;
    @XmlElement(name = "ExecutionTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar executionTime;
    @XmlElement(name = "IssuerCountry", nillable = true)
    protected String issuerCountry;
    @XmlElement(name = "IssuerCountryCode", nillable = true)
    protected String issuerCountryCode;
    @XmlElement(name = "IssuerId", nillable = true)
    protected String issuerId;
    @XmlElement(name = "MerchantId", nillable = true)
    protected String merchantId;
    @XmlElement(name = "PanHash", nillable = true)
    protected String panHash;
    @XmlElement(name = "RecurringType", nillable = true)
    protected String recurringType;
    @XmlElement(name = "ResponseCode", nillable = true)
    protected String responseCode;
    @XmlElement(name = "ResponseSource", nillable = true)
    protected String responseSource;
    @XmlElement(name = "ResponseText", nillable = true)
    protected String responseText;
    @XmlElement(name = "SessionId", nillable = true)
    protected String sessionId;
    @XmlElement(name = "SessionNumber", nillable = true)
    protected String sessionNumber;
    @XmlElement(name = "TransactionId", nillable = true)
    protected String transactionId;

    /**
     * Gets the value of the authenticatedStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthenticatedStatus() {
        return authenticatedStatus;
    }

    /**
     * Sets the value of the authenticatedStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthenticatedStatus(String value) {
        this.authenticatedStatus = value;
    }

    /**
     * Gets the value of the authenticatedWith property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthenticatedWith() {
        return authenticatedWith;
    }

    /**
     * Sets the value of the authenticatedWith property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthenticatedWith(String value) {
        this.authenticatedWith = value;
    }

    /**
     * Gets the value of the authorizationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorizationCode() {
        return authorizationCode;
    }

    /**
     * Sets the value of the authorizationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorizationCode(String value) {
        this.authorizationCode = value;
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
     * Gets the value of the cardExpiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    /**
     * Sets the value of the cardExpiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardExpiryDate(String value) {
        this.cardExpiryDate = value;
    }

    /**
     * Gets the value of the customerIP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerIP() {
        return customerIP;
    }

    /**
     * Sets the value of the customerIP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerIP(String value) {
        this.customerIP = value;
    }

    /**
     * Gets the value of the executionTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExecutionTime() {
        return executionTime;
    }

    /**
     * Sets the value of the executionTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExecutionTime(XMLGregorianCalendar value) {
        this.executionTime = value;
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
     * Gets the value of the issuerCountryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuerCountryCode() {
        return issuerCountryCode;
    }

    /**
     * Sets the value of the issuerCountryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuerCountryCode(String value) {
        this.issuerCountryCode = value;
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

    /**
     * Gets the value of the merchantId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * Sets the value of the merchantId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantId(String value) {
        this.merchantId = value;
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
     * Gets the value of the recurringType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecurringType() {
        return recurringType;
    }

    /**
     * Sets the value of the recurringType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecurringType(String value) {
        this.recurringType = value;
    }

    /**
     * Gets the value of the responseCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the value of the responseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseCode(String value) {
        this.responseCode = value;
    }

    /**
     * Gets the value of the responseSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseSource() {
        return responseSource;
    }

    /**
     * Sets the value of the responseSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseSource(String value) {
        this.responseSource = value;
    }

    /**
     * Gets the value of the responseText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseText() {
        return responseText;
    }

    /**
     * Sets the value of the responseText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseText(String value) {
        this.responseText = value;
    }

    /**
     * Gets the value of the sessionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * Sets the value of the sessionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionId(String value) {
        this.sessionId = value;
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

}
