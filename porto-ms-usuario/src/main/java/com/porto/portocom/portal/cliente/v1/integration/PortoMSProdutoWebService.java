package com.porto.portocom.portal.cliente.v1.integration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.porto.portocom.portal.cliente.v1.constant.CacheConstants;
import com.porto.portocom.portal.cliente.v1.constant.SiglaIntegracaoEnum;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp.Pessoa;
import com.porto.portocom.portal.cliente.v1.exception.EnvioCodigoSegurancaException;
import com.porto.portocom.portal.cliente.v1.response.Response;
import com.porto.portocom.portal.cliente.v1.vo.produto.ConsultaProdutosProspect;

@Service
public class PortoMSProdutoWebService implements IPortoMSProdutoWebService {

	private IPortalLogService portalLogService;
	private RestTemplate restTemplate;
	private static final String CPF_CNPJ_REQ = "cpfCnpj Requisição";
	private static final Integer BAD_REQUEST = 400;

	@Autowired
	public PortoMSProdutoWebService(IPortalLogService portalLogService, RestTemplate restTemplate) {
		this.portalLogService = portalLogService;
		this.restTemplate = restTemplate;
	}


	@Value("${integration.portomsproduto.url}")
	private String url;
	@Value("${integration.portomsproduto.url.v1.produtos.consultaProdutosProspect}")
	private String recursoProdutoConsultaProspect;
	@Value("${integration.portomsproduto.url.v1.bcp.consultaPessoas}")
	private String recursoBcpConsultaPessoas;
	@Value("${integration.portomsproduto.url.v1.investimento.consultaCotista}")
	private String recursoInvestimentoConsultaCotista;

	@Cacheable(value = CacheConstants.CONSULTA_PRODUTO_PROSPECT_MS_PRODUTO, key = CacheConstants.ChaveCache.CHAVE_CPF_CNPJ, unless = "#result==null or #result.size()==0")
	@Override
	public ConsultaProdutosProspect consultaProdutosProspect(String cpfCnpj) {

		long startTimeExecution = 0;
		long timeTakenExecution = 0;
		ResponseEntity<Response<ConsultaProdutosProspect>> response = null;
		ConsultaProdutosProspect produtos = null;
		Exception exception = null;
		Map<String, Object> request = new HashMap<>();
		int statusCode = 0;

		try {

			Map<String, String> param = new HashMap<>();

			param.put("cpfCnpj", cpfCnpj);

			startTimeExecution = System.currentTimeMillis();

			response = restTemplate.exchange(url + recursoProdutoConsultaProspect, HttpMethod.GET, null,
					new ParameterizedTypeReference<Response<ConsultaProdutosProspect>>() {
					}, param);

			request.put(CPF_CNPJ_REQ, cpfCnpj);

			if (response != null) {
				statusCode = response.getStatusCodeValue();

				if (response.getBody().getData() != null) {
					produtos = response.getBody().getData();
				}
			}

			timeTakenExecution = System.currentTimeMillis() - startTimeExecution;

		} catch (Exception e) {
			statusCode = BAD_REQUEST;
			throw new EnvioCodigoSegurancaException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());

		} finally {
			portalLogService.enviaLogIntegracao(SiglaIntegracaoEnum.PORTO_MS_PRODUTO.toString(),
					"consultaProdutosProspect", cpfCnpj, request, produtos, statusCode, startTimeExecution, timeTakenExecution,
					exception, null);
		}
		return produtos;

	}
	

	@Cacheable(value = CacheConstants.BCP_OBTER_PESSOA_MS_PRODUTO, key = CacheConstants.ChaveCache.CHAVE_CPF_CNPJ, unless = "#result==null or #result.size()==0")
	@Override
	public List<PessoaBcp.Pessoa> consultaPessoas(String cpfCnpj) {

		long startTimeExecution = 0;
		long timeTakenExecution = 0;
		ResponseEntity<Response<List<Pessoa>>> response = null;
		List<Pessoa> pessoas = new ArrayList<>();
		Exception exception = null;
		Map<String, Object> request = new HashMap<>();
		int statusCode = 0;

		try {

			Map<String, String> param = new HashMap<>();

			param.put("cpfCnpj", cpfCnpj);

			startTimeExecution = System.currentTimeMillis();
			response = restTemplate.exchange(url + recursoBcpConsultaPessoas, HttpMethod.GET, null,
					new ParameterizedTypeReference<Response<List<Pessoa>>>() {
					}, param);

			request.put(CPF_CNPJ_REQ, cpfCnpj);

			if (response != null) {
				statusCode = response.getStatusCodeValue();

				if (response.getBody().getData() != null) {
					pessoas = response.getBody().getData();
				}
			}

			timeTakenExecution = System.currentTimeMillis() - startTimeExecution;

		} catch (Exception e) {
			statusCode = BAD_REQUEST;
			exception = e;
		} finally {
			portalLogService.enviaLogIntegracao(SiglaIntegracaoEnum.PORTO_MS_PRODUTO.toString(), "consultaPessoas",
					cpfCnpj, request, pessoas, statusCode, 0, timeTakenExecution, exception, null);
		}
		return pessoas;
	}

}
