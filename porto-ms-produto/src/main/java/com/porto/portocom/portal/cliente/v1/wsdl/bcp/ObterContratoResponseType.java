
package com.porto.portocom.portal.cliente.v1.wsdl.bcp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Classe Java de ObterContratoResponseType complex type.
 * 
 * <p>
 * O seguinte fragmento do esquema especifica o conte�do esperado contido dentro
 * desta classe.
 * 
 * <pre>
 * &lt;complexType name="ObterContratoResponseType">
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
 *                   &lt;element name="contratos" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="codigoSusep" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="chaveDocumento" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="chave" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="valor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="codigoCanalVenda" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="codigoEmpresaQuemEmitiu" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="codigoOrigemProposta" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="codigoProdutoOrigem" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="codigoProdutoBcp" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="codigoSegmento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="nomeSegmento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="dataEmissao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="dataFinalVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="codigoSituacaoContrato" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="nomeSituacaoContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="dataAtualizacaoSituacaoContrato" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="nomeCanalVenda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="nomeEmpresaQuemEmitiu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="nomeProdutoBcp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="numeroClienteSistemaOrigem" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="numeroContratoSistemaOrigem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="numeroContratoVinculado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="numeroDigitoProposta" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="papelPessoaContrato" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="codigoPapelPessoa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                       &lt;element name="nomePapelPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                                       &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="dataAtualizacaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                   &lt;element name="dataInclusaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                   &lt;element name="documentos" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="codigoTipoDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="descricaoTipoDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="digitoCpfouCnpj" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="flagPessoaTitularDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="descricaoPessoaTitularDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="numeroCpfouCnpj" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="numeroDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="numeroOrdemCnpj" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="siglaTipoDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="flagCadastroPortalCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="nomeOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="nomePessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="nomeTratamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
@XmlType(name = "ObterContratoResponseType", propOrder = { "pessoa" })
public class ObterContratoResponseType implements Serializable {

	private static final long serialVersionUID = 6003334800540482717L;

	protected List<ObterContratoResponseType.Pessoa> pessoa;

	/**
	 * Gets the value of the pessoa property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the pessoa property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getPessoa().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link ObterContratoResponseType.Pessoa }
	 * 
	 * 
	 */
	public List<ObterContratoResponseType.Pessoa> getPessoa() {
		if (pessoa == null) {
			pessoa = new ArrayList<ObterContratoResponseType.Pessoa>();
		}
		return this.pessoa;
	}

	/**
	 * <p>
	 * Classe Java de anonymous complex type.
	 * 
	 * <p>
	 * O seguinte fragmento do esquema especifica o conte�do esperado contido dentro
	 * desta classe.
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="codigoOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *         &lt;element name="codigoTipoPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *         &lt;element name="descricaoTipoPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *         &lt;element name="contratos" maxOccurs="unbounded" minOccurs="0">
	 *           &lt;complexType>
	 *             &lt;complexContent>
	 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *                 &lt;sequence>
	 *                   &lt;element name="codigoSusep" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
	 *                   &lt;element name="codigoCanalVenda" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                   &lt;element name="codigoEmpresaQuemEmitiu" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                   &lt;element name="codigoOrigemProposta" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                   &lt;element name="codigoProdutoOrigem" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                   &lt;element name="codigoProdutoBcp" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                   &lt;element name="codigoSegmento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                   &lt;element name="nomeSegmento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                   &lt;element name="dataEmissao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
	 *                   &lt;element name="dataFinalVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
	 *                   &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
	 *                   &lt;element name="codigoSituacaoContrato" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                   &lt;element name="nomeSituacaoContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                   &lt;element name="dataAtualizacaoSituacaoContrato" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
	 *                   &lt;element name="nomeCanalVenda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                   &lt;element name="nomeEmpresaQuemEmitiu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                   &lt;element name="nomeProdutoBcp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                   &lt;element name="numeroClienteSistemaOrigem" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
	 *                   &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                   &lt;element name="numeroContratoSistemaOrigem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                   &lt;element name="numeroContratoVinculado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                   &lt;element name="numeroDigitoProposta" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
	 *                   &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
	 *                   &lt;element name="papelPessoaContrato" maxOccurs="unbounded" minOccurs="0">
	 *                     &lt;complexType>
	 *                       &lt;complexContent>
	 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *                           &lt;sequence>
	 *                             &lt;element name="codigoPapelPessoa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                             &lt;element name="nomePapelPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                             &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
	 *                             &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                           &lt;/sequence>
	 *                         &lt;/restriction>
	 *                       &lt;/complexContent>
	 *                     &lt;/complexType>
	 *                   &lt;/element>
	 *                 &lt;/sequence>
	 *               &lt;/restriction>
	 *             &lt;/complexContent>
	 *           &lt;/complexType>
	 *         &lt;/element>
	 *         &lt;element name="dataAtualizacaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
	 *         &lt;element name="dataInclusaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
	 *         &lt;element name="documentos" maxOccurs="unbounded" minOccurs="0">
	 *           &lt;complexType>
	 *             &lt;complexContent>
	 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *                 &lt;sequence>
	 *                   &lt;element name="codigoTipoDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                   &lt;element name="descricaoTipoDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                   &lt;element name="digitoCpfouCnpj" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                   &lt;element name="flagPessoaTitularDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                   &lt;element name="descricaoPessoaTitularDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                   &lt;element name="numeroCpfouCnpj" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
	 *                   &lt;element name="numeroDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                   &lt;element name="numeroOrdemCnpj" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                   &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
	 *                   &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                   &lt;element name="siglaTipoDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                 &lt;/sequence>
	 *               &lt;/restriction>
	 *             &lt;/complexContent>
	 *           &lt;/complexType>
	 *         &lt;/element>
	 *         &lt;element name="flagCadastroPortalCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *         &lt;element name="nomeOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *         &lt;element name="nomePessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *         &lt;element name="nomeTratamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *         &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
	@XmlType(name = "", propOrder = { "codigoOrigemMovimento", "codigoTipoPessoa", "descricaoTipoPessoa", "contratos",
			"dataAtualizacaoRegistro", "dataInclusaoRegistro", "documentos", "flagCadastroPortalCliente",
			"nomeOrigemMovimento", "nomePessoa", "nomeTratamento", "numeroPessoa", "primeiroCodigoFonetico",
			"segundoCodigoFonetico", "terceiroCodigoFonetico" })
	public static class Pessoa implements Serializable {

		private static final long serialVersionUID = -4753647735369495431L;

		protected Short codigoOrigemMovimento;
		protected String codigoTipoPessoa;
		protected String descricaoTipoPessoa;
		protected List<ObterContratoResponseType.Pessoa.Contratos> contratos;
		@XmlSchemaType(name = "dateTime")
		protected XMLGregorianCalendar dataAtualizacaoRegistro;
		@XmlSchemaType(name = "dateTime")
		protected XMLGregorianCalendar dataInclusaoRegistro;
		protected List<ObterContratoResponseType.Pessoa.Documentos> documentos;
		protected String flagCadastroPortalCliente;
		protected String nomeOrigemMovimento;
		protected String nomePessoa;
		protected String nomeTratamento;
		protected Long numeroPessoa;
		protected String primeiroCodigoFonetico;
		protected String segundoCodigoFonetico;
		protected String terceiroCodigoFonetico;

		/**
		 * Obt�m o valor da propriedade codigoOrigemMovimento.
		 * 
		 * @return possible object is {@link Short }
		 * 
		 */
		public Short getCodigoOrigemMovimento() {
			return codigoOrigemMovimento;
		}

