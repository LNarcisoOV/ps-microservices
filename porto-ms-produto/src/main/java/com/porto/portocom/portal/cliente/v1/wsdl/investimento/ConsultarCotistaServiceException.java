
package com.porto.portocom.portal.cliente.v1.wsdl.investimento;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ConsultarCotistaServiceException complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ConsultarCotistaServiceException">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codErroCarSale" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="mensagemErroCarSale" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultarCotistaServiceException", namespace = "http://exception.portopar.financeiro.porto.com", propOrder = {
    "codErroCarSale",
    "mensagemErroCarSale"
})
public class ConsultarCotistaServiceException {

    @XmlElement(required = true, nillable = true)
    protected String codErroCarSale;
    @XmlElement(required = true, nillable = true)
    protected String mensagemErroCarSale;

    /**
     * Obt�m o valor da propriedade codErroCarSale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodErroCarSale() {
        return codErroCarSale;
    }

    /**
     * Define o valor da propriedade codErroCarSale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodErroCarSale(String value) {
        this.codErroCarSale = value;
    }

    /**
     * Obt�m o valor da propriedade mensagemErroCarSale.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensagemErroCarSale() {
        return mensagemErroCarSale;
    }

    /**
     * Define o valor da propriedade mensagemErroCarSale.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensagemErroCarSale(String value) {
        this.mensagemErroCarSale = value;
    }

}
