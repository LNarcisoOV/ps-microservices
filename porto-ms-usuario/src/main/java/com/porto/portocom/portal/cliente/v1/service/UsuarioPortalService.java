package com.porto.portocom.portal.cliente.v1.service;

import static org.apache.commons.lang3.StringUtils.EMPTY;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.TimeZone;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.porto.portocom.portal.cliente.entity.TipoUsuario;
import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.entity.UsuarioStatusConta;
import com.porto.portocom.portal.cliente.v1.constant.ChavesParamEnum;
import com.porto.portocom.portal.cliente.v1.constant.MensagemChaveEnum;
import com.porto.portocom.portal.cliente.v1.constant.MensagemUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.constant.StatusUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoFluxoEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp.Documentos;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp.Enderecos;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp.Pessoa;
import com.porto.portocom.portal.cliente.v1.dto.conquista.IsClienteArenaCadastrado;
import com.porto.portocom.portal.cliente.v1.dto.vdo.CotacoesVendaOnline;
import com.porto.portocom.portal.cliente.v1.exception.CpfCnpjInvalidoException;
import com.porto.portocom.portal.cliente.v1.exception.PortalException;
import com.porto.portocom.portal.cliente.v1.exception.UsuarioPortalException;
import com.porto.portocom.portal.cliente.v1.integration.facade.ILdapFacade;
import com.porto.portocom.portal.cliente.v1.model.TelefoneEmailVO;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioPortalClienteRepository;
import com.porto.portocom.portal.cliente.v1.repository.IUsuarioStatusContaRepository;
import com.porto.portocom.portal.cliente.v1.utils.AplicaMascaraUtil;
import com.porto.portocom.portal.cliente.v1.utils.LexisNexisUtils;
import com.porto.portocom.portal.cliente.v1.utils.TrataCpfCnpjUtils;
import com.porto.portocom.portal.cliente.v1.utils.ValidaCpfCnpjUtils;
import com.porto.portocom.portal.cliente.v1.vo.CpfCnpjVO;
import com.porto.portocom.portal.cliente.v1.vo.bcc.EnderecoEletronico;
import com.porto.portocom.portal.cliente.v1.vo.bcc.EnderecoPessoa.Endereco;
import com.porto.portocom.portal.cliente.v1.vo.bcc.PaisDomicilio;
import com.porto.portocom.portal.cliente.v1.vo.bcc.PessoaBccPF;
import com.porto.portocom.portal.cliente.v1.vo.bcc.PessoaBccPJ;
import com.porto.portocom.portal.cliente.v1.vo.bcc.Telefone;
import com.porto.portocom.portal.cliente.v1.vo.produto.ConsultaProdutosProspect;
import com.porto.portocom.portal.cliente.v1.vo.usuario.DadosAcessoVO;
import com.porto.portocom.portal.cliente.v1.vo.usuario.EnderecoVO;
import com.porto.portocom.portal.cliente.v1.vo.usuario.PessoaVO;
import com.porto.portocom.portal.cliente.v1.vo.usuario.TelefoneVO;
import com.porto.portocom.portal.cliente.v1.vo.usuario.TipoUsuarioVO;
import com.porto.portocom.portal.cliente.v1.vo.usuario.UsuarioSimplificado;
import com.porto.portocom.portal.cliente.v1.vo.usuario.UsuarioSimplificadoAtivacao;

import reactor.core.publisher.Mono;

@Service
public class UsuarioPortalService implements IUsuarioPortalService {

	private static final Logger LOG = LoggerFactory.getLogger(UsuarioPortalService.class);

	public static final Short COD_TITULAR = Short.valueOf("1");
	public static final Short COD_NAO_TITULAR = Short.valueOf("2");
	private static final Short COD_TIPO_TELEFONE_MOVEL_BCC = 1;
	private static final String PESSOA_JURIDICA = "J";
	private static final String COD_DDI = "55";
	private static final String HEADER_EXCEPTION_MESSAGE = "O Header corporativoRequestHeader não foi informado ou não foi encontrado.";

	private IUsuarioPortalClienteService usuarioPortalClienteService;
	private IUsuarioStatusContaRepository usuarioStatusContaRepository;
	private IUsuarioPortalClienteRepository usuarioRepository;
	private IProspectService prospectService;
	private ILogPortalClienteService logPortalClienteService;
	private LexisNexisUtils lexisNexisUtils;

	private MensagemLocalCacheService mensagemLocalCacheService;
	private ParametrosLocalCacheService parametrosLocalCacheService;

	@Autowired
	UsuarioPortalService(IUsuarioPortalClienteService usuarioPortalClienteService, ILdapFacade ldapFacade,
			MensagemLocalCacheService mensagemLocalCacheService,
			ParametrosLocalCacheService parametrosLocalCacheService,
			IUsuarioStatusContaRepository usuarioStatusContaRepository, IProspectService prospectService,
			ILogPortalClienteService logPortalClienteService, IUsuarioPortalClienteRepository usuarioRepository,
			LexisNexisUtils lexisNexisUtils) {
		this.usuarioPortalClienteService = usuarioPortalClienteService;
		this.mensagemLocalCacheService = mensagemLocalCacheService;
		this.parametrosLocalCacheService = parametrosLocalCacheService;
		this.usuarioStatusContaRepository = usuarioStatusContaRepository;
		this.prospectService = prospectService;
		this.logPortalClienteService = logPortalClienteService;
		this.usuarioRepository = usuarioRepository;
		this.lexisNexisUtils = lexisNexisUtils;
	}

