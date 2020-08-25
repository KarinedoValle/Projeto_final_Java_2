package com.serratec.java2.projetoEcommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.java2.projetoEcommerce.exceptions.FuncionarioNotFoundException;
import com.serratec.java2.projetoEcommerce.exceptions.ParametroObrigatorioException;
import com.serratec.java2.projetoEcommerce.models.Funcionario;
import com.serratec.java2.projetoEcommerce.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	FuncionarioRepository funcionarioRepository;

	public List<Funcionario> listarFuncionarios() {
		List<Funcionario> listaFuncionario = funcionarioRepository.findAll();
		
		return listaFuncionario;
	}

	public Funcionario listarFuncionarioPorCodigo(Integer cod) throws FuncionarioNotFoundException {
		Optional<Funcionario> opFunc = funcionarioRepository.findById(cod);
		if(opFunc.isPresent()) {
			Funcionario funcionario = opFunc.get();
			return funcionario;
		}
		throw new FuncionarioNotFoundException("O funcionário com o código "+ cod + " não foi encontrado");
	}

	public void criarFuncionario(Funcionario funcionario) throws ParametroObrigatorioException {
		if(funcionario == null) throw new ParametroObrigatorioException("Campo 'funcionario' é obrigatório");
		funcionarioRepository.save(funcionario);
	}

	public void atualizarFuncionario(Integer cod, Funcionario funcionario) throws FuncionarioNotFoundException, ParametroObrigatorioException {
		if(funcionario == null) throw new ParametroObrigatorioException("Campo 'funcionario' é obrigatório");
		Funcionario fNoDB = listarFuncionarioPorCodigo(cod);
		
		if(funcionario.getNome() != null) {
			fNoDB.setNome(funcionario.getNome());
		}
		if(funcionario.getCpf() != null) {
			fNoDB.setCpf(funcionario.getCpf());
		}
		
		funcionarioRepository.save(fNoDB);
	}

	public void deletarFuncionario(Integer cod) {
		funcionarioRepository.deleteById(cod);
	}
}
