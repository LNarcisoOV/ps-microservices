package com.porto.portocom.portal.cliente.v1.integration.facade;

import java.net.Authenticator;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.BindingProvider;

import org.springframework.beans.factory.annotation.Autowired;

import com.porto.portocom.portal.cliente.v1.constant.ChavesParamEnum;
import com.porto.portocom.portal.cliente.v1.constant.IntegracaoEnum;
import com.porto.portocom.portal.cliente.v1.service.ParametrosLocalCacheService;
import com.porto.portocom.portal.cliente.v1.wsdl.bcp.ConsultaDadosBCPWS_Service;
import com.porto.portocom.portal.cliente.v1.wsdl.complementocartoes.CartaoWebPortalService;
import com.porto.portocom.portal.cliente.v1.wsdl.conquista.ClienteArenaWSImplService;
import com.porto.portocom.portal.cliente.v1.wsdl.investimento.ConsultarCotistaServiceService;
import com.porto.portocom.portal.cliente.v1.wsdl.vdo.VendaOnlinePesquisaCotacaoEndPointSoapBindingQSService;

public abstract class BaseFacade {

	protected static final String CACHE_REALIZADO_SUCESSO = "Cache realizado.";

	protected static final String CACHE_NAO_REALIZADO_SUCESSO = "Cache não realizado.";

	@Autowired
	protected ParametrosLocalCacheService parametrosLocalCacheService;

	protected HashMap<String, String> obtemUsuarioESenha(final String usernameKey, final String passwordKey) {
		HashMap<String, String> usuarioESenha = new HashMap<>();

		String pUsuario = parametrosLocalCacheService.recuperaParametro(usernameKey);

		if (pUsuario != null  && !pUsuario.trim().isEmpty()) {
			usuarioESenha.put(BindingProvider.USERNAME_PROPERTY, pUsuario.trim());
		}

		String pSenha = parametrosLocalCacheService.recuperaParametro(passwordKey);

		if (pSenha != null  && !pSenha.trim().isEmpty()) {
			usuarioESenha.put(BindingProvider.PASSWORD_PROPERTY, pSenha);
		}

		return usuarioESenha;
	}

	// estabeleceConexao como um método genérico
	protected Object estabeleceConexao(final String userKey, final String passKey, final IntegracaoEnum  integracaoEnum )
			throws MalformedURLException {
		Object objetoFactory = null;
		this.setRequisitosDeConexao(userKey, passKey);
			
		switch(integracaoEnum) {

		case BCP:
			objetoFactory = new ConsultaDadosBCPWS_Service(
					new URL(parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_PRODUTO_BCP_WS_URL.getValor())));
			break;
		case CARTOES:
			objetoFactory = new CartaoWebPortalService(
					new URL(parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_PRODUTO_CARTOES_WS_URL.getValor())));
			break;
		case CONQUISTA:
			objetoFactory =  new ClienteArenaWSImplService(
					new URL(parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_PRODUTO_CONQUISTA_WS_URL.getValor())));
			break;
		case PORTOPAR:
			objetoFactory = new ConsultarCotistaServiceService(
					new URL(parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_PRODUTO_PORTOPAR_WS_URL.getValor())));
			break;
		case VDO:
			objetoFactory = new VendaOnlinePesquisaCotacaoEndPointSoapBindingQSService(
					new URL(parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_PRODUTO_VENDA_ONLINE_WS_URL.getValor())));
			break;
		}

		return objetoFactory;


	}

	private void setRequisitosDeConexao(final String usernameKey, final String passwordKey) {
		Map<String, String> usuarioESenha = obtemUsuarioESenha(usernameKey, passwordKey);

		if (usuarioESenha.containsKey(BindingProvider.USERNAME_PROPERTY)
				&& usuarioESenha.containsKey(BindingProvider.PASSWORD_PROPERTY)) {

			Authenticator.setDefault(new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(usuarioESenha.get(BindingProvider.USERNAME_PROPERTY),
							usuarioESenha.get(BindingProvider.PASSWORD_PROPERTY).toCharArray());
				}
			});
		}

	}
}
