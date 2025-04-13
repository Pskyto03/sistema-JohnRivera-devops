package com.example.matriculas.controller;

import com.example.matriculas.model.Matricula;
import com.example.matriculas.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;

    @Autowired
    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    // Crear una nueva matrícula
    @PostMapping("/matricular")
    public ResponseEntity<Matricula> matricularEstudiante(@RequestParam String idEstudiante, @RequestParam String idAsignatura) {
        Matricula matricula = matriculaService.matricularEstudiante(idEstudiante, idAsignatura);
        return new ResponseEntity<>(matricula, HttpStatus.CREATED);
    }

    // Obtener todas las matrículas
    @GetMapping
    public ResponseEntity<List<Matricula>> obtenerMatriculas() {
        List<Matricula> matriculas = matriculaService.obtenerMatriculas();
        return new ResponseEntity<>(matriculas, HttpStatus.OK);
    }

    // Obtener una matrícula por ID
    @GetMapping("/{id}")
    public ResponseEntity<Matricula> obtenerMatriculaPorId(@PathVariable String id) {
        Optional<Matricula> matricula = matriculaService.obtenerMatriculaPorId(id);
        return matricula.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Actualizar una matrícula
    @PutMapping("/{id}")
    public ResponseEntity<Matricula> actualizarMatricula(@PathVariable String id, @RequestParam String idEstudiante, @RequestParam String idAsignatura) {
        Matricula matricula = matriculaService.actualizarMatricula(id, idEstudiante, idAsignatura);
        if (matricula != null) {
            return new ResponseEntity<>(matricula, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una matrícula
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMatricula(@PathVariable String id) {
        boolean eliminado = matriculaService.eliminarMatricula(id);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
