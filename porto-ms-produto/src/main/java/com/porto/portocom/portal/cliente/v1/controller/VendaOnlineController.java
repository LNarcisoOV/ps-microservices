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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.porto.portocom.portal.cliente.v1.constant.ConstantesEnum;
import com.porto.portocom.portal.cliente.v1.dto.vdo.CotacoesVendaOnline;
import com.porto.portocom.portal.cliente.v1.response.Response;
import com.porto.portocom.portal.cliente.v1.service.IVendaOnlineService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/vdo")
@CrossOrigin(origins = "*")
public class VendaOnlineController {

	private static final Logger LOG = LoggerFactory.getLogger(VendaOnlineController.class);

	@Autowired
	private IVendaOnlineService vendaOnlineService;

	@GetMapping("/{cpfCnpj}/cotacoes")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso ao obter cotações."),
			@ApiResponse(code = 400, message = "Erro genérico ocorrido no backend") })
	public Mono<ResponseEntity<Response<CotacoesVendaOnline>>> pesquisaCotacoes(@PathVariable String cpfCnpj) {
		LOG.debug("Controlador obtém as cotações por CPF/CNPJ");
		return vendaOnlineService.pesquisaCotacoes(cpfCnpj).map(result -> {
			Response<CotacoesVendaOnline> response = new Response<>();
			response.setData(result);
			response.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}).onErrorResume(error -> {
			LOG.error(error.getMessage(), error);
			Response<CotacoesVendaOnline> response = new Response<>();
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
