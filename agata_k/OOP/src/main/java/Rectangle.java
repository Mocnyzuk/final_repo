import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Rectangle class with two fields for its sides and Figure methods implemented according to the mathematical formulas.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rectangle implements Figure {
    private double sideA = 0;
    private double sideB = 0;
    public static final String RECTANGLE=  "It's a rectangle";

    @Override
    public String introduceFigure() {
        return "It's a rectangle";
    }
    @Override
    public double calculateArea() {
        return sideA * sideB;
    }

    @Override
    public double calculateCircum() {
        return 2 * sideA + 2 * sideB;
    }
}
