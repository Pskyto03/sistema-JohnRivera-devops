package com.example.usuarios.repository;

import com.example.usuarios.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    boolean existsByUsername(String username);
    Optional<Usuario> findByUsername(String username);
}