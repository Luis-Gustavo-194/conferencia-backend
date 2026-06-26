package com.sistema.conferencia.controller;

import com.sistema.conferencia.domain.Articulo;
import com.sistema.conferencia.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/articulos")
// Eliminamos @CrossOrigin aquí para evitar conflictos con WebConfig.java
public class ArticuloController {

    @Autowired
    private ArticuloRepository articuloRepository;

    // Endpoint para listar todos los artículos
    @GetMapping
    public List<Articulo> listarTodos() {
        return articuloRepository.findAll();
    }

    // Endpoint para registrar un nuevo artículo
    @PostMapping("/crear")
    public Articulo crearArticulo(@RequestBody Articulo articulo) {
        // Asignamos la fecha actual del sistema antes de guardar
        articulo.setFechaEnvio(LocalDateTime.now());
        articulo.setActivo(true);
        
        return articuloRepository.save(articulo);
    }
}
