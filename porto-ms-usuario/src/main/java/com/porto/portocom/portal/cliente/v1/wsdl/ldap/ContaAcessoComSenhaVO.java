
package com.porto.portocom.portal.cliente.v1.wsdl.ldap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for contaAcessoComSenhaVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="contaAcessoComSenhaVO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://service.portalcliente.seguranca.porto.com/}contaAcessoVO">
 *       &lt;sequence>
 *         &lt;element name="senha" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "contaAcessoComSenhaVO", propOrder = {
    "senha"
})
public class ContaAcessoComSenhaVO
    extends ContaAcessoVO
{

    protected String senha;

    /**
     * Gets the value of the senha property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Sets the value of the senha property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenha(String value) {
        this.senha = value;
    }

}
