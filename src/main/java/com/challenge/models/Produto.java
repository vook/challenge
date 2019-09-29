package com.challenge.models;

import javax.persistence.*;

@Entity
@Table(name = "PRODUTOS")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUTO")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA", referencedColumnName = "ID_CATEGORIA")
    private Categoria categoria;

    private String produto;

    private Integer preco;

    private Integer quantidade;

    private String descricao;

    private String foto;

    public Integer getId() {
        return id;
    }

    public Produto setId(Integer id) {
        this.id = id;
        return this;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Produto setCategoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }

    public String getProduto() {
        return produto;
    }

    public Produto setProduto(String produto) {
        this.produto = produto;
        return this;
    }

    public Integer getPreco() {
        return preco;
    }

    public Produto setPreco(Integer preco) {
        this.preco = preco;
        return this;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Produto setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Produto setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public String getFoto() {
        return foto;
    }

    public Produto setFoto(String foto) {
        this.foto = foto;
        return this;
    }
}
