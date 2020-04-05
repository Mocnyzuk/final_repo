package model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.function.Predicate;

@Data
@AllArgsConstructor
public class Participant {
    String name;
    String surname;
    int yearOfBirth;

    static Predicate<Participant> nameStartsWith(final String firstLetter) {
        return p -> p.name.startsWith(firstLetter);
    }

    static Predicate<Participant> surnameStartsWith(final String firstLetter) {
        return p -> p.surname.startsWith(firstLetter);
    }

    static Predicate<Participant> bornIn90 = p -> p.yearOfBirth >= 1990 && p.yearOfBirth < 2000;

    static Comparator<Participant> nameSort = Comparator.comparing(p -> p.name);
    static Comparator<Participant> surnameSort = Comparator.comparing(p -> p.surname);
    static Comparator<Participant> birthSort = Comparator.comparing(p -> p.yearOfBirth);


}
