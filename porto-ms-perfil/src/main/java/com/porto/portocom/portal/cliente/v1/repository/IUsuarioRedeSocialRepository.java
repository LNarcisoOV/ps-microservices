package com.porto.portocom.portal.cliente.v1.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.porto.portocom.portal.cliente.entity.UsuarioRedeSocial;

@Repository
public interface IUsuarioRedeSocialRepository extends JpaRepository<UsuarioRedeSocial, Serializable> {

	@Query("select u from UsuarioRedeSocial u where u.idSocialCliente = :idSocialCliente")
	UsuarioRedeSocial findByIdRedeSocial(@Param("idSocialCliente") String idSocialCliente);
	
	@Query("select u from UsuarioRedeSocial u where u.idSocialCliente = :idSocialCliente and u.usuarioPortalCliente.idUsuario = :idUsuario")
	UsuarioRedeSocial findByIdRedeSocialAndIdUsuario(@Param("idSocialCliente") String idSocialCliente, @Param("idUsuario") Long idUsuario);
	
	@Query("select u from UsuarioRedeSocial u where u.usuarioPortalCliente.idUsuario = :idUsuario")
	List<UsuarioRedeSocial> findByIdUsuario(@Param("idUsuario") Long idUsuario);
	
	@Query("select u from UsuarioRedeSocial u where u.idSocialCliente = :idSocialCliente "
			+ "and u.aplicacaoRedeSocial.codigoSequencial = :aplicacaoRedeSocialId")
	List<UsuarioRedeSocial> findByIdRedeSocialAndAplicacaoRedeSocialId(@Param("idSocialCliente") String idSocialCliente, 
			@Param("aplicacaoRedeSocialId")Integer aplicacaoRedeSocialId);

}
