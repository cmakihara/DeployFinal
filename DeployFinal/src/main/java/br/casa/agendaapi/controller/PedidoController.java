package br.casa.agendaapi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.casa.agendaapi.model.ItemPedido;
import br.casa.agendaapi.model.Pedido;
import br.casa.agendaapi.repository.ContatoRepository;
import br.casa.agendaapi.repository.ItemPedidoRepository;
import br.casa.agendaapi.repository.PedidoRepository;
import br.casa.agendaapi.repository.UsuarioRepository;
import br.casa.dto.PedidoDTO;
import br.casa.email.EnviarEmail;

@RestController
@RequestMapping("/api")
public class PedidoController {
	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	ContatoRepository contatoRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	ItemPedidoRepository itemPedidoRepository;

	@GetMapping("/pedido")
	public List<Pedido> getAllPedidos() {
		return pedidoRepository.findAll();
	}

	@GetMapping("/pedido/{id}")
	public ResponseEntity<Pedido> getPedidoById(@PathVariable(value = "id") Long pedidoId) {
		Pedido pedido = pedidoRepository.findOne(pedidoId);

		if (pedido == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(pedido);

	}

	@PostMapping("/pedido")
		public Pedido createPedido(@Valid @RequestBody Pedido pedido) {
				pedido.setContato(contatoRepository.findOne(pedido.getContato().getId_contato()));
				pedido.setUsuario(usuarioRepository.findOne(pedido.getUsuario().getId_usuario()));
				return pedidoRepository.save(pedido);
	}

	@DeleteMapping("/pedido/{id}")
	public void deletePedido(@PathVariable(value = "id") Long pedidoId) {
		pedidoRepository.delete(pedidoId);
	}

	@PutMapping("/pedido/{id}")
	public Pedido putPedido(@PathVariable(value = "id") Long pedidoId, @Valid @RequestBody Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	@GetMapping("/pedido/usuario/{id}")
	public List<Pedido> getPedidosByUsuario(@PathVariable(value = "id") Long id_usuario) {
		return pedidoRepository.getAllPedidosByUsuario(id_usuario);
	}
	
	@GetMapping("/pedido/confirmar/{id}")
	public void confirmarPedido(@PathVariable(value = "id") Long id_pedido) {
		pedidoRepository.confirmarPedido(id_pedido);
	}
	@GetMapping("pedido/confirmados")
	public List<Pedido> getAllConfirmados(){
		return pedidoRepository.getAllConfirmados();
	}
	
	@GetMapping("pedido/naoconfirmados")
	public List<Pedido> getAllNaoConfirmados(){
		return pedidoRepository.getAllNaoConfirmados();
	}
	
	@GetMapping("pedido/cliente/{id}")
	public List<Pedido> getPedidosByCliente(@PathVariable(value="id") Long id_cliente) {
		return pedidoRepository.getAllPedidosByCliente(id_cliente);
	}
	
	@PostMapping("pedido/email/empresa")
	public void enviarEmailEmpresa(@Valid @RequestBody List<ItemPedido> itens) {
		EnviarEmail em = new EnviarEmail();
		em.enviarParaPrestadora(itens);
	}
	
	@PostMapping("pedido/email/cliente")
	public void enviarEmailCliente(@Valid @RequestBody List<ItemPedido> itens) {
		System.out.println("teste");
		
		ItemPedido item = this.itemPedidoRepository.findOne(itens.get(0).getId_itempedido());
		List<ItemPedido> listaItens = this.itemPedidoRepository.findAllByPedido(item.getPedido().getId_pedido());
		
		EnviarEmail em = new EnviarEmail();
		em.enviarParaCliente(listaItens);
	}

}
