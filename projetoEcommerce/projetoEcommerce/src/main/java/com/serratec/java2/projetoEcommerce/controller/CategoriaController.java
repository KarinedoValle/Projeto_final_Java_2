package com.serratec.java2.projetoEcommerce.controller;

import java.util.List;

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

import com.serratec.java2.projetoEcommerce.exceptions.CategoriaNotFoundException;
import com.serratec.java2.projetoEcommerce.exceptions.ParametroObrigatorioException;
import com.serratec.java2.projetoEcommerce.models.Categoria;
import com.serratec.java2.projetoEcommerce.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;
	
	
	@PostMapping
	
	public ResponseEntity<Void> criarCategoria(@Valid @RequestBody(required = false) Categoria categoria) throws ParametroObrigatorioException {
		categoriaService.criarCategoria(categoria);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Categoria>> listarCategoria(){
		List<Categoria> listaC = categoriaService.listarCategoria();
		return new ResponseEntity<List<Categoria>>(listaC, HttpStatus.OK);
	}
	
	
	@GetMapping("/{cod}")
	public ResponseEntity<Categoria> listarCategoriaPorCodigo(@Valid @PathVariable Integer cod) throws CategoriaNotFoundException {
		Categoria c = categoriaService.listarCategoriaPorCodigo(cod);
		return new ResponseEntity<Categoria>(c, HttpStatus.OK);
	}
	
	@PutMapping("/{cod}")
	public ResponseEntity<Void> atualizarCategoria(@Valid @PathVariable Integer cod,@Valid @RequestBody(required = false) Categoria categoria) throws CategoriaNotFoundException, ParametroObrigatorioException {
		categoriaService.atualizarCategoria(cod, categoria);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{cod}")
	public ResponseEntity<Void> deletarCategoria(@Valid @PathVariable Integer cod) throws CategoriaNotFoundException{
		categoriaService.deletarCategoria(cod);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
