package br.casa.dto;

import java.util.List;

import br.casa.agendaapi.model.ItemPedido;
import br.casa.agendaapi.model.Pedido;

public class PedidoDTO {

	private List<ItemPedido> produtos;
	
	private Pedido pedido;

	public List<ItemPedido> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ItemPedido> produtos) {
		this.produtos = produtos;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}
