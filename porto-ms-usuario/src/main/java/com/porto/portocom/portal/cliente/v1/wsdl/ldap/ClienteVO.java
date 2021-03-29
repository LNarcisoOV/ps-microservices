
package com.porto.portocom.portal.cliente.v1.wsdl.ldap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for clienteVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="clienteVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cnpjTitular" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoRetorno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cpfTitular" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataAdesao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mailing" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mensagem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="papeis" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="produtos" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sobrenome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clienteVO", propOrder = {
    "cnpjTitular",
    "codigoRetorno",
    "cpfTitular",
    "dataAdesao",
    "email",
    "mailing",
    "mensagem",
    "nome",
    "papeis",
    "produtos",
    "sobrenome",
    "tipoPessoa"
})
public class ClienteVO {

    protected String cnpjTitular;
    protected String codigoRetorno;
    protected String cpfTitular;
    protected String dataAdesao;
    protected String email;
    protected String mailing;
    protected String mensagem;
    protected String nome;
    @XmlElement(nillable = true)
    protected List<String> papeis;
    @XmlElement(nillable = true)
    protected List<String> produtos;
    protected String sobrenome;
    protected String tipoPessoa;

    /**
     * Gets the value of the cnpjTitular property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCnpjTitular() {
        return cnpjTitular;
    }

    /**
     * Sets the value of the cnpjTitular property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCnpjTitular(String value) {
        this.cnpjTitular = value;
    }

    /**
     * Gets the value of the codigoRetorno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoRetorno() {
        return codigoRetorno;
    }

    /**
     * Sets the value of the codigoRetorno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoRetorno(String value) {
        this.codigoRetorno = value;
    }

    /**
     * Gets the value of the cpfTitular property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCpfTitular() {
        return cpfTitular;
    }

    /**
     * Sets the value of the cpfTitular property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCpfTitular(String value) {
        this.cpfTitular = value;
    }

    /**
     * Gets the value of the dataAdesao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataAdesao() {
        return dataAdesao;
    }

    /**
     * Sets the value of the dataAdesao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataAdesao(String value) {
        this.dataAdesao = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the mailing property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMailing() {
        return mailing;
    }

    /**
     * Sets the value of the mailing property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMailing(String value) {
        this.mailing = value;
    }

    /**
     * Gets the value of the mensagem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * Sets the value of the mensagem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensagem(String value) {
        this.mensagem = value;
    }

    /**
     * Gets the value of the nome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets the value of the nome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNome(String value) {
        this.nome = value;
    }

    /**
     * Gets the value of the papeis property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the papeis property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPapeis().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPapeis() {
        if (papeis == null) {
            papeis = new ArrayList<String>();
        }
        return this.papeis;
    }

    /**
     * Gets the value of the produtos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the produtos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProdutos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getProdutos() {
        if (produtos == null) {
            produtos = new ArrayList<String>();
        }
        return this.produtos;
    }

    /**
     * Gets the value of the sobrenome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * Sets the value of the sobrenome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSobrenome(String value) {
        this.sobrenome = value;
    }

    /**
     * Gets the value of the tipoPessoa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoPessoa() {
        return tipoPessoa;
    }

    /**
     * Sets the value of the tipoPessoa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoPessoa(String value) {
        this.tipoPessoa = value;
    }

}
