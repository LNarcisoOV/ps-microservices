
package com.porto.portocom.portal.cliente.v1.wsdl.conquista;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de obterDadosClienteArenaCadastrado complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="obterDadosClienteArenaCadastrado">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="isClienteArenaCadastrado" type="{http://impl.service.soap.arenaservicos.portopar.financeiro.porto.com/}isClienteCadastradoRequestType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obterDadosClienteArenaCadastrado", propOrder = {
    "isClienteArenaCadastrado"
})
public class ObterDadosClienteArenaCadastrado {

    protected IsClienteCadastradoRequestType isClienteArenaCadastrado;

    /**
     * Obt�m o valor da propriedade isClienteArenaCadastrado.
     * 
     * @return
     *     possible object is
     *     {@link IsClienteCadastradoRequestType }
     *     
     */
    public IsClienteCadastradoRequestType getIsClienteArenaCadastrado() {
        return isClienteArenaCadastrado;
    }

    /**
     * Define o valor da propriedade isClienteArenaCadastrado.
     * 
     * @param value
     *     allowed object is
     *     {@link IsClienteCadastradoRequestType }
     *     
     */
    public void setIsClienteArenaCadastrado(IsClienteCadastradoRequestType value) {
        this.isClienteArenaCadastrado = value;
    }

}
