
package com.porto.portocom.portal.cliente.v1.wsdl.bcp;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java de ObterFuncionarioPrestadorResponseType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ObterFuncionarioPrestadorResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dadosFuncPrest" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="codigoPapelPessoa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                   &lt;element name="nomePapelPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="codigoCargo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="codigoEmpresa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                   &lt;element name="nomeEmpresa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="codigoEstruturaCargo" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                   &lt;element name="dataAdmissao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                   &lt;element name="dataDesligamento" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                   &lt;element name="numeroMatricula" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                   &lt;element name="codigoPrestadorSistemaOrigem" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                   &lt;element name="codigoTipoPrestador" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                   &lt;element name="nomeTipoPrestador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "ObterFuncionarioPrestadorResponseType", propOrder = {
    "dadosFuncPrest"
})
public class ObterFuncionarioPrestadorResponseType {

    protected List<ObterFuncionarioPrestadorResponseType.DadosFuncPrest> dadosFuncPrest;

    /**
     * Gets the value of the dadosFuncPrest property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dadosFuncPrest property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDadosFuncPrest().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ObterFuncionarioPrestadorResponseType.DadosFuncPrest }
     * 
     * 
     */
    public List<ObterFuncionarioPrestadorResponseType.DadosFuncPrest> getDadosFuncPrest() {
        if (dadosFuncPrest == null) {
            dadosFuncPrest = new ArrayList<ObterFuncionarioPrestadorResponseType.DadosFuncPrest>();
        }
        return this.dadosFuncPrest;
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
     *         &lt;element name="codigoPapelPessoa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *         &lt;element name="nomePapelPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="codigoCargo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="codigoEmpresa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *         &lt;element name="nomeEmpresa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="codigoEstruturaCargo" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *         &lt;element name="dataAdmissao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *         &lt;element name="dataDesligamento" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *         &lt;element name="numeroMatricula" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *         &lt;element name="codigoPrestadorSistemaOrigem" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *         &lt;element name="codigoTipoPrestador" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *         &lt;element name="nomeTipoPrestador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "codigoPapelPessoa",
        "nomePapelPessoa",
        "codigoCargo",
        "codigoEmpresa",
        "nomeEmpresa",
        "codigoEstruturaCargo",
        "dataAdmissao",
        "dataDesligamento",
        "numeroMatricula",
        "numeroSequencia",
        "codigoPrestadorSistemaOrigem",
        "codigoTipoPrestador",
        "nomeTipoPrestador"
    })
    public static class DadosFuncPrest {

        protected Short codigoPapelPessoa;
        protected String nomePapelPessoa;
        protected String codigoCargo;
        protected Short codigoEmpresa;
        protected String nomeEmpresa;
        protected Short codigoEstruturaCargo;
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar dataAdmissao;
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar dataDesligamento;
        protected String numeroMatricula;
        protected Short numeroSequencia;
        protected Long codigoPrestadorSistemaOrigem;
        protected Short codigoTipoPrestador;
        protected String nomeTipoPrestador;

        /**
         * Obt�m o valor da propriedade codigoPapelPessoa.
         * 
         * @return
         *     possible object is
         *     {@link Short }
         *     
         */
        public Short getCodigoPapelPessoa() {
            return codigoPapelPessoa;
        }

        /**
         * Define o valor da propriedade codigoPapelPessoa.
         * 
         * @param value
         *     allowed object is
         *     {@link Short }
         *     
         */
        public void setCodigoPapelPessoa(Short value) {
            this.codigoPapelPessoa = value;
        }

        /**
         * Obt�m o valor da propriedade nomePapelPessoa.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNomePapelPessoa() {
            return nomePapelPessoa;
        }

        /**
         * Define o valor da propriedade nomePapelPessoa.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNomePapelPessoa(String value) {
            this.nomePapelPessoa = value;
        }

        /**
         * Obt�m o valor da propriedade codigoCargo.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCodigoCargo() {
            return codigoCargo;
        }

        /**
         * Define o valor da propriedade codigoCargo.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCodigoCargo(String value) {
            this.codigoCargo = value;
        }

        /**
         * Obt�m o valor da propriedade codigoEmpresa.
         * 
         * @return
         *     possible object is
         *     {@link Short }
         *     
         */
        public Short getCodigoEmpresa() {
            return codigoEmpresa;
        }

        /**
         * Define o valor da propriedade codigoEmpresa.
         * 
         * @param value
         *     allowed object is
         *     {@link Short }
         *     
         */
        public void setCodigoEmpresa(Short value) {
            this.codigoEmpresa = value;
        }

        /**
         * Obt�m o valor da propriedade nomeEmpresa.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNomeEmpresa() {
            return nomeEmpresa;
        }

        /**
         * Define o valor da propriedade nomeEmpresa.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNomeEmpresa(String value) {
            this.nomeEmpresa = value;
        }

        /**
         * Obt�m o valor da propriedade codigoEstruturaCargo.
         * 
         * @return
         *     possible object is
         *     {@link Short }
         *     
         */
        public Short getCodigoEstruturaCargo() {
            return codigoEstruturaCargo;
        }

        /**
         * Define o valor da propriedade codigoEstruturaCargo.
         * 
         * @param value
         *     allowed object is
         *     {@link Short }
         *     
         */
        public void setCodigoEstruturaCargo(Short value) {
            this.codigoEstruturaCargo = value;
        }

        /**
         * Obt�m o valor da propriedade dataAdmissao.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDataAdmissao() {
            return dataAdmissao;
        }

        /**
         * Define o valor da propriedade dataAdmissao.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDataAdmissao(XMLGregorianCalendar value) {
            this.dataAdmissao = value;
        }

        /**
         * Obt�m o valor da propriedade dataDesligamento.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDataDesligamento() {
            return dataDesligamento;
        }

        /**
         * Define o valor da propriedade dataDesligamento.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDataDesligamento(XMLGregorianCalendar value) {
            this.dataDesligamento = value;
        }

        /**
         * Obt�m o valor da propriedade numeroMatricula.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNumeroMatricula() {
            return numeroMatricula;
        }

        /**
         * Define o valor da propriedade numeroMatricula.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNumeroMatricula(String value) {
            this.numeroMatricula = value;
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

        /**
         * Obt�m o valor da propriedade codigoPrestadorSistemaOrigem.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getCodigoPrestadorSistemaOrigem() {
            return codigoPrestadorSistemaOrigem;
        }

        /**
         * Define o valor da propriedade codigoPrestadorSistemaOrigem.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setCodigoPrestadorSistemaOrigem(Long value) {
            this.codigoPrestadorSistemaOrigem = value;
        }

        /**
         * Obt�m o valor da propriedade codigoTipoPrestador.
         * 
         * @return
         *     possible object is
         *     {@link Short }
         *     
         */
        public Short getCodigoTipoPrestador() {
            return codigoTipoPrestador;
        }

        /**
         * Define o valor da propriedade codigoTipoPrestador.
         * 
         * @param value
         *     allowed object is
         *     {@link Short }
         *     
         */
        public void setCodigoTipoPrestador(Short value) {
            this.codigoTipoPrestador = value;
        }

        /**
         * Obt�m o valor da propriedade nomeTipoPrestador.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNomeTipoPrestador() {
            return nomeTipoPrestador;
        }

        /**
         * Define o valor da propriedade nomeTipoPrestador.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNomeTipoPrestador(String value) {
            this.nomeTipoPrestador = value;
        }

    }

}
