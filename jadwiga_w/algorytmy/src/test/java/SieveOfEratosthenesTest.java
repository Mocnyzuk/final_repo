import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SieveOfEratosthenesTest {

    @Test
    @DisplayName("All prime numbers up to 0, should return empty List")
    void findAllPrimeNumbersUpToZero() {
        List<Integer> primeUptoZero = SieveOfEratosthenes.findAllPrimeNumbersUpToLimit(0);
        assertEquals(0, primeUptoZero.size());
    }

    @Test
    @DisplayName("All prime numbers up to 1, should return empty List")
    void findAllPrimeNumbersUpToOne() {
        List<Integer> primeUptoOne = SieveOfEratosthenes.findAllPrimeNumbersUpToLimit(1);
        assertEquals(0, primeUptoOne.size());
    }

    @Test
    @DisplayName("All prime numbers up to 2, should return List with one integer - 2")
    void findAllPrimeNumbersUpToTwo() {
        List<Integer> primeUptoTwo = SieveOfEratosthenes.findAllPrimeNumbersUpToLimit(2);
        assertEquals(1, primeUptoTwo.size());
        assertTrue(primeUptoTwo.contains(2));
    }

    @Test
    @DisplayName("All prime numbers up to 31, should return list.size() = 11")
    void findAllPrimeNumbersUpTo31() {
        List<Integer> primeUpto31 = SieveOfEratosthenes.findAllPrimeNumbersUpToLimit(31);
        assertEquals(11, primeUpto31.size());
        assertTrue(primeUpto31.containsAll(List.of(2,3,5,7,11,13,17,19,23,29,31)));
    }

    @Test
    @DisplayName("All prime numbers up to 100, should return list.size() = 25")
    void findAllPrimeNumbersUpTo100() {
        List<Integer> primeUpto100 = SieveOfEratosthenes.findAllPrimeNumbersUpToLimit(100);
        assertEquals(25, primeUpto100.size());
    }

    @Test
    @DisplayName("All prime numbers up to 100, should return list.size() = 168")
    void findAllPrimeNumbersUpTo1000() {
        List<Integer> primeUpto100 = SieveOfEratosthenes.findAllPrimeNumbersUpToLimit(1000);
        assertEquals(168, primeUpto100.size());
    }


}