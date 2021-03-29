
package com.porto.portocom.portal.cliente.v1.wsdl.conquista;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java de isClienteCadastradoResponseType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="isClienteCadastradoResponseType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://impl.service.soap.arenaservicos.portopar.financeiro.porto.com/}baseVO">
 *       &lt;sequence>
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="mesagem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cpfCnpj" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="is_cadastrado" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="emailCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroTelefone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dddNumeroTelefone" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="nomeCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataNascimento" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cep" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroEnderecoResidencial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoEstadoCivil" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="tipoDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgaoEmissor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataExpedicao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="nomeMae" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "isClienteCadastradoResponseType", propOrder = {
    "message",
    "mesagem",
    "cpfCnpj",
    "isCadastrado",
    "emailCliente",
    "numeroTelefone",
    "dddNumeroTelefone",
    "nomeCliente",
    "dataNascimento",
    "estado",
    "cep",
    "numeroEnderecoResidencial",
    "sexo",
    "codigoEstadoCivil",
    "tipoDocumento",
    "numeroDocumento",
    "orgaoEmissor",
    "dataExpedicao",
    "nomeMae"
})
public class IsClienteCadastradoResponseType
    extends BaseVO implements Serializable
{

	private static final long serialVersionUID = 3936598114278069379L;
	
	@XmlElement(name = "Message", required = true)
    protected Object message;
    protected String mesagem;
    protected String cpfCnpj;
    @XmlElement(name = "is_cadastrado")
    protected Boolean isCadastrado;
    protected String emailCliente;
    protected String numeroTelefone;
    protected BigDecimal dddNumeroTelefone;
    protected String nomeCliente;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataNascimento;
    protected String estado;
    protected String cep;
    protected String numeroEnderecoResidencial;
    protected String sexo;
    protected BigDecimal codigoEstadoCivil;
    protected String tipoDocumento;
    protected String numeroDocumento;
    protected String orgaoEmissor;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataExpedicao;
    protected String nomeMae;

    /**
     * Obt�m o valor da propriedade message.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getMessage() {
        return message;
    }

    /**
     * Define o valor da propriedade message.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setMessage(Object value) {
        this.message = value;
    }

    /**
     * Obt�m o valor da propriedade mesagem.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMesagem() {
        return mesagem;
    }

    /**
     * Define o valor da propriedade mesagem.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMesagem(String value) {
        this.mesagem = value;
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
     * Obt�m o valor da propriedade isCadastrado.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsCadastrado() {
        return isCadastrado;
    }

    /**
     * Define o valor da propriedade isCadastrado.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsCadastrado(Boolean value) {
        this.isCadastrado = value;
    }

    /**
     * Obt�m o valor da propriedade emailCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailCliente() {
        return emailCliente;
    }

    /**
     * Define o valor da propriedade emailCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailCliente(String value) {
        this.emailCliente = value;
    }

    /**
     * Obt�m o valor da propriedade numeroTelefone.
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
     * Define o valor da propriedade numeroTelefone.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroTelefone(String value) {
        this.numeroTelefone = value;
    }

    /**
     * Obt�m o valor da propriedade dddNumeroTelefone.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDddNumeroTelefone() {
        return dddNumeroTelefone;
    }

    /**
     * Define o valor da propriedade dddNumeroTelefone.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDddNumeroTelefone(BigDecimal value) {
        this.dddNumeroTelefone = value;
    }

    /**
     * Obt�m o valor da propriedade nomeCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * Define o valor da propriedade nomeCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeCliente(String value) {
        this.nomeCliente = value;
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
     * Obt�m o valor da propriedade estado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Define o valor da propriedade estado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Obt�m o valor da propriedade cep.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCep() {
        return cep;
    }

    /**
     * Define o valor da propriedade cep.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCep(String value) {
        this.cep = value;
    }

    /**
     * Gets the value of the numeroEnderecoResidencial property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroEnderecoResidencial() {
        return numeroEnderecoResidencial;
    }

    /**
     * Sets the value of the numeroEnderecoResidencial property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroEnderecoResidencial(String value) {
        this.numeroEnderecoResidencial = value;
    }

    /**
     * Gets the value of the sexo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Sets the value of the sexo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSexo(String value) {
        this.sexo = value;
    }

    /**
     * Gets the value of the codigoEstadoCivil property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCodigoEstadoCivil() {
        return codigoEstadoCivil;
    }

    /**
     * Sets the value of the codigoEstadoCivil property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCodigoEstadoCivil(BigDecimal value) {
        this.codigoEstadoCivil = value;
    }

    /**
     * Gets the value of the tipoDocumento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * Sets the value of the tipoDocumento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDocumento(String value) {
        this.tipoDocumento = value;
    }

    /**
     * Gets the value of the numeroDocumento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * Sets the value of the numeroDocumento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroDocumento(String value) {
        this.numeroDocumento = value;
    }

    /**
     * Gets the value of the orgaoEmissor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    /**
     * Sets the value of the orgaoEmissor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgaoEmissor(String value) {
        this.orgaoEmissor = value;
    }

    /**
     * Gets the value of the dataExpedicao property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataExpedicao() {
        return dataExpedicao;
    }

    /**
     * Sets the value of the dataExpedicao property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataExpedicao(XMLGregorianCalendar value) {
        this.dataExpedicao = value;
    }

    /**
     * Gets the value of the nomeMae property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomeMae() {
        return nomeMae;
    }

    /**
     * Sets the value of the nomeMae property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomeMae(String value) {
        this.nomeMae = value;
    }

}
