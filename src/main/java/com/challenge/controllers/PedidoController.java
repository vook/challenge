package com.challenge.controllers;

import com.challenge.enums.Status;
import com.challenge.forms.AddPedidoForm;
import com.challenge.forms.RemovePedidoForm;
import com.challenge.models.Cliente;
import com.challenge.models.PedidoItem;
import com.challenge.models.Produto;
import com.challenge.repositories.PedidoItemRepository;
import com.challenge.repositories.ProdutoRepository;
import com.challenge.resources.security.responses.AddPedidoDto;
import com.challenge.resources.security.responses.FecharPedidoDto;
import com.challenge.resources.security.responses.PedidoDto;
import com.challenge.resources.security.responses.RemovePedidoDto;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import com.challenge.models.Pedido;
import com.challenge.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("pedido")
public class PedidoController
{
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoItemRepository pedidoItemRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public Page<PedidoDto> index (@PageableDefault Pageable pageable)
    {
        return PedidoDto.make(this.pedidoRepository.findAll(pageable));
    }

    @PostMapping("/adicionar")
    @Transactional
    public ResponseEntity<AddPedidoDto> adicionar(
            @RequestBody
            @Valid
            AddPedidoForm form,
            @ApiIgnore
            Authentication auth
    ) throws NotFoundException {
        Cliente cliente = (Cliente) auth.getPrincipal();
        Pedido pedido = this.pedidoRepository.getPedidoPorClienteEStatus(cliente, Status.ABERTO);
        if (pedido == null) {
            pedido = (new Pedido())
                    .setCliente(cliente)
                    .setDataAbertura(new Date())
                    .setStatus(Status.ABERTO)
                    .setTotal(0);
            this.pedidoRepository.save(pedido);
        }
        Produto produto = this.produtoRepository.findById(form.getProduto()).get();
        if (produto == null) {
            throw new NotFoundException("Produto não encontrado");
        }
        PedidoItem item = this.pedidoItemRepository.getPedidoPorClienteEStatus(pedido, produto);
        if (item == null) {
            item = (new PedidoItem())
                .setPedido(pedido)
                .setProduto(produto)
                .setQuantidade(form.getQuantidade())
                .setValor(produto.getPreco())
                .setSubtotal(produto.getPreco() * form.getQuantidade());
        } else {
            item.setQuantidade(form.getQuantidade())
                .setValor(produto.getPreco())
                .setSubtotal(produto.getPreco() * form.getQuantidade());
        }
        pedido.addProdutos(item)
            .setTotal(pedido.getTotal() + item.getSubtotal());
        this.pedidoRepository.save(pedido);
        return ResponseEntity.ok(AddPedidoDto.make(pedido, item));
    }

    @PostMapping("/remover")
    @Transactional
    public ResponseEntity<RemovePedidoDto> remover(
            @RequestBody
            @Valid
            RemovePedidoForm form,
            @ApiIgnore
            Authentication auth
    ) throws NotFoundException {
        Cliente cliente = (Cliente) auth.getPrincipal();
        Pedido pedido = this.pedidoRepository.getPedidoPorClienteEStatus(cliente, Status.ABERTO);
        Produto produto = this.produtoRepository.findById(form.getProduto()).get();
        PedidoItem item = this.pedidoItemRepository.getPedidoPorClienteEStatus(pedido, produto);
        if (produto == null || pedido == null || item == null) {
            throw new NotFoundException("Produto ou Pedido não encontrado");
        }
        pedido.setTotal(pedido.getTotal() - item.getSubtotal());
        this.pedidoRepository.save(pedido);
        this.pedidoItemRepository.delete(item);
        return ResponseEntity.ok(RemovePedidoDto.make(pedido));
    }

    @PostMapping("/fechar")
    @Transactional
    public ResponseEntity<FecharPedidoDto> Fechar(@ApiIgnore Authentication auth) throws NotFoundException {
        Cliente cliente = (Cliente) auth.getPrincipal();
        Pedido pedido = this.pedidoRepository.getPedidoPorClienteEStatus(cliente, Status.ABERTO);
        if (pedido == null) {
            throw new NotFoundException("Pedido não encontrado");
        }
        pedido.setStatus(Status.FECHADO)
                .setDataFechamento(new Date());
        this.pedidoRepository.save(pedido);
        return ResponseEntity.ok(FecharPedidoDto.make(pedido));
    }
}
