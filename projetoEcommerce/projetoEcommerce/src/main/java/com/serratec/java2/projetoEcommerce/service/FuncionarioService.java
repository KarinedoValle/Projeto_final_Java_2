package com.serratec.java2.projetoEcommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.java2.projetoEcommerce.models.Funcionario;
import com.serratec.java2.projetoEcommerce.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

//		deletar/atualizar/cadastrar funcionario

	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	public void inserirFuncionario(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
		
	}
	
	public void deletarFuncionario(Integer id) {
		Funcionario funcionario = listarFuncionarioPorId(id);
		funcionarioRepository.delete(funcionario);
		
	}

	public Funcionario listarFuncionarioPorId(Integer id) {
		Optional<Funcionario> opFuncionario = funcionarioRepository.findById(id);
	
		if(opFuncionario.isPresent()) {
			Funcionario funcionario = opFuncionario.get();
			return funcionario;
		}
		return null;
		//throw new funcionarioNotFoundException("Funcionário com id " + id + " não encontrado.");
	}

	public List<Funcionario> listarFuncionario() {
		return funcionarioRepository.findAll();
	}

	public Funcionario substituir(Integer id, Funcionario funcionario) {
		
		Funcionario funcionarioNoBanco = listarFuncionarioPorId(id);
		
		if (funcionario.getNome() != null) {
			funcionarioNoBanco.setNome(funcionario.getNome());
		}

		if (funcionario.getCpf() != null) {
			funcionarioNoBanco.setCpf(funcionario.getCpf());
		}
		
		Funcionario novoFuncionario = funcionarioRepository.save(funcionarioNoBanco);
		
		return novoFuncionario;
		
	}
}
