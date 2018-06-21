package br.casa.agendaapi.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@Column(name = "id_pedido")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id_pedido;
	
	@Column(name="valor_total")
	private BigDecimal valor_total;
	
	@Column(name="qtd_produto")
	private Long qtd_produto;
	
	@Column(name="confirmado")
	private boolean confirmado;
	
	@JoinColumn(name = "contato_id")
	@ManyToOne(targetEntity = Contato.class, cascade=CascadeType.ALL)
	private Contato contato;

	@ManyToOne(targetEntity = Usuario.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@Column(name="data")
	private Date data;
	
	public Long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}

	public BigDecimal getValor_total() {
		return valor_total;
	}

	public void setValor_total(BigDecimal valor_total) {
		this.valor_total = valor_total;
	}

	public Long getQtd_produto() {
		return qtd_produto;
	}

	public void setQtd_produto(Long qtd_produto) {
		this.qtd_produto = qtd_produto;
	}

	public boolean isConfirmado() {
		return confirmado;
	}

	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	
}
