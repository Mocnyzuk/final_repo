package pl.accenture.szkolka.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimaryStudentTest {

    @Test
    public void PrimaryStudentBuilderTest(){
        //given
        PrimaryStudent givenStudent = new PrimaryStudent("Tomasz", "Malina", 10, true,
                new String[]{"Polish", "Math"}, new String[]{"Tomasz Adam", "Wojciech Malinowski"});
        //when
        PrimaryStudent builderStudent = PrimaryStudent.builder()
                .name("Tomasz")
                .lastName("Malina")
                .age(10)
                .isMen(true)
                .subjects(new String[]{"Polish", "Math"})
                .teachers(new String[]{"Tomasz Adam", "Wojciech Malinowski"})
                .build();
        //then
        assertEquals(givenStudent, builderStudent);
    }

}