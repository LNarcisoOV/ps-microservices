package com.porto.portocom.portal.cliente.v1.integration.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.constant.ChavesParamEnum;
import com.porto.portocom.portal.cliente.v1.constant.IntegracaoEnum;
import com.porto.portocom.portal.cliente.v1.exception.ConexaoException;
import com.porto.portocom.portal.cliente.v1.integration.IVendaOnlineWebService;
import com.porto.portocom.portal.cliente.v1.wsdl.vdo.VendaOnlinePesquisaCotacaoEndPointSoapBindingQSService;
import com.porto.portocom.portal.cliente.v1.wsdl.vdo.common.VendaOnlineResponse;

import reactor.core.publisher.Mono;

@Service
public class VendaOnlineFacade extends BaseFacade implements IVendaOnlineFacade {

	private static final Logger LOG = LoggerFactory.getLogger(VendaOnlineFacade.class);

	private IVendaOnlineWebService vendaOnlineWebService;

	private VendaOnlinePesquisaCotacaoEndPointSoapBindingQSService vendaOnlineService;

	@Autowired
	VendaOnlineFacade(IVendaOnlineWebService vendaOnlineWebService) {
		this.vendaOnlineWebService = vendaOnlineWebService;
	}



	private synchronized VendaOnlinePesquisaCotacaoEndPointSoapBindingQSService loadVendaOnlinePesquisaCotacaoWS() {
		
		try {
			if (vendaOnlineService == null) {

				vendaOnlineService = (VendaOnlinePesquisaCotacaoEndPointSoapBindingQSService) estabeleceConexao(
						ChavesParamEnum.PORTO_MS_PRODUTO_VENDA_ONLINE_WS_USUARIO.getValor(), 
						ChavesParamEnum.PORTO_MS_PRODUTO_VENDA_ONLINE_WS_SENHA.getValor(), IntegracaoEnum.VDO);
			} else {
				LOG.debug("Conexão com {} já foi estabelecida anteriormente.", IntegracaoEnum.VDO);
			}
		} catch (Exception e) {
			throw new ConexaoException(e.getMessage(), e);
		}
		return vendaOnlineService;
	}

	@Override
	public Mono<VendaOnlineResponse> pesquisaCotacoes(String cpfCnpj) {
		return Mono.just(loadVendaOnlinePesquisaCotacaoWS())
				.map(vendasOnlineWS -> this.vendaOnlineWebService.pesquisaCotacoesCache(cpfCnpj, vendasOnlineWS))
				.doOnSuccess(success -> {
					LOG.debug("pesquisaCotacoes - " + CACHE_REALIZADO_SUCESSO);
				}).onErrorResume(error -> {
					LOG.error(error.getMessage(), error);
					LOG.debug("pesquisaCotacoes - " + CACHE_NAO_REALIZADO_SUCESSO);
					return Mono.just(this.vendaOnlineWebService.pesquisaCotacoes(cpfCnpj, vendaOnlineService));
				});
	}


}
