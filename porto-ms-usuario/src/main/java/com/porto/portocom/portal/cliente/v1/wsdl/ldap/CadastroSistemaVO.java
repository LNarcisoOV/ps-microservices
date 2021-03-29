
package com.porto.portocom.portal.cliente.v1.wsdl.ldap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cadastroSistemaVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cadastroSistemaVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="descricaoSistema" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="displayNome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prefixoSistema" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cadastroSistemaVO", propOrder = {
    "descricaoSistema",
    "displayNome",
    "prefixoSistema"
})
public class CadastroSistemaVO {

    protected String descricaoSistema;
    protected String displayNome;
    protected String prefixoSistema;

    /**
     * Gets the value of the descricaoSistema property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescricaoSistema() {
        return descricaoSistema;
    }

    /**
     * Sets the value of the descricaoSistema property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescricaoSistema(String value) {
        this.descricaoSistema = value;
    }

    /**
     * Gets the value of the displayNome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayNome() {
        return displayNome;
    }

    /**
     * Sets the value of the displayNome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayNome(String value) {
        this.displayNome = value;
    }

    /**
     * Gets the value of the prefixoSistema property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrefixoSistema() {
        return prefixoSistema;
    }

    /**
     * Sets the value of the prefixoSistema property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrefixoSistema(String value) {
        this.prefixoSistema = value;
    }

}
