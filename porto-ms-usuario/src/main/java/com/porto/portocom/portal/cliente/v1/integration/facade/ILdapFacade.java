package com.porto.portocom.portal.cliente.v1.integration.facade;

import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.v1.model.ContaAcessoComSenha;
import com.porto.portocom.portal.cliente.v1.vo.usuario.TipoUsuarioVO;

import reactor.core.publisher.Mono;

@Service
public interface ILdapFacade {

	Mono<Boolean> atualizarSenha(String cpfCnpj, String senha, String errorMessage);

	Mono<Boolean> criarUsuarioComSenha(ContaAcessoComSenha contaAcessoComSenha);

	Mono<Boolean> criarUsuario(UsuarioPortalCliente usuarioPortal,TipoUsuarioVO tipoUsuarioVO);
}
