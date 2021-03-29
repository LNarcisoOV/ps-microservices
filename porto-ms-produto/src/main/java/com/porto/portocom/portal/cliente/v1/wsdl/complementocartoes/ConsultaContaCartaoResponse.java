
package com.porto.portocom.portal.cliente.v1.wsdl.complementocartoes;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consultaContaCartaoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="consultaContaCartaoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://ws.cartaoweb.cartoes.financeiro.com/}contaCartaoRetornoVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaContaCartaoResponse", propOrder = {
    "_return"
})
public class ConsultaContaCartaoResponse implements Serializable {

	private static final long serialVersionUID = -3285870789061524155L;

	@XmlElement(name = "return")
    protected ContaCartaoRetornoVO _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link ContaCartaoRetornoVO }
     *     
     */
    public ContaCartaoRetornoVO getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContaCartaoRetornoVO }
     *     
     */
    public void setReturn(ContaCartaoRetornoVO value) {
        this._return = value;
    }

}
