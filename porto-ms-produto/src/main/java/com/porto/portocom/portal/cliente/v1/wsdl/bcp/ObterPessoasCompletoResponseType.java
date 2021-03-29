
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
 * <p>Classe Java de ObterPessoasCompletoResponseType complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="ObterPessoasCompletoResponseType">
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
 *                   &lt;element name="codigoSusep" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                   &lt;element name="juridica" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
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
 *                   &lt;element name="vinculos" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="codigoExposicaoPoliticaPessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="descricaoExposicaoPoliticaPessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "ObterPessoasCompletoResponseType", propOrder = {
    "pessoa"
})
public class ObterPessoasCompletoResponseType implements Serializable{

	private static final long serialVersionUID = 629304474316946770L;
	
	protected List<ObterPessoasCompletoResponseType.Pessoa> pessoa;

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
     * {@link ObterPessoasCompletoResponseType.Pessoa }
     * 
     * 
     */
    public List<ObterPessoasCompletoResponseType.Pessoa> getPessoa() {
        if (pessoa == null) {
            pessoa = new ArrayList<ObterPessoasCompletoResponseType.Pessoa>();
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
     *         &lt;element name="codigoSusep" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *         &lt;element name="juridica" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
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
     *         &lt;element name="vinculos" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="codigoExposicaoPoliticaPessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="descricaoExposicaoPoliticaPessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
        "dataAtualizacaoRegistro",
        "dataInclusaoRegistro",
        "documentos",
        "enderecos",
        "enderecosEletronicos",
        "fisica",
        "flagCadastroPortalCliente",
        "codigoSusep",
        "juridica",
        "nomeOrigemMovimento",
        "nomePessoa",
        "nomeTratamento",
        "numeroPessoa",
        "papeisPessoa",
        "primeiroCodigoFonetico",
        "segundoCodigoFonetico",
        "terceiroCodigoFonetico",
        "telefones",
        "vinculos",
        "midiasSociais"
    })
    public static class Pessoa {

