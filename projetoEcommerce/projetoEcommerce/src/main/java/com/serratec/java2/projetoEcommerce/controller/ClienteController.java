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

import com.serratec.java2.projetoEcommerce.models.Cliente;
import com.serratec.java2.projetoEcommerce.service.ClienteService;
import com.serratec.java2.projetoEcommerce.service.EnderecoService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	@Autowired
	EnderecoService enderecoService;
	
//	cadastrar/deletar/atualizar clientes

	
	@PostMapping
	public ResponseEntity<Void> inserirCliente(@RequestBody Cliente cliente){
		clienteService.inserirCliente(cliente);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> listarClientesPorId(@PathVariable Integer id){
		Cliente cliente = clienteService.listarClientesPorId(id); 
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Cliente>> listarClientes(){
		return new ResponseEntity<List<Cliente>>(clienteService.listarClientes(), HttpStatus.OK);
	}
	 
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarCliente(@PathVariable Integer id){
		clienteService.deletarCliente(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public void substituir(@PathVariable Integer id, @RequestBody(required = false) Cliente cliente) {
		clienteService.substituir(id, cliente);
	}
	

}
