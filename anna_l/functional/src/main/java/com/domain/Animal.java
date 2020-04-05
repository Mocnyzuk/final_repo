package com.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Animal {

    private String name;
    private int age;
    private AnimalType type;
}
