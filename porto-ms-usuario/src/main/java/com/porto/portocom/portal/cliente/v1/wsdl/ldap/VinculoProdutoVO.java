
package com.porto.portocom.portal.cliente.v1.wsdl.ldap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for vinculoProdutoVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="vinculoProdutoVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoProduto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contratoFormatado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vinculoProdutoVO", propOrder = {
    "codigoProduto",
    "contratoFormatado",
    "usuario"
})
public class VinculoProdutoVO {

    protected String codigoProduto;
    protected String contratoFormatado;
    protected String usuario;

    /**
     * Gets the value of the codigoProduto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoProduto() {
        return codigoProduto;
    }

    /**
     * Sets the value of the codigoProduto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoProduto(String value) {
        this.codigoProduto = value;
    }

    /**
     * Gets the value of the contratoFormatado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContratoFormatado() {
        return contratoFormatado;
    }

    /**
     * Sets the value of the contratoFormatado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContratoFormatado(String value) {
        this.contratoFormatado = value;
    }

    /**
     * Gets the value of the usuario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Sets the value of the usuario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuario(String value) {
        this.usuario = value;
    }

}
