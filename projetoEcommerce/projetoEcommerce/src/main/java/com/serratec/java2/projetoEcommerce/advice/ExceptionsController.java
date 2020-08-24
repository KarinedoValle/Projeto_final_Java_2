package com.serratec.java2.projetoEcommerce.advice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.serratec.java2.projetoEcommerce.exceptions.CategoriaNotFoundException;
import com.serratec.java2.projetoEcommerce.exceptions.FuncionarioNotFoundException;
import com.serratec.java2.projetoEcommerce.exceptions.ValorInvalidoException;
import com.serratec.java2.projetoEcommerce.exceptions.clienteNotFoundException;
import com.serratec.java2.projetoEcommerce.exceptions.enderecoNotFoundException;
import com.serratec.java2.projetoEcommerce.exceptions.pedidoNotFoundException;
import com.serratec.java2.projetoEcommerce.exceptions.produtoNotFoundException;

@RestControllerAdvice
public class ExceptionsController {

	@ExceptionHandler(CategoriaNotFoundException.class)
	public ResponseEntity<String> CategoriaNotFoundException(CategoriaNotFoundException exception){
		String msg = exception.getMessage();
		//Map<String, Strings> errors = "";
//		return handleExcpetionInternal(ex, msg, )
//		return new ResponseEntity<String>(msg, HttpStatus.NOT_FOUND);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
	}
	
	@ExceptionHandler(clienteNotFoundException.class)
	public ResponseEntity<Void> clienteNotFoundException(clienteNotFoundException exception){
		String msg = exception.getMessage();
		return ResponseEntity.notFound().header("cliente-erro", msg).build();
	}
	
	@ExceptionHandler(ValorInvalidoException.class)
	public ResponseEntity<Void> ValorInvalidoException(ValorInvalidoException exception){
		String msg = exception.getMessage();
		return ResponseEntity.badRequest().header("valor-unitario-erro", msg).build();
	}
	
	@ExceptionHandler(produtoNotFoundException.class)
	public ResponseEntity<Void> produtoNotFoundException(produtoNotFoundException exception){
		String msg = exception.getMessage();
		return ResponseEntity.badRequest().header("produto-erro", msg).build();
	}
	
	@ExceptionHandler(pedidoNotFoundException.class)
	public ResponseEntity<Void> pedidoNotFoundException(pedidoNotFoundException exception){
		String msg = exception.getMessage();
		return ResponseEntity.badRequest().header("produto-erro", msg).build();
	}
	
	@ExceptionHandler(enderecoNotFoundException.class)
	public ResponseEntity<Void> enderecoNotFoundException(enderecoNotFoundException exception){
		String msg = exception.getMessage();
		return ResponseEntity.badRequest().header("produto-erro", msg).build();
	}
	
	@ExceptionHandler(FuncionarioNotFoundException.class)
	public ResponseEntity<Void> FuncionarioNotFoundException(FuncionarioNotFoundException exception){
		String msg = exception.getMessage();
		return ResponseEntity.badRequest().header("produto-erro", msg).build();
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Void> MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception){
		String msg = exception.getMessage();
		return ResponseEntity.badRequest().header("erro-datatype", msg).build();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> trataValidacoes(MethodArgumentNotValidException exception){
		Map<String, String> errosMap = new HashMap<String, String>();
		List<ObjectError> errosEncontrados = exception.getBindingResult().getAllErrors();
		for (ObjectError erro : errosEncontrados) {
			FieldError fieldError = (FieldError) erro;
			String atributo = fieldError.getField();
			String mensagem = fieldError.getDefaultMessage();
			errosMap.put(atributo, mensagem);
		}
		return ResponseEntity.badRequest().body(errosMap);
	}
}
