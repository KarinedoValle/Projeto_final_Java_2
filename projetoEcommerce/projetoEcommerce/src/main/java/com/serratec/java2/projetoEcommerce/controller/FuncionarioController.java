package com.serratec.java2.projetoEcommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serratec.java2.projetoEcommerce.exceptions.FuncionarioNotFoundException;
import com.serratec.java2.projetoEcommerce.exceptions.ParametroObrigatorioException;
import com.serratec.java2.projetoEcommerce.models.Funcionario;
import com.serratec.java2.projetoEcommerce.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	FuncionarioService funcionarioService;
	
	@PostMapping
	public ResponseEntity<Void> criarFuncionario(@RequestBody(required = false) Funcionario funcionario) throws ParametroObrigatorioException {
		funcionarioService.criarFuncionario(funcionario);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> listarFuncionarios(){
		List<Funcionario> listaFuncionarios = funcionarioService.listarFuncionarios();
		return new ResponseEntity<List<Funcionario>>(listaFuncionarios, HttpStatus.OK);
	}
	
	@GetMapping("/{cod}")
	public ResponseEntity<Funcionario> listarFuncionarioPorCodigo(@PathVariable Integer cod) throws FuncionarioNotFoundException {
		Funcionario f = funcionarioService.listarFuncionarioPorCodigo(cod);
		return new ResponseEntity<Funcionario>(f, HttpStatus.OK);
	}
	
	@PutMapping("/{cod}")
	public ResponseEntity<Void> atualizarFuncionario(@PathVariable Integer cod, @RequestBody(required = false) Funcionario funcionario) throws FuncionarioNotFoundException, ParametroObrigatorioException {
		funcionarioService.atualizarFuncionario(cod, funcionario);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{cod}")
	public ResponseEntity<Void> deletarFuncionario(@PathVariable Integer cod) {
		funcionarioService.deletarFuncionario(cod);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
}
