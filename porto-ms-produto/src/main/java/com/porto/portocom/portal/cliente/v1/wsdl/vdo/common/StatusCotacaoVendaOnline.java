
package com.porto.portocom.portal.cliente.v1.wsdl.vdo.common;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for StatusCotacaoVendaOnline complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="StatusCotacaoVendaOnline">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="isStatusAtual" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="descricao" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatusCotacaoVendaOnline", propOrder = { "isStatusAtual", "descricao" })
public class StatusCotacaoVendaOnline implements Serializable {

	private static final long serialVersionUID = 6690307788565003323L;

	@XmlElement(required = true, type = Boolean.class, nillable = true)
	protected Boolean isStatusAtual;
	@XmlElement(required = true, nillable = true)
	protected String descricao;

	/**
	 * Gets the value of the isStatusAtual property.
	 * 
	 * @return possible object is {@link Boolean }
	 * 
	 */
	public Boolean isIsStatusAtual() {
		return isStatusAtual;
	}

	/**
	 * Sets the value of the isStatusAtual property.
	 * 
	 * @param value allowed object is {@link Boolean }
	 * 
	 */
	public void setIsStatusAtual(Boolean value) {
		this.isStatusAtual = value;
	}

	/**
	 * Gets the value of the descricao property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Sets the value of the descricao property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDescricao(String value) {
		this.descricao = value;
	}

}
