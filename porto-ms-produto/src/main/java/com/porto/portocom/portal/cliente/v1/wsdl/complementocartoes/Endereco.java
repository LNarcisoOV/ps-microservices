
package com.porto.portocom.portal.cliente.v1.wsdl.complementocartoes;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for endereco complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="endereco">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nomeBairro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomeCidade" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomeLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomeTipoLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroComplementoCep" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="numeroInicioCep" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="siglaPais" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "endereco", propOrder = {
    "nomeBairro",
    "nomeCidade",
    "nomeLogradouro",
    "nomeTipoLogradouro",
    "numeroComplementoCep",
    "numeroInicioCep",
    "siglaPais"
})
@XmlSeeAlso({
    EnderecoV2 .class
})
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1877375031023573162L;

	protected String nomeBairro;
    protected String nomeCidade;
    protected String nomeLogradouro;
    protected String nomeTipoLogradouro;
    protected Long numeroComplementoCep;
    protected Long numeroInicioCep;
    protected String siglaPais;

    /**
     * Gets the value of the nomeBairro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeBairro() {
        return nomeBairro;
    }

    /**
     * Sets the value of the nomeBairro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeBairro(String value) {
        this.nomeBairro = value;
    }

    /**
     * Gets the value of the nomeCidade property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeCidade() {
        return nomeCidade;
    }

    /**
     * Sets the value of the nomeCidade property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeCidade(String value) {
        this.nomeCidade = value;
    }

    /**
     * Gets the value of the nomeLogradouro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    /**
     * Sets the value of the nomeLogradouro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeLogradouro(String value) {
        this.nomeLogradouro = value;
    }

    /**
     * Gets the value of the nomeTipoLogradouro property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeTipoLogradouro() {
        return nomeTipoLogradouro;
    }

    /**
     * Sets the value of the nomeTipoLogradouro property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeTipoLogradouro(String value) {
        this.nomeTipoLogradouro = value;
    }

    /**
     * Gets the value of the numeroComplementoCep property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumeroComplementoCep() {
        return numeroComplementoCep;
    }

    /**
     * Sets the value of the numeroComplementoCep property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumeroComplementoCep(Long value) {
        this.numeroComplementoCep = value;
    }

    /**
     * Gets the value of the numeroInicioCep property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumeroInicioCep() {
        return numeroInicioCep;
    }

    /**
     * Sets the value of the numeroInicioCep property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumeroInicioCep(Long value) {
        this.numeroInicioCep = value;
    }

    /**
     * Gets the value of the siglaPais property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSiglaPais() {
        return siglaPais;
    }

    /**
     * Sets the value of the siglaPais property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSiglaPais(String value) {
        this.siglaPais = value;
    }

}
