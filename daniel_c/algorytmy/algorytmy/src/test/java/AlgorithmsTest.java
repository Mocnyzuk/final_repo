import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmsTest {

    @Test
    @DisplayName("findSecondLargest: Should return 9")
    void findSecondLargest() {
        int[] arr = {1, 3, 4, 6, 8, 9, 12};
        assertEquals(9, Algorithms.findSecondLargest(arr));
    }

    @Test
    @DisplayName("findSecondLargest: Should return 21")
    void findSecondLargest2() {
        int[] arr = {12, 51, 21, 4, 3, 6, 1};
        assertEquals(21, Algorithms.findSecondLargest(arr));
    }


    @Test
    @DisplayName("loneSum: Should return 9")
    void loneSum() {
        assertEquals(9, Algorithms.loneSum(9, 2, 2));
    }

    @Test
    @DisplayName("loneSum: Should return 0")
    void loneSum2() {
        assertEquals(0, Algorithms.loneSum(3, 3, 3));
    }

    @Test
    @DisplayName("loneSum: Should return 6")
    void loneSum3() {
        assertEquals(6, Algorithms.loneSum(3, 1, 2));
    }


    @Test
    @DisplayName("evenlySpaced: Should return true")
    void evenlySpaced() {
        assertTrue(Algorithms.evenlySpaced(2, 4, 6));
    }

    @Test
    @DisplayName("evenlySpaced: Should return false")
    void evenlySpaced2() {
        assertFalse(Algorithms.evenlySpaced(2, 2, 3));
    }

    @Test
    @DisplayName("evenlySpaced: Should return true")
    void evenlySpaced3() {
        assertTrue(Algorithms.evenlySpaced(5, 5, 5));
    }

}