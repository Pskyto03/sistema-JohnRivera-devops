package com.example.matriculas.client;

import com.example.matriculas.client.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuarios-servicio")
public interface UsuarioClient {
    @GetMapping("/usuarios/{id}")
    UsuarioDTO getUsuario(@PathVariable Long id); // Usa UsuarioDTO
}