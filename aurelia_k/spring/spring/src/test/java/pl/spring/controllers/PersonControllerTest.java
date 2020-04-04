package pl.spring.controllers;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {

    private static final int FIRST_ID = 1;
    @Autowired
    MockMvc mockMvc;


    @Test
    @DirtiesContext
    void getPersonById() throws Exception {
        mockMvc.perform(get("/api/person/" + FIRST_ID))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(FIRST_ID)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", is("Jan")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", is("Kowalski")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age", is(23)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.working", is(true)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.happy", is(true)));
    }

    @Test
    @DirtiesContext
    void cretePerson() throws Exception {
        String newPerson = "{\n" +
                "  \"name\":\"newName\",\n" +
                "  \"lastName\":\"newLastName\",\n" +
                "  \"age\":34,\n" +
                "  \"ishappy\":false,\n" +
                "  \"working\":true\n" +
                "}";
        //then
        mockMvc.perform(post("/api/person")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newPerson))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", is("newName")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", is("newLastName")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age", is(34)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.happy", is(false)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.working", is(true)));
    }

    @Test
    @DirtiesContext
    void personList() throws Exception {
        mockMvc.perform(get("/api/person"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id", is(FIRST_ID)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].age", is(23)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name", is("Jan")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].lastName", is("Kowalski")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].happy", is(true)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].working", is(true)));
    }

    @Test
    @DirtiesContext
    void updatePersonById() throws Exception {
        //given
        //language=JSON
        String newPerson = "{\n" +
                "  \"name\":\"newName\",\n" +
                "  \"lastName\":\"newLastName\",\n" +
                "  \"age\":34,\n" +
                "  \"isHappy\":false,\n" +
                "  \"working\":false\n" +
                "}";
        //then
        mockMvc.perform(post("/api/person/" + FIRST_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(newPerson))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(FIRST_ID)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", is("newName")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", is("newLastName")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age", is(34)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.happy", is(false)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.working", is(false)));
    }
}