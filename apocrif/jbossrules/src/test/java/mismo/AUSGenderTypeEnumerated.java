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
 * <p>Java class for AUS_GenderTypeEnumerated.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AUS_GenderTypeEnumerated">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Female"/>
 *     &lt;enumeration value="InformationNotProvidedUnknown"/>
 *     &lt;enumeration value="Male"/>
 *     &lt;enumeration value="NotApplicable"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AUS_GenderTypeEnumerated")
@XmlEnum
public enum AUSGenderTypeEnumerated {

    @XmlEnumValue("Female")
    FEMALE("Female"),
    @XmlEnumValue("InformationNotProvidedUnknown")
    INFORMATION_NOT_PROVIDED_UNKNOWN("InformationNotProvidedUnknown"),
    @XmlEnumValue("Male")
    MALE("Male"),
    @XmlEnumValue("NotApplicable")
    NOT_APPLICABLE("NotApplicable");
    private final String value;

    AUSGenderTypeEnumerated(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AUSGenderTypeEnumerated fromValue(String v) {
        for (AUSGenderTypeEnumerated c: AUSGenderTypeEnumerated.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
