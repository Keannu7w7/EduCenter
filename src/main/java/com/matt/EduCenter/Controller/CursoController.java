package com.matt.EduCenter.Controller;

import com.matt.EduCenter.Modelo.Curso;
import com.matt.EduCenter.Service.CursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public Curso crearCurso(@RequestBody Curso curso) {
        return cursoService.crearCurso(curso);
    }

    @GetMapping
    public List<Curso> listarCursos() {
        return cursoService.listarCursos();
    }

    @GetMapping("/{id}")
    public Curso obtenerCurso(@PathVariable Long id) {
        return cursoService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public Curso actualizarCurso(@PathVariable Long id, @RequestBody Curso curso) {
        return cursoService.actualizarCurso(id, curso);
    }

    @DeleteMapping("/{id}")
    public void eliminarCurso(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
    }
}