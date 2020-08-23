package com.serratec.java2.projetoEcommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.serratec.java2.projetoEcommerce.exceptions.ValorInvalidoException;
import com.serratec.java2.projetoEcommerce.exceptions.produtoNotFoundException;
import com.serratec.java2.projetoEcommerce.models.Produto;
import com.serratec.java2.projetoEcommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {

//		cadastrar/deletar/atualizar produto 
//		consultar/atualizar os preços dos produtos
//		consultar/atualizar o estoque

	@Autowired
	ProdutoRepository produtoRepository;

	public void inserirProduto(Produto produto) throws ValorInvalidoException {
		
		if(produto.getValor_unitario() <= 0) {
			throw new ValorInvalidoException("Não são permitidos valores menores que 0");
		}
		
		
		produtoRepository.save(produto);

	}

	public void deletarProduto(Integer id) throws produtoNotFoundException {
		Produto produto = listarProdutoPorId(id);
		produtoRepository.delete(produto);

	}

	public Produto listarProdutoPorId(Integer id) throws produtoNotFoundException {
		Optional<Produto> opProduto = produtoRepository.findById(id);

		if (opProduto.isPresent()) {
			Produto produto = opProduto.get();
			return produto;
		}
		 throw new produtoNotFoundException("Produto com id " + id + " não encontrado.");
	}

	public List<Produto> listarProdutos() {
		return produtoRepository.findAll();
	}

	public Double consultarPreco(Integer id) {
		Optional <Produto> opProduto = produtoRepository.findById(id);
		Produto produto = opProduto.get();
		Double preco = produto.getValor_unitario();
		return preco;
	}

	public void atualizarPreco(Integer id, Double valor_unitario) throws ValorInvalidoException, produtoNotFoundException {
		
		if(valor_unitario <= 0) {
			throw new ValorInvalidoException("Não são permitidos valores menores que 0");
		}
		
		Produto produtoNoBanco = listarProdutoPorId(id);
		produtoNoBanco.setValor_unitario(valor_unitario);
	}

	public Integer consultarEstoque(Integer id) {
		Optional <Produto> opProduto = produtoRepository.findById(id);
		Produto produto = opProduto.get();
		Integer quantidade = produto.getQuantidade_estoque();
		return quantidade;
	}

	public void atualizarEstoque(Integer id, Integer quantidade_estoque) throws ValorInvalidoException, produtoNotFoundException {
		if(quantidade_estoque < 0) {
			throw new ValorInvalidoException("Não são permitidos valores menores que 0");
		}
		
		Produto produtoNoBanco = listarProdutoPorId(id);
		produtoNoBanco.setQuantidade_estoque(quantidade_estoque);
	}
	
	public Produto substituir(Integer id, Produto produto) throws ValorInvalidoException, produtoNotFoundException {

		if(produto.getValor_unitario() <= 0 || produto.getQuantidade_estoque() < 0) {
			throw new ValorInvalidoException("Não são permitidos valores menores que 0");
		}
		Produto produtoNoBanco = listarProdutoPorId(id);
		

		if (produto.getNome() != null) {
			produtoNoBanco.setNome(produto.getNome());
		}

		if (produto.getDescricao() != null) {
			produtoNoBanco.setDescricao(produto.getDescricao());
		}

		if (produto.getQuantidade_estoque() != null) {
			produtoNoBanco.setQuantidade_estoque(produto.getQuantidade_estoque());
		}

		if (produto.getData_fabricacao() != null) {
			produtoNoBanco.setData_fabricacao(produto.getData_fabricacao());
		}

		if (produto.getValor_unitario() != null) {
			produtoNoBanco.setValor_unitario(produto.getValor_unitario());
		}

		Produto novoProduto = produtoRepository.save(produtoNoBanco);

		return novoProduto;

	}

}
