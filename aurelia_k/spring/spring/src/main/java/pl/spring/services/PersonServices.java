package pl.spring.services;

import org.springframework.stereotype.Service;
import pl.spring.domain.Person;
import pl.spring.repositories.PersonRepository;

import java.util.List;

@Service
public class PersonServices {

    PersonRepository personRepository;

    public PersonServices(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person getPersonById(long id) {
        Person person = personRepository.findById(id).get();
        return person;
    }


    public Person cretePerson(Person person) {
        personRepository.save(person);
        return person;
    }


    public List<Person> personList() {
        return personRepository.findAll();
    }


    public Person updatePersonById(long id, Person person) {
        person.setId(id);
        personRepository.save(person);
        return person;
    }
}
