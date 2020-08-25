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
import com.serratec.java2.projetoEcommerce.exceptions.ParametroObrigatorioException;
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
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
	}
	
	@ExceptionHandler(ParametroObrigatorioException.class)
	public ResponseEntity<String> ParametroObrigatorioException(ParametroObrigatorioException exception){
		String msg = exception.getMessage();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
	}
	
	@ExceptionHandler(clienteNotFoundException.class)
	public ResponseEntity<String> clienteNotFoundException(clienteNotFoundException exception){
		String msg = exception.getMessage();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
	}
	
	@ExceptionHandler(ValorInvalidoException.class)
	public ResponseEntity<String> ValorInvalidoException(ValorInvalidoException exception){
		String msg = exception.getMessage();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
	}
	
	@ExceptionHandler(produtoNotFoundException.class)
	public ResponseEntity<String> produtoNotFoundException(produtoNotFoundException exception){
		String msg = exception.getMessage();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
	}
	
	@ExceptionHandler(pedidoNotFoundException.class)
	public ResponseEntity<String> pedidoNotFoundException(pedidoNotFoundException exception){
		String msg = exception.getMessage();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
	}
	
	@ExceptionHandler(enderecoNotFoundException.class)
	public ResponseEntity<String> enderecoNotFoundException(enderecoNotFoundException exception){
		String msg = exception.getMessage();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
	}
	
	@ExceptionHandler(FuncionarioNotFoundException.class)
	public ResponseEntity<String> FuncionarioNotFoundException(FuncionarioNotFoundException exception){
		String msg = exception.getMessage();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<String> MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception){
		String msg = exception.getMessage();
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
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
   
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> NullPointerException(NullPointerException exception){
        String msg = exception.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
    }
   
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<String> IndexOutOfBoundsException(IndexOutOfBoundsException exception){
        String msg = exception.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
    }
}
