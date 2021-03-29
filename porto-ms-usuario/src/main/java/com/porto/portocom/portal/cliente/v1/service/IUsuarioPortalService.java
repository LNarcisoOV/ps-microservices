package com.porto.portocom.portal.cliente.v1.service;

import java.util.List;

import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.entity.UsuarioStatusConta;
import com.porto.portocom.portal.cliente.v1.constant.TipoFluxoEnum;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp.Pessoa;
import com.porto.portocom.portal.cliente.v1.model.TelefoneEmailVO;
import com.porto.portocom.portal.cliente.v1.vo.bcc.EnderecoEletronico;
import com.porto.portocom.portal.cliente.v1.vo.bcc.Telefone;
import com.porto.portocom.portal.cliente.v1.vo.produto.ConsultaProdutosProspect;
import com.porto.portocom.portal.cliente.v1.vo.usuario.DadosAcessoVO;
import com.porto.portocom.portal.cliente.v1.vo.usuario.PessoaVO;
import com.porto.portocom.portal.cliente.v1.vo.usuario.UsuarioSimplificado;
import com.porto.portocom.portal.cliente.v1.vo.usuario.UsuarioSimplificadoAtivacao;

import reactor.core.publisher.Mono;

public interface IUsuarioPortalService {

	Mono<UsuarioPortalCliente> consultar(String cpfCnpj);

	Mono<List<UsuarioSimplificadoAtivacao>> consultaUsuarioSimplificado(String cpfCnpj, ConsultaProdutosProspect produtos);

	Mono<UsuarioStatusConta> consultaStatus(String cpfCnpj);

	UsuarioPortalCliente criaUsuarioPortalDePessoaVo(PessoaVO pessoa);

	UsuarioPortalCliente alteraUsuarioPortal(PessoaVO pessoaVo, UsuarioPortalCliente usuarioPortal, TipoFluxoEnum tipoCadastro);

	Mono<UsuarioPortalCliente> consultarUsuarioPorId(Long cpfCnpj);

	Mono<List<UsuarioSimplificado>> consultaUsuarioSimplificadoRecuperacao(String cpfCnpj);

	Mono<Pessoa> obtemClienteTitular(final List<Pessoa> listaPessoas);

	Mono<UsuarioPortalCliente> salvar(UsuarioPortalCliente usuario);

	TelefoneEmailVO obtemEmailETelefoneBCC(List<Telefone> telefones, List<EnderecoEletronico> emails);

	Mono<DadosAcessoVO> consultarDadosAcesso(String cpf);

	Mono<PessoaVO> obtemPessoaPorProdutos(ConsultaProdutosProspect produtos, String cpfCnpj);
}
