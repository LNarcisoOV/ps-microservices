
package com.porto.portocom.portal.cliente.v1.wsdl.ldap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for alteraUrlVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="alteraUrlVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nomeServico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prefixoSistema" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="URL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "alteraUrlVO", propOrder = {
    "nomeServico",
    "prefixoSistema",
    "url"
})
public class AlteraUrlVO {

    protected String nomeServico;
    protected String prefixoSistema;
    @XmlElement(name = "URL")
    protected String url;

    /**
     * Gets the value of the nomeServico property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeServico() {
        return nomeServico;
    }

    /**
     * Sets the value of the nomeServico property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeServico(String value) {
        this.nomeServico = value;
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

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getURL() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setURL(String value) {
        this.url = value;
    }

}
