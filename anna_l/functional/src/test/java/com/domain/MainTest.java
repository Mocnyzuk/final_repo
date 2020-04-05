package com.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static com.domain.Person.ageOver18;
import static com.domain.Person.nameStartsWithA;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    List<Person> peopleList = List.of(
            new Person("Ania", "Nowak", 24, new Animal("Burek", 4, AnimalType.DOG)),
            new Person("Kasia", "Kowalska", 12, new Animal("Mruczek", 13, AnimalType.CAT)),
            new Person("Amelia", "Duda", 3, new Animal("Mustang", 16, AnimalType.HORSE)),
            new Person("Piotr", "Bak", 10, new Animal("Lapa", 2, AnimalType.RAT)),
            new Person("Ala", "Nowak", 70, new Animal("Stuart", 1, AnimalType.MOUSE)),
            new Person("Ania", "Ptak", 19, new Animal("Reksio", 10, AnimalType.DOG)));

    @Test
    void shouldReturnPeopleOver18WhoseNamesStartsWithA() {
        List<Person> listToBeReturned = List.of(
                new Person("Ania", "Nowak", 24, new Animal("Burek", 4, AnimalType.DOG)),
                new Person("Ala", "Nowak", 70, new Animal("Stuart", 1, AnimalType.MOUSE)),
                new Person("Ania", "Ptak", 19, new Animal("Reksio", 10, AnimalType.DOG)));

        List<Person> list = peopleList.stream()
                .filter(nameStartsWithA
                        .and(ageOver18))
                .collect(Collectors.toList());

        assertEquals(listToBeReturned, list);
    }

    @Test
    void shouldReturnUniqueLastNamesOfPeopleOver18() {
        List<String> listToBeReturned = List.of("Nowak", "Ptak");

        List<String> list = peopleList.stream()
                .filter(ageOver18)
                .map(Person::getLastName)
                .distinct()
                .collect(Collectors.toList());

        assertEquals(listToBeReturned, list);
    }
}