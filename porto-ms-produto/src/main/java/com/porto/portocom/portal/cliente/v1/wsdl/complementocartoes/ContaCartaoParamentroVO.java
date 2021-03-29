
package com.porto.portocom.portal.cliente.v1.wsdl.complementocartoes;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for contaCartaoParamentroVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contaCartaoParamentroVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cpf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="origem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contaCartaoParamentroVO", propOrder = {
    "cpf",
    "origem"
})
public class ContaCartaoParamentroVO implements Serializable {

	private static final long serialVersionUID = -8921762874282511135L;

	protected String cpf;
    protected String origem;

    /**
     * Gets the value of the cpf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Sets the value of the cpf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCpf(String value) {
        this.cpf = value;
    }

    /**
     * Gets the value of the origem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigem() {
        return origem;
    }

    /**
     * Sets the value of the origem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigem(String value) {
        this.origem = value;
    }

}
