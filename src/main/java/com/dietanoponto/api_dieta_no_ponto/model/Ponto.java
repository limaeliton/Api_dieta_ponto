package com.dietanoponto.api_dieta_no_ponto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ponto {
    private Long id;
    private String pointName;
    
    
    public Ponto() {
    }

    

    public Ponto(Long id, String pointName) {
        this.id = id;
        this.pointName = pointName;
    }


    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    
    
}
