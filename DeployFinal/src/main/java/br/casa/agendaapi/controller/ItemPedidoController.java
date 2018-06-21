package br.casa.agendaapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.casa.agendaapi.model.ItemPedido;
import br.casa.agendaapi.repository.ItemPedidoRepository;
import br.casa.agendaapi.repository.PedidoRepository;

@RestController
@RequestMapping("/api")
public class ItemPedidoController {

	@Autowired
	ItemPedidoRepository itemPedidoRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	

	@PostMapping("/itempedido")
	public ItemPedido lala(@Valid @RequestBody ItemPedido item) {
		return itemPedidoRepository.save(item);
	}

	@GetMapping("/itempedido")
	public List<ItemPedido> getAllItemPedidos() {
		return itemPedidoRepository.findAll();
	}

	@GetMapping("/itempedido/pedido/{id}")
	public List<ItemPedido> getItemPedidoById(@PathVariable(value = "id") Long id_pedido) {
		return itemPedidoRepository.findAllByPedido(id_pedido);
	}

}
