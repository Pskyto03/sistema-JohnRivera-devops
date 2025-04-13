package com.example.matriculas.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // Configuración de seguridad para la autenticación básica
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Configuración explícita de los endpoints y la autenticación
        http
                .csrf(csrf -> csrf.ignoringRequestMatchers("/matriculas/**"))  // Ignorar CSRF en /matriculas
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/matriculas/**").authenticated()  // Requiere autenticación para /matriculas
                                .anyRequest().permitAll()  // Permite acceso sin autenticación a otros endpoints
                )
                .httpBasic(Customizer.withDefaults());  // Habilita la autenticación básica con configuración predeterminada

        return http.build();
    }

    // Crear usuarios en memoria para la autenticación básica
    @Bean
    public UserDetailsService userDetailsService() {
        var user = User.withUsername("admin")
                .password(passwordEncoder().encode("admin"))  // Codificación de la contraseña con BCrypt
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);  // Almacena el usuario en memoria
    }

    // Codificador de contraseñas con BCrypt
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Usamos un codificador fuerte para las contraseñas
    }
}
