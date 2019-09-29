package com.challenge.resources.security.responses;

import com.challenge.models.Categoria;

public class CategoriaDto {
    private Integer id;
    private String categoria;

    public static CategoriaDto make(Categoria categoria) {
        return (new CategoriaDto()).setId(categoria.getId())
            .setCategoria(categoria.getCategoria());
    }

    public Integer getId() {
        return id;
    }

    public CategoriaDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCategoria() {
        return categoria;
    }

    public CategoriaDto setCategoria(String categoria) {
        this.categoria = categoria;
        return this;
    }
}
