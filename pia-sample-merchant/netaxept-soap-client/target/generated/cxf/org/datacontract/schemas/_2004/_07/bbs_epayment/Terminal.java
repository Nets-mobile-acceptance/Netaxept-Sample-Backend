
package org.datacontract.schemas._2004._07.bbs_epayment;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Terminal complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Terminal"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="AutoAuth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="AutoSale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Design" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FeeList" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="FinancialOperation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Language" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Layout" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OrderDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PaymentData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PaymentMethodActionList" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}ArrayOfPaymentMethodAction" minOccurs="0"/&gt;
 *         &lt;element name="PaymentMethodList" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RedirectOnError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RedirectUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SinglePage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TemplateData" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}ArrayOfKeyValuePair" minOccurs="0"/&gt;
 *         &lt;element name="Vat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="WalletProviderId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Terminal", propOrder = {
    "autoAuth",
    "autoSale",
    "design",
    "feeList",
    "financialOperation",
    "language",
    "layout",
    "orderDescription",
    "paymentData",
    "paymentMethodActionList",
    "paymentMethodList",
    "redirectOnError",
    "redirectUrl",
    "singlePage",
    "templateData",
    "vat",
    "walletProviderId"
})
public class Terminal {

    @XmlElement(name = "AutoAuth", nillable = true)
    protected String autoAuth;
    @XmlElement(name = "AutoSale", nillable = true)
    protected String autoSale;
    @XmlElement(name = "Design", nillable = true)
    protected String design;
    @XmlElement(name = "FeeList", nillable = true)
    protected String feeList;
    @XmlElement(name = "FinancialOperation", nillable = true)
    protected String financialOperation;
    @XmlElement(name = "Language", nillable = true)
    protected String language;
    @XmlElement(name = "Layout", nillable = true)
    protected String layout;
    @XmlElement(name = "OrderDescription", nillable = true)
    protected String orderDescription;
    @XmlElement(name = "PaymentData", nillable = true)
    protected String paymentData;
    @XmlElement(name = "PaymentMethodActionList", nillable = true)
    protected ArrayOfPaymentMethodAction paymentMethodActionList;
    @XmlElement(name = "PaymentMethodList", nillable = true)
    protected String paymentMethodList;
    @XmlElement(name = "RedirectOnError", nillable = true)
    protected String redirectOnError;
    @XmlElement(name = "RedirectUrl", nillable = true)
    protected String redirectUrl;
    @XmlElement(name = "SinglePage", nillable = true)
    protected String singlePage;
    @XmlElement(name = "TemplateData", nillable = true)
    protected ArrayOfKeyValuePair templateData;
    @XmlElement(name = "Vat", nillable = true)
    protected String vat;
    @XmlElement(name = "WalletProviderId", nillable = true)
    protected String walletProviderId;

    /**
     * Gets the value of the autoAuth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutoAuth() {
        return autoAuth;
    }

    /**
     * Sets the value of the autoAuth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutoAuth(String value) {
        this.autoAuth = value;
    }

    /**
     * Gets the value of the autoSale property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutoSale() {
        return autoSale;
    }

    /**
     * Sets the value of the autoSale property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutoSale(String value) {
        this.autoSale = value;
    }

    /**
     * Gets the value of the design property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesign() {
        return design;
    }

    /**
     * Sets the value of the design property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesign(String value) {
        this.design = value;
    }

    /**
     * Gets the value of the feeList property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeList() {
        return feeList;
    }

    /**
     * Sets the value of the feeList property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeList(String value) {
        this.feeList = value;
    }

    /**
     * Gets the value of the financialOperation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinancialOperation() {
        return financialOperation;
    }

    /**
     * Sets the value of the financialOperation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinancialOperation(String value) {
        this.financialOperation = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the layout property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLayout() {
        return layout;
    }

    /**
     * Sets the value of the layout property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLayout(String value) {
        this.layout = value;
    }

    /**
     * Gets the value of the orderDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderDescription() {
        return orderDescription;
    }

    /**
     * Sets the value of the orderDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderDescription(String value) {
        this.orderDescription = value;
    }

    /**
     * Gets the value of the paymentData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentData() {
        return paymentData;
    }

    /**
     * Sets the value of the paymentData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentData(String value) {
        this.paymentData = value;
    }

    /**
     * Gets the value of the paymentMethodActionList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPaymentMethodAction }
     *     
     */
    public ArrayOfPaymentMethodAction getPaymentMethodActionList() {
        return paymentMethodActionList;
    }

    /**
     * Sets the value of the paymentMethodActionList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPaymentMethodAction }
     *     
     */
    public void setPaymentMethodActionList(ArrayOfPaymentMethodAction value) {
        this.paymentMethodActionList = value;
    }

    /**
     * Gets the value of the paymentMethodList property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentMethodList() {
        return paymentMethodList;
    }

    /**
     * Sets the value of the paymentMethodList property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentMethodList(String value) {
        this.paymentMethodList = value;
    }

    /**
     * Gets the value of the redirectOnError property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRedirectOnError() {
        return redirectOnError;
    }

    /**
     * Sets the value of the redirectOnError property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRedirectOnError(String value) {
        this.redirectOnError = value;
    }

    /**
     * Gets the value of the redirectUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRedirectUrl() {
        return redirectUrl;
    }

    /**
     * Sets the value of the redirectUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRedirectUrl(String value) {
        this.redirectUrl = value;
    }

    /**
     * Gets the value of the singlePage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSinglePage() {
        return singlePage;
    }

    /**
     * Sets the value of the singlePage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSinglePage(String value) {
        this.singlePage = value;
    }

    /**
     * Gets the value of the templateData property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfKeyValuePair }
     *     
     */
    public ArrayOfKeyValuePair getTemplateData() {
        return templateData;
    }

    /**
     * Sets the value of the templateData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfKeyValuePair }
     *     
     */
    public void setTemplateData(ArrayOfKeyValuePair value) {
        this.templateData = value;
    }

    /**
     * Gets the value of the vat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVat() {
        return vat;
    }

    /**
     * Sets the value of the vat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVat(String value) {
        this.vat = value;
    }

    /**
     * Gets the value of the walletProviderId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWalletProviderId() {
        return walletProviderId;
    }

    /**
     * Sets the value of the walletProviderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWalletProviderId(String value) {
        this.walletProviderId = value;
    }

}
