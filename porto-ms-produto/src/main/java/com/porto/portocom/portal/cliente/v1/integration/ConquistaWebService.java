package com.porto.portocom.portal.cliente.v1.integration;

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
import com.porto.portocom.portal.cliente.v1.wsdl.conquista.CadastrarClienteArenaException_Exception;
import com.porto.portocom.portal.cliente.v1.wsdl.conquista.CadastrarClienteArenaRequestType;
import com.porto.portocom.portal.cliente.v1.wsdl.conquista.CadastrarClienteArenaResponseType;
import com.porto.portocom.portal.cliente.v1.wsdl.conquista.ClienteArenaWSImpl;
import com.porto.portocom.portal.cliente.v1.wsdl.conquista.ClienteArenaWSImplService;
import com.porto.portocom.portal.cliente.v1.wsdl.conquista.ConsultarClienteArenaCadastradoException_Exception;
import com.porto.portocom.portal.cliente.v1.wsdl.conquista.IsClienteCadastradoRequestType;
import com.porto.portocom.portal.cliente.v1.wsdl.conquista.IsClienteCadastradoResponseType;

@Service
public class ConquistaWebService extends BaseWebService implements IConquistaWebService {

	private static final Logger LOG = LoggerFactory.getLogger(ConquistaWebService.class);

	protected ParametrosLocalCacheService parametrosLocalCacheService;

	@Autowired
	public ConquistaWebService(IPortalLogService portalLogService,ParametrosLocalCacheService parametrosLocalCacheService) {
		this.portalLogService = portalLogService;
		this.parametrosLocalCacheService = parametrosLocalCacheService;
	}

	@Override
	public CadastrarClienteArenaResponseType cadastrarClienteArena(
			CadastrarClienteArenaRequestType cadastrarClienteArena, ClienteArenaWSImplService clienteArenaWS) {

		int responseCode = 0;
		long startTimeConnection = 0;
		long timeTakenConnection = 0;
		long startTimeExecution = 0;
		long timeTakenExecution = 0;
		BindingProvider bp = null;
		CadastrarClienteArenaResponseType response = new CadastrarClienteArenaResponseType();
		Exception exception = null;

		try {
			startTimeConnection = System.currentTimeMillis();
			ClienteArenaWSImpl clienteArena = clienteArenaWS.getClienteArenaWSImplPort();

			bp = (BindingProvider) clienteArena;

			verificaTimeOut(bp);

			timeTakenConnection = System.currentTimeMillis() - startTimeConnection;

			startTimeExecution = System.currentTimeMillis();

			response = clienteArena.cadastrarClienteArena(cadastrarClienteArena);

			timeTakenExecution = System.currentTimeMillis() - startTimeExecution;

		} catch (WebServiceException | CadastrarClienteArenaException_Exception e) {
			LOG.error(e.getMessage(), e);
			exception = e;
		} finally {
			if (bp != null && bp.getResponseContext() != null
					&& bp.getResponseContext().get(MessageContext.HTTP_RESPONSE_CODE) != null) {
				responseCode = (int) bp.getResponseContext().get(MessageContext.HTTP_RESPONSE_CODE);
			}

			portalLogService.enviaLogIntegracao(SiglaIntegracaoEnum.CONQUISTA.toString(), "cadastrarClienteArena",
					cadastrarClienteArena.getClienteArena().getCpfCnpj(), cadastrarClienteArena, response, responseCode,
					timeTakenConnection, timeTakenExecution, exception, null);
		}

		return response;
	}

	@Cacheable(value = CacheConstants.CONQUISTA_CLIENTE_CADASTRADO
			, key = CacheConstants.ChaveCache.CHAVE_CPF_CNPJ
			, unless = "#result.isCadastrado==null")
	@Override
	public IsClienteCadastradoResponseType isClienteArenaCadastradoCache(String cpfCnpj,
			ClienteArenaWSImplService clienteArenaWS) {

		return isClienteArenaCadastrado(cpfCnpj, clienteArenaWS);
	}

