package com.example.demo.controller;

import com.example.demo.domain.Hobbit;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HobbitControllerTest {

    @Autowired
    MockMvc mockMvc;

    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Test
    void getHobbit() throws Exception {
        //Given
        //When
        MvcResult response = mockMvc.perform(
                get("/hobbit")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        Hobbit hobbit = OBJECT_MAPPER.readValue(response.getResponse().getContentAsString(), Hobbit.class);

        assertEquals(new Hobbit("Frodo", "Baggins"), hobbit);
    }
}