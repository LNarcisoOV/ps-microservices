
package com.porto.portocom.portal.cliente.v1.wsdl.vdo.common;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for CorretorCotacaoVendaOnline complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="CorretorCotacaoVendaOnline">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="susep" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dddTelefone" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="numeroTelefone" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CorretorCotacaoVendaOnline", propOrder = { "nome", "susep", "email", "dddTelefone", "numeroTelefone" })
public class CorretorCotacaoVendaOnline implements Serializable {

	private static final long serialVersionUID = 5526141074275911803L;

	@XmlElement(required = true, nillable = true)
	protected String nome;
	@XmlElement(required = true, nillable = true)
	protected String susep;
	@XmlElement(required = true, nillable = true)
	protected String email;
	@XmlElement(required = true, type = Short.class, nillable = true)
	protected Short dddTelefone;
	@XmlElement(required = true, type = Integer.class, nillable = true)
	protected Integer numeroTelefone;

	/**
	 * Gets the value of the nome property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets the value of the nome property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setNome(String value) {
		this.nome = value;
	}

	/**
	 * Gets the value of the susep property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSusep() {
		return susep;
	}

	/**
	 * Sets the value of the susep property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setSusep(String value) {
		this.susep = value;
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
	 * Gets the value of the dddTelefone property.
	 * 
	 * @return possible object is {@link Short }
	 * 
	 */
	public Short getDddTelefone() {
		return dddTelefone;
	}

	/**
	 * Sets the value of the dddTelefone property.
	 * 
	 * @param value allowed object is {@link Short }
	 * 
	 */
	public void setDddTelefone(Short value) {
		this.dddTelefone = value;
	}

	/**
	 * Gets the value of the numeroTelefone property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getNumeroTelefone() {
		return numeroTelefone;
	}

	/**
	 * Sets the value of the numeroTelefone property.
	 * 
	 * @param value allowed object is {@link Integer }
	 * 
	 */
	public void setNumeroTelefone(Integer value) {
		this.numeroTelefone = value;
	}

}
