package com.challenge.forms;

import com.challenge.models.Produto;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class CreateProdutoForm {

    @NotNull
    @NotEmpty
    @Length(min = 2, max = 50)
    private String produto;

    @NotNull
    @Positive
    private Integer categoria;

    @PositiveOrZero
    @NotNull
    private Integer quantidade;

    @Positive
    @NotNull
    private Integer preco;

    @NotNull
    @NotEmpty
    @Length(min = 2, max = 255)
    private String descricao;

    @NotNull
    @NotEmpty
    @Length(max = 150)
    private String foto;


    public void setProduto(String produto) {
        this.produto = produto;
    }

    public CreateProdutoForm setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public CreateProdutoForm setCategoria(Integer categoria) {
        this.categoria = categoria;
        return this;
    }

    public Produto create()
    {
        return (new Produto())
                .setProduto(produto)
                .setQuantidade(quantidade)
                .setPreco(preco)
                .setDescricao(descricao)
                .setFoto(foto);
    }
}
