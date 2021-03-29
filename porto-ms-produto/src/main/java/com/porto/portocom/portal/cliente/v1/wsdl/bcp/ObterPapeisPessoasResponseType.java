
package com.porto.portocom.portal.cliente.v1.wsdl.bcp;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java de ObterPapeisPessoasResponseType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ObterPapeisPessoasResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pessoa" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="codigoOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                   &lt;element name="codigoTipoPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="descricaoTipoPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="dataAtualizacaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                   &lt;element name="dataInclusaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                   &lt;element name="nomeOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="nomePessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="nomeTratamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                   &lt;element name="papeisPessoa" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="codigoPapelPessoa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="nomePapelPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="dataInicio" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="primeiroCodigoFonetico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="segundoCodigoFonetico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="terceiroCodigoFonetico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "ObterPapeisPessoasResponseType", propOrder = {
    "pessoa"
})
public class ObterPapeisPessoasResponseType {

    protected List<ObterPapeisPessoasResponseType.Pessoa> pessoa;

    /**
     * Gets the value of the pessoa property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pessoa property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPessoa().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ObterPapeisPessoasResponseType.Pessoa }
     * 
     * 
     */
    public List<ObterPapeisPessoasResponseType.Pessoa> getPessoa() {
        if (pessoa == null) {
            pessoa = new ArrayList<ObterPapeisPessoasResponseType.Pessoa>();
        }
        return this.pessoa;
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
     *         &lt;element name="codigoOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *         &lt;element name="codigoTipoPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="descricaoTipoPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="dataAtualizacaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *         &lt;element name="dataInclusaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *         &lt;element name="nomeOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="nomePessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="nomeTratamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *         &lt;element name="papeisPessoa" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="codigoPapelPessoa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="nomePapelPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="dataInicio" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="primeiroCodigoFonetico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="segundoCodigoFonetico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="terceiroCodigoFonetico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "codigoOrigemMovimento",
        "codigoTipoPessoa",
        "descricaoTipoPessoa",
        "dataAtualizacaoRegistro",
        "dataInclusaoRegistro",
        "nomeOrigemMovimento",
        "nomePessoa",
        "nomeTratamento",
        "numeroPessoa",
        "papeisPessoa",
        "primeiroCodigoFonetico",
        "segundoCodigoFonetico",
        "terceiroCodigoFonetico"
    })
    public static class Pessoa {

        protected Short codigoOrigemMovimento;
        protected String codigoTipoPessoa;
        protected String descricaoTipoPessoa;
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar dataAtualizacaoRegistro;
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar dataInclusaoRegistro;
        protected String nomeOrigemMovimento;
        protected String nomePessoa;
        protected String nomeTratamento;
        protected Long numeroPessoa;
        protected List<ObterPapeisPessoasResponseType.Pessoa.PapeisPessoa> papeisPessoa;
        protected String primeiroCodigoFonetico;
        protected String segundoCodigoFonetico;
        protected String terceiroCodigoFonetico;

        /**
         * Obt�m o valor da propriedade codigoOrigemMovimento.
         * 
         * @return
         *     possible object is
         *     {@link Short }
         *     
         */
        public Short getCodigoOrigemMovimento() {
            return codigoOrigemMovimento;
        }

        /**
         * Define o valor da propriedade codigoOrigemMovimento.
         * 
         * @param value
         *     allowed object is
         *     {@link Short }
         *     
         */
        public void setCodigoOrigemMovimento(Short value) {
            this.codigoOrigemMovimento = value;
        }

        /**
         * Obt�m o valor da propriedade codigoTipoPessoa.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCodigoTipoPessoa() {
            return codigoTipoPessoa;
        }

        /**
         * Define o valor da propriedade codigoTipoPessoa.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCodigoTipoPessoa(String value) {
            this.codigoTipoPessoa = value;
        }

        /**
         * Obt�m o valor da propriedade descricaoTipoPessoa.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDescricaoTipoPessoa() {
            return descricaoTipoPessoa;
        }

        /**
         * Define o valor da propriedade descricaoTipoPessoa.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDescricaoTipoPessoa(String value) {
            this.descricaoTipoPessoa = value;
        }

        /**
         * Obt�m o valor da propriedade dataAtualizacaoRegistro.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDataAtualizacaoRegistro() {
            return dataAtualizacaoRegistro;
        }

        /**
         * Define o valor da propriedade dataAtualizacaoRegistro.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDataAtualizacaoRegistro(XMLGregorianCalendar value) {
            this.dataAtualizacaoRegistro = value;
        }

        /**
         * Obt�m o valor da propriedade dataInclusaoRegistro.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDataInclusaoRegistro() {
            return dataInclusaoRegistro;
        }

        /**
         * Define o valor da propriedade dataInclusaoRegistro.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDataInclusaoRegistro(XMLGregorianCalendar value) {
            this.dataInclusaoRegistro = value;
        }

        /**
         * Obt�m o valor da propriedade nomeOrigemMovimento.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNomeOrigemMovimento() {
            return nomeOrigemMovimento;
        }

        /**
         * Define o valor da propriedade nomeOrigemMovimento.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNomeOrigemMovimento(String value) {
            this.nomeOrigemMovimento = value;
        }

        /**
         * Obt�m o valor da propriedade nomePessoa.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNomePessoa() {
            return nomePessoa;
        }

        /**
         * Define o valor da propriedade nomePessoa.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNomePessoa(String value) {
            this.nomePessoa = value;
        }

        /**
         * Obt�m o valor da propriedade nomeTratamento.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNomeTratamento() {
            return nomeTratamento;
        }

        /**
         * Define o valor da propriedade nomeTratamento.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNomeTratamento(String value) {
            this.nomeTratamento = value;
        }

        /**
         * Obt�m o valor da propriedade numeroPessoa.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getNumeroPessoa() {
            return numeroPessoa;
        }

        /**
         * Define o valor da propriedade numeroPessoa.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setNumeroPessoa(Long value) {
            this.numeroPessoa = value;
        }

        /**
         * Gets the value of the papeisPessoa property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the papeisPessoa property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPapeisPessoa().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ObterPapeisPessoasResponseType.Pessoa.PapeisPessoa }
         * 
         * 
         */
        public List<ObterPapeisPessoasResponseType.Pessoa.PapeisPessoa> getPapeisPessoa() {
            if (papeisPessoa == null) {
                papeisPessoa = new ArrayList<ObterPapeisPessoasResponseType.Pessoa.PapeisPessoa>();
            }
            return this.papeisPessoa;
        }

        /**
         * Obt�m o valor da propriedade primeiroCodigoFonetico.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPrimeiroCodigoFonetico() {
            return primeiroCodigoFonetico;
        }

        /**
         * Define o valor da propriedade primeiroCodigoFonetico.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPrimeiroCodigoFonetico(String value) {
            this.primeiroCodigoFonetico = value;
        }

        /**
         * Obt�m o valor da propriedade segundoCodigoFonetico.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSegundoCodigoFonetico() {
            return segundoCodigoFonetico;
        }

        /**
         * Define o valor da propriedade segundoCodigoFonetico.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSegundoCodigoFonetico(String value) {
            this.segundoCodigoFonetico = value;
        }

        /**
         * Obt�m o valor da propriedade terceiroCodigoFonetico.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTerceiroCodigoFonetico() {
            return terceiroCodigoFonetico;
        }

        /**
         * Define o valor da propriedade terceiroCodigoFonetico.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTerceiroCodigoFonetico(String value) {
            this.terceiroCodigoFonetico = value;
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
         *         &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="dataInicio" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
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
            "numeroPessoa",
            "dataInicio"
        })
        public static class PapeisPessoa {

            protected Short codigoPapelPessoa;
            protected String nomePapelPessoa;
            protected Long numeroPessoa;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dataInicio;

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
             * Obt�m o valor da propriedade numeroPessoa.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getNumeroPessoa() {
                return numeroPessoa;
            }

            /**
             * Define o valor da propriedade numeroPessoa.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setNumeroPessoa(Long value) {
                this.numeroPessoa = value;
            }

            /**
             * Obt�m o valor da propriedade dataInicio.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getDataInicio() {
                return dataInicio;
            }

            /**
             * Define o valor da propriedade dataInicio.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setDataInicio(XMLGregorianCalendar value) {
                this.dataInicio = value;
            }

        }

    }

}
