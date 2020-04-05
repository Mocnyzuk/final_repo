package com.example.springbootproject.controller;

import com.example.springbootproject.domain.Movie;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldReturnAllMovies() throws Exception {

       mockMvc.perform(get("/movies"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void shouldReturnMovieById() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/movies/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andReturn();
        Movie movie = OBJECT_MAPPER.readValue(mvcResult.getResponse().getContentAsString(), Movie.class);

        assertEquals(new Movie(1L, "Lord Of The Rings. The fellowship of the ring", 2001), movie);
    }

    @Test
    void shouldThrowResponseStatusException() throws Exception {
        mockMvc.perform(get("/movies/121"))
                .andExpect(status().isNotFound());
    }

}