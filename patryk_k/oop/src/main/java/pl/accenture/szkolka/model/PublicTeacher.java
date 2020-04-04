package pl.accenture.szkolka.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.accenture.szkolka.Interfaces.Teacher;

@Data
@EqualsAndHashCode(callSuper = true)
public class PublicTeacher extends Person implements Teacher {

    private String[] classes;
    private String schoolName;

    @Builder
    public PublicTeacher(String name, String lastName, int age, boolean isMen, String[] classes, String schoolName){
        super(name, lastName, age, isMen);
        this.classes = classes;
        this.schoolName = schoolName;
    }

    @Override
    public void teachStudents() {
        System.out.println("Give boring lectures");
    }
}
