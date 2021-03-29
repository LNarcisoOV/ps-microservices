
package com.porto.portocom.portal.cliente.v1.wsdl.conquista;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de cadastrarClienteArenaValidationResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="cadastrarClienteArenaValidationResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://impl.service.soap.arenaservicos.portopar.financeiro.porto.com/}cadastrarClienteArenaResponseType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cadastrarClienteArenaValidationResponse", propOrder = {
    "_return"
})
public class CadastrarClienteArenaValidationResponse {

    @XmlElement(name = "return")
    protected CadastrarClienteArenaResponseType _return;

    /**
     * Obt�m o valor da propriedade return.
     * 
     * @return
     *     possible object is
     *     {@link CadastrarClienteArenaResponseType }
     *     
     */
    public CadastrarClienteArenaResponseType getReturn() {
        return _return;
    }

    /**
     * Define o valor da propriedade return.
     * 
     * @param value
     *     allowed object is
     *     {@link CadastrarClienteArenaResponseType }
     *     
     */
    public void setReturn(CadastrarClienteArenaResponseType value) {
        this._return = value;
    }

}
