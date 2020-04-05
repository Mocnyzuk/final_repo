package io.restApp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restApp.data.UserRepository;
import io.restApp.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class UserService {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        List<User> resultList = (userRepository.findAll().isEmpty())?
                Collections.singletonList(new User("User list is empty", "")):
                userRepository.findAll();
        try {
            log.debug(OBJECT_MAPPER.writeValueAsString(resultList));
        } catch (JsonProcessingException e) {
            log.debug("Couldnt parse Object to JSON");
        }
        return resultList;
    }

    public User getByUsername(String username) {
        User result = userRepository.findByUsername(username)
                .orElse(new User("no such user", ""));
        try {
            log.debug(OBJECT_MAPPER.writeValueAsString(result));
        } catch (JsonProcessingException e) {
            log.debug("Couldnt parse Object to JSON");
        }
        return result;
    }
}
