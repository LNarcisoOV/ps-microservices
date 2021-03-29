package com.porto.portocom.portal.cliente.v1.integration;

import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.handler.MessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.constant.SiglaIntegracaoEnum;
import com.porto.portocom.portal.cliente.v1.constant.CacheConstants;
import com.porto.portocom.portal.cliente.v1.constant.ChavesParamEnum;
import com.porto.portocom.portal.cliente.v1.service.ParametrosLocalCacheService;
import com.porto.portocom.portal.cliente.v1.utils.ConversorUtils;
import com.porto.portocom.portal.cliente.v1.utils.TrataCpfCnpjUtils;
import com.porto.portocom.portal.cliente.v1.wsdl.complementocartoes.CartaoWebPortal;
import com.porto.portocom.portal.cliente.v1.wsdl.complementocartoes.CartaoWebPortalService;
import com.porto.portocom.portal.cliente.v1.wsdl.complementocartoes.ContaCartaoParamentroVO;
import com.porto.portocom.portal.cliente.v1.wsdl.complementocartoes.ContaCartaoRetornoVO;

@Service
public class ComplementoCartoesWebService extends BaseWebService implements IComplementoCartoesWebService {

	private static final Logger LOG = LoggerFactory.getLogger(ComplementoCartoesWebService.class);

	private ParametrosLocalCacheService parametrosLocalCacheService;

	@Autowired
	public ComplementoCartoesWebService(IPortalLogService portalLogService,ParametrosLocalCacheService parametrosLocalCacheService) {
		this.portalLogService = portalLogService;
		this.parametrosLocalCacheService = parametrosLocalCacheService;
	}

	@Override
	public ContaCartaoRetornoVO consultarContasCartoes(String cpfCnpj, String origem,
			CartaoWebPortalService cartaoWebPortalService) {

		int responseCode = 0;
		long startTimeConnection = 0;
		long timeTakenConnection = 0;
		long startTimeExecution = 0;
		long timeTakenExecution = 0;
		BindingProvider bp = null;
		Map<String, Object> request = new HashMap<>();
		ContaCartaoRetornoVO response = new ContaCartaoRetornoVO();
		Exception exception = null;

		try {
			startTimeConnection = System.currentTimeMillis();

			ContaCartaoParamentroVO contaCartao = criarVO(cpfCnpj, origem);

			CartaoWebPortal cartaoWebPortal = cartaoWebPortalService.getCartaoWebPortalPort();

			bp = (BindingProvider) cartaoWebPortal;

			verificaTimeOut(bp, cpfCnpj);

			timeTakenConnection = System.currentTimeMillis() - startTimeConnection;

			request.put("numeroCpfCnpj", contaCartao.getCpf());
			request.put("origem", contaCartao.getOrigem());

			startTimeExecution = System.currentTimeMillis();

			response = cartaoWebPortal.consultaContaCartaoComAdicionalPJ(contaCartao);

			timeTakenExecution = System.currentTimeMillis() - startTimeExecution;
			LOG.debug("Sucesso consultarContasCartoes.");
		} catch (WebServiceException e) {
			LOG.error(e.getMessage(), e);
			exception = e;
		} finally {
			if (bp != null && bp.getResponseContext() != null
					&& bp.getResponseContext().get(MessageContext.HTTP_RESPONSE_CODE) != null) {
				responseCode = (int) bp.getResponseContext().get(MessageContext.HTTP_RESPONSE_CODE);
			}

			portalLogService.enviaLogIntegracao(SiglaIntegracaoEnum.COMP_CARTOES.toString(), "consultarContas", cpfCnpj,
					request, response, responseCode, timeTakenConnection, timeTakenExecution, exception, null);
		}

		return response;
	}

	@Cacheable(value = CacheConstants.CONTAS_CARTOES
			, key = CacheConstants.ChaveCache.CHAVE_CPF_CNPJ + " + #origem"
			, unless = "#result.codigoRetorno==null")
	@Override
	public ContaCartaoRetornoVO consultarContasCartoesCache(String cpfCnpj, String origem,
			CartaoWebPortalService cartaoWebPortalService) {
		return consultarContasCartoes(cpfCnpj, origem, cartaoWebPortalService);
	}

	/**
	 * Méotodos auxiliares da classe
	 * 
	 * @param cpfCnpj
	 * @param origem
	 * @return
	 */
	public ContaCartaoParamentroVO criarVO(String cpfCnpj, String origem) {

		ContaCartaoParamentroVO contaCartao = new ContaCartaoParamentroVO();
		contaCartao.setCpf(cpfCnpj);
		contaCartao.setOrigem(origem);
		return contaCartao;
	}

	private void verificaTimeOut(BindingProvider bp, String cpfCnpj) {

		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_PRODUTO_CARTOES_WS_URL.getValor()));

		if (ConversorUtils.converteStringParaInteiro(
				parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_PRODUTO_CARTOES_WS_CONNECT_TIMEOUT.getValor())) > 0) {
			bp.getRequestContext().put(CONNECT_TIMEOUT,
					parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_PRODUTO_CARTOES_WS_CONNECT_TIMEOUT.getValor()));
		}

		if (TrataCpfCnpjUtils.isCpf(cpfCnpj) && (ConversorUtils.converteStringParaInteiro(
				parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_PRODUTO_BCP_BASE_UNICA_CLIENTE_CPF_WS_TIMEOUT.getValor())) > 0)) {
				bp.getRequestContext().put(REQUEST_TIMEOUT,
						parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_PRODUTO_BCP_BASE_UNICA_CLIENTE_CPF_WS_TIMEOUT.getValor()));

		} else if (TrataCpfCnpjUtils.isCnpj(cpfCnpj) && (ConversorUtils.converteStringParaInteiro(
				parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_PRODUTO_BCP_BASE_UNICA_CLIENTE_CNPJ_WS_TIMEOUT.getValor())) > 0)) {
				bp.getRequestContext().put(REQUEST_TIMEOUT,
						parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_PRODUTO_BCP_BASE_UNICA_CLIENTE_CNPJ_WS_TIMEOUT.getValor()));
		}

	}
	

}
