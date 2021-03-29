
package com.porto.portocom.portal.cliente.v1.wsdl.bcp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Classe Java de ObterContratoCompletoResponseType complex type.
 * 
 * <p>
 * O seguinte fragmento do esquema especifica o conte�do esperado contido dentro
 * desta classe.
 * 
 * <pre>
 * &lt;complexType name="ObterContratoCompletoResponseType">
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
 *                             &lt;element name="scoreCorretor" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
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
 *                             &lt;element name="enderecosEletronicosContrato" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="codigoFinalidadeEndereco" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                       &lt;element name="descricaoFinalidadeEndereco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="codigoOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                       &lt;element name="dataAtualizacaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                                       &lt;element name="dataAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                                       &lt;element name="enderecoEletronico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="flagAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="nomeOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="codigoSituacaoContrato" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="nomeSituacaoContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="dataAtualizacaoSituacaoContrato" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="itens" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="codigoEndosso" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                       &lt;element name="codigoFormaPagamento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                       &lt;element name="codigoOrigemProposta" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                       &lt;element name="codigoTipoAlteracaoItem" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                       &lt;element name="codigoValorRecebido" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                       &lt;element name="descricaoValorRecebido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="dataEmissao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                                       &lt;element name="dataFinalVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                                       &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                                       &lt;element name="codigoSituacaoItem" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                       &lt;element name="nomeSituacaoItem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="dataInclusaoRegistroSituacaoItem" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                                       &lt;element name="localRisco" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="codigoFinalidadeEndereco" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                                 &lt;element name="descricaoFinalidadeEndereco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="codigoOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                                 &lt;element name="codigoUnidadeFederacao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="complementoEndereco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="dataAtualizacaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                                                 &lt;element name="nomeBairro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="nomeCidade" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="nomeLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="nomeTipoLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="numeroComplementoCep" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                                 &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="numeroInicioCep" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                                                 &lt;element name="numeroItem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                                                 &lt;element name="numeroLatitudeDecimal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                                                 &lt;element name="numeroLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="numeroLongitudeDecimal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                                                 &lt;element name="numeroSequenciaDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="siglaPais" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="nomeFormaPagamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="nomeTipoAlteracaoItem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="numeroDigitoEndosso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="numeroDigitoProposta" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                                       &lt;element name="numeroItem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                                       &lt;element name="numeroItemSistemaOrigem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                                       &lt;element name="numeroRenovacaoSimplificada" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                                       &lt;element name="numeroSequenciaDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                       &lt;element name="objeto" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="codigoObjeto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="codigoTipoObjeto" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                                 &lt;element name="nomeTipoObjeto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="numeroItem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                                                 &lt;element name="numeroSequenciaDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="ordemRenovacaoSimplificada" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                       &lt;element name="sinistros" maxOccurs="unbounded" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="codigoTipoPerda" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                                 &lt;element name="dataAvisoSinistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                                                 &lt;element name="nomeTipoPerda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="numeroItem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                                                 &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                                 &lt;element name="numeroSequenciaDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                                 &lt;element name="numeroSinistroOrigem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="valorContrato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                                       &lt;element name="valorRecebimento" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                                       &lt;element name="valorTotalContrato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *                                       &lt;element name="veiculo" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="anoFabricacaoVeiculo" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                                 &lt;element name="anoModeloVeiculo" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                                 &lt;element name="nomeMarcaVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="nomeModeloVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="nomeTipoVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="numeroChassiVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="numeroItem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                                                 &lt;element name="numeroLicencaVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="numeroSequenciaDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
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
 *                                       &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                                       &lt;element name="nomePapelPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="telefonesContrato" maxOccurs="unbounded" minOccurs="0">
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
 *                                       &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                       &lt;element name="numeroTelefone" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="vinculosContrato" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="chaveDocumento" maxOccurs="unbounded" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="chave" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="valor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="documentos" maxOccurs="unbounded" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="codigoTipoDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                                 &lt;element name="descricaoTipoDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="digitoCpfouCnpj" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                                 &lt;element name="flagPessoaTitularDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                                 &lt;element name="descricaoPessoaTitularDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="numeroCpfouCnpj" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                                                 &lt;element name="numeroDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="numeroOrdemCnpj" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                                 &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                                                 &lt;element name="nomePessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                                 &lt;element name="siglaTipoDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="papelPessoaContrato" maxOccurs="unbounded" minOccurs="0">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="codigoPapelPessoa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                                 &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                                                 &lt;element name="nomePapelPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                                 &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="tipoVinculoContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                                       &lt;element name="codigoProdutoBcp" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                       &lt;element name="nomeProdutoBcp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                                       &lt;element name="dataFinalVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                                       &lt;element name="dataEmissao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                                       &lt;element name="codigoOrigemProposta" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                       &lt;element name="numeroDigitoProposta" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
@XmlType(name = "ObterContratoCompletoResponseType", propOrder = { "pessoa" })
public class ObterContratoCompletoResponseType implements Serializable {

