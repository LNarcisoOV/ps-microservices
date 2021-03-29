
package com.porto.portocom.portal.cliente.v1.wsdl.vdo.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ArrayOfStatusCotacaoVendaOnline complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfStatusCotacaoVendaOnline">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StatusCotacaoVendaOnline" type="{http://common.marketing.porto.com}StatusCotacaoVendaOnline" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfStatusCotacaoVendaOnline", propOrder = { "statusCotacaoVendaOnline" })
public class ArrayOfStatusCotacaoVendaOnline implements Serializable {

	private static final long serialVersionUID = -7120773940045620762L;

	@XmlElement(name = "StatusCotacaoVendaOnline", nillable = true)
	protected List<StatusCotacaoVendaOnline> statusCotacaoVendaOnline;

	/**
	 * Gets the value of the statusCotacaoVendaOnline property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the statusCotacaoVendaOnline property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getStatusCotacaoVendaOnline().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link StatusCotacaoVendaOnline }
	 * 
	 * 
	 */
	public List<StatusCotacaoVendaOnline> getStatusCotacaoVendaOnline() {
		if (statusCotacaoVendaOnline == null) {
			statusCotacaoVendaOnline = new ArrayList<StatusCotacaoVendaOnline>();
		}
		return this.statusCotacaoVendaOnline;
	}

}
