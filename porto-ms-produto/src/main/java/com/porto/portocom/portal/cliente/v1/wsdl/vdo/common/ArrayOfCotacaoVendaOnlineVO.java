
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
 * Java class for ArrayOfCotacaoVendaOnlineVO complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCotacaoVendaOnlineVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CotacaoVendaOnlineVO" type="{http://common.marketing.porto.com}CotacaoVendaOnlineVO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCotacaoVendaOnlineVO", propOrder = { "cotacaoVendaOnlineVO" })
public class ArrayOfCotacaoVendaOnlineVO implements Serializable {

	private static final long serialVersionUID = 1892996612010881597L;

	@XmlElement(name = "CotacaoVendaOnlineVO", nillable = true)
	protected List<CotacaoVendaOnlineVO> cotacaoVendaOnlineVO;

	/**
	 * Gets the value of the cotacaoVendaOnlineVO property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the cotacaoVendaOnlineVO property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getCotacaoVendaOnlineVO().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link CotacaoVendaOnlineVO }
	 * 
	 * 
	 */
	public List<CotacaoVendaOnlineVO> getCotacaoVendaOnlineVO() {
		if (cotacaoVendaOnlineVO == null) {
			cotacaoVendaOnlineVO = new ArrayList<CotacaoVendaOnlineVO>();
		}
		return this.cotacaoVendaOnlineVO;
	}

}
