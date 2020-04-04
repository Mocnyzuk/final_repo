package pl.spring.controllers;

import org.springframework.web.bind.annotation.*;
import pl.spring.domain.Person;
import pl.spring.services.PersonServices;

import java.util.List;

@RestController
@RequestMapping("api/person")
public class PersonController {
    PersonServices personServices;

    public PersonController(PersonServices personServices) {
        this.personServices = personServices;
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable long id) {
        Person person = personServices.getPersonById(id);
        return person;
    }

    @PostMapping
    public Person cretePerson(@RequestBody Person person) {
        personServices.cretePerson(person);
        return person;
    }

    @GetMapping
    public List<Person> personList() {
        return personServices.personList();
    }

    @PostMapping("/{id}")
    public Person updatePersonById(@PathVariable long id, @RequestBody Person person) {
        personServices.updatePersonById(id, person);
        return person;
    }
}
