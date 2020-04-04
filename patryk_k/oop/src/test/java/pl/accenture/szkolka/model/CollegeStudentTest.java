package pl.accenture.szkolka.model;

import org.junit.jupiter.api.Test;
import pl.accenture.szkolka.model.CollegeStudent;
import static org.junit.jupiter.api.Assertions.*;

public class CollegeStudentTest {

    @Test
    public void collegeStudentBuilderTest(){
        //given
        CollegeStudent givenStudent = new CollegeStudent("Barbara", "Nowakowska", 23, false,
                new String[]{"OOP", "Math"}, new String[]{"Programming", "Math"});
        //when
        CollegeStudent builderStudent = CollegeStudent.builder()
                .name("Barbara")
                .lastName("Nowakowska")
                .age(23)
                .isMen(false)
                .lectures(new String[]{"OOP", "Math"})
                .collegeExercises(new String[]{"Programming", "Math"})
                .build();
        //then
        assertEquals(givenStudent, builderStudent);
    }
}
