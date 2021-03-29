package com.porto.portocom.portal.cliente.v1.wsdl.investimento;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de CotistaServiceVO complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="CotistaServiceVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cgccpf" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cliente" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dataNascimento" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="assessor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CotistaServiceVO", namespace = "http://common.portopar.financeiro.porto.com", propOrder = {
    "cgccpf",
    "cliente",
    "dataNascimento",
    "assessor"
})
@XmlSeeAlso({
    CotistaCompletoServiceVO.class
})
public class CotistaServiceVO implements Serializable{

	private static final long serialVersionUID = 6411797703472935013L;
	
	@XmlElement(required = true, nillable = true)
    protected String cgccpf;
    @XmlElement(required = true, nillable = true)
    protected String cliente;
    @XmlElement(required = true, nillable = true)
    protected String dataNascimento;
    @XmlElement(required = true, nillable = true)
    protected String assessor;

    /**
     * Obt�m o valor da propriedade cgccpf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCgccpf() {
        return cgccpf;
    }

    /**
     * Define o valor da propriedade cgccpf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCgccpf(String value) {
        this.cgccpf = value;
    }

    /**
     * Obt�m o valor da propriedade cliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * Define o valor da propriedade cliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCliente(String value) {
        this.cliente = value;
    }

    /**
     * Obt�m o valor da propriedade dataNascimento.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Define o valor da propriedade dataNascimento.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataNascimento(String value) {
        this.dataNascimento = value;
    }

    /**
     * Obt�m o valor da propriedade assessor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssessor() {
        return assessor;
    }

    /**
     * Define o valor da propriedade assessor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssessor(String value) {
        this.assessor = value;
    }

}
