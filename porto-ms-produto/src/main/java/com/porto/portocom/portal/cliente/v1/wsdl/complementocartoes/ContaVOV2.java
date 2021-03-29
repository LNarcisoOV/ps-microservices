
package com.porto.portocom.portal.cliente.v1.wsdl.complementocartoes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for contaVOV2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contaVOV2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="descricacao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="diaVencimento" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="enderecos" type="{http://ws.cartaoweb.cartoes.financeiro.com/}enderecoV2" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="enderecosEletronicos" type="{http://ws.cartaoweb.cartoes.financeiro.com/}enderecoEletronico" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="fisica" type="{http://ws.cartaoweb.cartoes.financeiro.com/}fisica" minOccurs="0"/>
 *         &lt;element name="flagTitular" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="melhorDataCompra" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numeroBin" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="numeroCartao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sequenciaConta" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="telefones" type="{http://ws.cartaoweb.cartoes.financeiro.com/}telefone" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contaVOV2", propOrder = {
    "descricacao",
    "diaVencimento",
    "enderecos",
    "enderecosEletronicos",
    "fisica",
    "flagTitular",
    "melhorDataCompra",
    "numeroBin",
    "numeroCartao",
    "sequenciaConta",
    "telefones"
})
public class ContaVOV2 implements Serializable {

	private static final long serialVersionUID = -909779537783704412L;

	protected String descricacao;
    protected Integer diaVencimento;
    @XmlElement(nillable = true)
    protected List<EnderecoV2> enderecos;
    @XmlElement(nillable = true)
    protected List<EnderecoEletronico> enderecosEletronicos;
    protected Fisica fisica;
    protected String flagTitular;
    protected Integer melhorDataCompra;
    protected Long numeroBin;
    protected String numeroCartao;
    protected Integer sequenciaConta;
    @XmlElement(nillable = true)
    protected List<Telefone> telefones;

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
     * Gets the value of the enderecos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the enderecos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnderecos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EnderecoV2 }
     * 
     * 
     */
    public List<EnderecoV2> getEnderecos() {
        if (enderecos == null) {
            enderecos = new ArrayList<EnderecoV2>();
        }
        return this.enderecos;
    }

    /**
     * Gets the value of the enderecosEletronicos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the enderecosEletronicos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnderecosEletronicos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EnderecoEletronico }
     * 
     * 
     */
    public List<EnderecoEletronico> getEnderecosEletronicos() {
        if (enderecosEletronicos == null) {
            enderecosEletronicos = new ArrayList<EnderecoEletronico>();
        }
        return this.enderecosEletronicos;
    }

    /**
     * Gets the value of the fisica property.
     * 
     * @return
     *     possible object is
     *     {@link Fisica }
     *     
     */
    public Fisica getFisica() {
        return fisica;
    }

    /**
     * Sets the value of the fisica property.
     * 
     * @param value
     *     allowed object is
     *     {@link Fisica }
     *     
     */
    public void setFisica(Fisica value) {
        this.fisica = value;
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

    /**
     * Gets the value of the telefones property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the telefones property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTelefones().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Telefone }
     * 
     * 
     */
    public List<Telefone> getTelefones() {
        if (telefones == null) {
            telefones = new ArrayList<Telefone>();
        }
        return this.telefones;
    }

}
