package com.example.usuarios.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
public class Usuario {

    @Id
    private String id;
    private String nombre;
    private String username;  // Nuevo campo para el login
    private String password; // Nuevo campo para almacenar la contraseña encriptada
    private String rol;  // "Estudiante" o "Docente"

    // Constructores
    public Usuario() {
        // Constructor vacío necesario para Spring Data
    }

    public Usuario(String nombre, String username, String password, String rol) {
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}