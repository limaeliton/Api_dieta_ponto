package com.dietanoponto.api_dieta_no_ponto.controller;

import java.util.List;

import com.dietanoponto.api_dieta_no_ponto.model.Usuario;
import com.dietanoponto.api_dieta_no_ponto.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class UserController {
    @Autowired
    private UserRepo userRepo;


    @GetMapping
    public List<Usuario> findAll(){
        return userRepo.findAll();
    } 

    @PostMapping
    public Usuario save(@RequestBody Usuario newUser){
        return userRepo.save(newUser);
    }

    @PutMapping
    public Usuario udpdate(@RequestBody Usuario updateUser){
        return userRepo.save(updateUser);
    }

    @DeleteMapping
    public String delete(@RequestBody Usuario deleteUser){
        userRepo.delete(deleteUser);
        return "Usuário deletado com sucesso";
    }


}
