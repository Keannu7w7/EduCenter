package com.matt.EduCenter.Controller;

import com.matt.EduCenter.Modelo.*;
import com.matt.EduCenter.Service.InscripcionService;
import com.matt.EduCenter.dto.InscripcionDTO;
import com.matt.EduCenter.repository.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {

    private final InscripcionService inscripcionService;
    private final UserRepository userRepository;

    public InscripcionController(InscripcionService inscripcionService,
                                 UserRepository userRepository) {
        this.inscripcionService = inscripcionService;
        this.userRepository = userRepository;
    }

    @PostMapping("/{cursoId}")
    @PreAuthorize("hasRole('ESTUDIANTE')")
    public Inscripcion inscribirse(@AuthenticationPrincipal User estudiante, @PathVariable Long cursoId) {
        return inscripcionService.inscribirse(estudiante, cursoId);
    }

    @GetMapping("/mis-cursos")
    @PreAuthorize("hasRole('ESTUDIANTE')")
    public List<InscripcionDTO> misCursos(Authentication authentication){

        String email = authentication.getName();

        User estudiante = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return inscripcionService.obtenerCursosDeEstudiante(estudiante);
    }

    @GetMapping("/curso/{cursoId}")
    @PreAuthorize("hasRole('PROFESOR') or hasRole('ADMIN')")
    public List<InscripcionDTO> verInscripcionesCurso(@PathVariable Long cursoId){
        return inscripcionService.obtenerInscripcionesPorCurso(cursoId);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ESTUDIANTE')")
    public void cancelarInscripcion(@PathVariable Long id,
                                    @AuthenticationPrincipal User estudiante){

        inscripcionService.cancelarInscripcion(id, estudiante);
    }




}
