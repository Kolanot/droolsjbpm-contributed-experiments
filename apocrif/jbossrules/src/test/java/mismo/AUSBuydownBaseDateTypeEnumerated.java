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
 * <p>Java class for AUS_BuydownBaseDateTypeEnumerated.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AUS_BuydownBaseDateTypeEnumerated">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NoteDate"/>
 *     &lt;enumeration value="FirstPaymentDate"/>
 *     &lt;enumeration value="LastPaymentDate"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AUS_BuydownBaseDateTypeEnumerated")
@XmlEnum
public enum AUSBuydownBaseDateTypeEnumerated {

    @XmlEnumValue("NoteDate")
    NOTE_DATE("NoteDate"),
    @XmlEnumValue("FirstPaymentDate")
    FIRST_PAYMENT_DATE("FirstPaymentDate"),
    @XmlEnumValue("LastPaymentDate")
    LAST_PAYMENT_DATE("LastPaymentDate"),
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    AUSBuydownBaseDateTypeEnumerated(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AUSBuydownBaseDateTypeEnumerated fromValue(String v) {
        for (AUSBuydownBaseDateTypeEnumerated c: AUSBuydownBaseDateTypeEnumerated.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
