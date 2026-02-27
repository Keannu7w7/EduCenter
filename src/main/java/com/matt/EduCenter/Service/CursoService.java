package com.matt.EduCenter.Service;

import com.matt.EduCenter.Modelo.Curso;
import com.matt.EduCenter.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Curso crearCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    public Curso obtenerPorId(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
    }

    public Curso actualizarCurso(Long id, Curso cursoActualizado) {
        Curso curso = obtenerPorId(id);

        curso.setNombre(cursoActualizado.getNombre());
        curso.setDescription(cursoActualizado.getDescription());

        return cursoRepository.save(curso);
    }

    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}