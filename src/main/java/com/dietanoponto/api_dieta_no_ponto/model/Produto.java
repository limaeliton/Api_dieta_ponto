package com.dietanoponto.api_dieta_no_ponto.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produto {
    
    private Long id;
    private String productName;
    private Integer currentyInventory;
    private String validity;
    
     public Produto() {
    }

    public Produto(Long id, String productName, Integer currentyInventory, String validity) {
        this.id = id;
        this.productName = productName;
        this.currentyInventory = currentyInventory;
        this.validity = validity;
    }


    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Integer getCurrentyInventory() {
        return currentyInventory;
    }
    public void setCurrentyInventory(Integer currentyInventory) {
        this.currentyInventory = currentyInventory;
    }
    public String getValidity() {
        return validity;
    }
    public void setValidity(String validity) {
        this.validity = validity;
    }

    public void baixaestoque(int qtd){
        this.currentyInventory -= qtd; 
    }

}