		/**
		 * Define o valor da propriedade codigoOrigemMovimento.
		 * 
		 * @param value allowed object is {@link Short }
		 * 
		 */
		public void setCodigoOrigemMovimento(Short value) {
			this.codigoOrigemMovimento = value;
		}

		/**
		 * Obt�m o valor da propriedade codigoTipoPessoa.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getCodigoTipoPessoa() {
			return codigoTipoPessoa;
		}

		/**
		 * Define o valor da propriedade codigoTipoPessoa.
		 * 
		 * @param value allowed object is {@link String }
		 * 
		 */
		public void setCodigoTipoPessoa(String value) {
			this.codigoTipoPessoa = value;
		}

		/**
		 * Obt�m o valor da propriedade descricaoTipoPessoa.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getDescricaoTipoPessoa() {
			return descricaoTipoPessoa;
		}

		/**
		 * Define o valor da propriedade descricaoTipoPessoa.
		 * 
		 * @param value allowed object is {@link String }
		 * 
		 */
		public void setDescricaoTipoPessoa(String value) {
			this.descricaoTipoPessoa = value;
		}

		/**
		 * Gets the value of the contratos property.
		 * 
		 * <p>
		 * This accessor method returns a reference to the live list, not a snapshot.
		 * Therefore any modification you make to the returned list will be present
		 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
		 * for the contratos property.
		 * 
		 * <p>
		 * For example, to add a new item, do as follows:
		 * 
		 * <pre>
		 * getContratos().add(newItem);
		 * </pre>
		 * 
		 * 
		 * <p>
		 * Objects of the following type(s) are allowed in the list
		 * {@link ObterContratoResponseType.Pessoa.Contratos }
		 * 
		 * 
		 */
		public List<ObterContratoResponseType.Pessoa.Contratos> getContratos() {
			if (contratos == null) {
				contratos = new ArrayList<ObterContratoResponseType.Pessoa.Contratos>();
			}
			return this.contratos;
		}

		/**
		 * Obt�m o valor da propriedade dataAtualizacaoRegistro.
		 * 
		 * @return possible object is {@link XMLGregorianCalendar }
		 * 
		 */
		public XMLGregorianCalendar getDataAtualizacaoRegistro() {
			return dataAtualizacaoRegistro;
		}

		/**
		 * Define o valor da propriedade dataAtualizacaoRegistro.
		 * 
		 * @param value allowed object is {@link XMLGregorianCalendar }
		 * 
		 */
		public void setDataAtualizacaoRegistro(XMLGregorianCalendar value) {
			this.dataAtualizacaoRegistro = value;
		}

		/**
		 * Obt�m o valor da propriedade dataInclusaoRegistro.
		 * 
		 * @return possible object is {@link XMLGregorianCalendar }
		 * 
		 */
		public XMLGregorianCalendar getDataInclusaoRegistro() {
			return dataInclusaoRegistro;
		}

		/**
		 * Define o valor da propriedade dataInclusaoRegistro.
		 * 
		 * @param value allowed object is {@link XMLGregorianCalendar }
		 * 
		 */
		public void setDataInclusaoRegistro(XMLGregorianCalendar value) {
			this.dataInclusaoRegistro = value;
		}

