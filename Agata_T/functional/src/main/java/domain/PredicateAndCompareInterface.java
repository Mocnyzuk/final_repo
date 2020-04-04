package domain;

import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
public interface PredicateAndCompareInterface {
    List<Person> filterAndSort(List<Person> people);

    PredicateAndCompareInterface useFirstPredAndCompar = people -> people
            .stream()
            .filter(Person.ifFirstNameEndsWithA)
            .sorted(Person.sortByFirstName)
            .collect(Collectors.toList());

    PredicateAndCompareInterface useSecondPredAndCompar = people -> people
            .stream()
            .filter(Person.ifPersonGotBlueEyes)
            .sorted(Person.sortByLastName.reversed())
            .collect(Collectors.toList());

    PredicateAndCompareInterface useThirdPredAndCompar = people -> people
            .stream()
            .filter(Person.ifPersonIsAdult)
            .sorted(Person.sortByAge.thenComparing(Person.sortByLastName))
            .collect(Collectors.toList());
}
