package com.challenge.forms;

import com.challenge.models.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EditCategoriaForm {

    @NotNull
    @NotEmpty
    @Length(max = 50)
    private String categoria;

    public EditCategoriaForm setCategoria(String categoria) {
        this.categoria = categoria;
        return this;
    }

    public Categoria edit(Categoria categoria)
    {
        return categoria.setCategoria(this.categoria);
    }
}
