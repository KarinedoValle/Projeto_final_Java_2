package com.serratec.java2.projetoEcommerce.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.java2.projetoEcommerce.exceptions.ParametroObrigatorioException;
import com.serratec.java2.projetoEcommerce.exceptions.clienteNotFoundException;
import com.serratec.java2.projetoEcommerce.forms.ClienteForm;
import com.serratec.java2.projetoEcommerce.models.Cliente;
import com.serratec.java2.projetoEcommerce.models.Endereco;
import com.serratec.java2.projetoEcommerce.repository.ClienteRepository;
import com.serratec.java2.projetoEcommerce.repository.EnderecoRepository;

@Service
public class ClienteService {

//		cadastrar/deletar/atualizar clientes

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	EnderecoRepository enderecoRepository;
	
	
	public void inserirCliente(@Valid ClienteForm clienteForm) throws ParametroObrigatorioException {
		if(clienteForm == null) throw new ParametroObrigatorioException("Campo 'cliente' é obrigatório");
		
		Cliente cliente = new Cliente();
		
		Integer codEnd = clienteForm.getCodigo_endereco();
		Optional <Endereco> opEnd = enderecoRepository.findById(codEnd);
		Endereco endereco = opEnd.get();
		cliente.setEndereco(endereco);
		
		
		cliente.setCpf(clienteForm.getCpf());
		cliente.setData_nascimento(clienteForm.getData_nascimento());
		cliente.setEmail(clienteForm.getEmail());
		cliente.setNome(clienteForm.getNome());
		cliente.setUsuario(clienteForm.getUsuario());
		
		clienteRepository.save(cliente);
		
	}

	public void deletarCliente(Integer id) throws clienteNotFoundException {
		Cliente cliente = listarClientesPorId(id);
		clienteRepository.delete(cliente);
		
	}

	public Cliente listarClientesPorId(Integer id) throws clienteNotFoundException {
        Optional<Cliente> opCliente = clienteRepository.findById(id);
   
        if(opCliente.isPresent()) {
            Cliente cliente = opCliente.get();
            return cliente;
        }
        throw new clienteNotFoundException("cliente com id " + id + " não encontrada");
    }

	public Set<ClienteForm> listarClientes() {
		Set<ClienteForm> cListFinal = new HashSet<>();
		List<Cliente> clienteList = new ArrayList<>();
		clienteList = clienteRepository.findAll();
		
		for(int i = 0; i < clienteList.size(); i++) {
			Cliente cliente = clienteList.get(i);
			ClienteForm cForm = new ClienteForm();
			Endereco endereco = cliente.getEndereco();
			cForm.setId(cliente.getCodigo());
			cForm.setCpf(cliente.getCpf());
			cForm.setData_nascimento(cliente.getData_nascimento());
			cForm.setEmail(cliente.getEmail());
			
			//Pegar o endereco
			cForm.setCodigo_endereco(endereco.getCodigo());
			cForm.setNome(cliente.getNome());
			cForm.setUsuario(cliente.getUsuario());
			cForm.setRua(endereco.getRua());
			cForm.setNumero(endereco.getNumero());
			cForm.setComplemento(endereco.getComplemento());
			cForm.setBairro(endereco.getBairro());
			cForm.setCidade(endereco.getCidade());
			cForm.setEstado(endereco.getEstado());
			cForm.setCep(endereco.getCep());
			
			
			cListFinal.add(cForm);
		}
		return cListFinal;
	}

	public Cliente substituir(Integer id, @Valid Cliente cliente) throws clienteNotFoundException, ParametroObrigatorioException {
		if(cliente == null) throw new ParametroObrigatorioException("Campo 'cliente' é obrigatório");
		
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
