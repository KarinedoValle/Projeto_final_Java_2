package com.serratec.java2.projetoEcommerce.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

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
import com.serratec.java2.projetoEcommerce.exceptions.clienteNotFoundException;
import com.serratec.java2.projetoEcommerce.forms.ClienteForm;
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
	public ResponseEntity<Void> inserirCliente(@Valid @RequestBody(required = false) ClienteForm clienteForm) throws ParametroObrigatorioException{
		clienteService.inserirCliente(clienteForm);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> listarClientesPorId(@PathVariable Integer id) throws clienteNotFoundException{
		Cliente cliente = clienteService.listarClientesPorId(id); 
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity<Set<ClienteForm>> listarClientes(){
		Set<ClienteForm> clienteSet = new HashSet<>();
		clienteSet = clienteService.listarClientes();
		return new ResponseEntity<Set<ClienteForm>>(clienteSet, HttpStatus.OK);
	}
	 
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarCliente(@PathVariable Integer id) throws clienteNotFoundException{
		clienteService.deletarCliente(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public void substituir(@PathVariable Integer id,@Valid @RequestBody(required = false) Cliente cliente) throws clienteNotFoundException, ParametroObrigatorioException {
		clienteService.substituir(id, cliente);
	}
	

}
