package com.challenge.resources.security.responses;

import com.challenge.enums.Status;
import com.challenge.models.Pedido;
import com.challenge.models.PedidoItem;

public class AddPedidoDto {
    private Integer pedido;
    private Status status;
    private Integer quantidade;
    private Integer valor;
    private Integer subtotal;
    private Integer total;

    public static AddPedidoDto make(Pedido pedido, PedidoItem item)
    {
        return (new AddPedidoDto())
            .setPedido(pedido.getId())
            .setStatus(pedido.getStatus())
            .setQuantidade(item.getQuantidade())
            .setValor(item.getValor())
            .setSubtotal(item.getSubtotal())
            .setTotal(pedido.getTotal());
    }

    public Integer getPedido() {
        return pedido;
    }

    public AddPedidoDto setPedido(Integer pedido) {
        this.pedido = pedido;
        return this;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Status getStatus() {
        return status;
    }

    public AddPedidoDto setStatus(Status status) {
        this.status = status;
        return this;
    }

    public AddPedidoDto setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public Integer getValor() {
        return valor;
    }

    public AddPedidoDto setValor(Integer valor) {
        this.valor = valor;
        return this;
    }

    public Integer getSubtotal() {
        return subtotal;
    }

    public AddPedidoDto setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
        return this;
    }

    public Integer getTotal() {
        return total;
    }

    public AddPedidoDto setTotal(Integer total) {
        this.total = total;
        return this;
    }
}
