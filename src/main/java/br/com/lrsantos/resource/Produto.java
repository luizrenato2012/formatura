package br.com.lrsantos.resource;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Produto {

	private Integer id;

	private String nome;

	private String telefone;
	
	@JsonIgnore
	private Date dataCriacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Produto() {
		super();
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", telefone="
				+ telefone + "]";
	}



}
