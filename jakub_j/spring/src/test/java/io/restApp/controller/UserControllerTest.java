package io.restApp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restApp.model.User;
import io.restApp.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should return an array of Users")
    @DirtiesContext
    void getAllUsers() throws Exception {
        //given
        List<User> expected = userService.getAllUsers();
        //when
        MvcResult result = mockMvc.perform(
                get("/user/all"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        User[] resultUsers = OBJECT_MAPPER.readValue(
                result.getResponse().getContentAsString(), User[].class
        );
        //then
        assertArrayEquals(expected.toArray(), resultUsers);
    }

    @Test
    @DisplayName("Should return the user with contains the given Username")
    @DirtiesContext
    void getByUsername() throws Exception {
        //given
        String username = "username";
        User expected = userService.getByUsername(username);
        //when
        MvcResult result = mockMvc.perform(
                get("/user/" + username))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        User resultUser = OBJECT_MAPPER.readValue(
                result.getResponse().getContentAsString(), User.class
        );
        //then
        assertEquals(expected, resultUser);
    }
}