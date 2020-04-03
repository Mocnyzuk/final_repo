package pl.accenture.algorytmy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fibonacci {

    private static List<BigInteger> calculatedSequence = new ArrayList<BigInteger>(
            Arrays.asList(
                    new BigInteger("0"),
                    new BigInteger("1")
            )
    );

    public static BigInteger fibonacciRecursion(int n) {
        if (n == 0) {
            return BigInteger.ZERO;
        } else if (n == 1) {
            return  BigInteger.ONE;
        } else {
            return new BigInteger(String.valueOf(fibonacciRecursion(n - 1).add(fibonacciRecursion(n - 2))));
        }
    }

    public static BigInteger fibonacciIter(int n) {
        if (n == 0) {
            return BigInteger.ZERO;
        } else if (n == 1) {
            return BigInteger.ONE;
        }
        BigInteger previousElement = new BigInteger("0"),
                    currentElement = new BigInteger("1"),
                       nextElement;
        for (int i = 1; i < n; i++) {
            nextElement = currentElement.add(previousElement);
            previousElement = currentElement;
            currentElement = nextElement;
        }
        return currentElement;
    }

    public static BigInteger fibonacciMemoization(int n) {
        if (n == 0) {
            return calculatedSequence.get(0);
        }else if (n == 1) {
            return calculatedSequence.get(1);
        }
        int maxElementIndex = calculatedSequence.size() - 1;
        if (maxElementIndex >= n ) {
            return calculatedSequence.get(n);
        } else {
            BigInteger previousElement = calculatedSequence.get(maxElementIndex - 1),
                        currentElement = calculatedSequence.get(maxElementIndex),
                           nextElement;
            for (int i = maxElementIndex; i < n; i++) {
                nextElement = currentElement.add(previousElement);
                previousElement = currentElement;
                currentElement = nextElement;
                calculatedSequence.add(currentElement);
            }
            return  currentElement;
        }
    }

}
