package com.porto.portocom.portal.cliente.v1.integration.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.constant.ChavesParamEnum;
import com.porto.portocom.portal.cliente.v1.constant.IntegracaoEnum;
import com.porto.portocom.portal.cliente.v1.exception.ConexaoException;
import com.porto.portocom.portal.cliente.v1.integration.IConquistaWebService;
import com.porto.portocom.portal.cliente.v1.service.ParametrosLocalCacheService;
import com.porto.portocom.portal.cliente.v1.wsdl.conquista.CadastrarClienteArenaRequestType;
import com.porto.portocom.portal.cliente.v1.wsdl.conquista.CadastrarClienteArenaResponseType;
import com.porto.portocom.portal.cliente.v1.wsdl.conquista.ClienteArenaWSImplService;
import com.porto.portocom.portal.cliente.v1.wsdl.conquista.IsClienteCadastradoResponseType;

import reactor.core.publisher.Mono;

@Service
public class ConquistaFacade extends BaseFacade implements IConquistaFacade {

	private static final Logger LOG = LoggerFactory.getLogger(ConquistaFacade.class);

	private IConquistaWebService conquistaWebService;

	private ClienteArenaWSImplService clienteArenaWSImplService;

	@Autowired
	public ConquistaFacade(IConquistaWebService conquistaWebService, ParametrosLocalCacheService parametroLocal) {
		this.conquistaWebService = conquistaWebService;
	}



	private synchronized ClienteArenaWSImplService loadClienteArenaWSImplService() {
		
		try {
			if (clienteArenaWSImplService == null) {

				clienteArenaWSImplService = (ClienteArenaWSImplService) estabeleceConexao(ChavesParamEnum.PORTO_MS_PRODUTO_CONQUISTA_WS_USUARIO.getValor(),
						ChavesParamEnum.PORTO_MS_PRODUTO_CONQUISTA_WS_SENHA.getValor(), IntegracaoEnum.CONQUISTA);
			} else {
				LOG.debug("Conexão com {} já foi estabelecida anteriormente.", IntegracaoEnum.CONQUISTA);
			}
		} catch (Exception e) {
			throw new ConexaoException(e.getMessage(), e);
		}
		return clienteArenaWSImplService;
	}
	

	@Override
	public Mono<CadastrarClienteArenaResponseType> cadastrarClienteArena(
			CadastrarClienteArenaRequestType cadastrarClienteArena) {
		return Mono.just(loadClienteArenaWSImplService())
				.map(clienteArenaWS -> this.conquistaWebService.cadastrarClienteArena(cadastrarClienteArena, clienteArenaWS))
				.doOnSuccess(success -> LOG.debug("Cliente cadastrado: {}", success));
	}

	@Override
	public Mono<IsClienteCadastradoResponseType> isClienteArenaCadastrado(String cpfCnpj) {
		return Mono.just(loadClienteArenaWSImplService())
				.map(clienteArenaWS -> this.conquistaWebService.isClienteArenaCadastradoCache(cpfCnpj, clienteArenaWS))
				.doOnNext(success -> LOG.debug("isClienteArenaCadastrado -  {} - {}", cpfCnpj, CACHE_REALIZADO_SUCESSO))
				.onErrorResume(error -> {
					LOG.error(error.getMessage(), error);
					LOG.debug("isClienteArenaCadastrado -  {} - {} ", cpfCnpj, CACHE_NAO_REALIZADO_SUCESSO);
					return Mono.just(
							this.conquistaWebService.isClienteArenaCadastrado(cpfCnpj, clienteArenaWSImplService));
				});
	}
	
	@Override
	public Mono<IsClienteCadastradoResponseType> obterDadosClienteArenaCadastrado(String cpfCnpj) {
		return Mono.just(loadClienteArenaWSImplService())
				.map(clienteArenaWS -> this.conquistaWebService.obterDadosClienteArenaCadastradoCache(cpfCnpj, clienteArenaWS))
				.doOnNext(success -> LOG.debug("obterDadosClienteArenaCadastrado -  {} - {}", cpfCnpj, CACHE_REALIZADO_SUCESSO))
				.onErrorResume(error -> {
					LOG.error(error.getMessage(), error);
					LOG.debug("obterDadosClienteArenaCadastrado -  {} - {} ", cpfCnpj, CACHE_NAO_REALIZADO_SUCESSO);
					return Mono.just(
							this.conquistaWebService.obterDadosClienteArenaCadastrado(cpfCnpj, clienteArenaWSImplService));
				});
	}
}
