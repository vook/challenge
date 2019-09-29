package com.challenge.forms;

import com.challenge.models.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateCategoriaForm {

    @NotNull
    @NotEmpty
    @Length(max = 50)
    private String categoria;

    public CreateCategoriaForm setCategoria(String categoria) {
        this.categoria = categoria;
        return this;
    }

    public Categoria create()
    {
        return (new Categoria())
                .setCategoria(categoria);
    }
}
