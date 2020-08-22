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

import com.sun.istack.NotNull;

@Entity
@Table(name = "funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@NotNull
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;
	
	@NotNull
	@Column(name = "cpf", nullable = false, length = 11)
	private Integer cpf;
	
	@OneToMany(targetEntity = Produto.class, mappedBy = "funcionario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Produto> produtos;
	
	//Construtores
	public Funcionario() {
		
	}

	public Funcionario(Integer codigo, String nome, Integer cpf) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
	}

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

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
	
	

}
