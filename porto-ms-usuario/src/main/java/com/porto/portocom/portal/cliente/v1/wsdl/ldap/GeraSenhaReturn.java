
package com.porto.portocom.portal.cliente.v1.wsdl.ldap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for geraSenhaReturn complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="geraSenhaReturn">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoRetorno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mensagem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="novaSenha" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "geraSenhaReturn", propOrder = {
    "codigoRetorno",
    "mensagem",
    "novaSenha"
})
public class GeraSenhaReturn {

    protected String codigoRetorno;
    protected String mensagem;
    protected String novaSenha;

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
     * Gets the value of the novaSenha property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNovaSenha() {
        return novaSenha;
    }

    /**
     * Sets the value of the novaSenha property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNovaSenha(String value) {
        this.novaSenha = value;
    }

}
