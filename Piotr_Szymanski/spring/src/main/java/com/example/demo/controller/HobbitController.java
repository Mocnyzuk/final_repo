package com.example.demo.controller;

import com.example.demo.domain.Hobbit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HobbitController {

    @GetMapping("/hobbit")
    public Hobbit getHobbit() {
        return new Hobbit("Frodo", "Baggins");
    }
}
