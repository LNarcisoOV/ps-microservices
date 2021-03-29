package com.porto.portocom.portal.cliente.v1.integration.facade;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.constant.ChavesParamEnum;
import com.porto.portocom.portal.cliente.v1.constant.IntegracaoEnum;
import com.porto.portocom.portal.cliente.v1.exception.ConexaoException;
import com.porto.portocom.portal.cliente.v1.integration.IInvestimentoWebService;
import com.porto.portocom.portal.cliente.v1.wsdl.investimento.ConsultarCotistaServiceService;
import com.porto.portocom.portal.cliente.v1.wsdl.investimento.CotistaCompletoServiceVO;

import reactor.core.publisher.Mono;

@Service
public class InvestimentoFacade extends BaseFacade implements IInvestimentoFacade {

	private static final Logger LOG = LoggerFactory.getLogger(InvestimentoFacade.class);

	private IInvestimentoWebService investimentoWebService;
	
	private ConsultarCotistaServiceService consultarCotistaService;

	@Autowired
	InvestimentoFacade(IInvestimentoWebService investimentoWebService) {
		this.investimentoWebService = investimentoWebService;
	}
	
	private synchronized ConsultarCotistaServiceService loadConsultarCotistaServiceService() {

		try {
			if (consultarCotistaService == null) {

				consultarCotistaService = (ConsultarCotistaServiceService) estabeleceConexao(ChavesParamEnum.PORTO_MS_PRODUTO_PORTOPAR_WS_USUARIO.getValor(),
						ChavesParamEnum.PORTO_MS_PRODUTO_PORTOPAR_WS_SENHA.getValor(), IntegracaoEnum.PORTOPAR);
			} else {
				LOG.debug("Conexão com {} já foi estabelecida anteriormente.", IntegracaoEnum.PORTOPAR);
			}
		} catch (Exception e) {
			throw new ConexaoException(e.getMessage(), e);
		}
		return consultarCotistaService;
	}

	@Override
	public Mono<List<CotistaCompletoServiceVO>> cotistas(String cpfCnpj) {
		return Mono.justOrEmpty(loadConsultarCotistaServiceService())
				.map(consultaCotistaWS -> this.investimentoWebService.consultarCache(cpfCnpj, consultaCotistaWS))
				.doOnSuccess(success -> LOG.debug("ConsultaCotistaCompletoPorCpfCnpj - " + CACHE_REALIZADO_SUCESSO))
				.onErrorResume(error -> {
					LOG.error(error.getMessage(), error);
					LOG.debug("ConsultaCotistaCompletoPorCpfCnpj - " + CACHE_NAO_REALIZADO_SUCESSO);
					return Mono.justOrEmpty(this.investimentoWebService.consultar(cpfCnpj, consultarCotistaService));
				});
	}
}
