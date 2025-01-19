package com.growby.reto.service;

import com.growby.reto.model.Libro;
import com.growby.reto.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    // Crear o actualizar un libro
    public Libro saveLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    // Obtener todos los libros con paginación
    public Page<Libro> getAllLibros(int page, int size) {
        return libroRepository.findAll(PageRequest.of(page, size));
    }

    public List<Libro> getAllLibrosSinPaginacion() {
        return libroRepository.findAll(); // Devuelve todos los registros como lista
    }

    // Obtener un libro por ID
    public Optional<Libro> getLibroById(Long id) {
        return libroRepository.findById(id);
    }

    // Verificar disponibilidad de un libro
    public boolean isLibroDisponible(Long id) {
        Optional<Libro> libro = libroRepository.findById(id);
        return libro.isPresent() && "Disponible".equalsIgnoreCase(libro.get().getEstado());
    }

    // Eliminar un libro por ID
    public void deleteLibro(Long id) {
        libroRepository.deleteById(id);
    }


}
