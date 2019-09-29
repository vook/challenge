package com.challenge.repositories;

import com.challenge.models.Pedido;
import com.challenge.models.PedidoItem;
import com.challenge.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoItemRepository extends JpaRepository<PedidoItem, Integer>
{
    @Query("select i from PedidoItem i where i.pedido = :pedido and i.produto = :produto")
    public PedidoItem getPedidoPorClienteEStatus(Pedido pedido, Produto produto);
}
