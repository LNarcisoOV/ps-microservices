package com.porto.portocom.portal.cliente.v1.integration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.handler.MessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.constant.CacheConstants;
import com.porto.portocom.portal.cliente.v1.constant.SiglaIntegracaoEnum;
import com.porto.portocom.portal.cliente.v1.service.ParametrosLocalCacheService;
import com.porto.portocom.portal.cliente.v1.utils.ConversorUtils;
import com.porto.portocom.portal.cliente.v1.utils.TrataCpfCnpjUtils;
import com.porto.portocom.portal.cliente.v1.vo.CpfCnpjVO;
import com.porto.portocom.portal.cliente.v1.wsdl.investimento.ConsultarCotistaService;
import com.porto.portocom.portal.cliente.v1.wsdl.investimento.ConsultarCotistaServiceException_Exception;
import com.porto.portocom.portal.cliente.v1.wsdl.investimento.ConsultarCotistaServiceService;
import com.porto.portocom.portal.cliente.v1.wsdl.investimento.CotistaCompletoServiceVO;

@Service
public class InvestimentoWebService extends BaseWebService implements IInvestimentoWebService {

	private static final Logger LOG = LoggerFactory.getLogger(InvestimentoWebService.class);

	private static final String PORTOPAR_WS_TIME_OUT = "portopar.ws.timeout";

	private static final String CONNECT_TIMEOUT_PORTOPAR = "connect.timeout.portopar";
	
	protected ParametrosLocalCacheService parametrosLocalCacheService;

	@Autowired
	public InvestimentoWebService(IPortalLogService portalLogService,ParametrosLocalCacheService parametrosLocalCacheService) {
		this.portalLogService = portalLogService;
		this.parametrosLocalCacheService = parametrosLocalCacheService;
	}

	@Override
	public List<CotistaCompletoServiceVO> consultar(String cpfCnpj,
			ConsultarCotistaServiceService consultarCotistaService) {

		int responseCode = 0;
		long startTimeConnection = 0;
		long timeTakenConnection = 0;
		long startTimeExecution = 0;
		long timeTakenExecution = 0;
		BindingProvider bp = null;
		Map<String, Object> request = new HashMap<>();
		List<CotistaCompletoServiceVO> response = new ArrayList<>();
		Exception exception = null;

		try {
			startTimeConnection = System.currentTimeMillis();

			ConsultarCotistaService consultaCotista = consultarCotistaService.getConsultarCotistaService();

			bp = (BindingProvider) consultaCotista;

			verificaTimeOut(bp);

			timeTakenConnection = System.currentTimeMillis() - startTimeConnection;

			CpfCnpjVO cpfCnpjVO = TrataCpfCnpjUtils.obterCpfCnpjFormatado(cpfCnpj);

			request.put("numeroCpfouCnpj", cpfCnpjVO.getCpfCnpjNumero());
			request.put("numeroOrdemCnpj", cpfCnpjVO.getCpfCnpjOrdem().toString());
			request.put("digitoCpfouCnpj", cpfCnpjVO.getCpfCnpjDigito());

			startTimeExecution = System.currentTimeMillis();

			response = consultaCotista.consultaCotistaCompletoPorCpfCnpj(cpfCnpjVO.getCpfCnpjNumero().toString(),
					cpfCnpjVO.getCpfCnpjOrdem().toString(), cpfCnpjVO.getCpfCnpjDigito().toString());

			timeTakenExecution = System.currentTimeMillis() - startTimeExecution;
			LOG.debug("Sucesso consultaCotistaPorCpfCnpj.");
		} catch (WebServiceException e) {
			LOG.error(e.getMessage(), e);
			exception = e;
		} catch (ConsultarCotistaServiceException_Exception e) {
			LOG.error(String.format("Cotista %s não encontrado.", cpfCnpj), e);
			exception = e;
		} finally {
			if (bp != null && bp.getResponseContext() != null
					&& bp.getResponseContext().get(MessageContext.HTTP_RESPONSE_CODE) != null) {
				responseCode = (int) bp.getResponseContext().get(MessageContext.HTTP_RESPONSE_CODE);
			}

			portalLogService.enviaLogIntegracao(SiglaIntegracaoEnum.PORTOPAR.toString(), "consultaCotistaPorCpfCnpj",
					cpfCnpj, request, response, responseCode, timeTakenConnection, timeTakenExecution, exception, null);
		}
		return response;
	}

	@Cacheable(value = CacheConstants.PORTOPAR_CONSULTA_COTISTA
			, key = CacheConstants.ChaveCache.CHAVE_CPF_CNPJ
			, unless = "#result==null or #result.size()==0")
	@Override
	public List<CotistaCompletoServiceVO> consultarCache(String cpfCnpj,
			ConsultarCotistaServiceService consultarCotistaService) {
		return consultar(cpfCnpj, consultarCotistaService);
	}

	private void verificaTimeOut(BindingProvider bp) {
		if (ConversorUtils.converteStringParaInteiro(
				parametrosLocalCacheService.recuperaParametro(CONNECT_TIMEOUT_PORTOPAR)) > 0) {
			bp.getRequestContext().put(CONNECT_TIMEOUT,
					parametrosLocalCacheService.recuperaParametro(CONNECT_TIMEOUT_PORTOPAR));
		}

		if (ConversorUtils.converteStringParaInteiro(
				parametrosLocalCacheService.recuperaParametro(PORTOPAR_WS_TIME_OUT)) > 0) {
			bp.getRequestContext().put(REQUEST_TIMEOUT,
					parametrosLocalCacheService.recuperaParametro(PORTOPAR_WS_TIME_OUT));
		}
	}

}
