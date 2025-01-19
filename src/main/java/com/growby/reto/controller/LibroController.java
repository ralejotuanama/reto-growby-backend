package com.growby.reto.controller;

import com.growby.reto.model.Libro;
import com.growby.reto.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
@CrossOrigin(origins = "http://localhost:4200") // Permite solicitudes desde Angular
public class LibroController {

    @Autowired
    private LibroService libroService;

    // Crear o actualizar un libro
    @PostMapping
    public ResponseEntity<Libro> createOrUpdateLibro(@RequestBody Libro libro) {
        return ResponseEntity.ok(libroService.saveLibro(libro));
    }

    // Obtener todos los libros con paginación
    @GetMapping
    public ResponseEntity<Page<Libro>> getAllLibros(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(libroService.getAllLibros(page, size));
    }

    // Obtener un libro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Libro> getLibroById(@PathVariable Long id) {
        Optional<Libro> libro = libroService.getLibroById(id);
        return libro.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Verificar disponibilidad de un libro
    @GetMapping("/{id}/disponible")
    public ResponseEntity<Boolean> isLibroDisponible(@PathVariable Long id) {
        return ResponseEntity.ok(libroService.isLibroDisponible(id));
    }

    // Eliminar un libro por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable Long id) {
        libroService.deleteLibro(id);
        return ResponseEntity.noContent().build();
    }


    // Nuevo endpoint sin paginación
    @GetMapping("/todos")
    public ResponseEntity<List<Libro>> getAllLibrosSinPaginacion() {
        return ResponseEntity.ok(libroService.getAllLibrosSinPaginacion());
    }

}
