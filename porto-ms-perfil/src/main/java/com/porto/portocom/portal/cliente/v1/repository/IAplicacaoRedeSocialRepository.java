package com.porto.portocom.portal.cliente.v1.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.porto.portocom.portal.cliente.entity.AplicacaoRedeSocial;

@Repository
public interface IAplicacaoRedeSocialRepository extends JpaRepository<AplicacaoRedeSocial, Serializable> {

	@Query("select u from AplicacaoRedeSocial u where u.textoIdentificadorAplicacaoRedeSocial = :textoIdentificadorAplicacaoRedeSocial")
	AplicacaoRedeSocial findBytextoIdentificadorAplicacaoRedeSocial(
			@Param("textoIdentificadorAplicacaoRedeSocial") String textoIdentificadorAplicacaoRedeSocial);

}
