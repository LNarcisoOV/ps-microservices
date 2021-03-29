
package com.porto.portocom.portal.cliente.v1.wsdl.bcp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java de ObterPessoasResponseType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ObterPessoasResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pessoa" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="codigoOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                   &lt;element name="codigoTipoPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="descricaoTipoPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *                   &lt;element name="enderecos" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="codigoFinalidadeEndereco" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="descricaoFinalidadeEndereco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="codigoOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="codigoUnidadeFederacao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="complementoEndereco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="dataAtualizacaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="dataAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="flagAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="flagNivelConfiancaEnderecoAtingido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="flagNivelConfiancaLocalizacaoAtingido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="indiceSucessoEntregaCorrespondencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="nomeBairro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="nomeCidade" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="nomeLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="nomeOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="nomeTipoLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="numeroComplementoCep" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="numeroInicioCep" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                             &lt;element name="numeroLatitudeDecimal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                             &lt;element name="numeroLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="numeroLongitudeDecimal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                             &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="percentualConfiancaEndereco" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                             &lt;element name="siglaPais" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="enderecosEletronicos" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="codigoFinalidadeEndereco" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="descricaoFinalidadeEndereco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="codigoOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="codigoTipoEnderecoEletronico" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="dataAtualizacaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="dataAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="enderecoEletronico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="flagAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="nomeOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="fisica" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="codigoExposicaoPoliticaPessoa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="codigoGrupoAgregacaoPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="codigoSexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="codigoSituacaoPessoa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="dataAtualizacaoGrupoAgregacao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="dataNascimento" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="flagPessoaDeficienciaFisica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="flagPessoaEstrangeira" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="codigoEstadoCivil" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="nomeEstadoCivil" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="dataInclusaoRegistroEstadoCivil" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="nomeMae" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="nomePai" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="flagCadastroPortalCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="juridica" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="codigoNaturezaJuridica" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="dataRegistroAbertura" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="nomeAtividadeCnae" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="nomeNaturezaJuridica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="numeroCnae" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                             &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
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
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="primeiroCodigoFonetico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="segundoCodigoFonetico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="terceiroCodigoFonetico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="telefones" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="codigoDdd" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="codigoDdi" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="codigoOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="codigoTipoTelefone" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="descricaoTipoTelefone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="dataAtualizacaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="dataAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="flagAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="nomeOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="numeroTelefone" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObterPessoasResponseType", propOrder = {
    "pessoa"
})
public class ObterPessoasResponseType implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -5810357439831697986L;
	@XmlElement(required = true)
    protected List<ObterPessoasResponseType.Pessoa> pessoa;

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
     * {@link ObterPessoasResponseType.Pessoa }
     * 
     * 
     */
    public List<ObterPessoasResponseType.Pessoa> getPessoa() {
        if (pessoa == null) {
            pessoa = new ArrayList<ObterPessoasResponseType.Pessoa>();
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
     *         &lt;element name="enderecos" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="codigoFinalidadeEndereco" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="descricaoFinalidadeEndereco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="codigoOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="codigoUnidadeFederacao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="complementoEndereco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="dataAtualizacaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                   &lt;element name="dataAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                   &lt;element name="flagAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="flagNivelConfiancaEnderecoAtingido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="flagNivelConfiancaLocalizacaoAtingido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="indiceSucessoEntregaCorrespondencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="nomeBairro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="nomeCidade" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="nomeLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="nomeOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="nomeTipoLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="numeroComplementoCep" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="numeroInicioCep" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *                   &lt;element name="numeroLatitudeDecimal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *                   &lt;element name="numeroLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="numeroLongitudeDecimal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *                   &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="percentualConfiancaEndereco" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *                   &lt;element name="siglaPais" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="enderecosEletronicos" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="codigoFinalidadeEndereco" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="descricaoFinalidadeEndereco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="codigoOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="codigoTipoEnderecoEletronico" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="dataAtualizacaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                   &lt;element name="dataAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                   &lt;element name="enderecoEletronico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="flagAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="nomeOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="fisica" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="codigoExposicaoPoliticaPessoa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="codigoGrupoAgregacaoPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="codigoSexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="codigoSituacaoPessoa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="dataAtualizacaoGrupoAgregacao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                   &lt;element name="dataNascimento" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                   &lt;element name="flagPessoaDeficienciaFisica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="flagPessoaEstrangeira" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="codigoEstadoCivil" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="nomeEstadoCivil" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="dataInclusaoRegistroEstadoCivil" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                   &lt;element name="nomeMae" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="nomePai" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="flagCadastroPortalCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="juridica" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="codigoNaturezaJuridica" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="dataRegistroAbertura" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                   &lt;element name="nomeAtividadeCnae" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="nomeNaturezaJuridica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="numeroCnae" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *                   &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="primeiroCodigoFonetico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="segundoCodigoFonetico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="terceiroCodigoFonetico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="telefones" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="codigoDdd" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="codigoDdi" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="codigoOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="codigoTipoTelefone" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="descricaoTipoTelefone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="dataAtualizacaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                   &lt;element name="dataAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                   &lt;element name="flagAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="nomeOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="numeroTelefone" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
    @XmlType(name = "", propOrder = {
        "codigoOrigemMovimento",
        "codigoTipoPessoa",
        "descricaoTipoPessoa",
        "dataAtualizacaoRegistro",
        "dataInclusaoRegistro",
        "documentos",
        "enderecos",
        "enderecosEletronicos",
        "fisica",
        "flagCadastroPortalCliente",
        "juridica",
        "nomeOrigemMovimento",
        "nomePessoa",
        "nomeTratamento",
        "numeroPessoa",
        "papeisPessoa",
        "primeiroCodigoFonetico",
        "segundoCodigoFonetico",
        "terceiroCodigoFonetico",
        "telefones"
    })
    public static class Pessoa implements Serializable {
       
		private static final long serialVersionUID = 1592567067621712552L;
		
		protected Short codigoOrigemMovimento;
        protected String codigoTipoPessoa;
        protected String descricaoTipoPessoa;
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar dataAtualizacaoRegistro;
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar dataInclusaoRegistro;
        protected List<ObterPessoasResponseType.Pessoa.Documentos> documentos;
        protected List<ObterPessoasResponseType.Pessoa.Enderecos> enderecos;
        protected List<ObterPessoasResponseType.Pessoa.EnderecosEletronicos> enderecosEletronicos;
        protected ObterPessoasResponseType.Pessoa.Fisica fisica;
        protected String flagCadastroPortalCliente;
        protected ObterPessoasResponseType.Pessoa.Juridica juridica;
        protected String nomeOrigemMovimento;
        protected String nomePessoa;
        protected String nomeTratamento;
        protected Long numeroPessoa;
        protected List<ObterPessoasResponseType.Pessoa.PapeisPessoa> papeisPessoa;
        protected String primeiroCodigoFonetico;
        protected String segundoCodigoFonetico;
        protected String terceiroCodigoFonetico;
        protected List<ObterPessoasResponseType.Pessoa.Telefones> telefones;

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
         * Gets the value of the documentos property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the documentos property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDocumentos().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ObterPessoasResponseType.Pessoa.Documentos }
         * 
         * 
         */
        public List<ObterPessoasResponseType.Pessoa.Documentos> getDocumentos() {
            if (documentos == null) {
                documentos = new ArrayList<ObterPessoasResponseType.Pessoa.Documentos>();
            }
            return this.documentos;
        }

        /**
         * Gets the value of the enderecos property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the enderecos property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEnderecos().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ObterPessoasResponseType.Pessoa.Enderecos }
         * 
         * 
         */
        public List<ObterPessoasResponseType.Pessoa.Enderecos> getEnderecos() {
            if (enderecos == null) {
                enderecos = new ArrayList<ObterPessoasResponseType.Pessoa.Enderecos>();
            }
            return this.enderecos;
        }

        /**
         * Gets the value of the enderecosEletronicos property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the enderecosEletronicos property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEnderecosEletronicos().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ObterPessoasResponseType.Pessoa.EnderecosEletronicos }
         * 
         * 
         */
        public List<ObterPessoasResponseType.Pessoa.EnderecosEletronicos> getEnderecosEletronicos() {
            if (enderecosEletronicos == null) {
                enderecosEletronicos = new ArrayList<ObterPessoasResponseType.Pessoa.EnderecosEletronicos>();
            }
            return this.enderecosEletronicos;
        }

        /**
         * Obt�m o valor da propriedade fisica.
         * 
         * @return
         *     possible object is
         *     {@link ObterPessoasResponseType.Pessoa.Fisica }
         *     
         */
        public ObterPessoasResponseType.Pessoa.Fisica getFisica() {
            return fisica;
        }

        /**
         * Define o valor da propriedade fisica.
         * 
         * @param value
         *     allowed object is
         *     {@link ObterPessoasResponseType.Pessoa.Fisica }
         *     
         */
        public void setFisica(ObterPessoasResponseType.Pessoa.Fisica value) {
            this.fisica = value;
        }

        /**
         * Obt�m o valor da propriedade flagCadastroPortalCliente.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFlagCadastroPortalCliente() {
            return flagCadastroPortalCliente;
        }

        /**
         * Define o valor da propriedade flagCadastroPortalCliente.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFlagCadastroPortalCliente(String value) {
            this.flagCadastroPortalCliente = value;
        }

        /**
         * Obt�m o valor da propriedade juridica.
         * 
         * @return
         *     possible object is
         *     {@link ObterPessoasResponseType.Pessoa.Juridica }
         *     
         */
        public ObterPessoasResponseType.Pessoa.Juridica getJuridica() {
            return juridica;
        }

        /**
         * Define o valor da propriedade juridica.
         * 
         * @param value
         *     allowed object is
         *     {@link ObterPessoasResponseType.Pessoa.Juridica }
         *     
         */
        public void setJuridica(ObterPessoasResponseType.Pessoa.Juridica value) {
            this.juridica = value;
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
         * {@link ObterPessoasResponseType.Pessoa.PapeisPessoa }
         * 
         * 
         */
        public List<ObterPessoasResponseType.Pessoa.PapeisPessoa> getPapeisPessoa() {
            if (papeisPessoa == null) {
                papeisPessoa = new ArrayList<ObterPessoasResponseType.Pessoa.PapeisPessoa>();
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
         * Gets the value of the telefones property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the telefones property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTelefones().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ObterPessoasResponseType.Pessoa.Telefones }
         * 
         * 
         */
        public List<ObterPessoasResponseType.Pessoa.Telefones> getTelefones() {
            if (telefones == null) {
                telefones = new ArrayList<ObterPessoasResponseType.Pessoa.Telefones>();
            }
            return this.telefones;
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
        @XmlType(name = "", propOrder = {
            "codigoTipoDocumento",
            "descricaoTipoDocumento",
            "digitoCpfouCnpj",
            "flagPessoaTitularDocumento",
            "descricaoPessoaTitularDocumento",
            "numeroCpfouCnpj",
            "numeroDocumento",
            "numeroOrdemCnpj",
            "numeroPessoa",
            "numeroSequencia",
            "siglaTipoDocumento"
        })
        public static class Documentos implements Serializable{

			private static final long serialVersionUID = -4045301676551867440L;
			
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
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getCodigoTipoDocumento() {
                return codigoTipoDocumento;
            }

            /**
             * Define o valor da propriedade codigoTipoDocumento.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setCodigoTipoDocumento(Short value) {
                this.codigoTipoDocumento = value;
            }

            /**
             * Obt�m o valor da propriedade descricaoTipoDocumento.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDescricaoTipoDocumento() {
                return descricaoTipoDocumento;
            }

            /**
             * Define o valor da propriedade descricaoTipoDocumento.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDescricaoTipoDocumento(String value) {
                this.descricaoTipoDocumento = value;
            }

            /**
             * Obt�m o valor da propriedade digitoCpfouCnpj.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getDigitoCpfouCnpj() {
                return digitoCpfouCnpj;
            }

            /**
             * Define o valor da propriedade digitoCpfouCnpj.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setDigitoCpfouCnpj(Short value) {
                this.digitoCpfouCnpj = value;
            }

            /**
             * Obt�m o valor da propriedade flagPessoaTitularDocumento.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getFlagPessoaTitularDocumento() {
                return flagPessoaTitularDocumento;
            }

            /**
             * Define o valor da propriedade flagPessoaTitularDocumento.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setFlagPessoaTitularDocumento(Short value) {
                this.flagPessoaTitularDocumento = value;
            }

            /**
             * Obt�m o valor da propriedade descricaoPessoaTitularDocumento.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDescricaoPessoaTitularDocumento() {
                return descricaoPessoaTitularDocumento;
            }

            /**
             * Define o valor da propriedade descricaoPessoaTitularDocumento.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDescricaoPessoaTitularDocumento(String value) {
                this.descricaoPessoaTitularDocumento = value;
            }

            /**
             * Obt�m o valor da propriedade numeroCpfouCnpj.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getNumeroCpfouCnpj() {
                return numeroCpfouCnpj;
            }

            /**
             * Define o valor da propriedade numeroCpfouCnpj.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setNumeroCpfouCnpj(Long value) {
                this.numeroCpfouCnpj = value;
            }

            /**
             * Obt�m o valor da propriedade numeroDocumento.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNumeroDocumento() {
                return numeroDocumento;
            }

            /**
             * Define o valor da propriedade numeroDocumento.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNumeroDocumento(String value) {
                this.numeroDocumento = value;
            }

            /**
             * Obt�m o valor da propriedade numeroOrdemCnpj.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getNumeroOrdemCnpj() {
                return numeroOrdemCnpj;
            }

            /**
             * Define o valor da propriedade numeroOrdemCnpj.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setNumeroOrdemCnpj(Short value) {
                this.numeroOrdemCnpj = value;
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
             * Obt�m o valor da propriedade siglaTipoDocumento.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSiglaTipoDocumento() {
                return siglaTipoDocumento;
            }

            /**
             * Define o valor da propriedade siglaTipoDocumento.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSiglaTipoDocumento(String value) {
                this.siglaTipoDocumento = value;
            }

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
         *         &lt;element name="codigoFinalidadeEndereco" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="descricaoFinalidadeEndereco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="codigoOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="codigoUnidadeFederacao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="complementoEndereco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="dataAtualizacaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
         *         &lt;element name="dataAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
         *         &lt;element name="flagAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="flagNivelConfiancaEnderecoAtingido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="flagNivelConfiancaLocalizacaoAtingido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="indiceSucessoEntregaCorrespondencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="nomeBairro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="nomeCidade" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="nomeLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="nomeOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="nomeTipoLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="numeroComplementoCep" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="numeroInicioCep" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
         *         &lt;element name="numeroLatitudeDecimal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
         *         &lt;element name="numeroLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="numeroLongitudeDecimal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
         *         &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="percentualConfiancaEndereco" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
         *         &lt;element name="siglaPais" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "codigoFinalidadeEndereco",
            "descricaoFinalidadeEndereco",
            "codigoOrigemMovimento",
            "codigoUnidadeFederacao",
            "complementoEndereco",
            "dataAtualizacaoRegistro",
            "dataAutorizacaoPropaganda",
            "flagAutorizacaoPropaganda",
            "flagNivelConfiancaEnderecoAtingido",
            "flagNivelConfiancaLocalizacaoAtingido",
            "indiceSucessoEntregaCorrespondencia",
            "nomeBairro",
            "nomeCidade",
            "nomeLogradouro",
            "nomeOrigemMovimento",
            "nomeTipoLogradouro",
            "numeroComplementoCep",
            "numeroInicioCep",
            "numeroLatitudeDecimal",
            "numeroLogradouro",
            "numeroLongitudeDecimal",
            "numeroPessoa",
            "numeroSequencia",
            "percentualConfiancaEndereco",
            "siglaPais"
        })
        public static class Enderecos implements Serializable{

            
			private static final long serialVersionUID = 1736178043564330867L;
			
			protected Short codigoFinalidadeEndereco;
            protected String descricaoFinalidadeEndereco;
            protected Short codigoOrigemMovimento;
            protected String codigoUnidadeFederacao;
            protected String complementoEndereco;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dataAtualizacaoRegistro;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dataAutorizacaoPropaganda;
            protected String flagAutorizacaoPropaganda;
            protected String flagNivelConfiancaEnderecoAtingido;
            protected String flagNivelConfiancaLocalizacaoAtingido;
            protected Short indiceSucessoEntregaCorrespondencia;
            protected String nomeBairro;
            protected String nomeCidade;
            protected String nomeLogradouro;
            protected String nomeOrigemMovimento;
            protected String nomeTipoLogradouro;
            protected Short numeroComplementoCep;
            protected Integer numeroInicioCep;
            protected BigDecimal numeroLatitudeDecimal;
            protected String numeroLogradouro;
            protected BigDecimal numeroLongitudeDecimal;
            protected Long numeroPessoa;
            protected Short numeroSequencia;
            protected BigDecimal percentualConfiancaEndereco;
            protected String siglaPais;

            /**
             * Obt�m o valor da propriedade codigoFinalidadeEndereco.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getCodigoFinalidadeEndereco() {
                return codigoFinalidadeEndereco;
            }

            /**
             * Define o valor da propriedade codigoFinalidadeEndereco.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setCodigoFinalidadeEndereco(Short value) {
                this.codigoFinalidadeEndereco = value;
            }

            /**
             * Obt�m o valor da propriedade descricaoFinalidadeEndereco.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDescricaoFinalidadeEndereco() {
                return descricaoFinalidadeEndereco;
            }

            /**
             * Define o valor da propriedade descricaoFinalidadeEndereco.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDescricaoFinalidadeEndereco(String value) {
                this.descricaoFinalidadeEndereco = value;
            }

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
             * Obt�m o valor da propriedade codigoUnidadeFederacao.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCodigoUnidadeFederacao() {
                return codigoUnidadeFederacao;
            }

            /**
             * Define o valor da propriedade codigoUnidadeFederacao.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCodigoUnidadeFederacao(String value) {
                this.codigoUnidadeFederacao = value;
            }

            /**
             * Obt�m o valor da propriedade complementoEndereco.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getComplementoEndereco() {
                return complementoEndereco;
            }

            /**
             * Define o valor da propriedade complementoEndereco.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setComplementoEndereco(String value) {
                this.complementoEndereco = value;
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
             * Obt�m o valor da propriedade dataAutorizacaoPropaganda.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getDataAutorizacaoPropaganda() {
                return dataAutorizacaoPropaganda;
            }

            /**
             * Define o valor da propriedade dataAutorizacaoPropaganda.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setDataAutorizacaoPropaganda(XMLGregorianCalendar value) {
                this.dataAutorizacaoPropaganda = value;
            }

            /**
             * Obt�m o valor da propriedade flagAutorizacaoPropaganda.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFlagAutorizacaoPropaganda() {
                return flagAutorizacaoPropaganda;
            }

            /**
             * Define o valor da propriedade flagAutorizacaoPropaganda.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFlagAutorizacaoPropaganda(String value) {
                this.flagAutorizacaoPropaganda = value;
            }

            /**
             * Obt�m o valor da propriedade flagNivelConfiancaEnderecoAtingido.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFlagNivelConfiancaEnderecoAtingido() {
                return flagNivelConfiancaEnderecoAtingido;
            }

            /**
             * Define o valor da propriedade flagNivelConfiancaEnderecoAtingido.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFlagNivelConfiancaEnderecoAtingido(String value) {
                this.flagNivelConfiancaEnderecoAtingido = value;
            }

            /**
             * Obt�m o valor da propriedade flagNivelConfiancaLocalizacaoAtingido.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFlagNivelConfiancaLocalizacaoAtingido() {
                return flagNivelConfiancaLocalizacaoAtingido;
            }

            /**
             * Define o valor da propriedade flagNivelConfiancaLocalizacaoAtingido.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFlagNivelConfiancaLocalizacaoAtingido(String value) {
                this.flagNivelConfiancaLocalizacaoAtingido = value;
            }

            /**
             * Obt�m o valor da propriedade indiceSucessoEntregaCorrespondencia.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getIndiceSucessoEntregaCorrespondencia() {
                return indiceSucessoEntregaCorrespondencia;
            }

            /**
             * Define o valor da propriedade indiceSucessoEntregaCorrespondencia.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setIndiceSucessoEntregaCorrespondencia(Short value) {
                this.indiceSucessoEntregaCorrespondencia = value;
            }

            /**
             * Obt�m o valor da propriedade nomeBairro.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNomeBairro() {
                return nomeBairro;
            }

            /**
             * Define o valor da propriedade nomeBairro.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNomeBairro(String value) {
                this.nomeBairro = value;
            }

            /**
             * Obt�m o valor da propriedade nomeCidade.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNomeCidade() {
                return nomeCidade;
            }

            /**
             * Define o valor da propriedade nomeCidade.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNomeCidade(String value) {
                this.nomeCidade = value;
            }

            /**
             * Obt�m o valor da propriedade nomeLogradouro.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNomeLogradouro() {
                return nomeLogradouro;
            }

            /**
             * Define o valor da propriedade nomeLogradouro.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNomeLogradouro(String value) {
                this.nomeLogradouro = value;
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
             * Obt�m o valor da propriedade nomeTipoLogradouro.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNomeTipoLogradouro() {
                return nomeTipoLogradouro;
            }

            /**
             * Define o valor da propriedade nomeTipoLogradouro.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNomeTipoLogradouro(String value) {
                this.nomeTipoLogradouro = value;
            }

            /**
             * Obt�m o valor da propriedade numeroComplementoCep.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getNumeroComplementoCep() {
                return numeroComplementoCep;
            }

            /**
             * Define o valor da propriedade numeroComplementoCep.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setNumeroComplementoCep(Short value) {
                this.numeroComplementoCep = value;
            }

            /**
             * Obt�m o valor da propriedade numeroInicioCep.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public Integer getNumeroInicioCep() {
                return numeroInicioCep;
            }

            /**
             * Define o valor da propriedade numeroInicioCep.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setNumeroInicioCep(Integer value) {
                this.numeroInicioCep = value;
            }

            /**
             * Obt�m o valor da propriedade numeroLatitudeDecimal.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getNumeroLatitudeDecimal() {
                return numeroLatitudeDecimal;
            }

            /**
             * Define o valor da propriedade numeroLatitudeDecimal.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setNumeroLatitudeDecimal(BigDecimal value) {
                this.numeroLatitudeDecimal = value;
            }

            /**
             * Obt�m o valor da propriedade numeroLogradouro.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNumeroLogradouro() {
                return numeroLogradouro;
            }

            /**
             * Define o valor da propriedade numeroLogradouro.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNumeroLogradouro(String value) {
                this.numeroLogradouro = value;
            }

            /**
             * Obt�m o valor da propriedade numeroLongitudeDecimal.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getNumeroLongitudeDecimal() {
                return numeroLongitudeDecimal;
            }

            /**
             * Define o valor da propriedade numeroLongitudeDecimal.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setNumeroLongitudeDecimal(BigDecimal value) {
                this.numeroLongitudeDecimal = value;
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
             * Obt�m o valor da propriedade percentualConfiancaEndereco.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getPercentualConfiancaEndereco() {
                return percentualConfiancaEndereco;
            }

            /**
             * Define o valor da propriedade percentualConfiancaEndereco.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setPercentualConfiancaEndereco(BigDecimal value) {
                this.percentualConfiancaEndereco = value;
            }

            /**
             * Obt�m o valor da propriedade siglaPais.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSiglaPais() {
                return siglaPais;
            }

            /**
             * Define o valor da propriedade siglaPais.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSiglaPais(String value) {
                this.siglaPais = value;
            }

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
         *         &lt;element name="codigoFinalidadeEndereco" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="descricaoFinalidadeEndereco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="codigoOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="codigoTipoEnderecoEletronico" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="dataAtualizacaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
         *         &lt;element name="dataAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
         *         &lt;element name="enderecoEletronico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="flagAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="nomeOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
            "codigoFinalidadeEndereco",
            "descricaoFinalidadeEndereco",
            "codigoOrigemMovimento",
            "codigoTipoEnderecoEletronico",
            "dataAtualizacaoRegistro",
            "dataAutorizacaoPropaganda",
            "enderecoEletronico",
            "flagAutorizacaoPropaganda",
            "nomeOrigemMovimento",
            "numeroPessoa",
            "numeroSequencia"
        })
        public static class EnderecosEletronicos implements Serializable{
        	
			private static final long serialVersionUID = 884667210520872264L;
			
			protected Short codigoFinalidadeEndereco;
            protected String descricaoFinalidadeEndereco;
            protected Short codigoOrigemMovimento;
            protected Short codigoTipoEnderecoEletronico;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dataAtualizacaoRegistro;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dataAutorizacaoPropaganda;
            protected String enderecoEletronico;
            protected String flagAutorizacaoPropaganda;
            protected String nomeOrigemMovimento;
            protected Long numeroPessoa;
            protected Short numeroSequencia;

            /**
             * Obt�m o valor da propriedade codigoFinalidadeEndereco.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getCodigoFinalidadeEndereco() {
                return codigoFinalidadeEndereco;
            }

            /**
             * Define o valor da propriedade codigoFinalidadeEndereco.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setCodigoFinalidadeEndereco(Short value) {
                this.codigoFinalidadeEndereco = value;
            }

            /**
             * Obt�m o valor da propriedade descricaoFinalidadeEndereco.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDescricaoFinalidadeEndereco() {
                return descricaoFinalidadeEndereco;
            }

            /**
             * Define o valor da propriedade descricaoFinalidadeEndereco.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDescricaoFinalidadeEndereco(String value) {
                this.descricaoFinalidadeEndereco = value;
            }

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
             * Obt�m o valor da propriedade codigoTipoEnderecoEletronico.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getCodigoTipoEnderecoEletronico() {
                return codigoTipoEnderecoEletronico;
            }

            /**
             * Define o valor da propriedade codigoTipoEnderecoEletronico.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setCodigoTipoEnderecoEletronico(Short value) {
                this.codigoTipoEnderecoEletronico = value;
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
             * Obt�m o valor da propriedade dataAutorizacaoPropaganda.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getDataAutorizacaoPropaganda() {
                return dataAutorizacaoPropaganda;
            }

            /**
             * Define o valor da propriedade dataAutorizacaoPropaganda.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setDataAutorizacaoPropaganda(XMLGregorianCalendar value) {
                this.dataAutorizacaoPropaganda = value;
            }

            /**
             * Obt�m o valor da propriedade enderecoEletronico.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEnderecoEletronico() {
                return enderecoEletronico;
            }

            /**
             * Define o valor da propriedade enderecoEletronico.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEnderecoEletronico(String value) {
                this.enderecoEletronico = value;
            }

            /**
             * Obt�m o valor da propriedade flagAutorizacaoPropaganda.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFlagAutorizacaoPropaganda() {
                return flagAutorizacaoPropaganda;
            }

            /**
             * Define o valor da propriedade flagAutorizacaoPropaganda.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFlagAutorizacaoPropaganda(String value) {
                this.flagAutorizacaoPropaganda = value;
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
         *         &lt;element name="codigoExposicaoPoliticaPessoa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="codigoGrupoAgregacaoPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="codigoSexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="codigoSituacaoPessoa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="dataAtualizacaoGrupoAgregacao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
         *         &lt;element name="dataNascimento" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
         *         &lt;element name="flagPessoaDeficienciaFisica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="flagPessoaEstrangeira" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="codigoEstadoCivil" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="nomeEstadoCivil" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="dataInclusaoRegistroEstadoCivil" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
         *         &lt;element name="nomeMae" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="nomePai" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
            "codigoExposicaoPoliticaPessoa",
            "codigoGrupoAgregacaoPessoa",
            "codigoSexo",
            "codigoSituacaoPessoa",
            "dataAtualizacaoGrupoAgregacao",
            "dataNascimento",
            "flagPessoaDeficienciaFisica",
            "flagPessoaEstrangeira",
            "codigoEstadoCivil",
            "nomeEstadoCivil",
            "dataInclusaoRegistroEstadoCivil",
            "nomeMae",
            "nomePai",
            "numeroPessoa"
        })
        public static class Fisica implements Serializable{
        	
			private static final long serialVersionUID = -1819190779760628262L;
			
			protected Short codigoExposicaoPoliticaPessoa;
            protected Long codigoGrupoAgregacaoPessoa;
            protected String codigoSexo;
            protected Short codigoSituacaoPessoa;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dataAtualizacaoGrupoAgregacao;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dataNascimento;
            protected String flagPessoaDeficienciaFisica;
            protected String flagPessoaEstrangeira;
            protected Short codigoEstadoCivil;
            protected String nomeEstadoCivil;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dataInclusaoRegistroEstadoCivil;
            protected String nomeMae;
            protected String nomePai;
            protected Long numeroPessoa;

            /**
             * Obt�m o valor da propriedade codigoExposicaoPoliticaPessoa.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getCodigoExposicaoPoliticaPessoa() {
                return codigoExposicaoPoliticaPessoa;
            }

            /**
             * Define o valor da propriedade codigoExposicaoPoliticaPessoa.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setCodigoExposicaoPoliticaPessoa(Short value) {
                this.codigoExposicaoPoliticaPessoa = value;
            }

            /**
             * Obt�m o valor da propriedade codigoGrupoAgregacaoPessoa.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getCodigoGrupoAgregacaoPessoa() {
                return codigoGrupoAgregacaoPessoa;
            }

            /**
             * Define o valor da propriedade codigoGrupoAgregacaoPessoa.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setCodigoGrupoAgregacaoPessoa(Long value) {
                this.codigoGrupoAgregacaoPessoa = value;
            }

            /**
             * Obt�m o valor da propriedade codigoSexo.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCodigoSexo() {
                return codigoSexo;
            }

            /**
             * Define o valor da propriedade codigoSexo.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCodigoSexo(String value) {
                this.codigoSexo = value;
            }

            /**
             * Obt�m o valor da propriedade codigoSituacaoPessoa.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getCodigoSituacaoPessoa() {
                return codigoSituacaoPessoa;
            }

            /**
             * Define o valor da propriedade codigoSituacaoPessoa.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setCodigoSituacaoPessoa(Short value) {
                this.codigoSituacaoPessoa = value;
            }

            /**
             * Obt�m o valor da propriedade dataAtualizacaoGrupoAgregacao.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getDataAtualizacaoGrupoAgregacao() {
                return dataAtualizacaoGrupoAgregacao;
            }

            /**
             * Define o valor da propriedade dataAtualizacaoGrupoAgregacao.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setDataAtualizacaoGrupoAgregacao(XMLGregorianCalendar value) {
                this.dataAtualizacaoGrupoAgregacao = value;
            }

            /**
             * Obt�m o valor da propriedade dataNascimento.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getDataNascimento() {
                return dataNascimento;
            }

            /**
             * Define o valor da propriedade dataNascimento.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setDataNascimento(XMLGregorianCalendar value) {
                this.dataNascimento = value;
            }

            /**
             * Obt�m o valor da propriedade flagPessoaDeficienciaFisica.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFlagPessoaDeficienciaFisica() {
                return flagPessoaDeficienciaFisica;
            }

            /**
             * Define o valor da propriedade flagPessoaDeficienciaFisica.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFlagPessoaDeficienciaFisica(String value) {
                this.flagPessoaDeficienciaFisica = value;
            }

            /**
             * Obt�m o valor da propriedade flagPessoaEstrangeira.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFlagPessoaEstrangeira() {
                return flagPessoaEstrangeira;
            }

            /**
             * Define o valor da propriedade flagPessoaEstrangeira.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFlagPessoaEstrangeira(String value) {
                this.flagPessoaEstrangeira = value;
            }

            /**
             * Obt�m o valor da propriedade codigoEstadoCivil.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getCodigoEstadoCivil() {
                return codigoEstadoCivil;
            }

            /**
             * Define o valor da propriedade codigoEstadoCivil.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setCodigoEstadoCivil(Short value) {
                this.codigoEstadoCivil = value;
            }

            /**
             * Obt�m o valor da propriedade nomeEstadoCivil.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNomeEstadoCivil() {
                return nomeEstadoCivil;
            }

            /**
             * Define o valor da propriedade nomeEstadoCivil.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNomeEstadoCivil(String value) {
                this.nomeEstadoCivil = value;
            }

            /**
             * Obt�m o valor da propriedade dataInclusaoRegistroEstadoCivil.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getDataInclusaoRegistroEstadoCivil() {
                return dataInclusaoRegistroEstadoCivil;
            }

            /**
             * Define o valor da propriedade dataInclusaoRegistroEstadoCivil.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setDataInclusaoRegistroEstadoCivil(XMLGregorianCalendar value) {
                this.dataInclusaoRegistroEstadoCivil = value;
            }

            /**
             * Obt�m o valor da propriedade nomeMae.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNomeMae() {
                return nomeMae;
            }

            /**
             * Define o valor da propriedade nomeMae.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNomeMae(String value) {
                this.nomeMae = value;
            }

            /**
             * Obt�m o valor da propriedade nomePai.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNomePai() {
                return nomePai;
            }

            /**
             * Define o valor da propriedade nomePai.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNomePai(String value) {
                this.nomePai = value;
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
         *         &lt;element name="codigoNaturezaJuridica" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="dataRegistroAbertura" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
         *         &lt;element name="nomeAtividadeCnae" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="nomeNaturezaJuridica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="numeroCnae" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
         *         &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
            "codigoNaturezaJuridica",
            "dataRegistroAbertura",
            "nomeAtividadeCnae",
            "nomeNaturezaJuridica",
            "numeroCnae",
            "numeroPessoa"
        })
        public static class Juridica implements Serializable{

			private static final long serialVersionUID = -8782299330871845969L;
			
			protected Short codigoNaturezaJuridica;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dataRegistroAbertura;
            protected String nomeAtividadeCnae;
            protected String nomeNaturezaJuridica;
            protected Integer numeroCnae;
            protected Long numeroPessoa;

            /**
             * Obt�m o valor da propriedade codigoNaturezaJuridica.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getCodigoNaturezaJuridica() {
                return codigoNaturezaJuridica;
            }

            /**
             * Define o valor da propriedade codigoNaturezaJuridica.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setCodigoNaturezaJuridica(Short value) {
                this.codigoNaturezaJuridica = value;
            }

            /**
             * Obt�m o valor da propriedade dataRegistroAbertura.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getDataRegistroAbertura() {
                return dataRegistroAbertura;
            }

            /**
             * Define o valor da propriedade dataRegistroAbertura.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setDataRegistroAbertura(XMLGregorianCalendar value) {
                this.dataRegistroAbertura = value;
            }

            /**
             * Obt�m o valor da propriedade nomeAtividadeCnae.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNomeAtividadeCnae() {
                return nomeAtividadeCnae;
            }

            /**
             * Define o valor da propriedade nomeAtividadeCnae.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNomeAtividadeCnae(String value) {
                this.nomeAtividadeCnae = value;
            }

            /**
             * Obt�m o valor da propriedade nomeNaturezaJuridica.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNomeNaturezaJuridica() {
                return nomeNaturezaJuridica;
            }

            /**
             * Define o valor da propriedade nomeNaturezaJuridica.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNomeNaturezaJuridica(String value) {
                this.nomeNaturezaJuridica = value;
            }

            /**
             * Obt�m o valor da propriedade numeroCnae.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public Integer getNumeroCnae() {
                return numeroCnae;
            }

            /**
             * Define o valor da propriedade numeroCnae.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setNumeroCnae(Integer value) {
                this.numeroCnae = value;
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
            "numeroPessoa"
        })
        public static class PapeisPessoa implements Serializable{

			private static final long serialVersionUID = 8683607250530170436L;
			
			protected Short codigoPapelPessoa;
            protected String nomePapelPessoa;
            protected Long numeroPessoa;

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
         *         &lt;element name="codigoDdd" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="codigoDdi" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="codigoOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="codigoTipoTelefone" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="descricaoTipoTelefone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="dataAtualizacaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
         *         &lt;element name="dataAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
         *         &lt;element name="flagAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="nomeOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="numeroTelefone" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
            "codigoDdd",
            "codigoDdi",
            "codigoOrigemMovimento",
            "codigoTipoTelefone",
            "descricaoTipoTelefone",
            "dataAtualizacaoRegistro",
            "dataAutorizacaoPropaganda",
            "flagAutorizacaoPropaganda",
            "nomeOrigemMovimento",
            "numeroPessoa",
            "numeroSequencia",
            "numeroTelefone"
        })
        public static class Telefones implements Serializable{

            /**
			 * 
			 */
			private static final long serialVersionUID = 3823165845811862179L;
			protected Short codigoDdd;
            protected Short codigoDdi;
            protected Short codigoOrigemMovimento;
            protected Short codigoTipoTelefone;
            protected String descricaoTipoTelefone;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dataAtualizacaoRegistro;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dataAutorizacaoPropaganda;
            protected String flagAutorizacaoPropaganda;
            protected String nomeOrigemMovimento;
            protected Long numeroPessoa;
            protected Short numeroSequencia;
            protected Long numeroTelefone;

            /**
             * Obt�m o valor da propriedade codigoDdd.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getCodigoDdd() {
                return codigoDdd;
            }

            /**
             * Define o valor da propriedade codigoDdd.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setCodigoDdd(Short value) {
                this.codigoDdd = value;
            }

            /**
             * Obt�m o valor da propriedade codigoDdi.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getCodigoDdi() {
                return codigoDdi;
            }

            /**
             * Define o valor da propriedade codigoDdi.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setCodigoDdi(Short value) {
                this.codigoDdi = value;
            }

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
             * Obt�m o valor da propriedade codigoTipoTelefone.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getCodigoTipoTelefone() {
                return codigoTipoTelefone;
            }

            /**
             * Define o valor da propriedade codigoTipoTelefone.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setCodigoTipoTelefone(Short value) {
                this.codigoTipoTelefone = value;
            }

            /**
             * Obt�m o valor da propriedade descricaoTipoTelefone.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDescricaoTipoTelefone() {
                return descricaoTipoTelefone;
            }

            /**
             * Define o valor da propriedade descricaoTipoTelefone.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDescricaoTipoTelefone(String value) {
                this.descricaoTipoTelefone = value;
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
             * Obt�m o valor da propriedade dataAutorizacaoPropaganda.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getDataAutorizacaoPropaganda() {
                return dataAutorizacaoPropaganda;
            }

            /**
             * Define o valor da propriedade dataAutorizacaoPropaganda.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setDataAutorizacaoPropaganda(XMLGregorianCalendar value) {
                this.dataAutorizacaoPropaganda = value;
            }

            /**
             * Obt�m o valor da propriedade flagAutorizacaoPropaganda.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFlagAutorizacaoPropaganda() {
                return flagAutorizacaoPropaganda;
            }

            /**
             * Define o valor da propriedade flagAutorizacaoPropaganda.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFlagAutorizacaoPropaganda(String value) {
                this.flagAutorizacaoPropaganda = value;
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
             * Obt�m o valor da propriedade numeroTelefone.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getNumeroTelefone() {
                return numeroTelefone;
            }

            /**
             * Define o valor da propriedade numeroTelefone.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setNumeroTelefone(Long value) {
                this.numeroTelefone = value;
            }

        }

    }

}
