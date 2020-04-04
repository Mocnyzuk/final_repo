package domain;
import java.util.List;
import java.util.stream.Collectors;


@FunctionalInterface
public interface PredicateAndCompareInterface {
    /**
     * Provides filtering and sorting the list using predicates and comparators from People Class. Uses StreamAPI.
     * @return filtered and sorted list.
     */
    List<Person> filterAndSort(List<Person> people);

    PredicateAndCompareInterface ifWomanSortByFirstName = people -> people
            .stream()
            .filter(Person.ifFirstNameEndsWithA)
            .sorted(Person.sortByFirstName)
            .collect(Collectors.toList());

    PredicateAndCompareInterface ifBlueEyesSortByLastName = people -> people
            .stream()
            .filter(Person.ifPersonGotBlueEyes)
            .sorted(Person.sortByLastName.reversed())
            .collect(Collectors.toList());

    PredicateAndCompareInterface ifAdultSortByAgeThenLastName = people -> people
            .stream()
            .filter(Person.ifPersonIsAdult)
            .sorted(Person.sortByAge.thenComparing(Person.sortByLastName))
            .collect(Collectors.toList());
}
