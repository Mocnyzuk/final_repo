package pl.spring.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.spring.spring.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
