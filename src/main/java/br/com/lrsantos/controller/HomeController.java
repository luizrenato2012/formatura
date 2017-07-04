package br.com.lrsantos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.lrsantos.model.bean.Aluno;

@Controller
public class HomeController {

	@RequestMapping("/home")
	@ResponseBody
	public ResponseEntity<Aluno> teste() {
		System.out.println("iniciando controller");
		Aluno aluno = new Aluno();
		aluno.setId(1);
		aluno.setNome("Aluno 1");
		aluno.setEndereco("Endereco 1");
		aluno.setTelefone("111-1111");
		
		return new ResponseEntity(aluno, HttpStatus.OK);
	}
}
