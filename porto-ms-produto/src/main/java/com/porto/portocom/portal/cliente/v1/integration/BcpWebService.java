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

import com.porto.portocom.portal.cliente.v1.constant.SiglaIntegracaoEnum;
import com.porto.portocom.portal.cliente.v1.constant.CacheConstants;
import com.porto.portocom.portal.cliente.v1.constant.ChavesParamEnum;
import com.porto.portocom.portal.cliente.v1.repository.IProdutosPortalRepository;
import com.porto.portocom.portal.cliente.v1.service.ParametrosLocalCacheService;
import com.porto.portocom.portal.cliente.v1.utils.ConversorUtils;
import com.porto.portocom.portal.cliente.v1.utils.FiltroContratoUtils;
import com.porto.portocom.portal.cliente.v1.utils.TrataCpfCnpjUtils;
import com.porto.portocom.portal.cliente.v1.vo.CpfCnpjVO;
import com.porto.portocom.portal.cliente.v1.wsdl.bcp.ConsultaDadosBCPWS;
import com.porto.portocom.portal.cliente.v1.wsdl.bcp.ConsultaDadosBCPWS_Service;
import com.porto.portocom.portal.cliente.v1.wsdl.bcp.ObterContratoResponseType;
import com.porto.portocom.portal.cliente.v1.wsdl.bcp.ObterContratoType;
import com.porto.portocom.portal.cliente.v1.wsdl.bcp.ObterPessoasResponseType;
import com.porto.portocom.portal.cliente.v1.wsdl.bcp.ObterPessoasType;
import com.porto.portocom.portal.cliente.v1.wsdl.bcp.PortoSeguroFaultInfo;
import com.porto.portocom.portal.cliente.v1.wsdl.bcp.ObterContratoType.FiltroContrato;

@Service
public class BcpWebService extends BaseWebService implements IBcpWebService {

	private static final Logger LOG = LoggerFactory.getLogger(BcpWebService.class);

	private IProdutosPortalRepository produtosPortalRepository;
	
	private  ParametrosLocalCacheService parametrosLocalCacheService;

	@Autowired
	public BcpWebService(IPortalLogService portalLogService, IProdutosPortalRepository produtosPortalRepository,
			ParametrosLocalCacheService parametrosLocalCacheService) {
		this.portalLogService = portalLogService;
		this.produtosPortalRepository = produtosPortalRepository;
		this.parametrosLocalCacheService = parametrosLocalCacheService;
	}

	@Override
	public List<ObterContratoResponseType.Pessoa> obterContratos(String cpfCnpj,
			ConsultaDadosBCPWS_Service consultaDadosBCPWSService) {

		int responseCode = 0;
		long startTimeConnection = 0;
		long timeTakenConnection = 0;
		long startTimeExecution = 0;
		long timeTakenExecution = 0;
		BindingProvider bp = null;
		Map<String, Object> request = new HashMap<>();
		List<ObterContratoResponseType.Pessoa> response = new ArrayList<>();
		Exception exception = null;

		try {
			startTimeConnection = System.currentTimeMillis();

			ConsultaDadosBCPWS consultaDadosBcpws = consultaDadosBCPWSService.getConsultaDadosBCPWS();

			bp = (BindingProvider) consultaDadosBcpws;

			verificaTimeout(bp, cpfCnpj);

			timeTakenConnection = System.currentTimeMillis() - startTimeConnection;

			CpfCnpjVO cpfCnpjVo = TrataCpfCnpjUtils.obterCpfCnpjFormatado(cpfCnpj);

			List<FiltroContrato> produtosReturn = FiltroContratoUtils
					.adicionaFiltroContrato(this.produtosPortalRepository);

			ObterContratoType obterContratoType = new ObterContratoType();
			setContratoType(cpfCnpjVo, obterContratoType);

			configRequestContrato(request, obterContratoType, produtosReturn);

			startTimeExecution = System.currentTimeMillis();

			response = consultaDadosBcpws.obterContrato(obterContratoType.getNumeroCpfouCnpj(),
					obterContratoType.getNumeroOrdemCnpj(), obterContratoType.getDigitoCpfouCnpj(), null, null, null,
					null, null, null, produtosReturn, null);

			timeTakenExecution = System.currentTimeMillis() - startTimeExecution;
			LOG.debug("Sucesso obterContrato.");

		} catch (WebServiceException | PortoSeguroFaultInfo e) {
			LOG.error(e.getMessage(), e);
			exception = e;
		} finally {
			if (bp != null && bp.getResponseContext() != null
					&& bp.getResponseContext().get(MessageContext.HTTP_RESPONSE_CODE) != null) {
				responseCode = (int) bp.getResponseContext().get(MessageContext.HTTP_RESPONSE_CODE);
			}

			portalLogService.enviaLogIntegracao(SiglaIntegracaoEnum.BCP.toString(), "obterContrato", cpfCnpj, request,
					response, responseCode, timeTakenConnection, timeTakenExecution, exception, null);
		}
		return response;

	}

