import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    @DisplayName("-> It's a circle")
    void introduceFigure() {
        //given
        String expectedIntroduction = Circle.CIRCLE;
        //when
        String returnedIntroduction = new Circle().introduceFigure();
        //then
        assertEquals(expectedIntroduction, returnedIntroduction);

    }

    @Test
    @DisplayName("radius 5 -> area= 78.53981633974483")
    void calculateArea() {
        //given
        double radius = 5;
        Circle circle = new Circle(radius);
        //when
        double expectedArea = radius * radius * Math.PI;
        double returnedArea = circle.calculateArea();
        //then
        assertEquals(expectedArea, returnedArea);
    }

    @Test
    @DisplayName("radius = 5 -> circum =31.41592653589793")
    void calculateCircum() {
        //given
        double radius = 5;
        Circle circle = new Circle(radius);
        //when
        double expectedCircum = 2 * Math.PI * radius;
        double returnedCircum = circle.calculateCircum();
        //then
        assertEquals(expectedCircum, returnedCircum);
    }
}