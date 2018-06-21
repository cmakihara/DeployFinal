package br.casa.agendaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "itempedido")
public class ItemPedido {

	
	@Id
	@Column(name = "id_itempedido")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id_itempedido;

	@Column(name="quantidade")
	private int quantidade;
	
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;

	public Long getId_itempedido() {
		return id_itempedido;
	}

	public void setId_itempedido(Long id_itempedido) {
		this.id_itempedido = id_itempedido;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
}
	