package com.sistema.conferencia.repository;

import com.sistema.conferencia.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    // Consulta SQL nativa para obtener el rol del usuario si las credenciales coinciden
    @Query(value = "SELECT r.nombre FROM usuario u " +
               "JOIN usuario_rol ur ON u.id = ur.usuario_id " +
               "JOIN rol r ON ur.rol_id = r.id " +
               "WHERE u.email = :email LIMIT 1", 
       nativeQuery = true)
    String obtenerRolPorCredenciales(@Param("email") String email);
}