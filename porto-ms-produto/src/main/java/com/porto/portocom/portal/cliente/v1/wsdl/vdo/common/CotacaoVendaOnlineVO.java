
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
 * Java class for CotacaoVendaOnlineVO complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="CotacaoVendaOnlineVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numeroProtocolo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="dataRealizacao" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="codigoProdutoBCP" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="descricaoProduto" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="link" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descricaoLink" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="statusCotacao" type="{http://common.marketing.porto.com}ArrayOfStatusCotacaoVendaOnline"/>
 *         &lt;element name="corretorVendaOnline" type="{http://common.marketing.porto.com}CorretorCotacaoVendaOnline"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CotacaoVendaOnlineVO", propOrder = { "numeroProtocolo", "dataRealizacao", "codigoProdutoBCP",
		"descricaoProduto", "link", "descricaoLink", "statusCotacao", "corretorVendaOnline" })
public class CotacaoVendaOnlineVO implements Serializable {

	private static final long serialVersionUID = 8349586431681664740L;

	@XmlElement(required = true, type = Integer.class, nillable = true)
	protected Integer numeroProtocolo;
	@XmlElement(required = true, nillable = true)
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar dataRealizacao;
	@XmlElement(required = true, type = Short.class, nillable = true)
	protected Short codigoProdutoBCP;
	@XmlElement(required = true, nillable = true)
	protected String descricaoProduto;
	@XmlElement(required = true, nillable = true)
	protected String link;
	@XmlElement(required = true, nillable = true)
	protected String descricaoLink;
	@XmlElement(required = true, nillable = true)
	protected ArrayOfStatusCotacaoVendaOnline statusCotacao;
	@XmlElement(required = true, nillable = true)
	protected CorretorCotacaoVendaOnline corretorVendaOnline;

	/**
	 * Gets the value of the numeroProtocolo property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getNumeroProtocolo() {
		return numeroProtocolo;
	}

	/**
	 * Sets the value of the numeroProtocolo property.
	 * 
	 * @param value allowed object is {@link Integer }
	 * 
	 */
	public void setNumeroProtocolo(Integer value) {
		this.numeroProtocolo = value;
	}

	/**
	 * Gets the value of the dataRealizacao property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getDataRealizacao() {
		return dataRealizacao;
	}

	/**
	 * Sets the value of the dataRealizacao property.
	 * 
	 * @param value allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setDataRealizacao(XMLGregorianCalendar value) {
		this.dataRealizacao = value;
	}

	/**
	 * Gets the value of the codigoProdutoBCP property.
	 * 
	 * @return possible object is {@link Short }
	 * 
	 */
	public Short getCodigoProdutoBCP() {
		return codigoProdutoBCP;
	}

	/**
	 * Sets the value of the codigoProdutoBCP property.
	 * 
	 * @param value allowed object is {@link Short }
	 * 
	 */
	public void setCodigoProdutoBCP(Short value) {
		this.codigoProdutoBCP = value;
	}

	/**
	 * Gets the value of the descricaoProduto property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	/**
	 * Sets the value of the descricaoProduto property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDescricaoProduto(String value) {
		this.descricaoProduto = value;
	}

	/**
	 * Gets the value of the link property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLink() {
		return link;
	}

	/**
	 * Sets the value of the link property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setLink(String value) {
		this.link = value;
	}

	/**
	 * Gets the value of the descricaoLink property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescricaoLink() {
		return descricaoLink;
	}

	/**
	 * Sets the value of the descricaoLink property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDescricaoLink(String value) {
		this.descricaoLink = value;
	}

	/**
	 * Gets the value of the statusCotacao property.
	 * 
	 * @return possible object is {@link ArrayOfStatusCotacaoVendaOnline }
	 * 
	 */
	public ArrayOfStatusCotacaoVendaOnline getStatusCotacao() {
		return statusCotacao;
	}

	/**
	 * Sets the value of the statusCotacao property.
	 * 
	 * @param value allowed object is {@link ArrayOfStatusCotacaoVendaOnline }
	 * 
	 */
	public void setStatusCotacao(ArrayOfStatusCotacaoVendaOnline value) {
		this.statusCotacao = value;
	}

	/**
	 * Gets the value of the corretorVendaOnline property.
	 * 
	 * @return possible object is {@link CorretorCotacaoVendaOnline }
	 * 
	 */
	public CorretorCotacaoVendaOnline getCorretorVendaOnline() {
		return corretorVendaOnline;
	}

	/**
	 * Sets the value of the corretorVendaOnline property.
	 * 
	 * @param value allowed object is {@link CorretorCotacaoVendaOnline }
	 * 
	 */
	public void setCorretorVendaOnline(CorretorCotacaoVendaOnline value) {
		this.corretorVendaOnline = value;
	}

}
