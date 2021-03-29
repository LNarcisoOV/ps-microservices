
package com.porto.portocom.portal.cliente.v1.wsdl.complementocartoes;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for contaVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contaVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="descricacao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="diaVencimento" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="flagRepresentanteLegal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flagTitular" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="melhorDataCompra" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numeroBin" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="numeroCartao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sequenciaConta" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contaVO", propOrder = {
    "descricacao",
    "diaVencimento",
    "flagRepresentanteLegal",
    "flagTitular",
    "melhorDataCompra",
    "numeroBin",
    "numeroCartao",
    "sequenciaConta"
})
public class ContaVO implements Serializable {

	private static final long serialVersionUID = 6609012249342270373L;

	protected String descricacao;
    protected Integer diaVencimento;
    protected String flagRepresentanteLegal;
    protected String flagTitular;
    protected Integer melhorDataCompra;
    protected Long numeroBin;
    protected String numeroCartao;
    protected Integer sequenciaConta;

    /**
     * Gets the value of the descricacao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescricacao() {
        return descricacao;
    }

    /**
     * Sets the value of the descricacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescricacao(String value) {
        this.descricacao = value;
    }

    /**
     * Gets the value of the diaVencimento property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDiaVencimento() {
        return diaVencimento;
    }

    /**
     * Sets the value of the diaVencimento property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDiaVencimento(Integer value) {
        this.diaVencimento = value;
    }

    /**
     * Gets the value of the flagRepresentanteLegal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagRepresentanteLegal() {
        return flagRepresentanteLegal;
    }

    /**
     * Sets the value of the flagRepresentanteLegal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagRepresentanteLegal(String value) {
        this.flagRepresentanteLegal = value;
    }

    /**
     * Gets the value of the flagTitular property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlagTitular() {
        return flagTitular;
    }

    /**
     * Sets the value of the flagTitular property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlagTitular(String value) {
        this.flagTitular = value;
    }

    /**
     * Gets the value of the melhorDataCompra property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMelhorDataCompra() {
        return melhorDataCompra;
    }

    /**
     * Sets the value of the melhorDataCompra property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMelhorDataCompra(Integer value) {
        this.melhorDataCompra = value;
    }

    /**
     * Gets the value of the numeroBin property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumeroBin() {
        return numeroBin;
    }

    /**
     * Sets the value of the numeroBin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumeroBin(Long value) {
        this.numeroBin = value;
    }

    /**
     * Gets the value of the numeroCartao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroCartao() {
        return numeroCartao;
    }

    /**
     * Sets the value of the numeroCartao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroCartao(String value) {
        this.numeroCartao = value;
    }

    /**
     * Gets the value of the sequenciaConta property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSequenciaConta() {
        return sequenciaConta;
    }

    /**
     * Sets the value of the sequenciaConta property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSequenciaConta(Integer value) {
        this.sequenciaConta = value;
    }

}
