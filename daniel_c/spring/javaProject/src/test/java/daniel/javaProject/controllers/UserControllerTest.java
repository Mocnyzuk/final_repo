package daniel.javaProject.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import daniel.javaProject.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class UserControllerTest {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldReturnUserById() throws Exception {
        MvcResult storyResult =
                mockMvc.perform(
                        get("/userById/1")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                        .andExpect(status().isOk())
                        .andDo(print())
                        .andReturn();

        User user = OBJECT_MAPPER.readValue(storyResult.getResponse().getContentAsString(), User.class);

        assertEquals(new User(1, "testuser"), user);
    }

    @Test
    void shouldReturnUserByLogin() throws Exception {
        MvcResult storyResult =
                mockMvc.perform(
                        get("/userByLogin/testuser2")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                        .andExpect(status().isOk())
                        .andDo(print())
                        .andReturn();

        User user = OBJECT_MAPPER.readValue(storyResult.getResponse().getContentAsString(), User.class);

        assertEquals(new User(2, "testuser2"), user);
    }

}