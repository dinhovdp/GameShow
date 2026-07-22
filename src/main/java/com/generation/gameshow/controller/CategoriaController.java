package com.generation.gameshow.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.generation.gameshow.model.Categoria;
import com.generation.gameshow.repository.CategoriaRepository;



@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    @GetMapping
    public ResponseEntity<List<Categoria>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable Long id) {

        return repository.findById(id)
                .map(resposta -> ResponseEntity.ok(resposta))
                .orElse(ResponseEntity.notFound().build());

    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Categoria>> getByTipo(@PathVariable String tipo) {

        return ResponseEntity.ok(repository.findAllByTipoContainingIgnoreCase(tipo));

    }

    @PostMapping
    public ResponseEntity<Categoria> post(@RequestBody Categoria categoria) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(repository.save(categoria));

    }

    @PutMapping
    public ResponseEntity<Categoria> put(@RequestBody Categoria categoria) {

        return ResponseEntity.ok(repository.save(categoria));

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        repository.deleteById(id);

    }

}