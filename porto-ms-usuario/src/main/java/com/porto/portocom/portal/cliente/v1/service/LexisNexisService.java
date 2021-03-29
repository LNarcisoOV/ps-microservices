package com.porto.portocom.portal.cliente.v1.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.porto.experiencia.cliente.lexisnexis.SessionQueryResponse;
import com.porto.portocom.portal.cliente.v1.constant.HeaderAplicacaoEnum;
import com.porto.portocom.portal.cliente.v1.constant.LexisNexisPolicyEnum;
import com.porto.portocom.portal.cliente.v1.constant.LexisNexisStatusEnum;
import com.porto.portocom.portal.cliente.v1.constant.LogSubTipoEnum;
import com.porto.portocom.portal.cliente.v1.constant.MensagemChaveEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoCodigoEnum;
import com.porto.portocom.portal.cliente.v1.exception.CadastroException;
import com.porto.portocom.portal.cliente.v1.exception.LexisNexisRejectException;
import com.porto.portocom.portal.cliente.v1.utils.LexisNexisUtils;
import com.porto.portocom.portal.cliente.v1.vo.antifraude.CorporativoValidation;
import com.porto.portocom.portal.cliente.v1.vo.antifraude.LexisNexisAtualizaRequest;
import com.porto.portocom.portal.cliente.v1.vo.antifraude.LexisNexisRequestHeader;
import com.porto.portocom.portal.cliente.v1.vo.antifraude.LexisNexisSessionRequest;
import com.porto.portocom.portal.cliente.v1.vo.usuario.PessoaVO;
import com.porto.portocom.portal.cliente.v1.vo.usuario.TelefoneVO;
import com.porto.portocom.portal.cliente.v1.vo.usuario.UsuarioSimplificado;
import com.porto.portocom.portal.cliente.v1.vo.usuario.UsuarioSimplificadoAtivacao;
import com.porto.portocom.portal.cliente.v1.vo.usuario.UsuarioVO;

import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@Qualifier("lexisNexisPortal")
@Service("lexisNexisPortal")
public class LexisNexisService implements ILexisNexisService {

	private static final String LEXIS_ACTION_UPDATE_DEFAULT = "update_event_tag";
	private static final String COD_DDI = "55";

	private LexisNexisUtils lexisNexisUtils;
	private IProspectService prospectService;
	private IUsuarioPortalService usuarioPortalService;
	private IPortalLexisNexisService portalLexisNexisService;
	private MensagemLocalCacheService mensagemLocalCacheService;
	private ILogPortalClienteService logPortalClienteService;

	@Autowired
	public LexisNexisService(LexisNexisUtils lexisNexisUtils, IProspectService prospectService,
			IUsuarioPortalService usuarioPortalService, IPortalLexisNexisService portalLexisNexisService,
			MensagemLocalCacheService mensagemLocalCacheService, ILogPortalClienteService logPortalClienteService) {
		this.lexisNexisUtils = lexisNexisUtils;
		this.prospectService = prospectService;
		this.usuarioPortalService = usuarioPortalService;
		this.portalLexisNexisService = portalLexisNexisService;
		this.mensagemLocalCacheService = mensagemLocalCacheService;
		this.logPortalClienteService = logPortalClienteService;
	}

	@Override
	public void atualizaLexisNexis(String eventTag, String tagContext) {

		LexisNexisRequestHeader lexisNexisRequestHeader = lexisNexisUtils.obtemHeaderLexisNexis();

		if (lexisNexisRequestHeader != null
				&& (lexisNexisRequestHeader.getValidation().equals(LexisNexisStatusEnum.REVIEW.getValor())
						|| lexisNexisRequestHeader.getValidation().equals(LexisNexisStatusEnum.PASS.getValor()))) {

			portalLexisNexisService
					.atualizaLexisNexis(new LexisNexisAtualizaRequest(lexisNexisRequestHeader.getOrganizationId(),
							lexisNexisRequestHeader.getRequestId(), LEXIS_ACTION_UPDATE_DEFAULT, eventTag, tagContext));
		}
	}

	@Override
	public Mono<Tuple2<List<UsuarioSimplificadoAtivacao>, CorporativoValidation>> validaLexisNexisUsuarioSimplificadoAtivacao(
			String cpfCnpj) {

		Mono<List<UsuarioSimplificadoAtivacao>> usuarioSimplificado = null;
		LexisNexisRequestHeader lexisNexisRequestHeader = lexisNexisUtils.obtemHeaderLexisNexis();

		if (lexisNexisRequestHeader != null) {
			return this.prospectService.consultaProdutosProspect(cpfCnpj)
					.flatMap(produtos -> this.usuarioPortalService.consultaUsuarioSimplificado(cpfCnpj, produtos)
							.flatMap(usuario -> this.usuarioPortalService.obtemPessoaPorProdutos(produtos, cpfCnpj)
									.flatMap(pessoaVo -> montaObjetoRequestERealizaChamadaLexis(lexisNexisRequestHeader,
											cpfCnpj, pessoaVo, null, null)
													.flatMap(corporativoValidation -> Mono.zip(Mono.just(usuario),
															Mono.just(corporativoValidation))))));
		} else {
			usuarioSimplificado = this.usuarioPortalService.consultaUsuarioSimplificado(cpfCnpj, null);
		}

		return Mono.zip(usuarioSimplificado, Mono.just(new CorporativoValidation()));
	}

