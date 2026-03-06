package com.matt.EduCenter.repository;

import com.matt.EduCenter.Modelo.Inscripcion;
import com.matt.EduCenter.Modelo.User;
import com.matt.EduCenter.Modelo.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    Optional<Inscripcion> findByEstudianteAndCurso(User estudiante, Curso curso);
    List<Inscripcion> findByEstudiante(User estudiante);

    List<Inscripcion> findByCurso(Curso curso);

}