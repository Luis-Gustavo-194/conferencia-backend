package com.sistema.conferencia.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    @Column(name = "password_hash")
    private String password;

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}