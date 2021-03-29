
package com.porto.portocom.portal.cliente.v1.wsdl.complementocartoes;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for enderecoEletronico complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="enderecoEletronico">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enderecoEletronico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "enderecoEletronico", propOrder = {
    "enderecoEletronico"
})
public class EnderecoEletronico implements Serializable{

	private static final long serialVersionUID = 2219294108596842246L;

	protected String enderecoEletronico;

    /**
     * Gets the value of the enderecoEletronico property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnderecoEletronico() {
        return enderecoEletronico;
    }

    /**
     * Sets the value of the enderecoEletronico property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnderecoEletronico(String value) {
        this.enderecoEletronico = value;
    }

}
