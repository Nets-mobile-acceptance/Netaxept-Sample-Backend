
package org.datacontract.schemas._2004._07.bbs_epayment;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfProcessRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfProcessRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ProcessRequest" type="{http://schemas.datacontract.org/2004/07/BBS.EPayment.ServiceLibrary}ProcessRequest" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfProcessRequest", propOrder = {
    "processRequest"
})
public class ArrayOfProcessRequest {

    @XmlElement(name = "ProcessRequest", nillable = true)
    protected List<ProcessRequest> processRequest;

    /**
     * Gets the value of the processRequest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the processRequest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProcessRequest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProcessRequest }
     * 
     * 
     */
    public List<ProcessRequest> getProcessRequest() {
        if (processRequest == null) {
            processRequest = new ArrayList<ProcessRequest>();
        }
        return this.processRequest;
    }

}
