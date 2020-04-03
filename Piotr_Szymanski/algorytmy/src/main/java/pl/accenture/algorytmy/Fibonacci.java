package pl.accenture.algorytmy;

import java.math.BigInteger;

public class Fibonacci {

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
        return BigInteger.ONE;
    }


}
