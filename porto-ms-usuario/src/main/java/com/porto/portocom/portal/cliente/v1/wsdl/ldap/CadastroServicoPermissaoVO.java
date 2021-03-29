
package com.porto.portocom.portal.cliente.v1.wsdl.ldap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cadastroServicoPermissaoVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cadastroServicoPermissaoVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="permissao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="servicos" type="{http://service.portalcliente.seguranca.porto.com/}servicoPermissaoVO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cadastroServicoPermissaoVO", propOrder = {
    "permissao",
    "servicos"
})
public class CadastroServicoPermissaoVO {

    protected String permissao;
    @XmlElement(nillable = true)
    protected List<ServicoPermissaoVO> servicos;

    /**
     * Gets the value of the permissao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPermissao() {
        return permissao;
    }

    /**
     * Sets the value of the permissao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPermissao(String value) {
        this.permissao = value;
    }

    /**
     * Gets the value of the servicos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the servicos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServicos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServicoPermissaoVO }
     * 
     * 
     */
    public List<ServicoPermissaoVO> getServicos() {
        if (servicos == null) {
            servicos = new ArrayList<ServicoPermissaoVO>();
        }
        return this.servicos;
    }

}
