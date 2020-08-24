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
import com.serratec.java2.projetoEcommerce.models.Funcionario;
import com.serratec.java2.projetoEcommerce.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	FuncionarioService funcionarioService;
	
	@PostMapping
	public void criarFuncionario(@RequestBody Funcionario funcionario) {
		funcionarioService.criarFuncionario(funcionario);
	}
	
	@GetMapping
	public List<Funcionario> listarFuncionarios(){
		return funcionarioService.listarFuncionarios();
	}
	
	@GetMapping("/{cod}")
	public Funcionario listarFuncionarioPorCodigo(@PathVariable Integer cod) throws FuncionarioNotFoundException {
		return funcionarioService.listarFuncionarioPorCodigo(cod);
	}
	
	@PutMapping("/{cod}")
	public void atualizarFuncionario(@PathVariable Integer cod, @RequestBody Funcionario funcionario) throws FuncionarioNotFoundException {
		funcionarioService.atualizarFuncionario(cod, funcionario);
	}
	
	@DeleteMapping("/{cod}")
	public void deletarFuncionario(@PathVariable Integer cod) {
		funcionarioService.deletarFuncionario(cod);
	}
	
	
}
