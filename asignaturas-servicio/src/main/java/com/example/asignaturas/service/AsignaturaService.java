package com.example.asignaturas.service;

import com.example.asignaturas.model.Asignatura;
import com.example.asignaturas.repository.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaService {

    private final AsignaturaRepository asignaturaRepository;

    @Autowired
    public AsignaturaService(AsignaturaRepository asignaturaRepository) {
        this.asignaturaRepository = asignaturaRepository;
    }

    // Crear una nueva asignatura
    public Asignatura crearAsignatura(String nombre, String descripcion) {
        // Crear un nuevo objeto Asignatura con el nombre y la descripción proporcionados
        Asignatura asignatura = new Asignatura(nombre, descripcion);

        // Guardar la asignatura en la base de datos utilizando el repositorio
        return asignaturaRepository.save(asignatura);
    }
}
