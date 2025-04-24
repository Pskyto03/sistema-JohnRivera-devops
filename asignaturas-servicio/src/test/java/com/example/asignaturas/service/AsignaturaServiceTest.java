package com.example.asignaturas.service;

import com.example.asignaturas.model.Asignatura;
import com.example.asignaturas.repository.AsignaturaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AsignaturaServiceTest {

    @Mock
    private AsignaturaRepository asignaturaRepository;

    @InjectMocks
    private AsignaturaService asignaturaService;

    @Test
    public void crearAsignatura_DeberiaRetornarAsignaturaGuardada() {
        // Configurar mock
        Asignatura asignaturaMock = new Asignatura("Matemáticas", "Álgebra lineal");
        asignaturaMock.setId("1");
        when(asignaturaRepository.save(any(Asignatura.class))).thenReturn(asignaturaMock);

        // Ejecutar
        Asignatura resultado = asignaturaService.crearAsignatura("Matemáticas", "Álgebra lineal");

        // Verificar
        assertEquals("1", resultado.getId());
        assertEquals("Matemáticas", resultado.getNombre());
        verify(asignaturaRepository, times(1)).save(any(Asignatura.class));
    }

    @Test
    public void crearAsignatura_ConNombreNulo_DeberiaLanzarExcepcion() {
        when(asignaturaRepository.save(any())).thenThrow(new IllegalArgumentException("Nombre es requerido"));

        assertThrows(IllegalArgumentException.class, () -> {
            asignaturaService.crearAsignatura(null, "Descripción");
        });
    }
}   