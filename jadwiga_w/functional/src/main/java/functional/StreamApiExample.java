package functional;

import functional.domain.Person;
import functional.domain.PetSpecies;

import java.util.List;
import java.util.stream.Collectors;

public class StreamApiExample {

    public List<Person> findAllGoatOwnersInAlphabeticalOrder(List<Person> people){
        return people
                .stream()
                .filter(Person.ownersOfSpecies(PetSpecies.GOAT))
                .sorted(Person.sortByLastName)
                .collect(Collectors.toList());
    }

    public List<Person> findAllDogOrCatOwnersSortedByAge(List<Person> people){
        return people
                .stream()
                .filter(Person.ownersOfSpecies(PetSpecies.CAT).or(Person.ownersOfSpecies(PetSpecies.DOG)))
                .sorted(Person.sortByYearOfBirth)
                .collect(Collectors.toList());
    }

    public List<Person> findAllPeopleBornBetween1980and1999sortedByName(List<Person> people){
        return people
                .stream()
                .filter(Person.yearOfBirthBetween1980and1999)
                .sorted(Person.sortByName)
                .collect(Collectors.toList());
    }

    public List<Person> sortAllPeopleByPetSpeciesAndLastName(List<Person> people){
        return people
                .stream()
                .sorted(Person.sortByPetSpecies.thenComparing(Person.sortByLastName))
                .collect(Collectors.toList());
    }
}
