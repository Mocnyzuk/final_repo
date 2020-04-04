package streamAPI;

import streamAPI.fileCopying.FileCopying;
import streamAPI.models.Bike;
import streamAPI.models.Person;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static streamAPI.models.Person.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var people = generatePeople();
        useStreamsAPI(people);

        System.out.println("\n=============================\n");

        FileCopying fileCopying = new FileCopying();
        fileCopying.testAllMethods();
    }

    static List<Person> generatePeople() {
        return List.of(
                new Person("Ala", "Kowalska", new Bike("romet", 14)),
                new Person("Bogdan", "Bogdanowicz", new Bike("cross", 16)),
                new Person("Bena", "Nowak", new Bike("romet", 18)),
                new Person("Adam", "Bogdanowicz", new Bike("romet", 12)),
                new Person("Zenek", "Jakiś", new Bike("cube", 10)),
                new Person("Ania", "Bednarek", new Bike("trekk", 16))
        );
    }

    private static void useStreamsAPI(List<Person> people) {
        System.out.println("Imie Zenek lub Marka roweru zaczyna sie na C lub Rama roweru > 12:");
        System.out.println(filterAndSort1(people));

        System.out.println("\nRama > 12 i Dlugosc nazwiska > 5:");
        System.out.println(filterAndSort2(people));

        System.out.println("\n(Rama > 12 i Dlugosc nazwiska > 5) lub Imie Zenek:");
        System.out.println(filterAndSort3(people));
    }

    static List<Person> filterAndSort1(List<Person> people) {
        return people
                .stream()
                .filter(nameIsZenekPredicate.or(brandStartsWithCPredicate).or(bikeFrameSizeBiggerThan12Predicate))
                .sorted(sortByBrand)
                .collect(Collectors.toList());
    }

    static List<Person> filterAndSort2(List<Person> people) {
        return people
                .stream()
                .filter(bikeFrameSizeBiggerThan12Predicate.and(lastNameLengthBiggerThan5Predicate))
                .sorted(sortByLastName)
                .collect(Collectors.toList());
    }

    static List<Person> filterAndSort3(List<Person> people) {
        return people
                .stream()
                .filter((bikeFrameSizeBiggerThan12Predicate.and(lastNameLengthBiggerThan5Predicate)).or(nameIsZenekPredicate))
                .sorted(sortByName)
                .collect(Collectors.toList());
    }

}
