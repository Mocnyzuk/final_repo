package spring.spring;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SmoothieRepository extends MongoRepository<Smoothie, String> {
    Smoothie findByName(String name);

    List<Smoothie> findBySize(String size);
}
