//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.3-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.05.21 at 09:59:49 PM BST 
//


package mismo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for AUS_DECLARATION_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AUS_DECLARATION_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_EXPLANATION" type="{}AUS_EXPLANATION_Type" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="_ID" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="AlimonyChildSupportObligationIndicator" type="{}AUS_MISMOIndicatorType" />
 *       &lt;attribute name="BankruptcyIndicator" type="{}AUS_MISMOIndicatorType" />
 *       &lt;attribute name="BorrowedDownPaymentIndicator" type="{}AUS_MISMOIndicatorType" />
 *       &lt;attribute name="CitizenshipResidencyType" type="{}AUS_CitizenshipResidencyTypeEnumerated" />
 *       &lt;attribute name="CoMakerEndorserOfNoteIndicator" type="{}AUS_MISMOIndicatorType" />
 *       &lt;attribute name="HomeownerPastThreeYearsType" type="{}AUS_HomeownerPastThreeYearsTypeEnumerated" />
 *       &lt;attribute name="IntentToOccupyType" type="{}AUS_IntentToOccupyTypeEnumerated" />
 *       &lt;attribute name="LoanForeclosureOrJudgementIndicator" type="{}AUS_MISMOIndicatorType" />
 *       &lt;attribute name="OutstandingJudgementsIndicator" type="{}AUS_MISMOIndicatorType" />
 *       &lt;attribute name="PartyToLawsuitIndicator" type="{}AUS_MISMOIndicatorType" />
 *       &lt;attribute name="PresentlyDelinquentIndicator" type="{}AUS_MISMOIndicatorType" />
 *       &lt;attribute name="PriorPropertyTitleType" type="{}AUS_PriorPropertyTitleTypeEnumerated" />
 *       &lt;attribute name="PriorPropertyUsageType" type="{}AUS_PriorPropertyUsageTypeEnumerated" />
 *       &lt;attribute name="PropertyForeclosedPastSevenYearsIndicator" type="{}AUS_MISMOIndicatorType" />
 *       &lt;attribute name="BorrowerFirstTimeHomebuyerIndicator" type="{}AUS_MISMOIndicatorType" />
 *       &lt;attribute name="LoanForeclosureOrJudgmentIndicator" type="{}AUS_MISMOIndicatorType" />
 *       &lt;attribute name="OutstandingJudgmentsIndicator" type="{}AUS_MISMOIndicatorType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AUS_DECLARATION_Type", propOrder = {
    "explanation"
})
public class AUSDECLARATIONType {

