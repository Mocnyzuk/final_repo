package com.example.controller;

import com.example.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {

    private final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    MockMvc mockMvc;

    @Test
    void getPersonById() throws Exception {
        MvcResult response = mockMvc.perform(                            //uzywamy api MockMvc do testu endpoint'a (bez uzycia tomcata)
                get("/person/1")                               //metoda HTTP GET na endpoint hobbit
                        .contentType(MediaType.APPLICATION_JSON)       //format przesyłania danych
        )
                .andExpect(status().isOk())                             //oczekiwany status odpowiedzi (HTTP)
                .andDo(print())                                         // logowanie  (nie jest wymagane ale loguje w consoli co sie dzieje)
                .andReturn();                                           //zwrócenie obiekttu MvcResult

        Person person = OBJECT_MAPPER.readValue(response.getResponse().getContentAsString(), Person.class);     //mapujemy jsona do new Object
        assertEquals("Ala", person.getName());                                 // porównujemy zwroconego jsona do obiektu oczekwianego
        assertEquals("Koala", person.getSurname());
    }

    @Test
    void shouldReturn4XX_hobbitPOST() throws Exception {
        mockMvc.perform(
                post("/person/3")
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isMethodNotAllowed())
                .andDo(print())
                .andReturn();
    }
}