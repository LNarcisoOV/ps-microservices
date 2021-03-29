
package com.porto.portocom.portal.cliente.v1.wsdl.vdo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.porto.portocom.portal.cliente.v1.wsdl.vdo.common.VendaOnlineResponse;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pesquisaCotacoesVendaOnlineReturn" type="{http://common.marketing.porto.com}VendaOnlineResponse"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pesquisaCotacoesVendaOnlineReturn"
})
@XmlRootElement(name = "pesquisaCotacoesVendaOnlineResponse")
public class PesquisaCotacoesVendaOnlineResponse {

    @XmlElement(required = true, nillable = true)
    protected VendaOnlineResponse pesquisaCotacoesVendaOnlineReturn;

    /**
     * Gets the value of the pesquisaCotacoesVendaOnlineReturn property.
     * 
     * @return
     *     possible object is
     *     {@link VendaOnlineResponse }
     *     
     */
    public VendaOnlineResponse getPesquisaCotacoesVendaOnlineReturn() {
        return pesquisaCotacoesVendaOnlineReturn;
    }

    /**
     * Sets the value of the pesquisaCotacoesVendaOnlineReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link VendaOnlineResponse }
     *     
     */
    public void setPesquisaCotacoesVendaOnlineReturn(VendaOnlineResponse value) {
        this.pesquisaCotacoesVendaOnlineReturn = value;
    }

}
