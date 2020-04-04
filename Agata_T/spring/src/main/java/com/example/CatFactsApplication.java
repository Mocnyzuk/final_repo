package com.example;

import com.example.model.Fact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CatFactsApplication {

    private static final Logger log = LoggerFactory.getLogger(CatFactsApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CatFactsApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Fact fact = restTemplate.getForObject(
                    "https://cat-fact.herokuapp.com/facts/random?animal_type=cat&amount=1", Fact.class);
            log.info(fact.toString());
        };
    }
}
