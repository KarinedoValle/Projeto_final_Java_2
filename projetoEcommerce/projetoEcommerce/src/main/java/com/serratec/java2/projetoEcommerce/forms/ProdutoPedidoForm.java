package com.serratec.java2.projetoEcommerce.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProdutoPedidoForm {
	
	@NotNull
	@Size(max = 50)
	private Integer quantidade_itens;
	
	@NotNull
	private Integer codigo_produto;
	
	private String produto_nome;
	
	
	private Double valor_unitario;
	
	
	//Getters and Setters
	public Integer getQuantidade_itens() {
		return quantidade_itens;
	}

	public void setQuantidade_itens(Integer quantidade_itens) {
		this.quantidade_itens = quantidade_itens;
	}

	public Integer getCodigo_produto() {
		return codigo_produto;
	}

	public void setCodigo_produto(Integer codigo_produto) {
		this.codigo_produto = codigo_produto;
	}

	public String getProduto_nome() {
		return produto_nome;
	}

	public void setProduto_nome(String produto_nome) {
		this.produto_nome = produto_nome;
	}

	public Double getValor_unitario() {
		return valor_unitario;
	}

	public void setValor_unitario(Double valor_unitario) {
		this.valor_unitario = valor_unitario;
	}

	
}
