
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
 *         &lt;element name="consultaCotistaCompletoPorCpfCnpjReturn" type="{http://common.portopar.financeiro.porto.com}CotistaCompletoServiceVO" maxOccurs="unbounded"/>
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
    "consultaCotistaCompletoPorCpfCnpjReturn"
})
@XmlRootElement(name = "consultaCotistaCompletoPorCpfCnpjResponse")
public class ConsultaCotistaCompletoPorCpfCnpjResponse {

    @XmlElement(required = true)
    protected List<CotistaCompletoServiceVO> consultaCotistaCompletoPorCpfCnpjReturn;

    /**
     * Gets the value of the consultaCotistaCompletoPorCpfCnpjReturn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the consultaCotistaCompletoPorCpfCnpjReturn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConsultaCotistaCompletoPorCpfCnpjReturn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CotistaCompletoServiceVO }
     * 
     * 
     */
    public List<CotistaCompletoServiceVO> getConsultaCotistaCompletoPorCpfCnpjReturn() {
        if (consultaCotistaCompletoPorCpfCnpjReturn == null) {
            consultaCotistaCompletoPorCpfCnpjReturn = new ArrayList<CotistaCompletoServiceVO>();
        }
        return this.consultaCotistaCompletoPorCpfCnpjReturn;
    }

}
