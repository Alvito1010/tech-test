package com.techtest.testbe.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="provinsi")
public class Provinsi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name", length=255)
    private String name;

    @Column(name="negara_id")
    private Integer negaraId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNegaraId() {
        return negaraId;
    }

    public void setNegaraId(Integer negaraId) {
        this.negaraId = negaraId;
    }

    
}
