
package com.porto.portocom.portal.cliente.v1.wsdl.bcp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de ObterDadosCnaeType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ObterDadosCnaeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numeroCnae" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObterDadosCnaeType", propOrder = {
    "numeroCnae"
})
public class ObterDadosCnaeType {

    protected int numeroCnae;

    /**
     * Obt�m o valor da propriedade numeroCnae.
     * 
     */
    public int getNumeroCnae() {
        return numeroCnae;
    }

    /**
     * Define o valor da propriedade numeroCnae.
     * 
     */
    public void setNumeroCnae(int value) {
        this.numeroCnae = value;
    }

}
