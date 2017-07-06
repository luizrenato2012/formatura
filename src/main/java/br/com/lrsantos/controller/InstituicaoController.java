package br.com.lrsantos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.lrsantos.model.bean.Instituicao;
import br.com.lrsantos.model.dao.InstituicaoDAO;

@Controller
@RequestMapping("/instituicao")
public class InstituicaoController {
	
	@Autowired
	private InstituicaoDAO dao;
//	private InstituicaoMemoryDAO dao;
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity inclui(Instituicao instituicao) {
		try {
			this.dao.insert(instituicao);
			return new ResponseEntity(HttpStatus.CREATED);
		} catch (Exception e  ) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);	
		}
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public List<Instituicao> listaTodos() {
		return this.dao.listAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	@ResponseBody
	public Instituicao procura(@PathVariable("id")int id) {
		return this.dao.load(id);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/nome/{nome}")
	@ResponseBody
	public List<Instituicao> procura(@PathVariable("nome")  String nome) {
		return this.dao.listByNome(nome);
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity atualiza(Instituicao instituicao) {
		ResponseEntity responseEntity = null;
		try{
			this.dao.update(instituicao);
			responseEntity = new ResponseEntity<HttpHeaders>(HttpStatus.ACCEPTED);
		} catch (Exception e ) {
			e.printStackTrace();
			responseEntity = new ResponseEntity(new HeaderFactory().criaHeader("erro", "Erro ao atualizar"),
					HttpStatus.EXPECTATION_FAILED);
		}
		return responseEntity;
	}

}
