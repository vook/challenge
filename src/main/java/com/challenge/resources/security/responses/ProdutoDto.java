package com.challenge.resources.security.responses;

import com.challenge.models.Produto;

public class ProdutoDto {
    private Integer id;
    private String produto;
    private String categoria;
    private Integer preco;
    private Integer quantidade;
    private String descricao;
    private String foto;

    public Integer getId() {
        return id;
    }

    public ProdutoDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getProduto() {
        return produto;
    }

    public ProdutoDto setProduto(String produto) {
        this.produto = produto;
        return this;
    }

    public String getCategoria() {
        return categoria;
    }

    public ProdutoDto setCategoria(String categoria) {
        this.categoria = categoria;
        return this;
    }

    public Integer getPreco() {
        return preco;
    }

    public ProdutoDto setPreco(Integer preco) {
        this.preco = preco;
        return this;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public ProdutoDto setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public ProdutoDto setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public String getFoto() {
        return foto;
    }

    public ProdutoDto setFoto(String foto) {
        this.foto = foto;
        return this;
    }

    public static ProdutoDto make(Produto produto)
    {
        return (new ProdutoDto())
                .setId(produto.getId())
                .setCategoria(produto.getCategoria().getCategoria())
                .setProduto(produto.getProduto())
                .setPreco(produto.getPreco())
                .setDescricao(produto.getDescricao())
                .setFoto(produto.getFoto());
    }
}
