package com.serratec.java2.projetoEcommerce.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.java2.projetoEcommerce.exceptions.CategoriaNotFoundException;
import com.serratec.java2.projetoEcommerce.exceptions.ParametroObrigatorioException;
import com.serratec.java2.projetoEcommerce.models.Categoria;
import com.serratec.java2.projetoEcommerce.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	public void criarCategoria(Categoria categoria) throws ParametroObrigatorioException {
		if(categoria == null) throw new ParametroObrigatorioException("Campo 'categoria' é obrigatório");
		categoriaRepository.save(categoria);
	}

	public List<Categoria> listarCategoria() {
		return categoriaRepository.findAll();
	}

	public Categoria listarCategoriaPorCodigo(Integer cod) throws CategoriaNotFoundException {
		Optional<Categoria> opCateg = categoriaRepository.findById(cod);
		
		if(opCateg.isPresent()) {
			Categoria categoria = opCateg.get();
			return categoria;
		}
		
		throw new CategoriaNotFoundException("Não foi encontrada uma categoria com o codigo "+ cod);
	}

	public void atualizarCategoria(@Valid Integer cod, @Valid Categoria categoria) throws CategoriaNotFoundException, ParametroObrigatorioException {
		if(categoria == null) throw new ParametroObrigatorioException("Campo 'categoria' é obrigatório");
		Categoria c = listarCategoriaPorCodigo(cod);
		if(categoria.getNome() != null) {
			c.setNome(categoria.getNome());
		}
		if(categoria.getDescricao() != null) {
			c.setNome(categoria.getDescricao());
		}
		categoriaRepository.save(c);
	}

	public void deletarCategoria(@Valid Integer cod) throws CategoriaNotFoundException {
		Categoria c = listarCategoriaPorCodigo(cod);
		categoriaRepository.delete(c);
	}
	
	
}
