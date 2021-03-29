
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
 *         &lt;element name="consultaCotistaCompletoPorContratoReturn" type="{http://common.portopar.financeiro.porto.com}CotistaCompletoServiceVO"/>
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
    "consultaCotistaCompletoPorContratoReturn"
})
@XmlRootElement(name = "consultaCotistaCompletoPorContratoResponse")
public class ConsultaCotistaCompletoPorContratoResponse {

    @XmlElement(required = true, nillable = true)
    protected CotistaCompletoServiceVO consultaCotistaCompletoPorContratoReturn;

    /**
     * Obt�m o valor da propriedade consultaCotistaCompletoPorContratoReturn.
     * 
     * @return
     *     possible object is
     *     {@link CotistaCompletoServiceVO }
     *     
     */
    public CotistaCompletoServiceVO getConsultaCotistaCompletoPorContratoReturn() {
        return consultaCotistaCompletoPorContratoReturn;
    }

    /**
     * Define o valor da propriedade consultaCotistaCompletoPorContratoReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link CotistaCompletoServiceVO }
     *     
     */
    public void setConsultaCotistaCompletoPorContratoReturn(CotistaCompletoServiceVO value) {
        this.consultaCotistaCompletoPorContratoReturn = value;
    }

}
