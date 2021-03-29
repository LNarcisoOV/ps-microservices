package com.porto.portocom.portal.cliente.v1.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.porto.portocom.portal.cliente.v1.constant.TipoEnvioEnum;
import com.porto.portocom.portal.cliente.v1.constant.TipoFluxoEnum;
import com.porto.portocom.portal.cliente.v1.exception.CodigoSegurancaException;
import com.porto.portocom.portal.cliente.v1.exception.ContadorAcessoException;
import com.porto.portocom.portal.cliente.v1.exception.CpfCnpjInvalidoException;
import com.porto.portocom.portal.cliente.v1.exception.UsuarioPortalException;
import com.porto.portocom.portal.cliente.v1.response.Response;
import com.porto.portocom.portal.cliente.v1.service.ICodigoAcessoService;
import com.porto.portocom.portal.cliente.v1.service.ICodigoAtivacaoService;
import com.porto.portocom.portal.cliente.v1.service.ICodigoRecuperacaoService;
import com.porto.portocom.portal.cliente.v1.service.IContadorAcessoService;
import com.porto.portocom.portal.cliente.v1.service.IUsuarioPortalService;
import com.porto.portocom.portal.cliente.v1.vo.usuario.DadosAcessoVO;
import com.porto.portocom.portal.cliente.v1.vo.usuario.EnviaCodigoSeguranca;
import com.porto.portocom.portal.cliente.v1.vo.usuario.InformacaoCodigoSeguranca;
import com.porto.portocom.portal.cliente.v1.vo.usuario.InformacaoContador;
import com.porto.portocom.portal.cliente.v1.vo.usuario.InformacaoContadorConta;
import com.porto.portocom.portal.cliente.v1.vo.usuario.UsuarioSimplificado;
import com.porto.portocom.portal.cliente.v1.vo.usuario.UsuarioSimplificadoAtivacao;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/usuario")
@CrossOrigin(origins = "*")
public class UsuarioAcessoController {

	private static final Logger LOG = LoggerFactory.getLogger(UsuarioAcessoController.class);

	@Autowired
	private ICodigoAtivacaoService codigoAtivacaoService;

	@Autowired
	private ICodigoRecuperacaoService codigoRecuperacaoService;

	@Autowired
	private IContadorAcessoService contadorAcessoService;

	@Autowired
	private IUsuarioPortalService usuarioPortalService;
	
