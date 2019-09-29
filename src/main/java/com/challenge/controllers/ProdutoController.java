package com.challenge.controllers;

import com.challenge.forms.CreateProdutoForm;
import com.challenge.forms.EditProdutoForm;
import com.challenge.models.Categoria;
import com.challenge.models.Produto;
import com.challenge.repositories.CategoriaRepository;
import com.challenge.repositories.ProdutoRepository;
import com.challenge.resources.security.responses.ProdutoDto;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public Page<ProdutoDto> index(@PageableDefault Pageable pageable)
    {
        return this.produtoRepository.findAll(pageable).map((Produto produto) -> ProdutoDto.make(produto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> get(@PathVariable Integer id)
    {
        Produto produto = produtoRepository.getOne(id);
        return ResponseEntity.ok(ProdutoDto.make(produto));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProdutoDto> store(@RequestBody @Valid CreateProdutoForm form, UriComponentsBuilder uriBuilder) throws NotFoundException {
        Produto produto = form.create();
        Categoria categoria = categoriaRepository.findById(form.getCategoria()).get();
        if (categoria == null) {
            throw new NotFoundException("");
        }
        produto.setCategoria(categoria);
        produtoRepository.save(produto);
        URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(ProdutoDto.make(produto));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProdutoDto> update(@RequestBody @Valid EditProdutoForm form, @PathVariable Integer id) throws NotFoundException {
        Produto produto = produtoRepository.findById(id).get();
        Categoria categoria = categoriaRepository.findById(form.getCategoria()).get();
        if (categoria == null || produto == null) {
            throw new NotFoundException("");
        }
        form.edit(produto);
        produtoRepository.save(produto);
        return ResponseEntity.ok(ProdutoDto.make(produto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity.HeadersBuilder destroy(@PathVariable Integer id)
    {
        Produto produto = produtoRepository.getOne(id);
        produtoRepository.delete(produto);
        return ResponseEntity.noContent();
    }
}
