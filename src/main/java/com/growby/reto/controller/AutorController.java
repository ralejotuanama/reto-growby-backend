package com.growby.reto.controller;

import com.growby.reto.model.Autor;
import com.growby.reto.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/autores")
@CrossOrigin(origins = "http://localhost:4200") // Permitir solicitudes desde Angular
public class AutorController {

    @Autowired
    private AutorService autorService;

    // Crear o actualizar un autor
    @PostMapping
    public ResponseEntity<Autor> createOrUpdateAutor(@RequestBody Autor autor) {
        return ResponseEntity.ok(autorService.saveAutor(autor));
    }

    // Obtener todos los autores
    @GetMapping
    public ResponseEntity<List<Autor>> getAllAutores() {
        return ResponseEntity.ok(autorService.getAllAutores());
    }

    // Obtener un autor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Autor> getAutorById(@PathVariable Long id) {
        Optional<Autor> autor = autorService.getAutorById(id);
        return autor.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un autor por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable Long id) {
        autorService.deleteAutor(id);
        return ResponseEntity.noContent().build();
    }
}
