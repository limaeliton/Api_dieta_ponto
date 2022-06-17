package com.dietanoponto.api_dieta_no_ponto.repository;

import com.dietanoponto.api_dieta_no_ponto.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Usuario, Long> {
    
}
