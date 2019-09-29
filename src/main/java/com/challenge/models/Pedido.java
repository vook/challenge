package com.challenge.models;

import com.challenge.enums.Status;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PEDIDOS")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PEDIDO")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    private Cliente cliente;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private Set<PedidoItem> itens = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private Status status;

    private Integer total;

    private Date dataAbertura;

    private Date dataFechamento;

    public Integer getId() {
        return id;
    }

    public Pedido setId(Integer id) {
        this.id = id;
        return this;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Pedido setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public Set<PedidoItem> getItens() {
        return itens;
    }

    public Pedido addProdutos(PedidoItem item) {
        this.itens.add(item);
        return this;
    }

    public Pedido removeProdutos(PedidoItem item) {
        this.itens.remove(item);
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Pedido setStatus(Status status) {
        this.status = status;
        return this;
    }

    public Integer getTotal() {
        return total;
    }

    public Pedido setTotal(Integer total) {
        this.total = total;
        return this;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public Pedido setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
        return this;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public Pedido setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
        return this;
    }
}