		/**
		 * Gets the value of the documentos property.
		 * 
		 * <p>
		 * This accessor method returns a reference to the live list, not a snapshot.
		 * Therefore any modification you make to the returned list will be present
		 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
		 * for the documentos property.
		 * 
		 * <p>
		 * For example, to add a new item, do as follows:
		 * 
		 * <pre>
		 * getDocumentos().add(newItem);
		 * </pre>
		 * 
		 * 
		 * <p>
		 * Objects of the following type(s) are allowed in the list
		 * {@link ObterContratoResponseType.Pessoa.Documentos }
		 * 
		 * 
		 */
		public List<ObterContratoResponseType.Pessoa.Documentos> getDocumentos() {
			if (documentos == null) {
				documentos = new ArrayList<ObterContratoResponseType.Pessoa.Documentos>();
			}
			return this.documentos;
		}

		/**
		 * Obt�m o valor da propriedade flagCadastroPortalCliente.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getFlagCadastroPortalCliente() {
			return flagCadastroPortalCliente;
		}

		/**
		 * Define o valor da propriedade flagCadastroPortalCliente.
		 * 
		 * @param value allowed object is {@link String }
		 * 
		 */
		public void setFlagCadastroPortalCliente(String value) {
			this.flagCadastroPortalCliente = value;
		}

		/**
		 * Obt�m o valor da propriedade nomeOrigemMovimento.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getNomeOrigemMovimento() {
			return nomeOrigemMovimento;
		}

		/**
		 * Define o valor da propriedade nomeOrigemMovimento.
		 * 
		 * @param value allowed object is {@link String }
		 * 
		 */
		public void setNomeOrigemMovimento(String value) {
			this.nomeOrigemMovimento = value;
		}

		/**
		 * Obt�m o valor da propriedade nomePessoa.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getNomePessoa() {
			return nomePessoa;
		}

		/**
		 * Define o valor da propriedade nomePessoa.
		 * 
		 * @param value allowed object is {@link String }
		 * 
		 */
		public void setNomePessoa(String value) {
			this.nomePessoa = value;
		}

		/**
		 * Obt�m o valor da propriedade nomeTratamento.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getNomeTratamento() {
			return nomeTratamento;
		}

		/**
		 * Define o valor da propriedade nomeTratamento.
		 * 
		 * @param value allowed object is {@link String }
		 * 
		 */
		public void setNomeTratamento(String value) {
			this.nomeTratamento = value;
		}

		/**
		 * Obt�m o valor da propriedade numeroPessoa.
		 * 
		 * @return possible object is {@link Long }
		 * 
		 */
		public Long getNumeroPessoa() {
			return numeroPessoa;
		}

		/**
		 * Define o valor da propriedade numeroPessoa.
		 * 
		 * @param value allowed object is {@link Long }
		 * 
		 */
		public void setNumeroPessoa(Long value) {
			this.numeroPessoa = value;
		}

		/**
		 * Obt�m o valor da propriedade primeiroCodigoFonetico.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getPrimeiroCodigoFonetico() {
			return primeiroCodigoFonetico;
		}

		/**
		 * Define o valor da propriedade primeiroCodigoFonetico.
		 * 
		 * @param value allowed object is {@link String }
		 * 
		 */
		public void setPrimeiroCodigoFonetico(String value) {
			this.primeiroCodigoFonetico = value;
		}

		/**
		 * Obt�m o valor da propriedade segundoCodigoFonetico.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getSegundoCodigoFonetico() {
			return segundoCodigoFonetico;
		}

		/**
		 * Define o valor da propriedade segundoCodigoFonetico.
		 * 
		 * @param value allowed object is {@link String }
		 * 
		 */
		public void setSegundoCodigoFonetico(String value) {
			this.segundoCodigoFonetico = value;
		}

		/**
		 * Obt�m o valor da propriedade terceiroCodigoFonetico.
		 * 
		 * @return possible object is {@link String }
		 * 
		 */
		public String getTerceiroCodigoFonetico() {
			return terceiroCodigoFonetico;
		}

		/**
		 * Define o valor da propriedade terceiroCodigoFonetico.
		 * 
		 * @param value allowed object is {@link String }
		 * 
		 */
		public void setTerceiroCodigoFonetico(String value) {
			this.terceiroCodigoFonetico = value;
		}

