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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "pedido")
public class Pedido extends ProdutoPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	
	@Column(name = "data_pedido")
	private String data_pedido;
	
	@NotNull
	@Column(name = "valor_total", nullable = false)
	private Integer valor_total;
	
//	@Column(name = "codigo_cliente", insertable = false, updatable = false)
//	private Integer codigo_cliente;
	
	//Foreing key
	@ManyToOne()
	@JoinColumn (name = "codigo_cliente", referencedColumnName = "codigo")
	private Cliente cliente;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "produto_pedido", joinColumns = @JoinColumn (name = "codigo_pedido", 
	referencedColumnName = "codigo"),
	inverseJoinColumns = @JoinColumn (name = "codigo_produto", referencedColumnName = "codigo"))
	private List<Produto> codigoProduto;
	
	
	//Getters and Setters
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getData_pedido() {
		return data_pedido;
	}

	public void setData_pedido(String data_pedido) {
		this.data_pedido = data_pedido;
	}

	public Integer getValor_total() {
		return valor_total;
	}

	public void setValor_total(Integer valor_total) {
		this.valor_total = valor_total;
	}

	
}
