package br.casa.agendaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.casa.agendaapi.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Transactional
	@Modifying
	@Query("UPDATE Usuario u SET u.inativo = false WHERE u.id_usuario = :id_usuario")
	public void setAtivo(@Param("id_usuario") Long id_usuario);
	
	@Transactional
	@Modifying
	@Query("UPDATE Usuario u SET u.inativo = true WHERE u.id_usuario = :id_usuario")
	public void setInativo(@Param("id_usuario") Long id_usuario);
	
	@Transactional
	@Modifying
	@Query("UPDATE Usuario u SET u.admin = true WHERE u.id_usuario = :id_usuario")
	public void setAdminTrue(@Param("id_usuario") Long id_usuario);
	
	@Transactional
	@Modifying
	@Query("UPDATE Usuario u SET u.admin = false WHERE u.id_usuario = :id_usuario")
	public void setAdminFalse(@Param("id_usuario") Long id_usuario);
}
