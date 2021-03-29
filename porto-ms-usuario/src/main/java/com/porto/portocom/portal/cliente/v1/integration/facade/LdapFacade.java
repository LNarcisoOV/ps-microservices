package com.porto.portocom.portal.cliente.v1.integration.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porto.portocom.portal.cliente.entity.UsuarioPortalCliente;
import com.porto.portocom.portal.cliente.v1.constant.TipoUsuarioEnum;
import com.porto.portocom.portal.cliente.v1.integration.ILdapWebService;
import com.porto.portocom.portal.cliente.v1.model.ContaAcessoComSenha;
import com.porto.portocom.portal.cliente.v1.utils.TrataCpfCnpjUtils;
import com.porto.portocom.portal.cliente.v1.vo.usuario.TipoUsuarioVO;
import com.porto.portocom.portal.cliente.v1.wsdl.ldap.ContaAcessoVO;

import reactor.core.publisher.Mono;

@Service
public class LdapFacade implements ILdapFacade {

	private ILdapWebService ldapWebService;
    private final String codigoRAAUTTelemetria = "125";

	@Autowired
	public LdapFacade(ILdapWebService ldapWebService) {
		this.ldapWebService = ldapWebService;
	}

	@Override
	public Mono<Boolean> atualizarSenha(String cpfCnpj, String senha, String errorMessage) {
		try {
			return Mono.just(ldapWebService.atualizarSenha(cpfCnpj, senha, errorMessage));
		} catch (Exception e) {
			return Mono.error(e);
		}
	}

	@Override
	public Mono<Boolean> criarUsuarioComSenha(ContaAcessoComSenha contaAcessoComSenha) {
		try {
		return Mono.just(ldapWebService.criarUsuarioComSenha(contaAcessoComSenha));
		} catch (Exception e) {
			return Mono.error(e);
		}
	}

	@Override
	public Mono<Boolean> criarUsuario(UsuarioPortalCliente usuarioPortal,TipoUsuarioVO tipoUsuarioVO) {
		try {
			
			
			ContaAcessoVO contaAcessoVO = new ContaAcessoVO();
			String cpfCnpj = TrataCpfCnpjUtils.formatarCPFCNPJSemMascara(usuarioPortal.getCnpjCpf(),usuarioPortal.getCnpjOrdem(),
					usuarioPortal.getCnpjCpfDigito());
			
		    if (tipoUsuarioVO.getIdTipoUsuario().equals(TipoUsuarioEnum.PROSPECT_BCC.getCodTipo())) {
		    	contaAcessoVO.getProdutos().add(codigoRAAUTTelemetria + "#" + cpfCnpj);
	        }
		    contaAcessoVO.setNome(usuarioPortal.getNomeUsuarioPortal());
		    contaAcessoVO.setSobreNome("");
		    contaAcessoVO.setUsuario(cpfCnpj);
		return Mono.just(ldapWebService.criarUsuario(contaAcessoVO));
		} catch (Exception e) {
			return Mono.error(e);
		}
	}
}
