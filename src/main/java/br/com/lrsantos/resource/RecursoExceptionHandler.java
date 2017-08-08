package br.com.lrsantos.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

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
	
	//tratando erros do tipo exclusao de recurso c/ id inexistente
	@ExceptionHandler({EmptyResultDataAccessException.class})
	public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex, WebRequest request){
		String mensagem = this.messageSource.getMessage("recurso.nao-encontrado", null,LocaleContextHolder.getLocale());
		List<Erro> erros = Arrays.asList(new Erro(mensagem));
		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	private List<Erro> listaErros(BindingResult bindingResults) {
		List<Erro> erros = new ArrayList<Erro>();
		for(FieldError erro : bindingResults.getFieldErrors()){
			erros.add(new Erro(this.messageSource.getMessage(erro,LocaleContextHolder.getLocale()) ));
		}
		return erros;
	}
	
//	@Override
//	protected ResponseEntity<Object> handleHttpMessageNotReadable(
//			HttpMessageNotReadableException ex, HttpHeaders headers,
//			HttpStatus status, WebRequest request) {
//		System.out.println(">>> HttpMessageNotReadableException");
//		return super.handleHttpMessageNotReadable(ex, headers, status, request);
//	}
	
//	@Override
//	protected ResponseEntity<Object> handleConversionNotSupported(
//			ConversionNotSupportedException ex, HttpHeaders headers,
//			HttpStatus status, WebRequest request) {
//		System.out.println(">>> handleConversionNotSupported");
//		return super.handleConversionNotSupported(ex, headers, status, request);
//	}

//	@Override
//	protected ResponseEntity<Object> handleHttpMessageNotWritable(
//			HttpMessageNotWritableException ex, HttpHeaders headers,
//			HttpStatus status, WebRequest request) {
//		System.out.println(">>> handleHttpMessageNotWritable");
//		return super.handleHttpMessageNotWritable(ex, headers, status, request);
//	}

//	@Override
//	protected ResponseEntity<Object> handleMissingServletRequestParameter(
//			MissingServletRequestParameterException ex, HttpHeaders headers,
//			HttpStatus status, WebRequest request) {
//		System.out.println(">>> handleMissingServletRequestParameter");
//		return super.handleMissingServletRequestParameter(ex, headers, status, request);
//	}

//	@Override
//	protected ResponseEntity<Object> handleMissingServletRequestPart(
//			MissingServletRequestPartException ex, HttpHeaders headers,
//			HttpStatus status, WebRequest request) {
//		System.out.println(">>> handleMissingServletRequestPart");
//		return super.handleMissingServletRequestPart(ex, headers, status, request);
//	}

//	@Override
//	protected ResponseEntity<Object> handleNoHandlerFoundException(
//			NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status,
//			WebRequest request) {
//		System.out.println(">>> handleNoHandlerFoundException");
//		return super.handleNoHandlerFoundException(ex, headers, status, request);
//	}

//	@Override
//	protected ResponseEntity<Object> handleNoSuchRequestHandlingMethod(
//			NoSuchRequestHandlingMethodException ex, HttpHeaders headers,
//			HttpStatus status, WebRequest request) {
//		System.out.println(">>> handleNoSuchRequestHandlingMethod");
//		return super.handleNoSuchRequestHandlingMethod(ex, headers, status, request);
//	}

//	@Override
//	protected ResponseEntity<Object> handleServletRequestBindingException(
//			ServletRequestBindingException ex, HttpHeaders headers,
//			HttpStatus status, WebRequest request) {
//		System.out.println(">>> handleServletRequestBindingException");
//		return super.handleServletRequestBindingException(ex, headers, status, request);
//	}

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
