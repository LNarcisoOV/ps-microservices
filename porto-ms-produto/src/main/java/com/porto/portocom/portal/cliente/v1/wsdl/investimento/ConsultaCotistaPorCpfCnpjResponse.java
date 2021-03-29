
package com.porto.portocom.portal.cliente.v1.wsdl.investimento;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="consultaCotistaPorCpfCnpjReturn" type="{http://common.portopar.financeiro.porto.com}CotistaServiceVO" maxOccurs="unbounded"/>
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
    "consultaCotistaPorCpfCnpjReturn"
})
@XmlRootElement(name = "consultaCotistaPorCpfCnpjResponse")
public class ConsultaCotistaPorCpfCnpjResponse {

    @XmlElement(required = true)
    protected List<CotistaServiceVO> consultaCotistaPorCpfCnpjReturn;

    /**
     * Gets the value of the consultaCotistaPorCpfCnpjReturn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the consultaCotistaPorCpfCnpjReturn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConsultaCotistaPorCpfCnpjReturn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CotistaServiceVO }
     * 
     * 
     */
    public List<CotistaServiceVO> getConsultaCotistaPorCpfCnpjReturn() {
        if (consultaCotistaPorCpfCnpjReturn == null) {
            consultaCotistaPorCpfCnpjReturn = new ArrayList<CotistaServiceVO>();
        }
        return this.consultaCotistaPorCpfCnpjReturn;
    }

}
