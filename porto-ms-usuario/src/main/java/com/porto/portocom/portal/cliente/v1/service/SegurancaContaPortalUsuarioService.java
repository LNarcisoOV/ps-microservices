package com.porto.portocom.portal.cliente.v1.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.entity.SegurancaContaPortalUsuario;
import com.porto.portocom.portal.cliente.v1.constant.TipoCodigoSegurancaEnum;
import com.porto.portocom.portal.cliente.v1.repository.ISegurancaContaPortalUsuarioRepository;

import reactor.core.publisher.Mono;

@Service
public class SegurancaContaPortalUsuarioService implements ISegurancaContaPortalUsuarioService {

	private ISegurancaContaPortalUsuarioRepository segurancaContaPortalUsuarioRepository;

	@Autowired
	SegurancaContaPortalUsuarioService(ISegurancaContaPortalUsuarioRepository segurancaContaPortalUsuarioRepository) {
		this.segurancaContaPortalUsuarioRepository = segurancaContaPortalUsuarioRepository;
	}

	public Mono<SegurancaContaPortalUsuario> obtemCodigoRecuperacao(Long usuarioId, Long codigoRecuperacao) {
		return Mono.justOrEmpty(segurancaContaPortalUsuarioRepository
				.findByCodigoSegurancaUsuarioAndNumeroSequenciaUsuarioAndCodigoTipoSeguranca(usuarioId,
						codigoRecuperacao, TipoCodigoSegurancaEnum.TIPO_CODIGOSEGURANCA_REDEFINIRSENHA.getCodigo()));
	}

	public Mono<SegurancaContaPortalUsuario> obtemCodigoAtivacao(Long usuarioId, Long codigoAtivacao) {
		return Mono.justOrEmpty(segurancaContaPortalUsuarioRepository
				.findByCodigoSegurancaUsuarioAndNumeroSequenciaUsuarioAndCodigoTipoSeguranca(usuarioId, codigoAtivacao,
						TipoCodigoSegurancaEnum.TIPO_CODIGOSEGURANCA_CADASTROCONTA_PORTAL.getCodigo()));
	}

	public Mono<SegurancaContaPortalUsuario> obtemCodigoAcesso(Long usuarioId, Long codigoAtivacao) {
		return Mono.justOrEmpty(segurancaContaPortalUsuarioRepository
				.findByCodigoSegurancaUsuarioAndNumeroSequenciaUsuarioAndCodigoTipoSeguranca(usuarioId, codigoAtivacao,
						TipoCodigoSegurancaEnum.TIPO_CODIGOSEGURANCA_ACESSO.getCodigo()));
	}

	public boolean verificaCodigoExpirado(SegurancaContaPortalUsuario codigo) {
		boolean expirado = true;

		LocalDateTime dataCriacao = obtemDataCriacaoCodigo(codigo);
		LocalDateTime dataAtual = LocalDateTime.now();
		Long duracao = Duration.between(dataCriacao, dataAtual).toMinutes();
		if (duracao <= codigo.getId().getTipoCodigoSeguranca().getQuantidadeTempoValidade()) {
			expirado = false;
		}
		return expirado;
	}

	private LocalDateTime obtemDataCriacaoCodigo(SegurancaContaPortalUsuario codigo) {
		return codigo.getDataCriacaoCodigoSeguranca().toInstant().atZone(TimeZone.getDefault().toZoneId())
				.toLocalDateTime();
	}

	public boolean possuiCodigoSegurancaPortalValido(Long cnpjCpf, Long cnpjOrdem, Long cnpjCpfDigito) {

		SegurancaContaPortalUsuario codigoSeguranca = segurancaContaPortalUsuarioRepository
				.findByCodigoSegurancaAtivacaoByCpf(cnpjCpf, cnpjOrdem, cnpjCpfDigito);
		
		if(codigoSeguranca != null) {
			if(verificaCodigoExpirado(codigoSeguranca)) {
				return false;
			}else {
				return true;
			}
				
		}else {
			return false;
		}
		

	}

}
