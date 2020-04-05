package io.restApp.controller;

import io.restApp.service.RegisterService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegistrationController {

    private RegisterService registerService;


    public RegistrationController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping
    public String getMapOnRegister(){
        return registerService.GET_MAP_INFO;
    }

    @PostMapping
    public String registerForm(@RequestBody String json){
        return (registerService.checkIfUserExistAndSaveIfNot(json))?
                registerService.REGISTER_SUCCES_INFO:
                registerService.REGISTER_FAIL_INFO;
    }

}