	@Override
	public Mono<UsuarioPortalCliente> consultar(String cpfCnpj) {
		return Mono.justOrEmpty(usuarioPortalClienteService.consultaPorCpfCnpj(cpfCnpj));

	}

	@Override
	public Mono<List<UsuarioSimplificadoAtivacao>> consultaUsuarioSimplificado(String cpfCnpj,
			ConsultaProdutosProspect produtos) {

		if (!ValidaCpfCnpjUtils.isValid(cpfCnpj)) {
			return Mono.error(new CpfCnpjInvalidoException(mensagemLocalCacheService
					.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_VALIDACAO_USUARIO_INVALIDO.getValor())));
		}

		if (!lexisNexisUtils.verificaFlagLexis()) {
			return Mono.error(new PortalException(HEADER_EXCEPTION_MESSAGE, HttpStatus.BAD_REQUEST.value()));
		}

		if (produtos != null) {
			return defineTipoUsuarioByProdutos(produtos);
		} else {
			return prospectService.consultaProdutosProspect(cpfCnpj).flatMap(this::defineTipoUsuarioByProdutos);
		}
	}

	private Mono<List<UsuarioSimplificadoAtivacao>> defineTipoUsuarioByProdutos(ConsultaProdutosProspect produtos) {

		TipoUsuario tipoUsuario = prospectService.aplicaRegraProspect(produtos);

		if (tipoUsuario.getIdTipoUsuario().equals(TipoUsuarioEnum.CLIENTE.getCodTipo())
				|| tipoUsuario.getIdTipoUsuario().equals(TipoUsuarioEnum.EX_CLIENTE.getCodTipo())) {
			return this.obtemDadosClienteExCliente(produtos.getPessoasBcp(), tipoUsuario).flatMap(Mono::just);

		} else if (tipoUsuario.getIdTipoUsuario().equals(TipoUsuarioEnum.PROSPECT_BCC.getCodTipo())) {
			PessoaBccPF pessoaBccPf = produtos.getPessoaBccPf();
			PessoaBccPJ pessoaBccPj = produtos.getPessoaBccPj();

			return obtemPessoaBcc(pessoaBccPf, pessoaBccPj, tipoUsuario);

		} else if (tipoUsuario.getIdTipoUsuario().equals(TipoUsuarioEnum.PROSPECT_CONQUISTA.getCodTipo())) {
			String ddd = produtos.getIsClienteArenaCadastrado().getDddNumeroTelefone() != null
					? produtos.getIsClienteArenaCadastrado().getDddNumeroTelefone().toString()
					: null;

			UsuarioSimplificadoAtivacao usuarioSimplificado = montaObjetoUsuarioSimplificado(
					produtos.getIsClienteArenaCadastrado().getNomeCliente(),
					produtos.getIsClienteArenaCadastrado().getEmailCliente(),
					new TelefoneVO(ddd, produtos.getIsClienteArenaCadastrado().getNumeroTelefone()), tipoUsuario);

			return Mono.just(Arrays.asList(usuarioSimplificado));

		} else if (tipoUsuario.getIdTipoUsuario().equals(TipoUsuarioEnum.PROSPECT_VENDA_ONLINE.getCodTipo())) {
			String ddd = Objects.toString(produtos.getCotacoesVendaOnline().getDddCelular(), null) != null
					? produtos.getCotacoesVendaOnline().getDddCelular().toString()
					: null;

			String numeroTelefone = produtos.getCotacoesVendaOnline().getNumeroCelular() != null
					? produtos.getCotacoesVendaOnline().getNumeroCelular().toString()
					: null;

			UsuarioSimplificadoAtivacao usuarioSimplificado = montaObjetoUsuarioSimplificado(
					produtos.getCotacoesVendaOnline().getNomeProponente(), produtos.getCotacoesVendaOnline().getEmail(),
					new TelefoneVO(ddd, numeroTelefone), tipoUsuario);

			return Mono.just(Arrays.asList(usuarioSimplificado));

		} else {
			return Mono.error(new UsuarioPortalException(
					mensagemLocalCacheService
							.recuperaTextoMensagem(MensagemChaveEnum.COMMONS_ALERTA_USUARIO_NAO_ENCONTRADO.getValor()),
					HttpStatus.NOT_FOUND.value()));
		}
	}

	private Mono<List<UsuarioSimplificadoAtivacao>> obtemPessoaBcc(PessoaBccPF pessoaBccPf, PessoaBccPJ pessoaBccPj,
			TipoUsuario tipoUsuario) {

		if (pessoaBccPf != null && CollectionUtils.isNotEmpty(pessoaBccPf.getPessoas())) {
			PessoaBccPF.Pessoa pessoaPf = pessoaBccPf.getPessoas().get(0);

			TelefoneEmailVO telefoneEmailVo = obtemEmailETelefoneBCC(pessoaPf.getTelefones(),
					pessoaPf.getEnderecosEletronicos());

			String nome = StringUtils.isNotBlank(pessoaPf.getNomeTratamentoPessoaFisica())
					? pessoaPf.getNomeTratamentoPessoaFisica()
					: pessoaPf.getNomeLegalPessoa();

			return Mono.just(Arrays.asList(montaObjetoUsuarioSimplificado(nome, telefoneEmailVo.getEmail(),
					telefoneEmailVo.getTelefone(), tipoUsuario)));

		} else if (pessoaBccPj != null && CollectionUtils.isNotEmpty(pessoaBccPj.getPessoas())) {
			PessoaBccPJ.Pessoa pessoaPj = pessoaBccPj.getPessoas().get(0);

			TelefoneEmailVO telefoneEmailVo = obtemEmailETelefoneBCC(pessoaPj.getTelefones(),
					pessoaPj.getEnderecosEletronicos());

			return Mono.just(Arrays.asList(montaObjetoUsuarioSimplificado(pessoaPj.getNomeFantasiaPessoaJuridica(),
					telefoneEmailVo.getEmail(), telefoneEmailVo.getTelefone(), tipoUsuario)));
		}

		return null;
	}

	@Override
	public TelefoneEmailVO obtemEmailETelefoneBCC(List<Telefone> telefones, List<EnderecoEletronico> emails) {
		TelefoneEmailVO telefoneEmailVO = new TelefoneEmailVO();
		Short dddCelular = null;
		Long numeroTelefone = null;
		String tipoTelefone = null;

		if (CollectionUtils.isNotEmpty(emails) && StringUtils.isNotBlank(emails.get(0).getTextoEnderecoEletronico())) {
			telefoneEmailVO.setEmail(emails.get(0).getTextoEnderecoEletronico());
		}

		if (CollectionUtils.isNotEmpty(telefones)) {
			Telefone telefone = telefones.stream().filter(
					t -> t.getTipoLinhaTelefonica().getCodigoTipoLinhaTelefonica().equals(COD_TIPO_TELEFONE_MOVEL_BCC))
					.findFirst().orElse(null);

			if (telefone != null) {
				dddCelular = telefone.getCodigoDDDTelefone();
				numeroTelefone = telefone.getNumeroTelefone();
				tipoTelefone = telefone.getTipoFinalidadeTelefone() != null
						? telefone.getTipoFinalidadeTelefone().getNomeTipoFinalidadeTelefone()
						: null;
			}
			telefoneEmailVO.setTelefone(new TelefoneVO(Objects.toString(dddCelular, null),
					Objects.toString(numeroTelefone, null), tipoTelefone));
		}

		return telefoneEmailVO;
	}

	private UsuarioSimplificadoAtivacao montaObjetoUsuarioSimplificado(String nome, String email, TelefoneVO telefone,
			TipoUsuario tipoUsuario) {

		UsuarioSimplificadoAtivacao usuarioSimplificado = new UsuarioSimplificadoAtivacao();
		String nomeTratamento = "";

		if (StringUtils.isNotBlank(nome)) {
			if (tipoUsuario.getIdTipoUsuario().equals(TipoUsuarioEnum.CLIENTE.getCodTipo())
					|| tipoUsuario.getIdTipoUsuario().equals(TipoUsuarioEnum.EX_CLIENTE.getCodTipo())
					|| tipoUsuario.getIdTipoUsuario().equals(TipoUsuarioEnum.PROSPECT_BCC.getCodTipo())) {
				nomeTratamento = nome;
			} else {
				nomeTratamento = nome.split(" ")[0];
			}
		}

		usuarioSimplificado.setNome(StringUtils.capitalize(nomeTratamento));
		usuarioSimplificado.setEmails(AplicaMascaraUtil.formatarEmail(email));
		usuarioSimplificado.setCelulares(AplicaMascaraUtil.formatarCelular(telefone));
		usuarioSimplificado.setOrigemDados(tipoUsuario.getDescricaoTipoUsuario());
		usuarioSimplificado.setCodigoOrigemDados(tipoUsuario.getIdTipoUsuario());
		return usuarioSimplificado;
	}

	private Mono<List<UsuarioSimplificadoAtivacao>> obtemDadosClienteExCliente(List<Pessoa> pessoas,
			TipoUsuario tipoUsuario) {

		return this.obtemClienteTitular(pessoas).flatMap(pessoa -> {
			String email = "";
			TelefoneVO telefone = null;
			String nome = "";

			if (pessoa != null && CollectionUtils.isNotEmpty(pessoa.getEnderecosEletronicos())) {
				email = pessoa.getEnderecosEletronicos().get(0).getEnderecoEletronico();
			}

			if (pessoa != null && CollectionUtils.isNotEmpty(pessoa.getTelefones())) {
				String dddCelular = pessoa.getTelefones().get(0).getCodigoDdd() != null
						? pessoa.getTelefones().get(0).getCodigoDdd().toString()
						: null;

				String numeroTelefone = pessoa.getTelefones().get(0).getNumeroTelefone() != null
						? pessoa.getTelefones().get(0).getNumeroTelefone().toString()
						: null;
				telefone = new TelefoneVO(dddCelular, numeroTelefone);
			}

			if (pessoa.getCodigoTipoPessoa() != null) {
				nome = pessoa.getCodigoTipoPessoa().equals(PESSOA_JURIDICA) ? pessoa.getNomePessoa()
						: pessoa.getNomeTratamento();
			} else {
				nome = pessoa.getNomeTratamento();
			}

			UsuarioSimplificadoAtivacao usuario = montaObjetoUsuarioSimplificado(nome, email, telefone, tipoUsuario);

			return Mono.just(Arrays.asList(usuario));

		});
	}

	@Override
	public Mono<List<UsuarioSimplificado>> consultaUsuarioSimplificadoRecuperacao(String cpfCnpj) {

		UsuarioSimplificado usuarioSimplificadoBuilder = new UsuarioSimplificado();
		return this.consultar(cpfCnpj).flatMap(usuario -> {
			List<UsuarioSimplificado> usuarioSimplificado = new ArrayList<>();

			if (usuario != null
					&& usuario.getStatusUsuario().getIdStatusConta()
							.equals(StatusUsuarioEnum.STATUS_USUARIO_AGUARDANDO_PRIMEIRO_LOGIN.getCodStatus())
					|| usuario.getStatusUsuario().getIdStatusConta()
							.equals(StatusUsuarioEnum.STATUS_USUARIO_ATIVO.getCodStatus())
					|| usuario.getStatusUsuario().getIdStatusConta()
							.equals(StatusUsuarioEnum.STATUS_TENTATIVA_RECUPERACAO_CONTA.getCodStatus())) {

				if (!lexisNexisUtils.verificaFlagLexis()) {
					return Mono.error(new PortalException(HEADER_EXCEPTION_MESSAGE, HttpStatus.BAD_REQUEST.value()));
				}

				if (usuario.getNomeUsuarioPortal() != null) {
					usuarioSimplificadoBuilder.setNome(usuario.getNomeUsuarioPortal().split(" ")[0]);
				}

				TelefoneVO telefone = new TelefoneVO();
				if (usuario.getNumDddCelular() != null) {
					telefone.setDdd(usuario.getNumDddCelular().toString());
				}

				telefone.setNumeroTelefone(usuario.getNumCelular() != null ? usuario.getNumCelular().toString() : null);

				PessoaBcp.EnderecosEletronicos email = new PessoaBcp.EnderecosEletronicos();
				email.setEnderecoEletronico(usuario.getDescEmail());

				usuarioSimplificadoBuilder.setCelulares(AplicaMascaraUtil.formatarCelular(telefone));
				usuarioSimplificadoBuilder.setEmails(AplicaMascaraUtil.formatarEmail(email.getEnderecoEletronico()));
				usuarioSimplificado.add(usuarioSimplificadoBuilder);
				return Mono.just(usuarioSimplificado);

			} else {
				return Mono.error(new UsuarioPortalException(
						MensagemUsuarioEnum.USUARIO_INELEGIVEL_RECUPERACAO.getValor(), HttpStatus.BAD_REQUEST.value()));
			}

		}).switchIfEmpty(Mono.defer(() -> Mono.error(new UsuarioPortalException(
				mensagemLocalCacheService
						.recuperaTextoMensagem(MensagemChaveEnum.COMMONS_ALERTA_USUARIO_NAO_ENCONTRADO.getValor()),
				HttpStatus.NOT_FOUND.value()))));
	}

	@Override
	public Mono<UsuarioStatusConta> consultaStatus(String cpfCnpj) {
		return consultar(cpfCnpj).flatMap(usuario -> {

			long limiteTentatidaDeAcesso = Long.parseLong(parametrosLocalCacheService
					.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_TENTATIVAS_LOGIN.getValor()));
			long limiteTentativaAtivacao = Long.parseLong(parametrosLocalCacheService
					.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_TENTATIVAS_CRIACAO_CONTA.getValor()));
			long limiteTentativaRecuperacao = Long.parseLong(parametrosLocalCacheService
					.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_TENTATIVAS_RECUPERACAO.getValor()));

			long quantidadeTentativasAcessoUsuario = usuario.getQtdTentativaLogin() == null ? 0L
					: usuario.getQtdTentativaLogin();
			long quantidadeTentativasAtivacaoUsuario = usuario.getQuantidadeTentativaCriacaoConta() == null ? 0L
					: usuario.getQuantidadeTentativaCriacaoConta();
			long quantidadeTentativasRecuperacaoUsuario = usuario.getQuantidadeTentativasRecuperacaoConta() == null ? 0L
					: usuario.getQuantidadeTentativasRecuperacaoConta();

			UsuarioStatusConta usuarioStatusConta;

			if (quantidadeTentativasAcessoUsuario >= limiteTentatidaDeAcesso) {
				usuarioStatusConta = this.usuarioStatusContaRepository.findByIdStatusConta(
						StatusUsuarioEnum.STATUS_USUARIO_BLOQUEADO_TENTATIVA_ACESSO.getCodStatus());
				return Mono.just(usuarioStatusConta);
			}

			if (quantidadeTentativasAtivacaoUsuario >= limiteTentativaAtivacao) {
				usuarioStatusConta = this.usuarioStatusContaRepository.findByIdStatusConta(
						StatusUsuarioEnum.STATUS_USUARIO_BLOQUEADO_TENTATIVA_ATIVACAO_CONTA.getCodStatus());
				return Mono.just(usuarioStatusConta);
			}

			if (quantidadeTentativasRecuperacaoUsuario >= limiteTentativaRecuperacao) {
				usuarioStatusConta = this.usuarioStatusContaRepository.findByIdStatusConta(
						StatusUsuarioEnum.STATUS_USUARIO_BLOQUEADO_TENTATIVA_RECUPERACAO_CONTA.getCodStatus());
				return Mono.just(usuarioStatusConta);
			}

			return Mono.just(usuario.getStatusUsuario());

		}).switchIfEmpty(Mono.defer(() -> Mono.error(new UsuarioPortalException(
				mensagemLocalCacheService
						.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_VALIDACAO_USUARIO_INVALIDO.getValor()),
				HttpStatus.NOT_FOUND.value()))));
	}

	public UsuarioPortalCliente criaUsuarioPortalDePessoaVo(PessoaVO pessoaVo) {
		TipoUsuario tipoUsuario = new TipoUsuario();
		TipoUsuarioVO tipoUsuarioVo = pessoaVo.getTipoUsuario();
		String cpfCnpj = TrataCpfCnpjUtils.formatarCPFCNPJSemMascara(pessoaVo.getNumeroCpfCnpj(),
				pessoaVo.getNumeroOrdemCnpj(), pessoaVo.getDigitoCpfCnpj());
		tipoUsuario.setIdTipoUsuario(tipoUsuarioVo.getIdTipoUsuario());
		tipoUsuario.setDescricaoTipoUsuario(tipoUsuarioVo.getDescricaoTipoUsuario());
		tipoUsuario.setFlagTipoUsuario(tipoUsuarioVo.getFlagTipoUsuario());
		UsuarioPortalCliente usuarioPortal = new UsuarioPortalCliente();
		usuarioPortal.setCodTipoPessoa(TrataCpfCnpjUtils.obterTipoPessoa(cpfCnpj));
		usuarioPortal.setDataCadastro(new Date());
		usuarioPortal.setFlgConfEnvEmail("S");
		usuarioPortal.setQtdTentativaLogin(0L);
		usuarioPortal.setQuantidadeAcessoLogin(0L);
		usuarioPortal.setQuantidadeTentativaCriacaoConta(0L);
		usuarioPortal.setQuantidadeTentativasRecuperacaoConta(0L);
		UsuarioStatusConta statusConta = new UsuarioStatusConta();
		statusConta.setIdStatusConta(StatusUsuarioEnum.STATUS_USUARIO_TENTATIVA_CADASTRO.getCodStatus());
		usuarioPortal.setStatusUsuario(statusConta);
		usuarioPortal.setNomeUsuarioPortal(pessoaVo.getNome());
		usuarioPortal.setDataNascimento(pessoaVo.getDataNascimento());
		usuarioPortal.setTipoUsuario(tipoUsuario);
		usuarioPortal.setFlagValidacaoProduto(tipoUsuarioVo.getFlagTipoUsuario());

		defineDadosCadastro(pessoaVo, usuarioPortal);
		return usuarioPortal;
	}

	public UsuarioPortalCliente alteraUsuarioPortal(PessoaVO pessoaVo, UsuarioPortalCliente usuarioPortal,
			TipoFluxoEnum tipoCadastro) {
		TipoUsuario tipoUsuario = new TipoUsuario();
		TipoUsuarioVO tipoUsuarioVo = pessoaVo.getTipoUsuario();
		tipoUsuario.setIdTipoUsuario(tipoUsuarioVo.getIdTipoUsuario());
		tipoUsuario.setDescricaoTipoUsuario(tipoUsuarioVo.getDescricaoTipoUsuario());
		tipoUsuario.setFlagTipoUsuario(tipoUsuarioVo.getFlagTipoUsuario());

		if (usuarioPortal.getStatusUsuario().getIdStatusConta()
				.equals(StatusUsuarioEnum.STATUS_USUARIO_EXCLUIDO.getCodStatus())) {
			usuarioPortal.setQtdTentativaLogin(0L);
			usuarioPortal.setQuantidadeTentativaCriacaoConta(0L);
			usuarioPortal.setQuantidadeTentativasRecuperacaoConta(0L);
		}
		usuarioPortal.setTipoUsuario(tipoUsuario);
		if (tipoCadastro != null && tipoCadastro.equals(TipoFluxoEnum.SIMPLES)) {
			defineDadosCadastro(pessoaVo, usuarioPortal);
		}
		return usuarioPortal;
	}

	private void defineDadosCadastro(PessoaVO pessoaVo, UsuarioPortalCliente usuarioPortal) {
		usuarioPortal.setCnpjCpf(pessoaVo.getNumeroCpfCnpj());
		usuarioPortal.setCnpjCpfDigito(pessoaVo.getDigitoCpfCnpj());
		usuarioPortal.setCnpjOrdem(pessoaVo.getNumeroOrdemCnpj() != null ? pessoaVo.getNumeroOrdemCnpj() : 0);

		if (CollectionUtils.isNotEmpty(pessoaVo.getTelefones())) {
			TelefoneVO telefone = pessoaVo.getTelefones().get(0);
			usuarioPortal.setNumDddCelular(telefone.getDdd() != null ? NumberUtils.toLong(telefone.getDdd()) : null);
			usuarioPortal.setNumCelular(
					telefone.getNumeroTelefone() != null ? NumberUtils.toLong(telefone.getNumeroTelefone()) : null);
		}

		if (CollectionUtils.isNotEmpty(pessoaVo.getEmails()) && StringUtils.isNotBlank(pessoaVo.getEmails().get(0))) {
			usuarioPortal.setDescEmail(pessoaVo.getEmails().get(0));

		} else {
			usuarioPortal.setDescEmail(" ");
		}
	}

	@Override
	public Mono<UsuarioPortalCliente> consultarUsuarioPorId(Long id) {
		try {

			Optional<UsuarioPortalCliente> optUsuarioPortalCliente = this.usuarioRepository.findById(id);
			if (optUsuarioPortalCliente.isPresent()) {
				UsuarioPortalCliente usuarioPortalCliente = optUsuarioPortalCliente.get();
				return Mono.just(usuarioPortalCliente);
			}

			return Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, this.mensagemLocalCacheService
					.recuperaTextoMensagem(MensagemChaveEnum.COMMONS_ALERTA_USUARIO_NAO_ENCONTRADO.getValor())));

		} catch (Exception erroGenerico) {
			return Mono.error(erroGenerico);
		}
	}

	public Mono<Pessoa> obtemClienteTitular(final List<Pessoa> listaPessoas) {

		Pessoa toReturn = null;

		// 1 - Titular do CPF/CNPJ/RNE (Usar como titular) 2 - No o titular 3
		// - No identificado
		if (listaPessoas != null && !listaPessoas.isEmpty()) {
			if (listaPessoas.size() == 1) {
				toReturn = listaPessoas.get(0);
			} else {
				loopPessoa: for (final Pessoa pessoa : listaPessoas) {

					final List<Documentos> listaDocumentos = pessoa.getDocumentos();

					for (final Documentos documento : listaDocumentos) {
						if (COD_TITULAR.equals(documento.getFlagPessoaTitularDocumento())) {
							toReturn = pessoa;
							break loopPessoa;
						} else if (COD_NAO_TITULAR.equals(documento.getFlagPessoaTitularDocumento())) {
							// caso ja tenha um cliente com codigo '0' continua
							if (toReturn != null) {
								continue;
							}
							toReturn = pessoa;
						}
					}
				}
				// no encontrou '1' ou '2' obtem o primeiro da lista
				if (toReturn == null) {
					toReturn = listaPessoas.get(0);
				}
			}
		}

		if (toReturn != null) {
			return Mono.just(toReturn);
		} else {
			return Mono.empty();
		}
	}

	@Override
	public Mono<UsuarioPortalCliente> salvar(UsuarioPortalCliente usuario) {
		return Mono.justOrEmpty(usuarioRepository.save(usuario));
	}

	@Override
	public Mono<DadosAcessoVO> consultarDadosAcesso(String cpfCnpj) {
		return this.consultar(cpfCnpj)
				.switchIfEmpty(Mono.defer(() -> Mono.error(new UsuarioPortalException(
						mensagemLocalCacheService
								.recuperaTextoMensagem(MensagemChaveEnum.USUARIO_VALIDACAO_USUARIO_INVALIDO.getValor()),
						HttpStatus.NOT_FOUND.value()))))
				.flatMap(usuarioPortal -> {
					LocalDateTime dataEmail = logPortalClienteService.getMaxEmailLogData(usuarioPortal.getIdUsuario());
					LocalDateTime dataCelular = logPortalClienteService
							.getMaxCelularLogData(usuarioPortal.getIdUsuario());
					LocalDateTime dataCadastro = null;
					DadosAcessoVO dadosAcessoVO = new DadosAcessoVO();

					dadosAcessoVO.setEmail(usuarioPortal.getDescEmail() != null ? usuarioPortal.getDescEmail() : EMPTY);
					if (usuarioPortal.getNumDddCelular() != null && usuarioPortal.getNumCelular() != null) {
						dadosAcessoVO
								.setCelular(COD_DDI + usuarioPortal.getNumDddCelular() + usuarioPortal.getNumCelular());
					} else {
						dadosAcessoVO.setCelular(EMPTY);
					}
					if (usuarioPortal.getDataCadastro() != null) {
						dataCadastro = Instant.ofEpochMilli(usuarioPortal.getDataCadastro().getTime())
								.atZone(TimeZone.getDefault().toZoneId()).toLocalDateTime();
					}
					if (dataEmail == null || (dataCadastro != null && dataEmail.isBefore(dataCadastro))) {
						dadosAcessoVO.setDataHoraAtualizacaoEmail(dataCadastro);
					} else {
						dadosAcessoVO.setDataHoraAtualizacaoEmail(dataEmail);
					}
					if (dataCelular == null || (dataCadastro != null && dataCelular.isBefore(dataCadastro))) {
						dadosAcessoVO.setDataHoraAtualizacaoCelular(dataCadastro);
					} else {
						dadosAcessoVO.setDataHoraAtualizacaoCelular(dataCelular);
					}
					return Mono.just(dadosAcessoVO);
				});
	}

	public Mono<PessoaVO> obtemPessoaPorProdutos(ConsultaProdutosProspect produtos, String cpfCnpj) {

		TipoUsuario tipoUsuario = prospectService.aplicaRegraProspect(produtos);
		TipoUsuarioVO tipoUsuarioVo = new TipoUsuarioVO(tipoUsuario.getIdTipoUsuario(),
				tipoUsuario.getDescricaoTipoUsuario(), tipoUsuario.getFlagTipoUsuario());
		Long idTipoUsuario = tipoUsuario.getIdTipoUsuario();
		CpfCnpjVO cpfCnpjVo = TrataCpfCnpjUtils.obterCpfCnpjFormatado(cpfCnpj);

		if (idTipoUsuario.equals(TipoUsuarioEnum.CLIENTE.getCodTipo())
				|| idTipoUsuario.equals(TipoUsuarioEnum.EX_CLIENTE.getCodTipo())) {

			return this.obtemPessoaBcp(produtos, tipoUsuarioVo, cpfCnpjVo);

		} else if (idTipoUsuario.equals(TipoUsuarioEnum.PROSPECT_BCC.getCodTipo())) {
			PessoaBccPF pessoaBccPf = produtos.getPessoaBccPf();
			PessoaBccPJ pessoaBccPj = produtos.getPessoaBccPj();

			return this.obtemPessoaBcc(pessoaBccPf, pessoaBccPj, tipoUsuarioVo, cpfCnpjVo);

		} else if (idTipoUsuario.equals(TipoUsuarioEnum.PROSPECT_CONQUISTA.getCodTipo())) {
			IsClienteArenaCadastrado clienteArena = produtos.getIsClienteArenaCadastrado();

			LocalDateTime dataNascimento = clienteArena.getDataNascimento() != null
					? clienteArena.getDataNascimento().toGregorianCalendar().toZonedDateTime().toLocalDateTime()
					: null;

			Date dataNascimentoFormatada = dataNascimento != null
					? Date.from(dataNascimento.atZone(TimeZone.getDefault().toZoneId()).toInstant())
					: null;

			TelefoneVO telefoneVO = new TelefoneVO(Objects.toString(clienteArena.getDddNumeroTelefone(), null),
					clienteArena.getNumeroTelefone());

			EnderecoVO enderecoVo = new EnderecoVO();
			enderecoVo.setCep(clienteArena.getCep());
			enderecoVo.setEstado(clienteArena.getEstado());
			enderecoVo.setNumeroResidencial(clienteArena.getNumeroEnderecoResidencial());

			return Mono.just(montaPessoaVo(cpfCnpjVo, clienteArena.getNomeCliente(), dataNascimentoFormatada,
					clienteArena.getEmailCliente(), telefoneVO, tipoUsuarioVo, enderecoVo));

		} else if (idTipoUsuario.equals(TipoUsuarioEnum.PROSPECT_VENDA_ONLINE.getCodTipo())) {
			CotacoesVendaOnline clienteVdo = produtos.getCotacoesVendaOnline();

			LocalDateTime dataNascimento = clienteVdo.getDataNascimentoCliente() != null
					? clienteVdo.getDataNascimentoCliente().toGregorianCalendar().toZonedDateTime().toLocalDateTime()
					: null;

			Date dataNascimentoFormatada = dataNascimento != null
					? Date.from(dataNascimento.atZone(TimeZone.getDefault().toZoneId()).toInstant())
					: null;

			TelefoneVO telefoneVO = new TelefoneVO(Objects.toString(clienteVdo.getDddCelular(), null),
					Objects.toString(clienteVdo.getNumeroCelular(), null));

			return Mono.just(montaPessoaVo(cpfCnpjVo, clienteVdo.getNomeProponente(), dataNascimentoFormatada,
					clienteVdo.getEmail(), telefoneVO, tipoUsuarioVo, new EnderecoVO()));
		}

		else {
			return Mono.error(new UsuarioPortalException(
					mensagemLocalCacheService
							.recuperaTextoMensagem(MensagemChaveEnum.COMMONS_ALERTA_USUARIO_NAO_ENCONTRADO.getValor()),
					HttpStatus.NOT_FOUND.value()));
		}
	}

	private PessoaVO montaPessoaVo(CpfCnpjVO cpfCnpjVo, String nome, Date dataNascimento, String email,
			TelefoneVO telefoneVO, TipoUsuarioVO tipoUsuarioVo, EnderecoVO enderecoVo) {

		PessoaVO pessoaVo = new PessoaVO();

		pessoaVo.setTipoUsuario(tipoUsuarioVo);
		pessoaVo.setDigitoCpfCnpj(
				cpfCnpjVo.getCpfCnpjDigito() != null ? cpfCnpjVo.getCpfCnpjDigito().longValue() : null);
		pessoaVo.setNumeroCpfCnpj(cpfCnpjVo.getCpfCnpjNumero());
		pessoaVo.setNumeroOrdemCnpj(
				cpfCnpjVo.getCpfCnpjOrdem() != null ? cpfCnpjVo.getCpfCnpjOrdem().longValue() : null);
		pessoaVo.setNome(nome != null ? nome : StringUtils.EMPTY);
		pessoaVo.setDataNascimento(dataNascimento);
		pessoaVo.setEmails(email != null ? Arrays.asList(email) : null);
		pessoaVo.setTelefones(telefoneVO != null ? Arrays.asList(telefoneVO) : null);
		pessoaVo.setEndereco(enderecoVo);

		return pessoaVo;
	}

	private Mono<PessoaVO> obtemPessoaBcc(PessoaBccPF pessoaBccPf, PessoaBccPJ pessoaBccPj, TipoUsuarioVO tipoUsuarioVo,
			CpfCnpjVO cpfCnpjVo) {

		Date dataNascimento = null;
		EnderecoVO enderecoVo = null;

		if (pessoaBccPf != null && CollectionUtils.isNotEmpty(pessoaBccPf.getPessoas())) {
			PessoaBccPF.Pessoa pessoaPf = pessoaBccPf.getPessoas().get(0);

			TelefoneEmailVO telefoneEmailVO = this.obtemEmailETelefoneBCC(pessoaPf.getTelefones(),
					pessoaPf.getEnderecosEletronicos());

			if (pessoaPf.getDataNascimentoPessoaFisica() != null) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

				try {
					dataNascimento = simpleDateFormat.parse(pessoaPf.getDataNascimentoPessoaFisica());
				} catch (ParseException e) {
					LOG.error(e.getMessage(), e);
				}
			}

			if (CollectionUtils.isNotEmpty(pessoaPf.getEnderecos())) {
				Endereco endereco = pessoaPf.getEnderecos().get(0);
				enderecoVo = montaEnderecoVoBCC(endereco, pessoaBccPf.getPessoas().get(0).getPaisDomicilio());
			}

			return Mono.just(montaPessoaVo(cpfCnpjVo, pessoaPf.getNomeLegalPessoa(), dataNascimento,
					telefoneEmailVO.getEmail(), telefoneEmailVO.getTelefone(), tipoUsuarioVo, enderecoVo));

		} else if (pessoaBccPj != null && CollectionUtils.isNotEmpty(pessoaBccPj.getPessoas())) {
			PessoaBccPJ.Pessoa pessoaPj = pessoaBccPj.getPessoas().get(0);

			TelefoneEmailVO telefoneEmailVO = this.obtemEmailETelefoneBCC(pessoaPj.getTelefones(),
					pessoaPj.getEnderecosEletronicos());

			if (CollectionUtils.isNotEmpty(pessoaPj.getEnderecos())) {
				Endereco endereco = pessoaPj.getEnderecos().get(0);
				enderecoVo = montaEnderecoVoBCC(endereco, pessoaBccPj.getPessoas().get(0).getPaisDomicilio());
			}

			return Mono.just(montaPessoaVo(cpfCnpjVo, pessoaPj.getNomeFantasiaPessoaJuridica(), null,
					telefoneEmailVO.getEmail(), telefoneEmailVO.getTelefone(), tipoUsuarioVo, enderecoVo));
		}

		return null;
	}

	private EnderecoVO montaEnderecoVoBCC(Endereco endereco, PaisDomicilio pais) {
		EnderecoVO enderecoVo = new EnderecoVO();
		enderecoVo.setTipoLogradouro(endereco.getLogradouro().getTipoLogradouro().getNomeTipoLogradouro());
		enderecoVo.setLogradouro(endereco.getLogradouro().getNomeLogradouro());
		enderecoVo.setNumeroResidencial(Objects.toString(endereco.getNumeroImovelLogradouroEndereco(), null));
		enderecoVo.setComplemento(endereco.getDescricaoComplementoEndereco());
		enderecoVo.setBairro(endereco.getLogradouro().getBairro().getNomeBairro());
		enderecoVo.setCidade(endereco.getLogradouro().getLocalidade().getNomeLocalidade());
		enderecoVo.setCep(Objects.toString(endereco.getLogradouro().getNumeroCepLogradouro(), "")
				.concat(Objects.toString(endereco.getLogradouro().getNumeroCepComplementoLogradouro(), "")));
		enderecoVo.setEstado(endereco.getLogradouro().getLocalidade().getEstado().getSiglaEstado());
		enderecoVo.setPais(pais.getCodigoPaisIsoTresLetras());
		return enderecoVo;
	}

	private Mono<PessoaVO> obtemPessoaBcp(ConsultaProdutosProspect produtos, TipoUsuarioVO tipoUsuarioVo,
			CpfCnpjVO cpfCnpj) {

		return this.obtemClienteTitular(produtos.getPessoasBcp()).flatMap(pessoaBcp -> {
			String email = null;
			Date dataNascimentoFormatada = null;
			TelefoneVO telefoneVO = null;
			EnderecoVO enderecoVo = new EnderecoVO();
			PessoaVO pessoaVo = new PessoaVO();
			List<Enderecos> enderecos = pessoaBcp.getEnderecos();

			if (pessoaBcp.getFisica() != null) {
				LocalDateTime dataNascimento = pessoaBcp.getFisica().getDataNascimento() != null ? pessoaBcp.getFisica()
						.getDataNascimento().toGregorianCalendar().toZonedDateTime().toLocalDateTime() : null;

				dataNascimentoFormatada = dataNascimento != null
						? Date.from(dataNascimento.atZone(TimeZone.getDefault().toZoneId()).toInstant())
						: null;
			}

			if (CollectionUtils.isNotEmpty(pessoaBcp.getEnderecosEletronicos())
					&& StringUtils.isNotBlank(pessoaBcp.getEnderecosEletronicos().get(0).getEnderecoEletronico())) {
				email = pessoaBcp.getEnderecosEletronicos().get(0).getEnderecoEletronico();
			}

			if (CollectionUtils.isNotEmpty(pessoaBcp.getTelefones())) {
				Short dddCelular = pessoaBcp.getTelefones().get(0).getCodigoDdd();

				Long numeroTelefone = pessoaBcp.getTelefones().get(0).getNumeroTelefone();

				telefoneVO = new TelefoneVO(Objects.toString(dddCelular, null), Objects.toString(numeroTelefone, null),
						pessoaBcp.getTelefones().get(0).getDescricaoTipoTelefone());
			}

			if (CollectionUtils.isNotEmpty(enderecos)) {
				Enderecos endereco = enderecos.get(0);
				enderecoVo.setTipoLogradouro(endereco.getNomeTipoLogradouro());
				enderecoVo.setLogradouro(endereco.getNomeLogradouro());
				enderecoVo.setNumeroResidencial(endereco.getNumeroLogradouro());
				enderecoVo.setComplemento(endereco.getComplementoEndereco());
				enderecoVo.setBairro(endereco.getNomeBairro());
				enderecoVo.setCidade(endereco.getNomeCidade());
				StringBuilder cep = new StringBuilder();
				if (endereco.getNumeroInicioCep() != null && endereco.getNumeroComplementoCep() != null) {
					cep.append(String.format("%05d", endereco.getNumeroInicioCep()));
					cep.append("-").append(String.format("%03d", endereco.getNumeroComplementoCep()));
				}
				enderecoVo.setCep(cep.toString());
				enderecoVo.setEstado(endereco.getCodigoUnidadeFederacao());
				enderecoVo.setPais(endereco.getSiglaPais());
			}

			pessoaVo = montaPessoaVo(cpfCnpj, pessoaBcp.getNomePessoa(), dataNascimentoFormatada, email, telefoneVO,
					tipoUsuarioVo, enderecoVo);

			return Mono.just(pessoaVo);
		});
	}
}
