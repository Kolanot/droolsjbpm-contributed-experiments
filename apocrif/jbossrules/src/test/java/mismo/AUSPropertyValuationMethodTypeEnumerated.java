//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.3-b01-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.05.21 at 09:59:49 PM BST 
//


package mismo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AUS_PropertyValuationMethodTypeEnumerated.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AUS_PropertyValuationMethodTypeEnumerated">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FNM1004"/>
 *     &lt;enumeration value="EmployeeRelocationCouncil2001"/>
 *     &lt;enumeration value="FNM1073"/>
 *     &lt;enumeration value="FNM1025"/>
 *     &lt;enumeration value="FNM2055Exterior"/>
 *     &lt;enumeration value="FNM2065"/>
 *     &lt;enumeration value="FRE2070Interior"/>
 *     &lt;enumeration value="FRE2070Exterior"/>
 *     &lt;enumeration value="FNM2075"/>
 *     &lt;enumeration value="BrokerPriceOpinion"/>
 *     &lt;enumeration value="AutomatedValuationModel"/>
 *     &lt;enumeration value="TaxValuation"/>
 *     &lt;enumeration value="DriveBy"/>
 *     &lt;enumeration value="FullAppraisal"/>
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="FNM2055InteriorAndExterior"/>
 *     &lt;enumeration value="FNM2095Exterior"/>
 *     &lt;enumeration value="FNM2095InteriorAndExterior"/>
 *     &lt;enumeration value="PriorAppraisalUsed"/>
 *     &lt;enumeration value="Form261805"/>
 *     &lt;enumeration value="Form268712"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AUS_PropertyValuationMethodTypeEnumerated")
@XmlEnum
public enum AUSPropertyValuationMethodTypeEnumerated {

    @XmlEnumValue("FNM1004")
    FNM_1004("FNM1004"),
    @XmlEnumValue("EmployeeRelocationCouncil2001")
    EMPLOYEE_RELOCATION_COUNCIL_2001("EmployeeRelocationCouncil2001"),
    @XmlEnumValue("FNM1073")
    FNM_1073("FNM1073"),
    @XmlEnumValue("FNM1025")
    FNM_1025("FNM1025"),
    @XmlEnumValue("FNM2055Exterior")
    FNM_2055_EXTERIOR("FNM2055Exterior"),
    @XmlEnumValue("FNM2065")
    FNM_2065("FNM2065"),
    @XmlEnumValue("FRE2070Interior")
    FRE_2070_INTERIOR("FRE2070Interior"),
    @XmlEnumValue("FRE2070Exterior")
    FRE_2070_EXTERIOR("FRE2070Exterior"),
    @XmlEnumValue("FNM2075")
    FNM_2075("FNM2075"),
    @XmlEnumValue("BrokerPriceOpinion")
    BROKER_PRICE_OPINION("BrokerPriceOpinion"),
    @XmlEnumValue("AutomatedValuationModel")
    AUTOMATED_VALUATION_MODEL("AutomatedValuationModel"),
    @XmlEnumValue("TaxValuation")
    TAX_VALUATION("TaxValuation"),
    @XmlEnumValue("DriveBy")
    DRIVE_BY("DriveBy"),
    @XmlEnumValue("FullAppraisal")
    FULL_APPRAISAL("FullAppraisal"),
    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("FNM2055InteriorAndExterior")
    FNM_2055_INTERIOR_AND_EXTERIOR("FNM2055InteriorAndExterior"),
    @XmlEnumValue("FNM2095Exterior")
    FNM_2095_EXTERIOR("FNM2095Exterior"),
    @XmlEnumValue("FNM2095InteriorAndExterior")
    FNM_2095_INTERIOR_AND_EXTERIOR("FNM2095InteriorAndExterior"),
    @XmlEnumValue("PriorAppraisalUsed")
    PRIOR_APPRAISAL_USED("PriorAppraisalUsed"),
    @XmlEnumValue("Form261805")
    FORM_261805("Form261805"),
    @XmlEnumValue("Form268712")
    FORM_268712("Form268712"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    AUSPropertyValuationMethodTypeEnumerated(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AUSPropertyValuationMethodTypeEnumerated fromValue(String v) {
        for (AUSPropertyValuationMethodTypeEnumerated c: AUSPropertyValuationMethodTypeEnumerated.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}