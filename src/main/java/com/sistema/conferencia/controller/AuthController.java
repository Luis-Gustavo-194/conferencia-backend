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

    // ESTO SE VERÁ EN LOS LOGS DE RENDER
    System.out.println("DEBUG: Recibiendo email: " + email + " y password: " + password);

    String rol = usuarioRepository.obtenerRolPorCredenciales(email, password);

    if (rol != null) {
        return ResponseEntity.ok(Map.of("rol", rol));
    } else {
        // ESTO TAMBIÉN SE VERÁ EN LOS LOGS
        System.out.println("DEBUG: Consulta SQL devolvió null para: " + email);
        return ResponseEntity.status(401).body(Map.of("error", "Credenciales inválidas"));
    }
}
}