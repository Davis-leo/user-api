package com.leo.user_api.controller;

import com.leo.user_api.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    // Verifica se e possivel criar um usuario pela API
    @Test
    void shouldCreateUser() throws Exception {

        User user = new User("Leo", "leo@email.com");

        // Simula uma requisicao HTTP POST pro endpoint /users
        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))

                // Verifica se a resposta HTTP retornou o STATUS 200 OK
                .andExpect(status().isOk());
    }


    // Verifica se a API consegue retornar usuarios
    @Test
    void shouldReturnUsers() throws Exception {

        // Verifica se a resposta da API foi bem sucedida
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk());
    }
}