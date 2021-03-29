
package com.porto.portocom.portal.cliente.v1.wsdl.ldap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for alteraPapelVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="alteraPapelVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cardinalidade" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="papel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "alteraPapelVO", propOrder = {
    "cardinalidade",
    "papel"
})
public class AlteraPapelVO {

    protected String cardinalidade;
    protected String papel;

    /**
     * Gets the value of the cardinalidade property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardinalidade() {
        return cardinalidade;
    }

    /**
     * Sets the value of the cardinalidade property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardinalidade(String value) {
        this.cardinalidade = value;
    }

    /**
     * Gets the value of the papel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPapel() {
        return papel;
    }

    /**
     * Sets the value of the papel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPapel(String value) {
        this.papel = value;
    }

}
