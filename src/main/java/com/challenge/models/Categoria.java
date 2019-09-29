package com.challenge.models;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORIAS")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CATEGORIA")
    private Integer id;

    private String categoria;

    public Integer getId() {
        return id;
    }

    public Categoria setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCategoria() {
        return categoria;
    }

    public Categoria setCategoria(String categoria) {
        this.categoria = categoria;
        return this;
    }
}
