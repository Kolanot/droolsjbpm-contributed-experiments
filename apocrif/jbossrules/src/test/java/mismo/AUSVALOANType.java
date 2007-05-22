//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.3-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.05.21 at 09:59:49 PM BST 
//


package mismo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for AUS_VA_LOAN_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AUS_VA_LOAN_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="_ID" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="VABorrowerCoBorrowerMarriedIndicator" type="{}AUS_MISMOIndicatorType" />
 *       &lt;attribute name="BorrowerFundingFeePercent" type="{}AUS_MISMONumeric" />
 *       &lt;attribute name="VAEntitlementAmount" type="{}AUS_MISMOMoney" />
 *       &lt;attribute name="VAMaintenanceExpenseMonthlyAmount" type="{}AUS_MISMOMoney" />
 *       &lt;attribute name="VAResidualIncomeAmount" type="{}AUS_MISMOMoney" />
 *       &lt;attribute name="VAUtilityExpenseMonthlyAmount" type="{}AUS_MISMOMoney" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AUS_VA_LOAN_Type")
public class AUSVALOANType {

    @XmlAttribute(name = "_ID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "VABorrowerCoBorrowerMarriedIndicator")
    protected String vaBorrowerCoBorrowerMarriedIndicator;
    @XmlAttribute(name = "BorrowerFundingFeePercent")
    protected String borrowerFundingFeePercent;
    @XmlAttribute(name = "VAEntitlementAmount")
    protected String vaEntitlementAmount;
    @XmlAttribute(name = "VAMaintenanceExpenseMonthlyAmount")
    protected String vaMaintenanceExpenseMonthlyAmount;
    @XmlAttribute(name = "VAResidualIncomeAmount")
    protected String vaResidualIncomeAmount;
    @XmlAttribute(name = "VAUtilityExpenseMonthlyAmount")
    protected String vaUtilityExpenseMonthlyAmount;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setID(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the vaBorrowerCoBorrowerMarriedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVABorrowerCoBorrowerMarriedIndicator() {
        return vaBorrowerCoBorrowerMarriedIndicator;
    }

    /**
     * Sets the value of the vaBorrowerCoBorrowerMarriedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVABorrowerCoBorrowerMarriedIndicator(String value) {
        this.vaBorrowerCoBorrowerMarriedIndicator = value;
    }

    /**
     * Gets the value of the borrowerFundingFeePercent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorrowerFundingFeePercent() {
        return borrowerFundingFeePercent;
    }

    /**
     * Sets the value of the borrowerFundingFeePercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorrowerFundingFeePercent(String value) {
        this.borrowerFundingFeePercent = value;
    }

    /**
     * Gets the value of the vaEntitlementAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVAEntitlementAmount() {
        return vaEntitlementAmount;
    }

    /**
     * Sets the value of the vaEntitlementAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVAEntitlementAmount(String value) {
        this.vaEntitlementAmount = value;
    }

    /**
     * Gets the value of the vaMaintenanceExpenseMonthlyAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVAMaintenanceExpenseMonthlyAmount() {
        return vaMaintenanceExpenseMonthlyAmount;
    }

    /**
     * Sets the value of the vaMaintenanceExpenseMonthlyAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVAMaintenanceExpenseMonthlyAmount(String value) {
        this.vaMaintenanceExpenseMonthlyAmount = value;
    }

    /**
     * Gets the value of the vaResidualIncomeAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVAResidualIncomeAmount() {
        return vaResidualIncomeAmount;
    }

    /**
     * Sets the value of the vaResidualIncomeAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVAResidualIncomeAmount(String value) {
        this.vaResidualIncomeAmount = value;
    }

    /**
     * Gets the value of the vaUtilityExpenseMonthlyAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVAUtilityExpenseMonthlyAmount() {
        return vaUtilityExpenseMonthlyAmount;
    }

    /**
     * Sets the value of the vaUtilityExpenseMonthlyAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVAUtilityExpenseMonthlyAmount(String value) {
        this.vaUtilityExpenseMonthlyAmount = value;
    }

}
