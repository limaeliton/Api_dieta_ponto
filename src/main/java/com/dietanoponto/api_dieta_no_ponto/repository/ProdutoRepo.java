package com.dietanoponto.api_dieta_no_ponto.repository;

import com.dietanoponto.api_dieta_no_ponto.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepo extends JpaRepository<Produto, Long>{
    
}
