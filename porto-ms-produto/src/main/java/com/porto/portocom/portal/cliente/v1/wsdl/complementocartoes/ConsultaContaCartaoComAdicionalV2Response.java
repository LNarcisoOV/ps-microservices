
package com.porto.portocom.portal.cliente.v1.wsdl.complementocartoes;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consultaContaCartaoComAdicionalV2Response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="consultaContaCartaoComAdicionalV2Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://ws.cartaoweb.cartoes.financeiro.com/}contaCartaoRetornoVOV2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaContaCartaoComAdicionalV2Response", propOrder = {
    "_return"
})
public class ConsultaContaCartaoComAdicionalV2Response implements Serializable {

	private static final long serialVersionUID = -7956485497567999544L;

	@XmlElement(name = "return")
    protected ContaCartaoRetornoVOV2 _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link ContaCartaoRetornoVOV2 }
     *     
     */
    public ContaCartaoRetornoVOV2 getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContaCartaoRetornoVOV2 }
     *     
     */
    public void setReturn(ContaCartaoRetornoVOV2 value) {
        this._return = value;
    }

}
