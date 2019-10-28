
package epayment.bbs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.datacontract.schemas._2004._07.bbs_epayment.ArrayOfProcessResponse;


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
 *         &lt;element name="BatchResult" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}ArrayOfProcessResponse" minOccurs="0"/&gt;
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
    "batchResult"
})
@XmlRootElement(name = "BatchResponse")
public class BatchResponse {

    @XmlElement(name = "BatchResult", nillable = true)
    protected ArrayOfProcessResponse batchResult;

    /**
     * Gets the value of the batchResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfProcessResponse }
     *     
     */
    public ArrayOfProcessResponse getBatchResult() {
        return batchResult;
    }

    /**
     * Sets the value of the batchResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfProcessResponse }
     *     
     */
    public void setBatchResult(ArrayOfProcessResponse value) {
        this.batchResult = value;
    }

}
