import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmTest {


    @Test
    @DisplayName("[12, 10, 4], [2, 20, 30] -> 40")
    void shouldReturn40() {
        //given
        int[] arrayToCheck1 = {12, 10, 4};
        int[] arrayToCheck2 = {2, 20, 30};
        int expected = 40;
        //when
        int returned = Algorithm.addHighestMultipleOf10(arrayToCheck1, arrayToCheck2);
        //then
        assertEquals(expected, returned);
    }

    @Test
    @DisplayName("[12, 11, 4], [2, 20, 31] -> 20")
    void shouldReturn20() {
        //given
        int[] arrayToCheck1 = {12, 11, 4};
        int[] arrayToCheck2 = {2, 20, 31};
        int expected = 20;
        //when
        int returned = Algorithm.addHighestMultipleOf10(arrayToCheck1, arrayToCheck2);
        //then
        assertEquals(expected, returned);
    }

    @Test
    @DisplayName("[], [2] -> 0")
    void shouldReturn0() {
        //given
        int[] arrayToCheck1 = {};
        int[] arrayToCheck2 = {2};
        int expected = 0;
        //when
        int returned = Algorithm.addHighestMultipleOf10(arrayToCheck1, arrayToCheck2);
        //then
        assertEquals(expected, returned);
    }

    @Test
    @DisplayName("[3, 2, 4, 5, 8], 2) → [2, 4]")
    void copyEvensCase1() throws Exception {
        //given
        int[] numArray = {3, 2, 4, 5, 8};
        int count = 2;
        int[] expectedArray = {2, 4};
        //when
        int[] returnedArray = Algorithm.copyEvens(numArray, count);
        //then
        assertArrayEquals(expectedArray, returnedArray);

    }

    @Test
    @DisplayName("[3, 2, 4, 5, 8], 3) → [2, 4, 8]")
    void copyEvensCase2() throws Exception {
        //given
        int[] numArray = {3, 2, 4, 5, 8};
        int count = 3;
        int[] expectedArray = {2, 4, 8};
        //when
        int[] returnedArray = Algorithm.copyEvens(numArray, count);
        //then
        assertArrayEquals(expectedArray, returnedArray);

    }
    @Test
    @DisplayName("[3], 10) → IllegalArgumentException")
    void copyEvensCase3() throws Exception {
        //given
        int[] numArray = {3};
        int count = 10;
        //then
        assertThrows(IllegalArgumentException.class, () -> Algorithm.copyEvens(numArray, count));

    }
    @Test
    @DisplayName("[3, 2], 2) → IllegalArgumentException")
    void copyEvensCase4() throws Exception {
        //given
        int[] numArray = {3,2};
        int count = 2;
        //then
        assertThrows(IllegalArgumentException.class, () -> Algorithm.copyEvens(numArray, count));

    }
}