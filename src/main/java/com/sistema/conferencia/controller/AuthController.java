package com.sistema.conferencia.controller;

import com.sistema.conferencia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
public ResponseEntity<?> login(@RequestBody Map<String, String> credenciales) {
    String email = credenciales.get("email");
    
    // Imprimimos el email que llega para verificar si tiene espacios ocultos
    System.out.println("DEBUG: Buscando usuario con email: '" + email + "'");

    // Buscamos solo por email (como configuramos en el repositorio)
    String rol = usuarioRepository.obtenerRolPorCredenciales(email);

    if (rol != null) {
        System.out.println("DEBUG: Usuario encontrado, rol: " + rol);
        return ResponseEntity.ok(Map.of("rol", rol));
    } else {
        System.out.println("DEBUG: NINGUN usuario encontrado con el email: '" + email + "'");
        return ResponseEntity.status(401).body(Map.of("error", "Email no encontrado"));
    }
}
}