		/**
		 * <p>
		 * Classe Java de anonymous complex type.
		 * 
		 * <p>
		 * O seguinte fragmento do esquema especifica o conte�do esperado contido dentro
		 * desta classe.
		 * 
		 * <pre>
		 * &lt;complexType>
		 *   &lt;complexContent>
		 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
		 *       &lt;sequence>
		 *         &lt;element name="codigoSusep" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
		 *         &lt;element name="codigoCanalVenda" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *         &lt;element name="codigoEmpresaQuemEmitiu" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *         &lt;element name="codigoOrigemProposta" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *         &lt;element name="codigoProdutoOrigem" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *         &lt;element name="codigoProdutoBcp" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *         &lt;element name="codigoSegmento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *         &lt;element name="nomeSegmento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *         &lt;element name="dataEmissao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
		 *         &lt;element name="dataFinalVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
		 *         &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
		 *         &lt;element name="codigoSituacaoContrato" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *         &lt;element name="nomeSituacaoContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *         &lt;element name="dataAtualizacaoSituacaoContrato" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
		 *         &lt;element name="nomeCanalVenda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *         &lt;element name="nomeEmpresaQuemEmitiu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *         &lt;element name="nomeProdutoBcp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *         &lt;element name="numeroClienteSistemaOrigem" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
		 *         &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *         &lt;element name="numeroContratoSistemaOrigem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *         &lt;element name="numeroContratoVinculado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *         &lt;element name="numeroDigitoProposta" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
		 *         &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
		 *         &lt;element name="papelPessoaContrato" maxOccurs="unbounded" minOccurs="0">
		 *           &lt;complexType>
		 *             &lt;complexContent>
		 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
		 *                 &lt;sequence>
		 *                   &lt;element name="codigoPapelPessoa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *                   &lt;element name="nomePapelPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                   &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
		 *                   &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
		@XmlType(name = "", propOrder = { "codigoSusep", "chaveDocumento", "codigoCanalVenda",
				"codigoEmpresaQuemEmitiu", "codigoOrigemProposta", "codigoProdutoOrigem", "codigoProdutoBcp",
				"codigoSegmento", "nomeSegmento", "dataEmissao", "dataFinalVigencia", "dataInicioVigencia",
				"codigoSituacaoContrato", "nomeSituacaoContrato", "dataAtualizacaoSituacaoContrato", "nomeCanalVenda",
				"nomeEmpresaQuemEmitiu", "nomeProdutoBcp", "numeroClienteSistemaOrigem", "numeroContrato",
				"numeroContratoSistemaOrigem", "numeroContratoVinculado", "numeroDigitoProposta", "numeroPessoa",
				"papelPessoaContrato" })
		public static class Contratos implements Serializable {

			protected String codigoSusep;
			protected List<ObterContratoResponseType.Pessoa.Contratos.ChaveDocumento> chaveDocumento;
			protected Short codigoCanalVenda;
			protected Short codigoEmpresaQuemEmitiu;
			protected Short codigoOrigemProposta;
			protected Short codigoProdutoOrigem;
			protected Short codigoProdutoBcp;
			protected Short codigoSegmento;
			protected String nomeSegmento;
			@XmlSchemaType(name = "dateTime")
			protected XMLGregorianCalendar dataEmissao;
			@XmlSchemaType(name = "dateTime")
			protected XMLGregorianCalendar dataFinalVigencia;
			@XmlSchemaType(name = "dateTime")
			protected XMLGregorianCalendar dataInicioVigencia;
			protected Short codigoSituacaoContrato;
			protected String nomeSituacaoContrato;
			@XmlSchemaType(name = "dateTime")
			protected XMLGregorianCalendar dataAtualizacaoSituacaoContrato;
			protected String nomeCanalVenda;
			protected String nomeEmpresaQuemEmitiu;
			protected String nomeProdutoBcp;
			protected Long numeroClienteSistemaOrigem;
			protected String numeroContrato;
			protected String numeroContratoSistemaOrigem;
			protected String numeroContratoVinculado;
			protected Long numeroDigitoProposta;
			protected Long numeroPessoa;
			protected List<ObterContratoResponseType.Pessoa.Contratos.PapelPessoaContrato> papelPessoaContrato;

			/**
			 * Obt�m o valor da propriedade codigoSusep.
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getCodigoSusep() {
				return codigoSusep;
			}

			/**
			 * Define o valor da propriedade codigoSusep.
			 * 
			 * @param value allowed object is {@link String }
			 * 
			 */
			public void setCodigoSusep(String value) {
				this.codigoSusep = value;
			}

			/**
			 * Gets the value of the chaveDocumento property.
			 * 
			 * <p>
			 * This accessor method returns a reference to the live list, not a snapshot.
			 * Therefore any modification you make to the returned list will be present
			 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
			 * for the chaveDocumento property.
			 * 
			 * <p>
			 * For example, to add a new item, do as follows:
			 * 
			 * <pre>
			 * getChaveDocumento().add(newItem);
			 * </pre>
			 * 
			 * 
			 * <p>
			 * Objects of the following type(s) are allowed in the list
			 * {@link ObterContratoResponseType.Pessoa.Contratos.ChaveDocumento }
			 * 
			 * 
			 */
			public List<ObterContratoResponseType.Pessoa.Contratos.ChaveDocumento> getChaveDocumento() {
				if (chaveDocumento == null) {
					chaveDocumento = new ArrayList<ObterContratoResponseType.Pessoa.Contratos.ChaveDocumento>();
				}
				return this.chaveDocumento;
			}

			/**
			 * Obt�m o valor da propriedade codigoCanalVenda.
			 * 
			 * @return possible object is {@link Short }
			 * 
			 */
			public Short getCodigoCanalVenda() {
				return codigoCanalVenda;
			}

			/**
			 * Define o valor da propriedade codigoCanalVenda.
			 * 
			 * @param value allowed object is {@link Short }
			 * 
			 */
			public void setCodigoCanalVenda(Short value) {
				this.codigoCanalVenda = value;
			}

			/**
			 * Obt�m o valor da propriedade codigoEmpresaQuemEmitiu.
			 * 
			 * @return possible object is {@link Short }
			 * 
			 */
			public Short getCodigoEmpresaQuemEmitiu() {
				return codigoEmpresaQuemEmitiu;
			}

			/**
			 * Define o valor da propriedade codigoEmpresaQuemEmitiu.
			 * 
			 * @param value allowed object is {@link Short }
			 * 
			 */
			public void setCodigoEmpresaQuemEmitiu(Short value) {
				this.codigoEmpresaQuemEmitiu = value;
			}

