package generator;

import domain.EyeColor;
import domain.Person;
import java.util.List;

/**
 * Provides generating people List to be delivered into FilterAndSorter.
 * */
public class PeopleListGenerator {

    private PeopleListGenerator() {
    }

    public static List<Person> generate() {
        return List.of(
                new Person("Jan","Kowalski", 19, EyeColor.GREEN),
                new Person("Adam", "Nowak", 15, EyeColor.BLUE),
                new Person("Barbara", "Mucha", 53, EyeColor.GREY),
                new Person("Kacper","Chmielewski", 33, EyeColor.GREEN),
                new Person("Wojciech","Szymański", 18, EyeColor.BLUE),
                new Person("Anna", "Kwiatkowska", 10, EyeColor.BROWN),
                new Person("Wiktoria","Kozłowska", 19, EyeColor.GREEN),
                new Person("Barbara","Piasecka", 5, EyeColor.BLUE),
                new Person("Dominik","Gajewski", 42, EyeColor.BLUE)
        );
    }
}
