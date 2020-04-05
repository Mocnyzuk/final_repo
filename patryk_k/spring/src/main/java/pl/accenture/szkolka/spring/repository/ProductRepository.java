package pl.accenture.szkolka.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.accenture.szkolka.spring.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
