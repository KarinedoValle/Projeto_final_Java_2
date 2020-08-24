package com.serratec.java2.projetoEcommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.serratec.java2.projetoEcommerce.forms.ProdutoForm;

@Repository
public interface ProdutoFormRepository extends JpaRepository<ProdutoForm, Integer> {

}
