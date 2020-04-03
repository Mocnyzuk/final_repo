package algorithm.sort;

import algorithm.ArrayGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSorterTest {

    @Test
    @DisplayName("if the algorithm sorts correctly an array sorted desc")
    void sortArraySortedDesc() {
        //given
        int[] arrayToSortByJavaUtil = {83, 75, 73, 64, 61, 52, 43, 20, 19, 11, 11, 6, 3, 0};
        int[] arrayToSortByAlgorithm = arrayToSortByJavaUtil.clone();
        //when
        BubbleSorter.sort(arrayToSortByAlgorithm);
        Arrays.sort(arrayToSortByJavaUtil);
        //then
        assertArrayEquals(arrayToSortByAlgorithm, arrayToSortByJavaUtil);
    }

    @Test
    @DisplayName("if the algorithm sorts correctly an array sorted asc")
    void sortArraySortedAsc() {
        //given
        int[] arrayToSortByJavaUtil = {1, 3, 7, 21, 52, 56, 63, 73, 89, 91, 94, 99};
        int[] arrayToSortByAlgorithm = arrayToSortByJavaUtil.clone();
        //when
        BubbleSorter.sort(arrayToSortByAlgorithm);
        Arrays.sort(arrayToSortByJavaUtil);
        //then
        assertArrayEquals(arrayToSortByAlgorithm, arrayToSortByJavaUtil);
    }



    @Test
    @DisplayName("if the algorithm sorts correctly an array with repeating elements")
    void sortArrayNotSortedWithRepeatingElements() {
        //given
        int[] arrayToSortByJavaUtil = {82, 2, 82, 45, 14, 14, 9, 14, 53, 2, 80, 2, 82, 14, 82, 2, 14};
        int[] arrayToSortByAlgorithm = arrayToSortByJavaUtil.clone();
        //when
        BubbleSorter.sort(arrayToSortByAlgorithm);
        Arrays.sort(arrayToSortByJavaUtil);
        //then
        assertArrayEquals(arrayToSortByAlgorithm, arrayToSortByJavaUtil);
    }

}