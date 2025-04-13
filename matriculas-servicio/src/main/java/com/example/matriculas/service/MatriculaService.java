package com.example.matriculas.service;

import com.example.matriculas.model.Matricula;
import com.example.matriculas.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;

    @Autowired
    public MatriculaService(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    // Crear una nueva matrícula
    public Matricula matricularEstudiante(String idEstudiante, String idAsignatura) {
        Matricula matricula = new Matricula(idEstudiante, idAsignatura);
        return matriculaRepository.save(matricula);
    }

    // Obtener todas las matrículas
    public List<Matricula> obtenerMatriculas() {
        return matriculaRepository.findAll();
    }

    // Obtener una matrícula por su ID
    public Optional<Matricula> obtenerMatriculaPorId(String id) {
        return matriculaRepository.findById(id);
    }

    // Actualizar una matrícula existente
    public Matricula actualizarMatricula(String id, String idEstudiante, String idAsignatura) {
        if (matriculaRepository.existsById(id)) {
            Matricula matricula = new Matricula(idEstudiante, idAsignatura);
            matricula.setId(id);  // Aseguramos que el ID no se pierda
            return matriculaRepository.save(matricula);
        }
        return null; // O lanzar una excepción si la matrícula no existe
    }

    // Eliminar una matrícula
    public boolean eliminarMatricula(String id) {
        if (matriculaRepository.existsById(id)) {
            matriculaRepository.deleteById(id);
            return true;
        }
        return false;  // Retorna false si la matrícula no existe
    }
}
