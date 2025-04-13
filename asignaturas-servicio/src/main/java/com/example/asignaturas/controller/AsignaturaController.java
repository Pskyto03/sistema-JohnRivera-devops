package com.example.asignaturas.controller;

import com.example.asignaturas.model.Asignatura;
import com.example.asignaturas.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {

    private final AsignaturaRepository asignaturaRepository;

    @Autowired
    public AsignaturaController(AsignaturaRepository asignaturaRepository) {
        this.asignaturaRepository = asignaturaRepository;
    }

    @PostMapping
    public ResponseEntity<Asignatura> createAsignatura(@RequestBody Asignatura asignatura) {
        Asignatura savedAsignatura = asignaturaRepository.save(asignatura);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAsignatura);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asignatura> getAsignatura(@PathVariable String id) {
        return asignaturaRepository.findById(id)
                .map(asignatura -> ResponseEntity.ok(asignatura))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Asignatura> getAllAsignaturas() {
        return asignaturaRepository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asignatura> updateAsignatura(@PathVariable String id, @RequestBody Asignatura asignaturaDetails) {
        return asignaturaRepository.findById(id)
                .map(asignatura -> {
                    asignatura.setNombre(asignaturaDetails.getNombre());
                    asignatura.setDescripcion(asignaturaDetails.getDescripcion());
                    asignaturaRepository.save(asignatura);
                    return ResponseEntity.ok(asignatura);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAsignatura(@PathVariable String id) {
        return asignaturaRepository.findById(id)
                .map(asignatura -> {
                    asignaturaRepository.delete(asignatura);
                    return ResponseEntity.noContent().build(); // ResponseEntity<Void>
                })
                .orElseGet(() -> ResponseEntity.notFound().build()); // ResponseEntity<Void>
    }

}
