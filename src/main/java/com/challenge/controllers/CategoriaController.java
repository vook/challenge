package com.challenge.controllers;

import com.challenge.forms.CreateCategoriaForm;
import com.challenge.forms.EditCategoriaForm;
import com.challenge.models.Categoria;
import com.challenge.repositories.CategoriaRepository;
import com.challenge.resources.security.responses.CategoriaDto;
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
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public Page<CategoriaDto> index(@PageableDefault Pageable pageable)
    {
        return this.categoriaRepository.findAll(pageable).map((Categoria categoria) -> CategoriaDto.make(categoria));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> get(@PathVariable Integer id)
    {
        Categoria categoria =this.categoriaRepository.getOne(id);
        return ResponseEntity.ok(CategoriaDto.make(categoria));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CategoriaDto> store(
            @RequestBody
            @Valid
            CreateCategoriaForm form,
            UriComponentsBuilder uriBuilder
    ) {
        Categoria categoria = this.categoriaRepository.save(form.create());
        URI uri = uriBuilder.path("/categoria/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).body(CategoriaDto.make(categoria));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CategoriaDto> update(
            @RequestBody
            @Valid
            EditCategoriaForm form,
            @PathVariable
            Integer id
    ) {
        Categoria categoria = this.categoriaRepository.getOne(id);
        form.edit(categoria);
        this.categoriaRepository.save(categoria);
        return ResponseEntity.ok(CategoriaDto.make(categoria));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity.HeadersBuilder destroy(@PathVariable Integer id)
    {
        Categoria categoria = this.categoriaRepository.getOne(id);
        this.categoriaRepository.delete(categoria);
        return ResponseEntity.noContent();
    }
}