	@Autowired
	private ICodigoAcessoService codigoAcessoService;
	
	
	@GetMapping("/{cpfCnpj}/dados-acesso")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Sucesso ao consultar dados de acesso"),
			@ApiResponse(code = 400, message = "CPF / CNPJ invalido"),
			@ApiResponse(code = 404, message = "usuário não encontrado"),
			@ApiResponse(code = 500, message = "Erro inesperado não tratado")})
	public Mono<ResponseEntity<Response<DadosAcessoVO>>> getDadosAcesso(@PathVariable String cpfCnpj) {
		Response<DadosAcessoVO> responseCodigoRecuperacao = new Response<>();
		return usuarioPortalService.consultarDadosAcesso(cpfCnpj).map(dados->{
			responseCodigoRecuperacao.setData(dados);
			responseCodigoRecuperacao.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(responseCodigoRecuperacao);
		});
	}	

	@PostMapping("/{cpfCnpj}/valida-codigo-recuperacao/{pin}")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso ao consultar status"),
			@ApiResponse(code = 400, message = "Erro genérico ocorrido no backend") })
	public Mono<ResponseEntity<Response<InformacaoCodigoSeguranca>>> validaCodigoRecuperacao(
			@PathVariable String cpfCnpj, @PathVariable String pin) {
		Response<InformacaoCodigoSeguranca> responseCodigoRecuperacao = new Response<>();
		return codigoRecuperacaoService.validaCodigo(cpfCnpj, pin).map(validaCodigo -> {
			responseCodigoRecuperacao.setData(validaCodigo);
			responseCodigoRecuperacao.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(responseCodigoRecuperacao);

		}).onErrorResume(error -> {
			if (error instanceof CpfCnpjInvalidoException) {
				responseCodigoRecuperacao.setErrors(Arrays.asList(error.getMessage()));
				responseCodigoRecuperacao.setStatus(HttpStatus.BAD_REQUEST.value());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseCodigoRecuperacao));
			} else if (error instanceof CodigoSegurancaException) {
				responseCodigoRecuperacao.setErrors(Arrays.asList(error.getMessage()));
				responseCodigoRecuperacao.setStatus(((CodigoSegurancaException) error).getStatusCode());
				responseCodigoRecuperacao.setData(
						new InformacaoCodigoSeguranca(null, null, ((CodigoSegurancaException) error).getInfContador()));
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseCodigoRecuperacao));
			} else if (error instanceof UsuarioPortalException) {
				responseCodigoRecuperacao.setErrors(Arrays.asList(error.getMessage()));
				responseCodigoRecuperacao.setStatus(((UsuarioPortalException) error).getStatusCode());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseCodigoRecuperacao));
			} else {
				responseCodigoRecuperacao.setErrors(Arrays.asList(error.getMessage()));
				responseCodigoRecuperacao.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseCodigoRecuperacao));
			}
		});

	}

	@PostMapping("/{cpfCnpj}/valida-codigo-ativacao/{pin}")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso ao consultar status"),
			@ApiResponse(code = 400, message = "Erro genérico ocorrido no backend") })
	public Mono<ResponseEntity<Response<InformacaoCodigoSeguranca>>> validaCodigoAtivacao(@PathVariable String cpfCnpj,
			@PathVariable String pin) {

		Response<InformacaoCodigoSeguranca> responseCodigoAtivacao = new Response<>();
		return codigoAtivacaoService.validaCodigoAtivacao(cpfCnpj, pin).map(validaCodigo -> {
			responseCodigoAtivacao.setData(validaCodigo);
			responseCodigoAtivacao.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(responseCodigoAtivacao);

		}).onErrorResume(error -> {
			if (error instanceof CpfCnpjInvalidoException) {
				responseCodigoAtivacao.setErrors(Arrays.asList(error.getMessage()));
				responseCodigoAtivacao.setStatus(HttpStatus.BAD_REQUEST.value());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseCodigoAtivacao));
			} else if (error instanceof CodigoSegurancaException) {
				responseCodigoAtivacao.setErrors(Arrays.asList(error.getMessage()));
				responseCodigoAtivacao.setStatus(((CodigoSegurancaException) error).getStatusCode());
				responseCodigoAtivacao.setData(
						new InformacaoCodigoSeguranca(null, null, ((CodigoSegurancaException) error).getInfContador()));
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseCodigoAtivacao));
			} else if (error instanceof UsuarioPortalException) {
				responseCodigoAtivacao.setErrors(Arrays.asList(error.getMessage()));
				responseCodigoAtivacao.setStatus(((UsuarioPortalException) error).getStatusCode());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseCodigoAtivacao));
			} else {
				responseCodigoAtivacao.setErrors(Arrays.asList(error.getMessage()));
				responseCodigoAtivacao.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseCodigoAtivacao));
			}
		});
	}

	@PostMapping("/{cpfCnpj}/envia-codigo-ativacao-hard/email")
	@ApiOperation(value = "Enviar codigo ativação email")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Código enviado com sucesso"),
			@ApiResponse(code = 500, message = "Erro inesperado") })
	public Mono<ResponseEntity<Response<EnviaCodigoSeguranca>>> enviaCodigoAtivacaoEmailHard(@PathVariable String cpfCnpj) {
		Response<EnviaCodigoSeguranca> responseEnviaCodigoSeguranca = new Response<>();
		return codigoAtivacaoService.enviaCodigoAtivacao(cpfCnpj, TipoEnvioEnum.EMAIL, TipoFluxoEnum.HARD).map(resultadoEnvioEmail -> {
			responseEnviaCodigoSeguranca.setData(resultadoEnvioEmail);
			responseEnviaCodigoSeguranca.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(responseEnviaCodigoSeguranca);
		});
	}
	
	@PostMapping("/{cpfCnpj}/envia-codigo-ativacao-hard/celular")
	@ApiOperation(value = "Enviar codigo ativação celular")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Código enviado com sucesso"),
			@ApiResponse(code = 500, message = "Erro inesperado") })
	public Mono<ResponseEntity<Response<EnviaCodigoSeguranca>>> enviaCodigoAtivacaoCelularHard(
			@PathVariable String cpfCnpj) {
		Response<EnviaCodigoSeguranca> responseEnviaCodigoSeguranca = new Response<>();
		return codigoAtivacaoService.enviaCodigoAtivacao(cpfCnpj, TipoEnvioEnum.CELULAR, TipoFluxoEnum.HARD)
				.map(resultadoEnvioCelular -> {
					responseEnviaCodigoSeguranca.setData(resultadoEnvioCelular);
					responseEnviaCodigoSeguranca.setStatus(HttpStatus.OK.value());
					return ResponseEntity.status(HttpStatus.OK).body(responseEnviaCodigoSeguranca);
				});
	}
	
	@PostMapping("/{cpfCnpj}/envia-codigo-ativacao/email")
	@ApiOperation(value = "Enviar codigo ativação email")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Código enviado com sucesso"),
			@ApiResponse(code = 500, message = "Erro inesperado") })
	public Mono<ResponseEntity<Response<EnviaCodigoSeguranca>>> enviaCodigoAtivacaoEmail(@PathVariable String cpfCnpj) {
		Response<EnviaCodigoSeguranca> responseEnviaCodigoSeguranca = new Response<>();
		return codigoAtivacaoService.enviaCodigoAtivacao(cpfCnpj, TipoEnvioEnum.EMAIL, TipoFluxoEnum.SIMPLES)
				.map(resultadoEnvioEmail -> {
					responseEnviaCodigoSeguranca.setData(resultadoEnvioEmail);
					responseEnviaCodigoSeguranca.setStatus(HttpStatus.OK.value());
					return ResponseEntity.status(HttpStatus.OK).body(responseEnviaCodigoSeguranca);
				});
	}

	@PostMapping("/{cpfCnpj}/envia-codigo-ativacao/celular")
	@ApiOperation(value = "Enviar codigo ativação celular")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Código enviado com sucesso"),
			@ApiResponse(code = 500, message = "Erro inesperado") })
	public Mono<ResponseEntity<Response<EnviaCodigoSeguranca>>> enviaCodigoAtivacaoCelular(@PathVariable String cpfCnpj) {
		Response<EnviaCodigoSeguranca> responseEnviaCodigoSeguranca = new Response<>();
		return codigoAtivacaoService.enviaCodigoAtivacao(cpfCnpj, TipoEnvioEnum.CELULAR, TipoFluxoEnum.SIMPLES).map(resultadoEnvioCelular -> {
			responseEnviaCodigoSeguranca.setData(resultadoEnvioCelular);
			responseEnviaCodigoSeguranca.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(responseEnviaCodigoSeguranca);
		});
	}

	@GetMapping("/{cpfCnpj}/contadores")
	@ApiOperation(value = "Consultar contadores")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Contador retornado com sucesso"),
			@ApiResponse(code = 500, message = "Erro inesperado") })
	public Mono<ResponseEntity<Response<InformacaoContador>>> consultarContadoresTentativaAcesso(
			@PathVariable String cpfCnpj) {
		return contadorAcessoService.consultaContadoresTentativaAcesso(cpfCnpj).map(resultadoContador -> {
			Response<InformacaoContador> responseContador = new Response<>();
			responseContador.setData(resultadoContador);
			responseContador.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(responseContador);
		}).onErrorResume(error -> {
			Response<InformacaoContador> responseContador = new Response<>();
			if (error instanceof CpfCnpjInvalidoException) {
				responseContador.setErrors(Arrays.asList(error.getMessage()));
				responseContador.setStatus(HttpStatus.BAD_REQUEST.value());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseContador));
			} else if (error instanceof ContadorAcessoException) {
				responseContador.setErrors(Arrays.asList(error.getMessage()));
				responseContador.setStatus(((ContadorAcessoException) error).getStatusCode());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseContador));
			} else {
				responseContador.setErrors(Arrays.asList(error.getMessage()));
				responseContador.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseContador));
			}
		});
	}

	@PostMapping("/{cpfCnpj}/incrementa-tentativa-acesso")
	@ApiOperation(value = "Incrementar tentativa de acesso")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Tentativa de acesso incrementada com sucesso"),
			@ApiResponse(code = 500, message = "Erro inesperado") })
	public Mono<ResponseEntity<Response<InformacaoContadorConta>>> incrementarTentativaAcesso(
			@PathVariable String cpfCnpj) {
		LOG.debug("Controlador envia cpfCnpj");
		Response<InformacaoContadorConta> response = new Response<>();

		return contadorAcessoService.adicionaTentativa(cpfCnpj).map(tentativaDeIncremento -> {
			response.setData(tentativaDeIncremento);
			response.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(response);

		}).onErrorResume(error -> {
			if (error instanceof CpfCnpjInvalidoException) {
				response.setErrors(Arrays.asList(error.getMessage()));
				response.setStatus(HttpStatus.BAD_REQUEST.value());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(response));
			} else if (error instanceof ContadorAcessoException) {
				response.setData(((ContadorAcessoException) error).getInfContador());
				response.setErrors(Arrays.asList(error.getMessage()));
				response.setStatus(((ContadorAcessoException) error).getStatusCode());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(response));
			} else {
				response.setErrors(Arrays.asList(error.getMessage()));
				response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(response));
			}
		});
	}

	@PostMapping("/{cpfCnpj}/reinicia-tentativa-acesso")
	@ApiOperation(value = "Reiniciar Tentativa Acesso")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Contador reiniciado com sucesso"),
			@ApiResponse(code = 500, message = "Erro inesperado") })
	public Mono<ResponseEntity<Response<Boolean>>> reiniciarTentativaAcesso(@PathVariable String cpfCnpj) {
		return contadorAcessoService.reinicia(cpfCnpj).map(resultadoReinicia -> {
			Response<Boolean> responseUsuarioPortal = new Response<>();
			responseUsuarioPortal.setData(resultadoReinicia);
			responseUsuarioPortal.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(responseUsuarioPortal);
		}).onErrorResume(error -> {
			Response<Boolean> responseUsuario = new Response<>();
			responseUsuario.setData(false);
			if (error instanceof CpfCnpjInvalidoException) {
				responseUsuario.setErrors(Arrays.asList(error.getMessage()));
				responseUsuario.setStatus(HttpStatus.BAD_REQUEST.value());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseUsuario));
			} else if (error instanceof ContadorAcessoException) {
				responseUsuario.setErrors(Arrays.asList(error.getMessage()));
				responseUsuario.setStatus(((ContadorAcessoException) error).getStatusCode());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseUsuario));
			} else {
				responseUsuario.setErrors(Arrays.asList(error.getMessage()));
				responseUsuario.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseUsuario));
			}

		});
	}

	@GetMapping("/{cpfCnpj}/ativacao")
	@ApiImplicitParam(name = "corporativoRequestHeader", value = "corporativoRequestHeader", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "corporativoRequestHeader")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso ao obter usuário"),
			@ApiResponse(code = 500, message = "Erro interno no servidor"), })
	public Mono<ResponseEntity<Response<List<UsuarioSimplificadoAtivacao>>>> consultaSimplificada(
			@PathVariable String cpfCnpj) {
		LOG.debug("Controlador envia CPF/CNPJ para a service");
		Response<List<UsuarioSimplificadoAtivacao>> responseUsuario = new Response<>();
		return usuarioPortalService.consultaUsuarioSimplificado(cpfCnpj, null).map(clienteVO -> {
			responseUsuario.setData(clienteVO);
			responseUsuario.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(responseUsuario);
		}).onErrorResume(error -> {
			if (error instanceof UsuarioPortalException) {
				LOG.error(error.getMessage(), error);
				responseUsuario.setErrors(Arrays.asList(error.getMessage()));
				responseUsuario.setData(new ArrayList<>());
				responseUsuario.setStatus(((UsuarioPortalException) error).getStatusCode());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseUsuario));
			} else if (error instanceof CpfCnpjInvalidoException) {
				LOG.error(error.getMessage(), error);
				responseUsuario.setErrors(Arrays.asList(error.getMessage()));
				responseUsuario.setStatus(HttpStatus.BAD_REQUEST.value());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseUsuario));
			} else {
				LOG.error(error.getMessage(), error);
				responseUsuario.setErrors(Arrays.asList(error.getMessage()));
				responseUsuario.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseUsuario));
			}
		});
	}

	@PostMapping("/{cpfCnpj}/envia-codigo-recuperacao/celular")
	@ApiOperation(value = "Enviar codigo recuperação celular")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Código enviado com sucesso"),
			@ApiResponse(code = 500, message = "Erro inesperado") })
	public Mono<ResponseEntity<Response<EnviaCodigoSeguranca>>> enviaCodigoRecuperacaoCelular(
			@PathVariable String cpfCnpj) {
		Response<EnviaCodigoSeguranca> responseEnviaCodigoSeguranca = new Response<>();
		return codigoRecuperacaoService.enviaCodigo(cpfCnpj, TipoEnvioEnum.CELULAR).map(resultadoEnvioCelular -> {
			responseEnviaCodigoSeguranca.setData(resultadoEnvioCelular);
			responseEnviaCodigoSeguranca.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(responseEnviaCodigoSeguranca);
		});
	}

	@PostMapping("/{cpfCnpj}/envia-codigo-recuperacao/email")
	@ApiOperation(value = "Enviar codigo recuperação por email")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Código enviado com sucesso"),
			@ApiResponse(code = 500, message = "Erro inesperado") })
	public Mono<ResponseEntity<Response<EnviaCodigoSeguranca>>> enviaCodigoRecuperacaoEmail(
			@PathVariable String cpfCnpj) {
		Response<EnviaCodigoSeguranca> responseEnviaCodigoSeguranca = new Response<>();
		return codigoRecuperacaoService.enviaCodigo(cpfCnpj, TipoEnvioEnum.EMAIL).map(resultadoEnvioCelular -> {
			responseEnviaCodigoSeguranca.setData(resultadoEnvioCelular);
			responseEnviaCodigoSeguranca.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(responseEnviaCodigoSeguranca);
		});
	}

	@GetMapping("/{cpfCnpj}/recuperacao")
	@ApiImplicitParam(name = "corporativoRequestHeader", value = "corporativoRequestHeader", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "corporativoRequestHeader")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso ao obter usuário"),
			@ApiResponse(code = 500, message = "Erro genérico ocorrido no backend") })
	public Mono<ResponseEntity<Response<List<UsuarioSimplificado>>>> consultaSimplificadaRecuperacao(
			@PathVariable String cpfCnpj) {
		LOG.debug("Controlador envia CPF/CNPJ para a service");
		Response<List<UsuarioSimplificado>> responseUsuario = new Response<>();
		return usuarioPortalService.consultaUsuarioSimplificadoRecuperacao(cpfCnpj).map(usuario -> {
			responseUsuario.setData(usuario);
			responseUsuario.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(responseUsuario);
		}).onErrorResume(error -> {
			responseUsuario.setErrors(Arrays.asList(error.getMessage()));
			if (error instanceof CpfCnpjInvalidoException) {
				responseUsuario.setStatus(HttpStatus.BAD_REQUEST.value());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseUsuario));
			} else if (error instanceof UsuarioPortalException) {
				responseUsuario.setStatus(((UsuarioPortalException) error).getStatusCode());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseUsuario));
			} else {
				responseUsuario.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseUsuario));
			}
		});
	}
	
	@PostMapping("/{cpfCnpj}/envia-codigo-acesso/email")
	@ApiOperation(value = "Enviar codigo de acesso por email")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Código enviado com sucesso"),
			@ApiResponse(code = 400, message = "Erro genérico ocorrido no backend"),
			@ApiResponse(code = 500, message = "Erro inesperado")})
	public Mono<ResponseEntity<Response<EnviaCodigoSeguranca>>> enviaCodigoAcessoEmail(
			@PathVariable String cpfCnpj) {
		Response<EnviaCodigoSeguranca> response = new Response<>();
		return codigoAcessoService.enviaCodigoAcesso(cpfCnpj, TipoEnvioEnum.EMAIL).map(resultadoEnvioEmail -> {
			response.setData(resultadoEnvioEmail);
			response.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}).onErrorResume(error -> {
			response.setData(new EnviaCodigoSeguranca(null, null, false));
			if (error instanceof CpfCnpjInvalidoException) {
				response.setErrors(Arrays.asList(error.getMessage()));
				response.setStatus(HttpStatus.BAD_REQUEST.value());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(response));
			} else if (error instanceof UsuarioPortalException) {
				response.setErrors(Arrays.asList(error.getMessage()));
				response.setStatus(((UsuarioPortalException) error).getStatusCode());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(response));
			} else if (error instanceof CodigoSegurancaException) {
				response.setErrors(Arrays.asList(error.getMessage()));
				response.setStatus(((CodigoSegurancaException) error).getStatusCode());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(response));
			} else {
				response.setErrors(Arrays.asList(error.getMessage()));
				response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(response));
			}

		});
	}
	
	@PostMapping("/{cpfCnpj}/envia-codigo-acesso/celular")
	@ApiOperation(value = "Enviar código de acesso por celular")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Código enviado com sucesso"),
			@ApiResponse(code = 400, message = "Erro genérico ocorrido no backend"),
			@ApiResponse(code = 500, message = "Erro inesperado")})
	public Mono<ResponseEntity<Response<EnviaCodigoSeguranca>>> enviaCodigoAcessoCelular(
			@PathVariable String cpfCnpj) {
		Response<EnviaCodigoSeguranca> response = new Response<>();
		return codigoAcessoService.enviaCodigoAcesso(cpfCnpj, TipoEnvioEnum.CELULAR).map(resultadoEnvioCelular -> {
			response.setData(resultadoEnvioCelular);
			response.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}).onErrorResume(error -> {
			response.setData(new EnviaCodigoSeguranca(null, null, false));
			if (error instanceof CpfCnpjInvalidoException) {
				response.setErrors(Arrays.asList(error.getMessage()));
				response.setStatus(HttpStatus.BAD_REQUEST.value());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(response));
			} else if (error instanceof UsuarioPortalException) {
				response.setErrors(Arrays.asList(error.getMessage()));
				response.setStatus(((UsuarioPortalException) error).getStatusCode());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(response));
			} else if (error instanceof CodigoSegurancaException) {
				response.setErrors(Arrays.asList(error.getMessage()));
				response.setStatus(((CodigoSegurancaException) error).getStatusCode());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(response));
			} else {
				response.setErrors(Arrays.asList(error.getMessage()));
				response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(response));
			}

		});
	}

	@GetMapping("/{idUsuario}/acesso")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Permitido acesso ao usuario"),
			@ApiResponse(code = 500, message = "Erro genérico ocorrido no backend") })
	public Mono<ResponseEntity<Response<Boolean>>> validaAcesso(@PathVariable Long idUsuario) {
		Response<Boolean> permitiAcesso = new Response<>();
		return this.contadorAcessoService.permiteAcesso(idUsuario).map(usuario -> {
			permitiAcesso.setData(usuario);
			permitiAcesso.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(permitiAcesso);
		});
	}
	
	
	@PostMapping("/{cpfCnpj}/acesso-sucesso")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Informa uma tentativa de login com sucesso"),
			@ApiResponse(code = 400, message = "Erro genérico ocorrido no backend") })
	public Mono<ResponseEntity<Response<Boolean>>> acessoLoginSucesso(
			@PathVariable String cpfCnpj) {
		Response<Boolean> responseContador = new Response<>();
		return contadorAcessoService.registrarAcessoSucesso(cpfCnpj).map(resultadoRegistrarSucesso -> {
			responseContador.setData(resultadoRegistrarSucesso);
			responseContador.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(responseContador);
		});
	}	
	
	@PostMapping("/{cpfCnpj}/acesso-falha")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Registra falha ao tentar logar"),
	@ApiResponse(code = 400, message = "Erro genérico ocorrido no backend") })
	public Mono<ResponseEntity<Response<InformacaoContadorConta>>> registrarAcessoFalha(@PathVariable String cpfCnpj) {
		Response<InformacaoContadorConta> permiteAcesso = new Response<>();
		return this.contadorAcessoService.registrarAcessoFalha(cpfCnpj).map(resultadoRegistrarFalha -> {
			permiteAcesso.setData(resultadoRegistrarFalha);
			permiteAcesso.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(permiteAcesso);
		});
	}

	@PostMapping("/{cpfCnpj}/valida-codigo-acesso/{pin}")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso na validação do código de acesso"),
			@ApiResponse(code = 400, message = "Erro genérico ocorrido no backend") })
	public Mono<ResponseEntity<Response<InformacaoCodigoSeguranca>>> validaCodigoAcesso(@PathVariable String cpfCnpj,
			@PathVariable String pin) {
		Response<InformacaoCodigoSeguranca> responseValidadoSucesso = new Response<>();
		return codigoAcessoService.validaCodigoAcesso(cpfCnpj, pin).map(validaCodigo -> {
			responseValidadoSucesso.setData(validaCodigo);
			responseValidadoSucesso.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(responseValidadoSucesso);
		});
	}
}
