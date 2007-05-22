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
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for AUS_BORROWER_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AUS_BORROWER_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="_ALIAS" type="{}AUS_ALIAS_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="_MAIL_TO" type="{}AUS_MAIL_TO_Type" minOccurs="0"/>
 *         &lt;element name="_RESIDENCE" type="{}AUS_RESIDENCE_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CURRENT_INCOME" type="{}AUS_CURRENT_INCOME_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DECLARATION" type="{}AUS_DECLARATION_Type" minOccurs="0"/>
 *         &lt;element name="DEPENDENT" type="{}AUS_DEPENDENT_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="EMPLOYER" type="{}AUS_EMPLOYER_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="FHA_VA_BORROWER" type="{}AUS_FHA_VA_BORROWER_Type" minOccurs="0"/>
 *         &lt;element name="GOVERNMENT_MONITORING" type="{}AUS_GOVERNMENT_MONITORING_Type" minOccurs="0"/>
 *         &lt;element name="PRESENT_HOUSING_EXPENSE" type="{}AUS_PRESENT_HOUSING_EXPENSE_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SUMMARY" type="{}AUS_SUMMARY_Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="VA_BORROWER" type="{}AUS_VA_BORROWER_Type" minOccurs="0"/>
 *         &lt;element name="CONTACT_POINT" type="{}AUS_CONTACT_POINT_Type" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="BorrowerID" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="JointAssetBorrowerID" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;attribute name="_FirstName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="_MiddleName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="_LastName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="_NameSuffix" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="_AgeAtApplicationYears" type="{}AUS_MISMONumeric" />
 *       &lt;attribute name="_BirthDate" type="{}AUS_MISMODateTime" />
 *       &lt;attribute name="_ApplicationSignedDate" type="{}AUS_MISMODateTime" />
 *       &lt;attribute name="_HomeTelephoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="_PrintPositionType" type="{}AUS_BorrowerPrintPositionTypeEnumerated" />
 *       &lt;attribute name="_SSN" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DependentCount" type="{}AUS_MISMONumeric" />
 *       &lt;attribute name="JointAssetLiabilityReportingType" type="{}AUS_JointAssetLiabilityReportingTypeEnumerated" />
 *       &lt;attribute name="MaritalStatusType" type="{}AUS_MaritalStatusTypeEnumerated" />
 *       &lt;attribute name="SchoolingYears" type="{}AUS_MISMONumeric" />
 *       &lt;attribute name="CreditReportIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AUS_BORROWER_Type", propOrder = {
    "alias",
    "mailto",
    "residence",
    "currentincome",
    "declaration",
    "dependent",
    "employer",
    "fhavaborrower",
    "governmentmonitoring",
    "presenthousingexpense",
    "summary",
    "vaborrower",
    "contactpoint"
})
public class AUSBORROWERType {

