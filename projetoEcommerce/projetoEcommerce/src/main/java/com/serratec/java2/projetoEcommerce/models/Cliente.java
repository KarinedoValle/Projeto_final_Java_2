package com.serratec.java2.projetoEcommerce.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo", nullable = false)
	private Integer id;
	
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "usuario", nullable = false, length = 50)
	private String usuario;
	
	@Column(name = "email", nullable = false, length = 50)
	private String email;
	
	@Column(name = "cpf", nullable = false)
	private Integer cpf;
	
	@Column(name = "data_nascimento")
	@DateTimeFormat(iso = ISO.DATE)
	private Date data_nascimento;
	
	@OneToMany(targetEntity = Pedido.class, mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Pedido> pedidos;
	
	//Chave estrangeira da tabela endereço
	
	@OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	@Column(name = "codigo_endereco", nullable = false)
	private Integer codigo_endereco;
	
	
	//Construtores
	public Cliente() {
		
	}
	
	public Cliente(Integer codigo, String nome, String usuario, String email, Integer cpf, Date data_nascimento,
			Integer codigo_endereco) {
		super();
		this.id = codigo;
		this.nome = nome;
		this.usuario = usuario;
		this.email = email;
		this.cpf = cpf;
		this.data_nascimento = data_nascimento;
		this.codigo_endereco = codigo_endereco;
	}
	

	//Getters and Setters
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public Integer getCodigo_endereco() {
		return codigo_endereco;
	}

	public void setCodigo_endereco(Integer codigo_endereco) {
		this.codigo_endereco = codigo_endereco;
	}

}
