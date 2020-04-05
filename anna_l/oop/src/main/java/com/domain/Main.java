package com.domain;

public class Main {

    public static void main(String[] args) {
        Person person = new Person.Builder()
                .withAge(25)
                .withFirstName("Ania")
                .withMiddleName("Ola")
                .withLastName("Nowak")
                .withEmail("ania@gmail.com")
                .build();
    }
}