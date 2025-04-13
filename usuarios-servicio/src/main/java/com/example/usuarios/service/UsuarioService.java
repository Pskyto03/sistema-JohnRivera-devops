package com.example.usuarios.service;

import com.example.usuarios.model.Usuario;
import com.example.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Crear un nuevo usuario
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Obtener todos los usuarios
    public List<Usuario> obtenerUsuarios() {
        return usuarioRepository.findAll();
    }

    // Obtener un usuario por ID
    public Optional<Usuario> obtenerUsuarioPorId(String id) {
        return usuarioRepository.findById(id);
    }

    // Actualizar un usuario
    public Usuario actualizarUsuario(String id, Usuario usuarioActualizado) {
        if (usuarioRepository.existsById(id)) {
            usuarioActualizado.setId(id);  // Aseguramos que el ID no se pierda
            return usuarioRepository.save(usuarioActualizado);
        } else {
            return null; // O lanzar una excepción si el usuario no existe
        }
    }

    // Eliminar un usuario
    public boolean eliminarUsuario(String id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;  // Retorna false si el usuario no existe
    }
}
