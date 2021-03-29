
package com.porto.portocom.portal.cliente.v1.wsdl.ldap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for listarServicosPermissaoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="listarServicosPermissaoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://service.portalcliente.seguranca.porto.com/}retornoListaServicoPorPermissaoVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listarServicosPermissaoResponse", propOrder = {
    "_return"
})
public class ListarServicosPermissaoResponse {

    @XmlElement(name = "return")
    protected RetornoListaServicoPorPermissaoVO _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link RetornoListaServicoPorPermissaoVO }
     *     
     */
    public RetornoListaServicoPorPermissaoVO getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link RetornoListaServicoPorPermissaoVO }
     *     
     */
    public void setReturn(RetornoListaServicoPorPermissaoVO value) {
        this._return = value;
    }

}
