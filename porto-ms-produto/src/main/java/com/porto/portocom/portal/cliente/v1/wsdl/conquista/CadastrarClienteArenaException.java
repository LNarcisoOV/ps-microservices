
package com.porto.portocom.portal.cliente.v1.wsdl.conquista;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de CadastrarClienteArenaException complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="CadastrarClienteArenaException">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="camposValidacao" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoCriticoEnum" type="{http://impl.service.soap.arenaservicos.portopar.financeiro.porto.com/}tipoCriticaEnum" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CadastrarClienteArenaException", propOrder = {
    "camposValidacao",
    "message",
    "tipoCriticoEnum"
})
public class CadastrarClienteArenaException {

    @XmlElement(nillable = true)
    protected List<String> camposValidacao;
    protected String message;
    @XmlSchemaType(name = "string")
    protected TipoCriticaEnum tipoCriticoEnum;

    /**
     * Gets the value of the camposValidacao property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the camposValidacao property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCamposValidacao().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCamposValidacao() {
        if (camposValidacao == null) {
            camposValidacao = new ArrayList<String>();
        }
        return this.camposValidacao;
    }

    /**
     * Obt�m o valor da propriedade message.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Define o valor da propriedade message.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Obt�m o valor da propriedade tipoCriticoEnum.
     * 
     * @return
     *     possible object is
     *     {@link TipoCriticaEnum }
     *     
     */
    public TipoCriticaEnum getTipoCriticoEnum() {
        return tipoCriticoEnum;
    }

    /**
     * Define o valor da propriedade tipoCriticoEnum.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoCriticaEnum }
     *     
     */
    public void setTipoCriticoEnum(TipoCriticaEnum value) {
        this.tipoCriticoEnum = value;
    }

}
