package com.matt.EduCenter.Modelo;
import jakarta.persistence.*;
@Entity
public class Curso {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nombre;
  private String description;

  @ManyToOne
    @JoinColumn(name="profesor_id")
    private User profesor;

    public Curso() {}

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescription() {
        return description;
    }

    public User getProfesor() {
        return profesor;
    }

    public void setProfesor(User profesor) {
        this.profesor = profesor;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
