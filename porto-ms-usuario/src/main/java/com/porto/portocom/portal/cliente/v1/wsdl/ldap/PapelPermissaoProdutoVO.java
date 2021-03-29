
package com.porto.portocom.portal.cliente.v1.wsdl.ldap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for papelPermissaoProdutoVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="papelPermissaoProdutoVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cardinalidade" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoProduto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descricaoPapelPermissao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descricaoProduto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomePapel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomePermissao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "papelPermissaoProdutoVO", propOrder = {
    "cardinalidade",
    "codigoProduto",
    "descricaoPapelPermissao",
    "descricaoProduto",
    "nomePapel",
    "nomePermissao"
})
public class PapelPermissaoProdutoVO {

    protected String cardinalidade;
    protected String codigoProduto;
    protected String descricaoPapelPermissao;
    protected String descricaoProduto;
    protected String nomePapel;
    protected String nomePermissao;

    /**
     * Gets the value of the cardinalidade property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardinalidade() {
        return cardinalidade;
    }

    /**
     * Sets the value of the cardinalidade property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardinalidade(String value) {
        this.cardinalidade = value;
    }

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
     * Gets the value of the descricaoPapelPermissao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescricaoPapelPermissao() {
        return descricaoPapelPermissao;
    }

    /**
     * Sets the value of the descricaoPapelPermissao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescricaoPapelPermissao(String value) {
        this.descricaoPapelPermissao = value;
    }

    /**
     * Gets the value of the descricaoProduto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    /**
     * Sets the value of the descricaoProduto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescricaoProduto(String value) {
        this.descricaoProduto = value;
    }

    /**
     * Gets the value of the nomePapel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomePapel() {
        return nomePapel;
    }

    /**
     * Sets the value of the nomePapel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomePapel(String value) {
        this.nomePapel = value;
    }

    /**
     * Gets the value of the nomePermissao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomePermissao() {
        return nomePermissao;
    }

    /**
     * Sets the value of the nomePermissao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomePermissao(String value) {
        this.nomePermissao = value;
    }

}
