package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Fact {
    private String text;

    public Fact() {
    }


    @Override
    public String toString() {
        return "Random cat fact: "+ text;
    }
}