	@Override
	public IsClienteCadastradoResponseType isClienteArenaCadastrado(String cpfCnpj,
			ClienteArenaWSImplService clienteArenaWS) {

		int responseCode = 0;
		long startTimeConnection = 0;
		long timeTakenConnection = 0;
		long startTimeExecution = 0;
		long timeTakenExecution = 0;
		BindingProvider bp = null;
		IsClienteCadastradoRequestType request = new IsClienteCadastradoRequestType();
		IsClienteCadastradoResponseType response = new IsClienteCadastradoResponseType();
		Exception exception = null;

		try {
			request.setCpfCnpj(cpfCnpj);

			startTimeConnection = System.currentTimeMillis();
			ClienteArenaWSImpl clienteArena = clienteArenaWS.getClienteArenaWSImplPort();

			bp = (BindingProvider) clienteArena;

			verificaTimeOut(bp);

			timeTakenConnection = System.currentTimeMillis() - startTimeConnection;

			startTimeExecution = System.currentTimeMillis();

			response = clienteArena.isClienteArenaCadastrado(request);

			timeTakenExecution = System.currentTimeMillis() - startTimeExecution;
	
		} catch (RuntimeException | ConsultarClienteArenaCadastradoException_Exception e) {
			LOG.error(e.getMessage(), e);
			exception = e;
		} finally {
			if (bp != null && bp.getResponseContext() != null
					&& bp.getResponseContext().get(MessageContext.HTTP_RESPONSE_CODE) != null) {
				responseCode = (int) bp.getResponseContext().get(MessageContext.HTTP_RESPONSE_CODE);
			}

			portalLogService.enviaLogIntegracao(SiglaIntegracaoEnum.CONQUISTA.toString(), "isClienteArenaCadastrado",
					cpfCnpj, request, response, responseCode, timeTakenConnection, timeTakenExecution, exception, null);
		}

		return response;
	}
	
	@Cacheable(value = CacheConstants.CONQUISTA_CLIENTE_DADOS
			, key = CacheConstants.ChaveCache.CHAVE_CPF_CNPJ
			, unless = "#result.isCadastrado==false")
	@Override
	public IsClienteCadastradoResponseType obterDadosClienteArenaCadastradoCache(String cpfCnpj,
			ClienteArenaWSImplService clienteArenaWS) {

		return obterDadosClienteArenaCadastrado(cpfCnpj, clienteArenaWS);
	}

	
	@Override
	public IsClienteCadastradoResponseType obterDadosClienteArenaCadastrado(String cpfCnpj,
			ClienteArenaWSImplService clienteArenaWS) {

		int responseCode = 0;
		long startTimeConnection = 0;
		long timeTakenConnection = 0;
		long startTimeExecution = 0;
		long timeTakenExecution = 0;
		BindingProvider bp = null;
		IsClienteCadastradoRequestType request = new IsClienteCadastradoRequestType();
		IsClienteCadastradoResponseType response = new IsClienteCadastradoResponseType();
		Exception exception = null;

		try {
			request.setCpfCnpj(cpfCnpj);

			startTimeConnection = System.currentTimeMillis();
			ClienteArenaWSImpl clienteArena = clienteArenaWS.getClienteArenaWSImplPort();

			bp = (BindingProvider) clienteArena;

			verificaTimeOut(bp);

			timeTakenConnection = System.currentTimeMillis() - startTimeConnection;

			startTimeExecution = System.currentTimeMillis();

			response = clienteArena.obterDadosClienteArenaCadastrado(request);

			timeTakenExecution = System.currentTimeMillis() - startTimeExecution;
	
		} catch (RuntimeException | ConsultarClienteArenaCadastradoException_Exception e) {
			LOG.error(e.getMessage(), e);
			exception = e;
		} finally {
			if (bp != null && bp.getResponseContext() != null
					&& bp.getResponseContext().get(MessageContext.HTTP_RESPONSE_CODE) != null) {
				responseCode = (int) bp.getResponseContext().get(MessageContext.HTTP_RESPONSE_CODE);
			}

			portalLogService.enviaLogIntegracao(SiglaIntegracaoEnum.CONQUISTA.toString(), "obterDadosClienteArenaCadastrado",
					cpfCnpj, request, response, responseCode, timeTakenConnection, timeTakenExecution, exception, null);
		}

		return response;
	}

	private  void verificaTimeOut(BindingProvider bp) {
		String pConnectTimeout = parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_PRODUTO_CONQUISTA_WS_CONNECT_TIMEOUT.getValor());

		if (pConnectTimeout != null && ConversorUtils.converteStringParaInteiro(pConnectTimeout) > 0) {
			bp.getRequestContext().put(CONNECT_TIMEOUT, pConnectTimeout);
		}

		String pRequestTimeout = parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_PRODUTO_CONQUISTA_WS_REQUEST_TIMEOUT.getValor());

		if (pRequestTimeout != null && ConversorUtils.converteStringParaInteiro(pRequestTimeout) > 0) {
			bp.getRequestContext().put(REQUEST_TIMEOUT, pRequestTimeout);
		}
	}

}