    @XmlElement(name = "_ALIAS")
    protected List<AUSALIASType> alias;
    @XmlElement(name = "_MAIL_TO")
    protected AUSMAILTOType mailto;
    @XmlElement(name = "_RESIDENCE")
    protected List<AUSRESIDENCEType> residence;
    @XmlElement(name = "CURRENT_INCOME")
    protected List<AUSCURRENTINCOMEType> currentincome;
    @XmlElement(name = "DECLARATION")
    protected AUSDECLARATIONType declaration;
    @XmlElement(name = "DEPENDENT")
    protected List<AUSDEPENDENTType> dependent;
    @XmlElement(name = "EMPLOYER")
    protected List<AUSEMPLOYERType> employer;
    @XmlElement(name = "FHA_VA_BORROWER")
    protected AUSFHAVABORROWERType fhavaborrower;
    @XmlElement(name = "GOVERNMENT_MONITORING")
    protected AUSGOVERNMENTMONITORINGType governmentmonitoring;
    @XmlElement(name = "PRESENT_HOUSING_EXPENSE")
    protected List<AUSPRESENTHOUSINGEXPENSEType> presenthousingexpense;
    @XmlElement(name = "SUMMARY")
    protected List<AUSSUMMARYType> summary;
    @XmlElement(name = "VA_BORROWER")
    protected AUSVABORROWERType vaborrower;
    @XmlElement(name = "CONTACT_POINT")
    protected List<AUSCONTACTPOINTType> contactpoint;
    @XmlAttribute(name = "BorrowerID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String borrowerID;
    @XmlAttribute(name = "JointAssetBorrowerID")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object jointAssetBorrowerID;
    @XmlAttribute(name = "_FirstName", required = true)
    protected String firstName;
    @XmlAttribute(name = "_MiddleName")
    protected String middleName;
    @XmlAttribute(name = "_LastName", required = true)
    protected String lastName;
    @XmlAttribute(name = "_NameSuffix")
    protected String nameSuffix;
    @XmlAttribute(name = "_AgeAtApplicationYears")
    protected String ageAtApplicationYears;
    @XmlAttribute(name = "_BirthDate")
    protected String birthDate;
    @XmlAttribute(name = "_ApplicationSignedDate")
    protected String applicationSignedDate;
    @XmlAttribute(name = "_HomeTelephoneNumber")
    protected String homeTelephoneNumber;
    @XmlAttribute(name = "_PrintPositionType")
    protected AUSBorrowerPrintPositionTypeEnumerated printPositionType;
    @XmlAttribute(name = "_SSN", required = true)
    protected String ssn;
    @XmlAttribute(name = "DependentCount")
    protected String dependentCount;
    @XmlAttribute(name = "JointAssetLiabilityReportingType")
    protected AUSJointAssetLiabilityReportingTypeEnumerated jointAssetLiabilityReportingType;
    @XmlAttribute(name = "MaritalStatusType")
    protected AUSMaritalStatusTypeEnumerated maritalStatusType;
    @XmlAttribute(name = "SchoolingYears")
    protected String schoolingYears;
    @XmlAttribute(name = "CreditReportIdentifier")
    protected String creditReportIdentifier;

    /**
     * Gets the value of the alias property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the alias property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getALIAS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AUSALIASType }
     * 
     * 
     */
    public List<AUSALIASType> getALIAS() {
        if (alias == null) {
            alias = new ArrayList<AUSALIASType>();
        }
        return this.alias;
    }

    /**
     * Gets the value of the mailto property.
     * 
     * @return
     *     possible object is
     *     {@link AUSMAILTOType }
     *     
     */
    public AUSMAILTOType getMAILTO() {
        return mailto;
    }

    /**
     * Sets the value of the mailto property.
     * 
     * @param value
     *     allowed object is
     *     {@link AUSMAILTOType }
     *     
     */
    public void setMAILTO(AUSMAILTOType value) {
        this.mailto = value;
    }

    /**
     * Gets the value of the residence property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the residence property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRESIDENCE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AUSRESIDENCEType }
     * 
     * 
     */
    public List<AUSRESIDENCEType> getRESIDENCE() {
        if (residence == null) {
            residence = new ArrayList<AUSRESIDENCEType>();
        }
        return this.residence;
    }

    /**
     * Gets the value of the currentincome property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the currentincome property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCURRENTINCOME().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AUSCURRENTINCOMEType }
     * 
     * 
     */
    public List<AUSCURRENTINCOMEType> getCURRENTINCOME() {
        if (currentincome == null) {
            currentincome = new ArrayList<AUSCURRENTINCOMEType>();
        }
        return this.currentincome;
    }

    /**
     * Gets the value of the declaration property.
     * 
     * @return
     *     possible object is
     *     {@link AUSDECLARATIONType }
     *     
     */
    public AUSDECLARATIONType getDECLARATION() {
        return declaration;
    }

    /**
     * Sets the value of the declaration property.
     * 
     * @param value
     *     allowed object is
     *     {@link AUSDECLARATIONType }
     *     
     */
    public void setDECLARATION(AUSDECLARATIONType value) {
        this.declaration = value;
    }

    /**
     * Gets the value of the dependent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dependent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDEPENDENT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AUSDEPENDENTType }
     * 
     * 
     */
    public List<AUSDEPENDENTType> getDEPENDENT() {
        if (dependent == null) {
            dependent = new ArrayList<AUSDEPENDENTType>();
        }
        return this.dependent;
    }

    /**
     * Gets the value of the employer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the employer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEMPLOYER().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AUSEMPLOYERType }
     * 
     * 
     */
    public List<AUSEMPLOYERType> getEMPLOYER() {
        if (employer == null) {
            employer = new ArrayList<AUSEMPLOYERType>();
        }
        return this.employer;
    }

    /**
     * Gets the value of the fhavaborrower property.
     * 
     * @return
     *     possible object is
     *     {@link AUSFHAVABORROWERType }
     *     
     */
    public AUSFHAVABORROWERType getFHAVABORROWER() {
        return fhavaborrower;
    }

    /**
     * Sets the value of the fhavaborrower property.
     * 
     * @param value
     *     allowed object is
     *     {@link AUSFHAVABORROWERType }
     *     
     */
    public void setFHAVABORROWER(AUSFHAVABORROWERType value) {
        this.fhavaborrower = value;
    }

    /**
     * Gets the value of the governmentmonitoring property.
     * 
     * @return
     *     possible object is
     *     {@link AUSGOVERNMENTMONITORINGType }
     *     
     */
    public AUSGOVERNMENTMONITORINGType getGOVERNMENTMONITORING() {
        return governmentmonitoring;
    }

    /**
     * Sets the value of the governmentmonitoring property.
     * 
     * @param value
     *     allowed object is
     *     {@link AUSGOVERNMENTMONITORINGType }
     *     
     */
    public void setGOVERNMENTMONITORING(AUSGOVERNMENTMONITORINGType value) {
        this.governmentmonitoring = value;
    }

    /**
     * Gets the value of the presenthousingexpense property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the presenthousingexpense property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPRESENTHOUSINGEXPENSE().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AUSPRESENTHOUSINGEXPENSEType }
     * 
     * 
     */
    public List<AUSPRESENTHOUSINGEXPENSEType> getPRESENTHOUSINGEXPENSE() {
        if (presenthousingexpense == null) {
            presenthousingexpense = new ArrayList<AUSPRESENTHOUSINGEXPENSEType>();
        }
        return this.presenthousingexpense;
    }

    /**
     * Gets the value of the summary property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the summary property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSUMMARY().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AUSSUMMARYType }
     * 
     * 
     */
    public List<AUSSUMMARYType> getSUMMARY() {
        if (summary == null) {
            summary = new ArrayList<AUSSUMMARYType>();
        }
        return this.summary;
    }

    /**
     * Gets the value of the vaborrower property.
     * 
     * @return
     *     possible object is
     *     {@link AUSVABORROWERType }
     *     
     */
    public AUSVABORROWERType getVABORROWER() {
        return vaborrower;
    }

    /**
     * Sets the value of the vaborrower property.
     * 
     * @param value
     *     allowed object is
     *     {@link AUSVABORROWERType }
     *     
     */
    public void setVABORROWER(AUSVABORROWERType value) {
        this.vaborrower = value;
    }

    /**
     * Gets the value of the contactpoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contactpoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCONTACTPOINT().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AUSCONTACTPOINTType }
     * 
     * 
     */
    public List<AUSCONTACTPOINTType> getCONTACTPOINT() {
        if (contactpoint == null) {
            contactpoint = new ArrayList<AUSCONTACTPOINTType>();
        }
        return this.contactpoint;
    }

    /**
     * Gets the value of the borrowerID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBorrowerID() {
        return borrowerID;
    }

    /**
     * Sets the value of the borrowerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBorrowerID(String value) {
        this.borrowerID = value;
    }

    /**
     * Gets the value of the jointAssetBorrowerID property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getJointAssetBorrowerID() {
        return jointAssetBorrowerID;
    }

    /**
     * Sets the value of the jointAssetBorrowerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setJointAssetBorrowerID(Object value) {
        this.jointAssetBorrowerID = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the middleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Sets the value of the middleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMiddleName(String value) {
        this.middleName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the nameSuffix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameSuffix() {
        return nameSuffix;
    }

    /**
     * Sets the value of the nameSuffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameSuffix(String value) {
        this.nameSuffix = value;
    }

    /**
     * Gets the value of the ageAtApplicationYears property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgeAtApplicationYears() {
        return ageAtApplicationYears;
    }

    /**
     * Sets the value of the ageAtApplicationYears property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgeAtApplicationYears(String value) {
        this.ageAtApplicationYears = value;
    }

    /**
     * Gets the value of the birthDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the value of the birthDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthDate(String value) {
        this.birthDate = value;
    }

    /**
     * Gets the value of the applicationSignedDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationSignedDate() {
        return applicationSignedDate;
    }

    /**
     * Sets the value of the applicationSignedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationSignedDate(String value) {
        this.applicationSignedDate = value;
    }

    /**
     * Gets the value of the homeTelephoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHomeTelephoneNumber() {
        return homeTelephoneNumber;
    }

    /**
     * Sets the value of the homeTelephoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHomeTelephoneNumber(String value) {
        this.homeTelephoneNumber = value;
    }

    /**
     * Gets the value of the printPositionType property.
     * 
     * @return
     *     possible object is
     *     {@link AUSBorrowerPrintPositionTypeEnumerated }
     *     
     */
    public AUSBorrowerPrintPositionTypeEnumerated getPrintPositionType() {
        return printPositionType;
    }

    /**
     * Sets the value of the printPositionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AUSBorrowerPrintPositionTypeEnumerated }
     *     
     */
    public void setPrintPositionType(AUSBorrowerPrintPositionTypeEnumerated value) {
        this.printPositionType = value;
    }

    /**
     * Gets the value of the ssn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSSN() {
        return ssn;
    }

    /**
     * Sets the value of the ssn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSSN(String value) {
        this.ssn = value;
    }

    /**
     * Gets the value of the dependentCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDependentCount() {
        return dependentCount;
    }

    /**
     * Sets the value of the dependentCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDependentCount(String value) {
        this.dependentCount = value;
    }

    /**
     * Gets the value of the jointAssetLiabilityReportingType property.
     * 
     * @return
     *     possible object is
     *     {@link AUSJointAssetLiabilityReportingTypeEnumerated }
     *     
     */
    public AUSJointAssetLiabilityReportingTypeEnumerated getJointAssetLiabilityReportingType() {
        return jointAssetLiabilityReportingType;
    }

    /**
     * Sets the value of the jointAssetLiabilityReportingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AUSJointAssetLiabilityReportingTypeEnumerated }
     *     
     */
    public void setJointAssetLiabilityReportingType(AUSJointAssetLiabilityReportingTypeEnumerated value) {
        this.jointAssetLiabilityReportingType = value;
    }

    /**
     * Gets the value of the maritalStatusType property.
     * 
     * @return
     *     possible object is
     *     {@link AUSMaritalStatusTypeEnumerated }
     *     
     */
    public AUSMaritalStatusTypeEnumerated getMaritalStatusType() {
        return maritalStatusType;
    }

    /**
     * Sets the value of the maritalStatusType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AUSMaritalStatusTypeEnumerated }
     *     
     */
    public void setMaritalStatusType(AUSMaritalStatusTypeEnumerated value) {
        this.maritalStatusType = value;
    }

    /**
     * Gets the value of the schoolingYears property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchoolingYears() {
        return schoolingYears;
    }

    /**
     * Sets the value of the schoolingYears property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchoolingYears(String value) {
        this.schoolingYears = value;
    }

    /**
     * Gets the value of the creditReportIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditReportIdentifier() {
        return creditReportIdentifier;
    }

    /**
     * Sets the value of the creditReportIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditReportIdentifier(String value) {
        this.creditReportIdentifier = value;
    }

}
