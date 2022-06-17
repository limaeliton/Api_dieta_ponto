package com.dietanoponto.api_dieta_no_ponto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dietanoponto.api_dieta_no_ponto.model.Ponto;

public interface PontoRepo extends JpaRepository<Ponto, Long>{
    
}
