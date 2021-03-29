package com.porto.portocom.portal.cliente.v1.integration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

import org.apache.commons.collections4.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.v1.constant.AutenticacaoLdapEnum;
import com.porto.portocom.portal.cliente.v1.constant.ChavesEnum;
import com.porto.portocom.portal.cliente.v1.constant.ChavesParamEnum;
import com.porto.portocom.portal.cliente.v1.exception.LdapException;
import com.porto.portocom.portal.cliente.v1.model.ContaAcessoComSenha;
import com.porto.portocom.portal.cliente.v1.service.ParametrosLocalCacheService;
import com.porto.portocom.portal.cliente.v1.wsdl.ldap.ContaAcessoComSenhaVO;
import com.porto.portocom.portal.cliente.v1.wsdl.ldap.ContaAcessoVO;
import com.porto.portocom.portal.cliente.v1.wsdl.ldap.GeraSenhaReturn;
import com.porto.portocom.portal.cliente.v1.wsdl.ldap.NovaSenhaVO;
import com.porto.portocom.portal.cliente.v1.wsdl.ldap.PortalClienteDelegate;
import com.porto.portocom.portal.cliente.v1.wsdl.ldap.PortalClienteException_Exception;
import com.porto.portocom.portal.cliente.v1.wsdl.ldap.PortalClienteService;
import com.porto.portocom.portal.cliente.v1.wsdl.ldap.ResultVO;
import com.porto.portocom.portal.cliente.v1.wsdl.ldap.RetornoVO;

@Service
public class LdapWebService implements ILdapWebService {

	private static final Logger LOG = LoggerFactory.getLogger(LdapWebService.class);

	private PortalClienteService portalClienteService;

	private static final String CODIGO_ERRO_GENERICO = "-1";

	private static final String CODIGO_SUCESSO = "0";

	private static final String CODIGO_USUARIO_INVALIDO = "1";

	private static final String ASTERISCOS = "*****";

	private IPortalLogService portalLogService;
	
	private static final String LDAP_INTEGRACAO = "LDAP";

	private ParametrosLocalCacheService parametrosLocalCacheService;

	private Map<String,String> mapParametros;
	
	private static final Integer BAD_REQUEST = 400;

	@Autowired
	public LdapWebService(IPortalLogService portalLogService, ParametrosLocalCacheService parametrosLocalCacheService) {
		this.portalLogService = portalLogService;
		this.parametrosLocalCacheService = parametrosLocalCacheService;
	}

	private  synchronized PortalClienteService loadPortalClienteService() {
		try {
			this.loadParametros();
			if (portalClienteService == null) {
				String urlWsdl = mapParametros.get(ChavesParamEnum.PORTO_MS_USUARIO_LDAP_WS_URL.getValor()); 
				URL url = new URL(urlWsdl);
				portalClienteService = new PortalClienteService(url,
						new QName("http://service.portalcliente.seguranca.porto.com/", "PortalClienteService"));
			}
		} catch (MalformedURLException e) {
			LOG.error(e.getMessage());
		}
		return portalClienteService;
	}


	@Override
	public Boolean alterarSenha(String cpfcnpj, String senha) {

		LOG.debug("Alterando senha no LDAP");

		int responseCode = 0;
		long startTimeConnection = 0;
		long timeTakenConnection = 0;
		long startTimeExecution = 0;
		long timeTakenExecution = 0;
		BindingProvider bp = null;
		NovaSenhaVO request = new NovaSenhaVO();
		NovaSenhaVO requestLog = null;
		ResultVO response = null;
		Exception exception = null;

		try {

			startTimeConnection = System.currentTimeMillis();
			this.loadPortalClienteService();
			PortalClienteDelegate portalClienteDelegate = portalClienteService.getPortalClientePort();
			bp = (BindingProvider) portalClienteDelegate;
			this.setTimeout(bp);
			timeTakenConnection = System.currentTimeMillis() - startTimeConnection;

			request.setUsuario(cpfcnpj);
			request.setNovaSenha(senha);
			startTimeExecution = System.currentTimeMillis();

			requestLog = new NovaSenhaVO();
			requestLog.setUsuario(cpfcnpj);
			requestLog.setNovaSenha(ASTERISCOS);

			response = portalClienteDelegate.alterarSenha(request);
			timeTakenExecution = System.currentTimeMillis() - startTimeExecution;

		} catch (PortalClienteException_Exception e) {
			exception = e;
			responseCode = BAD_REQUEST;
		} finally {
			if (bp != null) {
				responseCode = (int) bp.getResponseContext().get(MessageContext.HTTP_RESPONSE_CODE);
			}
			
			portalLogService.enviaLogIntegracao(LDAP_INTEGRACAO, "alterarSenha", cpfcnpj, requestLog, response, responseCode,
					timeTakenConnection, timeTakenExecution, exception, null);
		}

		if (response != null) {
			if (AutenticacaoLdapEnum.SUCESSO_AUTENTICACAO.getValor().equals(response.getCodigo())) {
				LOG.debug("Sucesso ao redefinir senha.");
				return true;
			} else {
				throw new LdapException(response.getMensagem(), response.getCodigo());
			}
		} else {
			throw new LdapException("Não foi possível criar o usuário", CODIGO_ERRO_GENERICO);
		}
	}

