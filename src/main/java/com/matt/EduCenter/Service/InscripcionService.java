package com.matt.EduCenter.Service;

import com.matt.EduCenter.Modelo.*;
import com.matt.EduCenter.dto.InscripcionDTO;
import com.matt.EduCenter.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InscripcionService {

    public List<InscripcionDTO> obtenerInscripcionesPorCurso(Long cursoId){
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        return inscripcionRepository.findByCurso(curso)
                .stream()
                .map(inscripcion -> new InscripcionDTO(
                        inscripcion.getEstudiante().getNombre() + " " + inscripcion.getEstudiante().getApellido(),
                        inscripcion.getEstudiante().getEmail(),
                        inscripcion.getCurso().getNombre(),
                        inscripcion.getFechaInscripcion()
                ))
                .toList();
    }

    public void cancelarInscripcion(Long id, User estudiante){

        Inscripcion inscripcion = inscripcionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inscripción no encontrada"));

        if(!inscripcion.getEstudiante().getId().equals(estudiante.getId())){
            throw new RuntimeException("No puedes cancelar esta inscripción");
        }

        inscripcionRepository.delete(inscripcion);
    }

    private final InscripcionRepository inscripcionRepository;
    private final CursoRepository cursoRepository;

    public InscripcionService(InscripcionRepository inscripcionRepository,
                              CursoRepository cursoRepository) {
        this.inscripcionRepository = inscripcionRepository;
        this.cursoRepository = cursoRepository;
    }

    public Inscripcion inscribirse(User estudiante, Long cursoId) {

        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        if (inscripcionRepository.findByEstudianteAndCurso(estudiante, curso).isPresent()) {
            throw new RuntimeException("Ya estás inscrito en este curso");
        }

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setEstudiante(estudiante);
        inscripcion.setCurso(curso);
        inscripcion.setFechaInscripcion(LocalDate.now());

        return inscripcionRepository.save(inscripcion);
    }
    public List<InscripcionDTO> obtenerCursosDeEstudiante(User estudiante){

        return inscripcionRepository.findByEstudiante(estudiante)
                .stream()
                .map(inscripcion -> new InscripcionDTO(
                        inscripcion.getEstudiante().getNombre() + " " + inscripcion.getEstudiante().getApellido(),
                        inscripcion.getEstudiante().getEmail(),
                        inscripcion.getCurso().getNombre(),
                        inscripcion.getFechaInscripcion()
                ))
                .toList();
    }
}