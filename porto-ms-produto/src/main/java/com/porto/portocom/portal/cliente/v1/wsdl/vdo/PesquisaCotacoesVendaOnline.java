
package com.porto.portocom.portal.cliente.v1.wsdl.vdo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numeroCpfCnpj" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ordemCnpj" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="digitoCpfCnpj" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "numeroCpfCnpj",
    "ordemCnpj",
    "digitoCpfCnpj"
})
@XmlRootElement(name = "pesquisaCotacoesVendaOnline")
public class PesquisaCotacoesVendaOnline {

    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer numeroCpfCnpj;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer ordemCnpj;
    @XmlElement(required = true, type = Integer.class, nillable = true)
    protected Integer digitoCpfCnpj;

    /**
     * Gets the value of the numeroCpfCnpj property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumeroCpfCnpj() {
        return numeroCpfCnpj;
    }

    /**
     * Sets the value of the numeroCpfCnpj property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumeroCpfCnpj(Integer value) {
        this.numeroCpfCnpj = value;
    }

    /**
     * Gets the value of the ordemCnpj property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOrdemCnpj() {
        return ordemCnpj;
    }

    /**
     * Sets the value of the ordemCnpj property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOrdemCnpj(Integer value) {
        this.ordemCnpj = value;
    }

    /**
     * Gets the value of the digitoCpfCnpj property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDigitoCpfCnpj() {
        return digitoCpfCnpj;
    }

    /**
     * Sets the value of the digitoCpfCnpj property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDigitoCpfCnpj(Integer value) {
        this.digitoCpfCnpj = value;
    }

}
