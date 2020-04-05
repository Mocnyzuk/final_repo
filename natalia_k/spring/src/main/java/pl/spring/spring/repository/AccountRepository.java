package pl.spring.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.spring.spring.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
