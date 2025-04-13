/*
package com.example.matriculas.controller;

import com.example.matriculas.model.Matricula;
import com.example.matriculas.service.MatriculaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(MatriculaController.class)
class MatriculaControllerTest {

    @InjectMocks
    private MatriculaController matriculaController;

    @Mock
    private MatriculaService matriculaService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(matriculaController).build();
    }

    @Test
    void testMatricularEstudiante() throws Exception {
        // Crear un objeto Matricula con idEstudiante y idAsignatura
        Matricula matricula = new Matricula("estudiante1", "asignatura1");

        // Simulamos que el servicio crea una matrícula y la devuelve
        when(matriculaService.matricularEstudiante("estudiante1", "asignatura1")).thenReturn(matricula);

        // Realizamos una solicitud POST para crear la matrícula
        mockMvc.perform(post("/matriculas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"idEstudiante\":\"estudiante1\", \"idAsignatura\":\"asignatura1\"}"))
                .andExpect(status().isCreated())  // Verifica que el estado sea 201 Created
                .andExpect(jsonPath("$.idEstudiante").value("estudiante1"))  // Verifica el idEstudiante
                .andExpect(jsonPath("$.idAsignatura").value("asignatura1"));  // Verifica el idAsignatura
    }

    @Test
    void testObtenerMatriculas() throws Exception {
        // Simulamos una lista de matrículas
        Matricula matricula1 = new Matricula("estudiante1", "asignatura1");
        Matricula matricula2 = new Matricula("estudiante2", "asignatura2");
        when(matriculaService.obtenerMatriculas()).thenReturn(List.of(matricula1, matricula2));

        // Realizamos una solicitud GET para obtener las matrículas
        mockMvc.perform(get("/matriculas"))
                .andExpect(status().isOk())  // Verifica que el estado sea 200 OK
                .andExpect(jsonPath("$[0].idEstudiante").value("estudiante1"))  // Verifica el primer idEstudiante
                .andExpect(jsonPath("$[1].idEstudiante").value("estudiante2"));  // Verifica el segundo idEstudiante
    }
}
*/
