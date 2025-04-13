package com.example.asignaturas.repository;

import com.example.asignaturas.model.Asignatura;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepository extends MongoRepository<Asignatura, String> {
}
