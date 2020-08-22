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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "pedido")
public class Pedido extends ProdutoPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name = "data_pedido")
	@DateTimeFormat(iso = ISO.DATE)
	private Date data_pedido;
	
	@Column(name = "valor_total", nullable = false)
	private Integer valor_total;
	
	//Foreing key
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn (name = "codigo_cliente", 
	referencedColumnName = "codigo")
	private Cliente cliente;
	
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "produto_pedido", joinColumns = @JoinColumn (name = "codigo_pedido", 
	referencedColumnName = "codigo"),
	inverseJoinColumns = @JoinColumn (name = "codigo_produto", referencedColumnName = "codigo"))
	private List<Produto> codigoProduto;
	
	

	//Construtores
	public Pedido() {
	}

	public Pedido(Integer codigo, Date data_pedido, Integer valor_total) {
		super();
		this.codigo = codigo;
		this.data_pedido = data_pedido;
		this.valor_total = valor_total;
	}

	
	//Getters and Setters
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getData_pedido() {
		return data_pedido;
	}

	public void setData_pedido(Date data_pedido) {
		this.data_pedido = data_pedido;
	}

	public Integer getValor_total() {
		return valor_total;
	}

	public void setValor_total(Integer valor_total) {
		this.valor_total = valor_total;
	}

	
}
