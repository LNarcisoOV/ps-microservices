
package com.porto.portocom.portal.cliente.v1.wsdl.bcp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java de ObterPessoasContratosCompletoResponseType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ObterPessoasContratosCompletoResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pessoa" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="acessosRestritos" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="codigoRestricaoAcessoPessoa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="dataExclusaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="dataInclusaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
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
 *                             &lt;element name="descricaoExposicaoPoliticaPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="codigoGrupoAgregacaoPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="codigoSexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="codigoSituacaoPessoa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="descricaoSituacaoPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="dataAtualizacaoGrupoAgregacao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="dataNascimento" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="deficienciasFisicas" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="codigoTipoDeficienciaFisica" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                       &lt;element name="dataInclusaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                                       &lt;element name="nomeTipoDeficienciaFisica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="flagPessoaDeficienciaFisica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="flagPessoaEstrangeira" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="codigoEstadoCivil" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="nomeEstadoCivil" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="dataInclusaoRegistroEstadoCivil" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="ocupacoes" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="numeroOcupacao" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                                       &lt;element name="nomeOcupacao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="dataInclusaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                                       &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="codigoFaixaRenda" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="descricaoFaixaRenda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="dataInclusaoRegistroFaixaRenda" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="nomeMae" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="nomePai" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="vinculosPep" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="codigoExposicaoPoliticaPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="descricaoExposicaoPoliticaPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="codigoGrauParentesco" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                                       &lt;element name="dataFinalVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                                       &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                                       &lt;element name="nomeGrauParentesco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="nomePessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="numeroCpf" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                                       &lt;element name="numeroOcupacao" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *                                       &lt;element name="nomeOcupacao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                                       &lt;element name="numeroPessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                                       &lt;element name="codigoTipoPessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="descricaoTipoPessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                                       &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
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
 *                   &lt;element name="flagCadastroPortalCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="juridica" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="codigoNaturezaJuridica" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="dataRegistroAbertura" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="dataInclusaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="codigoFaixaValorContabil" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="codigoTipoValorContabil" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="descricaoFaixaValorContabil" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
 *                   &lt;element name="terceiroCodigoFonetico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="vinculos" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="codigoExposicaoPoliticaPessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="descricaoExposicaoPoliticaPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="codigoGrauParentesco" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="codigoProdutoBcp" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="codigoTipoRelacionamentoPessoa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="dataFinalVigenciaContrato" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="dataInicioVigenciaContrato" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="nomeGrauParentesco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="nomePessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="nomeTipoRelacionamentoPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="numeroContratoSistemaOrigem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="numeroContratoVinculado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="numeroPessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *                             &lt;element name="codigoTipoPessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="descricaoTipoPessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="midiasSociais" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="codigoTipoSocial" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
 *                             &lt;element name="descricaoTipoSocial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="nomeSocial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="emailSocial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="celularSocial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="dataNascimentoSocial" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *                             &lt;element name="flagSocial" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
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
@XmlType(name = "ObterPessoasContratosCompletoResponseType", propOrder = {
    "pessoa"
})
public class ObterPessoasContratosCompletoResponseType {

    protected List<ObterPessoasContratosCompletoResponseType.Pessoa> pessoa;

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
     * {@link ObterPessoasContratosCompletoResponseType.Pessoa }
     * 
     * 
     */
    public List<ObterPessoasContratosCompletoResponseType.Pessoa> getPessoa() {
        if (pessoa == null) {
            pessoa = new ArrayList<ObterPessoasContratosCompletoResponseType.Pessoa>();
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
     *         &lt;element name="acessosRestritos" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="codigoRestricaoAcessoPessoa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="dataExclusaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                   &lt;element name="dataInclusaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                   &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
     *                   &lt;element name="descricaoExposicaoPoliticaPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="codigoGrupoAgregacaoPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="codigoSexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="codigoSituacaoPessoa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="descricaoSituacaoPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="dataAtualizacaoGrupoAgregacao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                   &lt;element name="dataNascimento" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                   &lt;element name="deficienciasFisicas" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="codigoTipoDeficienciaFisica" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                             &lt;element name="dataInclusaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                             &lt;element name="nomeTipoDeficienciaFisica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="flagPessoaDeficienciaFisica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="flagPessoaEstrangeira" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="codigoEstadoCivil" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="nomeEstadoCivil" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="dataInclusaoRegistroEstadoCivil" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                   &lt;element name="ocupacoes" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="numeroOcupacao" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *                             &lt;element name="nomeOcupacao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="dataInclusaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                             &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="codigoFaixaRenda" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="descricaoFaixaRenda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="dataInclusaoRegistroFaixaRenda" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                   &lt;element name="nomeMae" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="nomePai" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="vinculosPep" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="codigoExposicaoPoliticaPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="descricaoExposicaoPoliticaPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="codigoGrauParentesco" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                             &lt;element name="dataFinalVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                             &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                             &lt;element name="nomeGrauParentesco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="nomePessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="numeroCpf" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                             &lt;element name="numeroOcupacao" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
     *                             &lt;element name="nomeOcupacao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                             &lt;element name="numeroPessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                             &lt;element name="codigoTipoPessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="descricaoTipoPessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                             &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
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
     *         &lt;element name="flagCadastroPortalCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="juridica" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="codigoNaturezaJuridica" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="dataRegistroAbertura" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                   &lt;element name="dataInclusaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                   &lt;element name="codigoFaixaValorContabil" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="codigoTipoValorContabil" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="descricaoFaixaValorContabil" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
     *         &lt;element name="terceiroCodigoFonetico" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="vinculos" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="codigoExposicaoPoliticaPessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="descricaoExposicaoPoliticaPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="codigoGrauParentesco" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="codigoProdutoBcp" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="codigoTipoRelacionamentoPessoa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="dataFinalVigenciaContrato" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                   &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                   &lt;element name="dataInicioVigenciaContrato" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                   &lt;element name="nomeGrauParentesco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="nomePessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="nomeTipoRelacionamentoPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="numeroContratoSistemaOrigem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="numeroContratoVinculado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="numeroPessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
     *                   &lt;element name="codigoTipoPessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="descricaoTipoPessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="midiasSociais" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="codigoTipoSocial" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
     *                   &lt;element name="descricaoTipoSocial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="nomeSocial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="emailSocial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="celularSocial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="dataNascimentoSocial" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
     *                   &lt;element name="flagSocial" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
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
        "acessosRestritos",
        "codigoOrigemMovimento",
        "codigoTipoPessoa",
        "descricaoTipoPessoa",
        "contratos",
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
        "telefones",
        "terceiroCodigoFonetico",
        "vinculos",
        "midiasSociais"
    })
    public static class Pessoa {

        protected List<ObterPessoasContratosCompletoResponseType.Pessoa.AcessosRestritos> acessosRestritos;
        protected Short codigoOrigemMovimento;
        protected String codigoTipoPessoa;
        protected String descricaoTipoPessoa;
        protected List<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos> contratos;
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar dataAtualizacaoRegistro;
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar dataInclusaoRegistro;
        protected List<ObterPessoasContratosCompletoResponseType.Pessoa.Documentos> documentos;
        protected List<ObterPessoasContratosCompletoResponseType.Pessoa.Enderecos> enderecos;
        protected List<ObterPessoasContratosCompletoResponseType.Pessoa.EnderecosEletronicos> enderecosEletronicos;
        protected ObterPessoasContratosCompletoResponseType.Pessoa.Fisica fisica;
        protected String flagCadastroPortalCliente;
        protected ObterPessoasContratosCompletoResponseType.Pessoa.Juridica juridica;
        protected String nomeOrigemMovimento;
        protected String nomePessoa;
        protected String nomeTratamento;
        protected Long numeroPessoa;
        protected List<ObterPessoasContratosCompletoResponseType.Pessoa.PapeisPessoa> papeisPessoa;
        protected String primeiroCodigoFonetico;
        protected String segundoCodigoFonetico;
        protected List<ObterPessoasContratosCompletoResponseType.Pessoa.Telefones> telefones;
        protected String terceiroCodigoFonetico;
        protected List<ObterPessoasContratosCompletoResponseType.Pessoa.Vinculos> vinculos;
        protected List<ObterPessoasContratosCompletoResponseType.Pessoa.MidiasSociais> midiasSociais;

