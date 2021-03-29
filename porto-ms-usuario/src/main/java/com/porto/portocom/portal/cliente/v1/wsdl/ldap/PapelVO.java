
package com.porto.portocom.portal.cliente.v1.wsdl.ldap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for papelVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="papelVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cardinalidade" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codProduto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="papel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="permissao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="produto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="servico" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "papelVO", propOrder = {
    "cardinalidade",
    "codProduto",
    "papel",
    "permissao",
    "produto",
    "servico"
})
public class PapelVO {

    protected String cardinalidade;
    protected String codProduto;
    protected String papel;
    protected String permissao;
    protected String produto;
    @XmlElement(nillable = true)
    protected List<String> servico;

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
     * Gets the value of the codProduto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodProduto() {
        return codProduto;
    }

    /**
     * Sets the value of the codProduto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodProduto(String value) {
        this.codProduto = value;
    }

    /**
     * Gets the value of the papel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPapel() {
        return papel;
    }

    /**
     * Sets the value of the papel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPapel(String value) {
        this.papel = value;
    }

    /**
     * Gets the value of the permissao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPermissao() {
        return permissao;
    }

    /**
     * Sets the value of the permissao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPermissao(String value) {
        this.permissao = value;
    }

    /**
     * Gets the value of the produto property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProduto() {
        return produto;
    }

    /**
     * Sets the value of the produto property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProduto(String value) {
        this.produto = value;
    }

    /**
     * Gets the value of the servico property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the servico property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServico().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getServico() {
        if (servico == null) {
            servico = new ArrayList<String>();
        }
        return this.servico;
    }

}
