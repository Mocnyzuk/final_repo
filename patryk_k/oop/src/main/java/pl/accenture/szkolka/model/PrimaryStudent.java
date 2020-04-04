package pl.accenture.szkolka.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.accenture.szkolka.Interfaces.Student;

@Data
@EqualsAndHashCode(callSuper = true)
public class PrimaryStudent extends Person implements Student {
    private String[] subjects;
    private String[] teachers;

    @Builder
    public PrimaryStudent(String name, String lastName, int age, boolean isMen, String[] subjects, String[] teachers){
        super(name, lastName, age, isMen);
        this.subjects = subjects;
        this.teachers = teachers;
    }

    @Override
    public void doYourHomeWork() {
        System.out.println("Student getting his work");
    }
}
