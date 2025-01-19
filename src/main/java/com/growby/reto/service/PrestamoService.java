package com.growby.reto.service;

import com.growby.reto.model.Libro;
import com.growby.reto.model.Prestamo;
import com.growby.reto.repository.LibroRepository;
import com.growby.reto.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoService {



    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private LibroRepository libroRepository;

    // Crear o actualizar un préstamo
    public Prestamo savePrestamo(Prestamo prestamo) {
        // Actualizar el estado del libro a "No disponible" si el préstamo está activo
        if ("Activo".equalsIgnoreCase(prestamo.getEstado())) {
            Optional<Libro> libro = libroRepository.findById(prestamo.getLibro().getId());
            libro.ifPresent(l -> {
                l.setEstado("No disponible");
                libroRepository.save(l);
            });
        }
        return prestamoRepository.save(prestamo);
    }

    // Obtener todos los préstamos
    public List<Prestamo> getAllPrestamos() {
        return prestamoRepository.findAll();
    }

    // Obtener préstamos por libro
   public List<Prestamo> getPrestamosByLibro(Long libroId) {
        return prestamoRepository.findAllByLibroId(libroId);
    }

    // Finalizar un préstamo
    public Prestamo finalizarPrestamo(Long prestamoId) {
        Optional<Prestamo> prestamoOptional = prestamoRepository.findById(prestamoId);
        if (prestamoOptional.isPresent()) {
            Prestamo prestamo = prestamoOptional.get();
            prestamo.setEstado("Finalizado");
            // Cambiar estado del libro a "Disponible"
            Optional<Libro> libro = libroRepository.findById(prestamo.getLibro().getId());
            libro.ifPresent(l -> {
                l.setEstado("Disponible");
                libroRepository.save(l);
            });
            return prestamoRepository.save(prestamo);
        }
        throw new RuntimeException("Préstamo no encontrado");
    }

    // Eliminar un préstamo por ID
    public void deletePrestamo(Long id) {
        prestamoRepository.deleteById(id);
    }
}
