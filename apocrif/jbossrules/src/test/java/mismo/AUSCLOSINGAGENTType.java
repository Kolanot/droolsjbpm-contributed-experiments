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
 * <p>Java class for AUS_CLOSING_AGENT_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AUS_CLOSING_AGENT_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CONTACT_DETAIL" type="{}AUS_CONTACT_DETAIL_Type" minOccurs="0"/>
 *         &lt;element name="NON_PERSON_ENTITY_DETAIL" type="{}AUS_NON_PERSON_ENTITY_DETAIL_Type" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="_ID" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="_City" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="_Country" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="_County" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="_OrderNumberIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="_PostalCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="_State" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="_StreetAddress" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="_StreetAddress2" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="_Type" type="{}AUS_ClosingAgentTypeEnumerated" />
 *       &lt;attribute name="_TypeOtherDescription" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="_UnparsedName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="NonPersonEntityIndicator" type="{}AUS_MISMOIndicatorType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AUS_CLOSING_AGENT_Type", propOrder = {
    "contactdetail",
    "nonpersonentitydetail"
})
public class AUSCLOSINGAGENTType {

    @XmlElement(name = "CONTACT_DETAIL")
    protected AUSCONTACTDETAILType contactdetail;
    @XmlElement(name = "NON_PERSON_ENTITY_DETAIL")
    protected List<AUSNONPERSONENTITYDETAILType> nonpersonentitydetail;
    @XmlAttribute(name = "_ID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "_City")
    protected String city;
    @XmlAttribute(name = "_Country")
    protected String country;
    @XmlAttribute(name = "_County")
    protected String county;
    @XmlAttribute(name = "_OrderNumberIdentifier")
    protected String orderNumberIdentifier;
    @XmlAttribute(name = "_PostalCode")
    protected String postalCode;
    @XmlAttribute(name = "_State")
    protected String state;
    @XmlAttribute(name = "_StreetAddress")
    protected String streetAddress;
    @XmlAttribute(name = "_StreetAddress2")
    protected String streetAddress2;
    @XmlAttribute(name = "_Type")
    protected AUSClosingAgentTypeEnumerated type;
    @XmlAttribute(name = "_TypeOtherDescription")
    protected String typeOtherDescription;
    @XmlAttribute(name = "_UnparsedName")
    protected String unparsedName;
    @XmlAttribute(name = "NonPersonEntityIndicator")
    protected String nonPersonEntityIndicator;

    /**
     * Gets the value of the contactdetail property.
     * 
     * @return
     *     possible object is
     *     {@link AUSCONTACTDETAILType }
     *     
     */
    public AUSCONTACTDETAILType getCONTACTDETAIL() {
        return contactdetail;
    }

    /**
     * Sets the value of the contactdetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link AUSCONTACTDETAILType }
     *     
     */
    public void setCONTACTDETAIL(AUSCONTACTDETAILType value) {
        this.contactdetail = value;
    }

    /**
     * Gets the value of the nonpersonentitydetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nonpersonentitydetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNONPERSONENTITYDETAIL().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AUSNONPERSONENTITYDETAILType }
     * 
     * 
     */
    public List<AUSNONPERSONENTITYDETAILType> getNONPERSONENTITYDETAIL() {
        if (nonpersonentitydetail == null) {
            nonpersonentitydetail = new ArrayList<AUSNONPERSONENTITYDETAILType>();
        }
        return this.nonpersonentitydetail;
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
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the county property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCounty() {
        return county;
    }

    /**
     * Sets the value of the county property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCounty(String value) {
        this.county = value;
    }

    /**
     * Gets the value of the orderNumberIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderNumberIdentifier() {
        return orderNumberIdentifier;
    }

    /**
     * Sets the value of the orderNumberIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderNumberIdentifier(String value) {
        this.orderNumberIdentifier = value;
    }

    /**
     * Gets the value of the postalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the streetAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Sets the value of the streetAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetAddress(String value) {
        this.streetAddress = value;
    }

    /**
     * Gets the value of the streetAddress2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetAddress2() {
        return streetAddress2;
    }

    /**
     * Sets the value of the streetAddress2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetAddress2(String value) {
        this.streetAddress2 = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link AUSClosingAgentTypeEnumerated }
     *     
     */
    public AUSClosingAgentTypeEnumerated getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link AUSClosingAgentTypeEnumerated }
     *     
     */
    public void setType(AUSClosingAgentTypeEnumerated value) {
        this.type = value;
    }

    /**
     * Gets the value of the typeOtherDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeOtherDescription() {
        return typeOtherDescription;
    }

    /**
     * Sets the value of the typeOtherDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeOtherDescription(String value) {
        this.typeOtherDescription = value;
    }

    /**
     * Gets the value of the unparsedName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnparsedName() {
        return unparsedName;
    }

    /**
     * Sets the value of the unparsedName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnparsedName(String value) {
        this.unparsedName = value;
    }

    /**
     * Gets the value of the nonPersonEntityIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNonPersonEntityIndicator() {
        return nonPersonEntityIndicator;
    }

    /**
     * Sets the value of the nonPersonEntityIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNonPersonEntityIndicator(String value) {
        this.nonPersonEntityIndicator = value;
    }

}
