
package com.porto.portocom.portal.cliente.v1.wsdl.investimento;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numeroCpfCnpj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ordemCnpj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="digitoCpfCnpj" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlRootElement(name = "consultaCotistaCompletoPorCpfCnpj")
public class ConsultaCotistaCompletoPorCpfCnpj {

    @XmlElement(required = true, nillable = true)
    protected String numeroCpfCnpj;
    @XmlElement(required = true, nillable = true)
    protected String ordemCnpj;
    @XmlElement(required = true, nillable = true)
    protected String digitoCpfCnpj;

    /**
     * Obt�m o valor da propriedade numeroCpfCnpj.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroCpfCnpj() {
        return numeroCpfCnpj;
    }

    /**
     * Define o valor da propriedade numeroCpfCnpj.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroCpfCnpj(String value) {
        this.numeroCpfCnpj = value;
    }

    /**
     * Obt�m o valor da propriedade ordemCnpj.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrdemCnpj() {
        return ordemCnpj;
    }

    /**
     * Define o valor da propriedade ordemCnpj.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrdemCnpj(String value) {
        this.ordemCnpj = value;
    }

    /**
     * Obt�m o valor da propriedade digitoCpfCnpj.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDigitoCpfCnpj() {
        return digitoCpfCnpj;
    }

    /**
     * Define o valor da propriedade digitoCpfCnpj.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDigitoCpfCnpj(String value) {
        this.digitoCpfCnpj = value;
    }

}
