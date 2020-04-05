/**
 * FigureFactory class provides an implementation of a factory design pattern
 */
public class FigureFactory {

    /**
     * method returning a variety of Figure types
     *
     * @param figureEnum criteria of a FigureEnum type, that specifie a Figure instance to be returned
     * @return Figure of a specified type
     */
    public static Figure getFigure(FigureEnum figureEnum) {
        switch (figureEnum) {
            case CIRCLE: {
                return new Circle();
            }
            case RECTANGLE: {
                return new Rectangle();
            }
            case SQUARE: {
                return new Square();
            }
            default: {
                return null;
            }
        }
    }
}