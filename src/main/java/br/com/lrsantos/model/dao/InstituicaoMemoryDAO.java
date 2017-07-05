package br.com.lrsantos.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.lrsantos.model.bean.Endereco;
import br.com.lrsantos.model.bean.Instituicao;

@Repository
public class InstituicaoMemoryDAO extends AbstractDAO<Instituicao, Integer> {
	
	public InstituicaoMemoryDAO() {
		Instituicao instituicao = new Instituicao();
		instituicao.setId(1);
		instituicao.setNome("Instituicao 1");
		
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Logradoura 1");
		endereco.setCidade("Cidade 1");
		endereco.setNumero("1");
		instituicao.setEndereco(endereco);
		instituicao.setTelefone("111-1111");
		super.listaTodos().add(instituicao);
		
		instituicao = new Instituicao();
		instituicao.setId(2);
		instituicao.setNome("Instituicao 2");
		endereco = new Endereco();
		endereco.setLogradouro("Logradouro 2");
		endereco.setCidade("Cidade 2");
		endereco.setNumero("2");
		
		instituicao.setEndereco(endereco);
		instituicao.setTelefone("2222-2222");
		super.listaTodos().add(instituicao);
		
		instituicao = new Instituicao();
		instituicao.setId(3);
		instituicao.setNome("Instituicao 3");
		
		endereco = new Endereco();
		endereco.setLogradouro("Logradoura 3");
		endereco.setCidade("Cidade 3");
		endereco.setNumero("3");
		
		instituicao.setEndereco(endereco);
		instituicao.setTelefone("333-3333");
		super.listaTodos().add(instituicao);
		
		instituicao = new Instituicao();
		instituicao.setId(4);
		instituicao.setNome("Instituicao 4");
		
		endereco = new Endereco();
		endereco.setLogradouro("Logradoura 4");
		endereco.setCidade("Cidade 4");
		endereco.setNumero("4");
		
		instituicao.setEndereco(endereco);
		instituicao.setTelefone("444-4444");
		super.listaTodos().add(instituicao);
	}

	@Override
	protected boolean isIgual(Instituicao t1, Instituicao t2) {
		return t1.equals(t1);
	}

	@Override
	protected boolean isMesmoId(Instituicao t1, Integer id) {
		return t1.getId().equals(id);
	}
	
	public List<Instituicao> listPorNome(String nome) {
		List<Instituicao> lista = new ArrayList<Instituicao>();
		for(Instituicao instituicao : this.listaTodos() ){
			if(instituicao.getNome().contains(nome)){
				lista.add(instituicao);
			}
		}
		return lista;
	}



}
