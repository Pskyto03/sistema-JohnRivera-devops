package com.example.matriculas.client;

import com.example.matriculas.client.dto.AsignaturaDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "asignaturas-servicio")
public interface AsignaturaClient {
    @GetMapping("/asignaturas/{id}")
    AsignaturaDTO getAsignatura(@PathVariable Long id); // Usa AsignaturaDTO
}