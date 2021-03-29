
package com.porto.portocom.portal.cliente.v1.wsdl.complementocartoes;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for telefone complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="telefone">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoDdd" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="codigoDdi" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="codigoTipoTelefone" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="descricaoTipoTelefone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroTelefone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "telefone", propOrder = {
    "codigoDdd",
    "codigoDdi",
    "codigoTipoTelefone",
    "descricaoTipoTelefone",
    "numeroTelefone"
})
public class Telefone implements Serializable {

	private static final long serialVersionUID = 4934347522351946845L;

	protected Integer codigoDdd;
    protected Integer codigoDdi;
    protected Integer codigoTipoTelefone;
    protected String descricaoTipoTelefone;
    protected String numeroTelefone;

    /**
     * Gets the value of the codigoDdd property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodigoDdd() {
        return codigoDdd;
    }

    /**
     * Sets the value of the codigoDdd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodigoDdd(Integer value) {
        this.codigoDdd = value;
    }

    /**
     * Gets the value of the codigoDdi property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodigoDdi() {
        return codigoDdi;
    }

    /**
     * Sets the value of the codigoDdi property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodigoDdi(Integer value) {
        this.codigoDdi = value;
    }

    /**
     * Gets the value of the codigoTipoTelefone property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodigoTipoTelefone() {
        return codigoTipoTelefone;
    }

    /**
     * Sets the value of the codigoTipoTelefone property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodigoTipoTelefone(Integer value) {
        this.codigoTipoTelefone = value;
    }

    /**
     * Gets the value of the descricaoTipoTelefone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescricaoTipoTelefone() {
        return descricaoTipoTelefone;
    }

    /**
     * Sets the value of the descricaoTipoTelefone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescricaoTipoTelefone(String value) {
        this.descricaoTipoTelefone = value;
    }

    /**
     * Gets the value of the numeroTelefone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    /**
     * Sets the value of the numeroTelefone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroTelefone(String value) {
        this.numeroTelefone = value;
    }

}
