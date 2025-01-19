package com.growby.reto.service;

import com.growby.reto.model.Autor;
import com.growby.reto.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    // Crear o actualizar un autor
    public Autor saveAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    // Obtener todos los autores
    public List<Autor> getAllAutores() {
        return autorRepository.findAll();
    }

    // Obtener un autor por ID
    public Optional<Autor> getAutorById(Long id) {
        return autorRepository.findById(id);
    }

    // Eliminar un autor por ID
    public void deleteAutor(Long id) {
        autorRepository.deleteById(id);
    }


}
