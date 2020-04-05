package spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private int seniority;
    private double salary;

}