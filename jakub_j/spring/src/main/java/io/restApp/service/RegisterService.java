package io.restApp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restApp.data.UserRepository;
import io.restApp.model.User;
import io.restApp.security.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RegisterService {

    public final String GET_MAP_INFO = "Prepare a HTTPPOST with new user details as JSON";
    public final String REGISTER_SUCCES_INFO = "Registration success";
    public final String REGISTER_FAIL_INFO = "Registration failed wrong credentials";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private UserRepository userRepository;
    private PasswordEncoder passEncoder;

    public RegisterService(UserRepository userRepository, PasswordEncoder passEncoder) {
        this.userRepository = userRepository;
        this.passEncoder = passEncoder;
    }

    public boolean checkIfUserExistAndSaveIfNot(String json){
        User user = jsonToUser(json);
        if(!user.getUsername().equals("")) {
            if (userRepository.findByUsername(user.getUsername()).isEmpty()) {
                userRepository.save(user);
                log.debug("USER SAVE COMPLETED");
                return true;
            }
        }
        log.debug("USER SAVE FAILED");
        return false;
    }
    private User jsonToUser(String json){
        UserDTO user = new UserDTO();
        try {
            user = OBJECT_MAPPER.readValue(json, UserDTO.class);

        } catch (JsonProcessingException e) {
            log.debug("Couldnt parse Object to JSON");
        }
        if((user.getPassword() == null || user.getUsername() == null) ||
                (user.getPassword().equals("") || user.getUsername().equals(""))){
            user.setPassword("");
            user.setUsername("");
        }
        return user.toUser(passEncoder);
    }
}
