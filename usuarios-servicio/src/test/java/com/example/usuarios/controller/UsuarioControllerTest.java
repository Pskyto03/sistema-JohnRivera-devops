/*
package com.example.usuarios.controller;

import com.example.usuarios.model.Usuario;
import com.example.usuarios.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(UsuarioController.class)
class UsuarioControllerTest {

    @InjectMocks
    private UsuarioController usuarioController;

    @Mock
    private UsuarioService usuarioService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();
    }

    @Test
    void testCrearUsuario() throws Exception {
        // Crear un objeto Usuario con nombre y rol
        Usuario usuario = new Usuario("juan", "Estudiante");

        // Simulamos que el servicio crea un usuario y lo devuelve
        when(usuarioService.crearUsuario(usuario)).thenReturn(usuario);

        // Realizamos una solicitud POST para crear un nuevo usuario
        mockMvc.perform(post("/usuarios/crear")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nombre\":\"juan\", \"rol\":\"Estudiante\"}"))
                .andExpect(status().isCreated())  // Verifica que el estado sea 201 Created
                .andExpect(jsonPath("$.nombre").value("juan"))  // Verifica el nombre del usuario
                .andExpect(jsonPath("$.rol").value("Estudiante"));  // Verifica el rol del usuario
    }
}
*/
