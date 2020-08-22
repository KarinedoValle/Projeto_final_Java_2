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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name = "quantidade_itens", nullable = false)
	private Integer quantidade_itens;
	
	//Foreign keys

	
	
	
	
	//Construtores
	public ProdutoPedido() {
	}


	public ProdutoPedido(Integer codigo, Integer quantidade_itens) {
		super();
		this.codigo = codigo;
		this.quantidade_itens = quantidade_itens;
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


}
