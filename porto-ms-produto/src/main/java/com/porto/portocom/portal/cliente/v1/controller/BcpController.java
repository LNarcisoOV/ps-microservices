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
import com.porto.portocom.portal.cliente.v1.dto.bcp.ContratoBcp;
import com.porto.portocom.portal.cliente.v1.dto.bcp.PessoaBcp;
import com.porto.portocom.portal.cliente.v1.response.Response;
import com.porto.portocom.portal.cliente.v1.service.IBcpService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/bcp")
@CrossOrigin(origins = "*")
public class BcpController {

	private static final Logger LOG = LoggerFactory.getLogger(BcpController.class);

	@Autowired
	private IBcpService bcpService;

	@GetMapping("/{cpfCnpj}/contratos")
	@ApiOperation(value = "Consulta Contratos na BCP")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Contratos consultados com sucesso"),
			@ApiResponse(code = 400, message = "Erro ao consultar contratos"),
			@ApiResponse(code = 401, message = "Você não está autorizado a visualizar o recurso"),
			@ApiResponse(code = 403, message = "Acessar o recurso que você estava tentando acessar é proibido"),
			@ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado") })
	public Mono<ResponseEntity<Response<List<ContratoBcp.Pessoa>>>> consultaContratos(@PathVariable String cpfCnpj) {
		LOG.debug("Controlador consome obterContrato na BCP");
		return bcpService.consultarContratos(cpfCnpj).map(listPessoas -> {
			Response<List<ContratoBcp.Pessoa>> response = new Response<>();
			if (listPessoas.isEmpty()) {
				response.setStatus(HttpStatus.NOT_FOUND.value());
				response.setErrors(Arrays.asList("Consulta sem retorno"));
			} else {
				response.setData(listPessoas);
				response.setStatus(HttpStatus.OK.value());
			}
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}).onErrorResume(error -> {
			LOG.error(error.getMessage(), error);
			Response<List<ContratoBcp.Pessoa>> response = new Response<>();
			response.setErrors(Arrays.asList(error.getMessage()));
			if (error.getMessage().equalsIgnoreCase(ConstantesEnum.CPF_CNPJ_INVALIDO.getDescricao())) {
				response.setStatus(HttpStatus.BAD_REQUEST.value());
			} else {
				response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			}
			return Mono.just(ResponseEntity.status(HttpStatus.OK).body(response));
		});
	}

	@GetMapping("/{cpfCnpj}/pessoas")
	@ApiOperation(value = "Consulta Pessoas na BCP")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Pessoas consultadas com sucesso"),
			@ApiResponse(code = 400, message = "Erro ao consultar pessoas"),
			@ApiResponse(code = 401, message = "Você não está autorizado a visualizar o recurso"),
			@ApiResponse(code = 403, message = "Acessar o recurso que você estava tentando acessar é proibido"),
			@ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado") })
	public Mono<ResponseEntity<Response<List<PessoaBcp.Pessoa>>>> consultaPessoas(@PathVariable String cpfCnpj) {
		LOG.debug("Controlador consome obterPessoas na BCP");
		return bcpService.consultarPessoas(cpfCnpj).map(pessoasBcp -> {
			Response<List<PessoaBcp.Pessoa>> response = new Response<>();
			if (pessoasBcp.isEmpty()) {
				response.setStatus(HttpStatus.NOT_FOUND.value());
				response.setErrors(Arrays.asList("Consulta sem retorno"));
			} else {
				response.setData(pessoasBcp);
				response.setStatus(HttpStatus.OK.value());
			}
			return ResponseEntity.status(HttpStatus.OK).body(response);

		}).onErrorResume(error -> {
			LOG.error(error.getMessage(), error);
			Response<List<PessoaBcp.Pessoa>> reponse = new Response<>();
			reponse.setErrors(Arrays.asList(error.getMessage()));
			if (error.getMessage().equalsIgnoreCase(ConstantesEnum.CPF_CNPJ_INVALIDO.getDescricao())) {
				return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(reponse));
			} else {
				return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(reponse));
			}
		});
	}
}
