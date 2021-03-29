
package com.porto.portocom.portal.cliente.v1.wsdl.bcp;

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
 * <p>Classe Java de ObterDadosVeiculoResponseType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ObterDadosVeiculoResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pessoa" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="retorno" type="{http://www.portoseguro.com.br/bi/integrations/ConsultaDadosBCPEBS/V2_0/}RetornoType"/>
 *                   &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                   &lt;element name="nomePessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="numeroDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="contratos" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
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
 *                             &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="codigoProdutoBcp" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="nomeProdutoBcp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="dataEmissao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="numeroItemSistemaOrigem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                             &lt;element name="numeroDigitoEndosso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="dataFinalVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="codigoEmpresaEmissao" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="nomeEmpresaEmissao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="codigoSituacaoContrato" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="nomeSituacaoContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="veiculo" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="placaVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="anoFabricacaoVeiculo" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                       &lt;element name="anoModeloVeiculo" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                       &lt;element name="nomeMarcaVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="nomeModeloVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="nomeTipoVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="numeroChassiVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="numeroItem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                                       &lt;element name="numeroLicencaVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="numeroSequenciaDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="telefones" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="codigoDdd" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                       &lt;element name="codigoDdi" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                       &lt;element name="codigoOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                       &lt;element name="codigoTipoTelefone" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                       &lt;element name="descricaoTipoTelefone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="dataAtualizacaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                                       &lt;element name="dataAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                                       &lt;element name="flagAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="nomeOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                                       &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                       &lt;element name="numeroTelefone" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="enderecosContrato" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="codigoFinalidadeEndereco" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                       &lt;element name="descricaoFinalidadeEndereco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="codigoOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                       &lt;element name="codigoUnidadeFederacao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="complementoEndereco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="dataAtualizacaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                                       &lt;element name="dataAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                                       &lt;element name="flagAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="flagNivelConfiancaEnderecoAtingido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="flagNivelConfiancaLocalizacaoAtingido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="indiceSucessoEntregaCorrespondencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                       &lt;element name="nomeBairro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="nomeCidade" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="nomeLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="nomeOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="nomeTipoLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="numeroComplementoCep" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                       &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="numeroInicioCep" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                                       &lt;element name="numeroLatitudeDecimal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                                       &lt;element name="numeroLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="numeroLongitudeDecimal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                                       &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                       &lt;element name="percentualConfiancaEndereco" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                                       &lt;element name="siglaPais" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "ObterDadosVeiculoResponseType", propOrder = {
    "pessoa"
})
public class ObterDadosVeiculoResponseType {

    protected ObterDadosVeiculoResponseType.Pessoa pessoa;

