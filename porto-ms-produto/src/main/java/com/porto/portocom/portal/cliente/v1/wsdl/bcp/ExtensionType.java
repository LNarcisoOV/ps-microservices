
package com.porto.portocom.portal.cliente.v1.wsdl.bcp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;

/**
 * Elemento usado para casos elegiveis para extens�o de uma mensagem ou tipo.
 * 
 * <p>
 * Classe Java de ExtensionType complex type.
 * 
 * <p>
 * O seguinte fragmento do esquema especifica o conte�do esperado contido dentro
 * desta classe.
 * 
 * <pre>
 * &lt;complexType name="ExtensionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtensionType", namespace = "http://www.portoseguro.com.br/ebo/Common/V1_0", propOrder = { "any" })
public class ExtensionType implements Serializable {

	private static final long serialVersionUID = 4075366018569793107L;

	@XmlAnyElement(lax = true)
	protected List<Object> any;

	/**
	 * Gets the value of the any property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the any property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getAny().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list {@link Element }
	 * {@link Object }
	 * 
	 * 
	 */
	public List<Object> getAny() {
		if (any == null) {
			any = new ArrayList<Object>();
		}
		return this.any;
	}

}