    @XmlElement(name = "_EXPLANATION")
    protected List<AUSEXPLANATIONType> explanation;
    @XmlAttribute(name = "_ID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "AlimonyChildSupportObligationIndicator")
    protected String alimonyChildSupportObligationIndicator;
    @XmlAttribute(name = "BankruptcyIndicator")
    protected String bankruptcyIndicator;
    @XmlAttribute(name = "BorrowedDownPaymentIndicator")
    protected String borrowedDownPaymentIndicator;
    @XmlAttribute(name = "CitizenshipResidencyType")
    protected AUSCitizenshipResidencyTypeEnumerated citizenshipResidencyType;
    @XmlAttribute(name = "CoMakerEndorserOfNoteIndicator")
    protected String coMakerEndorserOfNoteIndicator;
    @XmlAttribute(name = "HomeownerPastThreeYearsType")
    protected AUSHomeownerPastThreeYearsTypeEnumerated homeownerPastThreeYearsType;
    @XmlAttribute(name = "IntentToOccupyType")
    protected AUSIntentToOccupyTypeEnumerated intentToOccupyType;
    @XmlAttribute(name = "LoanForeclosureOrJudgementIndicator")
    protected String loanForeclosureOrJudgementIndicator;
    @XmlAttribute(name = "OutstandingJudgementsIndicator")
    protected String outstandingJudgementsIndicator;
    @XmlAttribute(name = "PartyToLawsuitIndicator")
    protected String partyToLawsuitIndicator;
    @XmlAttribute(name = "PresentlyDelinquentIndicator")
    protected String presentlyDelinquentIndicator;
    @XmlAttribute(name = "PriorPropertyTitleType")
    protected AUSPriorPropertyTitleTypeEnumerated priorPropertyTitleType;
    @XmlAttribute(name = "PriorPropertyUsageType")
    protected AUSPriorPropertyUsageTypeEnumerated priorPropertyUsageType;
    @XmlAttribute(name = "PropertyForeclosedPastSevenYearsIndicator")
    protected String propertyForeclosedPastSevenYearsIndicator;
    @XmlAttribute(name = "BorrowerFirstTimeHomebuyerIndicator")
    protected String borrowerFirstTimeHomebuyerIndicator;
    @XmlAttribute(name = "LoanForeclosureOrJudgmentIndicator")
    protected String loanForeclosureOrJudgmentIndicator;
    @XmlAttribute(name = "OutstandingJudgmentsIndicator")
    protected String outstandingJudgmentsIndicator;

    /**
     * Gets the value of the explanation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the explanation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEXPLANATION().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AUSEXPLANATIONType }
     * 
     * 
     */
    public List<AUSEXPLANATIONType> getEXPLANATION() {
        if (explanation == null) {
            explanation = new ArrayList<AUSEXPLANATIONType>();
        }
        return this.explanation;
    }

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
     * Gets the value of the alimonyChildSupportObligationIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlimonyChildSupportObligationIndicator() {
        return alimonyChildSupportObligationIndicator;
    }

    /**
     * Sets the value of the alimonyChildSupportObligationIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlimonyChildSupportObligationIndicator(String value) {
        this.alimonyChildSupportObligationIndicator = value;
    }

    /**
     * Gets the value of the bankruptcyIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankruptcyIndicator() {
        return bankruptcyIndicator;
    }

    /**
     * Sets the value of the bankruptcyIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankruptcyIndicator(String value) {
        this.bankruptcyIndicator = value;
    }

    /**
     * Gets the value of the borrowedDownPaymentIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorrowedDownPaymentIndicator() {
        return borrowedDownPaymentIndicator;
    }

    /**
     * Sets the value of the borrowedDownPaymentIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorrowedDownPaymentIndicator(String value) {
        this.borrowedDownPaymentIndicator = value;
    }

    /**
     * Gets the value of the citizenshipResidencyType property.
     * 
     * @return
     *     possible object is
     *     {@link AUSCitizenshipResidencyTypeEnumerated }
     *     
     */
    public AUSCitizenshipResidencyTypeEnumerated getCitizenshipResidencyType() {
        return citizenshipResidencyType;
    }

    /**
     * Sets the value of the citizenshipResidencyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AUSCitizenshipResidencyTypeEnumerated }
     *     
     */
    public void setCitizenshipResidencyType(AUSCitizenshipResidencyTypeEnumerated value) {
        this.citizenshipResidencyType = value;
    }

    /**
     * Gets the value of the coMakerEndorserOfNoteIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoMakerEndorserOfNoteIndicator() {
        return coMakerEndorserOfNoteIndicator;
    }

    /**
     * Sets the value of the coMakerEndorserOfNoteIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoMakerEndorserOfNoteIndicator(String value) {
        this.coMakerEndorserOfNoteIndicator = value;
    }

    /**
     * Gets the value of the homeownerPastThreeYearsType property.
     * 
     * @return
     *     possible object is
     *     {@link AUSHomeownerPastThreeYearsTypeEnumerated }
     *     
     */
    public AUSHomeownerPastThreeYearsTypeEnumerated getHomeownerPastThreeYearsType() {
        return homeownerPastThreeYearsType;
    }

    /**
     * Sets the value of the homeownerPastThreeYearsType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AUSHomeownerPastThreeYearsTypeEnumerated }
     *     
     */
    public void setHomeownerPastThreeYearsType(AUSHomeownerPastThreeYearsTypeEnumerated value) {
        this.homeownerPastThreeYearsType = value;
    }

    /**
     * Gets the value of the intentToOccupyType property.
     * 
     * @return
     *     possible object is
     *     {@link AUSIntentToOccupyTypeEnumerated }
     *     
     */
    public AUSIntentToOccupyTypeEnumerated getIntentToOccupyType() {
        return intentToOccupyType;
    }

    /**
     * Sets the value of the intentToOccupyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AUSIntentToOccupyTypeEnumerated }
     *     
     */
    public void setIntentToOccupyType(AUSIntentToOccupyTypeEnumerated value) {
        this.intentToOccupyType = value;
    }

    /**
     * Gets the value of the loanForeclosureOrJudgementIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoanForeclosureOrJudgementIndicator() {
        return loanForeclosureOrJudgementIndicator;
    }

    /**
     * Sets the value of the loanForeclosureOrJudgementIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoanForeclosureOrJudgementIndicator(String value) {
        this.loanForeclosureOrJudgementIndicator = value;
    }

    /**
     * Gets the value of the outstandingJudgementsIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutstandingJudgementsIndicator() {
        return outstandingJudgementsIndicator;
    }

    /**
     * Sets the value of the outstandingJudgementsIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutstandingJudgementsIndicator(String value) {
        this.outstandingJudgementsIndicator = value;
    }

    /**
     * Gets the value of the partyToLawsuitIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartyToLawsuitIndicator() {
        return partyToLawsuitIndicator;
    }

    /**
     * Sets the value of the partyToLawsuitIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartyToLawsuitIndicator(String value) {
        this.partyToLawsuitIndicator = value;
    }

    /**
     * Gets the value of the presentlyDelinquentIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPresentlyDelinquentIndicator() {
        return presentlyDelinquentIndicator;
    }

    /**
     * Sets the value of the presentlyDelinquentIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPresentlyDelinquentIndicator(String value) {
        this.presentlyDelinquentIndicator = value;
    }

    /**
     * Gets the value of the priorPropertyTitleType property.
     * 
     * @return
     *     possible object is
     *     {@link AUSPriorPropertyTitleTypeEnumerated }
     *     
     */
    public AUSPriorPropertyTitleTypeEnumerated getPriorPropertyTitleType() {
        return priorPropertyTitleType;
    }

    /**
     * Sets the value of the priorPropertyTitleType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AUSPriorPropertyTitleTypeEnumerated }
     *     
     */
    public void setPriorPropertyTitleType(AUSPriorPropertyTitleTypeEnumerated value) {
        this.priorPropertyTitleType = value;
    }

    /**
     * Gets the value of the priorPropertyUsageType property.
     * 
     * @return
     *     possible object is
     *     {@link AUSPriorPropertyUsageTypeEnumerated }
     *     
     */
    public AUSPriorPropertyUsageTypeEnumerated getPriorPropertyUsageType() {
        return priorPropertyUsageType;
    }

    /**
     * Sets the value of the priorPropertyUsageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AUSPriorPropertyUsageTypeEnumerated }
     *     
     */
    public void setPriorPropertyUsageType(AUSPriorPropertyUsageTypeEnumerated value) {
        this.priorPropertyUsageType = value;
    }

    /**
     * Gets the value of the propertyForeclosedPastSevenYearsIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropertyForeclosedPastSevenYearsIndicator() {
        return propertyForeclosedPastSevenYearsIndicator;
    }

    /**
     * Sets the value of the propertyForeclosedPastSevenYearsIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropertyForeclosedPastSevenYearsIndicator(String value) {
        this.propertyForeclosedPastSevenYearsIndicator = value;
    }

    /**
     * Gets the value of the borrowerFirstTimeHomebuyerIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorrowerFirstTimeHomebuyerIndicator() {
        return borrowerFirstTimeHomebuyerIndicator;
    }

    /**
     * Sets the value of the borrowerFirstTimeHomebuyerIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorrowerFirstTimeHomebuyerIndicator(String value) {
        this.borrowerFirstTimeHomebuyerIndicator = value;
    }

    /**
     * Gets the value of the loanForeclosureOrJudgmentIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoanForeclosureOrJudgmentIndicator() {
        return loanForeclosureOrJudgmentIndicator;
    }

    /**
     * Sets the value of the loanForeclosureOrJudgmentIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoanForeclosureOrJudgmentIndicator(String value) {
        this.loanForeclosureOrJudgmentIndicator = value;
    }

    /**
     * Gets the value of the outstandingJudgmentsIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutstandingJudgmentsIndicator() {
        return outstandingJudgmentsIndicator;
    }

    /**
     * Sets the value of the outstandingJudgmentsIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutstandingJudgmentsIndicator(String value) {
        this.outstandingJudgmentsIndicator = value;
    }

}