			/**
			 * Obt�m o valor da propriedade codigoOrigemProposta.
			 * 
			 * @return possible object is {@link Short }
			 * 
			 */
			public Short getCodigoOrigemProposta() {
				return codigoOrigemProposta;
			}

			/**
			 * Define o valor da propriedade codigoOrigemProposta.
			 * 
			 * @param value allowed object is {@link Short }
			 * 
			 */
			public void setCodigoOrigemProposta(Short value) {
				this.codigoOrigemProposta = value;
			}

			/**
			 * Obt�m o valor da propriedade codigoProdutoOrigem.
			 * 
			 * @return possible object is {@link Short }
			 * 
			 */
			public Short getCodigoProdutoOrigem() {
				return codigoProdutoOrigem;
			}

			/**
			 * Define o valor da propriedade codigoProdutoOrigem.
			 * 
			 * @param value allowed object is {@link Short }
			 * 
			 */
			public void setCodigoProdutoOrigem(Short value) {
				this.codigoProdutoOrigem = value;
			}

			/**
			 * Obt�m o valor da propriedade codigoProdutoBcp.
			 * 
			 * @return possible object is {@link Short }
			 * 
			 */
			public Short getCodigoProdutoBcp() {
				return codigoProdutoBcp;
			}

			/**
			 * Define o valor da propriedade codigoProdutoBcp.
			 * 
			 * @param value allowed object is {@link Short }
			 * 
			 */
			public void setCodigoProdutoBcp(Short value) {
				this.codigoProdutoBcp = value;
			}

			/**
			 * Obt�m o valor da propriedade codigoSegmento.
			 * 
			 * @return possible object is {@link Short }
			 * 
			 */
			public Short getCodigoSegmento() {
				return codigoSegmento;
			}

			/**
			 * Define o valor da propriedade codigoSegmento.
			 * 
			 * @param value allowed object is {@link Short }
			 * 
			 */
			public void setCodigoSegmento(Short value) {
				this.codigoSegmento = value;
			}

			/**
			 * Obt�m o valor da propriedade nomeSegmento.
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getNomeSegmento() {
				return nomeSegmento;
			}

			/**
			 * Define o valor da propriedade nomeSegmento.
			 * 
			 * @param value allowed object is {@link String }
			 * 
			 */
			public void setNomeSegmento(String value) {
				this.nomeSegmento = value;
			}

			/**
			 * Obt�m o valor da propriedade dataEmissao.
			 * 
			 * @return possible object is {@link XMLGregorianCalendar }
			 * 
			 */
			public XMLGregorianCalendar getDataEmissao() {
				return dataEmissao;
			}

			/**
			 * Define o valor da propriedade dataEmissao.
			 * 
			 * @param value allowed object is {@link XMLGregorianCalendar }
			 * 
			 */
			public void setDataEmissao(XMLGregorianCalendar value) {
				this.dataEmissao = value;
			}

			/**
			 * Obt�m o valor da propriedade dataFinalVigencia.
			 * 
			 * @return possible object is {@link XMLGregorianCalendar }
			 * 
			 */
			public XMLGregorianCalendar getDataFinalVigencia() {
				return dataFinalVigencia;
			}

			/**
			 * Define o valor da propriedade dataFinalVigencia.
			 * 
			 * @param value allowed object is {@link XMLGregorianCalendar }
			 * 
			 */
			public void setDataFinalVigencia(XMLGregorianCalendar value) {
				this.dataFinalVigencia = value;
			}

			/**
			 * Obt�m o valor da propriedade dataInicioVigencia.
			 * 
			 * @return possible object is {@link XMLGregorianCalendar }
			 * 
			 */
			public XMLGregorianCalendar getDataInicioVigencia() {
				return dataInicioVigencia;
			}

			/**
			 * Define o valor da propriedade dataInicioVigencia.
			 * 
			 * @param value allowed object is {@link XMLGregorianCalendar }
			 * 
			 */
			public void setDataInicioVigencia(XMLGregorianCalendar value) {
				this.dataInicioVigencia = value;
			}

			/**
			 * Obt�m o valor da propriedade codigoSituacaoContrato.
			 * 
			 * @return possible object is {@link Short }
			 * 
			 */
			public Short getCodigoSituacaoContrato() {
				return codigoSituacaoContrato;
			}

			/**
			 * Define o valor da propriedade codigoSituacaoContrato.
			 * 
			 * @param value allowed object is {@link Short }
			 * 
			 */
			public void setCodigoSituacaoContrato(Short value) {
				this.codigoSituacaoContrato = value;
			}

			/**
			 * Obt�m o valor da propriedade nomeSituacaoContrato.
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getNomeSituacaoContrato() {
				return nomeSituacaoContrato;
			}

			/**
			 * Define o valor da propriedade nomeSituacaoContrato.
			 * 
			 * @param value allowed object is {@link String }
			 * 
			 */
			public void setNomeSituacaoContrato(String value) {
				this.nomeSituacaoContrato = value;
			}

			/**
			 * Obt�m o valor da propriedade dataAtualizacaoSituacaoContrato.
			 * 
			 * @return possible object is {@link XMLGregorianCalendar }
			 * 
			 */
			public XMLGregorianCalendar getDataAtualizacaoSituacaoContrato() {
				return dataAtualizacaoSituacaoContrato;
			}

