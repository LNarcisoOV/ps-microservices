package com.porto.portocom.portal.cliente.v1.service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.entity.TipoUsuario;
import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.entity.UsuarioStatusConta;
import com.porto.portocom.portal.cliente.v1.constant.MensagemChaveEnum;
import com.porto.portocom.portal.cliente.v1.constant.MensagemUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.constant.StatusUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.dto.bcp.ContratoBcp.Pessoa;
import com.porto.portocom.portal.cliente.v1.dto.conquista.IsClienteArenaCadastrado;
import com.porto.portocom.portal.cliente.v1.dto.vdo.CotacoesVendaOnline;
import com.porto.portocom.portal.cliente.v1.exception.CadastroException;
import com.porto.portocom.portal.cliente.v1.exception.CpfCnpjInvalidoException;
import com.porto.portocom.portal.cliente.v1.exception.LexisNexisHeaderException;
import com.porto.portocom.portal.cliente.v1.exception.UsuarioPortalException;
import com.porto.portocom.portal.cliente.v1.integration.IPortoMSProdutoWebService;
import com.porto.portocom.portal.cliente.v1.repository.ITipoUsuarioRepository;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioPortalClienteRepository;
import com.porto.portocom.portal.cliente.v1.utils.TrataCpfCnpjUtils;
import com.porto.portocom.portal.cliente.v1.utils.ValidaCpfCnpjUtils;
import com.porto.portocom.portal.cliente.v1.vo.CpfCnpjVO;
import com.porto.portocom.portal.cliente.v1.vo.bcc.PessoaBccPF;
import com.porto.portocom.portal.cliente.v1.vo.bcc.PessoaBccPJ;
import com.porto.portocom.portal.cliente.v1.vo.produto.ConsultaProdutosProspect;
import com.porto.portocom.portal.cliente.v1.vo.usuario.CadastroUsuarioProspect;

import reactor.core.publisher.Mono;

@Service
public class ProspectService implements IProspectService {

	private static final Logger LOG = LoggerFactory.getLogger(ProspectService.class);
	private static final String MSG_STATUS_INVALIDO = "A conta não pode ser reativada devido ao seu status não ser: Excluída, Aguardando validação de cadastro ou Tentativa de cadastro";
	private static final String MSG_STATUS_PROPSECT = "Esta operação é permitida apenas para prospect.";

	private IPortoMSProdutoWebService produtoWebService;
	private IUsuarioPortalClienteRepository usuarioRepository;
	private IUsuarioPortalClienteService usuarioPortalClienteService;
	private ITipoUsuarioRepository tipoUsuarioRepository;
	private MensagemLocalCacheService mensagemLocalCacheService;

	@Autowired
	public ProspectService(IPortoMSProdutoWebService produtoWebService,
			IUsuarioPortalClienteRepository usuarioRepository, ITipoUsuarioRepository tipoUsuarioRepository,
			MensagemLocalCacheService mensagemLocalCacheService,
			IUsuarioPortalClienteService usuarioPortalClienteService) {
		this.produtoWebService = produtoWebService;
		this.usuarioRepository = usuarioRepository;
		this.tipoUsuarioRepository = tipoUsuarioRepository;
		this.mensagemLocalCacheService = mensagemLocalCacheService;
		this.usuarioPortalClienteService = usuarioPortalClienteService;
	}

	@Deprecated
	@Override
	public Mono<UsuarioPortalCliente> definirProspect(String cpfCnpj) {
		return this.consultar(cpfCnpj)
				.flatMap(usuarioPortal -> this.recuperaTipoUsuario(cpfCnpj).flatMap(tipoUsuario -> {

					usuarioPortal.setTipoUsuario(tipoUsuario);

					return Mono.just(usuarioRepository.save(usuarioPortal)).onErrorResume(error -> {
						LOG.error(error.getMessage(), error);
						return Mono.error(error);
					});
				})).switchIfEmpty(Mono.error(new UsuarioPortalException(
						MensagemUsuarioEnum.USUARIO_NAO_ENCONTRADO.getValor(), HttpStatus.NOT_FOUND.value())));

	}

	@Override
	public Mono<ConsultaProdutosProspect> consultaProdutosProspect(String cpfCnpj) {
		if (!ValidaCpfCnpjUtils.isValid(cpfCnpj)) {
			return Mono.error(new CpfCnpjInvalidoException(mensagemLocalCacheService
					.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_VALIDACAO_USUARIO_INVALIDO.getValor())));
		}

