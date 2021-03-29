package com.porto.portocom.portal.cliente.v1.service;

import java.util.List;

import com.porto.portocom.portal.cliente.v1.constant.TipoCodigoEnum;
import com.porto.portocom.portal.cliente.v1.vo.antifraude.CorporativoValidation;
import com.porto.portocom.portal.cliente.v1.vo.usuario.UsuarioSimplificado;
import com.porto.portocom.portal.cliente.v1.vo.usuario.UsuarioSimplificadoAtivacao;
import com.porto.portocom.portal.cliente.v1.vo.usuario.UsuarioVO;

import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

public interface ILexisNexisService {

	Mono<CorporativoValidation> validaLexisNexis(String cpfCnpj, UsuarioVO usuarioVoHard, TipoCodigoEnum tipoCodigo);

	Mono<Tuple2<List<UsuarioSimplificadoAtivacao>, CorporativoValidation>> validaLexisNexisUsuarioSimplificadoAtivacao(
			String cpfCnpj);

	Mono<Tuple2<List<UsuarioSimplificado>, CorporativoValidation>> validaLexisNexisUsuarioSimplificadoRecuperacao(
			String cpfCnpj);

	void atualizaLexisNexis(String eventTag, String tagContext);

}
