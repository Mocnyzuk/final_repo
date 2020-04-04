package pl.accenture.szkolka.model;

import org.junit.jupiter.api.Test;

import java.io.PrintWriter;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PrivateTeacherTest {

    @Test
    public void PrivateTeacherBuilderTest(){
        //given
        PrivateTeacher givenTeacher = new PrivateTeacher("Karol", "Nowak", 45, true,
                new String[]{"Patryk Kania", "Wiolleta Nowak"}, new BigDecimal(85));
        //when
        PrivateTeacher builderTeacher = PrivateTeacher.builder()
                .name("Karol")
                .lastName("Nowak")
                .age(45)
                .isMen(true)
                .students(new String[]{"Patryk Kania", "Wiolleta Nowak"})
                .costPerHour(new BigDecimal(85))
                .build();
        //then
        assertEquals(givenTeacher, builderTeacher);
    }
}