        /**
         * Gets the value of the acessosRestritos property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the acessosRestritos property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAcessosRestritos().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ObterPessoasContratosCompletoResponseType.Pessoa.AcessosRestritos }
         * 
         * 
         */
        public List<ObterPessoasContratosCompletoResponseType.Pessoa.AcessosRestritos> getAcessosRestritos() {
            if (acessosRestritos == null) {
                acessosRestritos = new ArrayList<ObterPessoasContratosCompletoResponseType.Pessoa.AcessosRestritos>();
            }
            return this.acessosRestritos;
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
         * {@link ObterPessoasContratosCompletoResponseType.Pessoa.Contratos }
         * 
         * 
         */
        public List<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos> getContratos() {
            if (contratos == null) {
                contratos = new ArrayList<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos>();
            }
            return this.contratos;
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
         * {@link ObterPessoasContratosCompletoResponseType.Pessoa.Documentos }
         * 
         * 
         */
        public List<ObterPessoasContratosCompletoResponseType.Pessoa.Documentos> getDocumentos() {
            if (documentos == null) {
                documentos = new ArrayList<ObterPessoasContratosCompletoResponseType.Pessoa.Documentos>();
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
         * {@link ObterPessoasContratosCompletoResponseType.Pessoa.Enderecos }
         * 
         * 
         */
        public List<ObterPessoasContratosCompletoResponseType.Pessoa.Enderecos> getEnderecos() {
            if (enderecos == null) {
                enderecos = new ArrayList<ObterPessoasContratosCompletoResponseType.Pessoa.Enderecos>();
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
         * {@link ObterPessoasContratosCompletoResponseType.Pessoa.EnderecosEletronicos }
         * 
         * 
         */
        public List<ObterPessoasContratosCompletoResponseType.Pessoa.EnderecosEletronicos> getEnderecosEletronicos() {
            if (enderecosEletronicos == null) {
                enderecosEletronicos = new ArrayList<ObterPessoasContratosCompletoResponseType.Pessoa.EnderecosEletronicos>();
            }
            return this.enderecosEletronicos;
        }

        /**
         * Obt�m o valor da propriedade fisica.
         * 
         * @return
         *     possible object is
         *     {@link ObterPessoasContratosCompletoResponseType.Pessoa.Fisica }
         *     
         */
        public ObterPessoasContratosCompletoResponseType.Pessoa.Fisica getFisica() {
            return fisica;
        }

        /**
         * Define o valor da propriedade fisica.
         * 
         * @param value
         *     allowed object is
         *     {@link ObterPessoasContratosCompletoResponseType.Pessoa.Fisica }
         *     
         */
        public void setFisica(ObterPessoasContratosCompletoResponseType.Pessoa.Fisica value) {
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
         *     {@link ObterPessoasContratosCompletoResponseType.Pessoa.Juridica }
         *     
         */
        public ObterPessoasContratosCompletoResponseType.Pessoa.Juridica getJuridica() {
            return juridica;
        }

        /**
         * Define o valor da propriedade juridica.
         * 
         * @param value
         *     allowed object is
         *     {@link ObterPessoasContratosCompletoResponseType.Pessoa.Juridica }
         *     
         */
        public void setJuridica(ObterPessoasContratosCompletoResponseType.Pessoa.Juridica value) {
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
         * {@link ObterPessoasContratosCompletoResponseType.Pessoa.PapeisPessoa }
         * 
         * 
         */
        public List<ObterPessoasContratosCompletoResponseType.Pessoa.PapeisPessoa> getPapeisPessoa() {
            if (papeisPessoa == null) {
                papeisPessoa = new ArrayList<ObterPessoasContratosCompletoResponseType.Pessoa.PapeisPessoa>();
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
         * {@link ObterPessoasContratosCompletoResponseType.Pessoa.Telefones }
         * 
         * 
         */
        public List<ObterPessoasContratosCompletoResponseType.Pessoa.Telefones> getTelefones() {
            if (telefones == null) {
                telefones = new ArrayList<ObterPessoasContratosCompletoResponseType.Pessoa.Telefones>();
            }
            return this.telefones;
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
         * Gets the value of the vinculos property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the vinculos property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getVinculos().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ObterPessoasContratosCompletoResponseType.Pessoa.Vinculos }
         * 
         * 
         */
        public List<ObterPessoasContratosCompletoResponseType.Pessoa.Vinculos> getVinculos() {
            if (vinculos == null) {
                vinculos = new ArrayList<ObterPessoasContratosCompletoResponseType.Pessoa.Vinculos>();
            }
            return this.vinculos;
        }

        /**
         * Gets the value of the midiasSociais property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the midiasSociais property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMidiasSociais().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ObterPessoasContratosCompletoResponseType.Pessoa.MidiasSociais }
         * 
         * 
         */
        public List<ObterPessoasContratosCompletoResponseType.Pessoa.MidiasSociais> getMidiasSociais() {
            if (midiasSociais == null) {
                midiasSociais = new ArrayList<ObterPessoasContratosCompletoResponseType.Pessoa.MidiasSociais>();
            }
            return this.midiasSociais;
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
         *         &lt;element name="codigoRestricaoAcessoPessoa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="dataExclusaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
         *         &lt;element name="dataInclusaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
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
            "codigoRestricaoAcessoPessoa",
            "dataExclusaoRegistro",
            "dataInclusaoRegistro",
            "numeroPessoa",
            "numeroSequencia"
        })
        public static class AcessosRestritos {

            protected Short codigoRestricaoAcessoPessoa;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dataExclusaoRegistro;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dataInclusaoRegistro;
            protected Long numeroPessoa;
            protected Short numeroSequencia;

            /**
             * Obt�m o valor da propriedade codigoRestricaoAcessoPessoa.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getCodigoRestricaoAcessoPessoa() {
                return codigoRestricaoAcessoPessoa;
            }

            /**
             * Define o valor da propriedade codigoRestricaoAcessoPessoa.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setCodigoRestricaoAcessoPessoa(Short value) {
                this.codigoRestricaoAcessoPessoa = value;
            }

            /**
             * Obt�m o valor da propriedade dataExclusaoRegistro.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getDataExclusaoRegistro() {
                return dataExclusaoRegistro;
            }

            /**
             * Define o valor da propriedade dataExclusaoRegistro.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setDataExclusaoRegistro(XMLGregorianCalendar value) {
                this.dataExclusaoRegistro = value;
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
        @XmlType(name = "", propOrder = {
            "codigoSusep",
            "chaveDocumento",
            "codigoCanalVenda",
            "codigoEmpresaQuemEmitiu",
            "codigoOrigemProposta",
            "codigoProdutoOrigem",
            "codigoProdutoBcp",
            "codigoSegmento",
            "nomeSegmento",
            "dataEmissao",
            "dataFinalVigencia",
            "dataInicioVigencia",
            "enderecosContrato",
            "enderecosEletronicosContrato",
            "codigoSituacaoContrato",
            "nomeSituacaoContrato",
            "dataAtualizacaoSituacaoContrato",
            "itens",
            "nomeCanalVenda",
            "nomeEmpresaQuemEmitiu",
            "nomeProdutoBcp",
            "numeroClienteSistemaOrigem",
            "numeroContrato",
            "numeroContratoSistemaOrigem",
            "numeroContratoVinculado",
            "numeroDigitoProposta",
            "numeroPessoa",
            "papelPessoaContrato",
            "telefonesContrato",
            "vinculosContrato"
        })
        public static class Contratos {

            protected String codigoSusep;
            protected List<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.ChaveDocumento> chaveDocumento;
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
            protected List<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.EnderecosContrato> enderecosContrato;
            protected List<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.EnderecosEletronicosContrato> enderecosEletronicosContrato;
            protected Short codigoSituacaoContrato;
            protected String nomeSituacaoContrato;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dataAtualizacaoSituacaoContrato;
            protected List<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.Itens> itens;
            protected String nomeCanalVenda;
            protected String nomeEmpresaQuemEmitiu;
            protected String nomeProdutoBcp;
            protected Long numeroClienteSistemaOrigem;
            protected String numeroContrato;
            protected String numeroContratoSistemaOrigem;
            protected String numeroContratoVinculado;
            protected Long numeroDigitoProposta;
            protected Long numeroPessoa;
            protected List<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.PapelPessoaContrato> papelPessoaContrato;
            protected List<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.TelefonesContrato> telefonesContrato;
            protected List<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.VinculosContrato> vinculosContrato;

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
             * {@link ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.ChaveDocumento }
             * 
             * 
             */
            public List<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.ChaveDocumento> getChaveDocumento() {
                if (chaveDocumento == null) {
                    chaveDocumento = new ArrayList<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.ChaveDocumento>();
                }
                return this.chaveDocumento;
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
             * Obt�m o valor da propriedade codigoProdutoOrigem.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getCodigoProdutoOrigem() {
                return codigoProdutoOrigem;
            }

            /**
             * Define o valor da propriedade codigoProdutoOrigem.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setCodigoProdutoOrigem(Short value) {
                this.codigoProdutoOrigem = value;
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
             * Obt�m o valor da propriedade codigoSegmento.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getCodigoSegmento() {
                return codigoSegmento;
            }

            /**
             * Define o valor da propriedade codigoSegmento.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setCodigoSegmento(Short value) {
                this.codigoSegmento = value;
            }

            /**
             * Obt�m o valor da propriedade nomeSegmento.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNomeSegmento() {
                return nomeSegmento;
            }

            /**
             * Define o valor da propriedade nomeSegmento.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNomeSegmento(String value) {
                this.nomeSegmento = value;
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
             * {@link ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.EnderecosContrato }
             * 
             * 
             */
            public List<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.EnderecosContrato> getEnderecosContrato() {
                if (enderecosContrato == null) {
                    enderecosContrato = new ArrayList<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.EnderecosContrato>();
                }
                return this.enderecosContrato;
            }

            /**
             * Gets the value of the enderecosEletronicosContrato property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the enderecosEletronicosContrato property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getEnderecosEletronicosContrato().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.EnderecosEletronicosContrato }
             * 
             * 
             */
            public List<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.EnderecosEletronicosContrato> getEnderecosEletronicosContrato() {
                if (enderecosEletronicosContrato == null) {
                    enderecosEletronicosContrato = new ArrayList<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.EnderecosEletronicosContrato>();
                }
                return this.enderecosEletronicosContrato;
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
             * Obt�m o valor da propriedade dataAtualizacaoSituacaoContrato.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getDataAtualizacaoSituacaoContrato() {
                return dataAtualizacaoSituacaoContrato;
            }

            /**
             * Define o valor da propriedade dataAtualizacaoSituacaoContrato.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setDataAtualizacaoSituacaoContrato(XMLGregorianCalendar value) {
                this.dataAtualizacaoSituacaoContrato = value;
            }

            /**
             * Gets the value of the itens property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the itens property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getItens().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.Itens }
             * 
             * 
             */
            public List<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.Itens> getItens() {
                if (itens == null) {
                    itens = new ArrayList<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.Itens>();
                }
                return this.itens;
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
             * Obt�m o valor da propriedade numeroClienteSistemaOrigem.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getNumeroClienteSistemaOrigem() {
                return numeroClienteSistemaOrigem;
            }

            /**
             * Define o valor da propriedade numeroClienteSistemaOrigem.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setNumeroClienteSistemaOrigem(Long value) {
                this.numeroClienteSistemaOrigem = value;
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
             * Obt�m o valor da propriedade numeroContratoVinculado.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNumeroContratoVinculado() {
                return numeroContratoVinculado;
            }

            /**
             * Define o valor da propriedade numeroContratoVinculado.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNumeroContratoVinculado(String value) {
                this.numeroContratoVinculado = value;
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
             * Gets the value of the papelPessoaContrato property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the papelPessoaContrato property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getPapelPessoaContrato().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.PapelPessoaContrato }
             * 
             * 
             */
            public List<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.PapelPessoaContrato> getPapelPessoaContrato() {
                if (papelPessoaContrato == null) {
                    papelPessoaContrato = new ArrayList<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.PapelPessoaContrato>();
                }
                return this.papelPessoaContrato;
            }

            /**
             * Gets the value of the telefonesContrato property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the telefonesContrato property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTelefonesContrato().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.TelefonesContrato }
             * 
             * 
             */
            public List<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.TelefonesContrato> getTelefonesContrato() {
                if (telefonesContrato == null) {
                    telefonesContrato = new ArrayList<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.TelefonesContrato>();
                }
                return this.telefonesContrato;
            }

            /**
             * Gets the value of the vinculosContrato property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the vinculosContrato property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getVinculosContrato().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.VinculosContrato }
             * 
             * 
             */
            public List<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.VinculosContrato> getVinculosContrato() {
                if (vinculosContrato == null) {
                    vinculosContrato = new ArrayList<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.VinculosContrato>();
                }
                return this.vinculosContrato;
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
            @XmlType(name = "", propOrder = {
                "codigoFinalidadeEndereco",
                "descricaoFinalidadeEndereco",
                "codigoOrigemMovimento",
                "dataAtualizacaoRegistro",
                "dataAutorizacaoPropaganda",
                "enderecoEletronico",
                "flagAutorizacaoPropaganda",
                "nomeOrigemMovimento",
                "numeroContrato",
                "numeroSequencia"
            })
            public static class EnderecosEletronicosContrato {

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
            @XmlType(name = "", propOrder = {
                "codigoEndosso",
                "codigoFormaPagamento",
                "codigoOrigemProposta",
                "codigoTipoAlteracaoItem",
                "codigoValorRecebido",
                "descricaoValorRecebido",
                "dataEmissao",
                "dataFinalVigencia",
                "dataInicioVigencia",
                "codigoSituacaoItem",
                "nomeSituacaoItem",
                "dataInclusaoRegistroSituacaoItem",
                "localRisco",
                "nomeFormaPagamento",
                "nomeTipoAlteracaoItem",
                "numeroContrato",
                "numeroDigitoEndosso",
                "numeroDigitoProposta",
                "numeroItem",
                "numeroItemSistemaOrigem",
                "numeroRenovacaoSimplificada",
                "numeroSequenciaDocumento",
                "objeto",
                "ordemRenovacaoSimplificada",
                "sinistros",
                "valorContrato",
                "valorRecebimento",
                "valorTotalContrato",
                "veiculo"
            })
            public static class Itens {

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
                protected ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.Itens.LocalRisco localRisco;
                protected String nomeFormaPagamento;
                protected String nomeTipoAlteracaoItem;
                protected String numeroContrato;
                protected String numeroDigitoEndosso;
                protected Long numeroDigitoProposta;
                protected Integer numeroItem;
                protected Integer numeroItemSistemaOrigem;
                protected Integer numeroRenovacaoSimplificada;
                protected Short numeroSequenciaDocumento;
                protected ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.Itens.Objeto objeto;
                protected Short ordemRenovacaoSimplificada;
                protected List<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.Itens.Sinistros> sinistros;
                protected BigDecimal valorContrato;
                protected BigDecimal valorRecebimento;
                protected BigDecimal valorTotalContrato;
                protected ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.Itens.Veiculo veiculo;

                /**
                 * Obt�m o valor da propriedade codigoEndosso.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Short }
                 *     
                 */
                public Short getCodigoEndosso() {
                    return codigoEndosso;
                }

                /**
                 * Define o valor da propriedade codigoEndosso.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Short }
                 *     
                 */
                public void setCodigoEndosso(Short value) {
                    this.codigoEndosso = value;
                }

                /**
                 * Obt�m o valor da propriedade codigoFormaPagamento.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Short }
                 *     
                 */
                public Short getCodigoFormaPagamento() {
                    return codigoFormaPagamento;
                }

                /**
                 * Define o valor da propriedade codigoFormaPagamento.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Short }
                 *     
                 */
                public void setCodigoFormaPagamento(Short value) {
                    this.codigoFormaPagamento = value;
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
                 * Obt�m o valor da propriedade codigoTipoAlteracaoItem.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Short }
                 *     
                 */
                public Short getCodigoTipoAlteracaoItem() {
                    return codigoTipoAlteracaoItem;
                }

                /**
                 * Define o valor da propriedade codigoTipoAlteracaoItem.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Short }
                 *     
                 */
                public void setCodigoTipoAlteracaoItem(Short value) {
                    this.codigoTipoAlteracaoItem = value;
                }

                /**
                 * Obt�m o valor da propriedade codigoValorRecebido.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Short }
                 *     
                 */
                public Short getCodigoValorRecebido() {
                    return codigoValorRecebido;
                }

                /**
                 * Define o valor da propriedade codigoValorRecebido.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Short }
                 *     
                 */
                public void setCodigoValorRecebido(Short value) {
                    this.codigoValorRecebido = value;
                }

                /**
                 * Obt�m o valor da propriedade descricaoValorRecebido.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDescricaoValorRecebido() {
                    return descricaoValorRecebido;
                }

                /**
                 * Define o valor da propriedade descricaoValorRecebido.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDescricaoValorRecebido(String value) {
                    this.descricaoValorRecebido = value;
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
                 * Obt�m o valor da propriedade codigoSituacaoItem.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Short }
                 *     
                 */
                public Short getCodigoSituacaoItem() {
                    return codigoSituacaoItem;
                }

                /**
                 * Define o valor da propriedade codigoSituacaoItem.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Short }
                 *     
                 */
                public void setCodigoSituacaoItem(Short value) {
                    this.codigoSituacaoItem = value;
                }

                /**
                 * Obt�m o valor da propriedade nomeSituacaoItem.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getNomeSituacaoItem() {
                    return nomeSituacaoItem;
                }

                /**
                 * Define o valor da propriedade nomeSituacaoItem.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setNomeSituacaoItem(String value) {
                    this.nomeSituacaoItem = value;
                }

                /**
                 * Obt�m o valor da propriedade dataInclusaoRegistroSituacaoItem.
                 * 
                 * @return
                 *     possible object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public XMLGregorianCalendar getDataInclusaoRegistroSituacaoItem() {
                    return dataInclusaoRegistroSituacaoItem;
                }

                /**
                 * Define o valor da propriedade dataInclusaoRegistroSituacaoItem.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link XMLGregorianCalendar }
                 *     
                 */
                public void setDataInclusaoRegistroSituacaoItem(XMLGregorianCalendar value) {
                    this.dataInclusaoRegistroSituacaoItem = value;
                }

                /**
                 * Obt�m o valor da propriedade localRisco.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.Itens.LocalRisco }
                 *     
                 */
                public ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.Itens.LocalRisco getLocalRisco() {
                    return localRisco;
                }

                /**
                 * Define o valor da propriedade localRisco.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.Itens.LocalRisco }
                 *     
                 */
                public void setLocalRisco(ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.Itens.LocalRisco value) {
                    this.localRisco = value;
                }

                /**
                 * Obt�m o valor da propriedade nomeFormaPagamento.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getNomeFormaPagamento() {
                    return nomeFormaPagamento;
                }

                /**
                 * Define o valor da propriedade nomeFormaPagamento.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setNomeFormaPagamento(String value) {
                    this.nomeFormaPagamento = value;
                }

                /**
                 * Obt�m o valor da propriedade nomeTipoAlteracaoItem.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getNomeTipoAlteracaoItem() {
                    return nomeTipoAlteracaoItem;
                }

                /**
                 * Define o valor da propriedade nomeTipoAlteracaoItem.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setNomeTipoAlteracaoItem(String value) {
                    this.nomeTipoAlteracaoItem = value;
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
                 * Obt�m o valor da propriedade numeroRenovacaoSimplificada.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Integer }
                 *     
                 */
                public Integer getNumeroRenovacaoSimplificada() {
                    return numeroRenovacaoSimplificada;
                }

                /**
                 * Define o valor da propriedade numeroRenovacaoSimplificada.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Integer }
                 *     
                 */
                public void setNumeroRenovacaoSimplificada(Integer value) {
                    this.numeroRenovacaoSimplificada = value;
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

                /**
                 * Obt�m o valor da propriedade objeto.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.Itens.Objeto }
                 *     
                 */
                public ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.Itens.Objeto getObjeto() {
                    return objeto;
                }

                /**
                 * Define o valor da propriedade objeto.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.Itens.Objeto }
                 *     
                 */
                public void setObjeto(ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.Itens.Objeto value) {
                    this.objeto = value;
                }

                /**
                 * Obt�m o valor da propriedade ordemRenovacaoSimplificada.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Short }
                 *     
                 */
                public Short getOrdemRenovacaoSimplificada() {
                    return ordemRenovacaoSimplificada;
                }

                /**
                 * Define o valor da propriedade ordemRenovacaoSimplificada.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Short }
                 *     
                 */
                public void setOrdemRenovacaoSimplificada(Short value) {
                    this.ordemRenovacaoSimplificada = value;
                }

                /**
                 * Gets the value of the sinistros property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the sinistros property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getSinistros().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.Itens.Sinistros }
                 * 
                 * 
                 */
                public List<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.Itens.Sinistros> getSinistros() {
                    if (sinistros == null) {
                        sinistros = new ArrayList<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.Itens.Sinistros>();
                    }
                    return this.sinistros;
                }

                /**
                 * Obt�m o valor da propriedade valorContrato.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getValorContrato() {
                    return valorContrato;
                }

                /**
                 * Define o valor da propriedade valorContrato.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setValorContrato(BigDecimal value) {
                    this.valorContrato = value;
                }

                /**
                 * Obt�m o valor da propriedade valorRecebimento.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getValorRecebimento() {
                    return valorRecebimento;
                }

                /**
                 * Define o valor da propriedade valorRecebimento.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setValorRecebimento(BigDecimal value) {
                    this.valorRecebimento = value;
                }

                /**
                 * Obt�m o valor da propriedade valorTotalContrato.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                public BigDecimal getValorTotalContrato() {
                    return valorTotalContrato;
                }

                /**
                 * Define o valor da propriedade valorTotalContrato.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                public void setValorTotalContrato(BigDecimal value) {
                    this.valorTotalContrato = value;
                }

                /**
                 * Obt�m o valor da propriedade veiculo.
                 * 
                 * @return
                 *     possible object is
                 *     {@link ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.Itens.Veiculo }
                 *     
                 */
                public ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.Itens.Veiculo getVeiculo() {
                    return veiculo;
                }

                /**
                 * Define o valor da propriedade veiculo.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.Itens.Veiculo }
                 *     
                 */
                public void setVeiculo(ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.Itens.Veiculo value) {
                    this.veiculo = value;
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
                @XmlType(name = "", propOrder = {
                    "codigoFinalidadeEndereco",
                    "descricaoFinalidadeEndereco",
                    "codigoOrigemMovimento",
                    "codigoUnidadeFederacao",
                    "complementoEndereco",
                    "dataAtualizacaoRegistro",
                    "nomeBairro",
                    "nomeCidade",
                    "nomeLogradouro",
                    "nomeTipoLogradouro",
                    "numeroComplementoCep",
                    "numeroContrato",
                    "numeroInicioCep",
                    "numeroItem",
                    "numeroLatitudeDecimal",
                    "numeroLogradouro",
                    "numeroLongitudeDecimal",
                    "numeroSequenciaDocumento",
                    "siglaPais"
                })
                public static class LocalRisco {

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
                     * Obt�m o valor da propriedade numeroSequenciaDocumento.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getNumeroSequenciaDocumento() {
                        return numeroSequenciaDocumento;
                    }

                    /**
                     * Define o valor da propriedade numeroSequenciaDocumento.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setNumeroSequenciaDocumento(String value) {
                        this.numeroSequenciaDocumento = value;
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
                @XmlType(name = "", propOrder = {
                    "codigoObjeto",
                    "codigoTipoObjeto",
                    "nomeTipoObjeto",
                    "numeroContrato",
                    "numeroItem",
                    "numeroSequenciaDocumento"
                })
                public static class Objeto {

                    protected String codigoObjeto;
                    protected Short codigoTipoObjeto;
                    protected String nomeTipoObjeto;
                    protected String numeroContrato;
                    protected Integer numeroItem;
                    protected Short numeroSequenciaDocumento;

                    /**
                     * Obt�m o valor da propriedade codigoObjeto.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getCodigoObjeto() {
                        return codigoObjeto;
                    }

                    /**
                     * Define o valor da propriedade codigoObjeto.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setCodigoObjeto(String value) {
                        this.codigoObjeto = value;
                    }

                    /**
                     * Obt�m o valor da propriedade codigoTipoObjeto.
                     * 
                     * @return
                     *     possible object is
                     *     {@link Short }
                     *     
                     */
                    public Short getCodigoTipoObjeto() {
                        return codigoTipoObjeto;
                    }

                    /**
                     * Define o valor da propriedade codigoTipoObjeto.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Short }
                     *     
                     */
                    public void setCodigoTipoObjeto(Short value) {
                        this.codigoTipoObjeto = value;
                    }

                    /**
                     * Obt�m o valor da propriedade nomeTipoObjeto.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getNomeTipoObjeto() {
                        return nomeTipoObjeto;
                    }

                    /**
                     * Define o valor da propriedade nomeTipoObjeto.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setNomeTipoObjeto(String value) {
                        this.nomeTipoObjeto = value;
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
                @XmlType(name = "", propOrder = {
                    "codigoTipoPerda",
                    "dataAvisoSinistro",
                    "nomeTipoPerda",
                    "numeroContrato",
                    "numeroItem",
                    "numeroSequencia",
                    "numeroSequenciaDocumento",
                    "numeroSinistroOrigem"
                })
                public static class Sinistros {

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
                     * @return
                     *     possible object is
                     *     {@link Short }
                     *     
                     */
                    public Short getCodigoTipoPerda() {
                        return codigoTipoPerda;
                    }

                    /**
                     * Define o valor da propriedade codigoTipoPerda.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link Short }
                     *     
                     */
                    public void setCodigoTipoPerda(Short value) {
                        this.codigoTipoPerda = value;
                    }

                    /**
                     * Obt�m o valor da propriedade dataAvisoSinistro.
                     * 
                     * @return
                     *     possible object is
                     *     {@link XMLGregorianCalendar }
                     *     
                     */
                    public XMLGregorianCalendar getDataAvisoSinistro() {
                        return dataAvisoSinistro;
                    }

                    /**
                     * Define o valor da propriedade dataAvisoSinistro.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link XMLGregorianCalendar }
                     *     
                     */
                    public void setDataAvisoSinistro(XMLGregorianCalendar value) {
                        this.dataAvisoSinistro = value;
                    }

                    /**
                     * Obt�m o valor da propriedade nomeTipoPerda.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getNomeTipoPerda() {
                        return nomeTipoPerda;
                    }

                    /**
                     * Define o valor da propriedade nomeTipoPerda.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setNomeTipoPerda(String value) {
                        this.nomeTipoPerda = value;
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

                    /**
                     * Obt�m o valor da propriedade numeroSinistroOrigem.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getNumeroSinistroOrigem() {
                        return numeroSinistroOrigem;
                    }

                    /**
                     * Define o valor da propriedade numeroSinistroOrigem.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setNumeroSinistroOrigem(String value) {
                        this.numeroSinistroOrigem = value;
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
            @XmlType(name = "", propOrder = {
                "codigoPapelPessoa",
                "dataInicioVigencia",
                "nomePapelPessoa",
                "numeroContrato"
            })
            public static class PapelPessoaContrato {

                protected Short codigoPapelPessoa;
                @XmlSchemaType(name = "dateTime")
                protected XMLGregorianCalendar dataInicioVigencia;
                protected String nomePapelPessoa;
                protected String numeroContrato;

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
                "numeroContrato",
                "numeroSequencia",
                "numeroTelefone"
            })
            public static class TelefonesContrato {

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
            @XmlType(name = "", propOrder = {
                "chaveDocumento",
                "documentos",
                "papelPessoaContrato",
                "tipoVinculoContrato",
                "numeroContrato",
                "codigoProdutoBcp",
                "nomeProdutoBcp",
                "dataInicioVigencia",
                "dataFinalVigencia",
                "dataEmissao",
                "codigoOrigemProposta",
                "numeroDigitoProposta"
            })
            public static class VinculosContrato {

                protected List<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.VinculosContrato.ChaveDocumento> chaveDocumento;
                protected List<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.VinculosContrato.Documentos> documentos;
                protected List<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.VinculosContrato.PapelPessoaContrato> papelPessoaContrato;
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
                 * {@link ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.VinculosContrato.ChaveDocumento }
                 * 
                 * 
                 */
                public List<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.VinculosContrato.ChaveDocumento> getChaveDocumento() {
                    if (chaveDocumento == null) {
                        chaveDocumento = new ArrayList<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.VinculosContrato.ChaveDocumento>();
                    }
                    return this.chaveDocumento;
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
                 * {@link ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.VinculosContrato.Documentos }
                 * 
                 * 
                 */
                public List<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.VinculosContrato.Documentos> getDocumentos() {
                    if (documentos == null) {
                        documentos = new ArrayList<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.VinculosContrato.Documentos>();
                    }
                    return this.documentos;
                }

                /**
                 * Gets the value of the papelPessoaContrato property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the papelPessoaContrato property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getPapelPessoaContrato().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.VinculosContrato.PapelPessoaContrato }
                 * 
                 * 
                 */
                public List<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.VinculosContrato.PapelPessoaContrato> getPapelPessoaContrato() {
                    if (papelPessoaContrato == null) {
                        papelPessoaContrato = new ArrayList<ObterPessoasContratosCompletoResponseType.Pessoa.Contratos.VinculosContrato.PapelPessoaContrato>();
                    }
                    return this.papelPessoaContrato;
                }

                /**
                 * Obt�m o valor da propriedade tipoVinculoContrato.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getTipoVinculoContrato() {
                    return tipoVinculoContrato;
                }

                /**
                 * Define o valor da propriedade tipoVinculoContrato.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setTipoVinculoContrato(String value) {
                    this.tipoVinculoContrato = value;
                }

                /**
                 * Obt�m o valor da propriedade numeroContrato.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Long }
                 *     
                 */
                public Long getNumeroContrato() {
                    return numeroContrato;
                }

                /**
                 * Define o valor da propriedade numeroContrato.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Long }
                 *     
                 */
                public void setNumeroContrato(Long value) {
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
                    "nomePessoa",
                    "numeroSequencia",
                    "siglaTipoDocumento"
                })
                public static class Documentos {

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
                @XmlType(name = "", propOrder = {
                    "codigoPapelPessoa",
                    "dataInicioVigencia",
                    "nomePapelPessoa",
                    "numeroContrato"
                })
                public static class PapelPessoaContrato {

                    protected Short codigoPapelPessoa;
                    @XmlSchemaType(name = "dateTime")
                    protected XMLGregorianCalendar dataInicioVigencia;
                    protected String nomePapelPessoa;
                    protected String numeroContrato;

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

                }

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
        public static class Documentos {

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
        public static class Enderecos {

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
        public static class EnderecosEletronicos {

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
         *         &lt;element name="descricaoExposicaoPoliticaPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="codigoGrupoAgregacaoPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="codigoSexo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="codigoSituacaoPessoa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="descricaoSituacaoPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="dataAtualizacaoGrupoAgregacao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
         *         &lt;element name="dataNascimento" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
         *         &lt;element name="deficienciasFisicas" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="codigoTipoDeficienciaFisica" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *                   &lt;element name="dataInclusaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
         *                   &lt;element name="nomeTipoDeficienciaFisica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="flagPessoaDeficienciaFisica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="flagPessoaEstrangeira" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="codigoEstadoCivil" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="nomeEstadoCivil" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="dataInclusaoRegistroEstadoCivil" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
         *         &lt;element name="ocupacoes" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="numeroOcupacao" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
         *                   &lt;element name="nomeOcupacao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="dataInclusaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
         *                   &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="codigoFaixaRenda" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="descricaoFaixaRenda" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="dataInclusaoRegistroFaixaRenda" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
         *         &lt;element name="nomeMae" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="nomePai" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="vinculosPep" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="codigoExposicaoPoliticaPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="descricaoExposicaoPoliticaPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="codigoGrauParentesco" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *                   &lt;element name="dataFinalVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
         *                   &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
         *                   &lt;element name="nomeGrauParentesco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="nomePessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="numeroCpf" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *                   &lt;element name="numeroOcupacao" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
         *                   &lt;element name="nomeOcupacao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *                   &lt;element name="numeroPessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *                   &lt;element name="codigoTipoPessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *                   &lt;element name="descricaoTipoPessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        @XmlType(name = "", propOrder = {
            "codigoExposicaoPoliticaPessoa",
            "descricaoExposicaoPoliticaPessoa",
            "codigoGrupoAgregacaoPessoa",
            "codigoSexo",
            "codigoSituacaoPessoa",
            "descricaoSituacaoPessoa",
            "dataAtualizacaoGrupoAgregacao",
            "dataNascimento",
            "deficienciasFisicas",
            "flagPessoaDeficienciaFisica",
            "flagPessoaEstrangeira",
            "codigoEstadoCivil",
            "nomeEstadoCivil",
            "dataInclusaoRegistroEstadoCivil",
            "ocupacoes",
            "codigoFaixaRenda",
            "descricaoFaixaRenda",
            "dataInclusaoRegistroFaixaRenda",
            "nomeMae",
            "nomePai",
            "numeroPessoa",
            "vinculosPep"
        })
        public static class Fisica {

            protected Short codigoExposicaoPoliticaPessoa;
            protected String descricaoExposicaoPoliticaPessoa;
            protected Long codigoGrupoAgregacaoPessoa;
            protected String codigoSexo;
            protected Short codigoSituacaoPessoa;
            protected String descricaoSituacaoPessoa;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dataAtualizacaoGrupoAgregacao;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dataNascimento;
            protected List<ObterPessoasContratosCompletoResponseType.Pessoa.Fisica.DeficienciasFisicas> deficienciasFisicas;
            protected String flagPessoaDeficienciaFisica;
            protected String flagPessoaEstrangeira;
            protected Short codigoEstadoCivil;
            protected String nomeEstadoCivil;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dataInclusaoRegistroEstadoCivil;
            protected List<ObterPessoasContratosCompletoResponseType.Pessoa.Fisica.Ocupacoes> ocupacoes;
            protected Short codigoFaixaRenda;
            protected String descricaoFaixaRenda;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dataInclusaoRegistroFaixaRenda;
            protected String nomeMae;
            protected String nomePai;
            protected Long numeroPessoa;
            protected List<ObterPessoasContratosCompletoResponseType.Pessoa.Fisica.VinculosPep> vinculosPep;

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
             * Obt�m o valor da propriedade descricaoExposicaoPoliticaPessoa.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDescricaoExposicaoPoliticaPessoa() {
                return descricaoExposicaoPoliticaPessoa;
            }

            /**
             * Define o valor da propriedade descricaoExposicaoPoliticaPessoa.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDescricaoExposicaoPoliticaPessoa(String value) {
                this.descricaoExposicaoPoliticaPessoa = value;
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
             * Obt�m o valor da propriedade descricaoSituacaoPessoa.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDescricaoSituacaoPessoa() {
                return descricaoSituacaoPessoa;
            }

            /**
             * Define o valor da propriedade descricaoSituacaoPessoa.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDescricaoSituacaoPessoa(String value) {
                this.descricaoSituacaoPessoa = value;
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
             * Gets the value of the deficienciasFisicas property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the deficienciasFisicas property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getDeficienciasFisicas().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ObterPessoasContratosCompletoResponseType.Pessoa.Fisica.DeficienciasFisicas }
             * 
             * 
             */
            public List<ObterPessoasContratosCompletoResponseType.Pessoa.Fisica.DeficienciasFisicas> getDeficienciasFisicas() {
                if (deficienciasFisicas == null) {
                    deficienciasFisicas = new ArrayList<ObterPessoasContratosCompletoResponseType.Pessoa.Fisica.DeficienciasFisicas>();
                }
                return this.deficienciasFisicas;
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
             * Gets the value of the ocupacoes property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the ocupacoes property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getOcupacoes().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ObterPessoasContratosCompletoResponseType.Pessoa.Fisica.Ocupacoes }
             * 
             * 
             */
            public List<ObterPessoasContratosCompletoResponseType.Pessoa.Fisica.Ocupacoes> getOcupacoes() {
                if (ocupacoes == null) {
                    ocupacoes = new ArrayList<ObterPessoasContratosCompletoResponseType.Pessoa.Fisica.Ocupacoes>();
                }
                return this.ocupacoes;
            }

            /**
             * Obt�m o valor da propriedade codigoFaixaRenda.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getCodigoFaixaRenda() {
                return codigoFaixaRenda;
            }

            /**
             * Define o valor da propriedade codigoFaixaRenda.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setCodigoFaixaRenda(Short value) {
                this.codigoFaixaRenda = value;
            }

            /**
             * Obt�m o valor da propriedade descricaoFaixaRenda.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDescricaoFaixaRenda() {
                return descricaoFaixaRenda;
            }

            /**
             * Define o valor da propriedade descricaoFaixaRenda.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDescricaoFaixaRenda(String value) {
                this.descricaoFaixaRenda = value;
            }

            /**
             * Obt�m o valor da propriedade dataInclusaoRegistroFaixaRenda.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getDataInclusaoRegistroFaixaRenda() {
                return dataInclusaoRegistroFaixaRenda;
            }

            /**
             * Define o valor da propriedade dataInclusaoRegistroFaixaRenda.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setDataInclusaoRegistroFaixaRenda(XMLGregorianCalendar value) {
                this.dataInclusaoRegistroFaixaRenda = value;
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

            /**
             * Gets the value of the vinculosPep property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the vinculosPep property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getVinculosPep().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ObterPessoasContratosCompletoResponseType.Pessoa.Fisica.VinculosPep }
             * 
             * 
             */
            public List<ObterPessoasContratosCompletoResponseType.Pessoa.Fisica.VinculosPep> getVinculosPep() {
                if (vinculosPep == null) {
                    vinculosPep = new ArrayList<ObterPessoasContratosCompletoResponseType.Pessoa.Fisica.VinculosPep>();
                }
                return this.vinculosPep;
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
             *         &lt;element name="codigoTipoDeficienciaFisica" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
             *         &lt;element name="dataInclusaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
             *         &lt;element name="nomeTipoDeficienciaFisica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
                "codigoTipoDeficienciaFisica",
                "dataInclusaoRegistro",
                "nomeTipoDeficienciaFisica",
                "numeroPessoa"
            })
            public static class DeficienciasFisicas {

                protected Short codigoTipoDeficienciaFisica;
                @XmlSchemaType(name = "dateTime")
                protected XMLGregorianCalendar dataInclusaoRegistro;
                protected String nomeTipoDeficienciaFisica;
                protected Long numeroPessoa;

                /**
                 * Obt�m o valor da propriedade codigoTipoDeficienciaFisica.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Short }
                 *     
                 */
                public Short getCodigoTipoDeficienciaFisica() {
                    return codigoTipoDeficienciaFisica;
                }

                /**
                 * Define o valor da propriedade codigoTipoDeficienciaFisica.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Short }
                 *     
                 */
                public void setCodigoTipoDeficienciaFisica(Short value) {
                    this.codigoTipoDeficienciaFisica = value;
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
                 * Obt�m o valor da propriedade nomeTipoDeficienciaFisica.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getNomeTipoDeficienciaFisica() {
                    return nomeTipoDeficienciaFisica;
                }

                /**
                 * Define o valor da propriedade nomeTipoDeficienciaFisica.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setNomeTipoDeficienciaFisica(String value) {
                    this.nomeTipoDeficienciaFisica = value;
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
             *         &lt;element name="numeroOcupacao" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
             *         &lt;element name="nomeOcupacao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="dataInclusaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
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
                "numeroOcupacao",
                "nomeOcupacao",
                "dataInclusaoRegistro",
                "numeroPessoa"
            })
            public static class Ocupacoes {

                protected Integer numeroOcupacao;
                protected String nomeOcupacao;
                @XmlSchemaType(name = "dateTime")
                protected XMLGregorianCalendar dataInclusaoRegistro;
                protected Long numeroPessoa;

                /**
                 * Obt�m o valor da propriedade numeroOcupacao.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Integer }
                 *     
                 */
                public Integer getNumeroOcupacao() {
                    return numeroOcupacao;
                }

                /**
                 * Define o valor da propriedade numeroOcupacao.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Integer }
                 *     
                 */
                public void setNumeroOcupacao(Integer value) {
                    this.numeroOcupacao = value;
                }

                /**
                 * Obt�m o valor da propriedade nomeOcupacao.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getNomeOcupacao() {
                    return nomeOcupacao;
                }

                /**
                 * Define o valor da propriedade nomeOcupacao.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setNomeOcupacao(String value) {
                    this.nomeOcupacao = value;
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
             *         &lt;element name="codigoExposicaoPoliticaPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="descricaoExposicaoPoliticaPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="codigoGrauParentesco" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
             *         &lt;element name="dataFinalVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
             *         &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
             *         &lt;element name="nomeGrauParentesco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="nomePessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="numeroCpf" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
             *         &lt;element name="numeroOcupacao" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
             *         &lt;element name="nomeOcupacao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
             *         &lt;element name="numeroPessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
             *         &lt;element name="codigoTipoPessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
             *         &lt;element name="descricaoTipoPessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
                "codigoExposicaoPoliticaPessoa",
                "descricaoExposicaoPoliticaPessoa",
                "codigoGrauParentesco",
                "dataFinalVigencia",
                "dataInicioVigencia",
                "nomeGrauParentesco",
                "nomePessoa",
                "numeroCpf",
                "numeroOcupacao",
                "nomeOcupacao",
                "numeroPessoa",
                "numeroPessoaVinculada",
                "codigoTipoPessoaVinculada",
                "descricaoTipoPessoaVinculada",
                "numeroSequencia"
            })
            public static class VinculosPep {

                protected String codigoExposicaoPoliticaPessoa;
                protected String descricaoExposicaoPoliticaPessoa;
                protected Short codigoGrauParentesco;
                @XmlSchemaType(name = "dateTime")
                protected XMLGregorianCalendar dataFinalVigencia;
                @XmlSchemaType(name = "dateTime")
                protected XMLGregorianCalendar dataInicioVigencia;
                protected String nomeGrauParentesco;
                protected String nomePessoa;
                protected Long numeroCpf;
                protected Integer numeroOcupacao;
                protected String nomeOcupacao;
                protected Long numeroPessoa;
                protected Long numeroPessoaVinculada;
                protected String codigoTipoPessoaVinculada;
                protected String descricaoTipoPessoaVinculada;
                protected Short numeroSequencia;

                /**
                 * Obt�m o valor da propriedade codigoExposicaoPoliticaPessoa.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCodigoExposicaoPoliticaPessoa() {
                    return codigoExposicaoPoliticaPessoa;
                }

                /**
                 * Define o valor da propriedade codigoExposicaoPoliticaPessoa.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCodigoExposicaoPoliticaPessoa(String value) {
                    this.codigoExposicaoPoliticaPessoa = value;
                }

                /**
                 * Obt�m o valor da propriedade descricaoExposicaoPoliticaPessoa.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDescricaoExposicaoPoliticaPessoa() {
                    return descricaoExposicaoPoliticaPessoa;
                }

                /**
                 * Define o valor da propriedade descricaoExposicaoPoliticaPessoa.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDescricaoExposicaoPoliticaPessoa(String value) {
                    this.descricaoExposicaoPoliticaPessoa = value;
                }

                /**
                 * Obt�m o valor da propriedade codigoGrauParentesco.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Short }
                 *     
                 */
                public Short getCodigoGrauParentesco() {
                    return codigoGrauParentesco;
                }

                /**
                 * Define o valor da propriedade codigoGrauParentesco.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Short }
                 *     
                 */
                public void setCodigoGrauParentesco(Short value) {
                    this.codigoGrauParentesco = value;
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
                 * Obt�m o valor da propriedade nomeGrauParentesco.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getNomeGrauParentesco() {
                    return nomeGrauParentesco;
                }

                /**
                 * Define o valor da propriedade nomeGrauParentesco.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setNomeGrauParentesco(String value) {
                    this.nomeGrauParentesco = value;
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
                 * Obt�m o valor da propriedade numeroCpf.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Long }
                 *     
                 */
                public Long getNumeroCpf() {
                    return numeroCpf;
                }

                /**
                 * Define o valor da propriedade numeroCpf.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Long }
                 *     
                 */
                public void setNumeroCpf(Long value) {
                    this.numeroCpf = value;
                }

                /**
                 * Obt�m o valor da propriedade numeroOcupacao.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Integer }
                 *     
                 */
                public Integer getNumeroOcupacao() {
                    return numeroOcupacao;
                }

                /**
                 * Define o valor da propriedade numeroOcupacao.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Integer }
                 *     
                 */
                public void setNumeroOcupacao(Integer value) {
                    this.numeroOcupacao = value;
                }

                /**
                 * Obt�m o valor da propriedade nomeOcupacao.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getNomeOcupacao() {
                    return nomeOcupacao;
                }

                /**
                 * Define o valor da propriedade nomeOcupacao.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setNomeOcupacao(String value) {
                    this.nomeOcupacao = value;
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
                 * Obt�m o valor da propriedade numeroPessoaVinculada.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Long }
                 *     
                 */
                public Long getNumeroPessoaVinculada() {
                    return numeroPessoaVinculada;
                }

                /**
                 * Define o valor da propriedade numeroPessoaVinculada.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Long }
                 *     
                 */
                public void setNumeroPessoaVinculada(Long value) {
                    this.numeroPessoaVinculada = value;
                }

                /**
                 * Obt�m o valor da propriedade codigoTipoPessoaVinculada.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getCodigoTipoPessoaVinculada() {
                    return codigoTipoPessoaVinculada;
                }

                /**
                 * Define o valor da propriedade codigoTipoPessoaVinculada.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setCodigoTipoPessoaVinculada(String value) {
                    this.codigoTipoPessoaVinculada = value;
                }

                /**
                 * Obt�m o valor da propriedade descricaoTipoPessoaVinculada.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getDescricaoTipoPessoaVinculada() {
                    return descricaoTipoPessoaVinculada;
                }

                /**
                 * Define o valor da propriedade descricaoTipoPessoaVinculada.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setDescricaoTipoPessoaVinculada(String value) {
                    this.descricaoTipoPessoaVinculada = value;
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
         *         &lt;element name="dataInclusaoRegistro" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
         *         &lt;element name="codigoFaixaValorContabil" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="codigoTipoValorContabil" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="descricaoFaixaValorContabil" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "dataInclusaoRegistro",
            "codigoFaixaValorContabil",
            "codigoTipoValorContabil",
            "descricaoFaixaValorContabil",
            "nomeAtividadeCnae",
            "nomeNaturezaJuridica",
            "numeroCnae",
            "numeroPessoa"
        })
        public static class Juridica {

            protected Short codigoNaturezaJuridica;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dataRegistroAbertura;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dataInclusaoRegistro;
            protected Short codigoFaixaValorContabil;
            protected Short codigoTipoValorContabil;
            protected String descricaoFaixaValorContabil;
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
             * Obt�m o valor da propriedade codigoFaixaValorContabil.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getCodigoFaixaValorContabil() {
                return codigoFaixaValorContabil;
            }

            /**
             * Define o valor da propriedade codigoFaixaValorContabil.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setCodigoFaixaValorContabil(Short value) {
                this.codigoFaixaValorContabil = value;
            }

            /**
             * Obt�m o valor da propriedade codigoTipoValorContabil.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getCodigoTipoValorContabil() {
                return codigoTipoValorContabil;
            }

            /**
             * Define o valor da propriedade codigoTipoValorContabil.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setCodigoTipoValorContabil(Short value) {
                this.codigoTipoValorContabil = value;
            }

            /**
             * Obt�m o valor da propriedade descricaoFaixaValorContabil.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDescricaoFaixaValorContabil() {
                return descricaoFaixaValorContabil;
            }

            /**
             * Define o valor da propriedade descricaoFaixaValorContabil.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDescricaoFaixaValorContabil(String value) {
                this.descricaoFaixaValorContabil = value;
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
         *         &lt;element name="codigoTipoSocial" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="descricaoTipoSocial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="nomeSocial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="emailSocial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="celularSocial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="dataNascimentoSocial" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
         *         &lt;element name="flagSocial" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
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
            "codigoTipoSocial",
            "descricaoTipoSocial",
            "nomeSocial",
            "emailSocial",
            "celularSocial",
            "dataNascimentoSocial",
            "flagSocial"
        })
        public static class MidiasSociais {

            protected Short codigoTipoSocial;
            protected String descricaoTipoSocial;
            protected String nomeSocial;
            protected String emailSocial;
            protected String celularSocial;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dataNascimentoSocial;
            protected Short flagSocial;

            /**
             * Obt�m o valor da propriedade codigoTipoSocial.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getCodigoTipoSocial() {
                return codigoTipoSocial;
            }

            /**
             * Define o valor da propriedade codigoTipoSocial.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setCodigoTipoSocial(Short value) {
                this.codigoTipoSocial = value;
            }

            /**
             * Obt�m o valor da propriedade descricaoTipoSocial.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDescricaoTipoSocial() {
                return descricaoTipoSocial;
            }

            /**
             * Define o valor da propriedade descricaoTipoSocial.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDescricaoTipoSocial(String value) {
                this.descricaoTipoSocial = value;
            }

            /**
             * Obt�m o valor da propriedade nomeSocial.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNomeSocial() {
                return nomeSocial;
            }

            /**
             * Define o valor da propriedade nomeSocial.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNomeSocial(String value) {
                this.nomeSocial = value;
            }

            /**
             * Obt�m o valor da propriedade emailSocial.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getEmailSocial() {
                return emailSocial;
            }

            /**
             * Define o valor da propriedade emailSocial.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setEmailSocial(String value) {
                this.emailSocial = value;
            }

            /**
             * Obt�m o valor da propriedade celularSocial.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCelularSocial() {
                return celularSocial;
            }

            /**
             * Define o valor da propriedade celularSocial.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCelularSocial(String value) {
                this.celularSocial = value;
            }

            /**
             * Obt�m o valor da propriedade dataNascimentoSocial.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getDataNascimentoSocial() {
                return dataNascimentoSocial;
            }

            /**
             * Define o valor da propriedade dataNascimentoSocial.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setDataNascimentoSocial(XMLGregorianCalendar value) {
                this.dataNascimentoSocial = value;
            }

            /**
             * Obt�m o valor da propriedade flagSocial.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getFlagSocial() {
                return flagSocial;
            }

            /**
             * Define o valor da propriedade flagSocial.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setFlagSocial(Short value) {
                this.flagSocial = value;
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
        public static class PapeisPessoa {

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
         *         &lt;element name="codigoExposicaoPoliticaPessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="descricaoExposicaoPoliticaPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="codigoGrauParentesco" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="codigoProdutoBcp" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="codigoTipoRelacionamentoPessoa" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
         *         &lt;element name="dataFinalVigenciaContrato" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
         *         &lt;element name="dataInicioVigencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
         *         &lt;element name="dataInicioVigenciaContrato" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
         *         &lt;element name="nomeGrauParentesco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="nomePessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="nomeTipoRelacionamentoPessoa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="numeroContratoSistemaOrigem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="numeroContratoVinculado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="numeroPessoa" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="numeroPessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
         *         &lt;element name="codigoTipoPessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="descricaoTipoPessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "codigoExposicaoPoliticaPessoaVinculada",
            "descricaoExposicaoPoliticaPessoa",
            "codigoGrauParentesco",
            "codigoProdutoBcp",
            "codigoTipoRelacionamentoPessoa",
            "dataFinalVigenciaContrato",
            "dataInicioVigencia",
            "dataInicioVigenciaContrato",
            "nomeGrauParentesco",
            "nomePessoaVinculada",
            "nomeTipoRelacionamentoPessoa",
            "numeroContratoSistemaOrigem",
            "numeroContratoVinculado",
            "numeroPessoa",
            "numeroPessoaVinculada",
            "codigoTipoPessoaVinculada",
            "descricaoTipoPessoaVinculada",
            "numeroSequencia"
        })
        public static class Vinculos {

            protected String codigoExposicaoPoliticaPessoaVinculada;
            protected String descricaoExposicaoPoliticaPessoa;
            protected Short codigoGrauParentesco;
            protected Short codigoProdutoBcp;
            protected Short codigoTipoRelacionamentoPessoa;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dataFinalVigenciaContrato;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dataInicioVigencia;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dataInicioVigenciaContrato;
            protected String nomeGrauParentesco;
            protected String nomePessoaVinculada;
            protected String nomeTipoRelacionamentoPessoa;
            protected String numeroContratoSistemaOrigem;
            protected String numeroContratoVinculado;
            protected Long numeroPessoa;
            protected Long numeroPessoaVinculada;
            protected String codigoTipoPessoaVinculada;
            protected String descricaoTipoPessoaVinculada;
            protected Short numeroSequencia;

            /**
             * Obt�m o valor da propriedade codigoExposicaoPoliticaPessoaVinculada.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCodigoExposicaoPoliticaPessoaVinculada() {
                return codigoExposicaoPoliticaPessoaVinculada;
            }

            /**
             * Define o valor da propriedade codigoExposicaoPoliticaPessoaVinculada.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCodigoExposicaoPoliticaPessoaVinculada(String value) {
                this.codigoExposicaoPoliticaPessoaVinculada = value;
            }

            /**
             * Obt�m o valor da propriedade descricaoExposicaoPoliticaPessoa.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDescricaoExposicaoPoliticaPessoa() {
                return descricaoExposicaoPoliticaPessoa;
            }

            /**
             * Define o valor da propriedade descricaoExposicaoPoliticaPessoa.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDescricaoExposicaoPoliticaPessoa(String value) {
                this.descricaoExposicaoPoliticaPessoa = value;
            }

            /**
             * Obt�m o valor da propriedade codigoGrauParentesco.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getCodigoGrauParentesco() {
                return codigoGrauParentesco;
            }

            /**
             * Define o valor da propriedade codigoGrauParentesco.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setCodigoGrauParentesco(Short value) {
                this.codigoGrauParentesco = value;
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
             * Obt�m o valor da propriedade codigoTipoRelacionamentoPessoa.
             * 
             * @return
             *     possible object is
             *     {@link Short }
             *     
             */
            public Short getCodigoTipoRelacionamentoPessoa() {
                return codigoTipoRelacionamentoPessoa;
            }

            /**
             * Define o valor da propriedade codigoTipoRelacionamentoPessoa.
             * 
             * @param value
             *     allowed object is
             *     {@link Short }
             *     
             */
            public void setCodigoTipoRelacionamentoPessoa(Short value) {
                this.codigoTipoRelacionamentoPessoa = value;
            }

            /**
             * Obt�m o valor da propriedade dataFinalVigenciaContrato.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getDataFinalVigenciaContrato() {
                return dataFinalVigenciaContrato;
            }

            /**
             * Define o valor da propriedade dataFinalVigenciaContrato.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setDataFinalVigenciaContrato(XMLGregorianCalendar value) {
                this.dataFinalVigenciaContrato = value;
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
             * Obt�m o valor da propriedade dataInicioVigenciaContrato.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getDataInicioVigenciaContrato() {
                return dataInicioVigenciaContrato;
            }

            /**
             * Define o valor da propriedade dataInicioVigenciaContrato.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setDataInicioVigenciaContrato(XMLGregorianCalendar value) {
                this.dataInicioVigenciaContrato = value;
            }

            /**
             * Obt�m o valor da propriedade nomeGrauParentesco.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNomeGrauParentesco() {
                return nomeGrauParentesco;
            }

            /**
             * Define o valor da propriedade nomeGrauParentesco.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNomeGrauParentesco(String value) {
                this.nomeGrauParentesco = value;
            }

            /**
             * Obt�m o valor da propriedade nomePessoaVinculada.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNomePessoaVinculada() {
                return nomePessoaVinculada;
            }

            /**
             * Define o valor da propriedade nomePessoaVinculada.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNomePessoaVinculada(String value) {
                this.nomePessoaVinculada = value;
            }

            /**
             * Obt�m o valor da propriedade nomeTipoRelacionamentoPessoa.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNomeTipoRelacionamentoPessoa() {
                return nomeTipoRelacionamentoPessoa;
            }

            /**
             * Define o valor da propriedade nomeTipoRelacionamentoPessoa.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNomeTipoRelacionamentoPessoa(String value) {
                this.nomeTipoRelacionamentoPessoa = value;
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
             * Obt�m o valor da propriedade numeroContratoVinculado.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getNumeroContratoVinculado() {
                return numeroContratoVinculado;
            }

            /**
             * Define o valor da propriedade numeroContratoVinculado.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setNumeroContratoVinculado(String value) {
                this.numeroContratoVinculado = value;
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
             * Obt�m o valor da propriedade numeroPessoaVinculada.
             * 
             * @return
             *     possible object is
             *     {@link Long }
             *     
             */
            public Long getNumeroPessoaVinculada() {
                return numeroPessoaVinculada;
            }

            /**
             * Define o valor da propriedade numeroPessoaVinculada.
             * 
             * @param value
             *     allowed object is
             *     {@link Long }
             *     
             */
            public void setNumeroPessoaVinculada(Long value) {
                this.numeroPessoaVinculada = value;
            }

            /**
             * Obt�m o valor da propriedade codigoTipoPessoaVinculada.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCodigoTipoPessoaVinculada() {
                return codigoTipoPessoaVinculada;
            }

            /**
             * Define o valor da propriedade codigoTipoPessoaVinculada.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCodigoTipoPessoaVinculada(String value) {
                this.codigoTipoPessoaVinculada = value;
            }

            /**
             * Obt�m o valor da propriedade descricaoTipoPessoaVinculada.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDescricaoTipoPessoaVinculada() {
                return descricaoTipoPessoaVinculada;
            }

            /**
             * Define o valor da propriedade descricaoTipoPessoaVinculada.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDescricaoTipoPessoaVinculada(String value) {
                this.descricaoTipoPessoaVinculada = value;
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

}
