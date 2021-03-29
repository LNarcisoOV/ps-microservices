
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
 *         &lt;element name="agencia" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="conta" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "agencia",
    "conta"
})
@XmlRootElement(name = "consultaCotistaCompletoPorContrato")
public class ConsultaCotistaCompletoPorContrato {

    @XmlElement(required = true, nillable = true)
    protected String agencia;
    @XmlElement(required = true, nillable = true)
    protected String conta;

    /**
     * Obt�m o valor da propriedade agencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgencia() {
        return agencia;
    }

    /**
     * Define o valor da propriedade agencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgencia(String value) {
        this.agencia = value;
    }

    /**
     * Obt�m o valor da propriedade conta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConta() {
        return conta;
    }

    /**
     * Define o valor da propriedade conta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConta(String value) {
        this.conta = value;
    }

}
