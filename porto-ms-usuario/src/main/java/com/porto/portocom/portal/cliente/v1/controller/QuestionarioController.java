package com.porto.portocom.portal.cliente.v1.controller;

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

import com.porto.portocom.portal.cliente.v1.response.Response;
import com.porto.portocom.portal.cliente.v1.service.IConfirmacaoPositivaService;
import com.porto.portocom.portal.cliente.v1.vo.kba.AvalicaoRespostaVO;
import com.porto.portocom.portal.cliente.v1.vo.kba.KbaAnswersVO;
import com.porto.portocom.portal.cliente.v1.vo.kba.KbaQuizPinVO;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/usuario")
@CrossOrigin(origins = "*")
public class QuestionarioController {

	@Autowired
	private IConfirmacaoPositivaService confirmacaoPositivaService;

	@GetMapping("{cpfCnpj}/questionario")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso ao obter questionario"),
			@ApiResponse(code = 400, message = "Erro genérico ocorrido no backend"),
			@ApiResponse(code = 500, message = "Erro inesperado") })
	public Mono<ResponseEntity<Response<KbaQuizPinVO>>> recuperaQuestionario(@PathVariable String cpfCnpj) {
		Response<KbaQuizPinVO> reponseQuestionario = new Response<>();
		return confirmacaoPositivaService.recuperaQuestionario(cpfCnpj).map(questionarioVO -> {
			reponseQuestionario.setData(questionarioVO);
			reponseQuestionario.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(reponseQuestionario);
		});
	}

	@PostMapping("/avaliacao-respostas-questionario")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso ao obter avaliação questionário"),
			@ApiResponse(code = 400, message = "Erro genérico ocorrido no backend"),
			@ApiResponse(code = 500, message = "Erro inesperado") })
	public Mono<ResponseEntity<Response<AvalicaoRespostaVO>>> recuperaAvalicaoRespostas(
			@RequestBody KbaAnswersVO kbaAnswersVO) {
		Response<AvalicaoRespostaVO> reponseAvalicaoRespostas = new Response<>();
		return confirmacaoPositivaService.enviaRespostaQuestionario(kbaAnswersVO).map(avalicaoRespostaVo -> {
			reponseAvalicaoRespostas.setData(avalicaoRespostaVo);
			reponseAvalicaoRespostas.setStatus(HttpStatus.OK.value());
			return ResponseEntity.status(HttpStatus.OK).body(reponseAvalicaoRespostas);
		});
	}
}
