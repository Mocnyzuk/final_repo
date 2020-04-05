package io.restApp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restApp.model.User;
import io.restApp.security.UserDTO;
import io.restApp.service.RegisterService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RegistrationControllerTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private RegisterService registerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private String passForUser = "password";



    @Test
    @DisplayName("GetMapp on /register")
    @DirtiesContext
    void getMapOnRegisterShouldReturnString() throws Exception {
        //given
        String expected = registerService.GET_MAP_INFO;
        //when
        MvcResult result = mockMvc.perform(
                get("/register"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        String resultString = result.getResponse().getContentAsString();
        //then
        assertEquals(expected, resultString);
    }

    @Test
    @DisplayName("Should create new User")
    @DirtiesContext
    void registerForm() throws Exception {
        //given
        UserDTO userDTO = createTestUser();
        String expected = registerService.REGISTER_SUCCES_INFO;
        String jsonForPost = OBJECT_MAPPER.writeValueAsString(userDTO);
        User user = userFormToUser(userDTO);
        //when
        MvcResult result = mockMvc.perform(
                post("/register")
                .content(jsonForPost))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        String resultString = result.getResponse().getContentAsString();
        //then
        assertEquals(expected, resultString);
        assertNotEquals(passForUser, user.getPassword());
    }
    @Test
    @DisplayName("Creating user without password")
    @DirtiesContext
    void registerWrongCredentials()throws Exception{
        //given
        UserDTO userDTO = createTestUser();
        userDTO.setPassword(null);
        String expected = registerService.REGISTER_FAIL_INFO;
        String jsonForPost = OBJECT_MAPPER.writeValueAsString(userDTO);
        //User user = userFormToUser(userForm);
        //when
        MvcResult result = mockMvc.perform(
                post("/register")
                        .content(jsonForPost))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        String resultString = result.getResponse().getContentAsString();
        //then
        assertEquals(expected, resultString);
        //assertNotEquals(passForUser, user.getPassword());
    }
    private UserDTO createTestUser(){
        UserDTO userDTO = new UserDTO();
        userDTO.setPassword(passForUser);
        userDTO.setUsername("franek");
        return userDTO;
    }
    private User userFormToUser(UserDTO form){
        return form.toUser(passwordEncoder);
    }
}