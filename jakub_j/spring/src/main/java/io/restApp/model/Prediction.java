package io.restApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = PRIVATE, force = true)
public class Prediction {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private final String sentence;
    private final String author;
}