	private void setTimeout(BindingProvider bp) {
		String urlWsdl = mapParametros.get(ChavesParamEnum.PORTO_MS_USUARIO_LDAP_WS_URL.getValor());
		Integer requestTimeout = Integer.parseInt(mapParametros.get(ChavesParamEnum.PORTO_MS_USUARIO_LDAP_WS_REQUEST_TIMEOUT.getValor()));
		Integer connectTimeout = Integer.parseInt(mapParametros.get(ChavesParamEnum.PORTO_MS_USUARIO_LDAP_WS_CONNECT_TIMEOUT.getValor()));
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, urlWsdl);

		if (requestTimeout > 0) {
			bp.getRequestContext().put(ChavesEnum.REQUEST_TIMEOUT.getValor(), requestTimeout);
		}

		if (connectTimeout > 0) {
			bp.getRequestContext().put(ChavesEnum.CONNECT_TIMEOUT.getValor(), connectTimeout);
		}

	}

	private synchronized void loadParametros() {
		mapParametros = new HashedMap<>();

		mapParametros.put(ChavesParamEnum.PORTO_MS_USUARIO_LDAP_WS_REQUEST_TIMEOUT.getValor(),
				parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_LDAP_WS_REQUEST_TIMEOUT.getValor()));
		mapParametros.put(ChavesParamEnum.PORTO_MS_USUARIO_LDAP_WS_CONNECT_TIMEOUT.getValor(),
				parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_LDAP_WS_CONNECT_TIMEOUT.getValor()));
		mapParametros.put(ChavesParamEnum.PORTO_MS_USUARIO_LDAP_WS_URL.getValor(),
				parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_LDAP_WS_URL.getValor()));

	}


	@Override
	public Boolean atualizarSenha(String cpfcnpj, String senha, String errorMessage) {

		LOG.debug("Atualizando senha no LDAP");

		int responseCode = 0;
		long startTimeConnection = 0;
		long timeTakenConnection = 0;
		long startTimeExecution = 0;
		long timeTakenExecution = 0;
		BindingProvider bp = null;
		NovaSenhaVO request = null;
		NovaSenhaVO requestLog = null;
		String response = null;
		Exception exception = null;

		try {

			startTimeConnection = System.currentTimeMillis();
			this.loadPortalClienteService();
			PortalClienteDelegate portalClienteDelegate = portalClienteService.getPortalClientePort();
			bp = (BindingProvider) portalClienteDelegate;
			this.setTimeout(bp);
			timeTakenConnection = System.currentTimeMillis() - startTimeConnection;

			request = new NovaSenhaVO();
			request.setUsuario(cpfcnpj);
			request.setNovaSenha(senha);
			startTimeExecution = System.currentTimeMillis();
			
			
			requestLog = new NovaSenhaVO();
			requestLog.setUsuario(cpfcnpj);
			requestLog.setNovaSenha(ASTERISCOS);

			response = portalClienteDelegate.atualizarSenha(request);

			timeTakenExecution = System.currentTimeMillis() - startTimeExecution;

		} catch (PortalClienteException_Exception e) {
			exception = e;
			responseCode = BAD_REQUEST;
		} finally {
			if (bp != null) {
				responseCode = (int) bp.getResponseContext().get(MessageContext.HTTP_RESPONSE_CODE);
			}
			
			portalLogService.enviaLogIntegracao(LDAP_INTEGRACAO, "atualizarSenha", cpfcnpj, requestLog, response, responseCode,
					timeTakenConnection, timeTakenExecution, exception, null);
		}

		if (response != null) {
			if (CODIGO_SUCESSO.equals(response)) {
				LOG.debug("Sucesso ao redefinir senha.");
				return true;
			} else if (CODIGO_USUARIO_INVALIDO.equals(response)) {
				throw new LdapException(errorMessage != null ? "Usuário inválido: " + errorMessage : "Usuário inválido",
						CODIGO_USUARIO_INVALIDO);
			} else {
				throw new LdapException("Não foi possível redefinir a senha", CODIGO_ERRO_GENERICO);
			}
		} else {
			return false;
		}
	}


	@Override
	public Boolean criarUsuarioComSenha(ContaAcessoComSenha contaAcessoComSenha) {

		LOG.debug("Atualizando senha no LDAP");

		int responseCode = 0;
		long startTimeConnection = 0;
		long timeTakenConnection = 0;
		long startTimeExecution = 0;
		long timeTakenExecution = 0;
		BindingProvider bp = null;
		ContaAcessoComSenhaVO request = new ContaAcessoComSenhaVO();
		RetornoVO response = null;
		Exception exception = null;

		try {

			startTimeConnection = System.currentTimeMillis();
			this.loadPortalClienteService();
			PortalClienteDelegate portalClienteDelegate = portalClienteService.getPortalClientePort();
			bp = (BindingProvider) portalClienteDelegate;
			this.setTimeout(bp);
			timeTakenConnection = System.currentTimeMillis() - startTimeConnection;

			request.setNome(contaAcessoComSenha.getNome());
			request.setSobreNome(contaAcessoComSenha.getNome());
			request.setUsuario(contaAcessoComSenha.getUsuario());
			request.setSenha(contaAcessoComSenha.getSenha());
			if(contaAcessoComSenha.getProdutos()!=null){
				request.getProdutos().add(contaAcessoComSenha.getProdutos().get(0));
			}
			startTimeExecution = System.currentTimeMillis();

			response = portalClienteDelegate.criarUsuarioComSenha(request);

			timeTakenExecution = System.currentTimeMillis() - startTimeExecution;

		} catch (PortalClienteException_Exception e) {
			exception = e;
			responseCode = BAD_REQUEST;
		} finally {
			if (bp != null) {
				responseCode = (int) bp.getResponseContext().get(MessageContext.HTTP_RESPONSE_CODE);
			}
			request.setSenha(ASTERISCOS);
			portalLogService.enviaLogIntegracao(LDAP_INTEGRACAO, "criarUsuarioComSenha", contaAcessoComSenha.getUsuario(),
					request, response, responseCode, timeTakenConnection, timeTakenExecution, exception, null);
		}



		if (response != null && response.getCodigoRetorno() != null) {
			if (AutenticacaoLdapEnum.SUCESSO_AUTENTICACAO.getValor().equals(response.getCodigoRetorno())) {
				return true;
			} else if (response.getMensagem() != null && !response.getMensagem().isEmpty()){
				throw new LdapException(response.getMensagem(), response.getCodigoRetorno());
			} else if (AutenticacaoLdapEnum.USUARIO_SENHA_INVALIDO.getValor().equals(response.getCodigoRetorno())) {				
				throw new LdapException(response.getCodigoRetorno() +" - "+ AutenticacaoLdapEnum.USUARIO_SENHA_INVALIDO.getMensagem(), AutenticacaoLdapEnum.USUARIO_SENHA_INVALIDO.getValor());				
			} else if( AutenticacaoLdapEnum.SENHA_EXPIRADA.getValor().equals(response.getCodigoRetorno())) {
				throw new LdapException(response.getCodigoRetorno() +" - "+ AutenticacaoLdapEnum.SENHA_EXPIRADA.getMensagem(), AutenticacaoLdapEnum.SENHA_EXPIRADA.getValor());
			} else if (AutenticacaoLdapEnum.USUARIO_BLOQUEADO_TEMPORARIAMENTE.getValor().equals(response.getCodigoRetorno())) {
				throw new LdapException(response.getCodigoRetorno() +" - "+ AutenticacaoLdapEnum.USUARIO_BLOQUEADO_TEMPORARIAMENTE.getMensagem(), AutenticacaoLdapEnum.USUARIO_BLOQUEADO_TEMPORARIAMENTE.getValor());
			} else if (AutenticacaoLdapEnum.USUARIO_BLOQUEADO_DEFINITIVAMENTE.getValor().equals(response.getCodigoRetorno())) {
				throw new LdapException(response.getCodigoRetorno() +" - "+ AutenticacaoLdapEnum.USUARIO_BLOQUEADO_DEFINITIVAMENTE.getMensagem(), AutenticacaoLdapEnum.USUARIO_BLOQUEADO_DEFINITIVAMENTE.getValor());
			} else if (AutenticacaoLdapEnum.SESSAO_EM_CONTIGENCIA.getValor().equals(response.getCodigoRetorno())) {
				throw new LdapException(response.getCodigoRetorno() +" - "+ AutenticacaoLdapEnum.SESSAO_EM_CONTIGENCIA.getMensagem(), AutenticacaoLdapEnum.SESSAO_EM_CONTIGENCIA.getValor());
			} else if (AutenticacaoLdapEnum.SENHA_INVALIDA.getValor().equals(response.getCodigoRetorno())) {
				throw new LdapException(response.getCodigoRetorno() +" - "+ AutenticacaoLdapEnum.SENHA_INVALIDA.getMensagem(), AutenticacaoLdapEnum.SENHA_INVALIDA.getValor());
			} else if (AutenticacaoLdapEnum.SENHA_INVALIDA_ULTIMA_TENTATIVA.getValor().equals(response.getCodigoRetorno())) {
				throw new LdapException(response.getCodigoRetorno() +" - "+ AutenticacaoLdapEnum.SENHA_INVALIDA_ULTIMA_TENTATIVA.getMensagem(), AutenticacaoLdapEnum.SENHA_INVALIDA_ULTIMA_TENTATIVA.getValor());
			} else if (AutenticacaoLdapEnum.VARIAVEL_NAO_INFORMADA.getValor().equals(response.getCodigoRetorno())) {
				throw new LdapException(response.getCodigoRetorno() +" - "+ AutenticacaoLdapEnum.VARIAVEL_NAO_INFORMADA.getMensagem(), AutenticacaoLdapEnum.VARIAVEL_NAO_INFORMADA.getValor());
			} else if (AutenticacaoLdapEnum.ERRO_INESPERADO.getValor().equals(response.getCodigoRetorno())) {
				throw new LdapException(response.getCodigoRetorno() +" - "+ AutenticacaoLdapEnum.ERRO_INESPERADO.getMensagem(), AutenticacaoLdapEnum.ERRO_INESPERADO.getValor());
			} else {
				throw new LdapException("Não foi possível criar o usuário", CODIGO_ERRO_GENERICO);
			}
		} else {
			return false;
		}
	}

	@Override
	public Boolean criarUsuario(ContaAcessoVO contaAcesso) {

		LOG.debug("Criando Usuario no LDAP");

		int responseCode = 0;
		long startTimeConnection = 0;
		long timeTakenConnection = 0;
		long startTimeExecution = 0;
		long timeTakenExecution = 0;
		BindingProvider bp = null;
		GeraSenhaReturn response = null;
		Exception exception = null;

		try {

			startTimeConnection = System.currentTimeMillis();
			this.loadPortalClienteService();
			PortalClienteDelegate portalClienteDelegate = portalClienteService.getPortalClientePort();
			bp = (BindingProvider) portalClienteDelegate;
			this.setTimeout(bp);
			timeTakenConnection = System.currentTimeMillis() - startTimeConnection;

			startTimeExecution = System.currentTimeMillis();

			response = portalClienteDelegate.criarUsuario(contaAcesso);

			timeTakenExecution = System.currentTimeMillis() - startTimeExecution;

		} catch (PortalClienteException_Exception e) {
			exception = e;
			responseCode = BAD_REQUEST;
		} finally {
			if (bp != null) {
				responseCode = (int) bp.getResponseContext().get(MessageContext.HTTP_RESPONSE_CODE);
			}
			
			portalLogService.enviaLogIntegracao(LDAP_INTEGRACAO, "criarUsuario", contaAcesso.getUsuario(), contaAcesso, response,
					responseCode, timeTakenConnection, timeTakenExecution, exception, null);
		}

		if (response != null && response.getCodigoRetorno() != null) {
			return (CODIGO_SUCESSO.equals(response.getCodigoRetorno()));
		}  else {
			return false;
		}
	}


}
