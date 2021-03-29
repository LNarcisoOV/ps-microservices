package com.porto.portocom.portal.cliente.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.porto.portocom.portal.cliente.v1.constant.TipoCodigoEnum;
import com.porto.portocom.portal.cliente.v1.service.ILexisNexisService;
import com.porto.portocom.portal.cliente.v1.vo.antifraude.LexisNexisResponse;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/usuario")
@CrossOrigin(origins = "*")
public class LexisNexisController {

	@Autowired
	private ILexisNexisService lexisNexisService;

	@PostMapping("/{cpfCnpj}/valida-lexis-nexis")
	@ApiOperation(value = "Envia dados para o LexisNexis")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso ao enviar dados para o LexisNexis"),
			@ApiResponse(code = 400, message = "Erro genérico"),
			@ApiResponse(code = 500, message = "Erro inesperado") })
	public Mono<ResponseEntity<LexisNexisResponse>> validaLexisNexis(@PathVariable String cpfCnpj,
			@RequestParam TipoCodigoEnum tipoCodigo) {
		LexisNexisResponse response = new LexisNexisResponse();
		if (tipoCodigo == TipoCodigoEnum.ATIVACAO) {
			return lexisNexisService.validaLexisNexisUsuarioSimplificadoAtivacao(cpfCnpj).map(resultadoLexisNexis -> {
				response.setData(resultadoLexisNexis.getT1());
				response.setCorporativoValidation(
						resultadoLexisNexis.getT2().getRequestId() != null ? resultadoLexisNexis.getT2() : null);
				response.setStatus(HttpStatus.OK.value());
				return ResponseEntity.status(HttpStatus.OK).body(response);
			});
		} else if (tipoCodigo == TipoCodigoEnum.RECUPERACAO) {
			return lexisNexisService.validaLexisNexisUsuarioSimplificadoRecuperacao(cpfCnpj)
					.map(resultadoLexisNexis -> {
						response.setData(resultadoLexisNexis.getT1());
						response.setCorporativoValidation(
								resultadoLexisNexis.getT2().getRequestId() != null ? resultadoLexisNexis.getT2()
										: null);
						response.setStatus(HttpStatus.OK.value());
						return ResponseEntity.status(HttpStatus.OK).body(response);
					});
		}
		return Mono.just(ResponseEntity.status(HttpStatus.OK).body(response));
	}
}
