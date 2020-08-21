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

import com.serratec.java2.projetoEcommerce.models.Funcionario;
import com.serratec.java2.projetoEcommerce.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

//		deletar/atualizar/cadastrar funcionario
	
	@Autowired
	FuncionarioService funcionarioService;

	@PostMapping
	public ResponseEntity<Void> inserirFuncionario(@RequestBody Funcionario funcionario){
		funcionarioService.inserirFuncionario(funcionario);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> listarFuncionarioPorId(@PathVariable Integer id){
		Funcionario funcionario = funcionarioService.listarFuncionarioPorId(id); 
		return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> listarFuncionarios(){
		return new ResponseEntity<List<Funcionario>>(funcionarioService.listarFuncionario(), HttpStatus.OK);
	}
	 
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarFuncionario(@PathVariable Integer id){
		funcionarioService.deletarFuncionario(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public void substituir(@PathVariable Integer id, @RequestBody(required = false) Funcionario funcionario) {
		funcionarioService.substituir(id, funcionario);
	}
	

}
