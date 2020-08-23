package com.serratec.java2.projetoEcommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.java2.projetoEcommerce.exceptions.CategoriaNotFoundException;
import com.serratec.java2.projetoEcommerce.models.Categoria;
import com.serratec.java2.projetoEcommerce.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	public void criarCategoria(Categoria categoria) {
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
	
	
}
