package br.com.lrsantos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.lrsantos.model.bean.Instituicao;
import br.com.lrsantos.model.dao.InstituicaoMemoryDAO;

@Controller
@RequestMapping("/instituicao")
public class InstituicaoController {
	
	@Autowired
	private InstituicaoMemoryDAO dao;
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity inclui(Instituicao instituicao) {
		this.dao.inclui(instituicao);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public List<Instituicao> listaTodos() {
		return this.dao.listaTodos();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	@ResponseBody
	public Instituicao procura(@PathVariable("id")int id) {
		return this.dao.procura(id);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/nome/{nome}")
	@ResponseBody
	public List<Instituicao> procura(@PathVariable("nome")  String nome) {
		return this.dao.listPorNome(nome);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public void atualiza(Instituicao instituicao) {
		
	}

}
