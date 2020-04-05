package com.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.function.Predicate;

@Data
@AllArgsConstructor
public class Person {

    private String name;
    private String lastName;
    private int age;
    private Animal animal;

    static Predicate<Person> ageOver18 = person -> person.getAge() > 18;
    static Predicate<Person> nameStartsWithA = person -> person.getName().toUpperCase().startsWith("A");

    static Comparator<Person> sortByAnimalAge = Comparator.comparing(
            person -> person.getAnimal() == null ? 0 : person.getAnimal().getAge());
}