		return Mono.justOrEmpty(this.produtoWebService.consultaProdutosProspect(cpfCnpj)).onErrorResume(
				error -> Mono.error(new LexisNexisHeaderException("Erro ao consultar produtos do usuário",
						HttpStatus.INTERNAL_SERVER_ERROR.value())));
	}

	public Mono<UsuarioPortalCliente> consultar(String cpfCnpj) {
			return Mono.justOrEmpty(usuarioPortalClienteService.consultaPorCpfCnpj(cpfCnpj));
	}

	public Mono<TipoUsuario> recuperaTipoUsuario(String cpfCnpj) {
		return this.consultaProdutosProspect(cpfCnpj).map(produtos -> aplicaRegraProspect(produtos));
	}

	@Override
	public Mono<TipoUsuario> consultaProspect(String cpfCnpj) {
		return this.consultar(cpfCnpj).flatMap(usuarioPortal -> recuperaTipoUsuario(cpfCnpj)).switchIfEmpty(
				Mono.error(new UsuarioPortalException(MensagemUsuarioEnum.USUARIO_NAO_ENCONTRADO.getValor(),
						HttpStatus.NOT_FOUND.value())));
	}

	@Override
	@Deprecated
	public Mono<Boolean> cadastrarProspect(String cpfCnpj, CadastroUsuarioProspect usuarioProspect) {
		return definirProspect(cpfCnpj).flatMap(usuarioPortalCliente -> {
			if (verificaProspectStatusUsuario(usuarioPortalCliente)) {
				return Mono.just(reativarConta(usuarioProspect, usuarioPortalCliente));

			} else {
				return Mono.error(new CadastroException(MSG_STATUS_INVALIDO, 400));
			}
		}).onErrorResume(erroDefineProspect -> {
			if (erroDefineProspect instanceof UsuarioPortalException) {
				return consultaProspect(cpfCnpj).flatMap(prospect -> {
					if (prospect.getIdTipoUsuario() == 3 || prospect.getIdTipoUsuario() == 2
							|| prospect.getIdTipoUsuario() == 1) {
						return Mono.just(criarUsuario(cpfCnpj, usuarioProspect, prospect));
					} else {
						return Mono.error(new UsuarioPortalException(MSG_STATUS_PROPSECT, 400));
					}
				});

			} else if (erroDefineProspect instanceof CpfCnpjInvalidoException) {
				return Mono.error(new CpfCnpjInvalidoException(this.mensagemLocalCacheService
						.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_VALIDACAO_USUARIO_INVALIDO.getValor())));
			} else if (erroDefineProspect instanceof CadastroException) {
				return Mono.error(erroDefineProspect);
			} else {
				return Mono.just(Boolean.FALSE);
			}
		});
	}

	@Override
	public TipoUsuario aplicaRegraProspect(ConsultaProdutosProspect produtos) {
		List<Pessoa> contratoBcp = produtos.getContratosBcp();
		List<com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp.Pessoa> pessoaBcp = produtos.getPessoasBcp();
		CotacoesVendaOnline cotacaoVdo = produtos.getCotacoesVendaOnline();
		IsClienteArenaCadastrado isClienteArenaCadastrado = produtos.getIsClienteArenaCadastrado();
		PessoaBccPF pessoaBccPf = produtos.getPessoaBccPf();
		PessoaBccPJ pessoaBccPj = produtos.getPessoaBccPj();

		TipoUsuario tipoUsuario = new TipoUsuario();

		if (CollectionUtils.isNotEmpty(contratoBcp) && CollectionUtils.isNotEmpty(pessoaBcp)) {
			tipoUsuario = tipoUsuarioRepository.findByIdTipoUsuario(TipoUsuarioEnum.CLIENTE.getCodTipo());

		} else if (CollectionUtils.isEmpty(contratoBcp) && CollectionUtils.isNotEmpty(pessoaBcp)) {
			tipoUsuario = tipoUsuarioRepository.findByIdTipoUsuario(TipoUsuarioEnum.EX_CLIENTE.getCodTipo());

		} else if ((pessoaBccPf != null && CollectionUtils.isNotEmpty(pessoaBccPf.getPessoas()))
				|| (pessoaBccPj != null && CollectionUtils.isNotEmpty(pessoaBccPj.getPessoas()))) {
			tipoUsuario = tipoUsuarioRepository.findByIdTipoUsuario(TipoUsuarioEnum.PROSPECT_BCC.getCodTipo());

		} else if (isClienteArenaCadastrado != null && isClienteArenaCadastrado.getIsCadastrado() == null) {
			tipoUsuario = tipoUsuarioRepository.findByIdTipoUsuario(TipoUsuarioEnum.PROSPECT_CONQUISTA.getCodTipo());

		} else if (cotacaoVdo != null && cotacaoVdo.getCotacoesVendaOnline() != null
				&& CollectionUtils.isNotEmpty(cotacaoVdo.getCotacoesVendaOnline().getCotacaoVendaOnlineVO())) {
			tipoUsuario = tipoUsuarioRepository.findByIdTipoUsuario(TipoUsuarioEnum.PROSPECT_VENDA_ONLINE.getCodTipo());

		} else {
			tipoUsuario.setDescricaoTipoUsuario("Sem Relacionamento");
			tipoUsuario.setIdTipoUsuario(0L);
		}

		return tipoUsuario;
	}

	private Boolean reativarConta(CadastroUsuarioProspect usuarioProspect, UsuarioPortalCliente usuarioPortalCliente) {

		String celular = usuarioProspect.getCelular();
		Long dddUsuario = Long.parseLong(celular.substring(0, 2));
		Long celularUsuario = Long.parseLong(celular.substring(2, 11));
		String nomeUsuario = usuarioProspect.getNome();
		String emailUsuario = usuarioProspect.getEmail();

		UsuarioStatusConta statusUsuario = new UsuarioStatusConta();
		statusUsuario.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_TENTATIVA_CADASTRO.getCodStatus());

		usuarioPortalCliente.setNumDddCelular(dddUsuario);
		usuarioPortalCliente.setNumCelular(celularUsuario);
		usuarioPortalCliente.setQtdTentativaLogin(0L);
		usuarioPortalCliente.setQuantidadeTentativaCriacaoConta(0L);
		usuarioPortalCliente.setStatusUsuario(statusUsuario);
		usuarioPortalCliente.setNomeUsuarioPortal(nomeUsuario);
		usuarioPortalCliente.setDescEmail(emailUsuario);

		try {
			usuarioRepository.save(usuarioPortalCliente);
			return true;
		} catch (Exception e) {
			LOG.error("Erro ao reativar conta do usuário: {}", e);
			return false;
		}

	}

	private Boolean criarUsuario(String cpfCnpj, CadastroUsuarioProspect usuarioProspect, TipoUsuario tipoUsuario) {

		UsuarioPortalCliente usuarioPortalCliente = new UsuarioPortalCliente();

		CpfCnpjVO cpfCnpjVO = TrataCpfCnpjUtils.obterCpfCnpjFormatado(cpfCnpj);

		if (cpfCnpjVO.getCpfCnpjOrdem() == 0) {
			usuarioPortalCliente.setCodTipoPessoa("F");
		} else {
			usuarioPortalCliente.setCodTipoPessoa("J");
		}

		String celular = usuarioProspect.getCelular();
		Long dddUsuario = Long.parseLong(celular.substring(0, 2));
		Long celularUsuario = Long.parseLong(celular.substring(2, 11));
		String nomeUsuario = usuarioProspect.getNome();
		String emailUsuario = usuarioProspect.getEmail();

		UsuarioStatusConta statusUsuario = new UsuarioStatusConta();
		statusUsuario.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_TENTATIVA_CADASTRO.getCodStatus());

		usuarioPortalCliente.setTipoUsuario(tipoUsuario);
		usuarioPortalCliente.setCnpjCpf(cpfCnpjVO.getCpfCnpjNumero());
		usuarioPortalCliente.setCnpjCpfDigito(Long.valueOf(cpfCnpjVO.getCpfCnpjDigito()));
		usuarioPortalCliente
				.setCnpjOrdem(cpfCnpjVO.getCpfCnpjOrdem() != null ? Long.valueOf(cpfCnpjVO.getCpfCnpjOrdem()) : 0);
		usuarioPortalCliente.setNumDddCelular(dddUsuario);
		usuarioPortalCliente.setNumCelular(celularUsuario);
		usuarioPortalCliente.setQtdTentativaLogin(0L);
		usuarioPortalCliente.setQuantidadeTentativaCriacaoConta(0L);
		usuarioPortalCliente.setStatusUsuario(statusUsuario);
		usuarioPortalCliente.setNomeUsuarioPortal(nomeUsuario);
		usuarioPortalCliente.setDescEmail(emailUsuario);
		usuarioPortalCliente.setFlagValidacaoProduto("D");

		try {
			usuarioRepository.save(usuarioPortalCliente);
			return true;
		} catch (Exception e) {
			LOG.error("Erro ao criar usuário: {}", e);
			return false;
		}
	}

	private Boolean verificaProspectStatusUsuario(UsuarioPortalCliente usuarioPortalCliente) {
		return ((usuarioPortalCliente.getTipoUsuario().getIdTipoUsuario() == 3
				|| usuarioPortalCliente.getTipoUsuario().getIdTipoUsuario() == 2
				|| usuarioPortalCliente.getTipoUsuario().getIdTipoUsuario() == 1)
				&& (usuarioPortalCliente.getStatusUsuario()
						.getIdStatusConta() == StatusUsuarioEnum.STATUS_USUARIO_EXCLUIDO.getCodStatus()
						|| usuarioPortalCliente.getStatusUsuario()
								.getIdStatusConta() == StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_CONFIRMACAO
										.getCodStatus()
						|| usuarioPortalCliente.getStatusUsuario()
								.getIdStatusConta() == StatusUsuarioEnum.STATUS_USUARIO_TENTATIVA_CADASTRO
										.getCodStatus()));
	}

}
