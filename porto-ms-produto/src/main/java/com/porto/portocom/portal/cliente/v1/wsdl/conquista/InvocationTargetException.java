
package com.porto.portocom.portal.cliente.v1.wsdl.conquista;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de InvocationTargetException complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="InvocationTargetException">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="targetException" type="{http://impl.service.soap.arenaservicos.portopar.financeiro.porto.com/}throwable" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvocationTargetException", propOrder = {
    "message",
    "targetException"
})
public class InvocationTargetException {

    protected String message;
    protected Throwable targetException;

    /**
     * Obt�m o valor da propriedade message.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Define o valor da propriedade message.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Obt�m o valor da propriedade targetException.
     * 
     * @return
     *     possible object is
     *     {@link Throwable }
     *     
     */
    public Throwable getTargetException() {
        return targetException;
    }

    /**
     * Define o valor da propriedade targetException.
     * 
     * @param value
     *     allowed object is
     *     {@link Throwable }
     *     
     */
    public void setTargetException(Throwable value) {
        this.targetException = value;
    }

}
