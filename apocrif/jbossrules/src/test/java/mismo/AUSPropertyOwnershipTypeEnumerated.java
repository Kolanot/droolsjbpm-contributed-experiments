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
 * <p>Java class for AUS_PropertyOwnershipTypeEnumerated.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AUS_PropertyOwnershipTypeEnumerated">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Condominium"/>
 *     &lt;enumeration value="CondominiumHotel"/>
 *     &lt;enumeration value="Cooperative"/>
 *     &lt;enumeration value="Other"/>
 *     &lt;enumeration value="Timeshare"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AUS_PropertyOwnershipTypeEnumerated")
@XmlEnum
public enum AUSPropertyOwnershipTypeEnumerated {

    @XmlEnumValue("Condominium")
    CONDOMINIUM("Condominium"),
    @XmlEnumValue("CondominiumHotel")
    CONDOMINIUM_HOTEL("CondominiumHotel"),
    @XmlEnumValue("Cooperative")
    COOPERATIVE("Cooperative"),
    @XmlEnumValue("Other")
    OTHER("Other"),
    @XmlEnumValue("Timeshare")
    TIMESHARE("Timeshare");
    private final String value;

    AUSPropertyOwnershipTypeEnumerated(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AUSPropertyOwnershipTypeEnumerated fromValue(String v) {
        for (AUSPropertyOwnershipTypeEnumerated c: AUSPropertyOwnershipTypeEnumerated.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
