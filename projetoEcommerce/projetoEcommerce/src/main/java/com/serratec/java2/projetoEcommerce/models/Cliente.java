package com.serratec.java2.projetoEcommerce.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "usuario", nullable = false, length = 50)
	private String usuario;
	
	@NotNull
	@Email
	@Size(max = 50)
	@Column(name = "email", nullable = false, length = 50)
	private String email;
	
	@NotNull
	@Size(max = 11)
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@Past
	@Column(name = "data_nascimento")
//	@DateTimeFormat(iso = ISO.DATE)
	private String data_nascimento;
		
	@OneToMany(targetEntity = Pedido.class, mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Pedido> pedidos;
	
	//Chave estrangeira da tabela endereço
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_endereco", referencedColumnName = "codigo")
	private Endereco endereco;
	
	

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	

	
}