	@Override
	public Mono<Tuple2<List<UsuarioSimplificado>, CorporativoValidation>> validaLexisNexisUsuarioSimplificadoRecuperacao(
			String cpfCnpj) {

		Mono<List<UsuarioSimplificado>> usuarioSimplificado = null;
		LexisNexisRequestHeader lexisNexisRequestHeader = lexisNexisUtils.obtemHeaderLexisNexis();

		if (lexisNexisRequestHeader != null) {
			return this.prospectService.consultaProdutosProspect(cpfCnpj)
					.flatMap(produtos -> this.usuarioPortalService.consultaUsuarioSimplificadoRecuperacao(cpfCnpj)
							.flatMap(usuario -> this.usuarioPortalService.obtemPessoaPorProdutos(produtos, cpfCnpj)
									.flatMap(pessoaVo -> montaObjetoRequestERealizaChamadaLexis(lexisNexisRequestHeader,
											cpfCnpj, pessoaVo, null, null)
													.flatMap(corporativoValidation -> Mono.zip(Mono.just(usuario),
															Mono.just(corporativoValidation))))));
		} else {
			usuarioSimplificado = this.usuarioPortalService.consultaUsuarioSimplificadoRecuperacao(cpfCnpj);
		}

		return Mono.zip(usuarioSimplificado, Mono.just(new CorporativoValidation()));
	}

	@Override
	public Mono<CorporativoValidation> validaLexisNexis(String cpfCnpj, UsuarioVO usuarioVoHard,
			TipoCodigoEnum tipoCodigo) {

		LexisNexisRequestHeader lexisNexisRequestHeader = lexisNexisUtils.obtemHeaderLexisNexis();

		if (lexisNexisRequestHeader != null) {
			return this.prospectService.consultaProdutosProspect(cpfCnpj)
					.flatMap(produtos -> this.usuarioPortalService.obtemPessoaPorProdutos(produtos, cpfCnpj)
							.flatMap(pessoaVo -> montaObjetoRequestERealizaChamadaLexis(lexisNexisRequestHeader,
									cpfCnpj, pessoaVo, usuarioVoHard, tipoCodigo).onErrorResume(Mono::error)));
		}

		return Mono.just(new CorporativoValidation());
	}

