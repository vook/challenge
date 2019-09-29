package com.challenge.forms;

import com.challenge.models.Produto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class RemovePedidoForm
{
    @NotNull
    @Positive
    private Integer produto;

    public Integer getProduto() {
        return produto;
    }

    public RemovePedidoForm setProduto(Integer produto) {
        this.produto = produto;
        return this;
    }
}
