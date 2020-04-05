package com.example.demo.controller;

import com.example.demo.domain.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = BEFORE_EACH_TEST_METHOD)
class PersonControllerTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldReturnStatus200_AfterAddingPerson() throws Exception {
        mockMvc.perform(
                post("/addPerson")
                        .content(OBJECT_MAPPER
                                .writeValueAsString(new Person(5L, "mariaPtak@gmail.com", "Maria", "Ptak", false, 24))
                        ).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Maria")))
                .andExpect(jsonPath("$.lastName", is("Ptak")))
                .andExpect(jsonPath("$.isLearningJava", is(false)))
                .andExpect(jsonPath("$.email", is("mariaPtak@gmail.com")))
                .andExpect(jsonPath("$.age", is(24)));
    }

    @Test
    void shouldReturnErrorMessageWhenAddingPersonWithWrongEmail() throws Exception {
        MvcResult response = mockMvc.perform(
                post("/addPerson")
                        .content(OBJECT_MAPPER
                                .writeValueAsString(new Person(6L, "mariaPtak.gmail.com", "Maria", "Ptak", false, 24))
                        ).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals("Bad e-mail provided", response.getResponse().getContentAsString());
    }

    @Test
    void shouldReturnStatus200_AfterGettingPerson() throws Exception {
        mockMvc.perform(
                get("/person/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Ania")))
                .andExpect(jsonPath("$.lastName", is("Nowak")))
                .andExpect(jsonPath("$.isLearningJava", is(true)))
                .andExpect(jsonPath("$.email", is("ania@gmail.com")))
                .andExpect(jsonPath("$.age", is(25)));
    }

    @Test
    void shouldReturnStatus200_AfterGettingAllPeople() throws Exception {
        mockMvc.perform(
                get("/person")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)));
    }

    @Test
    void shouldReturnStatus200_AfterReplacingPerson() throws Exception {
        mockMvc.perform(
                put("/person/2")
                        .content(OBJECT_MAPPER
                                .writeValueAsString(new Person(2L, "mariaPtak@gmail.com", "Maria", "Ptak", false, 36))
                        ).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Maria")))
                .andExpect(jsonPath("$.lastName", is("Ptak")))
                .andExpect(jsonPath("$.isLearningJava", is(false)))
                .andExpect(jsonPath("$.email", is("mariaPtak@gmail.com")))
                .andExpect(jsonPath("$.age", is(36)));
    }

    @Test
    void shouldReturnStatus200_AfterReplacingNoExistingPerson() throws Exception {
        mockMvc.perform(
                put("/person/10")
                        .content(OBJECT_MAPPER
                                .writeValueAsString(new Person(10L, "mariaPtak@gmail.com", "Maria", "Ptak", false, 36))
                        ).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Maria")))
                .andExpect(jsonPath("$.lastName", is("Ptak")))
                .andExpect(jsonPath("$.isLearningJava", is(false)))
                .andExpect(jsonPath("$.email", is("mariaPtak@gmail.com")))
                .andExpect(jsonPath("$.age", is(36)));
    }

    @Test
    void shouldReturnStatus200_AfterDeletingPerson() throws Exception {
        mockMvc.perform(
                delete("/person/1")
                        .content(OBJECT_MAPPER
                                .writeValueAsString(new Person(1L, "mariaPtak@gmail.com", "Maria", "Ptak", false, 36))
                        ).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}