			/**
			 * Define o valor da propriedade dataAtualizacaoSituacaoContrato.
			 * 
			 * @param value allowed object is {@link XMLGregorianCalendar }
			 * 
			 */
			public void setDataAtualizacaoSituacaoContrato(XMLGregorianCalendar value) {
				this.dataAtualizacaoSituacaoContrato = value;
			}

			/**
			 * Obt�m o valor da propriedade nomeCanalVenda.
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getNomeCanalVenda() {
				return nomeCanalVenda;
			}

			/**
			 * Define o valor da propriedade nomeCanalVenda.
			 * 
			 * @param value allowed object is {@link String }
			 * 
			 */
			public void setNomeCanalVenda(String value) {
				this.nomeCanalVenda = value;
			}

			/**
			 * Obt�m o valor da propriedade nomeEmpresaQuemEmitiu.
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getNomeEmpresaQuemEmitiu() {
				return nomeEmpresaQuemEmitiu;
			}

			/**
			 * Define o valor da propriedade nomeEmpresaQuemEmitiu.
			 * 
			 * @param value allowed object is {@link String }
			 * 
			 */
			public void setNomeEmpresaQuemEmitiu(String value) {
				this.nomeEmpresaQuemEmitiu = value;
			}

			/**
			 * Obt�m o valor da propriedade nomeProdutoBcp.
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getNomeProdutoBcp() {
				return nomeProdutoBcp;
			}

			/**
			 * Define o valor da propriedade nomeProdutoBcp.
			 * 
			 * @param value allowed object is {@link String }
			 * 
			 */
			public void setNomeProdutoBcp(String value) {
				this.nomeProdutoBcp = value;
			}

			/**
			 * Obt�m o valor da propriedade numeroClienteSistemaOrigem.
			 * 
			 * @return possible object is {@link Long }
			 * 
			 */
			public Long getNumeroClienteSistemaOrigem() {
				return numeroClienteSistemaOrigem;
			}

			/**
			 * Define o valor da propriedade numeroClienteSistemaOrigem.
			 * 
			 * @param value allowed object is {@link Long }
			 * 
			 */
			public void setNumeroClienteSistemaOrigem(Long value) {
				this.numeroClienteSistemaOrigem = value;
			}

			/**
			 * Obt�m o valor da propriedade numeroContrato.
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getNumeroContrato() {
				return numeroContrato;
			}

			/**
			 * Define o valor da propriedade numeroContrato.
			 * 
			 * @param value allowed object is {@link String }
			 * 
			 */
			public void setNumeroContrato(String value) {
				this.numeroContrato = value;
			}

			/**
			 * Obt�m o valor da propriedade numeroContratoSistemaOrigem.
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getNumeroContratoSistemaOrigem() {
				return numeroContratoSistemaOrigem;
			}

			/**
			 * Define o valor da propriedade numeroContratoSistemaOrigem.
			 * 
			 * @param value allowed object is {@link String }
			 * 
			 */
			public void setNumeroContratoSistemaOrigem(String value) {
				this.numeroContratoSistemaOrigem = value;
			}

			/**
			 * Obt�m o valor da propriedade numeroContratoVinculado.
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getNumeroContratoVinculado() {
				return numeroContratoVinculado;
			}

			/**
			 * Define o valor da propriedade numeroContratoVinculado.
			 * 
			 * @param value allowed object is {@link String }
			 * 
			 */
			public void setNumeroContratoVinculado(String value) {
				this.numeroContratoVinculado = value;
			}

			/**
			 * Obt�m o valor da propriedade numeroDigitoProposta.
			 * 
			 * @return possible object is {@link Long }
			 * 
			 */
			public Long getNumeroDigitoProposta() {
				return numeroDigitoProposta;
			}

			/**
			 * Define o valor da propriedade numeroDigitoProposta.
			 * 
			 * @param value allowed object is {@link Long }
			 * 
			 */
			public void setNumeroDigitoProposta(Long value) {
				this.numeroDigitoProposta = value;
			}

			/**
			 * Obt�m o valor da propriedade numeroPessoa.
			 * 
			 * @return possible object is {@link Long }
			 * 
			 */
			public Long getNumeroPessoa() {
				return numeroPessoa;
			}

			/**
			 * Define o valor da propriedade numeroPessoa.
			 * 
			 * @param value allowed object is {@link Long }
			 * 
			 */
			public void setNumeroPessoa(Long value) {
				this.numeroPessoa = value;
			}

			/**
			 * Gets the value of the papelPessoaContrato property.
			 * 
			 * <p>
			 * This accessor method returns a reference to the live list, not a snapshot.
			 * Therefore any modification you make to the returned list will be present
			 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
			 * for the papelPessoaContrato property.
			 * 
			 * <p>
			 * For example, to add a new item, do as follows:
			 * 
			 * <pre>
			 * getPapelPessoaContrato().add(newItem);
			 * </pre>
			 * 
			 * 
			 * <p>
			 * Objects of the following type(s) are allowed in the list
			 * {@link ObterContratoResponseType.Pessoa.Contratos.PapelPessoaContrato }
			 * 
			 * 
			 */
			public List<ObterContratoResponseType.Pessoa.Contratos.PapelPessoaContrato> getPapelPessoaContrato() {
				if (papelPessoaContrato == null) {
					papelPessoaContrato = new ArrayList<ObterContratoResponseType.Pessoa.Contratos.PapelPessoaContrato>();
				}
				return this.papelPessoaContrato;
			}

