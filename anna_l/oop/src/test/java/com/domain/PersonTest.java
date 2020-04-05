package com.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void shouldThrowExceptionWhenWrongEmailProvided() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Person.Builder()
                        .withFirstName("Ania")
                        .withEmail("ania")
                        .build());

        assertTrue(exception.getMessage().contains("E-mail must contain @"));
    }

    @Test
    public void shouldThrowExceptionWhenNoInformationProvided() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Person.Builder()
                        .build());

        assertTrue(exception.getMessage().contains("Person must have name"));
    }

    @Test
    public void shouldThrowExceptionWhenAgeBelowZero() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> new Person.Builder()
                        .withFirstName("Ania")
                        .withAge(-1)
                        .build());

        assertTrue(exception.getMessage().contains("Age must be bigger than 0"));
    }

    @Test
    public void personCreatedWithBuilderShouldHaveAllValues() {
        Person person = new Person.Builder()
                .withEmail("anial@gmail.com")
                .withFirstName("Ania")
                .withMiddleName("Ola")
                .withLastName("Ptak")
                .withAge(25)
                .build();

        assertEquals("Ania", person.getFirstName());
        assertEquals("anial@gmail.com", person.getEmail());
        assertEquals("Ola", person.getMiddleName());
        assertEquals("Ptak", person.getLastName());
        assertEquals(25, person.getAge());
    }
}