package com.serratec.java2.projetoEcommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.java2.projetoEcommerce.models.Cliente;
import com.serratec.java2.projetoEcommerce.repository.ClienteRepository;
import com.serratec.java2.projetoEcommerce.repository.EnderecoRepository;

@Service
public class ClienteService {

//		cadastrar/deletar/atualizar clientes

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	EnderecoRepository enderecoRepository;
	
	public void inserirCliente(Cliente cliente) {
		clienteRepository.save(cliente);
		
	}

	public void deletarCliente(Integer id) {
		Cliente cliente = listarClientesPorId(id);
		clienteRepository.delete(cliente);
		
	}

	public Cliente listarClientesPorId(Integer id) {
		Optional<Cliente> opCliente = clienteRepository.findById(id);
	
		if(opCliente.isPresent()) {
			Cliente cliente = opCliente.get();
			return cliente;
		}
		return null;
		//throw new clienteNotFoundException("cliente com id " + id + " não encontrada");
	}

	public List<Cliente> listarClientes() {
		return clienteRepository.findAll();
	}

	public Cliente substituir(Integer id, Cliente cliente) {
		
		Cliente clienteNoBanco = listarClientesPorId(id);
		
		if (cliente.getNome() != null) {
			clienteNoBanco.setNome(cliente.getNome());
		}

		if (cliente.getCpf() != null) {
			clienteNoBanco.setCpf(cliente.getCpf());
		}

		if (cliente.getUsuario() != null) {
			clienteNoBanco.setUsuario(cliente.getUsuario());
		}

		if (cliente.getEmail() != null) {
			clienteNoBanco.setEmail(cliente.getEmail());
		}
		
		if (cliente.getData_nascimento() != null) {
			clienteNoBanco.setData_nascimento(cliente.getData_nascimento());
		}
		
		Cliente novoCliente = clienteRepository.save(clienteNoBanco);
		
		return novoCliente;
		
	}

}
