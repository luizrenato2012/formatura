package br.com.lrsantos.model.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.lrsantos.model.bean.Instituicao;
import br.com.lrsantos.model.dao.InstituicaoDAO;

@Service
public class InstituicaoService {

	@Autowired
	private InstituicaoDAO instituicaoDAO;
	
	public void delete(Integer id){
		Instituicao instituicao = instituicaoDAO.load(id);
		if(instituicao==null) {
			throw new EmptyResultDataAccessException("Instituicao id["+id+"] não existe", 1);
		}
		instituicaoDAO.delete(instituicao);
	}
	
	public void update(Integer id, Instituicao instituicao) {
		Instituicao instituicaoGravada= this.instituicaoDAO.load(id);
		if(instituicaoGravada==null){
			throw new EmptyResultDataAccessException("Instituicao id["+id+"] não existe", 1);
		}
		BeanUtils.copyProperties(instituicao, instituicaoGravada,"id");
		this.instituicaoDAO.update(instituicaoGravada);
	}
}
