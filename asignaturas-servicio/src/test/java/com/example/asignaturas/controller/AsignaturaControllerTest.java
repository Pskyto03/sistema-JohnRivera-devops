/*
package com.example.asignaturas.controller;

import com.example.asignaturas.model.Asignatura;
import com.example.asignaturas.service.AsignaturaService;
import com.example.asignaturas.repository.AsignaturaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest  // Usamos @SpringBootTest para cargar el contexto completo
class AsignaturaControllerTest {

    @InjectMocks
    private AsignaturaController asignaturaController;  // El controlador que estamos probando

    @Mock
    private AsignaturaService asignaturaService;  // El servicio simulado

    @Mock
    private AsignaturaRepository asignaturaRepository;  // El repositorio simulado

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(asignaturaController).build();  // Configuramos MockMvc
    }

    @Test
    void testCrearAsignatura() throws Exception {
        // Crear un objeto Asignatura para simular la respuesta del servicio
        Asignatura asignatura = new Asignatura("Matemáticas", "Curso de Matemáticas");

        // Simulamos que el servicio devuelve la asignatura creada
        when(asignaturaService.crearAsignatura("Matemáticas", "Curso de Matemáticas")).thenReturn(asignatura);

        // Realizamos la solicitud POST usando MockMvcRequestBuilders
        ResultActions resultActions = mockMvc.perform(post("/asignaturas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombre\":\"Matemáticas\", \"descripcion\":\"Curso de Matemáticas\"}"))
                .andExpect(status().isCreated())  // Verificamos que la respuesta sea 201 Created
                .andExpect(jsonPath("$.nombre").exists())
                .andExpect(jsonPath("$.nombre").value("Matemáticas"))  // Verificamos el nombre de la asignatura
                .andExpect(jsonPath("$.descripcion").value("Curso de Matemáticas"));  // Verificamos la descripción

        // Se imprime la respuesta de la solicitud para depuración (si es necesario)
        String responseContent = resultActions.andReturn().getResponse().getContentAsString();
        System.out.println("Response Body: " + responseContent);

        // Otras verificaciones o acciones adicionales pueden agregarse aquí
    }

}
*/
