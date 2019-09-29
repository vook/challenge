package com.challenge.repositories;

import com.challenge.enums.Status;
import com.challenge.models.Cliente;
import com.challenge.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>
{
    @Query("select p from Pedido p where p.cliente = :cliente and p.status = :status")
    public Pedido getPedidoPorClienteEStatus(Cliente cliente, Status status);
}
