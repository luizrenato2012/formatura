package br.com.lrsantos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.lrsantos.model.bean.Instituicao;
import br.com.lrsantos.model.dao.InstituicaoDAO;

@Controller
@RequestMapping("/instituicoes")
public class InstituicaoController {
	
	@Autowired
	private InstituicaoDAO dao;
	
	@Transactional
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> inclui(@RequestBody Instituicao instituicao) {
		try {
			System.out.println(instituicao);
			this.validaInstituicao(instituicao);
			this.dao.insert(instituicao);
			return new ResponseEntity(HttpStatus.CREATED);
		} catch (Exception e  ) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);	
		}
	}
	
	private void validaInstituicao(Instituicao instiuicao) {
		List<String >valoresInvalidos = new ArrayList<String>();
		String mensagem = "";
		
		if(instiuicao==null){
			throw new ValidacaoException("Produto invalido");
		}
		
		String nome = instiuicao.getNome();
		String telefone = instiuicao.getTelefone();
		
		if(nome==null || nome.equals("")){
			valoresInvalidos.add(nome);
		}
		
		if(telefone==null || telefone.equals("")){
			valoresInvalidos.add(telefone);
		}
		
		if(valoresInvalidos.size() != 0){
			
		}
		
	}
	
	
	
	@RequestMapping(method=RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity atualiza(@RequestBody Instituicao instituicao) {
		ResponseEntity responseEntity = null;
		try{
			this.dao.update(instituicao);
			responseEntity = new ResponseEntity<HttpHeaders>(HttpStatus.ACCEPTED);
		} catch (Exception e ) {
			e.printStackTrace();
			responseEntity = new ResponseEntity(new HeaderFactory().criaHeader("XErro", "Erro ao atualizar"),
					HttpStatus.EXPECTATION_FAILED);
		}
		return responseEntity;
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
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	@ResponseBody
	@Transactional
	public ResponseEntity delete(@PathVariable("id")  Integer id) {
		ResponseEntity response = null;
		try {
			this.dao.delete(id);
			response = new ResponseEntity<HttpHeaders>(HttpStatus.ACCEPTED);
		} catch (Exception e ) {
			e.printStackTrace();
			response = new ResponseEntity<>(new HeaderFactory().criaHeader("XErro", "Erro ao excluir"), 
					HttpStatus.BAD_REQUEST);
		}
		return response;
	}

}
