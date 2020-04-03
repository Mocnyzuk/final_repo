package pl.accenture.algorytmy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    @DisplayName("fibonacciRecursion test")
    void fibonacciRecursion() {
        // Given
        int expectedSequence[] = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946};
        // When
        int outputSequence[] = new int[expectedSequence.length];
        for (int i = 0; i < expectedSequence.length; i++) {
           outputSequence[i] = (Fibonacci.fibonacciRecursion(i).intValue());
        }
        // Then
        assertArrayEquals(expectedSequence, outputSequence);
    }
}