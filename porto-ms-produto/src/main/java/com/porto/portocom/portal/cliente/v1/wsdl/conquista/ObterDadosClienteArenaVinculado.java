
package com.porto.portocom.portal.cliente.v1.wsdl.conquista;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de obterDadosClienteArenaVinculado complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="obterDadosClienteArenaVinculado">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="isClienteArenaCadastrado" type="{http://impl.service.soap.arenaservicos.portopar.financeiro.porto.com/}isClienteCadastradoRequestType" minOccurs="0"/>
 *         &lt;element name="susep" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obterDadosClienteArenaVinculado", propOrder = {
    "isClienteArenaCadastrado",
    "susep"
})
public class ObterDadosClienteArenaVinculado {

    protected IsClienteCadastradoRequestType isClienteArenaCadastrado;
    protected String susep;

    /**
     * Obtém o valor da propriedade isClienteArenaCadastrado.
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

    /**
     * Obtém o valor da propriedade susep.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSusep() {
        return susep;
    }

    /**
     * Define o valor da propriedade susep.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSusep(String value) {
        this.susep = value;
    }

}
