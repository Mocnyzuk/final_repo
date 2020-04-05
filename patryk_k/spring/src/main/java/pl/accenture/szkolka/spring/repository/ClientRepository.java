package pl.accenture.szkolka.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.accenture.szkolka.spring.model.Client;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findAllByLastName(String lastName);

}
