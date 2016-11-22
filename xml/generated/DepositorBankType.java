//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.11.22 at 01:27:07 PM MAGT 
//


package generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DepositorBankType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DepositorBankType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="depositor" type="{}DepositorType"/>
 *         &lt;element name="bank-deposits" type="{}BankDepositsType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DepositorBankType", propOrder = {
    "depositor",
    "bankDeposits"
})
public class DepositorBankType {

    @XmlElement(required = true)
    protected DepositorType depositor;
    @XmlElement(name = "bank-deposits", required = true)
    protected List<BankDepositsType> bankDeposits;

    /**
     * Gets the value of the depositor property.
     * 
     * @return
     *     possible object is
     *     {@link DepositorType }
     *     
     */
    public DepositorType getDepositor() {
        return depositor;
    }

    /**
     * Sets the value of the depositor property.
     * 
     * @param value
     *     allowed object is
     *     {@link DepositorType }
     *     
     */
    public void setDepositor(DepositorType value) {
        this.depositor = value;
    }

    /**
     * Gets the value of the bankDeposits property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bankDeposits property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBankDeposits().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BankDepositsType }
     * 
     * 
     */
    public List<BankDepositsType> getBankDeposits() {
        if (bankDeposits == null) {
            bankDeposits = new ArrayList<BankDepositsType>();
        }
        return this.bankDeposits;
    }

}