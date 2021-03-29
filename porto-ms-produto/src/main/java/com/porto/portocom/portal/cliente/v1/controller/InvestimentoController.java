package com.porto.portocom.portal.cliente.v1.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.porto.portocom.portal.cliente.v1.constant.ConstantesEnum;
import com.porto.portocom.portal.cliente.v1.dto.investimento.CotistaInvestimento;
import com.porto.portocom.portal.cliente.v1.response.Response;
import com.porto.portocom.portal.cliente.v1.service.IInvestimentoService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/investimento")
@CrossOrigin(origins = "*")
public class InvestimentoController {

	private static final Logger LOG = LoggerFactory.getLogger(InvestimentoController.class);

	@Autowired
	private IInvestimentoService investimento;

	// TODO Alterar no documento o recurso, retirando o nome PorCpfCnpj

	@GetMapping("/cotista/{cpfCnpj}")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso ao obter cotista"),
			@ApiResponse(code = 400, message = "Erro genérico ocorrido no backend")	})
	public Mono<ResponseEntity<Response<List<CotistaInvestimento>>>> consulta(@PathVariable String cpfCnpj) {
		LOG.debug("Controlador envia CPF/CNPJ para a service");
		return investimento.consultaCotistas(cpfCnpj).map(result -> {
			Response<List<CotistaInvestimento>> response = new Response<>();
			if (!result.isEmpty()) {
				response.setData(result);
				response.setStatus(HttpStatus.OK.value());
			} else {
				response.setStatus(HttpStatus.NOT_FOUND.value());
				response.setErrors(Arrays.asList("Consulta sem retorno"));
			}
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}).onErrorResume(error -> {
			LOG.error(error.getMessage(), error);
			Response<List<CotistaInvestimento>> response = new Response<>();
			response.setErrors(Arrays.asList(error.getMessage()));
			if (error.getMessage().equalsIgnoreCase(ConstantesEnum.CPF_CNPJ_INVALIDO.getDescricao())) {
				response.setStatus(HttpStatus.BAD_REQUEST.value());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(response));
			} else {
				response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
				return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response));
			}
		});
	}
}
