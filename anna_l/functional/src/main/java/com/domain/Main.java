package com.domain;

import java.util.List;

import static com.domain.Person.*;

public class Main {

    public static void main(String[] args) {
        List<Person> people = createListOfPeople();

        System.out.println("People from list whose names starts with A and are over 18, sorted by animal age: ");
        people.stream()
                .filter(nameStartsWithA
                        .and(ageOver18))
                .sorted(sortByAnimalAge)
                .forEach(System.out::println);

        System.out.println("\nUnique lastNames of people from the list that are over 18:");
        people.stream()
                .filter(ageOver18)
                .map(Person::getLastName)
                .distinct()
                .forEach(System.out::println);
    }

    private static List<Person> createListOfPeople() {
        return List.of(
                new Person("Ania", "Nowak", 24, new Animal("Burek", 4, AnimalType.DOG)),
                new Person("Kasia", "Kowalska", 12, new Animal("Mruczek", 13, AnimalType.CAT)),
                new Person("Amelia", "Duda", 3, new Animal("Mustang", 16, AnimalType.HORSE)),
                new Person("Piotr", "Bak", 10, new Animal("Lapa", 2, AnimalType.RAT)),
                new Person("Ala", "Nowak", 70, new Animal("Stuart", 1, AnimalType.MOUSE)),
                new Person("Ania", "Ptak", 19, null)
        );
    }
}