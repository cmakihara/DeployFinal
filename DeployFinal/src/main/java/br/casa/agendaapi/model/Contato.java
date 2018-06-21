package br.casa.agendaapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "contato")
public class Contato {
	

	@Id
	@Column(name = "id_contato")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id_contato;
	
	@Column(name = "nomeFantasia")
	private String nomeFantasia;
	
	@Column(name = "razaoSocial")
	private String razaoSocial;
	
	@Column(name = "cnpj")
	private String cnpj;
	
	@Column(name = "telefone1")
	private String telefone1;
	
	@Column(name = "telefone2")
	private String telefone2;
	
	@Column(name = "email")
	private String email;
	
	
	
	//ENDERECO
	
	@Column(name = "logradouro")
	private String logradouro;
	
	@Column(name = "numero")
	private int numero;
	
	@Column(name = "bairro")
	private String bairro;

	@Column(name = "cep")
	private int cep;
	
	@Column(name = "complemento")
	private String complemento;
	
	@Column(name = "observacao")
	private String observacao;
	
	@Column(name = "localidade")
	private String localidade;
	
	@Column(name = "uf")
	private String uf;
	
	
	
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
			
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public String getTelefone() {
		return telefone1;
	}
	public void setTelefone(String telefone1) {
		this.telefone1 = telefone1;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public long getId_contato() {
		return id_contato;
	}
	public void setId_contato(long id_contato) {
		this.id_contato = id_contato;
	}
	
}
