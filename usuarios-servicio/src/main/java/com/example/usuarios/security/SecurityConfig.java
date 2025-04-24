package com.example.usuarios.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.usuarios.model.Usuario;
import com.example.usuarios.repository.UsuarioRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;

    public SecurityConfig(JwtAuthFilter jwtAuthFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/usuarios/auth/**").permitAll() // Permitir login y registro
                .requestMatchers("/usuarios/**").permitAll()
                .anyRequest().authenticated() // Todo lo demás requiere autenticación
            )
            .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
            .formLogin(form -> form.disable()) // Deshabilitar el form login por defecto
            .httpBasic(basic -> basic.disable()); // Deshabilitar autenticación básica

        return http.build();
    }

    @Bean
    CommandLineRunner initDatabase(UsuarioRepository usuarioRepo, PasswordEncoder encoder) {
        return args -> {
            if (!usuarioRepo.existsByUsername("admin")) {
                Usuario admin = new Usuario();
                admin.setNombre("Admin");
                admin.setUsername("admin");
                admin.setPassword(encoder.encode("admin123"));
                admin.setRol("ADMIN"); // ← Rol especial
                usuarioRepo.save(admin);
            }
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}