package com.serratec.java2.projetoEcommerce.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "descricao", nullable = false, length = 100)
	private String descricao;
	
	@OneToMany(targetEntity = Produto.class, mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Produto> produtos;
	

	//Construtores
	public Categoria() {
	}


	public Categoria(Integer codigo, String nome, String descricao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
	}


	//Getters and Setters
	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
}
