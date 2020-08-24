package com.serratec.java2.projetoEcommerce.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@NotNull
	@Size(max = 100)
	@Column(name = "rua", nullable = false, length = 100)
	private String rua;
	
	@NotNull
	@Column(name = "numero", nullable = false)
	private Integer numero;
	
	
	@Size(max = 100)
	@Column(name = "complemento", length = 100)
	private String complemento;
	
	@NotNull
	@Size(max = 100)
	@Column(name = "bairro", nullable = false, length = 100)
	private String bairro;
	
	@NotNull
	@Size(max = 100)
	@Column(name = "cidade", nullable = false, length = 100)
	private String cidade;
	
	@NotNull
	@Size(max = 100)
	@Column(name = "estado", nullable = false, length = 100)
	private String estado;
	
	@NotNull
	@Column(name = "cep", nullable = false)
	private Integer cep;
	
	
	@OneToOne(targetEntity = Cliente.class, mappedBy = "endereco", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Cliente cliente;
	
	//Getters and Setters
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}
	
	

}
