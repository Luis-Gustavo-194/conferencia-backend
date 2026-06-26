package com.sistema.conferencia.repository;

import com.sistema.conferencia.domain.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Integer> {
    // Spring Boot implementa automáticamente métodos como findAll(), findById(), save()
}