			/**
			 * <p>
			 * Classe Java de anonymous complex type.
			 * 
			 * <p>
			 * O seguinte fragmento do esquema especifica o conte�do esperado contido dentro
			 * desta classe.
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
			@XmlType(name = "", propOrder = { "chave", "valor" })
			public static class ChaveDocumento implements Serializable {

				protected String chave;
				protected String valor;

				/**
				 * Obt�m o valor da propriedade chave.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getChave() {
					return chave;
				}

				/**
				 * Define o valor da propriedade chave.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setChave(String value) {
					this.chave = value;
				}

				/**
				 * Obt�m o valor da propriedade valor.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getValor() {
					return valor;
				}

				/**
				 * Define o valor da propriedade valor.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setValor(String value) {
					this.valor = value;
				}

			}

			/**
			 * <p>
			 * Classe Java de anonymous complex type.
			 * 
			 * <p>
			 * O seguinte fragmento do esquema especifica o conte�do esperado contido dentro
			 * desta classe.
			 * 
			 * <pre>
			 * &lt;complexType>
			 *   &lt;complexContent>
			 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
			 *       &lt;sequence>
			 *         &lt;element name="codigoPapelPessoa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
			 *         &lt;element name="nomePapelPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *         &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
			 *         &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *       &lt;/sequence>
			 *     &lt;/restriction>
			 *   &lt;/complexContent>
			 * &lt;/complexType>
			 * </pre>
			 * 
			 * 
			 */
			@XmlAccessorType(XmlAccessType.FIELD)
			@XmlType(name = "", propOrder = { "codigoPapelPessoa", "nomePapelPessoa", "dataInicioVigencia",
					"numeroContrato" })
			public static class PapelPessoaContrato implements Serializable {

				protected Short codigoPapelPessoa;
				protected String nomePapelPessoa;
				@XmlSchemaType(name = "dateTime")
				protected XMLGregorianCalendar dataInicioVigencia;
				protected String numeroContrato;

				/**
				 * Obt�m o valor da propriedade codigoPapelPessoa.
				 * 
				 * @return possible object is {@link Short }
				 * 
				 */
				public Short getCodigoPapelPessoa() {
					return codigoPapelPessoa;
				}

				/**
				 * Define o valor da propriedade codigoPapelPessoa.
				 * 
				 * @param value allowed object is {@link Short }
				 * 
				 */
				public void setCodigoPapelPessoa(Short value) {
					this.codigoPapelPessoa = value;
				}

				/**
				 * Obt�m o valor da propriedade nomePapelPessoa.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getNomePapelPessoa() {
					return nomePapelPessoa;
				}

				/**
				 * Define o valor da propriedade nomePapelPessoa.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setNomePapelPessoa(String value) {
					this.nomePapelPessoa = value;
				}

				/**
				 * Obt�m o valor da propriedade dataInicioVigencia.
				 * 
				 * @return possible object is {@link XMLGregorianCalendar }
				 * 
				 */
				public XMLGregorianCalendar getDataInicioVigencia() {
					return dataInicioVigencia;
				}

				/**
				 * Define o valor da propriedade dataInicioVigencia.
				 * 
				 * @param value allowed object is {@link XMLGregorianCalendar }
				 * 
				 */
				public void setDataInicioVigencia(XMLGregorianCalendar value) {
					this.dataInicioVigencia = value;
				}

