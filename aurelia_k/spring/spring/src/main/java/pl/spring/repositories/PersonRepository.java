package pl.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.spring.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
