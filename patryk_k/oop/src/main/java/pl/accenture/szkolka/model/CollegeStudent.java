package pl.accenture.szkolka.model;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.accenture.szkolka.Interfaces.Student;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CollegeStudent extends Person implements Student {

    private String[] lectures;
    private String[] collegeExercises;

    @Builder
    public CollegeStudent(String name, String lastName, int age, boolean isMen, String[] lectures, String[] collegeExercises){
        super(name, lastName, age, isMen);
        this.lectures = lectures;
        this.collegeExercises = collegeExercises;
    }

    @Override
    public void doYourHomeWork() {
        System.out.println("The student doesn't want to do homework and goes to a party");
    }
}
