package com.example.asignaturas.controller;

import com.example.asignaturas.model.Asignatura;
import com.example.asignaturas.repository.AsignaturaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AsignaturaControllerTest {

    @Mock
    private AsignaturaRepository asignaturaRepository;

    @InjectMocks
    private AsignaturaController asignaturaController;

    @Test
    public void getAsignaturaById_Existente_DeberiaRetornar200() {
        // Configurar mock
        Asignatura asignaturaMock = new Asignatura("Física", "Termodinámica");
        asignaturaMock.setId("1");
        when(asignaturaRepository.findById("1")).thenReturn(Optional.of(asignaturaMock));

        // Ejecutar
        ResponseEntity<Asignatura> response = asignaturaController.getAsignatura("1");

        // Verificar
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Física", response.getBody().getNombre());
    }

    @Test
    public void getAsignaturaById_NoExistente_DeberiaRetornar404() {
        when(asignaturaRepository.findById("99")).thenReturn(Optional.empty());

        ResponseEntity<Asignatura> response = asignaturaController.getAsignatura("99");

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}