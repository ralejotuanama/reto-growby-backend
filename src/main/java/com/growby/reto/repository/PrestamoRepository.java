package com.growby.reto.repository;

import com.growby.reto.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

    // Método para listar todos los préstamos de un libro específico
    List<Prestamo> findAllByLibroId(Long libroId);

}
