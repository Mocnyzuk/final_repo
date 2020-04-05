import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FigureParameterSetterTest {

    @Test
    void setRadiusOfCircle() throws Exception {
        //given
        Figure circle = new Circle();
        double radius = 5;
        //when
        FigureParameterSetter.setFigureParameter(circle, radius);
        //then
        assertEquals(radius, ((Circle) circle).getRadius());

    }
    @Test
    @DisplayName("throws exception when too many arguments for a circle")
    void tooManyArgsForCircle() throws Exception {
        //given
        Figure circle = new Circle();
        double radius = 5;
        double additionalArg = 0;
        //then
        assertThrows(IllegalArgumentException.class, () -> FigureParameterSetter.setFigureParameter(circle, radius, additionalArg));

    }

    @Test
    void setSideOfSquare() throws Exception {
        //given
        Figure square = new Square();
        double side = 5;
        //when
        FigureParameterSetter.setFigureParameter(square, side);
        //then
        assertEquals(side, ((Square) square).getSide());

    }
    @Test
    @DisplayName("throws exception when too many arguments for a square")
    void tooManyArgsForSquare() throws Exception {
        //given
        Figure square = new Square();
        double radius = 5;
        double additionalArg = 0;
        //then
        assertThrows(IllegalArgumentException.class, () -> FigureParameterSetter.setFigureParameter(square, radius, additionalArg));

    }

    @Test
    void setSidesOfRectangle() throws Exception {
        //given
        Figure rectangle = new Rectangle();
        double side1 = 5;
        double side2 = 10;
        //when
        FigureParameterSetter.setFigureParameter(rectangle, side1, side2);
        //then
        assertEquals(side1, ((Rectangle) rectangle).getSideA());
        assertEquals(side2, ((Rectangle) rectangle).getSideB());

    }
    @Test
    @DisplayName("throws exception when too many arguments for a rectangle")
    void tooManyArgsForRectangle() throws Exception {
        //given
        Figure rectangle = new Rectangle();
        double side1 = 5;
        double side2 = 10;
        double additionalArg = 0;
        //then
        assertThrows(IllegalArgumentException.class, () -> FigureParameterSetter.setFigureParameter(rectangle, side1, side2, additionalArg));

    }
    @Test
    @DisplayName("throws exception when too little arguments for a rectangle")
    void tooLittleArgsForRectangle() throws Exception {
        //given
        Figure rectangle = new Rectangle();
        double onlyArg = 0;
        //then
        assertThrows(IllegalArgumentException.class, () -> FigureParameterSetter.setFigureParameter(rectangle, onlyArg));

    }

}