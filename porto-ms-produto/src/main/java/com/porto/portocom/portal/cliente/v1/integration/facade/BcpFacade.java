package com.porto.portocom.portal.cliente.v1.integration.facade;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.constant.ChavesParamEnum;
import com.porto.portocom.portal.cliente.v1.constant.IntegracaoEnum;
import com.porto.portocom.portal.cliente.v1.exception.ConexaoException;
import com.porto.portocom.portal.cliente.v1.integration.IBcpWebService;
import com.porto.portocom.portal.cliente.v1.wsdl.bcp.ConsultaDadosBCPWS_Service;
import com.porto.portocom.portal.cliente.v1.wsdl.bcp.ObterContratoResponseType;
import com.porto.portocom.portal.cliente.v1.wsdl.bcp.ObterPessoasResponseType;

import reactor.core.publisher.Mono;

@Service
public class BcpFacade extends BaseFacade implements IBcpFacade {

	private static final Logger LOG = LoggerFactory.getLogger(BcpFacade.class);

	private ConsultaDadosBCPWS_Service consultaDadosBCPWSService;

	private IBcpWebService bcpWebService;

	@Autowired
	BcpFacade(IBcpWebService bcpWebService) {
		this.bcpWebService = bcpWebService;
	}

	
	private synchronized ConsultaDadosBCPWS_Service loadConsultaDadosWS() {
		
		try {
			if (consultaDadosBCPWSService == null) {

				consultaDadosBCPWSService = (ConsultaDadosBCPWS_Service) estabeleceConexao(ChavesParamEnum.PORTO_MS_PRODUTO_BCP_WS_USUARIO.getValor(),
						ChavesParamEnum.PORTO_MS_PRODUTO_BCP_WS_SENHA.getValor(), IntegracaoEnum.BCP);
			} else {
				LOG.debug("Conexão com {} já foi estabelecida anteriormente.", IntegracaoEnum.BCP);
			}
		} catch (Exception e) {
			throw new ConexaoException(e.getMessage(), e);
		}
		return consultaDadosBCPWSService;
	}
	
	
	
	@Override
	public Mono<List<ObterContratoResponseType.Pessoa>> contratosBcp(final String cpfCnpj) {
		return Mono.justOrEmpty(loadConsultaDadosWS()).map(consultaDadosBCPWS -> this.bcpWebService.obterContratosCache(cpfCnpj, consultaDadosBCPWS))
				.doOnNext(sucesso -> LOG.debug("ContratosBcp - {}" , CACHE_REALIZADO_SUCESSO)).onErrorResume(error -> {
					LOG.error(error.getMessage(), error);
					LOG.debug("ContratosBcp - {}" , CACHE_NAO_REALIZADO_SUCESSO);
					return Mono.justOrEmpty(this.bcpWebService.obterContratos(cpfCnpj, consultaDadosBCPWSService));
				});
	}

	@Override
	public Mono<List<ObterPessoasResponseType.Pessoa>> pessoasBcp(String cpfCnpj) {
		return Mono.justOrEmpty(loadConsultaDadosWS()).map(consultaDadosBCPWS -> this.bcpWebService.obterPessoasCache(cpfCnpj, consultaDadosBCPWS))
				.doOnNext(success -> LOG.debug("PessoasBcp - {}" , CACHE_REALIZADO_SUCESSO)).onErrorResume(error -> {
					LOG.error(error.getMessage(), error);
					LOG.debug("PessoasBcp - {} " , CACHE_NAO_REALIZADO_SUCESSO);
					return Mono.justOrEmpty(this.bcpWebService.obterPessoas(cpfCnpj, consultaDadosBCPWSService));
				});
	}
}
