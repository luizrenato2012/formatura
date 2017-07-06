package br.com.lrsantos.controller;

import org.springframework.http.HttpHeaders;

public class HeaderFactory {
	
	public HttpHeaders criaHeader(String nome, String conteudo) {
		HttpHeaders headers = new HttpHeaders();
		headers.add(nome, conteudo);
		return headers;
	}
}
