package com.challenge.resources.security.responses;

import com.challenge.enums.Status;
import com.challenge.models.Pedido;
import org.springframework.data.domain.Page;

import java.util.Date;

public class PedidoDto {

    private Integer id;

    private String cliente;

    private Status status;

    private Integer total;

    private Date dataAbertura;

    private Date dataFechamento;

    public Integer getId() {
        return id;
    }

    public PedidoDto setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCliente() {
        return cliente;
    }

    public PedidoDto setCliente(String cliente) {
        this.cliente = cliente;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public PedidoDto setStatus(Status status) {
        this.status = status;
        return this;
    }

    public Integer getTotal() {
        return total;
    }

    public PedidoDto setTotal(Integer total) {
        this.total = total;
        return this;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public PedidoDto setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
        return this;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public PedidoDto setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
        return this;
    }

    public static Page<PedidoDto> make(Page<Pedido> pedidos)
    {
        return pedidos.map((Pedido pedido) -> (new PedidoDto())
            .setId(pedido.getId())
            .setStatus(pedido.getStatus())
            .setTotal(pedido.getTotal())
            .setCliente(pedido.getCliente().getNome())
            .setDataAbertura(pedido.getDataAbertura())
            .setDataFechamento(pedido.getDataFechamento())
        );
    }
}
