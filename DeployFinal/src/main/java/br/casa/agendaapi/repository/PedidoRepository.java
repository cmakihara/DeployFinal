package br.casa.agendaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.casa.agendaapi.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	@Query("SELECT p FROM Pedido p WHERE p.confirmado = true")
	public List<Pedido> getAllConfirmados();
	
	@Query("SELECT p FROM Pedido p WHERE p.confirmado = false")
	public List<Pedido> getAllNaoConfirmados();
	
	@Transactional
	@Modifying
	@Query("UPDATE Pedido p SET p.confirmado = true WHERE p.id_pedido = :id_pedido")
	public void confirmarPedido(@Param("id_pedido") Long id_pedido);
	
	@Query("SELECT p FROM Pedido p WHERE p.usuario.id_usuario = :id_usuario")
	public List<Pedido> getAllPedidosByUsuario(@Param("id_usuario") Long id_usuario);
	
	@Query("SELECT p FROM Pedido p WHERE p.contato.id_contato= :id_cliente")
	public List<Pedido> getAllPedidosByCliente(@Param("id_cliente") Long id_cliente);
}
