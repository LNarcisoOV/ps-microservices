package com.porto.portocom.portal.cliente.v1.service;

import java.util.List;

import com.porto.portocom.portal.cliente.v1.constant.TipoCodigoEnum;
import com.porto.portocom.portal.cliente.v1.vo.antifraude.CorporativoValidation;
import com.porto.portocom.portal.cliente.v1.vo.usuario.UsuarioSimplificado;
import com.porto.portocom.portal.cliente.v1.vo.usuario.UsuarioVO;

import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

public interface IDadosCadastraisService {

	Mono<Tuple2<List<UsuarioSimplificado>, CorporativoValidation>> atualizaDadosCadastrais(UsuarioVO usuarioVo,
			TipoCodigoEnum tipoCodigo);
}
