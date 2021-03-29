
package com.porto.portocom.portal.cliente.v1.wsdl.complementocartoes;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for contaCartaoComEmailRetornoVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contaCartaoComEmailRetornoVO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.cartaoweb.cartoes.financeiro.com/}contaCartaoRetornoVO">
 *       &lt;sequence>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contaCartaoComEmailRetornoVO", propOrder = {
    "email"
})
public class ContaCartaoComEmailRetornoVO
    extends ContaCartaoRetornoVO implements Serializable
{

	private static final long serialVersionUID = 5725638671743517891L;

	protected String email;

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

}
