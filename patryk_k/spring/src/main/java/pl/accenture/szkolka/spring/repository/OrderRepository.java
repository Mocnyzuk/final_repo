package pl.accenture.szkolka.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.accenture.szkolka.spring.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
