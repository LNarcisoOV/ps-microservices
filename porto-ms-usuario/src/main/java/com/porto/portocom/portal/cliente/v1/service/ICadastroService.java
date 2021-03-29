package com.porto.portocom.portal.cliente.v1.service;

import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.vo.usuario.CadastroSenha;
import com.porto.portocom.portal.cliente.v1.vo.usuario.TipoUsuarioVO;

import reactor.core.publisher.Mono;

@Service
public interface ICadastroService {
	
	Mono<Boolean> cadastroSenha(CadastroSenha cadastro);

	Mono<Boolean> alteraSenhaUsuario(String cpfCnpj, String senha, String codigoRecuperacao);
	
 	Mono<Boolean> criarUsuarioComSenha(CadastroSenha cadastroSenha, TipoUsuarioVO tipoUsuarioVO);
 	
}
