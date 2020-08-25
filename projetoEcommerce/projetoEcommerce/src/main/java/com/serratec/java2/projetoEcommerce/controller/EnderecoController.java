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

import com.serratec.java2.projetoEcommerce.exceptions.ParametroObrigatorioException;
import com.serratec.java2.projetoEcommerce.exceptions.enderecoNotFoundException;
import com.serratec.java2.projetoEcommerce.models.Endereco;
import com.serratec.java2.projetoEcommerce.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	EnderecoService enderecoService;

	@PostMapping
	public ResponseEntity<Void> inserirEndereco(@RequestBody(required = false) Endereco endereco) throws ParametroObrigatorioException{
		enderecoService.inserirEndereco(endereco);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Endereco> listarEnderecoPorId(@PathVariable Integer id) throws enderecoNotFoundException{
		Endereco endereco = enderecoService.listarEnderecoPorId(id); 
		return new ResponseEntity<Endereco>(endereco, HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Endereco>> listarEnderecos(){
		return new ResponseEntity<List<Endereco>>(enderecoService.listarEndereco(), HttpStatus.OK);
	}
	 
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarEndereco(@PathVariable Integer id) throws enderecoNotFoundException{
		enderecoService.deletarEndereco(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public void substituir(@PathVariable Integer id, @RequestBody(required = false) Endereco endereco) throws enderecoNotFoundException, ParametroObrigatorioException {
		enderecoService.substituir(id, endereco);
	}
}
