package com.matt.EduCenter.dto;

import java.time.LocalDate;

public class InscripcionDTO {

    private String estudianteNombre;
    private String estudianteEmail;
    private String cursoNombre;
    private LocalDate fechaInscripcion;

    public InscripcionDTO(String estudianteNombre, String estudianteEmail,
                          String cursoNombre, LocalDate fechaInscripcion) {
        this.estudianteNombre = estudianteNombre;
        this.estudianteEmail = estudianteEmail;
        this.cursoNombre = cursoNombre;
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getEstudianteNombre() { return estudianteNombre; }
    public String getEstudianteEmail() { return estudianteEmail; }
    public String getCursoNombre() { return cursoNombre; }
    public LocalDate getFechaInscripcion() { return fechaInscripcion; }
}