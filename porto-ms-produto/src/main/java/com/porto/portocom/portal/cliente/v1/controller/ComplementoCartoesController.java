package com.porto.portocom.portal.cliente.v1.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.porto.portocom.portal.cliente.v1.constant.ConstantesEnum;
import com.porto.portocom.portal.cliente.v1.dto.complementocartoes.ContaCartao;
import com.porto.portocom.portal.cliente.v1.response.Response;
import com.porto.portocom.portal.cliente.v1.service.IComplementoCartoesService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/cartoes")
@CrossOrigin(origins = "*")
public class ComplementoCartoesController {

	@Autowired
	private IComplementoCartoesService complementoCartoesService;


	@GetMapping("/{cpfCnpj}/conta-cartao-adicional-pj/{origem}")
	@ApiOperation(value = "Consulta Complemento cartão")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Comlemento cartões consultados com sucesso"),
			@ApiResponse(code = 400, message = "Erro ao consultar complementos cartões"),
			@ApiResponse(code = 401, message = "Você não está autorizado a visualizar o recurso"),
			@ApiResponse(code = 403, message = "Acessar o recurso que você estava tentando acessar é proibido"),
			@ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado") })
	public Mono<ResponseEntity<Response<ContaCartao>>> consultaContaCartaoComAdicionalPJ(@PathVariable String cpfCnpj,
			@PathVariable String origem) {
		Response<ContaCartao> response = new Response<>();
		return complementoCartoesService.consultarComplementoCartoes(cpfCnpj, origem).map(listCartoes -> {
			response.setData(listCartoes);
			response.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}).onErrorResume(error -> {
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
