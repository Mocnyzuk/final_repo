package functional;

import functional.domain.Person;
import functional.domain.Pet;
import functional.domain.PetSpecies;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class StreamApiExampleTest {

    private static final List<Person> testPeople = List.of(
            new Person("Anna", "Karenina", 1995, new Pet(PetSpecies.GOAT, "Lilly")),
            new Person("Marcus", "Aurelius", 1964, new Pet(PetSpecies.CAT, "Dog")),
            new Person("Ursula", "Le Guin", 1965, new Pet(PetSpecies.HAMSTER, "Jenefer")),
            new Person("Terry", "Pratchett", 1990, new Pet(PetSpecies.DOG, "Ogg")),
            new Person("Neil", "Gaiman", 1985, new Pet(PetSpecies.DOG, "Damian")),
            new Person("John", "Wick", 1944, new Pet(PetSpecies.GOAT, "Amanda")),
            new Person("Harry", "Potter", 1985, new Pet(PetSpecies.HORSE, "Hermione")),
            new Person("Esmeralda", "Weatherwax", 1995, new Pet(PetSpecies.CAT, "You"))
    );

    @Test
    void findAllGoatOwnersInAlphabeticalOrder() {
        //given
        StreamApiExample streamApiExample = new StreamApiExample();
        //when
        List<Person> resultList = streamApiExample.findAllGoatOwnersInAlphabeticalOrder(testPeople);
        List<String> petsNames = resultList
                .stream()
                .map(s -> s.getPet().getPetName())
                .collect(Collectors.toList());
        //then
        assertThat(resultList.size()).isEqualTo(2);
        assertThat(petsNames).containsExactly("Lilly", "Amanda");
    }

    @Test
    void findAllDogOrCatOwnersSortedByAge() {
        //given
        StreamApiExample streamApiExample = new StreamApiExample();
        //when
        List<Person> resultList = streamApiExample.findAllDogOrCatOwnersSortedByAge(testPeople);
        List<PetSpecies> petSpeciesList = resultList
                .stream()
                .map(Person::getPet)
                .map(Pet::getPetSpecies)
                .distinct()
                .collect(Collectors.toList());
        //then
        assertThat(resultList.size()).isEqualTo(4);
        assertThat(petSpeciesList.size()).isEqualTo(2);
    }

    @Test
    void findAllPeopleBornBetween1980and1999sortedByName() {
        //given
        StreamApiExample streamApiExample = new StreamApiExample();
        //when
        List<Person> resultList = streamApiExample.findAllPeopleBornBetween1980and1999sortedByName(testPeople);
        //then
        assertThat(resultList.size()).isEqualTo(5);
    }

    @Test
    void sortAllPeopleByPetSpeciesAndLastName() {
        //given
        StreamApiExample streamApiExample = new StreamApiExample();
        //when
        List<Person> resultList = streamApiExample.sortAllPeopleByPetSpeciesAndLastName(testPeople);
        //then
        assertThat(resultList.size()).isEqualTo(testPeople.size());
        assertThat(resultList.get(0).getPet().getPetName()).isEqualTo("Dog");
        assertThat(resultList.get(1).getPet().getPetName()).isEqualTo("You");
    }
}