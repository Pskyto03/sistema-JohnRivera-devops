package com.example.matriculas.repository;

import com.example.matriculas.model.Matricula;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MatriculaRepository extends MongoRepository<Matricula, String> {
}
