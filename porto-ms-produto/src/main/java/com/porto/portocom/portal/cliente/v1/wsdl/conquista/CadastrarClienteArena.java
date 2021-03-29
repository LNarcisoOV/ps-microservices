
package com.porto.portocom.portal.cliente.v1.wsdl.conquista;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de cadastrarClienteArena complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="cadastrarClienteArena">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cadastrarClienteArena" type="{http://impl.service.soap.arenaservicos.portopar.financeiro.porto.com/}cadastrarClienteArenaRequestType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cadastrarClienteArena", propOrder = {
    "cadastrarClienteArena"
})
public class CadastrarClienteArena {

    protected CadastrarClienteArenaRequestType cadastrarClienteArena;

    /**
     * Obt�m o valor da propriedade cadastrarClienteArena.
     * 
     * @return
     *     possible object is
     *     {@link CadastrarClienteArenaRequestType }
     *     
     */
    public CadastrarClienteArenaRequestType getCadastrarClienteArena() {
        return cadastrarClienteArena;
    }

    /**
     * Define o valor da propriedade cadastrarClienteArena.
     * 
     * @param value
     *     allowed object is
     *     {@link CadastrarClienteArenaRequestType }
     *     
     */
    public void setCadastrarClienteArena(CadastrarClienteArenaRequestType value) {
        this.cadastrarClienteArena = value;
    }

}
