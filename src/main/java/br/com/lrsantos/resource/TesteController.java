package br.com.lrsantos.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/testes")
public class TesteController {
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> teste(@RequestBody Teste teste) {
		System.out.println("Recebido " + teste);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
