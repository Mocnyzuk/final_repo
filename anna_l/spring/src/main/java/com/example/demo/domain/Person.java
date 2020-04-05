package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    private Long id;
    private String email;
    private String name;
    private String lastName;
    @JsonProperty(value = "isLearningJava")
    private boolean isLearningJava;
    private int age;

    public boolean isEmailValid() {
        return email.contains("@");
    }
}
