
package com.porto.portocom.portal.cliente.v1.wsdl.conquista;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de obterDadosClienteArenaVinculadoResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="obterDadosClienteArenaVinculadoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://impl.service.soap.arenaservicos.portopar.financeiro.porto.com/}isClienteCadastradoResponseType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obterDadosClienteArenaVinculadoResponse", propOrder = {
    "_return"
})
public class ObterDadosClienteArenaVinculadoResponse {

    @XmlElement(name = "return")
    protected IsClienteCadastradoResponseType _return;

    /**
     * Obtém o valor da propriedade return.
     * 
     * @return
     *     possible object is
     *     {@link IsClienteCadastradoResponseType }
     *     
     */
    public IsClienteCadastradoResponseType getReturn() {
        return _return;
    }

    /**
     * Define o valor da propriedade return.
     * 
     * @param value
     *     allowed object is
     *     {@link IsClienteCadastradoResponseType }
     *     
     */
    public void setReturn(IsClienteCadastradoResponseType value) {
        this._return = value;
    }

}
