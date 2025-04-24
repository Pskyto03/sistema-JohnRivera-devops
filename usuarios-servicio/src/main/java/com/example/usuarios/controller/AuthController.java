package com.example.usuarios.controller;

import com.example.usuarios.model.Usuario;
import com.example.usuarios.repository.UsuarioRepository;
import com.example.usuarios.security.JwtUtils;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.usuarios.dto.LoginRequest;
import com.example.usuarios.dto.RegisterRequest;

@RestController
@RequestMapping("/usuarios/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
    try {
        // 1. Buscar usuario
        Usuario usuario = usuarioRepo.findByUsername(request.getUsername()).orElse(null);
        if (usuario == null) {
            System.out.println("DEBUG - Usuario no encontrado");
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }

        // 2. Comparación manual
        boolean passwordMatches = encoder.matches(request.getPassword(), usuario.getPassword());
        System.out.println("DEBUG - Comparación: " + passwordMatches);
        System.out.println("DEBUG - Hash en BD: " + usuario.getPassword());

        if (!passwordMatches) {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }

        // 3. Generar token
        String token = jwtUtils.generateToken(request.getUsername());
        
        // 4. Obtener lista de usuarios (excluyendo passwords)
        List<Usuario> usuarios = usuarioRepo.findAll().stream()
            .map(u -> {
                u.setPassword(null); // Elimina el hash de la respuesta
                return u;
            })
            .collect(Collectors.toList());

        // 5. Crear respuesta combinada
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("token", token);
        response.put("usuarios", usuarios);
        
        return ResponseEntity.ok(response);

    } catch (Exception e) {
        System.out.println("DEBUG - Error: " + e.getMessage());
        return ResponseEntity.status(401).body("Error en autenticación");
    }
}
    // @PostMapping("/login")
    // public ResponseEntity<?> login(@RequestBody LoginRequest request) {
    // try {
    // authManager.authenticate(
    // new UsernamePasswordAuthenticationToken(
    // request.getUsername(),
    // request.getPassword()));

    // String token = jwtUtils.generateToken(request.getUsername());
    // return ResponseEntity.ok(token);

    // } catch (Exception e) {
    // return ResponseEntity.status(401).body("Credenciales inválidas");
    // }
    // }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        // Generar el hash de la contraseña
        String encodedPassword = encoder.encode(request.getPassword());
        System.out.println("Password registrado (hash): " + encodedPassword);
        // Verificar si el username ya existe
        if (usuarioRepo.existsByUsername(request.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("El nombre de usuario ya está en uso");
        }

        // Crear nuevo usuario con todos los campos
        Usuario user = new Usuario(
                request.getNombre(),
                request.getUsername(),
                encoder.encode(request.getPassword()),
                request.getRol());

        usuarioRepo.save(user);

        // 4. Preparar respuesta detallada
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", "success");
        response.put("message", "Usuario registrado exitosamente");
        response.put("username", user.getUsername());
        response.put("passwordHash", encodedPassword); // 👈 Hash visible en Postman
        response.put("timestamp", LocalDateTime.now());

        // 5. Log en consola (opcional)
        System.out.println("Registro exitoso. Hash generado: " + encodedPassword);

        return ResponseEntity.ok(response);

        // return ResponseEntity.ok("Usuario registrado exitosamente");
    }
}