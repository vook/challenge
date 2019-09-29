package com.challenge.models;

import javax.persistence.*;

@Entity
@Table(name = "PEDIDO_ITENS")
public class PedidoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ITEM")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_PEDIDO", referencedColumnName = "ID_PEDIDO")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID_PRODUTO")
    private Produto produto;

    private Integer quantidade;

    private Integer valor;

    private Integer subtotal;

    public Integer getId() {
        return id;
    }

    public PedidoItem setId(Integer id) {
        this.id = id;
        return this;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public PedidoItem setPedido(Pedido pedido) {
        this.pedido = pedido;
        return this;
    }

    public Produto getProduto() {
        return produto;
    }

    public PedidoItem setProduto(Produto produto) {
        this.produto = produto;
        return this;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public PedidoItem setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public Integer getValor() {
        return valor;
    }

    public PedidoItem setValor(Integer valor) {
        this.valor = valor;
        return this;
    }

    public Integer getSubtotal() {
        return subtotal;
    }

    public PedidoItem setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
        return this;
    }
}
