import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FigureFactoryTest {

    @Test
    @DisplayName("Returns instance of circle")
    void getCircle() {
        //when
        Figure circle = FigureFactory.getFigure(FigureEnum.CIRCLE);
        //then
        assertTrue(circle instanceof Circle);
    }

    @Test
    @DisplayName("Returns instance of square")
    void getSquare() {
        //when
        Figure square = FigureFactory.getFigure(FigureEnum.SQUARE);
        //then
        assertTrue(square instanceof Square);
    }

    @Test
    @DisplayName("Returns instance of rectangle")
    void getRectangle() {
        //when
        Figure rectangle = FigureFactory.getFigure(FigureEnum.RECTANGLE);
        //then
        assertTrue(rectangle instanceof Rectangle);
    }
}