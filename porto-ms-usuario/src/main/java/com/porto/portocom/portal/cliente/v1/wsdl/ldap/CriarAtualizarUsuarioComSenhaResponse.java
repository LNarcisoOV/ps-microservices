
package com.porto.portocom.portal.cliente.v1.wsdl.ldap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for criarAtualizarUsuarioComSenhaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="criarAtualizarUsuarioComSenhaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://service.portalcliente.seguranca.porto.com/}retornoVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "criarAtualizarUsuarioComSenhaResponse", propOrder = {
    "_return"
})
public class CriarAtualizarUsuarioComSenhaResponse {

    @XmlElement(name = "return")
    protected RetornoVO _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link RetornoVO }
     *     
     */
    public RetornoVO getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link RetornoVO }
     *     
     */
    public void setReturn(RetornoVO value) {
        this._return = value;
    }

}
