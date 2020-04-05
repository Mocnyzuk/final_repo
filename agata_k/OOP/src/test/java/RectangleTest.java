import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
    @Test
    @DisplayName("-> It's a rectangle")
    void introduceFigure() {
        //given
        String expectedIntroduction = Rectangle.RECTANGLE;
        //when
        String returnedIntroduction = new Rectangle().introduceFigure();
        //then
        assertEquals(expectedIntroduction, returnedIntroduction);

    }

    @Test
    @DisplayName("sides: 5, 1 -> area = 5")
    void calculateArea() {
        //given
        double side1 = 5;
        double side2 = 1;
        Rectangle rectangle = new Rectangle(side1, side2);
        //when
        double expectedArea = side1 * side2;
        double returnedArea = rectangle.calculateArea();
        //then
        assertEquals(expectedArea, returnedArea);
    }

    @Test
    @DisplayName("side: 5, 1 -> circum = 12")
    void calculateCircum() {
        //given
        double side1 = 5;
        double side2 = 1;
        Rectangle rectangle = new Rectangle(side1, side2);
        //when
        double expectedCircum = 2 * side1 + 2 * side2;
        double returnedCircum = rectangle.calculateCircum();
        //then
        assertEquals(expectedCircum, returnedCircum);
    }
}