				/**
				 * Obt�m o valor da propriedade numeroContrato.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getNumeroContrato() {
					return numeroContrato;
				}

				/**
				 * Define o valor da propriedade numeroContrato.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setNumeroContrato(String value) {
					this.numeroContrato = value;
				}

			}

		}

		/**
		 * <p>
		 * Classe Java de anonymous complex type.
		 * 
		 * <p>
		 * O seguinte fragmento do esquema especifica o conte�do esperado contido dentro
		 * desta classe.
		 * 
		 * <pre>
		 * &lt;complexType>
		 *   &lt;complexContent>
		 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
		 *       &lt;sequence>
		 *         &lt;element name="codigoTipoDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *         &lt;element name="descricaoTipoDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *         &lt;element name="digitoCpfouCnpj" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *         &lt;element name="flagPessoaTitularDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *         &lt;element name="descricaoPessoaTitularDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *         &lt;element name="numeroCpfouCnpj" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
		 *         &lt;element name="numeroDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *         &lt;element name="numeroOrdemCnpj" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *         &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
		 *         &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *         &lt;element name="siglaTipoDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *       &lt;/sequence>
		 *     &lt;/restriction>
		 *   &lt;/complexContent>
		 * &lt;/complexType>
		 * </pre>
		 * 
		 * 
		 */
		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "codigoTipoDocumento", "descricaoTipoDocumento", "digitoCpfouCnpj",
				"flagPessoaTitularDocumento", "descricaoPessoaTitularDocumento", "numeroCpfouCnpj", "numeroDocumento",
				"numeroOrdemCnpj", "numeroPessoa", "numeroSequencia", "siglaTipoDocumento" })
		public static class Documentos implements Serializable {

			protected Short codigoTipoDocumento;
			protected String descricaoTipoDocumento;
			protected Short digitoCpfouCnpj;
			protected Short flagPessoaTitularDocumento;
			protected String descricaoPessoaTitularDocumento;
			protected Long numeroCpfouCnpj;
			protected String numeroDocumento;
			protected Short numeroOrdemCnpj;
			protected Long numeroPessoa;
			protected Short numeroSequencia;
			protected String siglaTipoDocumento;

			/**
			 * Obt�m o valor da propriedade codigoTipoDocumento.
			 * 
			 * @return possible object is {@link Short }
			 * 
			 */
			public Short getCodigoTipoDocumento() {
				return codigoTipoDocumento;
			}

			/**
			 * Define o valor da propriedade codigoTipoDocumento.
			 * 
			 * @param value allowed object is {@link Short }
			 * 
			 */
			public void setCodigoTipoDocumento(Short value) {
				this.codigoTipoDocumento = value;
			}

			/**
			 * Obt�m o valor da propriedade descricaoTipoDocumento.
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getDescricaoTipoDocumento() {
				return descricaoTipoDocumento;
			}

			/**
			 * Define o valor da propriedade descricaoTipoDocumento.
			 * 
			 * @param value allowed object is {@link String }
			 * 
			 */
			public void setDescricaoTipoDocumento(String value) {
				this.descricaoTipoDocumento = value;
			}

			/**
			 * Obt�m o valor da propriedade digitoCpfouCnpj.
			 * 
			 * @return possible object is {@link Short }
			 * 
			 */
			public Short getDigitoCpfouCnpj() {
				return digitoCpfouCnpj;
			}

			/**
			 * Define o valor da propriedade digitoCpfouCnpj.
			 * 
			 * @param value allowed object is {@link Short }
			 * 
			 */
			public void setDigitoCpfouCnpj(Short value) {
				this.digitoCpfouCnpj = value;
			}

			/**
			 * Obt�m o valor da propriedade flagPessoaTitularDocumento.
			 * 
			 * @return possible object is {@link Short }
			 * 
			 */
			public Short getFlagPessoaTitularDocumento() {
				return flagPessoaTitularDocumento;
			}

			/**
			 * Define o valor da propriedade flagPessoaTitularDocumento.
			 * 
			 * @param value allowed object is {@link Short }
			 * 
			 */
			public void setFlagPessoaTitularDocumento(Short value) {
				this.flagPessoaTitularDocumento = value;
			}

			/**
			 * Obt�m o valor da propriedade descricaoPessoaTitularDocumento.
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getDescricaoPessoaTitularDocumento() {
				return descricaoPessoaTitularDocumento;
			}

			/**
			 * Define o valor da propriedade descricaoPessoaTitularDocumento.
			 * 
			 * @param value allowed object is {@link String }
			 * 
			 */
			public void setDescricaoPessoaTitularDocumento(String value) {
				this.descricaoPessoaTitularDocumento = value;
			}

			/**
			 * Obt�m o valor da propriedade numeroCpfouCnpj.
			 * 
			 * @return possible object is {@link Long }
			 * 
			 */
			public Long getNumeroCpfouCnpj() {
				return numeroCpfouCnpj;
			}

			/**
			 * Define o valor da propriedade numeroCpfouCnpj.
			 * 
			 * @param value allowed object is {@link Long }
			 * 
			 */
			public void setNumeroCpfouCnpj(Long value) {
				this.numeroCpfouCnpj = value;
			}

			/**
			 * Obt�m o valor da propriedade numeroDocumento.
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getNumeroDocumento() {
				return numeroDocumento;
			}

			/**
			 * Define o valor da propriedade numeroDocumento.
			 * 
			 * @param value allowed object is {@link String }
			 * 
			 */
			public void setNumeroDocumento(String value) {
				this.numeroDocumento = value;
			}

			/**
			 * Obt�m o valor da propriedade numeroOrdemCnpj.
			 * 
			 * @return possible object is {@link Short }
			 * 
			 */
			public Short getNumeroOrdemCnpj() {
				return numeroOrdemCnpj;
			}

			/**
			 * Define o valor da propriedade numeroOrdemCnpj.
			 * 
			 * @param value allowed object is {@link Short }
			 * 
			 */
			public void setNumeroOrdemCnpj(Short value) {
				this.numeroOrdemCnpj = value;
			}

			/**
			 * Obt�m o valor da propriedade numeroPessoa.
			 * 
			 * @return possible object is {@link Long }
			 * 
			 */
			public Long getNumeroPessoa() {
				return numeroPessoa;
			}

			/**
			 * Define o valor da propriedade numeroPessoa.
			 * 
			 * @param value allowed object is {@link Long }
			 * 
			 */
			public void setNumeroPessoa(Long value) {
				this.numeroPessoa = value;
			}

			/**
			 * Obt�m o valor da propriedade numeroSequencia.
			 * 
			 * @return possible object is {@link Short }
			 * 
			 */
			public Short getNumeroSequencia() {
				return numeroSequencia;
			}

			/**
			 * Define o valor da propriedade numeroSequencia.
			 * 
			 * @param value allowed object is {@link Short }
			 * 
			 */
			public void setNumeroSequencia(Short value) {
				this.numeroSequencia = value;
			}

			/**
			 * Obt�m o valor da propriedade siglaTipoDocumento.
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getSiglaTipoDocumento() {
				return siglaTipoDocumento;
			}

			/**
			 * Define o valor da propriedade siglaTipoDocumento.
			 * 
			 * @param value allowed object is {@link String }
			 * 
			 */
			public void setSiglaTipoDocumento(String value) {
				this.siglaTipoDocumento = value;
			}

		}

	}

}
