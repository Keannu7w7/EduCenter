package com.matt.EduCenter.Controller;

import com.matt.EduCenter.Modelo.Curso;
import com.matt.EduCenter.Service.CursoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Curso crearCurso(@RequestBody Curso curso) {
        return cursoService.crearCurso(curso);
    }


    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','PROFESOR','ESTUDIANTE')")
    public List<Curso> listarCursos() {
        return cursoService.listarCursos();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','PROFESOR','ESTUDIANTE')")
    public Curso obtenerCurso(@PathVariable Long id) {
        return cursoService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Curso actualizarCurso(@PathVariable Long id, @RequestBody Curso curso) {
        return cursoService.actualizarCurso(id, curso);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminarCurso(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
    }
}