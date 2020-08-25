package com.serratec.java2.projetoEcommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.java2.projetoEcommerce.exceptions.ParametroObrigatorioException;
import com.serratec.java2.projetoEcommerce.exceptions.enderecoNotFoundException;
import com.serratec.java2.projetoEcommerce.models.Endereco;
import com.serratec.java2.projetoEcommerce.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
//	cadastrar/deletar/atualizar endereço
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	public void inserirEndereco(Endereco endereco) throws ParametroObrigatorioException {
		if(endereco == null) throw new ParametroObrigatorioException("Campo 'endereço' é obrigatório");
		enderecoRepository.save(endereco);
		
	}
	
	public void deletarEndereco(Integer id) throws enderecoNotFoundException {
		Endereco endereco = listarEnderecoPorId(id);
		enderecoRepository.delete(endereco);
		
	}

	public Endereco listarEnderecoPorId(Integer id) throws enderecoNotFoundException {
		Optional<Endereco> opEndereco = enderecoRepository.findById(id);
	
		if(opEndereco.isPresent()) {
			Endereco endereco = opEndereco.get();
			return endereco;
		}
		throw new enderecoNotFoundException("Endereço com id " + id + " não encontrado.");
	}

	public List<Endereco> listarEndereco() {
		return enderecoRepository.findAll();
	}

	public Endereco substituir(Integer id, Endereco endereco) throws enderecoNotFoundException, ParametroObrigatorioException {
		if(endereco == null) throw new ParametroObrigatorioException("Campo 'endereço' é obrigatório");
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
