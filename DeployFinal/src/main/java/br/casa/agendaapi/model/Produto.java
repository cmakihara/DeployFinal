package br.casa.agendaapi.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "produto")
public class Produto {
	
	
	@Id
	@Column(name = "id_produto")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id_produto;
	
	
	@Column(name = "nomeproduto")
	private String nomeproduto;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "categoria")
	private String categoria;
	
	@Column(name = "medida")
	private String medida;
	
	@Column(name = "qtdMinima")
	private int qtdMinima;
	
	@Column(name = "valor")
	private BigDecimal valor;
	
	@Column(name = "codigoBarra")
	private String codigoBarra;
	
	@Column(name = "fabricante")
	private String fabricante;

	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public String getNomeproduto() {
		return nomeproduto;
	}
	public void setNomeproduto(String nomeproduto) {
		this.nomeproduto = nomeproduto;
	}
	
	public String getCategoria() {
		return categoria;
	}

	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public long getId_produto() {
		return id_produto;
	}
	public void setId_produto(long id_produto) {
		this.id_produto = id_produto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQtdMinima() {
		return qtdMinima;
	}
	public void setQtdMinima(int qtdMinima) {
		this.qtdMinima = qtdMinima;
	}
	public String getCodigoBarra() {
		return codigoBarra;
	}
	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}
	public String getMedida() {
		return medida;
	}
	public void setMedida(String medida) {
		this.medida = medida;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

}
