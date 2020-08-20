package com.serratec.java2.projetoEcommerce.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto_pedido")
public class ProdutoPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo", nullable = false)
	private Integer codigo;
	
	@Column(name = "quantidade_itens", nullable = false)
	private Integer quantidade_itens;
	
	//Foreign keys
	@Column(name = "codigo_produto", nullable = false)
	private Integer codigo_produto;
	
	@Column(name = "codigo_pedido", nullable = false)
	private Integer codigo_pedido;
	
	
	//Construtores
	public ProdutoPedido() {
	}


	public ProdutoPedido(Integer codigo, Integer quantidade_itens, Integer codigo_produto, Integer codigo_pedido) {
		super();
		this.codigo = codigo;
		this.quantidade_itens = quantidade_itens;
		this.codigo_produto = codigo_produto;
		this.codigo_pedido = codigo_pedido;
	}


	
	//Getters and Setters
	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


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


	public Integer getCodigo_pedido() {
		return codigo_pedido;
	}


	public void setCodigo_pedido(Integer codigo_pedido) {
		this.codigo_pedido = codigo_pedido;
	}

	
}
