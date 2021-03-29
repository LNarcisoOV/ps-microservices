
package com.porto.portocom.portal.cliente.v1.wsdl.bcp;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java de ObterListaContratosResponseType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ObterListaContratosResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contratos" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="chaveDocumento" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="chave" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="valor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                   &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="codigoProdutoBcp" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                   &lt;element name="nomeProdutoBcp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="dataEmissao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                   &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                   &lt;element name="dataFinalVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                   &lt;element name="codigoOrigemProposta" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                   &lt;element name="numeroDigitoProposta" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                   &lt;element name="codigoCanalVenda" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                   &lt;element name="nomeCanalVenda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="codigoEmpresaQuemEmitiu" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                   &lt;element name="nomeEmpresaQuemEmitiu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="codigoSusep" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="numeroContratoSistemaOrigem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="codigoSituacaoContrato" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                   &lt;element name="nomeSituacaoContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "ObterListaContratosResponseType", propOrder = {
    "contratos"
})
public class ObterListaContratosResponseType {

    protected List<ObterListaContratosResponseType.Contratos> contratos;

    /**
     * Gets the value of the contratos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contratos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContratos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ObterListaContratosResponseType.Contratos }
     * 
     * 
     */
    public List<ObterListaContratosResponseType.Contratos> getContratos() {
        if (contratos == null) {
            contratos = new ArrayList<ObterListaContratosResponseType.Contratos>();
        }
        return this.contratos;
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
     *         &lt;element name="chaveDocumento" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="chave" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="valor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *         &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="codigoProdutoBcp" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *         &lt;element name="nomeProdutoBcp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="dataEmissao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *         &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *         &lt;element name="dataFinalVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *         &lt;element name="codigoOrigemProposta" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *         &lt;element name="numeroDigitoProposta" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *         &lt;element name="codigoCanalVenda" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *         &lt;element name="nomeCanalVenda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="codigoEmpresaQuemEmitiu" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *         &lt;element name="nomeEmpresaQuemEmitiu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="codigoSusep" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="numeroContratoSistemaOrigem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="codigoSituacaoContrato" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *         &lt;element name="nomeSituacaoContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "chaveDocumento",
        "numeroPessoa",
        "numeroContrato",
        "codigoProdutoBcp",
        "nomeProdutoBcp",
        "dataEmissao",
        "dataInicioVigencia",
        "dataFinalVigencia",
        "codigoOrigemProposta",
        "numeroDigitoProposta",
        "codigoCanalVenda",
        "nomeCanalVenda",
        "codigoEmpresaQuemEmitiu",
        "nomeEmpresaQuemEmitiu",
        "codigoSusep",
        "numeroContratoSistemaOrigem",
        "codigoSituacaoContrato",
        "nomeSituacaoContrato"
    })
    public static class Contratos {

        protected List<ObterListaContratosResponseType.Contratos.ChaveDocumento> chaveDocumento;
        protected Long numeroPessoa;
        protected String numeroContrato;
        protected Short codigoProdutoBcp;
        protected String nomeProdutoBcp;
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar dataEmissao;
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar dataInicioVigencia;
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar dataFinalVigencia;
        protected Short codigoOrigemProposta;
        protected Long numeroDigitoProposta;
        protected Short codigoCanalVenda;
        protected String nomeCanalVenda;
        protected Short codigoEmpresaQuemEmitiu;
        protected String nomeEmpresaQuemEmitiu;
        protected String codigoSusep;
        protected String numeroContratoSistemaOrigem;
        protected Short codigoSituacaoContrato;
        protected String nomeSituacaoContrato;

        /**
         * Gets the value of the chaveDocumento property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the chaveDocumento property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getChaveDocumento().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ObterListaContratosResponseType.Contratos.ChaveDocumento }
         * 
         * 
         */
        public List<ObterListaContratosResponseType.Contratos.ChaveDocumento> getChaveDocumento() {
            if (chaveDocumento == null) {
                chaveDocumento = new ArrayList<ObterListaContratosResponseType.Contratos.ChaveDocumento>();
            }
            return this.chaveDocumento;
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
         * Obt�m o valor da propriedade numeroContrato.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNumeroContrato() {
            return numeroContrato;
        }

        /**
         * Define o valor da propriedade numeroContrato.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNumeroContrato(String value) {
            this.numeroContrato = value;
        }

        /**
         * Obt�m o valor da propriedade codigoProdutoBcp.
         * 
         * @return
         *     possible object is
         *     {@link Short }
         *     
         */
        public Short getCodigoProdutoBcp() {
            return codigoProdutoBcp;
        }

        /**
         * Define o valor da propriedade codigoProdutoBcp.
         * 
         * @param value
         *     allowed object is
         *     {@link Short }
         *     
         */
        public void setCodigoProdutoBcp(Short value) {
            this.codigoProdutoBcp = value;
        }

        /**
         * Obt�m o valor da propriedade nomeProdutoBcp.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNomeProdutoBcp() {
            return nomeProdutoBcp;
        }

        /**
         * Define o valor da propriedade nomeProdutoBcp.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNomeProdutoBcp(String value) {
            this.nomeProdutoBcp = value;
        }

        /**
         * Obt�m o valor da propriedade dataEmissao.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDataEmissao() {
            return dataEmissao;
        }

        /**
         * Define o valor da propriedade dataEmissao.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDataEmissao(XMLGregorianCalendar value) {
            this.dataEmissao = value;
        }

        /**
         * Obt�m o valor da propriedade dataInicioVigencia.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDataInicioVigencia() {
            return dataInicioVigencia;
        }

        /**
         * Define o valor da propriedade dataInicioVigencia.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDataInicioVigencia(XMLGregorianCalendar value) {
            this.dataInicioVigencia = value;
        }

        /**
         * Obt�m o valor da propriedade dataFinalVigencia.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDataFinalVigencia() {
            return dataFinalVigencia;
        }

        /**
         * Define o valor da propriedade dataFinalVigencia.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDataFinalVigencia(XMLGregorianCalendar value) {
            this.dataFinalVigencia = value;
        }

        /**
         * Obt�m o valor da propriedade codigoOrigemProposta.
         * 
         * @return
         *     possible object is
         *     {@link Short }
         *     
         */
        public Short getCodigoOrigemProposta() {
            return codigoOrigemProposta;
        }

        /**
         * Define o valor da propriedade codigoOrigemProposta.
         * 
         * @param value
         *     allowed object is
         *     {@link Short }
         *     
         */
        public void setCodigoOrigemProposta(Short value) {
            this.codigoOrigemProposta = value;
        }

        /**
         * Obt�m o valor da propriedade numeroDigitoProposta.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getNumeroDigitoProposta() {
            return numeroDigitoProposta;
        }

        /**
         * Define o valor da propriedade numeroDigitoProposta.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setNumeroDigitoProposta(Long value) {
            this.numeroDigitoProposta = value;
        }

        /**
         * Obt�m o valor da propriedade codigoCanalVenda.
         * 
         * @return
         *     possible object is
         *     {@link Short }
         *     
         */
        public Short getCodigoCanalVenda() {
            return codigoCanalVenda;
        }

        /**
         * Define o valor da propriedade codigoCanalVenda.
         * 
         * @param value
         *     allowed object is
         *     {@link Short }
         *     
         */
        public void setCodigoCanalVenda(Short value) {
            this.codigoCanalVenda = value;
        }

        /**
         * Obt�m o valor da propriedade nomeCanalVenda.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNomeCanalVenda() {
            return nomeCanalVenda;
        }

        /**
         * Define o valor da propriedade nomeCanalVenda.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNomeCanalVenda(String value) {
            this.nomeCanalVenda = value;
        }

        /**
         * Obt�m o valor da propriedade codigoEmpresaQuemEmitiu.
         * 
         * @return
         *     possible object is
         *     {@link Short }
         *     
         */
        public Short getCodigoEmpresaQuemEmitiu() {
            return codigoEmpresaQuemEmitiu;
        }

        /**
         * Define o valor da propriedade codigoEmpresaQuemEmitiu.
         * 
         * @param value
         *     allowed object is
         *     {@link Short }
         *     
         */
        public void setCodigoEmpresaQuemEmitiu(Short value) {
            this.codigoEmpresaQuemEmitiu = value;
        }

        /**
         * Obt�m o valor da propriedade nomeEmpresaQuemEmitiu.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNomeEmpresaQuemEmitiu() {
            return nomeEmpresaQuemEmitiu;
        }

        /**
         * Define o valor da propriedade nomeEmpresaQuemEmitiu.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNomeEmpresaQuemEmitiu(String value) {
            this.nomeEmpresaQuemEmitiu = value;
        }

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
         * Obt�m o valor da propriedade numeroContratoSistemaOrigem.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNumeroContratoSistemaOrigem() {
            return numeroContratoSistemaOrigem;
        }

        /**
         * Define o valor da propriedade numeroContratoSistemaOrigem.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNumeroContratoSistemaOrigem(String value) {
            this.numeroContratoSistemaOrigem = value;
        }

        /**
         * Obt�m o valor da propriedade codigoSituacaoContrato.
         * 
         * @return
         *     possible object is
         *     {@link Short }
         *     
         */
        public Short getCodigoSituacaoContrato() {
            return codigoSituacaoContrato;
        }

        /**
         * Define o valor da propriedade codigoSituacaoContrato.
         * 
         * @param value
         *     allowed object is
         *     {@link Short }
         *     
         */
        public void setCodigoSituacaoContrato(Short value) {
            this.codigoSituacaoContrato = value;
        }

        /**
         * Obt�m o valor da propriedade nomeSituacaoContrato.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNomeSituacaoContrato() {
            return nomeSituacaoContrato;
        }

        /**
         * Define o valor da propriedade nomeSituacaoContrato.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNomeSituacaoContrato(String value) {
            this.nomeSituacaoContrato = value;
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
         *         &lt;element name="chave" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="valor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "chave",
            "valor"
        })
        public static class ChaveDocumento {

            protected String chave;
            protected String valor;

            /**
             * Obt�m o valor da propriedade chave.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getChave() {
                return chave;
            }

            /**
             * Define o valor da propriedade chave.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setChave(String value) {
                this.chave = value;
            }

            /**
             * Obt�m o valor da propriedade valor.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValor() {
                return valor;
            }

            /**
             * Define o valor da propriedade valor.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValor(String value) {
                this.valor = value;
            }

        }

    }

}
