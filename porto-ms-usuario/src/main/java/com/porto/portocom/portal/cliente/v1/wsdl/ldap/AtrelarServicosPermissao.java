
package com.porto.portocom.portal.cliente.v1.wsdl.ldap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for atrelarServicosPermissao complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="atrelarServicosPermissao">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://service.portalcliente.seguranca.porto.com/}cadastroServicoPermissaoVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "atrelarServicosPermissao", propOrder = {
    "arg0"
})
public class AtrelarServicosPermissao {

    protected CadastroServicoPermissaoVO arg0;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link CadastroServicoPermissaoVO }
     *     
     */
    public CadastroServicoPermissaoVO getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link CadastroServicoPermissaoVO }
     *     
     */
    public void setArg0(CadastroServicoPermissaoVO value) {
        this.arg0 = value;
    }

}
