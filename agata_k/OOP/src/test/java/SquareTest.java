import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    @DisplayName("-> It's a square")
    void introduceFigure() {
        //given
        String expectedIntroduction = Square.SQUARE;
        //when
        String returnedIntroduction = new Square().introduceFigure();
        //then
        assertEquals(expectedIntroduction, returnedIntroduction);

    }

    @Test
    @DisplayName("side = 5 -> area = 25")
    void calculateArea() {
        //given
        double side = 5;
        Square square = new Square(side);
        //when
        double expectedArea = side * side;
        double returnedArea = square.calculateArea();
        //then
        assertEquals(expectedArea, returnedArea);
    }

    @Test
    @DisplayName("side = 5 -> circum = 20")
    void calculateCircum() {
        //given
        double side = 5;
        Square square = new Square(side);
        //when
        double expectedCircum = 4 * side;
        double returnedCircum = square.calculateCircum();
        //then
        assertEquals(expectedCircum, returnedCircum);
    }
}