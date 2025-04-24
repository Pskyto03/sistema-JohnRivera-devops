package com.example.asignaturas.controller;

import com.example.asignaturas.model.Asignatura;
import com.example.asignaturas.repository.AsignaturaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AsignaturaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private AsignaturaRepository asignaturaRepository;

    @BeforeEach
    void setUp() {
        Asignatura asignatura = new Asignatura("Matemáticas", "Álgebra");
        asignatura.setId("1");
        when(asignaturaRepository.save(asignatura)).thenReturn(asignatura);
        when(asignaturaRepository.findAll()).thenReturn(List.of(asignatura));
    }

    @Test
    public void crearAsignatura() throws Exception {
        Asignatura nuevaAsignatura = new Asignatura("Física", "Mecánica");

        mockMvc.perform(post("/asignaturas")
                .with(httpBasic("admin", "admin")) // Agregar esta línea
                .contentType("application/json")
                .content("{\"nombre\":\"Física\",\"descripcion\":\"Mecánica\"}"))
                .andExpect(status().isCreated());
    }

    // @Test
    // public void listarAsignaturas_DeberiaRetornarLista() throws Exception {
    //     mockMvc.perform(get("/asignaturas")
    //             .with(httpBasic("admin", "admin"))) // Agregar esta línea
    //             .andExpect(status().isOk())
    //             .andExpect(jsonPath("$[0].nombre").value("Matemáticas"));
    // }
}