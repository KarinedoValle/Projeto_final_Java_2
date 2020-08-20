package com.serratec.java2.projetoEcommerce.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo", nullable = false)
	private Integer codigo;
	
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "descricao", nullable = false, length = 200)
	private String descricao;
	
	@Column(name = "quantidade_estoque", nullable = false)
	private Integer quantidade_estoque;
	
	@Column(name = "data_fabricacao")
	@DateTimeFormat(iso = ISO.DATE)
	private Date data_fabricacao;
	
	@Column(name = "valor_unitario", nullable = false)
	private Double valor_unitario;
	
	//foreign keys
	@Column(name = "valor_unitario", nullable = false)
	private Integer codigo_funcionario;
	
	@Column(name = "valor_unitario", nullable = false)
	private Integer codigo_categoria;
	

	//Construtores
	public Produto() {
	}


	public Produto(Integer codigo, String nome, String descricao, Integer quantidade_estoque, Date data_fabricacao,
			Double valor_unitario, Integer codigo_funcionario, Integer codigo_categoria) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.quantidade_estoque = quantidade_estoque;
		this.data_fabricacao = data_fabricacao;
		this.valor_unitario = valor_unitario;
		this.codigo_funcionario = codigo_funcionario;
		this.codigo_categoria = codigo_categoria;
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


	public Integer getQuantidade_estoque() {
		return quantidade_estoque;
	}


	public void setQuantidade_estoque(Integer quantidade_estoque) {
		this.quantidade_estoque = quantidade_estoque;
	}


	public Date getData_fabricacao() {
		return data_fabricacao;
	}


	public void setData_fabricacao(Date data_fabricacao) {
		this.data_fabricacao = data_fabricacao;
	}


	public Double getValor_unitario() {
		return valor_unitario;
	}


	public void setValor_unitario(Double valor_unitario) {
		this.valor_unitario = valor_unitario;
	}


	public Integer getCodigo_funcionario() {
		return codigo_funcionario;
	}


	public void setCodigo_funcionario(Integer codigo_funcionario) {
		this.codigo_funcionario = codigo_funcionario;
	}


	public Integer getCodigo_categoria() {
		return codigo_categoria;
	}


	public void setCodigo_categoria(Integer codigo_categoria) {
		this.codigo_categoria = codigo_categoria;
	}
	
	

}