	@Cacheable(value = CacheConstants.BCP_OBTER_CONTRATO
			, key = CacheConstants.ChaveCache.CHAVE_CPF_CNPJ
			, unless = "#result==null or #result.size()==0")
	@Override
	public List<ObterContratoResponseType.Pessoa> obterContratosCache(String cpfCnpj,
			ConsultaDadosBCPWS_Service consultaDadosBCPWSService) {

		return obterContratos(cpfCnpj, consultaDadosBCPWSService);
	}

	private static void configRequestContrato(Map<String, Object> request, ObterContratoType obterContratoType,
			List<FiltroContrato> produtosReturn) {

		// request obterContrato
		request.put("numeroCpfouCnpj", obterContratoType.getNumeroCpfouCnpj());
		request.put("numeroOrdemCnpj", obterContratoType.getNumeroOrdemCnpj());
		request.put("digitoCpfouCnpj", obterContratoType.getDigitoCpfouCnpj());
		request.put("registroNacionalEstrangeiro", NULO);
		request.put("numeroContrato", NULO);
		request.put("numeroPessoa", NULO);
		request.put("nomePessoa", NULO);
		request.put("tipoPessoa", NULO);
		request.put("codigoOrigemProposta", NULO);
		request.put("filtroContrato", produtosReturn);
		request.put("suseps", NULO);
	}

	private static void setContratoType(CpfCnpjVO cpfCnpjVo, ObterContratoType obterContratoType) {
		obterContratoType.setDigitoCpfouCnpj(cpfCnpjVo.getCpfCnpjDigito());
		obterContratoType.setNumeroCpfouCnpj(cpfCnpjVo.getCpfCnpjNumero());
		obterContratoType.setNumeroOrdemCnpj(cpfCnpjVo.getCpfCnpjOrdem());
	}

	@Override
	public List<ObterPessoasResponseType.Pessoa> obterPessoas(String cpfcnpj,
			ConsultaDadosBCPWS_Service consultaDadosBCPWSService) {

		int responseCode = 0;
		long startTimeConnection = 0;
		long timeTakenConnection = 0;
		long startTimeExecution = 0;
		long timeTakenExecution = 0;
		BindingProvider bp = null;
		Map<String, Object> request = new HashMap<>();
		List<ObterPessoasResponseType.Pessoa> response = new ArrayList<>();
		Exception exception = null;

		try {
			startTimeConnection = System.currentTimeMillis();

			ConsultaDadosBCPWS consultaDadosBcpws = consultaDadosBCPWSService.getConsultaDadosBCPWS();

			bp = (BindingProvider) consultaDadosBcpws;

			verificaTimeout(bp, cpfcnpj);

			timeTakenConnection = System.currentTimeMillis() - startTimeConnection;

			CpfCnpjVO cpfCnpjVo = TrataCpfCnpjUtils.obterCpfCnpjFormatado(cpfcnpj);

			ObterPessoasType obterPessoasType = new ObterPessoasType();
			setPessoaType(cpfCnpjVo, obterPessoasType);

			configRequestPessoa(request, obterPessoasType);

			startTimeExecution = System.currentTimeMillis();

			response = consultaDadosBcpws.obterPessoas(obterPessoasType.getNumeroCpfouCnpj(),
					obterPessoasType.getNumeroOrdemCnpj(), obterPessoasType.getDigitoCpfouCnpj(), null, null, null,
					null);

			timeTakenExecution = System.currentTimeMillis() - startTimeExecution;
			LOG.debug("Sucesso obterPessoas.");

		} catch (WebServiceException | PortoSeguroFaultInfo e) {
			LOG.error(e.getMessage(), e);
			exception = e;
		} finally {
			if (bp != null && bp.getResponseContext() != null
					&& bp.getResponseContext().get(MessageContext.HTTP_RESPONSE_CODE) != null) {
				responseCode = (int) bp.getResponseContext().get(MessageContext.HTTP_RESPONSE_CODE);
			}

			portalLogService.enviaLogIntegracao(SiglaIntegracaoEnum.BCP.toString(), "obterPessoa", cpfcnpj, request,
					response, responseCode, timeTakenConnection, timeTakenExecution, exception, null);
		}
		return response;
	}

