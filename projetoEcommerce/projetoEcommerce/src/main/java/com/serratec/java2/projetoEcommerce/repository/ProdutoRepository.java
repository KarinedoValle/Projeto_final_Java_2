package com.serratec.java2.projetoEcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.serratec.java2.projetoEcommerce.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {


}
