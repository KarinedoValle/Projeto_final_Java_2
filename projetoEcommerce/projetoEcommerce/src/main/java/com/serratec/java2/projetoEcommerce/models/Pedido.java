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
@Table(name = "pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo", nullable = false)
	private Integer codigo;
	
	@Column(name = "data_pedido")
	@DateTimeFormat(iso = ISO.DATE)
	private Date data_pedido;
	
	@Column(name = "valor_total", nullable = false)
	private Integer valor_total;
	
	//Foreing key
	@Column(name = "codigo_cliente", nullable = false)
	private Integer codigo_cliente;

	//Construtores
	public Pedido() {
	}

	public Pedido(Integer codigo, Date data_pedido, Integer valor_total, Integer codigo_cliente) {
		super();
		this.codigo = codigo;
		this.data_pedido = data_pedido;
		this.valor_total = valor_total;
		this.codigo_cliente = codigo_cliente;
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

	public Integer getCodigo_cliente() {
		return codigo_cliente;
	}

	public void setCodigo_cliente(Integer codigo_cliente) {
		this.codigo_cliente = codigo_cliente;
	}
	
	
	
}
