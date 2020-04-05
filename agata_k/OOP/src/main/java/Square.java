import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Square class with side field and Figure interface methods implemented according to the mathematical formulas.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Square implements Figure {
    private double side = 0;
    public static final String SQUARE=  "It's a square";

    @Override
    public String introduceFigure() {
        return SQUARE;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public double calculateCircum() {
        return 4 * side;
    }
}
