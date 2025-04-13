package com.example.matriculas.client;

import com.example.asignaturas.model.Asignatura;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "asignaturas-servicio")
public interface AsignaturaClient {

    @GetMapping("/asignaturas/{id}")
    Asignatura getAsignatura(@PathVariable("id") String id);
}
