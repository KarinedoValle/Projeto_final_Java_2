package com.serratec.java2.projetoEcommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serratec.java2.projetoEcommerce.exceptions.CategoriaNotFoundException;
import com.serratec.java2.projetoEcommerce.models.Categoria;
import com.serratec.java2.projetoEcommerce.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;
	
	
	@PostMapping
	
	public void criarCategoria(@Valid @RequestBody Categoria categoria) {
		categoriaService.criarCategoria(categoria);
	}
	
	@GetMapping
	public List<Categoria> listarCategoria(){
		return categoriaService.listarCategoria();
	}
	
	
	@GetMapping("/{cod}")
	public Categoria listarCategoriaPorCodigo(@Valid @PathVariable Integer cod) throws CategoriaNotFoundException {
		return categoriaService.listarCategoriaPorCodigo(cod);
	}
	
	@PutMapping("/{cod}")
	public void atualizarCategoria(@Valid @PathVariable Integer cod,@Valid @RequestBody Categoria categoria) {
		
	}
}
