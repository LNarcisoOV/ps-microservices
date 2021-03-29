
package com.porto.portocom.portal.cliente.v1.wsdl.bcp;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java de ObterCorretorResponseType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ObterCorretorResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="corretor" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="codigoSusep" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="nomeFantasiaCorretor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="dataInicioRelacionamento" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                   &lt;element name="dataFinalRelacionamento" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                   &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObterCorretorResponseType", propOrder = {
    "corretor"
})
public class ObterCorretorResponseType {

    protected List<ObterCorretorResponseType.Corretor> corretor;

    /**
     * Gets the value of the corretor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the corretor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCorretor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ObterCorretorResponseType.Corretor }
     * 
     * 
     */
    public List<ObterCorretorResponseType.Corretor> getCorretor() {
        if (corretor == null) {
            corretor = new ArrayList<ObterCorretorResponseType.Corretor>();
        }
        return this.corretor;
    }


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
     *         &lt;element name="codigoSusep" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="nomeFantasiaCorretor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="dataInicioRelacionamento" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *         &lt;element name="dataFinalRelacionamento" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *         &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
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
        "codigoSusep",
        "nomeFantasiaCorretor",
        "dataInicioRelacionamento",
        "dataFinalRelacionamento",
        "numeroSequencia"
    })
    public static class Corretor {

        protected String codigoSusep;
        protected String nomeFantasiaCorretor;
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar dataInicioRelacionamento;
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar dataFinalRelacionamento;
        protected Short numeroSequencia;

        /**
         * Obt�m o valor da propriedade codigoSusep.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCodigoSusep() {
            return codigoSusep;
        }

        /**
         * Define o valor da propriedade codigoSusep.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCodigoSusep(String value) {
            this.codigoSusep = value;
        }

        /**
         * Obt�m o valor da propriedade nomeFantasiaCorretor.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNomeFantasiaCorretor() {
            return nomeFantasiaCorretor;
        }

        /**
         * Define o valor da propriedade nomeFantasiaCorretor.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNomeFantasiaCorretor(String value) {
            this.nomeFantasiaCorretor = value;
        }

        /**
         * Obt�m o valor da propriedade dataInicioRelacionamento.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDataInicioRelacionamento() {
            return dataInicioRelacionamento;
        }

        /**
         * Define o valor da propriedade dataInicioRelacionamento.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDataInicioRelacionamento(XMLGregorianCalendar value) {
            this.dataInicioRelacionamento = value;
        }

        /**
         * Obt�m o valor da propriedade dataFinalRelacionamento.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDataFinalRelacionamento() {
            return dataFinalRelacionamento;
        }

        /**
         * Define o valor da propriedade dataFinalRelacionamento.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDataFinalRelacionamento(XMLGregorianCalendar value) {
            this.dataFinalRelacionamento = value;
        }

        /**
         * Obt�m o valor da propriedade numeroSequencia.
         * 
         * @return
         *     possible object is
         *     {@link Short }
         *     
         */
        public Short getNumeroSequencia() {
            return numeroSequencia;
        }

        /**
         * Define o valor da propriedade numeroSequencia.
         * 
         * @param value
         *     allowed object is
         *     {@link Short }
         *     
         */
        public void setNumeroSequencia(Short value) {
            this.numeroSequencia = value;
        }

    }

}