        protected List<ObterPessoasCompletoResponseType.Pessoa.AcessosRestritos> acessosRestritos;
        protected Short codigoOrigemMovimento;
        protected String codigoTipoPessoa;
        protected String descricaoTipoPessoa;
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar dataAtualizacaoRegistro;
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar dataInclusaoRegistro;
        protected List<ObterPessoasCompletoResponseType.Pessoa.Documentos> documentos;
        protected List<ObterPessoasCompletoResponseType.Pessoa.Enderecos> enderecos;
        protected List<ObterPessoasCompletoResponseType.Pessoa.EnderecosEletronicos> enderecosEletronicos;
        protected ObterPessoasCompletoResponseType.Pessoa.Fisica fisica;
        protected String flagCadastroPortalCliente;
        protected String codigoSusep;
        protected ObterPessoasCompletoResponseType.Pessoa.Juridica juridica;
        protected String nomeOrigemMovimento;
        protected String nomePessoa;
        protected String nomeTratamento;
        protected Long numeroPessoa;
        protected List<ObterPessoasCompletoResponseType.Pessoa.PapeisPessoa> papeisPessoa;
        protected String primeiroCodigoFonetico;
        protected String segundoCodigoFonetico;
        protected String terceiroCodigoFonetico;
        protected List<ObterPessoasCompletoResponseType.Pessoa.Telefones> telefones;
        protected List<ObterPessoasCompletoResponseType.Pessoa.Vinculos> vinculos;
        protected List<ObterPessoasCompletoResponseType.Pessoa.MidiasSociais> midiasSociais;

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
         * {@link ObterPessoasCompletoResponseType.Pessoa.AcessosRestritos }
         * 
         * 
         */
        public List<ObterPessoasCompletoResponseType.Pessoa.AcessosRestritos> getAcessosRestritos() {
            if (acessosRestritos == null) {
                acessosRestritos = new ArrayList<ObterPessoasCompletoResponseType.Pessoa.AcessosRestritos>();
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
         * {@link ObterPessoasCompletoResponseType.Pessoa.Documentos }
         * 
         * 
         */
        public List<ObterPessoasCompletoResponseType.Pessoa.Documentos> getDocumentos() {
            if (documentos == null) {
                documentos = new ArrayList<ObterPessoasCompletoResponseType.Pessoa.Documentos>();
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
         * {@link ObterPessoasCompletoResponseType.Pessoa.Enderecos }
         * 
         * 
         */
        public List<ObterPessoasCompletoResponseType.Pessoa.Enderecos> getEnderecos() {
            if (enderecos == null) {
                enderecos = new ArrayList<ObterPessoasCompletoResponseType.Pessoa.Enderecos>();
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
         * {@link ObterPessoasCompletoResponseType.Pessoa.EnderecosEletronicos }
         * 
         * 
         */
        public List<ObterPessoasCompletoResponseType.Pessoa.EnderecosEletronicos> getEnderecosEletronicos() {
            if (enderecosEletronicos == null) {
                enderecosEletronicos = new ArrayList<ObterPessoasCompletoResponseType.Pessoa.EnderecosEletronicos>();
            }
            return this.enderecosEletronicos;
        }

        /**
         * Obt�m o valor da propriedade fisica.
         * 
         * @return
         *     possible object is
         *     {@link ObterPessoasCompletoResponseType.Pessoa.Fisica }
         *     
         */
        public ObterPessoasCompletoResponseType.Pessoa.Fisica getFisica() {
            return fisica;
        }

        /**
         * Define o valor da propriedade fisica.
         * 
         * @param value
         *     allowed object is
         *     {@link ObterPessoasCompletoResponseType.Pessoa.Fisica }
         *     
         */
        public void setFisica(ObterPessoasCompletoResponseType.Pessoa.Fisica value) {
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
         * Obt�m o valor da propriedade juridica.
         * 
         * @return
         *     possible object is
         *     {@link ObterPessoasCompletoResponseType.Pessoa.Juridica }
         *     
         */
        public ObterPessoasCompletoResponseType.Pessoa.Juridica getJuridica() {
            return juridica;
        }

        /**
         * Define o valor da propriedade juridica.
         * 
         * @param value
         *     allowed object is
         *     {@link ObterPessoasCompletoResponseType.Pessoa.Juridica }
         *     
         */
        public void setJuridica(ObterPessoasCompletoResponseType.Pessoa.Juridica value) {
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
         * {@link ObterPessoasCompletoResponseType.Pessoa.PapeisPessoa }
         * 
         * 
         */
        public List<ObterPessoasCompletoResponseType.Pessoa.PapeisPessoa> getPapeisPessoa() {
            if (papeisPessoa == null) {
                papeisPessoa = new ArrayList<ObterPessoasCompletoResponseType.Pessoa.PapeisPessoa>();
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
         * {@link ObterPessoasCompletoResponseType.Pessoa.Telefones }
         * 
         * 
         */
        public List<ObterPessoasCompletoResponseType.Pessoa.Telefones> getTelefones() {
            if (telefones == null) {
                telefones = new ArrayList<ObterPessoasCompletoResponseType.Pessoa.Telefones>();
            }
            return this.telefones;
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
         * {@link ObterPessoasCompletoResponseType.Pessoa.Vinculos }
         * 
         * 
         */
        public List<ObterPessoasCompletoResponseType.Pessoa.Vinculos> getVinculos() {
            if (vinculos == null) {
                vinculos = new ArrayList<ObterPessoasCompletoResponseType.Pessoa.Vinculos>();
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
         * {@link ObterPessoasCompletoResponseType.Pessoa.MidiasSociais }
         * 
         * 
         */
        public List<ObterPessoasCompletoResponseType.Pessoa.MidiasSociais> getMidiasSociais() {
            if (midiasSociais == null) {
                midiasSociais = new ArrayList<ObterPessoasCompletoResponseType.Pessoa.MidiasSociais>();
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
            protected List<ObterPessoasCompletoResponseType.Pessoa.Fisica.DeficienciasFisicas> deficienciasFisicas;
            protected String flagPessoaDeficienciaFisica;
            protected String flagPessoaEstrangeira;
            protected Short codigoEstadoCivil;
            protected String nomeEstadoCivil;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dataInclusaoRegistroEstadoCivil;
            protected List<ObterPessoasCompletoResponseType.Pessoa.Fisica.Ocupacoes> ocupacoes;
            protected Short codigoFaixaRenda;
            protected String descricaoFaixaRenda;
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar dataInclusaoRegistroFaixaRenda;
            protected String nomeMae;
            protected String nomePai;
            protected Long numeroPessoa;
            protected List<ObterPessoasCompletoResponseType.Pessoa.Fisica.VinculosPep> vinculosPep;

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
             * {@link ObterPessoasCompletoResponseType.Pessoa.Fisica.DeficienciasFisicas }
             * 
             * 
             */
            public List<ObterPessoasCompletoResponseType.Pessoa.Fisica.DeficienciasFisicas> getDeficienciasFisicas() {
                if (deficienciasFisicas == null) {
                    deficienciasFisicas = new ArrayList<ObterPessoasCompletoResponseType.Pessoa.Fisica.DeficienciasFisicas>();
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
             * {@link ObterPessoasCompletoResponseType.Pessoa.Fisica.Ocupacoes }
             * 
             * 
             */
            public List<ObterPessoasCompletoResponseType.Pessoa.Fisica.Ocupacoes> getOcupacoes() {
                if (ocupacoes == null) {
                    ocupacoes = new ArrayList<ObterPessoasCompletoResponseType.Pessoa.Fisica.Ocupacoes>();
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
             * {@link ObterPessoasCompletoResponseType.Pessoa.Fisica.VinculosPep }
             * 
             * 
             */
            public List<ObterPessoasCompletoResponseType.Pessoa.Fisica.VinculosPep> getVinculosPep() {
                if (vinculosPep == null) {
                    vinculosPep = new ArrayList<ObterPessoasCompletoResponseType.Pessoa.Fisica.VinculosPep>();
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
         *         &lt;element name="numeroSequencia" type="{http://www.w3.org/2001/XMLSchema}short" minOccurs="0"/>
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
            "numeroSequencia",
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

            protected Short numeroSequencia;
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
         *         &lt;element name="descricaoExposicaoPoliticaPessoaVinculada" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
            "descricaoExposicaoPoliticaPessoaVinculada",
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
            protected String descricaoExposicaoPoliticaPessoaVinculada;
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
             * Obt�m o valor da propriedade descricaoExposicaoPoliticaPessoaVinculada.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDescricaoExposicaoPoliticaPessoaVinculada() {
                return descricaoExposicaoPoliticaPessoaVinculada;
            }

            /**
             * Define o valor da propriedade descricaoExposicaoPoliticaPessoaVinculada.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDescricaoExposicaoPoliticaPessoaVinculada(String value) {
                this.descricaoExposicaoPoliticaPessoaVinculada = value;
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
