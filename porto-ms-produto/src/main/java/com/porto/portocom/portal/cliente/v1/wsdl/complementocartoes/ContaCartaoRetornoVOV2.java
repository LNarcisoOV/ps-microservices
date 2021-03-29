
package com.porto.portocom.portal.cliente.v1.wsdl.complementocartoes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for contaCartaoRetornoVOV2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contaCartaoRetornoVOV2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoRetorno" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="contasVOs" type="{http://ws.cartaoweb.cartoes.financeiro.com/}contaVOV2" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="mensagemRetorno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contaCartaoRetornoVOV2", propOrder = {
    "codigoRetorno",
    "contasVOs",
    "mensagemRetorno",
    "nome",
    "vip"
})
public class ContaCartaoRetornoVOV2 implements Serializable {

	private static final long serialVersionUID = 1477655381106442112L;

	protected Integer codigoRetorno;
    @XmlElement(nillable = true)
    protected List<ContaVOV2> contasVOs;
    protected String mensagemRetorno;
    protected String nome;
    protected String vip;

    /**
     * Gets the value of the codigoRetorno property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodigoRetorno() {
        return codigoRetorno;
    }

    /**
     * Sets the value of the codigoRetorno property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodigoRetorno(Integer value) {
        this.codigoRetorno = value;
    }

    /**
     * Gets the value of the contasVOs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contasVOs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContasVOs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContaVOV2 }
     * 
     * 
     */
    public List<ContaVOV2> getContasVOs() {
        if (contasVOs == null) {
            contasVOs = new ArrayList<ContaVOV2>();
        }
        return this.contasVOs;
    }

    /**
     * Gets the value of the mensagemRetorno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensagemRetorno() {
        return mensagemRetorno;
    }

    /**
     * Sets the value of the mensagemRetorno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensagemRetorno(String value) {
        this.mensagemRetorno = value;
    }

    /**
     * Gets the value of the nome property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets the value of the nome property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNome(String value) {
        this.nome = value;
    }

    /**
     * Gets the value of the vip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVip() {
        return vip;
    }

    /**
     * Sets the value of the vip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVip(String value) {
        this.vip = value;
    }

}
