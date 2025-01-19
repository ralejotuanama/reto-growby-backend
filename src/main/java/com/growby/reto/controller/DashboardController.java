package com.growby.reto.controller;

import com.growby.reto.repository.AutorRepository;
import com.growby.reto.repository.LibroRepository;
import com.growby.reto.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "http://localhost:4200")
public class DashboardController {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private PrestamoRepository prestamoRepository;



    @GetMapping("/totales")
    public ResponseEntity<Map<String, Long>> getTotals() {
        Map<String, Long> totals = new HashMap<>();
        totals.put("totalLibros", libroRepository.count());
        totals.put("totalAutores", autorRepository.count());
        totals.put("totalPrestamos", prestamoRepository.count());
        return ResponseEntity.ok(totals);
    }

}
