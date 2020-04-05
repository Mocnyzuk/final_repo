/**
 * FigureParameterSetter class with a static method for setting values of param
 */
public class FigureParameterSetter {
    public static void setFigureParameter(Figure figure, double param1, double... param2) throws Exception {
        if (figure instanceof Circle) {

            if (param2.length > 0)
                throw new IllegalArgumentException("Too many arguments! Give only value for radius");

            ((Circle) figure).setRadius(param1);

        } else if (figure instanceof Square) {

            if (param2.length > 0)
                throw new IllegalArgumentException("Too many arguments! Give only value for one side");

            ((Square) figure).setSide(param1);

        } else if (figure instanceof Rectangle) {
            if (param2.length == 0)
                throw new IllegalArgumentException("Too few arguments! Give values for two sides");
            else if (param2.length > 1)
                throw new IllegalArgumentException("Too many arguments! Give values only for two sides");

            ((Rectangle) figure).setSideA(param1);
            ((Rectangle) figure).setSideB(param2[0]);
        }
    }
}
