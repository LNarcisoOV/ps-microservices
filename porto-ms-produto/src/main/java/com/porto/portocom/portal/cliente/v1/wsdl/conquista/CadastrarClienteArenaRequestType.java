
package com.porto.portocom.portal.cliente.v1.wsdl.conquista;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de cadastrarClienteArenaRequestType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="cadastrarClienteArenaRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cliente_arena" type="{http://impl.service.soap.arenaservicos.portopar.financeiro.porto.com/}clienteArenaType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cadastrarClienteArenaRequestType", propOrder = {
    "clienteArena"
})
public class CadastrarClienteArenaRequestType {

    @XmlElement(name = "cliente_arena", required = true)
    protected ClienteArenaType clienteArena;

    /**
     * Obt�m o valor da propriedade clienteArena.
     * 
     * @return
     *     possible object is
     *     {@link ClienteArenaType }
     *     
     */
    public ClienteArenaType getClienteArena() {
        return clienteArena;
    }

    /**
     * Define o valor da propriedade clienteArena.
     * 
     * @param value
     *     allowed object is
     *     {@link ClienteArenaType }
     *     
     */
    public void setClienteArena(ClienteArenaType value) {
        this.clienteArena = value;
    }

}
