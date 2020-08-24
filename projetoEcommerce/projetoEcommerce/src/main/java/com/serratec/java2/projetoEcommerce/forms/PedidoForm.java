package com.serratec.java2.projetoEcommerce.forms;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pedido")
public class PedidoForm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@NotNull
	private String data_pedido;
	
	@NotNull
	private Double valor_total;
	
	@NotNull
	private Integer codigo_cliente;
	
	@NotNull
	//de produtoPedido
	List<ProdutoPedidoForm> produtosPedidos = new ArrayList<>();
	
	
	//Getters and Setters
	public List<ProdutoPedidoForm> getProdutosPedidos() {
		return produtosPedidos;
	}

	public void setProdutosPedidos(List<ProdutoPedidoForm> produtosPedidos) {
		this.produtosPedidos = produtosPedidos;
	}

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

	public Integer getCodigo_cliente() {
		return codigo_cliente;
	}

	public void setCodigo_cliente(Integer codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}
	
	

}
