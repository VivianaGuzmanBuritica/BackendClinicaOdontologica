package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.persistance.repository.ITurnoRepository;
import com.example.clinicaOdontologica.service.orm.TurnoServiceOrm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerTurnoTest {

    @InjectMocks
    TurnoServiceOrm sujetoDePrueba;

    @Mock
    ITurnoRepository repository;

    @Mock
    private ObjectMapper mapper;
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void retorunaStatus200() throws Exception{
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/turnos/todos"))
                .andDo(print())
                .andExpect(status().isOk()).andReturn();

        Assertions.assertEquals(result.getResponse().getStatus(), 200);
    }
}