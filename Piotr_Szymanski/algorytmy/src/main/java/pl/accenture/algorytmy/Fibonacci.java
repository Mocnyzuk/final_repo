package pl.accenture.algorytmy;

import java.math.BigInteger;
import java.util.List;

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

    }
}
