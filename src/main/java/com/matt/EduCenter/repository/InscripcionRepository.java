package com.matt.EduCenter.repository;


import com.matt.EduCenter.Modelo.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
}