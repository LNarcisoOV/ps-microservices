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
import com.porto.portocom.portal.cliente.v1.vo.CpfCnpjVO;
import com.porto.portocom.portal.cliente.v1.wsdl.vdo.VendaOnlinePesquisaCotacaoEndPoint;
import com.porto.portocom.portal.cliente.v1.wsdl.vdo.VendaOnlinePesquisaCotacaoEndPointSoapBindingQSService;
import com.porto.portocom.portal.cliente.v1.wsdl.vdo.common.VendaOnlineResponse;

@Service
public class VendaOnlineWebService extends BaseWebService implements IVendaOnlineWebService {

	private static final Logger LOG = LoggerFactory.getLogger(VendaOnlineWebService.class);
	
	private ParametrosLocalCacheService parametrosLocalCacheService;
	
	@Autowired
	public VendaOnlineWebService(IPortalLogService portalLogService,ParametrosLocalCacheService parametrosLocalCacheService) {
		this.portalLogService = portalLogService;
		this.parametrosLocalCacheService = parametrosLocalCacheService;
	}

	@Override
	public VendaOnlineResponse pesquisaCotacoes(String cpfCnpj,
			VendaOnlinePesquisaCotacaoEndPointSoapBindingQSService vendaOnlineService) {

		int responseCode = 0;
		long startTimeConnection = 0;
		long timeTakenConnection = 0;
		long startTimeExecution = 0;
		long timeTakenExecution = 0;
		BindingProvider bp = null;
		Map<String, Object> request = new HashMap<>();
		VendaOnlineResponse response = new VendaOnlineResponse();
		Exception exception = null;

		try {
			startTimeConnection = System.currentTimeMillis();

			VendaOnlinePesquisaCotacaoEndPoint vendaOnlinePesquisaCotacaoEndPoint = vendaOnlineService
					.getVendaOnlinePesquisaCotacaoEndPointSoapBindingQSPort();

			bp = (BindingProvider) vendaOnlinePesquisaCotacaoEndPoint;

			verificaTimeOut(bp);

			timeTakenConnection = System.currentTimeMillis() - startTimeConnection;

			CpfCnpjVO cpfCnpjVO = TrataCpfCnpjUtils.obterCpfCnpjFormatado(cpfCnpj);

			request.put("numeroCpfouCnpj", cpfCnpjVO.getCpfCnpjNumero());
			request.put("numeroOrdemCnpj", cpfCnpjVO.getCpfCnpjOrdem().toString());
			request.put("digitoCpfouCnpj", cpfCnpjVO.getCpfCnpjDigito());

			startTimeExecution = System.currentTimeMillis();

			response = vendaOnlinePesquisaCotacaoEndPoint.pesquisaCotacoesVendaOnline(
					cpfCnpjVO.getCpfCnpjNumero().intValue(), cpfCnpjVO.getCpfCnpjOrdem().intValue(),
					cpfCnpjVO.getCpfCnpjDigito().intValue());

			timeTakenExecution = System.currentTimeMillis() - startTimeExecution;
			LOG.debug("Sucesso pesquisaCotacoes.");
		} catch (WebServiceException e) {
			LOG.error(e.getMessage(), e);
			exception = e;
		} finally {
			if (bp != null && bp.getResponseContext() != null
					&& bp.getResponseContext().get(MessageContext.HTTP_RESPONSE_CODE) != null) {
				responseCode = (int) bp.getResponseContext().get(MessageContext.HTTP_RESPONSE_CODE);
			}

			portalLogService.enviaLogIntegracao(SiglaIntegracaoEnum.VDO.toString(), "pesquisaCotacoesVendaOnline",
					cpfCnpj, request, response, responseCode, timeTakenConnection, timeTakenExecution, exception, null);
		}
		return response;
	}

	@Cacheable(value = CacheConstants.VENDAONLINE_PESQUISA_COTACOES
			, key = CacheConstants.ChaveCache.CHAVE_CPF_CNPJ
			, unless = "#result.numeroCpfCnpj==null")
	@Override
	public VendaOnlineResponse pesquisaCotacoesCache(String cpfCnpj,
			VendaOnlinePesquisaCotacaoEndPointSoapBindingQSService vendaOnlineService) {
		return pesquisaCotacoes(cpfCnpj, vendaOnlineService);
	}

	private void verificaTimeOut(BindingProvider bp) {
		String pConnectTimeout = parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_PRODUTO_VENDA_ONLINE_WS_CONNECT_TIMEOUT.getValor());

		if (pConnectTimeout != null && ConversorUtils.converteStringParaInteiro(pConnectTimeout) > 0) {
			bp.getRequestContext().put(CONNECT_TIMEOUT, pConnectTimeout);
		}

		String pRequestTimeout = parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_PRODUTO_VENDA_ONLINE_WS_REQUEST_TIMEOUT.getValor());

		if (pRequestTimeout != null && ConversorUtils.converteStringParaInteiro(pRequestTimeout) > 0) {
			bp.getRequestContext().put(REQUEST_TIMEOUT, pRequestTimeout);
		}
	}

}
