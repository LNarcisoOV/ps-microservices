package com.porto.portocom.portal.cliente.v1.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

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

import com.porto.portocom.portal.cliente.v1.exception.CpfCnpjInvalidoException;
import com.porto.portocom.portal.cliente.v1.exception.RedeSocialException;
import com.porto.portocom.portal.cliente.v1.exception.UsuarioPortalException;
import com.porto.portocom.portal.cliente.v1.response.Response;
import com.porto.portocom.portal.cliente.v1.service.IRedeSocialService;
import com.porto.portocom.portal.cliente.v1.vo.RedeSocial;
import com.porto.portocom.portal.cliente.v1.vo.SocialCliente;
import com.porto.portocom.portal.cliente.v1.vo.SocialClienteConsulta;
import com.porto.portocom.portal.cliente.v1.vo.VinculoRedeSocial;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/redesocial")
@CrossOrigin(origins = "*")
public class RedeSocialController {
	
	private static final Logger LOG = LoggerFactory.getLogger(RedeSocialController.class);

	@Autowired
	private IRedeSocialService redeSocialService;

	@PostMapping("/{cpfCnpj}/desvincula")
	@ApiOperation(value = "Desvincula rede social", response = Boolean.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Rede social desvinculada com sucesso"),
			@ApiResponse(code = 400, message = "Erro genérico ocorrido no backend")

	})
	public Mono<ResponseEntity<Response<Boolean>>> desvincular(@PathVariable String cpfCnpj,
			@RequestBody @Valid SocialCliente socialCliente) {

		LOG.debug("Controlador desvincula rede social");
		Response<Boolean> reponseRedeSocialDesvinculada = new Response<>();

		return redeSocialService.desvinculaRedeSocial(cpfCnpj, socialCliente.getIdSocialCliente())
				.map(rsDesvinculada -> {
					reponseRedeSocialDesvinculada.setData(rsDesvinculada);
					reponseRedeSocialDesvinculada.setStatus(HttpStatus.OK.value());
					return ResponseEntity.status(HttpStatus.OK).body(reponseRedeSocialDesvinculada);
				}).onErrorResume(error -> {
					LOG.error(error.getMessage(), error);
					if (error instanceof CpfCnpjInvalidoException) {
						reponseRedeSocialDesvinculada.setErrors(Arrays.asList(error.getMessage()));
						reponseRedeSocialDesvinculada.setStatus(HttpStatus.BAD_REQUEST.value());
						return Mono.just(
								ResponseEntity.status(HttpStatus.OK).body(reponseRedeSocialDesvinculada));
					} else if (error instanceof UsuarioPortalException) {
						reponseRedeSocialDesvinculada.setErrors(Arrays.asList(error.getMessage()));
						reponseRedeSocialDesvinculada.setStatus(((UsuarioPortalException) error).getStatusCode());
						return Mono.just(ResponseEntity.status(HttpStatus.OK).body(reponseRedeSocialDesvinculada));
					} else if (error instanceof RedeSocialException) {
						reponseRedeSocialDesvinculada.setErrors(Arrays.asList(error.getMessage()));
						reponseRedeSocialDesvinculada.setStatus(((RedeSocialException) error).getStatusCode());
						return Mono.just(ResponseEntity.status(HttpStatus.OK).body(reponseRedeSocialDesvinculada));
					} else {
						reponseRedeSocialDesvinculada.setData(false);
						reponseRedeSocialDesvinculada.setErrors(Arrays.asList(error.getMessage()));
						reponseRedeSocialDesvinculada.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
						return Mono.just(
								ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(reponseRedeSocialDesvinculada));
					}
				});
	}


	@PostMapping("/")
	@ApiOperation(value = "Consulta rede social")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Qualquer retorno que não seja exceção "),
			@ApiResponse(code = 400, message = "Erro genérico ocorrido no backend")

	})
	public Mono<ResponseEntity<Response<List<RedeSocial>>>> consultaPorIdRedeSocialAndIdentificadorRedeSocial(@RequestBody @Valid SocialClienteConsulta socialCliente) {

		LOG.debug("Controlador consultaPorIdRedeSocial");
		Response<List<RedeSocial>> responseRedeSocial = new Response<>();
		return redeSocialService.consultaPorIdRedeSocialAndIdentificadorRedeSocial(socialCliente)
				.map(redeSocial -> {
					responseRedeSocial.setData(redeSocial);
					responseRedeSocial.setStatus(HttpStatus.OK.value());
					return ResponseEntity.status(HttpStatus.OK).body(responseRedeSocial);
				}).onErrorResume(error -> {
					LOG.error(error.getMessage(), error);
					if (error instanceof UsuarioPortalException) {
						responseRedeSocial.setErrors(Arrays.asList(error.getMessage()));
						responseRedeSocial.setStatus(((UsuarioPortalException) error).getStatusCode());
						return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseRedeSocial));
					} else if (error instanceof RedeSocialException) {
						responseRedeSocial.setErrors(Arrays.asList(error.getMessage()));
						responseRedeSocial.setStatus(((RedeSocialException) error).getStatusCode());
						return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseRedeSocial));	
					} else {
						responseRedeSocial.setErrors(Arrays.asList(error.getMessage()));
						responseRedeSocial.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
						return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseRedeSocial));
					}
				});
	}

	@GetMapping("/{cpfCnpj}")
	@ApiOperation(value = "Consulta rede social")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Qualquer retorno que não seja exceção "),
			@ApiResponse(code = 400, message = "Erro genérico ocorrido no backend") })
	public Mono<ResponseEntity<Response<List<RedeSocial>>>> consultaPorCpf(@PathVariable String cpfCnpj) {

		LOG.debug("Controlador consultaPorIdRedeSocial");
		Response<List<RedeSocial>> responseRedeSocial = new Response<>();
		return redeSocialService.consultaPorCpfCnpj(cpfCnpj).map(listRedeSocial -> {
			responseRedeSocial.setData(listRedeSocial);
			responseRedeSocial.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(responseRedeSocial);
		}).onErrorResume(error -> {
			LOG.error(error.getMessage(), error);
			if (error instanceof CpfCnpjInvalidoException) {
				responseRedeSocial.setStatus(HttpStatus.BAD_REQUEST.value());
				responseRedeSocial.setErrors(Arrays.asList(error.getMessage()));
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseRedeSocial));
			} else if (error instanceof UsuarioPortalException) {
				responseRedeSocial.setErrors(Arrays.asList(error.getMessage()));
				responseRedeSocial.setStatus(((UsuarioPortalException) error).getStatusCode());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseRedeSocial));
			} else {
				responseRedeSocial.setErrors(Arrays.asList(error.getMessage()));
				responseRedeSocial.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
				return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseRedeSocial));
			}
		});
	}

	@PostMapping("/{cpfCnpj}/vincula")
	@ApiOperation(value = "Vincula rede social", response = RedeSocial.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Qualquer retorno que não seja exceção "),
			@ApiResponse(code = 400, message = "Erro genérico ocorrido no backend") })
	public Mono<ResponseEntity<Response<Boolean>>> vinculaRedeSocial(
			@RequestBody @Valid VinculoRedeSocial vinculoRedeSocial, @PathVariable String cpfCnpj) {
		Response<Boolean> responseVinculoRedeSocial = new Response<>();
		return redeSocialService.vinculaRedeSocial(cpfCnpj, vinculoRedeSocial).map(sucesso -> {
			responseVinculoRedeSocial.setData(sucesso);
			responseVinculoRedeSocial.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(responseVinculoRedeSocial);

		}).onErrorResume(error -> {
			LOG.error(error.getMessage(), error);
			if (error instanceof CpfCnpjInvalidoException) {
				responseVinculoRedeSocial.setErrors(Arrays.asList(error.getMessage()));
				return Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseVinculoRedeSocial));
			} else if (error instanceof UsuarioPortalException) {
				responseVinculoRedeSocial.setErrors(Arrays.asList(error.getMessage()));
				responseVinculoRedeSocial.setStatus(((UsuarioPortalException) error).getStatusCode());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseVinculoRedeSocial));
			} else if (error instanceof RedeSocialException) {
				responseVinculoRedeSocial.setErrors(Arrays.asList(error.getMessage()));
				responseVinculoRedeSocial.setStatus(((RedeSocialException) error).getStatusCode());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseVinculoRedeSocial));
			} else {
				responseVinculoRedeSocial.setErrors(Arrays.asList(error.getMessage()));
				responseVinculoRedeSocial.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
				return Mono
						.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseVinculoRedeSocial));
			}
		});
	}
}
