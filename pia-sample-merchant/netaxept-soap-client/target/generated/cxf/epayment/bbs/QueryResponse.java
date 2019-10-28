
package epayment.bbs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="QueryResult" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}QueryResponse" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "queryResult"
})
@XmlRootElement(name = "QueryResponse")
public class QueryResponse {

    @XmlElement(name = "QueryResult", nillable = true)
    protected org.datacontract.schemas._2004._07.bbs_epayment.QueryResponse queryResult;

    /**
     * Gets the value of the queryResult property.
     * 
     * @return
     *     possible object is
     *     {@link org.datacontract.schemas._2004._07.bbs_epayment.QueryResponse }
     *     
     */
    public org.datacontract.schemas._2004._07.bbs_epayment.QueryResponse getQueryResult() {
        return queryResult;
    }

    /**
     * Sets the value of the queryResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link org.datacontract.schemas._2004._07.bbs_epayment.QueryResponse }
     *     
     */
    public void setQueryResult(org.datacontract.schemas._2004._07.bbs_epayment.QueryResponse value) {
        this.queryResult = value;
    }

}
