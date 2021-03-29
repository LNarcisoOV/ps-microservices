package com.porto.portocom.portal.cliente.v1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.restart.RestartEndpoint;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService implements IApplicationService{

	@Autowired 
	private RestartEndpoint restartEndpoint;

	public void restart() {
		restartEndpoint.restart();
	}
}
