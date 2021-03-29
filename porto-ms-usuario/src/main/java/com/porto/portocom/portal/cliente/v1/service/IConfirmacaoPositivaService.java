package com.porto.portocom.portal.cliente.v1.service;

import com.porto.portocom.portal.cliente.v1.vo.kba.AvalicaoRespostaVO;
import com.porto.portocom.portal.cliente.v1.vo.kba.KbaAnswersVO;
import com.porto.portocom.portal.cliente.v1.vo.kba.KbaQuizPinVO;

import reactor.core.publisher.Mono;

public interface IConfirmacaoPositivaService {

	Mono<KbaQuizPinVO> recuperaQuestionario(String cpf);

	Mono<AvalicaoRespostaVO> enviaRespostaQuestionario(KbaAnswersVO kbaAnswersVO);

}
