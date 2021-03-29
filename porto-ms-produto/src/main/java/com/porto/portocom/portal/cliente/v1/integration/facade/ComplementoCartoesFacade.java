package com.porto.portocom.portal.cliente.v1.integration.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.constant.ChavesParamEnum;
import com.porto.portocom.portal.cliente.v1.constant.IntegracaoEnum;
import com.porto.portocom.portal.cliente.v1.exception.ConexaoException;
import com.porto.portocom.portal.cliente.v1.integration.IComplementoCartoesWebService;
import com.porto.portocom.portal.cliente.v1.wsdl.complementocartoes.CartaoWebPortalService;
import com.porto.portocom.portal.cliente.v1.wsdl.complementocartoes.ContaCartaoRetornoVO;

import reactor.core.publisher.Mono;

@Service
public class ComplementoCartoesFacade extends BaseFacade implements IComplementoCartoesFacade {

	private static final Logger LOG = LoggerFactory.getLogger(ComplementoCartoesFacade.class);

	private CartaoWebPortalService cartaoWebPortalService;

	private IComplementoCartoesWebService complementoCartoesWebService;

	@Autowired
	public ComplementoCartoesFacade(IComplementoCartoesWebService complementoCartoesWebService) {
		this.complementoCartoesWebService = complementoCartoesWebService;
	}



	private synchronized CartaoWebPortalService loadCartaoWebPortalService() {
		
		try {
			if (cartaoWebPortalService == null) {

				cartaoWebPortalService = (CartaoWebPortalService) estabeleceConexao(ChavesParamEnum.PORTO_MS_PRODUTO_CARTOES_WS_USUARIO.getValor(),
						ChavesParamEnum.PORTO_MS_PRODUTO_CARTOES_WS_SENHA.getValor(), IntegracaoEnum.CARTOES);
			} else {
				LOG.debug("Conexão com {} já foi estabelecida anteriormente.", IntegracaoEnum.CARTOES);
			}
		} catch (Exception e) {
			throw new ConexaoException(e.getMessage(), e);
		}
		return cartaoWebPortalService;
	}



	@Override
	public Mono<ContaCartaoRetornoVO> contaCartoes(String cpfCnpj, String origem) {
		return Mono.just(loadCartaoWebPortalService())
				.map(cartaoWS -> this.complementoCartoesWebService.consultarContasCartoesCache(cpfCnpj, origem,cartaoWS))
				.doOnSuccess(success -> LOG.debug("Contas Cartões: {}", CACHE_REALIZADO_SUCESSO))
				.onErrorResume(error -> {
					LOG.error("Conta Cartões: {}", CACHE_NAO_REALIZADO_SUCESSO);
					LOG.error(error.getMessage(), error);
					return Mono.just(this.complementoCartoesWebService.consultarContasCartoes(cpfCnpj, origem,
							cartaoWebPortalService));
				});
	}

}
