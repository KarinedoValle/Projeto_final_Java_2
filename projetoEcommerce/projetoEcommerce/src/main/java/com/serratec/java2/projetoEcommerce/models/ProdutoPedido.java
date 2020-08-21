package com.serratec.java2.projetoEcommerce.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "produto_pedido")
public class ProdutoPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo", nullable = false)
	private Integer id;
	
	@Column(name = "quantidade_itens", nullable = false)
	private Integer quantidade_itens;
	
	//Foreign keys

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "produto", joinColumns = @JoinColumn (name = "codigo_produto", 
			referencedColumnName = "codigo"))
	@Column(name = "codigo_produto", nullable = false)
	private Integer codigo_produto;
	
	@JoinTable(name = "produto", joinColumns = @JoinColumn (name = "codigo_produto", 
			referencedColumnName = "codigo"))
	@Column(name = "codigo_pedido", nullable = false)
	private Integer codigo_pedido;
	
	
	
	
	//Construtores
	public ProdutoPedido() {
	}


	public ProdutoPedido(Integer codigo, Integer quantidade_itens, Integer codigo_produto, Integer codigo_pedido) {
		super();
		this.id = codigo;
		this.quantidade_itens = quantidade_itens;
		this.codigo_produto = codigo_produto;
		this.codigo_pedido = codigo_pedido;
	}


	
	//Getters and Setters
	public Integer getCodigo() {
		return id;
	}


	public void setCodigo(Integer codigo) {
		this.id = codigo;
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
