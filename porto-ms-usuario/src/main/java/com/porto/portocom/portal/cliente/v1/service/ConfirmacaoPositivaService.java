package com.porto.portocom.portal.cliente.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.constant.LexisNexisChallengeStatusEnum;
import com.porto.portocom.portal.cliente.v1.constant.LexisNexisTagContextEnum;
import com.porto.portocom.portal.cliente.v1.constant.MensagemChaveEnum;
import com.porto.portocom.portal.cliente.v1.exception.CpfCnpjInvalidoException;
import com.porto.portocom.portal.cliente.v1.exception.GeraTokenAAException;
import com.porto.portocom.portal.cliente.v1.exception.IntegracaoKbaException;
import com.porto.portocom.portal.cliente.v1.exception.PortalException;
import com.porto.portocom.portal.cliente.v1.exception.UsuarioPortalException;
import com.porto.portocom.portal.cliente.v1.utils.LexisNexisUtils;
import com.porto.portocom.portal.cliente.v1.exception.ValidacaoPinException;
import com.porto.portocom.portal.cliente.v1.utils.ValidaCpfCnpjUtils;
import com.porto.portocom.portal.cliente.v1.vo.kba.AvalicaoRespostaVO;
import com.porto.portocom.portal.cliente.v1.vo.kba.KbaAnswersVO;
import com.porto.portocom.portal.cliente.v1.vo.kba.KbaQuizPinVO;

import reactor.core.publisher.Mono;

@Service
public class ConfirmacaoPositivaService implements IConfirmacaoPositivaService {

	private static final String HEADER_EXCEPTION_MESSAGE = "O Header corporativoRequestHeader não foi informado ou não foi encontrado.";

	private IPortalKbaService portalKbaService;

	private ITokenAAService tokenAAService;

	private MensagemLocalCacheService mensagemLocalCacheService;

	private ILexisNexisService lexisNexisService;

	private LexisNexisUtils lexisNexisUtils;

	@Autowired
	public ConfirmacaoPositivaService(IPortalKbaService portalKbaService,
			MensagemLocalCacheService mensagemLocalCacheService, ITokenAAService tokenAAService,
			ILexisNexisService lexisNexisService, LexisNexisUtils lexisNexisUtils) {
		this.portalKbaService = portalKbaService;
		this.tokenAAService = tokenAAService;
		this.mensagemLocalCacheService = mensagemLocalCacheService;
		this.lexisNexisService = lexisNexisService;
		this.lexisNexisUtils = lexisNexisUtils;
	}

	@Override
	public Mono<KbaQuizPinVO> recuperaQuestionario(String cpf) {
		if (ValidaCpfCnpjUtils.isValid(cpf)) {

			if (!lexisNexisUtils.verificaFlagLexis()) {
				return Mono.error(new PortalException(HEADER_EXCEPTION_MESSAGE, HttpStatus.BAD_REQUEST.value()));
			}

			this.lexisNexisService.atualizaLexisNexis(LexisNexisChallengeStatusEnum.CHALLENGE_INIT.getValor(),
					LexisNexisTagContextEnum.KBA.getValor());

			return aplicaPinKba(cpf).flatMap(Mono::just);
		} else {
			return Mono.error(new CpfCnpjInvalidoException(mensagemLocalCacheService
					.recuperaTextoMensagem(MensagemChaveEnum.COMMONS_VALIDACAO_CPF_CNPJ.getValor())));
		}
	}

	private Mono<KbaQuizPinVO> aplicaPinKba(String cpf) {
		return this.tokenAAService.geraPinServico(cpf).flatMap(p -> {
			KbaQuizPinVO kbaquizVO = portalKbaService.recuperaQuestionario(cpf);
			kbaquizVO.setPin(p.getPin());
			return Mono.just(kbaquizVO);
		}).onErrorResume(error -> {
			if (error instanceof GeraTokenAAException) {
				return Mono.error(new UsuarioPortalException(
						mensagemLocalCacheService
								.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_ERRO_ENVIO_PIN.getValor()),
						HttpStatus.INTERNAL_SERVER_ERROR.value()));
			} else {
				return Mono.error(new IntegracaoKbaException("", HttpStatus.BAD_REQUEST.value()));
			}
		});
	}

	@Override
	public Mono<AvalicaoRespostaVO> enviaRespostaQuestionario(KbaAnswersVO kbaAnswersVO) {

		String cpf = kbaAnswersVO.getCpf();
		String token = kbaAnswersVO.getPin();

		if (!ValidaCpfCnpjUtils.isValid(cpf)) {
			return Mono.error(new CpfCnpjInvalidoException(mensagemLocalCacheService
					.recuperaTextoMensagem(MensagemChaveEnum.COMMONS_VALIDACAO_CPF_CNPJ.getValor())));
		}

		if (!lexisNexisUtils.verificaFlagLexis()) {
			return Mono.error(new PortalException(HEADER_EXCEPTION_MESSAGE, HttpStatus.BAD_REQUEST.value()));
		}

		return tokenAAService.validaTokenServico(cpf, token).flatMap(tokenAA -> {
			return portalKbaService.enviaRespostaQuestionario(kbaAnswersVO).flatMap(avaliacaoRespostas -> {
				if (Boolean.getBoolean(avaliacaoRespostas.getBloqueado())) {
					this.lexisNexisService.atualizaLexisNexis(LexisNexisChallengeStatusEnum.CHALLENGE_FAIL.getValor(),
							LexisNexisTagContextEnum.KBA.getValor());
				} else {
					this.lexisNexisService.atualizaLexisNexis(LexisNexisChallengeStatusEnum.CHALLENGE_PASS.getValor(),
							LexisNexisTagContextEnum.KBA.getValor());
				}
				return Mono.just(avaliacaoRespostas);
			}).onErrorResume(error -> Mono.error(new IntegracaoKbaException(
					mensagemLocalCacheService
							.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_ERRO_INTEGRACAO_KBA_INSTAVEL.getValor()),
					HttpStatus.BAD_REQUEST.value())));
		}).onErrorResume(error -> {
			if (error instanceof GeraTokenAAException) {
				GeraTokenAAException errorGeraToken = (GeraTokenAAException) error;
				if (HttpStatus.NOT_FOUND.value() == errorGeraToken.getStatusCode()) {
					return Mono.error(new ValidacaoPinException(
							this.mensagemLocalCacheService.recuperaTextoMensagem(
									MensagemChaveEnum.USUARIO_ERRO_CODIGO_SEGURANCA_NAO_ENCONTRADO.getValor()),
							HttpStatus.NOT_FOUND.value()));
				} else if (HttpStatus.UNAUTHORIZED.value() == errorGeraToken.getStatusCode()) {
					return Mono.error(new ValidacaoPinException(
							this.mensagemLocalCacheService.recuperaTextoMensagem(
									MensagemChaveEnum.USUARIO_VALIDACAO_CODIGO_ATIVACAO_EXPIRADO.getValor()),
							HttpStatus.UNAUTHORIZED.value()));
				} else {
					return Mono.error(new ValidacaoPinException(
							this.mensagemLocalCacheService
									.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_ERRO_VALIDA_PIN.getValor()),
							HttpStatus.BAD_REQUEST.value()));
				}
			} else {
				return Mono.error(new IntegracaoKbaException(
						this.mensagemLocalCacheService.recuperaTextoMensagem(
								MensagemChaveEnum.USUARIO_ERRO_INTEGRACAO_KBA_INSTAVEL.getValor()),
						HttpStatus.BAD_REQUEST.value()));
			}
		});
	}

}
