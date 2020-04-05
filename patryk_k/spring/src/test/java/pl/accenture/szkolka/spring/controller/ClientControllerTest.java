package pl.accenture.szkolka.spring.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import pl.accenture.szkolka.spring.model.Client;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@AutoConfigureMockMvc
@SpringBootTest
class ClientControllerTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    MockMvc mockMvc;

    @Test
    void getAllClientsByLastName() throws Exception {
        //given
        MvcResult result = mockMvc.perform(
                get("/client/lastname/KANIA")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        //when
        List<Client> clients = Arrays.asList(OBJECT_MAPPER.readValue(result.getResponse().getContentAsString(), Client[].class));
        //then
        assertEquals(1, clients.size());
    }

    @Test
    void getAllVipClients() throws Exception {
        //given
        MvcResult result = mockMvc.perform(
                get("/clientvip")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        //when
        List<Client> clients = Arrays.asList(OBJECT_MAPPER.readValue(result.getResponse().getContentAsString(), Client[].class));
        //then
        assertEquals(1, clients.size());
    }
}