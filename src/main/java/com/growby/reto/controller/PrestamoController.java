package com.growby.reto.controller;

import com.growby.reto.model.Prestamo;
import com.growby.reto.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
@CrossOrigin(origins = "http://localhost:4200") // Permitir solicitudes desde Angular
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    // Crear o actualizar un préstamo
    @PostMapping
    public ResponseEntity<Prestamo> createOrUpdatePrestamo(@RequestBody Prestamo prestamo) {
        return ResponseEntity.ok(prestamoService.savePrestamo(prestamo));
    }

    // Obtener todos los préstamos
    @GetMapping
    public ResponseEntity<List<Prestamo>> getAllPrestamos() {
        return ResponseEntity.ok(prestamoService.getAllPrestamos());
    }

    // Obtener préstamos por ID de libro
    @GetMapping("/libro/{libroId}")
    public ResponseEntity<List<Prestamo>> getPrestamosByLibro(@PathVariable Long libroId) {
        return ResponseEntity.ok(prestamoService.getPrestamosByLibro(libroId));
    }

    // Finalizar un préstamo
    @PutMapping("/{id}/finalizar")
    public ResponseEntity<Prestamo> finalizarPrestamo(@PathVariable Long id) {
        return ResponseEntity.ok(prestamoService.finalizarPrestamo(id));
    }

    // Eliminar un préstamo por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestamo(@PathVariable Long id) {
        prestamoService.deletePrestamo(id);
        return ResponseEntity.noContent().build();
    }
}
