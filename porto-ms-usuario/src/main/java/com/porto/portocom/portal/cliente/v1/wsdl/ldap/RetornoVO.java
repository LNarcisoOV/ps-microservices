
package com.porto.portocom.portal.cliente.v1.wsdl.ldap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for retornoVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="retornoVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoRetorno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mensagem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="senhaGerada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "retornoVO", propOrder = {
    "codigoRetorno",
    "mensagem",
    "senhaGerada"
})
public class RetornoVO {

    protected String codigoRetorno;
    protected String mensagem;
    protected String senhaGerada;

    /**
     * Gets the value of the codigoRetorno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoRetorno() {
        return codigoRetorno;
    }

    /**
     * Sets the value of the codigoRetorno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoRetorno(String value) {
        this.codigoRetorno = value;
    }

    /**
     * Gets the value of the mensagem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * Sets the value of the mensagem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensagem(String value) {
        this.mensagem = value;
    }

    /**
     * Gets the value of the senhaGerada property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenhaGerada() {
        return senhaGerada;
    }

    /**
     * Sets the value of the senhaGerada property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenhaGerada(String value) {
        this.senhaGerada = value;
    }

}
