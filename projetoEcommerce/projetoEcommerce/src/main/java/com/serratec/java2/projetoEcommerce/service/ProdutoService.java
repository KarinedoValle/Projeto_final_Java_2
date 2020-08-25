package com.serratec.java2.projetoEcommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serratec.java2.projetoEcommerce.exceptions.ParametroObrigatorioException;
import com.serratec.java2.projetoEcommerce.exceptions.ValorInvalidoException;
import com.serratec.java2.projetoEcommerce.exceptions.produtoNotFoundException;
import com.serratec.java2.projetoEcommerce.forms.ProdutoForm;
import com.serratec.java2.projetoEcommerce.models.Categoria;
import com.serratec.java2.projetoEcommerce.models.Funcionario;
import com.serratec.java2.projetoEcommerce.models.Produto;
import com.serratec.java2.projetoEcommerce.repository.CategoriaRepository;
import com.serratec.java2.projetoEcommerce.repository.FuncionarioRepository;
import com.serratec.java2.projetoEcommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {


	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	FuncionarioRepository funcionarioRepository;
	

	public void inserirProduto(@Valid ProdutoForm produtoForm) throws ValorInvalidoException, ParametroObrigatorioException {
		if(produtoForm == null) throw new ParametroObrigatorioException("Campo 'produto' é obrigatório");
		Produto produto = new Produto();
		
		//Categoria
		Integer codCat = produtoForm.getCodigo_categoria();
		Optional <Categoria> opCat = categoriaRepository.findById(codCat);
		
		
		Categoria categoria = opCat.get();
		produto.setCategoria(categoria);
		
		//Funcionario
		Integer codFun = produtoForm.getCodigo_funcionario();
		Optional <Funcionario> opFun = funcionarioRepository.findById(codFun);
		Funcionario funcionario = opFun.get();
		produto.setFuncionario(funcionario);
		
		
		produto.setData_fabricacao(produtoForm.getData_fabricacao());
		produto.setDescricao(produtoForm.getDescricao());
		produto.setNome(produtoForm.getNome());
		produto.setValor_unitario(produtoForm.getValor_unitario());
		produto.setQuantidade_estoque(produtoForm.getQuantidade_estoque());
		
		
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

	public List<ProdutoForm> listarProdutos() {
		List<ProdutoForm> pFormSet = new ArrayList<>();
		List<Produto> pList = produtoRepository.findAll();
		
		for(int i = 0; i < pList.size(); i++) {
			ProdutoForm pForm = new ProdutoForm();
			Categoria categoria = new Categoria();
			Funcionario funcionario = new Funcionario();
			Produto produto = new Produto();
			
			produto = pList.get(i);
			categoria = produto.getCategoria();
			pForm.setCodigo(produto.getCodigo());
			pForm.setCodigo_categoria(categoria.getCodigo());
			pForm.setNome_categoria(categoria.getNome());
			funcionario = produto.getFuncionario();
			pForm.setCodigo_funcionario(funcionario.getCodigo());
			pForm.setNome_funcionario(funcionario.getNome());
			pForm.setNome(produto.getNome());
			pForm.setDescricao(produto.getDescricao());
			pForm.setData_fabricacao(produto.getData_fabricacao());
			pForm.setQuantidade_estoque(produto.getQuantidade_estoque());
			pForm.setValor_unitario(produto.getValor_unitario());
			
			pFormSet.add(pForm);
		}
		return pFormSet;
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
	
	public Produto substituir(Integer id, Produto produto) throws ValorInvalidoException, produtoNotFoundException, ParametroObrigatorioException {
		if(produto == null) throw new ParametroObrigatorioException("Campo 'produto' é obrigatório");
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
