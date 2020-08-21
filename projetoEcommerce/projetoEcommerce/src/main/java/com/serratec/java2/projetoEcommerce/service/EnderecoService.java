package com.serratec.java2.projetoEcommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.serratec.java2.projetoEcommerce.models.Endereco;
import com.serratec.java2.projetoEcommerce.repository.EnderecoRepository;

public class EnderecoService {
	
//	cadastrar/deletar/atualizar endereço
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	public void inserirEndereco(Endereco endereco) {
		enderecoRepository.save(endereco);
		
	}
	
	public void deletarEndereco(Integer id) {
		Endereco endereco = listarEnderecoPorId(id);
		enderecoRepository.delete(endereco);
		
	}

	public Endereco listarEnderecoPorId(Integer id) {
		Optional<Endereco> opEndereco = enderecoRepository.findById(id);
	
		if(opEndereco.isPresent()) {
			Endereco endereco = opEndereco.get();
			return endereco;
		}
		return null;
		//throw new enderecoNotFoundException("Endereço com id " + id + " não encontrado.");
	}

	public List<Endereco> listarEndereco() {
		return enderecoRepository.findAll();
	}

	public Endereco substituir(Integer id, Endereco endereco) {
		
		Endereco enderecoNoBanco = listarEnderecoPorId(id);
		
		if (endereco.getRua() != null) {
			enderecoNoBanco.setRua(endereco.getRua());
		}

		if (endereco.getNumero() != null) {
			enderecoNoBanco.setNumero(endereco.getNumero());
		}

		if (endereco.getComplemento() != null) {
			enderecoNoBanco.setComplemento(endereco.getComplemento());
		}

		if (endereco.getBairro() != null) {
			enderecoNoBanco.setBairro(endereco.getBairro());
		}
		
		if (endereco.getCidade() != null) {
			enderecoNoBanco.setCidade(endereco.getCidade());
		}
		
		if (endereco.getEstado() != null) {
			enderecoNoBanco.setEstado(endereco.getEstado());
		}
		
		if (endereco.getCep() != null) {
			enderecoNoBanco.setCep(endereco.getCep());
		}
		
		Endereco novoEndereco = enderecoRepository.save(enderecoNoBanco);
		
		return novoEndereco;
		
	}

}
