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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	
	@Column(name = "data_pedido")
	private String data_pedido;
	
	@Column(name = "valor_total", nullable = false)
	private Double valor_total;
	
	
	//Foreing key
	@ManyToOne()
	@JoinColumn (name = "codigo_cliente", referencedColumnName = "codigo")
	private Cliente cliente;
	
	
	@OneToMany(targetEntity = ProdutoPedido.class, mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ProdutoPedido> ListPedidoProduto;
	
	
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

	public Double getValor_total() {
		return valor_total;
	}

	public void setValor_total(Double valor_total) {
		this.valor_total = valor_total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ProdutoPedido> getListPedidoProduto() {
		return ListPedidoProduto;
	}

	public void setListPedidoProduto(List<ProdutoPedido> listPedidoProduto) {
		ListPedidoProduto = listPedidoProduto;
	}

	
}
