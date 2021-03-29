package com.porto.portocom.portal.cliente.v1.controller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.entity.UsuarioStatusConta;
import com.porto.portocom.portal.cliente.v1.constant.TipoCodigoEnum;
import com.porto.portocom.portal.cliente.v1.exception.CadastroException;
import com.porto.portocom.portal.cliente.v1.exception.CodigoSegurancaException;
import com.porto.portocom.portal.cliente.v1.exception.CpfCnpjInvalidoException;
import com.porto.portocom.portal.cliente.v1.exception.IdInvalidoException;
import com.porto.portocom.portal.cliente.v1.exception.LdapException;
import com.porto.portocom.portal.cliente.v1.exception.UsuarioPortalException;
import com.porto.portocom.portal.cliente.v1.response.Response;
import com.porto.portocom.portal.cliente.v1.service.ICadastroService;
import com.porto.portocom.portal.cliente.v1.service.IDadosCadastraisService;
import com.porto.portocom.portal.cliente.v1.service.IUsuarioPortalService;
import com.porto.portocom.portal.cliente.v1.vo.NovoUsuarioESenhaVO;
import com.porto.portocom.portal.cliente.v1.vo.antifraude.LexisNexisResponse;
import com.porto.portocom.portal.cliente.v1.vo.usuario.CadastroSenha;
import com.porto.portocom.portal.cliente.v1.vo.usuario.UsuarioVO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

	private static final Logger LOG = LoggerFactory.getLogger(UsuarioController.class);

	private static final String CPF_CNPJ_DIVEGENTE = "CpfCnpj divergente";

	@Autowired
	private IUsuarioPortalService usuarioPortalService;

	@Autowired
	private IDadosCadastraisService dadosCadastraisService;

	@Autowired
	private ICadastroService cadastroService;

	@GetMapping("/{cpfCnpj}")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso ao obter usuário"),
			@ApiResponse(code = 400, message = "Erro genérico ocorrido no backend") })
	public Mono<ResponseEntity<Response<UsuarioPortalCliente>>> consulta(@PathVariable String cpfCnpj) {
		LOG.debug("Controlador envia CPF/CNPJ para a service");
		return usuarioPortalService.consultar(cpfCnpj).map(clienteVO -> {
			Response<UsuarioPortalCliente> reponseLogon = new Response<>();
			reponseLogon.setData(clienteVO);
			reponseLogon.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(reponseLogon);
		}).onErrorResume(error -> {
			LOG.error(error.getMessage(), error);
			Response<UsuarioPortalCliente> reponseUsuario = new Response<>();
			reponseUsuario.setStatus((HttpStatus.NOT_FOUND.value()));
			reponseUsuario.setErrors(Arrays.asList(error.getMessage()));
			return Mono.just(ResponseEntity.status(HttpStatus.OK).body(reponseUsuario));
		});
	}

	@GetMapping("/{cpfCnpj}/status")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso ao consultar status"),
			@ApiResponse(code = 400, message = "Erro genérico ocorrido no backend") })
	public Mono<ResponseEntity<Response<UsuarioStatusConta>>> consultaStatus(@PathVariable String cpfCnpj) {
		Response<UsuarioStatusConta> responseUsuarioStatus = new Response<>();
		return usuarioPortalService.consultaStatus(cpfCnpj).map(usuarioStatus -> {
			responseUsuarioStatus.setData(usuarioStatus);
			responseUsuarioStatus.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(responseUsuarioStatus);
		}).onErrorResume(error -> {
			if (error instanceof CpfCnpjInvalidoException) {
				responseUsuarioStatus.setErrors(Arrays.asList(error.getMessage()));
				responseUsuarioStatus.setStatus(HttpStatus.BAD_REQUEST.value());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseUsuarioStatus));
			} else if (error instanceof UsuarioPortalException) {
				responseUsuarioStatus.setErrors(Arrays.asList(error.getMessage()));
				responseUsuarioStatus.setStatus(((UsuarioPortalException) error).getStatusCode());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseUsuarioStatus));
			} else {
				responseUsuarioStatus.setErrors(Arrays.asList(error.getMessage()));
				responseUsuarioStatus.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(responseUsuarioStatus));
			}
		});
	}

	@PostMapping("{cpfCnpj}/redefine-senha")
	@ApiOperation(value = "Redefinir senha")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Senha alterada com sucesso"),
			@ApiResponse(code = 400, message = "Erro ao alterar senha"),
			@ApiResponse(code = 401, message = "Você não está autorizado a visualizar o recurso"),
			@ApiResponse(code = 403, message = "Acessar o recurso que você estava tentando acessar é proibido"),
			@ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado") })
	public Mono<ResponseEntity<Response<Boolean>>> redefinirSenha(@PathVariable String cpfCnpj,
			@RequestBody NovoUsuarioESenhaVO novoUsuario) {
		LOG.debug("Controlador envia cpf e nova senha");
		Response<Boolean> reponseSenhaAlterada = new Response<>();
		if (!cpfCnpj.equals(novoUsuario.getNovoUsuario())) {
			LOG.error(CPF_CNPJ_DIVEGENTE);
			reponseSenhaAlterada.setErrors(Arrays.asList(CPF_CNPJ_DIVEGENTE));
			reponseSenhaAlterada.setStatus(HttpStatus.BAD_REQUEST.value());
			return Mono.just(ResponseEntity.status(HttpStatus.OK).body(reponseSenhaAlterada));
		}
		return this.cadastroService.alteraSenhaUsuario(cpfCnpj, novoUsuario.getNovaSenha(), novoUsuario.getPin())
				.map(statusSenha -> {
					reponseSenhaAlterada.setData(statusSenha);
					reponseSenhaAlterada.setStatus(HttpStatus.OK.value());
					return ResponseEntity.status(HttpStatus.OK).body(reponseSenhaAlterada);
				}).onErrorResume(error -> {
					Response<Boolean> response = new Response<>();
					response.setData(false);
					if (error instanceof CpfCnpjInvalidoException || error instanceof LdapException) {
						response.setErrors(Arrays.asList(error.getMessage()));
						response.setStatus(HttpStatus.BAD_REQUEST.value());
						return Mono.just(ResponseEntity.status(HttpStatus.OK).body(response));
					} else if (error instanceof CadastroException) {
						response.setErrors(Arrays.asList(error.getMessage()));
						response.setStatus(((CadastroException) error).getStatusCode());
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

	@PostMapping("/senha")
	@ApiOperation(value = "Cadastrar senha")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Senha cadastrada com sucesso"),
			@ApiResponse(code = 400, message = "Erro ao tentar cadastrar senha"),
			@ApiResponse(code = 500, message = "Erro inesperado") })
	public Mono<ResponseEntity<Response<Boolean>>> cadastroSenha(@RequestBody CadastroSenha cadastro) {
		return this.cadastroService.cadastroSenha(cadastro).map(sucesso -> {
			Response<Boolean> response = new Response<>();
			response.setData(sucesso);
			response.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}).onErrorResume(error -> {
			Response<Boolean> response = new Response<>();
			response.setData(false);
			if (error instanceof CpfCnpjInvalidoException || error instanceof CadastroException
					|| error instanceof LdapException) {
				response.setErrors(Arrays.asList(error.getMessage()));
				response.setStatus(HttpStatus.BAD_REQUEST.value());
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

	@GetMapping("/codigo/{idUsuario}")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso ao obter usuário"),
			@ApiResponse(code = 400, message = "Erro genérico ocorrido no backend") })
	public Mono<ResponseEntity<Response<UsuarioPortalCliente>>> consultaPorCodigoUsuario(@PathVariable Long idUsuario) {
		LOG.debug("Controlador envia CPF/CNPJ para a service");
		return usuarioPortalService.consultarUsuarioPorId(idUsuario).map(clienteVO -> {
			Response<UsuarioPortalCliente> reponseLogon = new Response<>();
			reponseLogon.setData(clienteVO);
			reponseLogon.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(reponseLogon);
		}).onErrorResume(error -> {
			if (error instanceof IdInvalidoException) {
				LOG.error(error.getMessage(), error);
				Response<UsuarioPortalCliente> reponseUsuario = new Response<>();
				reponseUsuario.setStatus((HttpStatus.BAD_REQUEST.value()));
				reponseUsuario.setErrors(Arrays.asList(error.getMessage()));
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(reponseUsuario));
			} else {
				LOG.error(error.getMessage(), error);
				Response<UsuarioPortalCliente> reponseUsuario = new Response<>();
				reponseUsuario.setErrors(Arrays.asList(error.getMessage()));
				reponseUsuario.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
				return Mono.just(ResponseEntity.status(HttpStatus.OK).body(reponseUsuario));
			}
		});
	}

	@PatchMapping
	@ApiOperation(value = "Atualizar dados cadastrais")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Dados cadastrais atualizados com sucesso"),
			@ApiResponse(code = 400, message = "Erro genérico ocorrido no backend"),
			@ApiResponse(code = 500, message = "Erro inesperado") })
	public Mono<ResponseEntity<LexisNexisResponse>> atualizaDadosCadastrais(@RequestBody UsuarioVO usuarioVo,
			@RequestParam TipoCodigoEnum tipoCodigo) {
		LexisNexisResponse response = new LexisNexisResponse();
		return dadosCadastraisService.atualizaDadosCadastrais(usuarioVo, tipoCodigo).map(resultadoLexisNexis -> {
			response.setData(resultadoLexisNexis.getT1());
			response.setCorporativoValidation(
					resultadoLexisNexis.getT2().getRequestId() != null ? resultadoLexisNexis.getT2() : null);
			response.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(response);
		});
	}
}
