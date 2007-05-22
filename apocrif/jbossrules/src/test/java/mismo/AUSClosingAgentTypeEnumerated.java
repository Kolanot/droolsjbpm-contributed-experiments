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
 * <p>Java class for AUS_ClosingAgentTypeEnumerated.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AUS_ClosingAgentTypeEnumerated">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Attorney"/>
 *     &lt;enumeration value="ClosingAgent"/>
 *     &lt;enumeration value="EscrowCompany"/>
 *     &lt;enumeration value="Other"/>
 *     &lt;enumeration value="SettlementAgent"/>
 *     &lt;enumeration value="TitleCompany"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AUS_ClosingAgentTypeEnumerated")
@XmlEnum
public enum AUSClosingAgentTypeEnumerated {

    @XmlEnumValue("Attorney")
    ATTORNEY("Attorney"),
    @XmlEnumValue("ClosingAgent")
    CLOSING_AGENT("ClosingAgent"),
    @XmlEnumValue("EscrowCompany")
    ESCROW_COMPANY("EscrowCompany"),
    @XmlEnumValue("Other")
    OTHER("Other"),
    @XmlEnumValue("SettlementAgent")
    SETTLEMENT_AGENT("SettlementAgent"),
    @XmlEnumValue("TitleCompany")
    TITLE_COMPANY("TitleCompany");
    private final String value;

    AUSClosingAgentTypeEnumerated(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AUSClosingAgentTypeEnumerated fromValue(String v) {
        for (AUSClosingAgentTypeEnumerated c: AUSClosingAgentTypeEnumerated.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
