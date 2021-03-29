package com.porto.portocom.portal.cliente.v1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.Getter;

@Getter
public class LoginBCCException extends ResponseStatusException {

    private static final long serialVersionUID = -2906059274671259160L;

    public LoginBCCException(HttpStatus statusCode, String mensagem) {
        super(statusCode, mensagem);
    }

}