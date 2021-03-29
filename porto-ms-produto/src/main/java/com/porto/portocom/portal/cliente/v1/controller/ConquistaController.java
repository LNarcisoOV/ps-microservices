package com.porto.portocom.portal.cliente.v1.controller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.porto.portocom.portal.cliente.v1.constant.ConstantesEnum;
import com.porto.portocom.portal.cliente.v1.dto.conquista.CadastroClienteConquista;
import com.porto.portocom.portal.cliente.v1.dto.conquista.ClienteConquistaRequest;
import com.porto.portocom.portal.cliente.v1.dto.conquista.IsClienteArenaCadastrado;
import com.porto.portocom.portal.cliente.v1.response.Response;
import com.porto.portocom.portal.cliente.v1.service.IConquistaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/conquista")
@CrossOrigin(origins = "*")
public class ConquistaController {

	private static final Logger LOG = LoggerFactory.getLogger(ConquistaController.class);

	@Autowired
	private IConquistaService conquistaService;

	@PostMapping("/cliente")
	@ApiOperation(value = "Cadastra cliente no Conquista")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Cliente contratado com sucesso"),
			@ApiResponse(code = 400, message = "Erro ao cadastrar Conquista"),
			@ApiResponse(code = 500, message = "Erro inesperado") })
	public Mono<ResponseEntity<Response<CadastroClienteConquista>>> cadastrarClienteConquista(
			@RequestBody ClienteConquistaRequest cadastraCliente) {
		LOG.debug("Controlador que chama o cadastrarClienteArena ");
		return conquistaService.cadastrarClienteArena(cadastraCliente).map(conquistaRetorno -> {
			Response<CadastroClienteConquista> response = new Response<>();
			response.setData(conquistaRetorno);
			response.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}).onErrorResume(error -> {
			LOG.error(error.getMessage(), error);
			Response<CadastroClienteConquista> response = new Response<>();
			response.setErrors(Arrays.asList(error.getMessage()));
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response));
		});
	}

	@GetMapping("/cliente/{cpfCnpj}")
	@ApiOperation(value = "Consulta Cliente no Conquista")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Consulta realizada com sucesso."),
			@ApiResponse(code = 400, message = "Erro ao consultar cliente"),
			@ApiResponse(code = 401, message = "Você não está autorizado a visualizar o recurso"),
			@ApiResponse(code = 403, message = "Acessar o recurso que você estava tentando acessar é proibido"),
			@ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado") })
	public Mono<ResponseEntity<Response<IsClienteArenaCadastrado>>> consultarClienteConquista(
			@PathVariable String cpfCnpj) {
		LOG.debug("Controlador consome obterContrato na BCP");
		return conquistaService.isClienteArenaCadastrado(cpfCnpj).map(conquistaRetorno -> {
			Response<IsClienteArenaCadastrado> response = new Response<>();
			response.setData(conquistaRetorno);
			response.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}).onErrorResume(error -> {
			LOG.error(error.getMessage(), error);
			Response<IsClienteArenaCadastrado> response = new Response<>();
			response.setErrors(Arrays.asList(error.getMessage()));
			if (error.getMessage().equalsIgnoreCase(ConstantesEnum.CPF_CNPJ_INVALIDO.getDescricao())) {
				response.setStatus(HttpStatus.BAD_REQUEST.value());
			} else {
				response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			}
			return Mono.just(ResponseEntity.status(HttpStatus.OK).body(response));
		});
	}

}
