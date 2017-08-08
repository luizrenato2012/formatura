package br.com.lrsantos.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.lrsantos.model.bean.Instituicao;
import br.com.lrsantos.model.dao.InstituicaoDAO;
import br.com.lrsantos.model.service.InstituicaoService;

@RestController
@RequestMapping("/instituicoes")
public class InstituicaoResource {
	
	@Autowired
	private InstituicaoDAO dao;
	
	@Autowired
	private InstituicaoService service;
	
	@Transactional
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> inclui(@Valid @RequestBody  Instituicao instituicao) {
		this.dao.insert(instituicao);
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@Transactional
	@RequestMapping(method=RequestMethod.PUT,value="/{id}")
	@ResponseBody
	public ResponseEntity atualiza(@PathVariable Integer id, @Valid @RequestBody Instituicao instituicao) {
		this.service.update(id,instituicao);
		return new ResponseEntity<HttpHeaders>(HttpStatus.ACCEPTED);
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public List<Instituicao> listaTodos() {
		return this.dao.listAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	@ResponseBody
	public ResponseEntity procura(@PathVariable("id")int id) {
		Instituicao instituicao = this.dao.load(id);
		if(instituicao!=null){
			return ResponseEntity.ok(instituicao);
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/nome/{nome}")
	@ResponseBody
	public List<Instituicao> procura(@PathVariable("nome")  String nome) {
		return this.dao.listByNome(nome);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	@Transactional
	public ResponseEntity delete(@PathVariable("id")  Integer id) {
		this.service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
