package com.sistema.conferencia.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "articulo")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    
    @Column(name = "autores_str")
    private String autoresStr;

    @Column(name = "pdf_storage_path")
    private String pdfStoragePath;

    @Column(name = "fecha_envio")
    private LocalDateTime fechaEnvio;

    private Boolean activo;

    // Constructores, Getters y Setters
    public Articulo() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutoresStr() { return autoresStr; }
    public void setAutoresStr(String autoresStr) { this.autoresStr = autoresStr; }

    public String getPdfStoragePath() { return pdfStoragePath; }
    public void setPdfStoragePath(String pdfStoragePath) { this.pdfStoragePath = pdfStoragePath; }

    public LocalDateTime getFechaEnvio() { return fechaEnvio; }
    public void setFechaEnvio(LocalDateTime fechaEnvio) { this.fechaEnvio = fechaEnvio; }

    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
}
