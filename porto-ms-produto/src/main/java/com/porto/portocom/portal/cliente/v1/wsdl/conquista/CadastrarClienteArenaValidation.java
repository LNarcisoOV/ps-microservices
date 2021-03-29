
package com.porto.portocom.portal.cliente.v1.wsdl.conquista;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de cadastrarClienteArenaValidation complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="cadastrarClienteArenaValidation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cadastrarClienteArenaValidation" type="{http://impl.service.soap.arenaservicos.portopar.financeiro.porto.com/}cadastrarClienteArenaRequestType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cadastrarClienteArenaValidation", propOrder = {
    "cadastrarClienteArenaValidation"
})
public class CadastrarClienteArenaValidation {

    protected CadastrarClienteArenaRequestType cadastrarClienteArenaValidation;

    /**
     * Obt�m o valor da propriedade cadastrarClienteArenaValidation.
     * 
     * @return
     *     possible object is
     *     {@link CadastrarClienteArenaRequestType }
     *     
     */
    public CadastrarClienteArenaRequestType getCadastrarClienteArenaValidation() {
        return cadastrarClienteArenaValidation;
    }

    /**
     * Define o valor da propriedade cadastrarClienteArenaValidation.
     * 
     * @param value
     *     allowed object is
     *     {@link CadastrarClienteArenaRequestType }
     *     
     */
    public void setCadastrarClienteArenaValidation(CadastrarClienteArenaRequestType value) {
        this.cadastrarClienteArenaValidation = value;
    }

}
