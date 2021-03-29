
package com.porto.portocom.portal.cliente.v1.wsdl.complementocartoes;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for fisica complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="fisica">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoEstadoCivil" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="codigoSexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataNascimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomeEstadoCivil" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fisica", propOrder = {
    "codigoEstadoCivil",
    "codigoSexo",
    "dataNascimento",
    "nomeEstadoCivil"
})
public class Fisica implements Serializable {

	private static final long serialVersionUID = -8652447046814337705L;

	protected Integer codigoEstadoCivil;
    protected String codigoSexo;
    protected String dataNascimento;
    protected String nomeEstadoCivil;

    /**
     * Gets the value of the codigoEstadoCivil property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodigoEstadoCivil() {
        return codigoEstadoCivil;
    }

    /**
     * Sets the value of the codigoEstadoCivil property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodigoEstadoCivil(Integer value) {
        this.codigoEstadoCivil = value;
    }

    /**
     * Gets the value of the codigoSexo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoSexo() {
        return codigoSexo;
    }

    /**
     * Sets the value of the codigoSexo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoSexo(String value) {
        this.codigoSexo = value;
    }

    /**
     * Gets the value of the dataNascimento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Sets the value of the dataNascimento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataNascimento(String value) {
        this.dataNascimento = value;
    }

    /**
     * Gets the value of the nomeEstadoCivil property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeEstadoCivil() {
        return nomeEstadoCivil;
    }

    /**
     * Sets the value of the nomeEstadoCivil property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeEstadoCivil(String value) {
        this.nomeEstadoCivil = value;
    }

}
