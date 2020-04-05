package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Represents a cat fact got from https://cat-fact.herokuapp.com.
 * */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CatFact {
    private String text;

    public CatFact() {
    }


}
