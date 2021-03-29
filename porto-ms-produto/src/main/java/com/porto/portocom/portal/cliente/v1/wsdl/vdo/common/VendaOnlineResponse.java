
package com.porto.portocom.portal.cliente.v1.wsdl.vdo.common;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for VendaOnlineResponse complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="VendaOnlineResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cotacoesVendaOnline" type="{http://common.marketing.porto.com}ArrayOfCotacaoVendaOnlineVO"/>
 *         &lt;element name="numeroCpfCnpj" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ordemCnpj" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="digitoCpfCnpj" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="dataNascimentoCliente" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dddCelular" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="numeroCelular" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nomeProponente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VendaOnlineResponse", propOrder = { "cotacoesVendaOnline", "numeroCpfCnpj", "ordemCnpj",
		"digitoCpfCnpj", "dataNascimentoCliente", "email", "dddCelular", "numeroCelular", "nomeProponente" })
public class VendaOnlineResponse implements Serializable {

	private static final long serialVersionUID = 1268104824666629117L;

	@XmlElement(required = true, nillable = true)
	protected ArrayOfCotacaoVendaOnlineVO cotacoesVendaOnline;
	@XmlElement(required = true, type = Long.class, nillable = true)
	protected Long numeroCpfCnpj;
	@XmlElement(required = true, type = Short.class, nillable = true)
	protected Short ordemCnpj;
	@XmlElement(required = true, type = Short.class, nillable = true)
	protected Short digitoCpfCnpj;
	@XmlElement(required = true, nillable = true)
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar dataNascimentoCliente;
	@XmlElement(required = true, nillable = true)
	protected String email;
	@XmlElement(required = true, type = Short.class, nillable = true)
	protected Short dddCelular;
	@XmlElement(required = true, type = Integer.class, nillable = true)
	protected Integer numeroCelular;
	@XmlElement(required = true, nillable = true)
	protected String nomeProponente;

	/**
	 * Gets the value of the cotacoesVendaOnline property.
	 * 
	 * @return possible object is {@link ArrayOfCotacaoVendaOnlineVO }
	 * 
	 */
	public ArrayOfCotacaoVendaOnlineVO getCotacoesVendaOnline() {
		return cotacoesVendaOnline;
	}

	/**
	 * Sets the value of the cotacoesVendaOnline property.
	 * 
	 * @param value allowed object is {@link ArrayOfCotacaoVendaOnlineVO }
	 * 
	 */
	public void setCotacoesVendaOnline(ArrayOfCotacaoVendaOnlineVO value) {
		this.cotacoesVendaOnline = value;
	}

	/**
	 * Gets the value of the numeroCpfCnpj property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getNumeroCpfCnpj() {
		return numeroCpfCnpj;
	}

	/**
	 * Sets the value of the numeroCpfCnpj property.
	 * 
	 * @param value allowed object is {@link Long }
	 * 
	 */
	public void setNumeroCpfCnpj(Long value) {
		this.numeroCpfCnpj = value;
	}

	/**
	 * Gets the value of the ordemCnpj property.
	 * 
	 * @return possible object is {@link Short }
	 * 
	 */
	public Short getOrdemCnpj() {
		return ordemCnpj;
	}

	/**
	 * Sets the value of the ordemCnpj property.
	 * 
	 * @param value allowed object is {@link Short }
	 * 
	 */
	public void setOrdemCnpj(Short value) {
		this.ordemCnpj = value;
	}

	/**
	 * Gets the value of the digitoCpfCnpj property.
	 * 
	 * @return possible object is {@link Short }
	 * 
	 */
	public Short getDigitoCpfCnpj() {
		return digitoCpfCnpj;
	}

	/**
	 * Sets the value of the digitoCpfCnpj property.
	 * 
	 * @param value allowed object is {@link Short }
	 * 
	 */
	public void setDigitoCpfCnpj(Short value) {
		this.digitoCpfCnpj = value;
	}

	/**
	 * Gets the value of the dataNascimentoCliente property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getDataNascimentoCliente() {
		return dataNascimentoCliente;
	}

	/**
	 * Sets the value of the dataNascimentoCliente property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setDataNascimentoCliente(XMLGregorianCalendar value) {
		this.dataNascimentoCliente = value;
	}

	/**
	 * Gets the value of the email property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the value of the email property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setEmail(String value) {
		this.email = value;
	}

	/**
	 * Gets the value of the dddCelular property.
	 * 
	 * @return possible object is {@link Short }
	 * 
	 */
	public Short getDddCelular() {
		return dddCelular;
	}

	/**
	 * Sets the value of the dddCelular property.
	 * 
	 * @param value allowed object is {@link Short }
	 * 
	 */
	public void setDddCelular(Short value) {
		this.dddCelular = value;
	}

	/**
	 * Gets the value of the numeroCelular property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getNumeroCelular() {
		return numeroCelular;
	}

	/**
	 * Sets the value of the numeroCelular property.
	 * 
	 * @param value allowed object is {@link Integer }
	 * 
	 */
	public void setNumeroCelular(Integer value) {
		this.numeroCelular = value;
	}

	/**
	 * Gets the value of the nomeProponente property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNomeProponente() {
		return nomeProponente;
	}

	/**
	 * Sets the value of the nomeProponente property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setNomeProponente(String value) {
		this.nomeProponente = value;
	}

}
