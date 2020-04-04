package com.example.domain;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.websocket.OnError;

/**
 * Represents a person form with first name and age restrictions.
 */
@Data
public class PersonForm {
    @NotNull
    @Size(min=2, max=20)
    private String firstName;

    @NotNull
    @Min(15)
    private Integer age;

}
