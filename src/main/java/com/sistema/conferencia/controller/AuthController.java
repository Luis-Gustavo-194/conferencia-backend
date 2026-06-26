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
        String password = credenciales.get("password");

        String rol = usuarioRepository.obtenerRolPorCredenciales(email, password);

        if (rol != null) {
            // Si las credenciales son correctas, devolvemos el rol en formato JSON
            return ResponseEntity.ok(Map.of("rol", rol));
        } else {
            // Si fallan, devolvemos un error 401 (No autorizado)
            return ResponseEntity.status(401).body(Map.of("error", "Credenciales inválidas"));
        }
    }
}