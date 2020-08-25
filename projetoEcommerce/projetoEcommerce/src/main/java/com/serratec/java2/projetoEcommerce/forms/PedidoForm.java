package com.serratec.java2.projetoEcommerce.forms;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class PedidoForm {
	
	@NotNull
	private String data_pedido;
	
	
	private Double valor_total;
	
	@NotNull
	private Integer codigo_cliente;
	
	private String cliente_nome;
	
	private Integer codigo;
	
	private Integer quantidade_item;
	
	private Integer codigo_produto;
	
	//de produtoPedido
	List<ProdutoPedidoForm> produtosPedidos = new ArrayList<>();
	
	
	//Getters and Setters
	public List<ProdutoPedidoForm> getProdutosPedidos() {
		return produtosPedidos;
	}

	public void setProdutosPedidos(List<ProdutoPedidoForm> produtosPedidos) {
		this.produtosPedidos = produtosPedidos;
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

	public String getCliente_nome() {
		return cliente_nome;
	}

	public void setCliente_nome(String cliente_nome) {
		this.cliente_nome = cliente_nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getQuantidade_item() {
		return quantidade_item;
	}

	public void setQuantidade_item(Integer quantidade_item) {
		this.quantidade_item = quantidade_item;
	}

	public Integer getCodigo_produto() {
		return codigo_produto;
	}

	public void setCodigo_produto(Integer codigo_produto) {
		this.codigo_produto = codigo_produto;
	}
	
	

}
