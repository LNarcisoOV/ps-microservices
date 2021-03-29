package com.porto.portocom.portal.cliente.v1.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import javax.xml.datatype.DatatypeConfigurationException;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import com.porto.portocom.portal.cliente.v1.constant.ChavesParamEnum;
import com.porto.portocom.portal.cliente.v1.integration.ITokenAAWebService;
import com.porto.portocom.portal.cliente.v1.model.GeraTokenAAResponse;
import com.porto.portocom.portal.cliente.v1.model.ValidaTokenAAResponse;
import com.porto.portocom.portal.cliente.v1.service.ParametrosLocalCacheService;
import com.porto.portocom.portal.cliente.v1.service.TokenAAService;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("unit-test")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TokenAAServiceUnitTest {
	
    private static final String PIN = "123456";
    
    private static final String CPF = "22890390802";
    
    private static final String PROFILE_CLIENTE = "OTP PDC";
    
    private static final String PROFILE_SERVICO = "RECUPERACAO_PDC";
    
    @Mock
    private ITokenAAWebService tokenAAWS;
    
	@Mock
	private static ParametrosLocalCacheService parametrosLocalCacheService;
    
    private GeraTokenAAResponse geraTokenResponse;
    
    private ValidaTokenAAResponse validaTokenResponse;
    
	@InjectMocks
	private TokenAAService tokenAAService;

	
    @Before
    public void init() throws DatatypeConfigurationException {
        MockitoAnnotations.initMocks(this);
        geraTokenResponse = new GeraTokenAAResponse();
        geraTokenResponse.setOtp(PIN);
        geraTokenResponse.setValidityStartTime(LocalDateTime.now());
        geraTokenResponse.setValidityEndTime(LocalDateTime.now());
        
        validaTokenResponse = new ValidaTokenAAResponse();
        validaTokenResponse.setValidityEndTime(LocalDateTime.now());
        validaTokenResponse.setValidityStartTime(LocalDateTime.now());
        validaTokenResponse.setDaysLeftToExpire(2);
    }
	
	@Test
	public void testGeraPinCliente() {
		
		Mockito.when(parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_AA_WS_CLIENT_PROFILE_NAME.getValor()))
		.thenReturn(PROFILE_CLIENTE);
        
        Mockito.when(tokenAAWS.geraTokenAA(CPF, PROFILE_CLIENTE)).thenReturn(Mono.just(geraTokenResponse));
        
        tokenAAService.geraPinCliente(CPF).map(pinVO -> {
        	assertEquals(PIN, pinVO.getPin());
        	return pinVO;
        }).subscribe();
        
        Mockito.verify(parametrosLocalCacheService, Mockito.times(1)).recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_AA_WS_CLIENT_PROFILE_NAME.getValor());
    	Mockito.verify(tokenAAWS, Mockito.times(1)).geraTokenAA(CPF, "OTP PDC");
		
	}
	
	@Test
	public void testGeraPinServico() {
		
		Mockito.when(parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_AA_WS_SERVICE_PROFILE_NAME.getValor()))
		.thenReturn(PROFILE_SERVICO);
        
        Mockito.when(tokenAAWS.geraTokenAA(CPF, PROFILE_SERVICO)).thenReturn(Mono.just(geraTokenResponse));
        
        tokenAAService.geraPinServico(CPF).map(pinVO -> {
        	assertEquals(PIN, pinVO.getPin());
        	return pinVO;
        }).subscribe();
        
        Mockito.verify(parametrosLocalCacheService, Mockito.times(1)).recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_AA_WS_SERVICE_PROFILE_NAME.getValor());
    	Mockito.verify(tokenAAWS, Mockito.times(1)).geraTokenAA(CPF, PROFILE_SERVICO);
		
	}
	
	
	@Test
	public void testValidaPinCliente() {
		
		Mockito.when(parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_AA_WS_CLIENT_PROFILE_NAME.getValor()))
		.thenReturn(PROFILE_CLIENTE);
        
	    Mockito.when(tokenAAWS.validaTokenAA(CPF, PIN, PROFILE_CLIENTE)).thenReturn(Mono.just(validaTokenResponse));
        
        tokenAAService.validaTokenCliente(CPF, PIN).map(retornoValida -> {
        	assertEquals(2,retornoValida.getDaysLeftToExpire());
        	return retornoValida;
        }).subscribe();
        
        Mockito.verify(parametrosLocalCacheService, Mockito.times(1)).recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_AA_WS_CLIENT_PROFILE_NAME.getValor());
    	Mockito.verify(tokenAAWS, Mockito.times(1)).validaTokenAA(CPF, PIN, PROFILE_CLIENTE);
		
	}
	
	@Test
	public void testValidaPinServico() {
		
		Mockito.when(parametrosLocalCacheService.recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_AA_WS_SERVICE_PROFILE_NAME.getValor()))
		.thenReturn(PROFILE_SERVICO);
        
        Mockito.when(tokenAAWS.validaTokenAA(CPF, PIN, PROFILE_SERVICO)).thenReturn(Mono.just(validaTokenResponse));
        
        tokenAAService.validaTokenServico(CPF, PIN).map(retornoValida -> {
        	assertEquals(2,retornoValida.getDaysLeftToExpire());
        	return retornoValida;
        }).subscribe();
        
        Mockito.verify(parametrosLocalCacheService, Mockito.times(1)).recuperaParametro(ChavesParamEnum.PORTO_MS_USUARIO_AA_WS_SERVICE_PROFILE_NAME.getValor());
    	Mockito.verify(tokenAAWS, Mockito.times(1)).validaTokenAA(CPF, PIN, PROFILE_SERVICO);
		
	}
}
