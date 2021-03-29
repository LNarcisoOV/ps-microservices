
package com.porto.portocom.portal.cliente.v1.wsdl.complementocartoes;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for enderecoV2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="enderecoV2">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.cartaoweb.cartoes.financeiro.com/}endereco">
 *       &lt;sequence>
 *         &lt;element name="codigoUnidadeFederacao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "enderecoV2", propOrder = {
    "codigoUnidadeFederacao"
})
public class EnderecoV2
    extends Endereco implements Serializable
{
	private static final long serialVersionUID = -1404076261812864604L;

	protected String codigoUnidadeFederacao;

    /**
     * Gets the value of the codigoUnidadeFederacao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoUnidadeFederacao() {
        return codigoUnidadeFederacao;
    }

    /**
     * Sets the value of the codigoUnidadeFederacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoUnidadeFederacao(String value) {
        this.codigoUnidadeFederacao = value;
    }

}
