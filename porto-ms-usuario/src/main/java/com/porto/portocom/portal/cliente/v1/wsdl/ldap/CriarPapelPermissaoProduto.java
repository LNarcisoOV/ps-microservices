
package com.porto.portocom.portal.cliente.v1.wsdl.ldap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for criarPapelPermissaoProduto complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="criarPapelPermissaoProduto">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://service.portalcliente.seguranca.porto.com/}papelPermissaoProdutoVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "criarPapelPermissaoProduto", propOrder = {
    "arg0"
})
public class CriarPapelPermissaoProduto {

    protected PapelPermissaoProdutoVO arg0;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link PapelPermissaoProdutoVO }
     *     
     */
    public PapelPermissaoProdutoVO getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link PapelPermissaoProdutoVO }
     *     
     */
    public void setArg0(PapelPermissaoProdutoVO value) {
        this.arg0 = value;
    }

}
