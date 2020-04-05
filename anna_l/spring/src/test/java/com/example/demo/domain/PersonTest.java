package com.example.demo.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void shouldReturnTrueIfEmailIsValid() {
        Person person = new Person();
        person.setEmail("ania@gmail.com");
        assertTrue(person.isEmailValid());
    }

    @Test
    void shouldReturnFalseIfEmailIsNotValid() {
        Person person = new Person();
        person.setEmail("ania.gmail.com");
        assertFalse(person.isEmailValid());
    }
}