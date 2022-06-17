package com.dietanoponto.api_dieta_no_ponto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.dietanoponto.api_dieta_no_ponto.repository.PontoRepo;
import com.dietanoponto.api_dieta_no_ponto.model.Ponto;

@RestController
@RequestMapping(value="/ponto")
public class PontoController {
    
    @Autowired
    private PontoRepo pontoRepo;

    @GetMapping
    public List<Ponto> listPonto(){
        return pontoRepo.findAll();
    }
    
    @PostMapping
    public Ponto save(@RequestBody Ponto newPonto){
        return pontoRepo.save(newPonto);
    }

    @PutMapping("/{id}")
    public String update(@RequestBody Ponto newPonto, @PathVariable Long id){
        if(pontoRepo.existsById(id)){
            Ponto ponto_db = pontoRepo.findById(id).orElse(null);
            if((newPonto.getPointName() != null) && (ponto_db.getPointName() != newPonto.getPointName())){
                ponto_db.setPointName(newPonto.getPointName());
            }
            pontoRepo.save(ponto_db);
            return "Ponto" + ponto_db.getPointName() + " Atualizado com sucesso!";
        }else{
            return "Ponto não encontrado!";
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        if(pontoRepo.existsById(id)){
            pontoRepo.deleteById(id);
            return "Ponto excluído com sucesso!";
        }else{
            return "Ponto não encontrado";
        }
    }
}
