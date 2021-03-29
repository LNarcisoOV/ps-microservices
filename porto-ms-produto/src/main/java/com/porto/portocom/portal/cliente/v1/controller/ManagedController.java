package com.porto.portocom.portal.cliente.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.porto.portocom.portal.cliente.v1.service.IApplicationService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1/managed")
@CrossOrigin(origins = "*")
public class ManagedController {

	@Autowired
	private IApplicationService applicationService;
	
	@GetMapping("/restart")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Reiniciar serviço"),
			@ApiResponse(code = 500, message = "Erro genérico ocorrido no backend")

	})
	public ResponseEntity<String> restart() {
		applicationService.restart();	
		return ResponseEntity.status(HttpStatus.OK).body("Reiniciando...");
	}
	
}
