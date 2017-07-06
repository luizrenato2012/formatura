package br.com.lrsantos.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.lrsantos.model.bean.Instituicao;

@Repository
@Transactional
public class InstituicaoDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void insert(Instituicao instituicao) {
		this.entityManager.persist(instituicao);
	}
	
	public void update(Instituicao instituicao) {
		this.entityManager.merge(instituicao);
	}
	
	public void delete(Integer id) {
		this.entityManager.merge(id);
	}
	
	public Instituicao load(Integer id) {
		return this.entityManager.find(Instituicao.class, id);
	}
	
	public List<Instituicao> listAll() {
		Query query = this.entityManager.createNamedQuery("Instituicao.LIST_ALL");
		return query.getResultList();
	}
	
	public List<Instituicao> listByNome(String nome) {
		Query query = this.entityManager.createNamedQuery("Instituicao.LIST_BY_NOME");
		query.setParameter(1, nome+"%");
		return query.getResultList();
	}
	
}
