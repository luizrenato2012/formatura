package br.com.lrsantos.model.bean;

import org.springframework.stereotype.Repository;

@Repository
public class InstituicaoMemoryDAO extends AbstractDAO<Instituicao, Integer> {
	
	public InstituicaoMemoryDAO() {
		Instituicao instituicao = new Instituicao();
		instituicao.setId(1);
		instituicao.setNome("Instituicao 1");
		instituicao.setEndereço("Endereço 1 ");
		instituicao.setTelefone("111-1111");
		super.listaTodos().add(instituicao);
		
		instituicao = new Instituicao();
		instituicao.setId(2);
		instituicao.setNome("Instituicao 2");
		instituicao.setEndereço("Endereço 2 ");
		instituicao.setTelefone("2222-2222");
		super.listaTodos().add(instituicao);
		
		instituicao = new Instituicao();
		instituicao.setId(3);
		instituicao.setNome("Instituicao 3");
		instituicao.setEndereço("Endereço 3 ");
		instituicao.setTelefone("333-3333");
		super.listaTodos().add(instituicao);
		
		instituicao = new Instituicao();
		instituicao.setId(4);
		instituicao.setNome("Instituicao 4");
		instituicao.setEndereço("Endereço 4 ");
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



}