	protected List<ObterContratoCompletoResponseType.Pessoa> pessoa;

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
	 * {@link ObterContratoCompletoResponseType.Pessoa }
	 * 
	 * 
	 */
	public List<ObterContratoCompletoResponseType.Pessoa> getPessoa() {
		if (pessoa == null) {
			pessoa = new ArrayList<ObterContratoCompletoResponseType.Pessoa>();
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
	 *                   &lt;element name="scoreCorretor" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
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
	 *                   &lt;element name="enderecosEletronicosContrato" maxOccurs="unbounded" minOccurs="0">
	 *                     &lt;complexType>
	 *                       &lt;complexContent>
	 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *                           &lt;sequence>
	 *                             &lt;element name="codigoFinalidadeEndereco" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                             &lt;element name="descricaoFinalidadeEndereco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                             &lt;element name="codigoOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                             &lt;element name="dataAtualizacaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
	 *                             &lt;element name="dataAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
	 *                             &lt;element name="enderecoEletronico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                             &lt;element name="flagAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                             &lt;element name="nomeOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                             &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                             &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                           &lt;/sequence>
	 *                         &lt;/restriction>
	 *                       &lt;/complexContent>
	 *                     &lt;/complexType>
	 *                   &lt;/element>
	 *                   &lt;element name="codigoSituacaoContrato" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                   &lt;element name="nomeSituacaoContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                   &lt;element name="dataAtualizacaoSituacaoContrato" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
	 *                   &lt;element name="itens" maxOccurs="unbounded" minOccurs="0">
	 *                     &lt;complexType>
	 *                       &lt;complexContent>
	 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *                           &lt;sequence>
	 *                             &lt;element name="codigoEndosso" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                             &lt;element name="codigoFormaPagamento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                             &lt;element name="codigoOrigemProposta" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                             &lt;element name="codigoTipoAlteracaoItem" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                             &lt;element name="codigoValorRecebido" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                             &lt;element name="descricaoValorRecebido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                             &lt;element name="dataEmissao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
	 *                             &lt;element name="dataFinalVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
	 *                             &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
	 *                             &lt;element name="codigoSituacaoItem" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                             &lt;element name="nomeSituacaoItem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                             &lt;element name="dataInclusaoRegistroSituacaoItem" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
	 *                             &lt;element name="localRisco" minOccurs="0">
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
	 *                                       &lt;element name="nomeBairro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                                       &lt;element name="nomeCidade" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                                       &lt;element name="nomeLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                                       &lt;element name="nomeTipoLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                                       &lt;element name="numeroComplementoCep" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                                       &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                                       &lt;element name="numeroInicioCep" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
	 *                                       &lt;element name="numeroItem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
	 *                                       &lt;element name="numeroLatitudeDecimal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
	 *                                       &lt;element name="numeroLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                                       &lt;element name="numeroLongitudeDecimal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
	 *                                       &lt;element name="numeroSequenciaDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                                       &lt;element name="siglaPais" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                                     &lt;/sequence>
	 *                                   &lt;/restriction>
	 *                                 &lt;/complexContent>
	 *                               &lt;/complexType>
	 *                             &lt;/element>
	 *                             &lt;element name="nomeFormaPagamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                             &lt;element name="nomeTipoAlteracaoItem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                             &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                             &lt;element name="numeroDigitoEndosso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                             &lt;element name="numeroDigitoProposta" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
	 *                             &lt;element name="numeroItem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
	 *                             &lt;element name="numeroItemSistemaOrigem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
	 *                             &lt;element name="numeroRenovacaoSimplificada" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
	 *                             &lt;element name="numeroSequenciaDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                             &lt;element name="objeto" minOccurs="0">
	 *                               &lt;complexType>
	 *                                 &lt;complexContent>
	 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *                                     &lt;sequence>
	 *                                       &lt;element name="codigoObjeto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                                       &lt;element name="codigoTipoObjeto" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                                       &lt;element name="nomeTipoObjeto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                                       &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                                       &lt;element name="numeroItem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
	 *                                       &lt;element name="numeroSequenciaDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                                     &lt;/sequence>
	 *                                   &lt;/restriction>
	 *                                 &lt;/complexContent>
	 *                               &lt;/complexType>
	 *                             &lt;/element>
	 *                             &lt;element name="ordemRenovacaoSimplificada" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                             &lt;element name="sinistros" maxOccurs="unbounded" minOccurs="0">
	 *                               &lt;complexType>
	 *                                 &lt;complexContent>
	 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *                                     &lt;sequence>
	 *                                       &lt;element name="codigoTipoPerda" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                                       &lt;element name="dataAvisoSinistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
	 *                                       &lt;element name="nomeTipoPerda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                                       &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                                       &lt;element name="numeroItem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
	 *                                       &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                                       &lt;element name="numeroSequenciaDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                                       &lt;element name="numeroSinistroOrigem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                                     &lt;/sequence>
	 *                                   &lt;/restriction>
	 *                                 &lt;/complexContent>
	 *                               &lt;/complexType>
	 *                             &lt;/element>
	 *                             &lt;element name="valorContrato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
	 *                             &lt;element name="valorRecebimento" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
	 *                             &lt;element name="valorTotalContrato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
	 *                             &lt;element name="veiculo" minOccurs="0">
	 *                               &lt;complexType>
	 *                                 &lt;complexContent>
	 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *                                     &lt;sequence>
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
	 *                           &lt;/sequence>
	 *                         &lt;/restriction>
	 *                       &lt;/complexContent>
	 *                     &lt;/complexType>
	 *                   &lt;/element>
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
	 *                             &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
	 *                             &lt;element name="nomePapelPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                             &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                           &lt;/sequence>
	 *                         &lt;/restriction>
	 *                       &lt;/complexContent>
	 *                     &lt;/complexType>
	 *                   &lt;/element>
	 *                   &lt;element name="telefonesContrato" maxOccurs="unbounded" minOccurs="0">
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
	 *                             &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                             &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                             &lt;element name="numeroTelefone" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
	 *                           &lt;/sequence>
	 *                         &lt;/restriction>
	 *                       &lt;/complexContent>
	 *                     &lt;/complexType>
	 *                   &lt;/element>
	 *                   &lt;element name="vinculosContrato" maxOccurs="unbounded" minOccurs="0">
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
	 *                             &lt;element name="documentos" maxOccurs="unbounded" minOccurs="0">
	 *                               &lt;complexType>
	 *                                 &lt;complexContent>
	 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *                                     &lt;sequence>
	 *                                       &lt;element name="codigoTipoDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                                       &lt;element name="descricaoTipoDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                                       &lt;element name="digitoCpfouCnpj" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                                       &lt;element name="flagPessoaTitularDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                                       &lt;element name="descricaoPessoaTitularDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                                       &lt;element name="numeroCpfouCnpj" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
	 *                                       &lt;element name="numeroDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                                       &lt;element name="numeroOrdemCnpj" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                                       &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
	 *                                       &lt;element name="nomePessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                                       &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                                       &lt;element name="siglaTipoDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                                     &lt;/sequence>
	 *                                   &lt;/restriction>
	 *                                 &lt;/complexContent>
	 *                               &lt;/complexType>
	 *                             &lt;/element>
	 *                             &lt;element name="papelPessoaContrato" maxOccurs="unbounded" minOccurs="0">
	 *                               &lt;complexType>
	 *                                 &lt;complexContent>
	 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *                                     &lt;sequence>
	 *                                       &lt;element name="codigoPapelPessoa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                                       &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
	 *                                       &lt;element name="nomePapelPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                                       &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                                     &lt;/sequence>
	 *                                   &lt;/restriction>
	 *                                 &lt;/complexContent>
	 *                               &lt;/complexType>
	 *                             &lt;/element>
	 *                             &lt;element name="tipoVinculoContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                             &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
	 *                             &lt;element name="codigoProdutoBcp" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                             &lt;element name="nomeProdutoBcp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
	 *                             &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
	 *                             &lt;element name="dataFinalVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
	 *                             &lt;element name="dataEmissao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
	 *                             &lt;element name="codigoOrigemProposta" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
	 *                             &lt;element name="numeroDigitoProposta" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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

		private static final long serialVersionUID = 5802558772523323202L;

		protected Short codigoOrigemMovimento;
		protected String codigoTipoPessoa;
		protected String descricaoTipoPessoa;
		protected List<ObterContratoCompletoResponseType.Pessoa.Contratos> contratos;
		@XmlSchemaType(name = "dateTime")
		protected XMLGregorianCalendar dataAtualizacaoRegistro;
		@XmlSchemaType(name = "dateTime")
		protected XMLGregorianCalendar dataInclusaoRegistro;
		protected List<ObterContratoCompletoResponseType.Pessoa.Documentos> documentos;
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
		 * {@link ObterContratoCompletoResponseType.Pessoa.Contratos }
		 * 
		 * 
		 */
		public List<ObterContratoCompletoResponseType.Pessoa.Contratos> getContratos() {
			if (contratos == null) {
				contratos = new ArrayList<ObterContratoCompletoResponseType.Pessoa.Contratos>();
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
		 * {@link ObterContratoCompletoResponseType.Pessoa.Documentos }
		 * 
		 * 
		 */
		public List<ObterContratoCompletoResponseType.Pessoa.Documentos> getDocumentos() {
			if (documentos == null) {
				documentos = new ArrayList<ObterContratoCompletoResponseType.Pessoa.Documentos>();
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
		 *         &lt;element name="scoreCorretor" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
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
		 *         &lt;element name="enderecosEletronicosContrato" maxOccurs="unbounded" minOccurs="0">
		 *           &lt;complexType>
		 *             &lt;complexContent>
		 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
		 *                 &lt;sequence>
		 *                   &lt;element name="codigoFinalidadeEndereco" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *                   &lt;element name="descricaoFinalidadeEndereco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                   &lt;element name="codigoOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *                   &lt;element name="dataAtualizacaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
		 *                   &lt;element name="dataAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
		 *                   &lt;element name="enderecoEletronico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                   &lt;element name="flagAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                   &lt;element name="nomeOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                   &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                   &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *                 &lt;/sequence>
		 *               &lt;/restriction>
		 *             &lt;/complexContent>
		 *           &lt;/complexType>
		 *         &lt;/element>
		 *         &lt;element name="codigoSituacaoContrato" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *         &lt;element name="nomeSituacaoContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *         &lt;element name="dataAtualizacaoSituacaoContrato" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
		 *         &lt;element name="itens" maxOccurs="unbounded" minOccurs="0">
		 *           &lt;complexType>
		 *             &lt;complexContent>
		 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
		 *                 &lt;sequence>
		 *                   &lt;element name="codigoEndosso" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *                   &lt;element name="codigoFormaPagamento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *                   &lt;element name="codigoOrigemProposta" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *                   &lt;element name="codigoTipoAlteracaoItem" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *                   &lt;element name="codigoValorRecebido" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *                   &lt;element name="descricaoValorRecebido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                   &lt;element name="dataEmissao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
		 *                   &lt;element name="dataFinalVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
		 *                   &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
		 *                   &lt;element name="codigoSituacaoItem" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *                   &lt;element name="nomeSituacaoItem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                   &lt;element name="dataInclusaoRegistroSituacaoItem" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
		 *                   &lt;element name="localRisco" minOccurs="0">
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
		 *                             &lt;element name="nomeBairro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                             &lt;element name="nomeCidade" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                             &lt;element name="nomeLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                             &lt;element name="nomeTipoLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                             &lt;element name="numeroComplementoCep" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *                             &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                             &lt;element name="numeroInicioCep" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
		 *                             &lt;element name="numeroItem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
		 *                             &lt;element name="numeroLatitudeDecimal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
		 *                             &lt;element name="numeroLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                             &lt;element name="numeroLongitudeDecimal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
		 *                             &lt;element name="numeroSequenciaDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                             &lt;element name="siglaPais" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                           &lt;/sequence>
		 *                         &lt;/restriction>
		 *                       &lt;/complexContent>
		 *                     &lt;/complexType>
		 *                   &lt;/element>
		 *                   &lt;element name="nomeFormaPagamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                   &lt;element name="nomeTipoAlteracaoItem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                   &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                   &lt;element name="numeroDigitoEndosso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                   &lt;element name="numeroDigitoProposta" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
		 *                   &lt;element name="numeroItem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
		 *                   &lt;element name="numeroItemSistemaOrigem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
		 *                   &lt;element name="numeroRenovacaoSimplificada" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
		 *                   &lt;element name="numeroSequenciaDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *                   &lt;element name="objeto" minOccurs="0">
		 *                     &lt;complexType>
		 *                       &lt;complexContent>
		 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
		 *                           &lt;sequence>
		 *                             &lt;element name="codigoObjeto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                             &lt;element name="codigoTipoObjeto" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *                             &lt;element name="nomeTipoObjeto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                             &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                             &lt;element name="numeroItem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
		 *                             &lt;element name="numeroSequenciaDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *                           &lt;/sequence>
		 *                         &lt;/restriction>
		 *                       &lt;/complexContent>
		 *                     &lt;/complexType>
		 *                   &lt;/element>
		 *                   &lt;element name="ordemRenovacaoSimplificada" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *                   &lt;element name="sinistros" maxOccurs="unbounded" minOccurs="0">
		 *                     &lt;complexType>
		 *                       &lt;complexContent>
		 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
		 *                           &lt;sequence>
		 *                             &lt;element name="codigoTipoPerda" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *                             &lt;element name="dataAvisoSinistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
		 *                             &lt;element name="nomeTipoPerda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                             &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                             &lt;element name="numeroItem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
		 *                             &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *                             &lt;element name="numeroSequenciaDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *                             &lt;element name="numeroSinistroOrigem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                           &lt;/sequence>
		 *                         &lt;/restriction>
		 *                       &lt;/complexContent>
		 *                     &lt;/complexType>
		 *                   &lt;/element>
		 *                   &lt;element name="valorContrato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
		 *                   &lt;element name="valorRecebimento" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
		 *                   &lt;element name="valorTotalContrato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
		 *                   &lt;element name="veiculo" minOccurs="0">
		 *                     &lt;complexType>
		 *                       &lt;complexContent>
		 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
		 *                           &lt;sequence>
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
		 *                 &lt;/sequence>
		 *               &lt;/restriction>
		 *             &lt;/complexContent>
		 *           &lt;/complexType>
		 *         &lt;/element>
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
		 *                   &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
		 *                   &lt;element name="nomePapelPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                   &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                 &lt;/sequence>
		 *               &lt;/restriction>
		 *             &lt;/complexContent>
		 *           &lt;/complexType>
		 *         &lt;/element>
		 *         &lt;element name="telefonesContrato" maxOccurs="unbounded" minOccurs="0">
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
		 *                   &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                   &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *                   &lt;element name="numeroTelefone" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
		 *                 &lt;/sequence>
		 *               &lt;/restriction>
		 *             &lt;/complexContent>
		 *           &lt;/complexType>
		 *         &lt;/element>
		 *         &lt;element name="vinculosContrato" maxOccurs="unbounded" minOccurs="0">
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
		 *                             &lt;element name="nomePessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                             &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *                             &lt;element name="siglaTipoDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                           &lt;/sequence>
		 *                         &lt;/restriction>
		 *                       &lt;/complexContent>
		 *                     &lt;/complexType>
		 *                   &lt;/element>
		 *                   &lt;element name="papelPessoaContrato" maxOccurs="unbounded" minOccurs="0">
		 *                     &lt;complexType>
		 *                       &lt;complexContent>
		 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
		 *                           &lt;sequence>
		 *                             &lt;element name="codigoPapelPessoa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *                             &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
		 *                             &lt;element name="nomePapelPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                             &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                           &lt;/sequence>
		 *                         &lt;/restriction>
		 *                       &lt;/complexContent>
		 *                     &lt;/complexType>
		 *                   &lt;/element>
		 *                   &lt;element name="tipoVinculoContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                   &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
		 *                   &lt;element name="codigoProdutoBcp" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *                   &lt;element name="nomeProdutoBcp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
		 *                   &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
		 *                   &lt;element name="dataFinalVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
		 *                   &lt;element name="dataEmissao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
		 *                   &lt;element name="codigoOrigemProposta" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
		 *                   &lt;element name="numeroDigitoProposta" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
		@XmlType(name = "", propOrder = { "codigoSusep", "scoreCorretor", "chaveDocumento", "codigoCanalVenda",
				"codigoEmpresaQuemEmitiu", "codigoOrigemProposta", "codigoProdutoOrigem", "codigoProdutoBcp",
				"codigoSegmento", "nomeSegmento", "dataEmissao", "dataFinalVigencia", "dataInicioVigencia",
				"enderecosContrato", "enderecosEletronicosContrato", "codigoSituacaoContrato", "nomeSituacaoContrato",
				"dataAtualizacaoSituacaoContrato", "itens", "nomeCanalVenda", "nomeEmpresaQuemEmitiu", "nomeProdutoBcp",
				"numeroClienteSistemaOrigem", "numeroContrato", "numeroContratoSistemaOrigem",
				"numeroContratoVinculado", "numeroDigitoProposta", "numeroPessoa", "papelPessoaContrato",
				"telefonesContrato", "vinculosContrato" })
		public static class Contratos implements Serializable {

			protected String codigoSusep;
			protected Short scoreCorretor;
			protected List<ObterContratoCompletoResponseType.Pessoa.Contratos.ChaveDocumento> chaveDocumento;
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
			protected List<ObterContratoCompletoResponseType.Pessoa.Contratos.EnderecosContrato> enderecosContrato;
			protected List<ObterContratoCompletoResponseType.Pessoa.Contratos.EnderecosEletronicosContrato> enderecosEletronicosContrato;
			protected Short codigoSituacaoContrato;
			protected String nomeSituacaoContrato;
			@XmlSchemaType(name = "dateTime")
			protected XMLGregorianCalendar dataAtualizacaoSituacaoContrato;
			protected List<ObterContratoCompletoResponseType.Pessoa.Contratos.Itens> itens;
			protected String nomeCanalVenda;
			protected String nomeEmpresaQuemEmitiu;
			protected String nomeProdutoBcp;
			protected Long numeroClienteSistemaOrigem;
			protected String numeroContrato;
			protected String numeroContratoSistemaOrigem;
			protected String numeroContratoVinculado;
			protected Long numeroDigitoProposta;
			protected Long numeroPessoa;
			protected List<ObterContratoCompletoResponseType.Pessoa.Contratos.PapelPessoaContrato> papelPessoaContrato;
			protected List<ObterContratoCompletoResponseType.Pessoa.Contratos.TelefonesContrato> telefonesContrato;
			protected List<ObterContratoCompletoResponseType.Pessoa.Contratos.VinculosContrato> vinculosContrato;

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
			 * Obt�m o valor da propriedade scoreCorretor.
			 * 
			 * @return possible object is {@link Short }
			 * 
			 */
			public Short getScoreCorretor() {
				return scoreCorretor;
			}

			/**
			 * Define o valor da propriedade scoreCorretor.
			 * 
			 * @param value allowed object is {@link Short }
			 * 
			 */
			public void setScoreCorretor(Short value) {
				this.scoreCorretor = value;
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
			 * {@link ObterContratoCompletoResponseType.Pessoa.Contratos.ChaveDocumento }
			 * 
			 * 
			 */
			public List<ObterContratoCompletoResponseType.Pessoa.Contratos.ChaveDocumento> getChaveDocumento() {
				if (chaveDocumento == null) {
					chaveDocumento = new ArrayList<ObterContratoCompletoResponseType.Pessoa.Contratos.ChaveDocumento>();
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
			 * Gets the value of the enderecosContrato property.
			 * 
			 * <p>
			 * This accessor method returns a reference to the live list, not a snapshot.
			 * Therefore any modification you make to the returned list will be present
			 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
			 * for the enderecosContrato property.
			 * 
			 * <p>
			 * For example, to add a new item, do as follows:
			 * 
			 * <pre>
			 * getEnderecosContrato().add(newItem);
			 * </pre>
			 * 
			 * 
			 * <p>
			 * Objects of the following type(s) are allowed in the list
			 * {@link ObterContratoCompletoResponseType.Pessoa.Contratos.EnderecosContrato }
			 * 
			 * 
			 */
			public List<ObterContratoCompletoResponseType.Pessoa.Contratos.EnderecosContrato> getEnderecosContrato() {
				if (enderecosContrato == null) {
					enderecosContrato = new ArrayList<ObterContratoCompletoResponseType.Pessoa.Contratos.EnderecosContrato>();
				}
				return this.enderecosContrato;
			}

			/**
			 * Gets the value of the enderecosEletronicosContrato property.
			 * 
			 * <p>
			 * This accessor method returns a reference to the live list, not a snapshot.
			 * Therefore any modification you make to the returned list will be present
			 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
			 * for the enderecosEletronicosContrato property.
			 * 
			 * <p>
			 * For example, to add a new item, do as follows:
			 * 
			 * <pre>
			 * getEnderecosEletronicosContrato().add(newItem);
			 * </pre>
			 * 
			 * 
			 * <p>
			 * Objects of the following type(s) are allowed in the list
			 * {@link ObterContratoCompletoResponseType.Pessoa.Contratos.EnderecosEletronicosContrato }
			 * 
			 * 
			 */
			public List<ObterContratoCompletoResponseType.Pessoa.Contratos.EnderecosEletronicosContrato> getEnderecosEletronicosContrato() {
				if (enderecosEletronicosContrato == null) {
					enderecosEletronicosContrato = new ArrayList<ObterContratoCompletoResponseType.Pessoa.Contratos.EnderecosEletronicosContrato>();
				}
				return this.enderecosEletronicosContrato;
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
			 * Gets the value of the itens property.
			 * 
			 * <p>
			 * This accessor method returns a reference to the live list, not a snapshot.
			 * Therefore any modification you make to the returned list will be present
			 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
			 * for the itens property.
			 * 
			 * <p>
			 * For example, to add a new item, do as follows:
			 * 
			 * <pre>
			 * getItens().add(newItem);
			 * </pre>
			 * 
			 * 
			 * <p>
			 * Objects of the following type(s) are allowed in the list
			 * {@link ObterContratoCompletoResponseType.Pessoa.Contratos.Itens }
			 * 
			 * 
			 */
			public List<ObterContratoCompletoResponseType.Pessoa.Contratos.Itens> getItens() {
				if (itens == null) {
					itens = new ArrayList<ObterContratoCompletoResponseType.Pessoa.Contratos.Itens>();
				}
				return this.itens;
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
			 * {@link ObterContratoCompletoResponseType.Pessoa.Contratos.PapelPessoaContrato }
			 * 
			 * 
			 */
			public List<ObterContratoCompletoResponseType.Pessoa.Contratos.PapelPessoaContrato> getPapelPessoaContrato() {
				if (papelPessoaContrato == null) {
					papelPessoaContrato = new ArrayList<ObterContratoCompletoResponseType.Pessoa.Contratos.PapelPessoaContrato>();
				}
				return this.papelPessoaContrato;
			}

			/**
			 * Gets the value of the telefonesContrato property.
			 * 
			 * <p>
			 * This accessor method returns a reference to the live list, not a snapshot.
			 * Therefore any modification you make to the returned list will be present
			 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
			 * for the telefonesContrato property.
			 * 
			 * <p>
			 * For example, to add a new item, do as follows:
			 * 
			 * <pre>
			 * getTelefonesContrato().add(newItem);
			 * </pre>
			 * 
			 * 
			 * <p>
			 * Objects of the following type(s) are allowed in the list
			 * {@link ObterContratoCompletoResponseType.Pessoa.Contratos.TelefonesContrato }
			 * 
			 * 
			 */
			public List<ObterContratoCompletoResponseType.Pessoa.Contratos.TelefonesContrato> getTelefonesContrato() {
				if (telefonesContrato == null) {
					telefonesContrato = new ArrayList<ObterContratoCompletoResponseType.Pessoa.Contratos.TelefonesContrato>();
				}
				return this.telefonesContrato;
			}

			/**
			 * Gets the value of the vinculosContrato property.
			 * 
			 * <p>
			 * This accessor method returns a reference to the live list, not a snapshot.
			 * Therefore any modification you make to the returned list will be present
			 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
			 * for the vinculosContrato property.
			 * 
			 * <p>
			 * For example, to add a new item, do as follows:
			 * 
			 * <pre>
			 * getVinculosContrato().add(newItem);
			 * </pre>
			 * 
			 * 
			 * <p>
			 * Objects of the following type(s) are allowed in the list
			 * {@link ObterContratoCompletoResponseType.Pessoa.Contratos.VinculosContrato }
			 * 
			 * 
			 */
			public List<ObterContratoCompletoResponseType.Pessoa.Contratos.VinculosContrato> getVinculosContrato() {
				if (vinculosContrato == null) {
					vinculosContrato = new ArrayList<ObterContratoCompletoResponseType.Pessoa.Contratos.VinculosContrato>();
				}
				return this.vinculosContrato;
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
			@XmlType(name = "", propOrder = { "codigoFinalidadeEndereco", "descricaoFinalidadeEndereco",
					"codigoOrigemMovimento", "codigoUnidadeFederacao", "complementoEndereco", "dataAtualizacaoRegistro",
					"dataAutorizacaoPropaganda", "flagAutorizacaoPropaganda", "flagNivelConfiancaEnderecoAtingido",
					"flagNivelConfiancaLocalizacaoAtingido", "indiceSucessoEntregaCorrespondencia", "nomeBairro",
					"nomeCidade", "nomeLogradouro", "nomeOrigemMovimento", "nomeTipoLogradouro", "numeroComplementoCep",
					"numeroContrato", "numeroInicioCep", "numeroLatitudeDecimal", "numeroLogradouro",
					"numeroLongitudeDecimal", "numeroSequencia", "percentualConfiancaEndereco", "siglaPais" })
			public static class EnderecosContrato implements Serializable {

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
				 * @return possible object is {@link Short }
				 * 
				 */
				public Short getCodigoFinalidadeEndereco() {
					return codigoFinalidadeEndereco;
				}

				/**
				 * Define o valor da propriedade codigoFinalidadeEndereco.
				 * 
				 * @param value allowed object is {@link Short }
				 * 
				 */
				public void setCodigoFinalidadeEndereco(Short value) {
					this.codigoFinalidadeEndereco = value;
				}

				/**
				 * Obt�m o valor da propriedade descricaoFinalidadeEndereco.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getDescricaoFinalidadeEndereco() {
					return descricaoFinalidadeEndereco;
				}

				/**
				 * Define o valor da propriedade descricaoFinalidadeEndereco.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setDescricaoFinalidadeEndereco(String value) {
					this.descricaoFinalidadeEndereco = value;
				}

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
				 * Obt�m o valor da propriedade codigoUnidadeFederacao.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getCodigoUnidadeFederacao() {
					return codigoUnidadeFederacao;
				}

				/**
				 * Define o valor da propriedade codigoUnidadeFederacao.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setCodigoUnidadeFederacao(String value) {
					this.codigoUnidadeFederacao = value;
				}

				/**
				 * Obt�m o valor da propriedade complementoEndereco.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getComplementoEndereco() {
					return complementoEndereco;
				}

				/**
				 * Define o valor da propriedade complementoEndereco.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setComplementoEndereco(String value) {
					this.complementoEndereco = value;
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
				 * Obt�m o valor da propriedade dataAutorizacaoPropaganda.
				 * 
				 * @return possible object is {@link XMLGregorianCalendar }
				 * 
				 */
				public XMLGregorianCalendar getDataAutorizacaoPropaganda() {
					return dataAutorizacaoPropaganda;
				}

				/**
				 * Define o valor da propriedade dataAutorizacaoPropaganda.
				 * 
				 * @param value allowed object is {@link XMLGregorianCalendar }
				 * 
				 */
				public void setDataAutorizacaoPropaganda(XMLGregorianCalendar value) {
					this.dataAutorizacaoPropaganda = value;
				}

				/**
				 * Obt�m o valor da propriedade flagAutorizacaoPropaganda.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getFlagAutorizacaoPropaganda() {
					return flagAutorizacaoPropaganda;
				}

				/**
				 * Define o valor da propriedade flagAutorizacaoPropaganda.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setFlagAutorizacaoPropaganda(String value) {
					this.flagAutorizacaoPropaganda = value;
				}

				/**
				 * Obt�m o valor da propriedade flagNivelConfiancaEnderecoAtingido.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getFlagNivelConfiancaEnderecoAtingido() {
					return flagNivelConfiancaEnderecoAtingido;
				}

				/**
				 * Define o valor da propriedade flagNivelConfiancaEnderecoAtingido.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setFlagNivelConfiancaEnderecoAtingido(String value) {
					this.flagNivelConfiancaEnderecoAtingido = value;
				}

				/**
				 * Obt�m o valor da propriedade flagNivelConfiancaLocalizacaoAtingido.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getFlagNivelConfiancaLocalizacaoAtingido() {
					return flagNivelConfiancaLocalizacaoAtingido;
				}

				/**
				 * Define o valor da propriedade flagNivelConfiancaLocalizacaoAtingido.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setFlagNivelConfiancaLocalizacaoAtingido(String value) {
					this.flagNivelConfiancaLocalizacaoAtingido = value;
				}

				/**
				 * Obt�m o valor da propriedade indiceSucessoEntregaCorrespondencia.
				 * 
				 * @return possible object is {@link Short }
				 * 
				 */
				public Short getIndiceSucessoEntregaCorrespondencia() {
					return indiceSucessoEntregaCorrespondencia;
				}

				/**
				 * Define o valor da propriedade indiceSucessoEntregaCorrespondencia.
				 * 
				 * @param value allowed object is {@link Short }
				 * 
				 */
				public void setIndiceSucessoEntregaCorrespondencia(Short value) {
					this.indiceSucessoEntregaCorrespondencia = value;
				}

				/**
				 * Obt�m o valor da propriedade nomeBairro.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getNomeBairro() {
					return nomeBairro;
				}

				/**
				 * Define o valor da propriedade nomeBairro.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setNomeBairro(String value) {
					this.nomeBairro = value;
				}

				/**
				 * Obt�m o valor da propriedade nomeCidade.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getNomeCidade() {
					return nomeCidade;
				}

				/**
				 * Define o valor da propriedade nomeCidade.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setNomeCidade(String value) {
					this.nomeCidade = value;
				}

				/**
				 * Obt�m o valor da propriedade nomeLogradouro.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getNomeLogradouro() {
					return nomeLogradouro;
				}

				/**
				 * Define o valor da propriedade nomeLogradouro.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setNomeLogradouro(String value) {
					this.nomeLogradouro = value;
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
				 * Obt�m o valor da propriedade nomeTipoLogradouro.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getNomeTipoLogradouro() {
					return nomeTipoLogradouro;
				}

				/**
				 * Define o valor da propriedade nomeTipoLogradouro.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setNomeTipoLogradouro(String value) {
					this.nomeTipoLogradouro = value;
				}

				/**
				 * Obt�m o valor da propriedade numeroComplementoCep.
				 * 
				 * @return possible object is {@link Short }
				 * 
				 */
				public Short getNumeroComplementoCep() {
					return numeroComplementoCep;
				}

				/**
				 * Define o valor da propriedade numeroComplementoCep.
				 * 
				 * @param value allowed object is {@link Short }
				 * 
				 */
				public void setNumeroComplementoCep(Short value) {
					this.numeroComplementoCep = value;
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
				 * Obt�m o valor da propriedade numeroInicioCep.
				 * 
				 * @return possible object is {@link Integer }
				 * 
				 */
				public Integer getNumeroInicioCep() {
					return numeroInicioCep;
				}

				/**
				 * Define o valor da propriedade numeroInicioCep.
				 * 
				 * @param value allowed object is {@link Integer }
				 * 
				 */
				public void setNumeroInicioCep(Integer value) {
					this.numeroInicioCep = value;
				}

				/**
				 * Obt�m o valor da propriedade numeroLatitudeDecimal.
				 * 
				 * @return possible object is {@link BigDecimal }
				 * 
				 */
				public BigDecimal getNumeroLatitudeDecimal() {
					return numeroLatitudeDecimal;
				}

				/**
				 * Define o valor da propriedade numeroLatitudeDecimal.
				 * 
				 * @param value allowed object is {@link BigDecimal }
				 * 
				 */
				public void setNumeroLatitudeDecimal(BigDecimal value) {
					this.numeroLatitudeDecimal = value;
				}

				/**
				 * Obt�m o valor da propriedade numeroLogradouro.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getNumeroLogradouro() {
					return numeroLogradouro;
				}

				/**
				 * Define o valor da propriedade numeroLogradouro.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setNumeroLogradouro(String value) {
					this.numeroLogradouro = value;
				}

				/**
				 * Obt�m o valor da propriedade numeroLongitudeDecimal.
				 * 
				 * @return possible object is {@link BigDecimal }
				 * 
				 */
				public BigDecimal getNumeroLongitudeDecimal() {
					return numeroLongitudeDecimal;
				}

				/**
				 * Define o valor da propriedade numeroLongitudeDecimal.
				 * 
				 * @param value allowed object is {@link BigDecimal }
				 * 
				 */
				public void setNumeroLongitudeDecimal(BigDecimal value) {
					this.numeroLongitudeDecimal = value;
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
				 * Obt�m o valor da propriedade percentualConfiancaEndereco.
				 * 
				 * @return possible object is {@link BigDecimal }
				 * 
				 */
				public BigDecimal getPercentualConfiancaEndereco() {
					return percentualConfiancaEndereco;
				}

				/**
				 * Define o valor da propriedade percentualConfiancaEndereco.
				 * 
				 * @param value allowed object is {@link BigDecimal }
				 * 
				 */
				public void setPercentualConfiancaEndereco(BigDecimal value) {
					this.percentualConfiancaEndereco = value;
				}

				/**
				 * Obt�m o valor da propriedade siglaPais.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getSiglaPais() {
					return siglaPais;
				}

				/**
				 * Define o valor da propriedade siglaPais.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setSiglaPais(String value) {
					this.siglaPais = value;
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
			 *         &lt;element name="codigoFinalidadeEndereco" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
			 *         &lt;element name="descricaoFinalidadeEndereco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *         &lt;element name="codigoOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
			 *         &lt;element name="dataAtualizacaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
			 *         &lt;element name="dataAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
			 *         &lt;element name="enderecoEletronico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *         &lt;element name="flagAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *         &lt;element name="nomeOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *         &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
			@XmlType(name = "", propOrder = { "codigoFinalidadeEndereco", "descricaoFinalidadeEndereco",
					"codigoOrigemMovimento", "dataAtualizacaoRegistro", "dataAutorizacaoPropaganda",
					"enderecoEletronico", "flagAutorizacaoPropaganda", "nomeOrigemMovimento", "numeroContrato",
					"numeroSequencia" })
			public static class EnderecosEletronicosContrato implements Serializable {

				protected Short codigoFinalidadeEndereco;
				protected String descricaoFinalidadeEndereco;
				protected Short codigoOrigemMovimento;
				@XmlSchemaType(name = "dateTime")
				protected XMLGregorianCalendar dataAtualizacaoRegistro;
				@XmlSchemaType(name = "dateTime")
				protected XMLGregorianCalendar dataAutorizacaoPropaganda;
				protected String enderecoEletronico;
				protected String flagAutorizacaoPropaganda;
				protected String nomeOrigemMovimento;
				protected String numeroContrato;
				protected Short numeroSequencia;

				/**
				 * Obt�m o valor da propriedade codigoFinalidadeEndereco.
				 * 
				 * @return possible object is {@link Short }
				 * 
				 */
				public Short getCodigoFinalidadeEndereco() {
					return codigoFinalidadeEndereco;
				}

				/**
				 * Define o valor da propriedade codigoFinalidadeEndereco.
				 * 
				 * @param value allowed object is {@link Short }
				 * 
				 */
				public void setCodigoFinalidadeEndereco(Short value) {
					this.codigoFinalidadeEndereco = value;
				}

				/**
				 * Obt�m o valor da propriedade descricaoFinalidadeEndereco.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getDescricaoFinalidadeEndereco() {
					return descricaoFinalidadeEndereco;
				}

				/**
				 * Define o valor da propriedade descricaoFinalidadeEndereco.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setDescricaoFinalidadeEndereco(String value) {
					this.descricaoFinalidadeEndereco = value;
				}

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
				 * Obt�m o valor da propriedade dataAutorizacaoPropaganda.
				 * 
				 * @return possible object is {@link XMLGregorianCalendar }
				 * 
				 */
				public XMLGregorianCalendar getDataAutorizacaoPropaganda() {
					return dataAutorizacaoPropaganda;
				}

				/**
				 * Define o valor da propriedade dataAutorizacaoPropaganda.
				 * 
				 * @param value allowed object is {@link XMLGregorianCalendar }
				 * 
				 */
				public void setDataAutorizacaoPropaganda(XMLGregorianCalendar value) {
					this.dataAutorizacaoPropaganda = value;
				}

				/**
				 * Obt�m o valor da propriedade enderecoEletronico.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getEnderecoEletronico() {
					return enderecoEletronico;
				}

				/**
				 * Define o valor da propriedade enderecoEletronico.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setEnderecoEletronico(String value) {
					this.enderecoEletronico = value;
				}

				/**
				 * Obt�m o valor da propriedade flagAutorizacaoPropaganda.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getFlagAutorizacaoPropaganda() {
					return flagAutorizacaoPropaganda;
				}

				/**
				 * Define o valor da propriedade flagAutorizacaoPropaganda.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setFlagAutorizacaoPropaganda(String value) {
					this.flagAutorizacaoPropaganda = value;
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
			 *         &lt;element name="codigoEndosso" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
			 *         &lt;element name="codigoFormaPagamento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
			 *         &lt;element name="codigoOrigemProposta" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
			 *         &lt;element name="codigoTipoAlteracaoItem" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
			 *         &lt;element name="codigoValorRecebido" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
			 *         &lt;element name="descricaoValorRecebido" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *         &lt;element name="dataEmissao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
			 *         &lt;element name="dataFinalVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
			 *         &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
			 *         &lt;element name="codigoSituacaoItem" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
			 *         &lt;element name="nomeSituacaoItem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *         &lt;element name="dataInclusaoRegistroSituacaoItem" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
			 *         &lt;element name="localRisco" minOccurs="0">
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
			 *                   &lt;element name="nomeBairro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *                   &lt;element name="nomeCidade" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *                   &lt;element name="nomeLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *                   &lt;element name="nomeTipoLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *                   &lt;element name="numeroComplementoCep" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
			 *                   &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *                   &lt;element name="numeroInicioCep" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
			 *                   &lt;element name="numeroItem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
			 *                   &lt;element name="numeroLatitudeDecimal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
			 *                   &lt;element name="numeroLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *                   &lt;element name="numeroLongitudeDecimal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
			 *                   &lt;element name="numeroSequenciaDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *                   &lt;element name="siglaPais" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *                 &lt;/sequence>
			 *               &lt;/restriction>
			 *             &lt;/complexContent>
			 *           &lt;/complexType>
			 *         &lt;/element>
			 *         &lt;element name="nomeFormaPagamento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *         &lt;element name="nomeTipoAlteracaoItem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *         &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *         &lt;element name="numeroDigitoEndosso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *         &lt;element name="numeroDigitoProposta" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
			 *         &lt;element name="numeroItem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
			 *         &lt;element name="numeroItemSistemaOrigem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
			 *         &lt;element name="numeroRenovacaoSimplificada" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
			 *         &lt;element name="numeroSequenciaDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
			 *         &lt;element name="objeto" minOccurs="0">
			 *           &lt;complexType>
			 *             &lt;complexContent>
			 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
			 *                 &lt;sequence>
			 *                   &lt;element name="codigoObjeto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *                   &lt;element name="codigoTipoObjeto" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
			 *                   &lt;element name="nomeTipoObjeto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *                   &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *                   &lt;element name="numeroItem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
			 *                   &lt;element name="numeroSequenciaDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
			 *                 &lt;/sequence>
			 *               &lt;/restriction>
			 *             &lt;/complexContent>
			 *           &lt;/complexType>
			 *         &lt;/element>
			 *         &lt;element name="ordemRenovacaoSimplificada" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
			 *         &lt;element name="sinistros" maxOccurs="unbounded" minOccurs="0">
			 *           &lt;complexType>
			 *             &lt;complexContent>
			 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
			 *                 &lt;sequence>
			 *                   &lt;element name="codigoTipoPerda" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
			 *                   &lt;element name="dataAvisoSinistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
			 *                   &lt;element name="nomeTipoPerda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *                   &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *                   &lt;element name="numeroItem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
			 *                   &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
			 *                   &lt;element name="numeroSequenciaDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
			 *                   &lt;element name="numeroSinistroOrigem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *                 &lt;/sequence>
			 *               &lt;/restriction>
			 *             &lt;/complexContent>
			 *           &lt;/complexType>
			 *         &lt;/element>
			 *         &lt;element name="valorContrato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
			 *         &lt;element name="valorRecebimento" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
			 *         &lt;element name="valorTotalContrato" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
			 *         &lt;element name="veiculo" minOccurs="0">
			 *           &lt;complexType>
			 *             &lt;complexContent>
			 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
			 *                 &lt;sequence>
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
			 *       &lt;/sequence>
			 *     &lt;/restriction>
			 *   &lt;/complexContent>
			 * &lt;/complexType>
			 * </pre>
			 * 
			 * 
			 */
			@XmlAccessorType(XmlAccessType.FIELD)
			@XmlType(name = "", propOrder = { "codigoEndosso", "codigoFormaPagamento", "codigoOrigemProposta",
					"codigoTipoAlteracaoItem", "codigoValorRecebido", "descricaoValorRecebido", "dataEmissao",
					"dataFinalVigencia", "dataInicioVigencia", "codigoSituacaoItem", "nomeSituacaoItem",
					"dataInclusaoRegistroSituacaoItem", "localRisco", "nomeFormaPagamento", "nomeTipoAlteracaoItem",
					"numeroContrato", "numeroDigitoEndosso", "numeroDigitoProposta", "numeroItem",
					"numeroItemSistemaOrigem", "numeroRenovacaoSimplificada", "numeroSequenciaDocumento", "objeto",
					"ordemRenovacaoSimplificada", "sinistros", "valorContrato", "valorRecebimento",
					"valorTotalContrato", "veiculo" })
			public static class Itens implements Serializable {

				protected Short codigoEndosso;
				protected Short codigoFormaPagamento;
				protected Short codigoOrigemProposta;
				protected Short codigoTipoAlteracaoItem;
				protected Short codigoValorRecebido;
				protected String descricaoValorRecebido;
				@XmlSchemaType(name = "dateTime")
				protected XMLGregorianCalendar dataEmissao;
				@XmlSchemaType(name = "dateTime")
				protected XMLGregorianCalendar dataFinalVigencia;
				@XmlSchemaType(name = "dateTime")
				protected XMLGregorianCalendar dataInicioVigencia;
				protected Short codigoSituacaoItem;
				protected String nomeSituacaoItem;
				@XmlSchemaType(name = "dateTime")
				protected XMLGregorianCalendar dataInclusaoRegistroSituacaoItem;
				protected ObterContratoCompletoResponseType.Pessoa.Contratos.Itens.LocalRisco localRisco;
				protected String nomeFormaPagamento;
				protected String nomeTipoAlteracaoItem;
				protected String numeroContrato;
				protected String numeroDigitoEndosso;
				protected Long numeroDigitoProposta;
				protected Integer numeroItem;
				protected Integer numeroItemSistemaOrigem;
				protected Integer numeroRenovacaoSimplificada;
				protected Short numeroSequenciaDocumento;
				protected ObterContratoCompletoResponseType.Pessoa.Contratos.Itens.Objeto objeto;
				protected Short ordemRenovacaoSimplificada;
				protected List<ObterContratoCompletoResponseType.Pessoa.Contratos.Itens.Sinistros> sinistros;
				protected BigDecimal valorContrato;
				protected BigDecimal valorRecebimento;
				protected BigDecimal valorTotalContrato;
				protected ObterContratoCompletoResponseType.Pessoa.Contratos.Itens.Veiculo veiculo;

				/**
				 * Obt�m o valor da propriedade codigoEndosso.
				 * 
				 * @return possible object is {@link Short }
				 * 
				 */
				public Short getCodigoEndosso() {
					return codigoEndosso;
				}

				/**
				 * Define o valor da propriedade codigoEndosso.
				 * 
				 * @param value allowed object is {@link Short }
				 * 
				 */
				public void setCodigoEndosso(Short value) {
					this.codigoEndosso = value;
				}

				/**
				 * Obt�m o valor da propriedade codigoFormaPagamento.
				 * 
				 * @return possible object is {@link Short }
				 * 
				 */
				public Short getCodigoFormaPagamento() {
					return codigoFormaPagamento;
				}

				/**
				 * Define o valor da propriedade codigoFormaPagamento.
				 * 
				 * @param value allowed object is {@link Short }
				 * 
				 */
				public void setCodigoFormaPagamento(Short value) {
					this.codigoFormaPagamento = value;
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
				 * Obt�m o valor da propriedade codigoTipoAlteracaoItem.
				 * 
				 * @return possible object is {@link Short }
				 * 
				 */
				public Short getCodigoTipoAlteracaoItem() {
					return codigoTipoAlteracaoItem;
				}

				/**
				 * Define o valor da propriedade codigoTipoAlteracaoItem.
				 * 
				 * @param value allowed object is {@link Short }
				 * 
				 */
				public void setCodigoTipoAlteracaoItem(Short value) {
					this.codigoTipoAlteracaoItem = value;
				}

				/**
				 * Obt�m o valor da propriedade codigoValorRecebido.
				 * 
				 * @return possible object is {@link Short }
				 * 
				 */
				public Short getCodigoValorRecebido() {
					return codigoValorRecebido;
				}

				/**
				 * Define o valor da propriedade codigoValorRecebido.
				 * 
				 * @param value allowed object is {@link Short }
				 * 
				 */
				public void setCodigoValorRecebido(Short value) {
					this.codigoValorRecebido = value;
				}

				/**
				 * Obt�m o valor da propriedade descricaoValorRecebido.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getDescricaoValorRecebido() {
					return descricaoValorRecebido;
				}

				/**
				 * Define o valor da propriedade descricaoValorRecebido.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setDescricaoValorRecebido(String value) {
					this.descricaoValorRecebido = value;
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
				 * Obt�m o valor da propriedade codigoSituacaoItem.
				 * 
				 * @return possible object is {@link Short }
				 * 
				 */
				public Short getCodigoSituacaoItem() {
					return codigoSituacaoItem;
				}

				/**
				 * Define o valor da propriedade codigoSituacaoItem.
				 * 
				 * @param value allowed object is {@link Short }
				 * 
				 */
				public void setCodigoSituacaoItem(Short value) {
					this.codigoSituacaoItem = value;
				}

				/**
				 * Obt�m o valor da propriedade nomeSituacaoItem.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getNomeSituacaoItem() {
					return nomeSituacaoItem;
				}

				/**
				 * Define o valor da propriedade nomeSituacaoItem.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setNomeSituacaoItem(String value) {
					this.nomeSituacaoItem = value;
				}

				/**
				 * Obt�m o valor da propriedade dataInclusaoRegistroSituacaoItem.
				 * 
				 * @return possible object is {@link XMLGregorianCalendar }
				 * 
				 */
				public XMLGregorianCalendar getDataInclusaoRegistroSituacaoItem() {
					return dataInclusaoRegistroSituacaoItem;
				}

				/**
				 * Define o valor da propriedade dataInclusaoRegistroSituacaoItem.
				 * 
				 * @param value allowed object is {@link XMLGregorianCalendar }
				 * 
				 */
				public void setDataInclusaoRegistroSituacaoItem(XMLGregorianCalendar value) {
					this.dataInclusaoRegistroSituacaoItem = value;
				}

				/**
				 * Obt�m o valor da propriedade localRisco.
				 * 
				 * @return possible object is
				 *         {@link ObterContratoCompletoResponseType.Pessoa.Contratos.Itens.LocalRisco }
				 * 
				 */
				public ObterContratoCompletoResponseType.Pessoa.Contratos.Itens.LocalRisco getLocalRisco() {
					return localRisco;
				}

				/**
				 * Define o valor da propriedade localRisco.
				 * 
				 * @param value allowed object is
				 *              {@link ObterContratoCompletoResponseType.Pessoa.Contratos.Itens.LocalRisco }
				 * 
				 */
				public void setLocalRisco(ObterContratoCompletoResponseType.Pessoa.Contratos.Itens.LocalRisco value) {
					this.localRisco = value;
				}

				/**
				 * Obt�m o valor da propriedade nomeFormaPagamento.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getNomeFormaPagamento() {
					return nomeFormaPagamento;
				}

				/**
				 * Define o valor da propriedade nomeFormaPagamento.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setNomeFormaPagamento(String value) {
					this.nomeFormaPagamento = value;
				}

				/**
				 * Obt�m o valor da propriedade nomeTipoAlteracaoItem.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getNomeTipoAlteracaoItem() {
					return nomeTipoAlteracaoItem;
				}

				/**
				 * Define o valor da propriedade nomeTipoAlteracaoItem.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setNomeTipoAlteracaoItem(String value) {
					this.nomeTipoAlteracaoItem = value;
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
				 * Obt�m o valor da propriedade numeroDigitoEndosso.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getNumeroDigitoEndosso() {
					return numeroDigitoEndosso;
				}

				/**
				 * Define o valor da propriedade numeroDigitoEndosso.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setNumeroDigitoEndosso(String value) {
					this.numeroDigitoEndosso = value;
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
				 * Obt�m o valor da propriedade numeroItem.
				 * 
				 * @return possible object is {@link Integer }
				 * 
				 */
				public Integer getNumeroItem() {
					return numeroItem;
				}

				/**
				 * Define o valor da propriedade numeroItem.
				 * 
				 * @param value allowed object is {@link Integer }
				 * 
				 */
				public void setNumeroItem(Integer value) {
					this.numeroItem = value;
				}

				/**
				 * Obt�m o valor da propriedade numeroItemSistemaOrigem.
				 * 
				 * @return possible object is {@link Integer }
				 * 
				 */
				public Integer getNumeroItemSistemaOrigem() {
					return numeroItemSistemaOrigem;
				}

				/**
				 * Define o valor da propriedade numeroItemSistemaOrigem.
				 * 
				 * @param value allowed object is {@link Integer }
				 * 
				 */
				public void setNumeroItemSistemaOrigem(Integer value) {
					this.numeroItemSistemaOrigem = value;
				}

				/**
				 * Obt�m o valor da propriedade numeroRenovacaoSimplificada.
				 * 
				 * @return possible object is {@link Integer }
				 * 
				 */
				public Integer getNumeroRenovacaoSimplificada() {
					return numeroRenovacaoSimplificada;
				}

				/**
				 * Define o valor da propriedade numeroRenovacaoSimplificada.
				 * 
				 * @param value allowed object is {@link Integer }
				 * 
				 */
				public void setNumeroRenovacaoSimplificada(Integer value) {
					this.numeroRenovacaoSimplificada = value;
				}

				/**
				 * Obt�m o valor da propriedade numeroSequenciaDocumento.
				 * 
				 * @return possible object is {@link Short }
				 * 
				 */
				public Short getNumeroSequenciaDocumento() {
					return numeroSequenciaDocumento;
				}

				/**
				 * Define o valor da propriedade numeroSequenciaDocumento.
				 * 
				 * @param value allowed object is {@link Short }
				 * 
				 */
				public void setNumeroSequenciaDocumento(Short value) {
					this.numeroSequenciaDocumento = value;
				}

				/**
				 * Obt�m o valor da propriedade objeto.
				 * 
				 * @return possible object is
				 *         {@link ObterContratoCompletoResponseType.Pessoa.Contratos.Itens.Objeto }
				 * 
				 */
				public ObterContratoCompletoResponseType.Pessoa.Contratos.Itens.Objeto getObjeto() {
					return objeto;
				}

				/**
				 * Define o valor da propriedade objeto.
				 * 
				 * @param value allowed object is
				 *              {@link ObterContratoCompletoResponseType.Pessoa.Contratos.Itens.Objeto }
				 * 
				 */
				public void setObjeto(ObterContratoCompletoResponseType.Pessoa.Contratos.Itens.Objeto value) {
					this.objeto = value;
				}

				/**
				 * Obt�m o valor da propriedade ordemRenovacaoSimplificada.
				 * 
				 * @return possible object is {@link Short }
				 * 
				 */
				public Short getOrdemRenovacaoSimplificada() {
					return ordemRenovacaoSimplificada;
				}

				/**
				 * Define o valor da propriedade ordemRenovacaoSimplificada.
				 * 
				 * @param value allowed object is {@link Short }
				 * 
				 */
				public void setOrdemRenovacaoSimplificada(Short value) {
					this.ordemRenovacaoSimplificada = value;
				}

				/**
				 * Gets the value of the sinistros property.
				 * 
				 * <p>
				 * This accessor method returns a reference to the live list, not a snapshot.
				 * Therefore any modification you make to the returned list will be present
				 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
				 * for the sinistros property.
				 * 
				 * <p>
				 * For example, to add a new item, do as follows:
				 * 
				 * <pre>
				 * getSinistros().add(newItem);
				 * </pre>
				 * 
				 * 
				 * <p>
				 * Objects of the following type(s) are allowed in the list
				 * {@link ObterContratoCompletoResponseType.Pessoa.Contratos.Itens.Sinistros }
				 * 
				 * 
				 */
				public List<ObterContratoCompletoResponseType.Pessoa.Contratos.Itens.Sinistros> getSinistros() {
					if (sinistros == null) {
						sinistros = new ArrayList<ObterContratoCompletoResponseType.Pessoa.Contratos.Itens.Sinistros>();
					}
					return this.sinistros;
				}

				/**
				 * Obt�m o valor da propriedade valorContrato.
				 * 
				 * @return possible object is {@link BigDecimal }
				 * 
				 */
				public BigDecimal getValorContrato() {
					return valorContrato;
				}

				/**
				 * Define o valor da propriedade valorContrato.
				 * 
				 * @param value allowed object is {@link BigDecimal }
				 * 
				 */
				public void setValorContrato(BigDecimal value) {
					this.valorContrato = value;
				}

				/**
				 * Obt�m o valor da propriedade valorRecebimento.
				 * 
				 * @return possible object is {@link BigDecimal }
				 * 
				 */
				public BigDecimal getValorRecebimento() {
					return valorRecebimento;
				}

				/**
				 * Define o valor da propriedade valorRecebimento.
				 * 
				 * @param value allowed object is {@link BigDecimal }
				 * 
				 */
				public void setValorRecebimento(BigDecimal value) {
					this.valorRecebimento = value;
				}

				/**
				 * Obt�m o valor da propriedade valorTotalContrato.
				 * 
				 * @return possible object is {@link BigDecimal }
				 * 
				 */
				public BigDecimal getValorTotalContrato() {
					return valorTotalContrato;
				}

				/**
				 * Define o valor da propriedade valorTotalContrato.
				 * 
				 * @param value allowed object is {@link BigDecimal }
				 * 
				 */
				public void setValorTotalContrato(BigDecimal value) {
					this.valorTotalContrato = value;
				}

				/**
				 * Obt�m o valor da propriedade veiculo.
				 * 
				 * @return possible object is
				 *         {@link ObterContratoCompletoResponseType.Pessoa.Contratos.Itens.Veiculo }
				 * 
				 */
				public ObterContratoCompletoResponseType.Pessoa.Contratos.Itens.Veiculo getVeiculo() {
					return veiculo;
				}

				/**
				 * Define o valor da propriedade veiculo.
				 * 
				 * @param value allowed object is
				 *              {@link ObterContratoCompletoResponseType.Pessoa.Contratos.Itens.Veiculo }
				 * 
				 */
				public void setVeiculo(ObterContratoCompletoResponseType.Pessoa.Contratos.Itens.Veiculo value) {
					this.veiculo = value;
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
				 *         &lt;element name="codigoFinalidadeEndereco" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
				 *         &lt;element name="descricaoFinalidadeEndereco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
				 *         &lt;element name="codigoOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
				 *         &lt;element name="codigoUnidadeFederacao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
				 *         &lt;element name="complementoEndereco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
				 *         &lt;element name="dataAtualizacaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
				 *         &lt;element name="nomeBairro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
				 *         &lt;element name="nomeCidade" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
				 *         &lt;element name="nomeLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
				 *         &lt;element name="nomeTipoLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
				 *         &lt;element name="numeroComplementoCep" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
				 *         &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
				 *         &lt;element name="numeroInicioCep" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
				 *         &lt;element name="numeroItem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
				 *         &lt;element name="numeroLatitudeDecimal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
				 *         &lt;element name="numeroLogradouro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
				 *         &lt;element name="numeroLongitudeDecimal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
				 *         &lt;element name="numeroSequenciaDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
				@XmlType(name = "", propOrder = { "codigoFinalidadeEndereco", "descricaoFinalidadeEndereco",
						"codigoOrigemMovimento", "codigoUnidadeFederacao", "complementoEndereco",
						"dataAtualizacaoRegistro", "nomeBairro", "nomeCidade", "nomeLogradouro", "nomeTipoLogradouro",
						"numeroComplementoCep", "numeroContrato", "numeroInicioCep", "numeroItem",
						"numeroLatitudeDecimal", "numeroLogradouro", "numeroLongitudeDecimal",
						"numeroSequenciaDocumento", "siglaPais" })
				public static class LocalRisco implements Serializable {

					protected Short codigoFinalidadeEndereco;
					protected String descricaoFinalidadeEndereco;
					protected Short codigoOrigemMovimento;
					protected String codigoUnidadeFederacao;
					protected String complementoEndereco;
					@XmlSchemaType(name = "dateTime")
					protected XMLGregorianCalendar dataAtualizacaoRegistro;
					protected String nomeBairro;
					protected String nomeCidade;
					protected String nomeLogradouro;
					protected String nomeTipoLogradouro;
					protected Short numeroComplementoCep;
					protected String numeroContrato;
					protected Integer numeroInicioCep;
					protected Integer numeroItem;
					protected BigDecimal numeroLatitudeDecimal;
					protected String numeroLogradouro;
					protected BigDecimal numeroLongitudeDecimal;
					protected String numeroSequenciaDocumento;
					protected String siglaPais;

					/**
					 * Obt�m o valor da propriedade codigoFinalidadeEndereco.
					 * 
					 * @return possible object is {@link Short }
					 * 
					 */
					public Short getCodigoFinalidadeEndereco() {
						return codigoFinalidadeEndereco;
					}

					/**
					 * Define o valor da propriedade codigoFinalidadeEndereco.
					 * 
					 * @param value allowed object is {@link Short }
					 * 
					 */
					public void setCodigoFinalidadeEndereco(Short value) {
						this.codigoFinalidadeEndereco = value;
					}

					/**
					 * Obt�m o valor da propriedade descricaoFinalidadeEndereco.
					 * 
					 * @return possible object is {@link String }
					 * 
					 */
					public String getDescricaoFinalidadeEndereco() {
						return descricaoFinalidadeEndereco;
					}

					/**
					 * Define o valor da propriedade descricaoFinalidadeEndereco.
					 * 
					 * @param value allowed object is {@link String }
					 * 
					 */
					public void setDescricaoFinalidadeEndereco(String value) {
						this.descricaoFinalidadeEndereco = value;
					}

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
					 * Obt�m o valor da propriedade codigoUnidadeFederacao.
					 * 
					 * @return possible object is {@link String }
					 * 
					 */
					public String getCodigoUnidadeFederacao() {
						return codigoUnidadeFederacao;
					}

					/**
					 * Define o valor da propriedade codigoUnidadeFederacao.
					 * 
					 * @param value allowed object is {@link String }
					 * 
					 */
					public void setCodigoUnidadeFederacao(String value) {
						this.codigoUnidadeFederacao = value;
					}

					/**
					 * Obt�m o valor da propriedade complementoEndereco.
					 * 
					 * @return possible object is {@link String }
					 * 
					 */
					public String getComplementoEndereco() {
						return complementoEndereco;
					}

					/**
					 * Define o valor da propriedade complementoEndereco.
					 * 
					 * @param value allowed object is {@link String }
					 * 
					 */
					public void setComplementoEndereco(String value) {
						this.complementoEndereco = value;
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
					 * Obt�m o valor da propriedade nomeBairro.
					 * 
					 * @return possible object is {@link String }
					 * 
					 */
					public String getNomeBairro() {
						return nomeBairro;
					}

					/**
					 * Define o valor da propriedade nomeBairro.
					 * 
					 * @param value allowed object is {@link String }
					 * 
					 */
					public void setNomeBairro(String value) {
						this.nomeBairro = value;
					}

					/**
					 * Obt�m o valor da propriedade nomeCidade.
					 * 
					 * @return possible object is {@link String }
					 * 
					 */
					public String getNomeCidade() {
						return nomeCidade;
					}

					/**
					 * Define o valor da propriedade nomeCidade.
					 * 
					 * @param value allowed object is {@link String }
					 * 
					 */
					public void setNomeCidade(String value) {
						this.nomeCidade = value;
					}

					/**
					 * Obt�m o valor da propriedade nomeLogradouro.
					 * 
					 * @return possible object is {@link String }
					 * 
					 */
					public String getNomeLogradouro() {
						return nomeLogradouro;
					}

					/**
					 * Define o valor da propriedade nomeLogradouro.
					 * 
					 * @param value allowed object is {@link String }
					 * 
					 */
					public void setNomeLogradouro(String value) {
						this.nomeLogradouro = value;
					}

					/**
					 * Obt�m o valor da propriedade nomeTipoLogradouro.
					 * 
					 * @return possible object is {@link String }
					 * 
					 */
					public String getNomeTipoLogradouro() {
						return nomeTipoLogradouro;
					}

					/**
					 * Define o valor da propriedade nomeTipoLogradouro.
					 * 
					 * @param value allowed object is {@link String }
					 * 
					 */
					public void setNomeTipoLogradouro(String value) {
						this.nomeTipoLogradouro = value;
					}

					/**
					 * Obt�m o valor da propriedade numeroComplementoCep.
					 * 
					 * @return possible object is {@link Short }
					 * 
					 */
					public Short getNumeroComplementoCep() {
						return numeroComplementoCep;
					}

					/**
					 * Define o valor da propriedade numeroComplementoCep.
					 * 
					 * @param value allowed object is {@link Short }
					 * 
					 */
					public void setNumeroComplementoCep(Short value) {
						this.numeroComplementoCep = value;
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
					 * Obt�m o valor da propriedade numeroInicioCep.
					 * 
					 * @return possible object is {@link Integer }
					 * 
					 */
					public Integer getNumeroInicioCep() {
						return numeroInicioCep;
					}

					/**
					 * Define o valor da propriedade numeroInicioCep.
					 * 
					 * @param value allowed object is {@link Integer }
					 * 
					 */
					public void setNumeroInicioCep(Integer value) {
						this.numeroInicioCep = value;
					}

					/**
					 * Obt�m o valor da propriedade numeroItem.
					 * 
					 * @return possible object is {@link Integer }
					 * 
					 */
					public Integer getNumeroItem() {
						return numeroItem;
					}

					/**
					 * Define o valor da propriedade numeroItem.
					 * 
					 * @param value allowed object is {@link Integer }
					 * 
					 */
					public void setNumeroItem(Integer value) {
						this.numeroItem = value;
					}

					/**
					 * Obt�m o valor da propriedade numeroLatitudeDecimal.
					 * 
					 * @return possible object is {@link BigDecimal }
					 * 
					 */
					public BigDecimal getNumeroLatitudeDecimal() {
						return numeroLatitudeDecimal;
					}

					/**
					 * Define o valor da propriedade numeroLatitudeDecimal.
					 * 
					 * @param value allowed object is {@link BigDecimal }
					 * 
					 */
					public void setNumeroLatitudeDecimal(BigDecimal value) {
						this.numeroLatitudeDecimal = value;
					}

					/**
					 * Obt�m o valor da propriedade numeroLogradouro.
					 * 
					 * @return possible object is {@link String }
					 * 
					 */
					public String getNumeroLogradouro() {
						return numeroLogradouro;
					}

					/**
					 * Define o valor da propriedade numeroLogradouro.
					 * 
					 * @param value allowed object is {@link String }
					 * 
					 */
					public void setNumeroLogradouro(String value) {
						this.numeroLogradouro = value;
					}

					/**
					 * Obt�m o valor da propriedade numeroLongitudeDecimal.
					 * 
					 * @return possible object is {@link BigDecimal }
					 * 
					 */
					public BigDecimal getNumeroLongitudeDecimal() {
						return numeroLongitudeDecimal;
					}

					/**
					 * Define o valor da propriedade numeroLongitudeDecimal.
					 * 
					 * @param value allowed object is {@link BigDecimal }
					 * 
					 */
					public void setNumeroLongitudeDecimal(BigDecimal value) {
						this.numeroLongitudeDecimal = value;
					}

					/**
					 * Obt�m o valor da propriedade numeroSequenciaDocumento.
					 * 
					 * @return possible object is {@link String }
					 * 
					 */
					public String getNumeroSequenciaDocumento() {
						return numeroSequenciaDocumento;
					}

					/**
					 * Define o valor da propriedade numeroSequenciaDocumento.
					 * 
					 * @param value allowed object is {@link String }
					 * 
					 */
					public void setNumeroSequenciaDocumento(String value) {
						this.numeroSequenciaDocumento = value;
					}

					/**
					 * Obt�m o valor da propriedade siglaPais.
					 * 
					 * @return possible object is {@link String }
					 * 
					 */
					public String getSiglaPais() {
						return siglaPais;
					}

					/**
					 * Define o valor da propriedade siglaPais.
					 * 
					 * @param value allowed object is {@link String }
					 * 
					 */
					public void setSiglaPais(String value) {
						this.siglaPais = value;
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
				 *         &lt;element name="codigoObjeto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
				 *         &lt;element name="codigoTipoObjeto" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
				 *         &lt;element name="nomeTipoObjeto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
				 *         &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
				 *         &lt;element name="numeroItem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
				@XmlType(name = "", propOrder = { "codigoObjeto", "codigoTipoObjeto", "nomeTipoObjeto",
						"numeroContrato", "numeroItem", "numeroSequenciaDocumento" })
				public static class Objeto implements Serializable {

					protected String codigoObjeto;
					protected Short codigoTipoObjeto;
					protected String nomeTipoObjeto;
					protected String numeroContrato;
					protected Integer numeroItem;
					protected Short numeroSequenciaDocumento;

					/**
					 * Obt�m o valor da propriedade codigoObjeto.
					 * 
					 * @return possible object is {@link String }
					 * 
					 */
					public String getCodigoObjeto() {
						return codigoObjeto;
					}

					/**
					 * Define o valor da propriedade codigoObjeto.
					 * 
					 * @param value allowed object is {@link String }
					 * 
					 */
					public void setCodigoObjeto(String value) {
						this.codigoObjeto = value;
					}

					/**
					 * Obt�m o valor da propriedade codigoTipoObjeto.
					 * 
					 * @return possible object is {@link Short }
					 * 
					 */
					public Short getCodigoTipoObjeto() {
						return codigoTipoObjeto;
					}

					/**
					 * Define o valor da propriedade codigoTipoObjeto.
					 * 
					 * @param value allowed object is {@link Short }
					 * 
					 */
					public void setCodigoTipoObjeto(Short value) {
						this.codigoTipoObjeto = value;
					}

					/**
					 * Obt�m o valor da propriedade nomeTipoObjeto.
					 * 
					 * @return possible object is {@link String }
					 * 
					 */
					public String getNomeTipoObjeto() {
						return nomeTipoObjeto;
					}

					/**
					 * Define o valor da propriedade nomeTipoObjeto.
					 * 
					 * @param value allowed object is {@link String }
					 * 
					 */
					public void setNomeTipoObjeto(String value) {
						this.nomeTipoObjeto = value;
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
					 * Obt�m o valor da propriedade numeroItem.
					 * 
					 * @return possible object is {@link Integer }
					 * 
					 */
					public Integer getNumeroItem() {
						return numeroItem;
					}

					/**
					 * Define o valor da propriedade numeroItem.
					 * 
					 * @param value allowed object is {@link Integer }
					 * 
					 */
					public void setNumeroItem(Integer value) {
						this.numeroItem = value;
					}

					/**
					 * Obt�m o valor da propriedade numeroSequenciaDocumento.
					 * 
					 * @return possible object is {@link Short }
					 * 
					 */
					public Short getNumeroSequenciaDocumento() {
						return numeroSequenciaDocumento;
					}

					/**
					 * Define o valor da propriedade numeroSequenciaDocumento.
					 * 
					 * @param value allowed object is {@link Short }
					 * 
					 */
					public void setNumeroSequenciaDocumento(Short value) {
						this.numeroSequenciaDocumento = value;
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
				 *         &lt;element name="codigoTipoPerda" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
				 *         &lt;element name="dataAvisoSinistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
				 *         &lt;element name="nomeTipoPerda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
				 *         &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
				 *         &lt;element name="numeroItem" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
				 *         &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
				 *         &lt;element name="numeroSequenciaDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
				 *         &lt;element name="numeroSinistroOrigem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
				 *       &lt;/sequence>
				 *     &lt;/restriction>
				 *   &lt;/complexContent>
				 * &lt;/complexType>
				 * </pre>
				 * 
				 * 
				 */
				@XmlAccessorType(XmlAccessType.FIELD)
				@XmlType(name = "", propOrder = { "codigoTipoPerda", "dataAvisoSinistro", "nomeTipoPerda",
						"numeroContrato", "numeroItem", "numeroSequencia", "numeroSequenciaDocumento",
						"numeroSinistroOrigem" })
				public static class Sinistros implements Serializable {

					protected Short codigoTipoPerda;
					@XmlSchemaType(name = "dateTime")
					protected XMLGregorianCalendar dataAvisoSinistro;
					protected String nomeTipoPerda;
					protected String numeroContrato;
					protected Integer numeroItem;
					protected Short numeroSequencia;
					protected Short numeroSequenciaDocumento;
					protected String numeroSinistroOrigem;

					/**
					 * Obt�m o valor da propriedade codigoTipoPerda.
					 * 
					 * @return possible object is {@link Short }
					 * 
					 */
					public Short getCodigoTipoPerda() {
						return codigoTipoPerda;
					}

					/**
					 * Define o valor da propriedade codigoTipoPerda.
					 * 
					 * @param value allowed object is {@link Short }
					 * 
					 */
					public void setCodigoTipoPerda(Short value) {
						this.codigoTipoPerda = value;
					}

					/**
					 * Obt�m o valor da propriedade dataAvisoSinistro.
					 * 
					 * @return possible object is {@link XMLGregorianCalendar }
					 * 
					 */
					public XMLGregorianCalendar getDataAvisoSinistro() {
						return dataAvisoSinistro;
					}

					/**
					 * Define o valor da propriedade dataAvisoSinistro.
					 * 
					 * @param value allowed object is {@link XMLGregorianCalendar }
					 * 
					 */
					public void setDataAvisoSinistro(XMLGregorianCalendar value) {
						this.dataAvisoSinistro = value;
					}

					/**
					 * Obt�m o valor da propriedade nomeTipoPerda.
					 * 
					 * @return possible object is {@link String }
					 * 
					 */
					public String getNomeTipoPerda() {
						return nomeTipoPerda;
					}

					/**
					 * Define o valor da propriedade nomeTipoPerda.
					 * 
					 * @param value allowed object is {@link String }
					 * 
					 */
					public void setNomeTipoPerda(String value) {
						this.nomeTipoPerda = value;
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
					 * Obt�m o valor da propriedade numeroItem.
					 * 
					 * @return possible object is {@link Integer }
					 * 
					 */
					public Integer getNumeroItem() {
						return numeroItem;
					}

					/**
					 * Define o valor da propriedade numeroItem.
					 * 
					 * @param value allowed object is {@link Integer }
					 * 
					 */
					public void setNumeroItem(Integer value) {
						this.numeroItem = value;
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
					 * Obt�m o valor da propriedade numeroSequenciaDocumento.
					 * 
					 * @return possible object is {@link Short }
					 * 
					 */
					public Short getNumeroSequenciaDocumento() {
						return numeroSequenciaDocumento;
					}

					/**
					 * Define o valor da propriedade numeroSequenciaDocumento.
					 * 
					 * @param value allowed object is {@link Short }
					 * 
					 */
					public void setNumeroSequenciaDocumento(Short value) {
						this.numeroSequenciaDocumento = value;
					}

					/**
					 * Obt�m o valor da propriedade numeroSinistroOrigem.
					 * 
					 * @return possible object is {@link String }
					 * 
					 */
					public String getNumeroSinistroOrigem() {
						return numeroSinistroOrigem;
					}

					/**
					 * Define o valor da propriedade numeroSinistroOrigem.
					 * 
					 * @param value allowed object is {@link String }
					 * 
					 */
					public void setNumeroSinistroOrigem(String value) {
						this.numeroSinistroOrigem = value;
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
				@XmlType(name = "", propOrder = { "anoFabricacaoVeiculo", "anoModeloVeiculo", "nomeMarcaVeiculo",
						"nomeModeloVeiculo", "nomeTipoVeiculo", "numeroChassiVeiculo", "numeroContrato", "numeroItem",
						"numeroLicencaVeiculo", "numeroSequenciaDocumento" })
				public static class Veiculo implements Serializable {

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
					 * Obt�m o valor da propriedade anoFabricacaoVeiculo.
					 * 
					 * @return possible object is {@link Short }
					 * 
					 */
					public Short getAnoFabricacaoVeiculo() {
						return anoFabricacaoVeiculo;
					}

					/**
					 * Define o valor da propriedade anoFabricacaoVeiculo.
					 * 
					 * @param value allowed object is {@link Short }
					 * 
					 */
					public void setAnoFabricacaoVeiculo(Short value) {
						this.anoFabricacaoVeiculo = value;
					}

					/**
					 * Obt�m o valor da propriedade anoModeloVeiculo.
					 * 
					 * @return possible object is {@link Short }
					 * 
					 */
					public Short getAnoModeloVeiculo() {
						return anoModeloVeiculo;
					}

					/**
					 * Define o valor da propriedade anoModeloVeiculo.
					 * 
					 * @param value allowed object is {@link Short }
					 * 
					 */
					public void setAnoModeloVeiculo(Short value) {
						this.anoModeloVeiculo = value;
					}

					/**
					 * Obt�m o valor da propriedade nomeMarcaVeiculo.
					 * 
					 * @return possible object is {@link String }
					 * 
					 */
					public String getNomeMarcaVeiculo() {
						return nomeMarcaVeiculo;
					}

					/**
					 * Define o valor da propriedade nomeMarcaVeiculo.
					 * 
					 * @param value allowed object is {@link String }
					 * 
					 */
					public void setNomeMarcaVeiculo(String value) {
						this.nomeMarcaVeiculo = value;
					}

					/**
					 * Obt�m o valor da propriedade nomeModeloVeiculo.
					 * 
					 * @return possible object is {@link String }
					 * 
					 */
					public String getNomeModeloVeiculo() {
						return nomeModeloVeiculo;
					}

					/**
					 * Define o valor da propriedade nomeModeloVeiculo.
					 * 
					 * @param value allowed object is {@link String }
					 * 
					 */
					public void setNomeModeloVeiculo(String value) {
						this.nomeModeloVeiculo = value;
					}

					/**
					 * Obt�m o valor da propriedade nomeTipoVeiculo.
					 * 
					 * @return possible object is {@link String }
					 * 
					 */
					public String getNomeTipoVeiculo() {
						return nomeTipoVeiculo;
					}

					/**
					 * Define o valor da propriedade nomeTipoVeiculo.
					 * 
					 * @param value allowed object is {@link String }
					 * 
					 */
					public void setNomeTipoVeiculo(String value) {
						this.nomeTipoVeiculo = value;
					}

					/**
					 * Obt�m o valor da propriedade numeroChassiVeiculo.
					 * 
					 * @return possible object is {@link String }
					 * 
					 */
					public String getNumeroChassiVeiculo() {
						return numeroChassiVeiculo;
					}

					/**
					 * Define o valor da propriedade numeroChassiVeiculo.
					 * 
					 * @param value allowed object is {@link String }
					 * 
					 */
					public void setNumeroChassiVeiculo(String value) {
						this.numeroChassiVeiculo = value;
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
					 * Obt�m o valor da propriedade numeroItem.
					 * 
					 * @return possible object is {@link Integer }
					 * 
					 */
					public Integer getNumeroItem() {
						return numeroItem;
					}

					/**
					 * Define o valor da propriedade numeroItem.
					 * 
					 * @param value allowed object is {@link Integer }
					 * 
					 */
					public void setNumeroItem(Integer value) {
						this.numeroItem = value;
					}

					/**
					 * Obt�m o valor da propriedade numeroLicencaVeiculo.
					 * 
					 * @return possible object is {@link String }
					 * 
					 */
					public String getNumeroLicencaVeiculo() {
						return numeroLicencaVeiculo;
					}

					/**
					 * Define o valor da propriedade numeroLicencaVeiculo.
					 * 
					 * @param value allowed object is {@link String }
					 * 
					 */
					public void setNumeroLicencaVeiculo(String value) {
						this.numeroLicencaVeiculo = value;
					}

					/**
					 * Obt�m o valor da propriedade numeroSequenciaDocumento.
					 * 
					 * @return possible object is {@link Short }
					 * 
					 */
					public Short getNumeroSequenciaDocumento() {
						return numeroSequenciaDocumento;
					}

					/**
					 * Define o valor da propriedade numeroSequenciaDocumento.
					 * 
					 * @param value allowed object is {@link Short }
					 * 
					 */
					public void setNumeroSequenciaDocumento(Short value) {
						this.numeroSequenciaDocumento = value;
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
			 *         &lt;element name="codigoPapelPessoa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
			 *         &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
			 *         &lt;element name="nomePapelPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
			@XmlType(name = "", propOrder = { "codigoPapelPessoa", "dataInicioVigencia", "nomePapelPessoa",
					"numeroContrato" })
			public static class PapelPessoaContrato implements Serializable {

				protected Short codigoPapelPessoa;
				@XmlSchemaType(name = "dateTime")
				protected XMLGregorianCalendar dataInicioVigencia;
				protected String nomePapelPessoa;
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
			 *         &lt;element name="codigoDdd" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
			 *         &lt;element name="codigoDdi" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
			 *         &lt;element name="codigoOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
			 *         &lt;element name="codigoTipoTelefone" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
			 *         &lt;element name="descricaoTipoTelefone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *         &lt;element name="dataAtualizacaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
			 *         &lt;element name="dataAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
			 *         &lt;element name="flagAutorizacaoPropaganda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *         &lt;element name="nomeOrigemMovimento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *         &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
			@XmlType(name = "", propOrder = { "codigoDdd", "codigoDdi", "codigoOrigemMovimento", "codigoTipoTelefone",
					"descricaoTipoTelefone", "dataAtualizacaoRegistro", "dataAutorizacaoPropaganda",
					"flagAutorizacaoPropaganda", "nomeOrigemMovimento", "numeroContrato", "numeroSequencia",
					"numeroTelefone" })
			public static class TelefonesContrato implements Serializable {

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
				protected String numeroContrato;
				protected Short numeroSequencia;
				protected Long numeroTelefone;

				/**
				 * Obt�m o valor da propriedade codigoDdd.
				 * 
				 * @return possible object is {@link Short }
				 * 
				 */
				public Short getCodigoDdd() {
					return codigoDdd;
				}

				/**
				 * Define o valor da propriedade codigoDdd.
				 * 
				 * @param value allowed object is {@link Short }
				 * 
				 */
				public void setCodigoDdd(Short value) {
					this.codigoDdd = value;
				}

				/**
				 * Obt�m o valor da propriedade codigoDdi.
				 * 
				 * @return possible object is {@link Short }
				 * 
				 */
				public Short getCodigoDdi() {
					return codigoDdi;
				}

				/**
				 * Define o valor da propriedade codigoDdi.
				 * 
				 * @param value allowed object is {@link Short }
				 * 
				 */
				public void setCodigoDdi(Short value) {
					this.codigoDdi = value;
				}

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
				 * Obt�m o valor da propriedade codigoTipoTelefone.
				 * 
				 * @return possible object is {@link Short }
				 * 
				 */
				public Short getCodigoTipoTelefone() {
					return codigoTipoTelefone;
				}

				/**
				 * Define o valor da propriedade codigoTipoTelefone.
				 * 
				 * @param value allowed object is {@link Short }
				 * 
				 */
				public void setCodigoTipoTelefone(Short value) {
					this.codigoTipoTelefone = value;
				}

				/**
				 * Obt�m o valor da propriedade descricaoTipoTelefone.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getDescricaoTipoTelefone() {
					return descricaoTipoTelefone;
				}

				/**
				 * Define o valor da propriedade descricaoTipoTelefone.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setDescricaoTipoTelefone(String value) {
					this.descricaoTipoTelefone = value;
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
				 * Obt�m o valor da propriedade dataAutorizacaoPropaganda.
				 * 
				 * @return possible object is {@link XMLGregorianCalendar }
				 * 
				 */
				public XMLGregorianCalendar getDataAutorizacaoPropaganda() {
					return dataAutorizacaoPropaganda;
				}

				/**
				 * Define o valor da propriedade dataAutorizacaoPropaganda.
				 * 
				 * @param value allowed object is {@link XMLGregorianCalendar }
				 * 
				 */
				public void setDataAutorizacaoPropaganda(XMLGregorianCalendar value) {
					this.dataAutorizacaoPropaganda = value;
				}

				/**
				 * Obt�m o valor da propriedade flagAutorizacaoPropaganda.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getFlagAutorizacaoPropaganda() {
					return flagAutorizacaoPropaganda;
				}

				/**
				 * Define o valor da propriedade flagAutorizacaoPropaganda.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setFlagAutorizacaoPropaganda(String value) {
					this.flagAutorizacaoPropaganda = value;
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
				 * Obt�m o valor da propriedade numeroTelefone.
				 * 
				 * @return possible object is {@link Long }
				 * 
				 */
				public Long getNumeroTelefone() {
					return numeroTelefone;
				}

				/**
				 * Define o valor da propriedade numeroTelefone.
				 * 
				 * @param value allowed object is {@link Long }
				 * 
				 */
				public void setNumeroTelefone(Long value) {
					this.numeroTelefone = value;
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
			 *                   &lt;element name="nomePessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *                   &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
			 *                   &lt;element name="siglaTipoDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *                 &lt;/sequence>
			 *               &lt;/restriction>
			 *             &lt;/complexContent>
			 *           &lt;/complexType>
			 *         &lt;/element>
			 *         &lt;element name="papelPessoaContrato" maxOccurs="unbounded" minOccurs="0">
			 *           &lt;complexType>
			 *             &lt;complexContent>
			 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
			 *                 &lt;sequence>
			 *                   &lt;element name="codigoPapelPessoa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
			 *                   &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
			 *                   &lt;element name="nomePapelPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *                   &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *                 &lt;/sequence>
			 *               &lt;/restriction>
			 *             &lt;/complexContent>
			 *           &lt;/complexType>
			 *         &lt;/element>
			 *         &lt;element name="tipoVinculoContrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *         &lt;element name="numeroContrato" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
			 *         &lt;element name="codigoProdutoBcp" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
			 *         &lt;element name="nomeProdutoBcp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
			 *         &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
			 *         &lt;element name="dataFinalVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
			 *         &lt;element name="dataEmissao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
			 *         &lt;element name="codigoOrigemProposta" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
			 *         &lt;element name="numeroDigitoProposta" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
			 *       &lt;/sequence>
			 *     &lt;/restriction>
			 *   &lt;/complexContent>
			 * &lt;/complexType>
			 * </pre>
			 * 
			 * 
			 */
			@XmlAccessorType(XmlAccessType.FIELD)
			@XmlType(name = "", propOrder = { "chaveDocumento", "documentos", "papelPessoaContrato",
					"tipoVinculoContrato", "numeroContrato", "codigoProdutoBcp", "nomeProdutoBcp", "dataInicioVigencia",
					"dataFinalVigencia", "dataEmissao", "codigoOrigemProposta", "numeroDigitoProposta" })
			public static class VinculosContrato implements Serializable {

				protected List<ObterContratoCompletoResponseType.Pessoa.Contratos.VinculosContrato.ChaveDocumento> chaveDocumento;
				protected List<ObterContratoCompletoResponseType.Pessoa.Contratos.VinculosContrato.Documentos> documentos;
				protected List<ObterContratoCompletoResponseType.Pessoa.Contratos.VinculosContrato.PapelPessoaContrato> papelPessoaContrato;
				protected String tipoVinculoContrato;
				protected Long numeroContrato;
				protected Short codigoProdutoBcp;
				protected String nomeProdutoBcp;
				@XmlSchemaType(name = "dateTime")
				protected XMLGregorianCalendar dataInicioVigencia;
				@XmlSchemaType(name = "dateTime")
				protected XMLGregorianCalendar dataFinalVigencia;
				@XmlSchemaType(name = "dateTime")
				protected XMLGregorianCalendar dataEmissao;
				protected Short codigoOrigemProposta;
				protected Long numeroDigitoProposta;

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
				 * {@link ObterContratoCompletoResponseType.Pessoa.Contratos.VinculosContrato.ChaveDocumento }
				 * 
				 * 
				 */
				public List<ObterContratoCompletoResponseType.Pessoa.Contratos.VinculosContrato.ChaveDocumento> getChaveDocumento() {
					if (chaveDocumento == null) {
						chaveDocumento = new ArrayList<ObterContratoCompletoResponseType.Pessoa.Contratos.VinculosContrato.ChaveDocumento>();
					}
					return this.chaveDocumento;
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
				 * {@link ObterContratoCompletoResponseType.Pessoa.Contratos.VinculosContrato.Documentos }
				 * 
				 * 
				 */
				public List<ObterContratoCompletoResponseType.Pessoa.Contratos.VinculosContrato.Documentos> getDocumentos() {
					if (documentos == null) {
						documentos = new ArrayList<ObterContratoCompletoResponseType.Pessoa.Contratos.VinculosContrato.Documentos>();
					}
					return this.documentos;
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
				 * {@link ObterContratoCompletoResponseType.Pessoa.Contratos.VinculosContrato.PapelPessoaContrato }
				 * 
				 * 
				 */
				public List<ObterContratoCompletoResponseType.Pessoa.Contratos.VinculosContrato.PapelPessoaContrato> getPapelPessoaContrato() {
					if (papelPessoaContrato == null) {
						papelPessoaContrato = new ArrayList<ObterContratoCompletoResponseType.Pessoa.Contratos.VinculosContrato.PapelPessoaContrato>();
					}
					return this.papelPessoaContrato;
				}

				/**
				 * Obt�m o valor da propriedade tipoVinculoContrato.
				 * 
				 * @return possible object is {@link String }
				 * 
				 */
				public String getTipoVinculoContrato() {
					return tipoVinculoContrato;
				}

				/**
				 * Define o valor da propriedade tipoVinculoContrato.
				 * 
				 * @param value allowed object is {@link String }
				 * 
				 */
				public void setTipoVinculoContrato(String value) {
					this.tipoVinculoContrato = value;
				}

				/**
				 * Obt�m o valor da propriedade numeroContrato.
				 * 
				 * @return possible object is {@link Long }
				 * 
				 */
				public Long getNumeroContrato() {
					return numeroContrato;
				}

				/**
				 * Define o valor da propriedade numeroContrato.
				 * 
				 * @param value allowed object is {@link Long }
				 * 
				 */
				public void setNumeroContrato(Long value) {
					this.numeroContrato = value;
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
				 *         &lt;element name="codigoTipoDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
				 *         &lt;element name="descricaoTipoDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
				 *         &lt;element name="digitoCpfouCnpj" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
				 *         &lt;element name="flagPessoaTitularDocumento" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
				 *         &lt;element name="descricaoPessoaTitularDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
				 *         &lt;element name="numeroCpfouCnpj" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
				 *         &lt;element name="numeroDocumento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
				 *         &lt;element name="numeroOrdemCnpj" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
				 *         &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
				 *         &lt;element name="nomePessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
						"flagPessoaTitularDocumento", "descricaoPessoaTitularDocumento", "numeroCpfouCnpj",
						"numeroDocumento", "numeroOrdemCnpj", "numeroPessoa", "nomePessoa", "numeroSequencia",
						"siglaTipoDocumento" })
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
					protected String nomePessoa;
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
				 *         &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
				 *         &lt;element name="nomePapelPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
				@XmlType(name = "", propOrder = { "codigoPapelPessoa", "dataInicioVigencia", "nomePapelPessoa",
						"numeroContrato" })
				public static class PapelPessoaContrato implements Serializable {

					protected Short codigoPapelPessoa;
					@XmlSchemaType(name = "dateTime")
					protected XMLGregorianCalendar dataInicioVigencia;
					protected String nomePapelPessoa;
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
