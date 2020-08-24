package com.serratec.java2.projetoEcommerce.forms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
@Table(name = "produto")
public class ProdutoForm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String descricao;
	
	@NotNull
	private Integer quantidade_estoque;
	
	@Past
	@NotNull
	private String data_fabricacao;
	
	@NotNull
	private Double valor_unitario;
	
	@NotNull
	private Integer codigo_funcionario;
	
	@NotNull
	private Integer codigo_categoria;

	
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

	public String getData_fabricacao() {
		return data_fabricacao;
	}

	public void setData_fabricacao(String data_fabricacao) {
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
