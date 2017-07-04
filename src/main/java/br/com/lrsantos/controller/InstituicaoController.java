package br.com.lrsantos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.lrsantos.model.bean.Instituicao;
import br.com.lrsantos.model.bean.InstituicaoMemoryDAO;

@Controller
@RequestMapping("/instituicao")
public class InstituicaoController {
	
	@Autowired
	private InstituicaoMemoryDAO dao;
	
	@RequestMapping(method=RequestMethod.POST)
	public void inclui(Instituicao instituicao) {
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public List<Instituicao> listaTodos() {
		return this.dao.listaTodos();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	public Instituicao procura(@RequestParam("id")int id) {
		return null;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/nome/{id}")
	public Instituicao procura(@RequestParam("nome")  String nome) {
		return null;
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public void atualiza(Instituicao instituicao) {
		
	}

}
