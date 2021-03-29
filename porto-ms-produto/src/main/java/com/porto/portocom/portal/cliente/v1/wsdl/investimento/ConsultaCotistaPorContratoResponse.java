
package com.porto.portocom.portal.cliente.v1.wsdl.investimento;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="consultaCotistaPorContratoReturn" type="{http://common.portopar.financeiro.porto.com}CotistaServiceVO"/>
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
    "consultaCotistaPorContratoReturn"
})
@XmlRootElement(name = "consultaCotistaPorContratoResponse")
public class ConsultaCotistaPorContratoResponse {

    @XmlElement(required = true, nillable = true)
    protected CotistaServiceVO consultaCotistaPorContratoReturn;

    /**
     * Obt�m o valor da propriedade consultaCotistaPorContratoReturn.
     * 
     * @return
     *     possible object is
     *     {@link CotistaServiceVO }
     *     
     */
    public CotistaServiceVO getConsultaCotistaPorContratoReturn() {
        return consultaCotistaPorContratoReturn;
    }

    /**
     * Define o valor da propriedade consultaCotistaPorContratoReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link CotistaServiceVO }
     *     
     */
    public void setConsultaCotistaPorContratoReturn(CotistaServiceVO value) {
        this.consultaCotistaPorContratoReturn = value;
    }

}
