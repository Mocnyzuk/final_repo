package functional.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.PreparedStatement;
import java.util.Comparator;
import java.util.function.Predicate;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private String lastName;
    private int yearOfBirth;
    private Pet pet;

    public static Comparator<Person> sortByYearOfBirth = Comparator.comparing(p -> p.yearOfBirth);
    public static Comparator<Person> sortByLastName = Comparator.comparing(p -> p.lastName);
    public static Comparator<Person> sortByName = Comparator.comparing(p -> p.name);
    public static Comparator<Person> sortByPetSpecies = Comparator.comparing(p -> p.pet.getPetSpecies());

    public static Predicate<Person> yearOfBirthBetween1980and1999 = p -> p.yearOfBirth >= 1980 && p.yearOfBirth <= 1999;

    public static Predicate<Person> ownersOfSpecies(final PetSpecies species) {
        return p -> p.pet.getPetSpecies().equals(species);

    }

    public static Predicate<Person> nameStartsWithA = p -> p.name.toUpperCase().startsWith("A");

}
