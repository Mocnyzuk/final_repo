package com.example.demo.controller;

import com.example.demo.domain.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ControllerAdvice
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public void setPersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/person/{id}")
    public Person getPersonByID(@PathVariable Long id) {
        return personRepository.findById(id).get();
    }

    @GetMapping("/person")
    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    @PostMapping("/addPerson")
    public Person addPerson(@RequestBody Person person) throws BadEmailException {
        if (person.isEmailValid()) {
            return personRepository.save(person);
        }
        throw new BadEmailException("Bad e-mail provided");
    }

    @PutMapping("/person/{id}")
    public Person replacePerson(@RequestBody Person newPerson, @PathVariable Long id) {
        return personRepository.findById(id)
                .map(person -> {
                    person.setEmail(newPerson.getEmail());
                    person.setName(newPerson.getName());
                    person.setLastName(newPerson.getLastName());
                    person.setLearningJava(newPerson.isLearningJava());
                    person.setAge(newPerson.getAge());
                    return personRepository.save(person);
                }).orElseGet(() -> {
                    newPerson.setId(id);
                    return personRepository.save(newPerson);
                });
    }

    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
    }

    @ExceptionHandler(BadEmailException.class)
    public String badEmailHandler() {
        return "Bad e-mail provided";
    }

    @ExceptionHandler(Exception.class)
    public String allExceptionHandler() {
        return "Application has encountered a problem. \nPlease check if details provided are correct.";
    }
}
