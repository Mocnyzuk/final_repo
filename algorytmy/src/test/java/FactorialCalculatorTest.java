import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest {

    @Test
    @DisplayName("4 -> 24")
    void countFactorial() {

        //given
        int expectedValue = 24;
        //when
        int returnedValue = FactorialCalculator.countFactorial(4);
        //then
        assertEquals(expectedValue, returnedValue);
    }
}