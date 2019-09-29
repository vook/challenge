package com.challenge.forms;

import com.challenge.models.Produto;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class EditProdutoForm {

    @NotNull
    @NotEmpty
    @Length(min = 2, max = 50)
    private String produto;

    @NotNull
    @Positive
    private Integer categoria;

    @NotNull
    @Positive
    private Integer preco;

    @NotNull
    @Positive
    private Integer quantidade;

    @NotNull
    @NotEmpty
    @Length(min = 2, max = 255)
    private String descricao;

    @NotNull
    @NotEmpty
    @Length(max = 150)
    private String foto;

    public String getProduto() {
        return produto;
    }

    public EditProdutoForm setProduto(String produto) {
        this.produto = produto;
        return this;
    }

    public Integer getCategoria() {
        return categoria;
    }

    public EditProdutoForm setCategoria(Integer categoria) {
        this.categoria = categoria;
        return this;
    }

    public Integer getPreco() {
        return preco;
    }

    public EditProdutoForm setPreco(Integer preco) {
        this.preco = preco;
        return this;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public EditProdutoForm setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public EditProdutoForm setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public String getFoto() {
        return foto;
    }

    public EditProdutoForm setFoto(String foto) {
        this.foto = foto;
        return this;
    }

    public Produto edit(Produto produto)
    {
        return produto
            .setProduto(this.produto)
            .setQuantidade(this.quantidade)
            .setPreco(this.preco)
            .setDescricao(this.descricao)
            .setFoto(this.foto);
    }
}
