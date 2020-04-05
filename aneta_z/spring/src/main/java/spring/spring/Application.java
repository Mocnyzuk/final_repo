package spring.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    static SmoothieRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Smoothie("fresh", "small"));
        repository.save(new Smoothie("sweet", "small"));
        repository.save(new Smoothie("protein","medium"));
        repository.save(new Smoothie("fresh", "large"));
        repository.save(new Smoothie("vegetable", "large"));

        List<Smoothie> smoothies = new ArrayList<Smoothie>() {};

        for (Smoothie smoothie : repository.findAll()) {
            smoothies.add(smoothie);
        }
        System.out.println(smoothies);

        Smoothie freshSmoothie = repository.findByName("fresh");
        List<Smoothie> largeSmoothies = repository.findBySize("large");
        List<Smoothie> smallSmoothies = repository.findBySize("small");

        System.out.println("Large smoothies: " + largeSmoothies);
        System.out.println("Small smoothies: " + smallSmoothies);

    }
}
