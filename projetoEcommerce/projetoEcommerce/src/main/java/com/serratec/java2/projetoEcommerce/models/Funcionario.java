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
@Table(name = "funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo", nullable = false)
	private Integer id;
	
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "cpf", nullable = false)
	private Integer cpf;
	
	@OneToMany(targetEntity = Produto.class, mappedBy = "funcionario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Produto> produtos;
	
	//Construtores
	public Funcionario() {
		
	}

	public Funcionario(Integer codigo, String nome, Integer cpf) {
		super();
		this.id = codigo;
		this.nome = nome;
		this.cpf = cpf;
	}

	public Integer getCodigo() {
		return id;
	}

	public void setCodigo(Integer codigo) {
		this.id = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
	
	

}