	@Cacheable(value = CacheConstants.BCP_OBTER_PESSOA
			, key = CacheConstants.ChaveCache.CHAVE_CPF_CNPJ
			, unless = "#result==null or #result.size()==0")
	@Override
	public List<ObterPessoasResponseType.Pessoa> obterPessoasCache(String cpfCnpj,
			ConsultaDadosBCPWS_Service consultaDadosBCPWSService) {
		return obterPessoas(cpfCnpj, consultaDadosBCPWSService);
	}

	private static void configRequestPessoa(Map<String, Object> request, ObterPessoasType obterPessoasType) {

		// request obterPessoas
		request.put("numeroCpfouCnpjPessoas", obterPessoasType.getNumeroCpfouCnpj());
		request.put("numeroOrdemCnpjPessoas", obterPessoasType.getNumeroOrdemCnpj());
		request.put("digitoCpfouCnpjPessoas", obterPessoasType.getDigitoCpfouCnpj());
	}

	private static void setPessoaType(CpfCnpjVO cpfCnpjVo, ObterPessoasType obterPessoaType) {
		obterPessoaType.setDigitoCpfouCnpj(cpfCnpjVo.getCpfCnpjDigito());
		obterPessoaType.setNumeroCpfouCnpj(cpfCnpjVo.getCpfCnpjNumero());
		obterPessoaType.setNumeroOrdemCnpj(cpfCnpjVo.getCpfCnpjOrdem());
	}

	private  void verificaTimeout(BindingProvider bp, String cpfcnpj) {

		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
				parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_PRODUTO_BCP_WS_URL.getValor()));

		if (ConversorUtils.converteStringParaInteiro(
				parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_PRODUTO_BCP_WS_CONNECT_TIMEOUT.getValor())) > 0) {
			bp.getRequestContext().put(CONNECT_TIMEOUT,
					parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_PRODUTO_BCP_WS_CONNECT_TIMEOUT.getValor()));
		}

		if (TrataCpfCnpjUtils.isCpf(cpfcnpj)) {
			if (ConversorUtils.converteStringParaInteiro(
					parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_PRODUTO_BCP_BASE_UNICA_CLIENTE_CPF_WS_TIMEOUT.getValor())) > 0) {
				bp.getRequestContext().put(REQUEST_TIMEOUT,
						parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_PRODUTO_BCP_BASE_UNICA_CLIENTE_CPF_WS_TIMEOUT.getValor()));
			}
		} else if (TrataCpfCnpjUtils.isCnpj(cpfcnpj)) {
			if (ConversorUtils.converteStringParaInteiro(
					parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_PRODUTO_BCP_BASE_UNICA_CLIENTE_CNPJ_WS_TIMEOUT.getValor())) > 0) {
				bp.getRequestContext().put(REQUEST_TIMEOUT,
						parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_PRODUTO_BCP_BASE_UNICA_CLIENTE_CNPJ_WS_TIMEOUT.getValor()));
			}
		} else {
			if (ConversorUtils.converteStringParaInteiro(
					parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_PRODUTO_BCP_WS_REQUEST_TIMEOUT.getValor())) > 0) {
				bp.getRequestContext().put(REQUEST_TIMEOUT,
						parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_PRODUTO_BCP_WS_REQUEST_TIMEOUT.getValor()));
			}
		}
	}
}
