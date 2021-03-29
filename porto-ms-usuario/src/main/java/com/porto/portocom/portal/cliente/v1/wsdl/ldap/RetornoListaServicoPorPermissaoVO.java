
package com.porto.portocom.portal.cliente.v1.wsdl.ldap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for retornoListaServicoPorPermissaoVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="retornoListaServicoPorPermissaoVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoRetorno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="detalheServico" type="{http://service.portalcliente.seguranca.porto.com/}servicoPermissaoVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="mensagem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "retornoListaServicoPorPermissaoVO", propOrder = {
    "codigoRetorno",
    "detalheServico",
    "mensagem"
})
public class RetornoListaServicoPorPermissaoVO {

    protected String codigoRetorno;
    @XmlElement(nillable = true)
    protected List<ServicoPermissaoVO> detalheServico;
    protected String mensagem;

    /**
     * Gets the value of the codigoRetorno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoRetorno() {
        return codigoRetorno;
    }

    /**
     * Sets the value of the codigoRetorno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoRetorno(String value) {
        this.codigoRetorno = value;
    }

    /**
     * Gets the value of the detalheServico property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detalheServico property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetalheServico().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServicoPermissaoVO }
     * 
     * 
     */
    public List<ServicoPermissaoVO> getDetalheServico() {
        if (detalheServico == null) {
            detalheServico = new ArrayList<ServicoPermissaoVO>();
        }
        return this.detalheServico;
    }

    /**
     * Gets the value of the mensagem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * Sets the value of the mensagem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensagem(String value) {
        this.mensagem = value;
    }

}
