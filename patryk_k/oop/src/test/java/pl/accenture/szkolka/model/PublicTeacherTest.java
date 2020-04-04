package pl.accenture.szkolka.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PublicTeacherTest {

    @Test
    public void PublicTeacherBuilderTest(){
        //given
        PublicTeacher givenTeacher = new PublicTeacher("Karolina", "Loson", 33, false,
                new String[]{"1B", "4C", "4A"}, "SP3");
        //when
        PublicTeacher builderTeacher = PublicTeacher.builder()
                .name("Karolina")
                .lastName("Loson")
                .age(33)
                .isMen(false)
                .classes(new String[]{"1B", "4C", "4A"})
                .schoolName("SP3")
                .build();
        //then
        assertEquals(givenTeacher,builderTeacher);
    }
}