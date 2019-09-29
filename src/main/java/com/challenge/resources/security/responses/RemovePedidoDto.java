package com.challenge.resources.security.responses;

import com.challenge.enums.Status;
import com.challenge.models.Pedido;

public class RemovePedidoDto {
    private Integer pedido;
    private Status status;
    private Integer total;

    public static RemovePedidoDto make(Pedido pedido)
    {
        return (new RemovePedidoDto())
                .setPedido(pedido.getId())
                .setStatus(pedido.getStatus())
                .setTotal(pedido.getTotal());
    }

    public Integer getPedido() {
        return pedido;
    }

    public RemovePedidoDto setPedido(Integer pedido) {
        this.pedido = pedido;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public RemovePedidoDto setStatus(Status status) {
        this.status = status;
        return this;
    }

    public Integer getTotal() {
        return total;
    }

    public RemovePedidoDto setTotal(Integer total) {
        this.total = total;
        return this;
    }
}
