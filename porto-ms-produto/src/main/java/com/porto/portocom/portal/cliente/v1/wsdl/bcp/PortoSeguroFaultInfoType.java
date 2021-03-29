
package com.porto.portocom.portal.cliente.v1.wsdl.bcp;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Elemento usado para encapsular informa��es de
 * 				falhas na execucao de servicos.
 * 
 * <p>Classe Java de PortoSeguroFaultInfoType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="PortoSeguroFaultInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigo" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="mensagem" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dataOcorrencia" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="fonte" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipo">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="NEGOCIO"/>
 *               &lt;enumeration value="SISTEMA"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="additionalInfo" type="{http://www.portoseguro.com.br/ebo/Common/V1_0}ExtensionType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PortoSeguroFaultInfoType", namespace = "http://www.portoseguro.com.br/foundation/PortoSeguroMessage", propOrder = {
    "codigo",
    "mensagem",
    "dataOcorrencia",
    "fonte",
    "tipo",
    "additionalInfo"
})
public class PortoSeguroFaultInfoType {

    @XmlElement(required = true)
    protected BigInteger codigo;
    @XmlElement(required = true)
    protected String mensagem;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataOcorrencia;
    @XmlElement(required = true)
    protected String fonte;
    @XmlElement(required = true)
    protected String tipo;
    @XmlElement(required = true)
    protected ExtensionType additionalInfo;

    /**
     * Obt�m o valor da propriedade codigo.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCodigo() {
        return codigo;
    }

    /**
     * Define o valor da propriedade codigo.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCodigo(BigInteger value) {
        this.codigo = value;
    }

    /**
     * Obt�m o valor da propriedade mensagem.
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
     * Define o valor da propriedade mensagem.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensagem(String value) {
        this.mensagem = value;
    }

    /**
     * Obt�m o valor da propriedade dataOcorrencia.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataOcorrencia() {
        return dataOcorrencia;
    }

    /**
     * Define o valor da propriedade dataOcorrencia.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataOcorrencia(XMLGregorianCalendar value) {
        this.dataOcorrencia = value;
    }

    /**
     * Obt�m o valor da propriedade fonte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFonte() {
        return fonte;
    }

    /**
     * Define o valor da propriedade fonte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFonte(String value) {
        this.fonte = value;
    }

    /**
     * Obt�m o valor da propriedade tipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define o valor da propriedade tipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipo(String value) {
        this.tipo = value;
    }

    /**
     * Obt�m o valor da propriedade additionalInfo.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionType }
     *     
     */
    public ExtensionType getAdditionalInfo() {
        return additionalInfo;
    }

    /**
     * Define o valor da propriedade additionalInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionType }
     *     
     */
    public void setAdditionalInfo(ExtensionType value) {
        this.additionalInfo = value;
    }

}
