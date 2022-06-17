package com.dietanoponto.api_dieta_no_ponto.controller;

import java.util.List;

import com.dietanoponto.api_dieta_no_ponto.model.Produto;
import com.dietanoponto.api_dieta_no_ponto.repository.ProdutoRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/produto")
public class ProdutoController {
    @Autowired
    private ProdutoRepo produtoRepo;

    @GetMapping
    public List<Produto> listProducts(){
        return produtoRepo.findAll();
    }

    @PostMapping
    public Produto save(@RequestBody Produto newProduct){
        return produtoRepo.save(newProduct);
    }

    @PutMapping("/{id}")
    public String update(@RequestBody Produto newProduto, @PathVariable Long id){
        if(produtoRepo.existsById(id)){
            Produto prod_db = produtoRepo.findById(id).orElse(null);
        
            if((newProduto.getProductName() != null) && (prod_db.getProductName() != newProduto.getProductName())){
                prod_db.setProductName(newProduto.getProductName());
            }
            if((newProduto.getCurrentyInventory() != null) && (prod_db.getCurrentyInventory() != newProduto.getCurrentyInventory())){
                prod_db.setCurrentyInventory(newProduto.getCurrentyInventory());
            }
            if((newProduto.getValidity() != null) && (prod_db.getValidity() != newProduto.getValidity())){
                prod_db.setValidity(newProduto.getValidity());
            }
            produtoRepo.save(prod_db);
            return "Produto " + prod_db.getProductName() + " atualizado com sucesso";
        }else{
            return "Produto não encontrado";
        }

    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        if(produtoRepo.existsById(id)){
            produtoRepo.deleteById(id);
            return "Produto deletado com sucesso!";
        }else{
            return "Produto não encontrado!";
        }
    }
}
