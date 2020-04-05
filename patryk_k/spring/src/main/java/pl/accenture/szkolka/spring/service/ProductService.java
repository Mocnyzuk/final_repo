package pl.accenture.szkolka.spring.service;

import org.springframework.stereotype.Service;
import pl.accenture.szkolka.spring.model.Product;
import pl.accenture.szkolka.spring.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return new ArrayList<>(productRepository.findAll());
    }
}
