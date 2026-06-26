package com.sistema.conferencia.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "revision")
public class Revision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "asignacion_id")
    private Integer asignacionId;

    private Integer puntuacion;
    private String comentarios;

    @Column(name = "fecha_envio")
    private LocalDateTime fechaEnvio;

    // Constructores, Getters y Setters
    public Revision() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getAsignacionId() { return asignacionId; }
    public void setAsignacionId(Integer asignacionId) { this.asignacionId = asignacionId; }

    public Integer getPuntuacion() { return puntuacion; }
    public void setPuntuacion(Integer puntuacion) { this.puntuacion = puntuacion; }

    public String getComentarios() { return comentarios; }
    public void setComentarios(String comentarios) { this.comentarios = comentarios; }

    public LocalDateTime getFechaEnvio() { return fechaEnvio; }
    public void setFechaEnvio(LocalDateTime fechaEnvio) { this.fechaEnvio = fechaEnvio; }
}
