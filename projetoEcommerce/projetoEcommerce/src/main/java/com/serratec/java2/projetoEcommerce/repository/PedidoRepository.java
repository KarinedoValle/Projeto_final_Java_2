package com.serratec.java2.projetoEcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serratec.java2.projetoEcommerce.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
