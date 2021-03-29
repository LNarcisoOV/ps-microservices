
package com.porto.portocom.portal.cliente.v1.wsdl.conquista;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java de clienteArenaType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="clienteArenaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cpfCnpj" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="data_nascimento" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="ddi_celular" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dddCelular" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numero_celular" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="cep" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="complementoCep" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="endereco_residencial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numero" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="complemento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bairro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cidade" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clienteArenaType", propOrder = {
    "email",
    "cpfCnpj",
    "nome",
    "dataNascimento",
    "ddiCelular",
    "dddCelular",
    "numeroCelular",
    "cep",
    "complementoCep",
    "enderecoResidencial",
    "numero",
    "complemento",
    "bairro",
    "cidade",
    "uf"
})
public class ClienteArenaType {

    protected String email;
    protected String cpfCnpj;
    protected String nome;
    @XmlElement(name = "data_nascimento")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataNascimento;
    @XmlElement(name = "ddi_celular")
    protected String ddiCelular;
    protected Integer dddCelular;
    @XmlElement(name = "numero_celular")
    protected Integer numeroCelular;
    protected Integer cep;
    protected Integer complementoCep;
    @XmlElement(name = "endereco_residencial")
    protected String enderecoResidencial;
    protected Integer numero;
    protected String complemento;
    protected String bairro;
    protected String cidade;
    protected String uf;

    /**
     * Obt�m o valor da propriedade email.
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
     * Define o valor da propriedade email.
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
     * Obt�m o valor da propriedade cpfCnpj.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCpfCnpj() {
        return cpfCnpj;
    }

    /**
     * Define o valor da propriedade cpfCnpj.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCpfCnpj(String value) {
        this.cpfCnpj = value;
    }

    /**
     * Obt�m o valor da propriedade nome.
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
     * Define o valor da propriedade nome.
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
     * Obt�m o valor da propriedade dataNascimento.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Define o valor da propriedade dataNascimento.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataNascimento(XMLGregorianCalendar value) {
        this.dataNascimento = value;
    }

    /**
     * Obt�m o valor da propriedade ddiCelular.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDdiCelular() {
        return ddiCelular;
    }

    /**
     * Define o valor da propriedade ddiCelular.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDdiCelular(String value) {
        this.ddiCelular = value;
    }

    /**
     * Obt�m o valor da propriedade dddCelular.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDddCelular() {
        return dddCelular;
    }

    /**
     * Define o valor da propriedade dddCelular.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDddCelular(Integer value) {
        this.dddCelular = value;
    }

    /**
     * Obt�m o valor da propriedade numeroCelular.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumeroCelular() {
        return numeroCelular;
    }

    /**
     * Define o valor da propriedade numeroCelular.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumeroCelular(Integer value) {
        this.numeroCelular = value;
    }

    /**
     * Obt�m o valor da propriedade cep.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCep() {
        return cep;
    }

    /**
     * Define o valor da propriedade cep.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCep(Integer value) {
        this.cep = value;
    }

    /**
     * Obt�m o valor da propriedade complementoCep.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getComplementoCep() {
        return complementoCep;
    }

    /**
     * Define o valor da propriedade complementoCep.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setComplementoCep(Integer value) {
        this.complementoCep = value;
    }

    /**
     * Obt�m o valor da propriedade enderecoResidencial.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnderecoResidencial() {
        return enderecoResidencial;
    }

    /**
     * Define o valor da propriedade enderecoResidencial.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnderecoResidencial(String value) {
        this.enderecoResidencial = value;
    }

    /**
     * Obt�m o valor da propriedade numero.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * Define o valor da propriedade numero.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumero(Integer value) {
        this.numero = value;
    }

    /**
     * Obt�m o valor da propriedade complemento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * Define o valor da propriedade complemento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComplemento(String value) {
        this.complemento = value;
    }

    /**
     * Obt�m o valor da propriedade bairro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * Define o valor da propriedade bairro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBairro(String value) {
        this.bairro = value;
    }

    /**
     * Obt�m o valor da propriedade cidade.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Define o valor da propriedade cidade.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCidade(String value) {
        this.cidade = value;
    }

    /**
     * Obt�m o valor da propriedade uf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUf() {
        return uf;
    }

    /**
     * Define o valor da propriedade uf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUf(String value) {
        this.uf = value;
    }

}
