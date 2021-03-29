package com.porto.portocom.portal.cliente.v1.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.constant.ConstantesEnum;
import com.porto.portocom.portal.cliente.v1.utils.TrataCpfCnpjUtils;
import com.porto.portocom.portal.cliente.v1.utils.ValidaCpfCnpjUtils;
import com.porto.portocom.portal.cliente.v1.vo.bcc.PessoaBccPF;
import com.porto.portocom.portal.cliente.v1.vo.bcc.PessoaBccPJ;
import com.porto.portocom.portal.cliente.v1.vo.produto.ConsultaProdutosProspect;
import com.porto.portocom.portal.cliente.v1.vo.produto.ConsultaProdutosProspect.ConsultaProdutosProspectBuilder;

import reactor.core.publisher.Mono;

@Service
public class ProdutoService implements IProdutoService {

	private IVendaOnlineService vendaOnlineService;

	private IBcpService bcpService;

	private IConquistaService conquistaService;

	private IBCCService bccService;
	
	private static final String PESSOA_FISICA = "F";

	@Autowired
	public ProdutoService(IVendaOnlineService vendaOnlineService, IBcpService bcpService,
			IConquistaService conquistaService, IBCCService bccService) {
		this.vendaOnlineService = vendaOnlineService;
		this.bcpService = bcpService;
		this.conquistaService = conquistaService;
		this.bccService = bccService;
	}

	@Override
	public Mono<ConsultaProdutosProspect> consultaProdutosProspect(String cpfCnpj) {
		if (ValidaCpfCnpjUtils.isValid(cpfCnpj)) {
			ConsultaProdutosProspectBuilder builder = ConsultaProdutosProspect.builder();
			return pesquisaCotacoesVendaOnline(cpfCnpj, builder).flatMap(cotacoes -> {
				return consultaContratosBcp(cpfCnpj, builder).flatMap(contratos -> {
					return consultaPessoasBcp(cpfCnpj, builder).flatMap(pessoas -> {
						return consultaCadastroConquista(cpfCnpj, builder).flatMap(cadastro -> {
							return consultaCadastroBcc(cpfCnpj, builder).map(pessoasBCC -> {
								return builder.build();
							});
						});
					});
				});
			});

		} else {
			return Mono.error(new Error(ConstantesEnum.CPF_CNPJ_INVALIDO.getDescricao()));
		}
	}

	private Mono<ConsultaProdutosProspectBuilder> pesquisaCotacoesVendaOnline(final String cpfCnpj,
			ConsultaProdutosProspectBuilder builder) {

		return this.vendaOnlineService.pesquisaCotacoes(cpfCnpj).map(cotacoes -> {
			builder.cotacoesVendaOnline(cotacoes);
			return builder;
		});
	}

	private Mono<ConsultaProdutosProspectBuilder> consultaContratosBcp(final String cpfCnpj,
			ConsultaProdutosProspectBuilder builder) {

		return this.bcpService.consultarContratos(cpfCnpj).map(contratos -> {
			builder.contratosBcp(contratos);
			return builder;
		});
	}

	private Mono<ConsultaProdutosProspectBuilder> consultaPessoasBcp(final String cpfCnpj,
			ConsultaProdutosProspectBuilder builder) {

		return this.bcpService.consultarPessoas(cpfCnpj).map(pessoas -> {
			builder.pessoasBcp(pessoas);
			return builder;
		});
	}

	private Mono<ConsultaProdutosProspectBuilder> consultaCadastroConquista(final String cpfCnpj,
			ConsultaProdutosProspectBuilder builder) {

		return this.conquistaService.obterDadosClienteArenaCadastrado(cpfCnpj).map(cadastro -> {
			builder.isClienteArenaCadastrado(cadastro);
			return builder;
		});
	}

	private Mono<ConsultaProdutosProspectBuilder> consultaCadastroBcc(final String cpfCnpj,
			ConsultaProdutosProspectBuilder builder) {

		String tipoPessoa = TrataCpfCnpjUtils.obterTipoPessoa(cpfCnpj);
		
		if (tipoPessoa.equals(PESSOA_FISICA)) {
			PessoaBccPJ pessoaBccPjVazio = new PessoaBccPJ();
			pessoaBccPjVazio.setPessoas(new ArrayList<PessoaBccPJ.Pessoa>());
			return this.bccService.consultaPFBCC(cpfCnpj).map(pessoasBccPf -> {
				builder.pessoaBccPf(pessoasBccPf);
				builder.pessoaBccPj(pessoaBccPjVazio);
				return builder;
			});

		} else {
			PessoaBccPF pessoaBccPfVazio = new PessoaBccPF();
			pessoaBccPfVazio.setPessoas(new ArrayList<PessoaBccPF.Pessoa>());
			return this.bccService.consultaPJBCC(cpfCnpj).map(pessoasBccPj -> {
				builder.pessoaBccPj(pessoasBccPj);
				builder.pessoaBccPf(pessoaBccPfVazio);
				return builder;
			});
		}
	}
}
