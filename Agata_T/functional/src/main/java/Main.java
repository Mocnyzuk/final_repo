import domain.EyeColor;
import domain.Person;
import domain.PredicateAndCompareInterface;

import java.util.List;

public class Main {
    public static void main(String[] args) {


    }
    private static List<Person> generatePeopleList() {
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

    private static void usePredicateAndComparator(PredicateAndCompareInterface predAndCompI, List<Person> people) {
        predAndCompI.filterAndSort(people)
                .forEach(System.out::println);
    }
}
