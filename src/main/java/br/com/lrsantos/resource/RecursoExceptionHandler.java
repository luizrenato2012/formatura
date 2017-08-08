package br.com.lrsantos.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RecursoExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;

	//errros de validacao em atributos
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		List<Erro> listaErros = this.listaErros(ex.getBindingResult());
		return handleExceptionInternal(ex, listaErros, headers, HttpStatus.BAD_REQUEST, request);
	}
	
	private List<Erro> listaErros(BindingResult bindingResults) {
		List<Erro> erros = new ArrayList<Erro>();
		for(FieldError erro : bindingResults.getFieldErrors()){
			erros.add(new Erro(this.messageSource.getMessage(erro,LocaleContextHolder.getLocale()) ));
		}
		return erros;
	}
	
	static class Erro {
		private String erro;

		public Erro(String erro) {
			super();
			this.erro= erro;
		}

		public String getErro() {
			return erro;
		}
		
		
	}


}
