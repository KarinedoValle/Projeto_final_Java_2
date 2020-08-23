package com.serratec.java2.projetoEcommerce.models;

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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "produto_pedido")
public class ProdutoPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@NotNull
	@Size(max = 50)
	@Column(name = "quantidade_itens", nullable = false)
	private Integer quantidade_itens;
	
	//Foreign keys

	 

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinTable(name = "produto", joinColumns = @JoinColumn (name = "codigo_produto", 
//            referencedColumnName = "codigo"))
//    private Produto produto;
//    
//
// 
//
//    @JoinTable(name = "produto", joinColumns = @JoinColumn (name = "codigo_produto", 
//            referencedColumnName = "codigo"))
//    private Pedido pedido;
	
	//Getters and Setters
	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public Integer getQuantidade_itens() {
		return quantidade_itens;
	}


	public void setQuantidade_itens(Integer quantidade_itens) {
		this.quantidade_itens = quantidade_itens;
	}


}
