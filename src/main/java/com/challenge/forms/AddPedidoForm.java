package com.challenge.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class AddPedidoForm
{
    @NotNull
    @Positive
    private Integer produto;

    @NotNull
    @Positive
    private Integer quantidade;

    public Integer getProduto() {
        return produto;
    }

    public AddPedidoForm setProduto(Integer produto) {
        this.produto = produto;
        return this;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public AddPedidoForm setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }
}
