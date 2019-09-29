package com.challenge.resources.security.responses;

import com.challenge.enums.Status;
import com.challenge.models.Pedido;

public class FecharPedidoDto {
    private Integer pedido;
    private Status status;
    private Integer total;

    public static FecharPedidoDto make(Pedido pedido)
    {
        return (new FecharPedidoDto())
            .setPedido(pedido.getId())
            .setStatus(pedido.getStatus())
            .setTotal(pedido.getTotal());
    }

    public Integer getPedido() {
        return pedido;
    }

    public FecharPedidoDto setPedido(Integer pedido) {
        this.pedido = pedido;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public FecharPedidoDto setStatus(Status status) {
        this.status = status;
        return this;
    }

    public Integer getTotal() {
        return total;
    }

    public FecharPedidoDto setTotal(Integer total) {
        this.total = total;
        return this;
    }
}