    /**
     * Obt�m o valor da propriedade pessoa.
     * 
     * @return
     *     possible object is
     *     {@link ObterDadosVeiculoResponseType.Pessoa }
     *     
     */
    public ObterDadosVeiculoResponseType.Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * Define o valor da propriedade pessoa.
     * 
     * @param value
     *     allowed object is
     *     {@link ObterDadosVeiculoResponseType.Pessoa }
     *     
     */
    public void setPessoa(ObterDadosVeiculoResponseType.Pessoa value) {
        this.pessoa = value;
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
     *         &lt;element name="retorno" type="{http://www.portoseguro.com.br/bi/integrations/ConsultaDadosBCPEBS/V2_0/}RetornoType"/>
     *         &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *         &lt;element name="nomePessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="numeroDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
     *                   &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="codigoProdutoBcp" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="nomeProdutoBcp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="dataEmissao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                   &lt;element name="numeroItemSistemaOrigem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *                   &lt;element name="numeroDigitoEndosso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                   &lt;element name="dataFinalVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                   &lt;element name="codigoEmpresaEmissao" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="nomeEmpresaEmissao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="codigoSituacaoContrato" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="nomeSituacaoContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="veiculo" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="placaVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="anoFabricacaoVeiculo" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                             &lt;element name="anoModeloVeiculo" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                             &lt;element name="nomeMarcaVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="nomeModeloVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="nomeTipoVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="numeroChassiVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="numeroItem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *                             &lt;element name="numeroLicencaVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="numeroSequenciaDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
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
     *                   &lt;element name="enderecosContrato" maxOccurs="unbounded" minOccurs="0">
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
     *                             &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="numeroInicioCep" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *                             &lt;element name="numeroLatitudeDecimal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *                             &lt;element name="numeroLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="numeroLongitudeDecimal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *                             &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                             &lt;element name="percentualConfiancaEndereco" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
     *                             &lt;element name="siglaPais" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    @XmlType(name = "", propOrder = {
        "retorno",
        "numeroPessoa",
        "nomePessoa",
        "numeroDocumento",
        "contratos"
    })
    public static class Pessoa {

        @XmlElement(required = true)
        protected RetornoType retorno;
        protected Long numeroPessoa;
        protected String nomePessoa;
        protected String numeroDocumento;
        protected List<ObterDadosVeiculoResponseType.Pessoa.Contratos> contratos;

        /**
         * Obt�m o valor da propriedade retorno.
         * 
         * @return
         *     possible object is
         *     {@link RetornoType }
         *     
         */
        public RetornoType getRetorno() {
            return retorno;
        }

        /**
         * Define o valor da propriedade retorno.
         * 
         * @param value
         *     allowed object is
         *     {@link RetornoType }
         *     
         */
        public void setRetorno(RetornoType value) {
            this.retorno = value;
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
         * {@link ObterDadosVeiculoResponseType.Pessoa.Contratos }
         * 
         * 
         */
        public List<ObterDadosVeiculoResponseType.Pessoa.Contratos> getContratos() {
            if (contratos == null) {
                contratos = new ArrayList<ObterDadosVeiculoResponseType.Pessoa.Contratos>();
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
         *         &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="codigoProdutoBcp" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="nomeProdutoBcp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="dataEmissao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
         *         &lt;element name="numeroItemSistemaOrigem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
         *         &lt;element name="numeroDigitoEndosso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
         *         &lt;element name="dataFinalVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
         *         &lt;element name="codigoEmpresaEmissao" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="nomeEmpresaEmissao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="codigoSituacaoContrato" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="nomeSituacaoContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="veiculo" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="placaVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="anoFabricacaoVeiculo" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *                   &lt;element name="anoModeloVeiculo" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *                   &lt;element name="nomeMarcaVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="nomeModeloVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="nomeTipoVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="numeroChassiVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="numeroItem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
         *                   &lt;element name="numeroLicencaVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="numeroSequenciaDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
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
         *         &lt;element name="enderecosContrato" maxOccurs="unbounded" minOccurs="0">
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
         *                   &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="numeroInicioCep" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
         *                   &lt;element name="numeroLatitudeDecimal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
         *                   &lt;element name="numeroLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="numeroLongitudeDecimal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
         *                   &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *                   &lt;element name="percentualConfiancaEndereco" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
         *                   &lt;element name="siglaPais" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "chaveDocumento",
            "numeroContrato",
            "codigoProdutoBcp",
            "nomeProdutoBcp",
            "dataEmissao",
            "numeroItemSistemaOrigem",
            "numeroDigitoEndosso",
            "dataInicioVigencia",
            "dataFinalVigencia",
            "codigoEmpresaEmissao",
            "nomeEmpresaEmissao",
            "codigoSituacaoContrato",
            "nomeSituacaoContrato",
            "veiculo",
            "telefones",
            "enderecosContrato"
        })
        public static class Contratos {

            protected List<ObterDadosVeiculoResponseType.Pessoa.Contratos.ChaveDocumento> chaveDocumento;
            protected String numeroContrato;
            protected Short codigoProdutoBcp;
            protected String nomeProdutoBcp;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dataEmissao;
            protected Integer numeroItemSistemaOrigem;
            protected String numeroDigitoEndosso;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dataInicioVigencia;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dataFinalVigencia;
            protected Short codigoEmpresaEmissao;
            protected String nomeEmpresaEmissao;
            protected Short codigoSituacaoContrato;
            protected String nomeSituacaoContrato;
            protected ObterDadosVeiculoResponseType.Pessoa.Contratos.Veiculo veiculo;
            protected List<ObterDadosVeiculoResponseType.Pessoa.Contratos.Telefones> telefones;
            protected List<ObterDadosVeiculoResponseType.Pessoa.Contratos.EnderecosContrato> enderecosContrato;

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
             * {@link ObterDadosVeiculoResponseType.Pessoa.Contratos.ChaveDocumento }
             * 
             * 
             */
            public List<ObterDadosVeiculoResponseType.Pessoa.Contratos.ChaveDocumento> getChaveDocumento() {
                if (chaveDocumento == null) {
                    chaveDocumento = new ArrayList<ObterDadosVeiculoResponseType.Pessoa.Contratos.ChaveDocumento>();
                }
                return this.chaveDocumento;
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
             * Obt�m o valor da propriedade numeroItemSistemaOrigem.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            public Integer getNumeroItemSistemaOrigem() {
                return numeroItemSistemaOrigem;
            }

            /**
             * Define o valor da propriedade numeroItemSistemaOrigem.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            public void setNumeroItemSistemaOrigem(Integer value) {
                this.numeroItemSistemaOrigem = value;
            }

            /**
             * Obt�m o valor da propriedade numeroDigitoEndosso.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNumeroDigitoEndosso() {
                return numeroDigitoEndosso;
            }

            /**
             * Define o valor da propriedade numeroDigitoEndosso.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNumeroDigitoEndosso(String value) {
                this.numeroDigitoEndosso = value;
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
             * Obt�m o valor da propriedade codigoEmpresaEmissao.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getCodigoEmpresaEmissao() {
                return codigoEmpresaEmissao;
            }

            /**
             * Define o valor da propriedade codigoEmpresaEmissao.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setCodigoEmpresaEmissao(Short value) {
                this.codigoEmpresaEmissao = value;
            }

            /**
             * Obt�m o valor da propriedade nomeEmpresaEmissao.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNomeEmpresaEmissao() {
                return nomeEmpresaEmissao;
            }

            /**
             * Define o valor da propriedade nomeEmpresaEmissao.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNomeEmpresaEmissao(String value) {
                this.nomeEmpresaEmissao = value;
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
             * Obt�m o valor da propriedade veiculo.
             * 
             * @return
             *     possible object is
             *     {@link ObterDadosVeiculoResponseType.Pessoa.Contratos.Veiculo }
             *     
             */
            public ObterDadosVeiculoResponseType.Pessoa.Contratos.Veiculo getVeiculo() {
                return veiculo;
            }

            /**
             * Define o valor da propriedade veiculo.
             * 
             * @param value
             *     allowed object is
             *     {@link ObterDadosVeiculoResponseType.Pessoa.Contratos.Veiculo }
             *     
             */
            public void setVeiculo(ObterDadosVeiculoResponseType.Pessoa.Contratos.Veiculo value) {
                this.veiculo = value;
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
             * {@link ObterDadosVeiculoResponseType.Pessoa.Contratos.Telefones }
             * 
             * 
             */
            public List<ObterDadosVeiculoResponseType.Pessoa.Contratos.Telefones> getTelefones() {
                if (telefones == null) {
                    telefones = new ArrayList<ObterDadosVeiculoResponseType.Pessoa.Contratos.Telefones>();
                }
                return this.telefones;
            }

            /**
             * Gets the value of the enderecosContrato property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the enderecosContrato property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getEnderecosContrato().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ObterDadosVeiculoResponseType.Pessoa.Contratos.EnderecosContrato }
             * 
             * 
             */
            public List<ObterDadosVeiculoResponseType.Pessoa.Contratos.EnderecosContrato> getEnderecosContrato() {
                if (enderecosContrato == null) {
                    enderecosContrato = new ArrayList<ObterDadosVeiculoResponseType.Pessoa.Contratos.EnderecosContrato>();
                }
                return this.enderecosContrato;
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
             *         &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="numeroInicioCep" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
             *         &lt;element name="numeroLatitudeDecimal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
             *         &lt;element name="numeroLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="numeroLongitudeDecimal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
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
                "numeroContrato",
                "numeroInicioCep",
                "numeroLatitudeDecimal",
                "numeroLogradouro",
                "numeroLongitudeDecimal",
                "numeroSequencia",
                "percentualConfiancaEndereco",
                "siglaPais"
            })
            public static class EnderecosContrato {

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
                protected String numeroContrato;
                protected Integer numeroInicioCep;
                protected BigDecimal numeroLatitudeDecimal;
                protected String numeroLogradouro;
                protected BigDecimal numeroLongitudeDecimal;
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
            public static class Telefones {

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
             *         &lt;element name="placaVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="anoFabricacaoVeiculo" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
             *         &lt;element name="anoModeloVeiculo" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
             *         &lt;element name="nomeMarcaVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="nomeModeloVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="nomeTipoVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="numeroChassiVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="numeroItem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
             *         &lt;element name="numeroLicencaVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="numeroSequenciaDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
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
                "placaVeiculo",
                "anoFabricacaoVeiculo",
                "anoModeloVeiculo",
                "nomeMarcaVeiculo",
                "nomeModeloVeiculo",
                "nomeTipoVeiculo",
                "numeroChassiVeiculo",
                "numeroContrato",
                "numeroItem",
                "numeroLicencaVeiculo",
                "numeroSequenciaDocumento"
            })
            public static class Veiculo {

                protected String placaVeiculo;
                protected Short anoFabricacaoVeiculo;
                protected Short anoModeloVeiculo;
                protected String nomeMarcaVeiculo;
                protected String nomeModeloVeiculo;
                protected String nomeTipoVeiculo;
                protected String numeroChassiVeiculo;
                protected String numeroContrato;
                protected Integer numeroItem;
                protected String numeroLicencaVeiculo;
                protected Short numeroSequenciaDocumento;

                /**
                 * Obt�m o valor da propriedade placaVeiculo.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getPlacaVeiculo() {
                    return placaVeiculo;
                }

                /**
                 * Define o valor da propriedade placaVeiculo.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setPlacaVeiculo(String value) {
                    this.placaVeiculo = value;
                }

                /**
                 * Obt�m o valor da propriedade anoFabricacaoVeiculo.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Short }
                 *     
                 */
                public Short getAnoFabricacaoVeiculo() {
                    return anoFabricacaoVeiculo;
                }

                /**
                 * Define o valor da propriedade anoFabricacaoVeiculo.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Short }
                 *     
                 */
                public void setAnoFabricacaoVeiculo(Short value) {
                    this.anoFabricacaoVeiculo = value;
                }

                /**
                 * Obt�m o valor da propriedade anoModeloVeiculo.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Short }
                 *     
                 */
                public Short getAnoModeloVeiculo() {
                    return anoModeloVeiculo;
                }

                /**
                 * Define o valor da propriedade anoModeloVeiculo.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Short }
                 *     
                 */
                public void setAnoModeloVeiculo(Short value) {
                    this.anoModeloVeiculo = value;
                }

                /**
                 * Obt�m o valor da propriedade nomeMarcaVeiculo.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getNomeMarcaVeiculo() {
                    return nomeMarcaVeiculo;
                }

                /**
                 * Define o valor da propriedade nomeMarcaVeiculo.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setNomeMarcaVeiculo(String value) {
                    this.nomeMarcaVeiculo = value;
                }

                /**
                 * Obt�m o valor da propriedade nomeModeloVeiculo.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getNomeModeloVeiculo() {
                    return nomeModeloVeiculo;
                }

                /**
                 * Define o valor da propriedade nomeModeloVeiculo.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setNomeModeloVeiculo(String value) {
                    this.nomeModeloVeiculo = value;
                }

                /**
                 * Obt�m o valor da propriedade nomeTipoVeiculo.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getNomeTipoVeiculo() {
                    return nomeTipoVeiculo;
                }

                /**
                 * Define o valor da propriedade nomeTipoVeiculo.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setNomeTipoVeiculo(String value) {
                    this.nomeTipoVeiculo = value;
                }

                /**
                 * Obt�m o valor da propriedade numeroChassiVeiculo.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getNumeroChassiVeiculo() {
                    return numeroChassiVeiculo;
                }

                /**
                 * Define o valor da propriedade numeroChassiVeiculo.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setNumeroChassiVeiculo(String value) {
                    this.numeroChassiVeiculo = value;
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
                 * Obt�m o valor da propriedade numeroItem.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Integer }
                 *     
                 */
                public Integer getNumeroItem() {
                    return numeroItem;
                }

                /**
                 * Define o valor da propriedade numeroItem.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Integer }
                 *     
                 */
                public void setNumeroItem(Integer value) {
                    this.numeroItem = value;
                }

                /**
                 * Obt�m o valor da propriedade numeroLicencaVeiculo.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getNumeroLicencaVeiculo() {
                    return numeroLicencaVeiculo;
                }

                /**
                 * Define o valor da propriedade numeroLicencaVeiculo.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setNumeroLicencaVeiculo(String value) {
                    this.numeroLicencaVeiculo = value;
                }

                /**
                 * Obt�m o valor da propriedade numeroSequenciaDocumento.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Short }
                 *     
                 */
                public Short getNumeroSequenciaDocumento() {
                    return numeroSequenciaDocumento;
                }

                /**
                 * Define o valor da propriedade numeroSequenciaDocumento.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Short }
                 *     
                 */
                public void setNumeroSequenciaDocumento(Short value) {
                    this.numeroSequenciaDocumento = value;
                }

            }

        }

    }

}
