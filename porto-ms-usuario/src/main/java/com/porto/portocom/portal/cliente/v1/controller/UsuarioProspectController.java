package com.porto.portocom.portal.cliente.v1.controller;

import java.util.Arrays;

import javax.validation.Valid;

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

import com.porto.portocom.portal.cliente.entity.TipoUsuario;
import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.v1.exception.CadastroException;
import com.porto.portocom.portal.cliente.v1.exception.CpfCnpjInvalidoException;
import com.porto.portocom.portal.cliente.v1.exception.UsuarioPortalException;
import com.porto.portocom.portal.cliente.v1.response.Response;
import com.porto.portocom.portal.cliente.v1.service.IProspectService;
import com.porto.portocom.portal.cliente.v1.vo.usuario.CadastroUsuarioProspect;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Mono;

@Deprecated
@RestController
@RequestMapping("/v1/usuario")
@CrossOrigin(origins = "*")
public class UsuarioProspectController {

	@Autowired
	private IProspectService prospectService;

	@Deprecated
	@GetMapping("/define/prospect/{cpfCnpj}")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso ao definir prospect"),
			@ApiResponse(code = 400, message = "Erro genérico ocorrido no backend")	})
	public Mono<ResponseEntity<Response<UsuarioPortalCliente>>> defineProspect(@PathVariable String cpfCnpj) {
		return prospectService.definirProspect(cpfCnpj).map(usuarioPortalCliente -> {
			Response<UsuarioPortalCliente> responseUsuarioPortal = new Response<>();
			responseUsuarioPortal.setData(usuarioPortalCliente);
			responseUsuarioPortal.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(responseUsuarioPortal);
		}).onErrorResume(error -> {
			Response<UsuarioPortalCliente> responseUsuarioPortal = new Response<>();
			if (error instanceof CpfCnpjInvalidoException) {
				responseUsuarioPortal.setErrors(Arrays.asList(error.getMessage()));
				responseUsuarioPortal.setStatus(HttpStatus.BAD_REQUEST.value());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseUsuarioPortal));
			} else if (error instanceof UsuarioPortalException) {
				responseUsuarioPortal.setErrors(Arrays.asList(error.getMessage()));
				responseUsuarioPortal.setStatus(((UsuarioPortalException) error).getStatusCode());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseUsuarioPortal));
			} else {
				responseUsuarioPortal.setErrors(Arrays.asList(error.getMessage()));
				responseUsuarioPortal.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseUsuarioPortal));
			}
		});
	}

	@Deprecated
	@GetMapping("/consulta/prospect/{cpfCnpj}")
	@ApiOperation(value = "Consulta prospect")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso ao consultar prospect"),
			@ApiResponse(code = 400, message = "CPF/CNPJ inválido."),
			@ApiResponse(code = 500, message = "Erro inesperado") })
	public Mono<ResponseEntity<Response<Object>>> consultaProspect(@PathVariable String cpfCnpj) {
		return prospectService.consultaProspect(cpfCnpj).map(resultadoReinicia -> {
			Response<Object> responseUsuarioPortal = new Response<>();
			responseUsuarioPortal.setData((TipoUsuario) resultadoReinicia);
			responseUsuarioPortal.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(responseUsuarioPortal);
		}).onErrorResume(error -> {
			Response<Object> responseUsuario = new Response<>();
			if (error instanceof CpfCnpjInvalidoException) {
				responseUsuario.setErrors(Arrays.asList(error.getMessage()));
				responseUsuario.setData((Boolean) false);
				responseUsuario.setStatus(HttpStatus.BAD_REQUEST.value());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseUsuario));
			} else if (error instanceof UsuarioPortalException) {
				responseUsuario.setErrors(Arrays.asList(error.getMessage()));
				responseUsuario.setData((Boolean) false);
				responseUsuario.setStatus(HttpStatus.NOT_FOUND.value());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseUsuario));
			} else {
				responseUsuario.setErrors(Arrays.asList(error.getMessage()));
				responseUsuario.setData((Boolean) false);
				responseUsuario.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseUsuario));
			}

		});
	}

	@Deprecated
	@PostMapping("/cadastro/prospect/{cpfCnpj}")
	@ApiOperation(value = "Cadastro prospect")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Prospect cadastrado com sucesso"),
			@ApiResponse(code = 400, message = "CPF/CNPJ inválido."),
			@ApiResponse(code = 500, message = "Erro inesperado") })
	public Mono<ResponseEntity<Response<Boolean>>> cadastroProspect(@PathVariable String cpfCnpj,
			@RequestBody @Valid CadastroUsuarioProspect usuarioProspect) {
		return prospectService.cadastrarProspect(cpfCnpj, usuarioProspect).map(cadastroProspect -> {
			Response<Boolean> responseCadastroProspect = new Response<>();
			responseCadastroProspect.setData(cadastroProspect);
			responseCadastroProspect.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(responseCadastroProspect);
		}).onErrorResume(error -> {
			Response<Boolean> responseCadastroProspect = new Response<>();
			responseCadastroProspect.setData(false);
			if (error instanceof CpfCnpjInvalidoException) {
				responseCadastroProspect.setErrors(Arrays.asList(error.getMessage()));
				responseCadastroProspect.setStatus(HttpStatus.BAD_REQUEST.value());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseCadastroProspect));
			} else if (error instanceof UsuarioPortalException) {
				responseCadastroProspect.setErrors(Arrays.asList(error.getMessage()));
				responseCadastroProspect.setStatus(((UsuarioPortalException) error).getStatusCode());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseCadastroProspect));
			} else if (error instanceof CadastroException) {
				responseCadastroProspect.setErrors(Arrays.asList(error.getMessage()));
				responseCadastroProspect.setStatus(((CadastroException) error).getStatusCode());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseCadastroProspect));
			} else {
				responseCadastroProspect.setErrors(Arrays.asList(error.getMessage()));
				responseCadastroProspect.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseCadastroProspect));
			}

		});
	}

}
