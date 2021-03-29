
package com.porto.portocom.portal.cliente.v1.wsdl.complementocartoes;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for consultaContaCartaoComAdicionalV2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="consultaContaCartaoComAdicionalV2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://ws.cartaoweb.cartoes.financeiro.com/}contaCartaoParamentroVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "consultaContaCartaoComAdicionalV2", propOrder = {
    "arg0"
})
public class ConsultaContaCartaoComAdicionalV2 implements Serializable {

	private static final long serialVersionUID = 5256391764762490962L;

	protected ContaCartaoParamentroVO arg0;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link ContaCartaoParamentroVO }
     *     
     */
    public ContaCartaoParamentroVO getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContaCartaoParamentroVO }
     *     
     */
    public void setArg0(ContaCartaoParamentroVO value) {
        this.arg0 = value;
    }

}