	private Mono<CorporativoValidation> montaObjetoRequestERealizaChamadaLexis(
			LexisNexisRequestHeader lexisNexisRequestHeader, String cpfCnpj, PessoaVO pessoaVO, UsuarioVO usuarioVoHard,
			TipoCodigoEnum tipoCodigo) {

		CorporativoValidation lexisNexisValidation = new CorporativoValidation();

		LexisNexisSessionRequest lexisNexisSessionRequest = montaObjetoLexisNexisSessionRequest(cpfCnpj,
				lexisNexisRequestHeader, pessoaVO, usuarioVoHard);

		SessionQueryResponse respostaLexisNexis = this.verificaPoliticaERealizaChamada(usuarioVoHard,
				lexisNexisRequestHeader, tipoCodigo, lexisNexisSessionRequest);

		if (respostaLexisNexis.getRequestResult() != null && respostaLexisNexis.getRequestResult().equals("success")) {
			lexisNexisValidation.setRequestId(respostaLexisNexis.getRequestId());
			lexisNexisValidation.setValidation(respostaLexisNexis.getReviewStatus());

			if (StringUtils.isNotBlank(respostaLexisNexis.getReviewStatus())) {

				this.montaLogPortal(cpfCnpj, lexisNexisRequestHeader.getPolicy(), respostaLexisNexis.getReviewStatus());

				if (respostaLexisNexis.getReviewStatus().equals(LexisNexisStatusEnum.REJECT.getValor())) {
					return Mono.error(new LexisNexisRejectException(
							this.mensagemLocalCacheService
									.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_VALIDACAO_LEXIS_NEXIS.getValor()),
							HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS.value(), lexisNexisValidation));
				}
			}

		} else {
			return Mono.error(new CadastroException(
					"Erro ao realizar integração com serviço corporativo: " + respostaLexisNexis.getErrorDetail(),
					HttpStatus.BAD_REQUEST.value()));
		}
		return Mono.just(lexisNexisValidation);
	}

	private LexisNexisSessionRequest montaObjetoLexisNexisSessionRequest(String cpfCnpj,
			LexisNexisRequestHeader lexisNexisRequestHeader, PessoaVO pessoaVO, UsuarioVO usuarioVoHard) {

		LexisNexisSessionRequest lexisNexisSessionRequest = new LexisNexisSessionRequest();

		lexisNexisSessionRequest.setOrganizationId(lexisNexisRequestHeader.getOrganizationId());
		lexisNexisSessionRequest.setSessionId(lexisNexisRequestHeader.getSessionId());
		lexisNexisSessionRequest.setIpAddress(lexisNexisRequestHeader.getIpAddress());
		lexisNexisSessionRequest.setCpfCnpj(cpfCnpj);
		lexisNexisSessionRequest.setNome(pessoaVO.getNome());
		lexisNexisSessionRequest.setPolicy(lexisNexisRequestHeader.getPolicy());
		lexisNexisSessionRequest.setDataNascimento(pessoaVO.getDataNascimento() != null
				? new SimpleDateFormat("yyyyMMdd").format(pessoaVO.getDataNascimento())
				: null);
		lexisNexisSessionRequest.setCustomerEventType(MDC.get(HeaderAplicacaoEnum.NOME_APLICACAO.getValor()));

		if (CollectionUtils.isNotEmpty(pessoaVO.getTelefones())) {
			lexisNexisSessionRequest.setContextoTelefone(pessoaVO.getTelefones().get(0).getTipoTelefone());
		}
		if (pessoaVO.getEndereco() != null) {
			lexisNexisSessionRequest.setTipoLogradouro(pessoaVO.getEndereco().getTipoLogradouro());
			lexisNexisSessionRequest.setLogradouro(pessoaVO.getEndereco().getLogradouro());
			lexisNexisSessionRequest.setNumeroResidencial(pessoaVO.getEndereco().getNumeroResidencial());
			lexisNexisSessionRequest.setComplemento(pessoaVO.getEndereco().getComplemento());
			lexisNexisSessionRequest.setBairro(pessoaVO.getEndereco().getBairro());
			lexisNexisSessionRequest.setCidade(pessoaVO.getEndereco().getCidade());
			lexisNexisSessionRequest.setCep(pessoaVO.getEndereco().getCep());
			lexisNexisSessionRequest.setEstado(pessoaVO.getEndereco().getEstado());
			lexisNexisSessionRequest.setPais(pessoaVO.getEndereco().getPais());
		}

		if (usuarioVoHard != null) {
			lexisNexisSessionRequest
					.setNome(usuarioVoHard.getNome() != null ? usuarioVoHard.getNome() : pessoaVO.getNome());
			lexisNexisSessionRequest.setTelefone(usuarioVoHard.getCelular());
			lexisNexisSessionRequest.setEmail(usuarioVoHard.getEmail());
			lexisNexisSessionRequest.setAssociatedRequestId(lexisNexisRequestHeader.getRequestId());
		} else {
			this.usuarioPortalService.consultarDadosAcesso(cpfCnpj).doOnSuccess(dadosAcesso -> {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				lexisNexisSessionRequest.setDataAlteracaoEmail(dadosAcesso.getDataHoraAtualizacaoEmail() != null
						? dadosAcesso.getDataHoraAtualizacaoEmail().format(formatter)
						: null);
				lexisNexisSessionRequest.setDataAlteracaoTelefone(dadosAcesso.getDataHoraAtualizacaoCelular() != null
						? dadosAcesso.getDataHoraAtualizacaoCelular().format(formatter)
						: null);
				lexisNexisSessionRequest.setTelefone(dadosAcesso.getCelular());
				lexisNexisSessionRequest.setEmail(dadosAcesso.getEmail());

			}).doOnError(erro -> {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String dataAtual = LocalDateTime.now().format(formatter);
				lexisNexisSessionRequest.setDataAlteracaoEmail(dataAtual);
				lexisNexisSessionRequest.setDataAlteracaoTelefone(dataAtual);
				if (CollectionUtils.isNotEmpty(pessoaVO.getTelefones())) {
					TelefoneVO telefoneVO = pessoaVO.getTelefones().get(0);
					String telefoneCompleto = COD_DDI + telefoneVO.getDdd() + telefoneVO.getNumeroTelefone();
					lexisNexisSessionRequest.setTelefone(telefoneCompleto);
				}
				lexisNexisSessionRequest.setEmail(
						CollectionUtils.isNotEmpty(pessoaVO.getEmails()) ? pessoaVO.getEmails().get(0) : null);
			}).subscribe();
		}

		return lexisNexisSessionRequest;
	}

	private SessionQueryResponse verificaPoliticaERealizaChamada(UsuarioVO usuarioVoHard,
			LexisNexisRequestHeader lexisNexisRequestHeader, TipoCodigoEnum tipoCodigo,
			LexisNexisSessionRequest lexisNexisSessionRequest) {

		SessionQueryResponse respostaLexisNexis = new SessionQueryResponse();

		if (usuarioVoHard != null) {
			if (lexisNexisRequestHeader.getPolicy().equals(LexisNexisPolicyEnum.FLUXO_HARD_WEB.getValor())
					|| lexisNexisRequestHeader.getPolicy().equals(LexisNexisPolicyEnum.FLUXO_HARD_APP.getValor())
							&& (tipoCodigo != null && tipoCodigo == TipoCodigoEnum.ATIVACAO)) {
				respostaLexisNexis = portalLexisNexisService.validaCadastroLexisNexis(lexisNexisSessionRequest);

			} else if ((lexisNexisRequestHeader.getPolicy().equals(LexisNexisPolicyEnum.FLUXO_HARD_WEB.getValor())
					|| lexisNexisRequestHeader.getPolicy().equals(LexisNexisPolicyEnum.FLUXO_HARD_APP.getValor()))
					&& (tipoCodigo != null && tipoCodigo == TipoCodigoEnum.RECUPERACAO)) {
				respostaLexisNexis = portalLexisNexisService.validaRecuperacaoContaLexisNexis(lexisNexisSessionRequest);
			}

		} else {
			if (lexisNexisRequestHeader.getPolicy().equals(LexisNexisPolicyEnum.CADASTRO.getValor())
					|| lexisNexisRequestHeader.getPolicy().equals(LexisNexisPolicyEnum.CADASTRO_APP.getValor())) {
				respostaLexisNexis = portalLexisNexisService.validaCadastroLexisNexis(lexisNexisSessionRequest);

			} else if (lexisNexisRequestHeader.getPolicy().equals(LexisNexisPolicyEnum.RECUPERACAO.getValor())
					|| lexisNexisRequestHeader.getPolicy().equals(LexisNexisPolicyEnum.RECUPERACAO_APP.getValor())) {
				respostaLexisNexis = portalLexisNexisService.validaRecuperacaoContaLexisNexis(lexisNexisSessionRequest);
			}
		}
		return respostaLexisNexis;
	}

	private void montaLogPortal(String cpfCnpj, String policy, String reviewStatus) {

		if ((policy == LexisNexisPolicyEnum.CADASTRO.getValor()
				|| policy == LexisNexisPolicyEnum.CADASTRO_APP.getValor())
				&& reviewStatus.equals(LexisNexisStatusEnum.REVIEW.getValor())) {
			logPortalClienteService.geraLogPortal(cpfCnpj,
					MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_REVISAO_LEXIS_ATIVACAO.getValor(),
					LogSubTipoEnum.CADASTRO_REVIEW_LEXIS_NEXIS.getCodigo());

		} else if ((policy == LexisNexisPolicyEnum.CADASTRO.getValor()
				|| policy == LexisNexisPolicyEnum.CADASTRO_APP.getValor())
				&& reviewStatus.equals(LexisNexisStatusEnum.REJECT.getValor())) {
			logPortalClienteService.geraLogPortal(cpfCnpj,
					MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_REJEITADO_LEXIS_ATIVACAO.getValor(),
					LogSubTipoEnum.CADASTRO_BLOQUEADO_LEXIS_NEXIS.getCodigo());

		} else if ((policy == LexisNexisPolicyEnum.RECUPERACAO.getValor()
				|| policy == LexisNexisPolicyEnum.RECUPERACAO_APP.getValor())
				&& reviewStatus.equals(LexisNexisStatusEnum.REVIEW.getValor())) {
			logPortalClienteService.geraLogPortal(cpfCnpj,
					MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_REVISAO_LEXIS_RECUPERACAO.getValor(),
					LogSubTipoEnum.RECUPERACAO_REVIEW_LEXIS_NEXIS.getCodigo());

		} else if ((policy == LexisNexisPolicyEnum.RECUPERACAO.getValor()
				|| policy == LexisNexisPolicyEnum.RECUPERACAO_APP.getValor())
				&& reviewStatus.equals(LexisNexisStatusEnum.REJECT.getValor())) {
			logPortalClienteService.geraLogPortal(cpfCnpj,
					MensagemChaveEnum.USUARIO_MSG_LOG_ENVIO_COD_SEGURANCA_REJEITADO_LEXIS_RECUPERACAO.getValor(),
					LogSubTipoEnum.RECUPERACAO_BLOQUEADO_LEXIS_NEXIS.getCodigo());
		}
	}
}
