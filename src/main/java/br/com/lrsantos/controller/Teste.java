package br.com.lrsantos.controller;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Teste {

	private Integer id;
	
	private String descricao;
	
	@JsonIgnore
	private Date dataCriacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Teste [id=" + id + ", descricao=" + descricao + "]";
	}
	
	
	
}
