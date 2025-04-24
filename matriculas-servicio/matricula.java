package com.example.matriculas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "matriculas")
public class Matricula {

    @Id
    private String id;
    private String idEstudiante;
    private String idAsignatura;

    public Matricula(String idEstudiante, String idAsignatura) {
        this.idEstudiante = idEstudiante;
        this.idAsignatura = idAsignatura;
    }

    // Getters y Setters
    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(String idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

}
