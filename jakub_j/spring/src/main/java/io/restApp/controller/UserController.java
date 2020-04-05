package io.restApp.controller;

import io.restApp.model.User;
import io.restApp.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAllUsers();
    }
    @GetMapping("/{username}")
    public User getByUsername(@PathVariable String username){
        return userService.getByUsername(username);
    }
}
