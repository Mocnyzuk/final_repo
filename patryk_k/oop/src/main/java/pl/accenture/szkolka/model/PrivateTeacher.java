package pl.accenture.szkolka.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.accenture.szkolka.Interfaces.Teacher;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class PrivateTeacher extends Person implements Teacher {

    private String[] students;
    private BigDecimal costPerHour;

    @Builder
    public PrivateTeacher(String name, String lastName, int age, boolean isMen, String[] students, BigDecimal costPerHour){
        super(name, lastName, age, isMen);
        this.students = students;
        this.costPerHour = costPerHour;
    }

    @Override
    public void teachStudents() {
        System.out.println("Give interesting lectures");
    }
}
