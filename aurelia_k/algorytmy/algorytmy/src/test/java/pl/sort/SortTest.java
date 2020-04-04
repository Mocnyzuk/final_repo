package pl.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    @Test
    @DisplayName("{100, 16, 13, 5, 2, 6, 1, 4, 3} -> {1, 2, 3, 4, 5, 6, 13, 16, 100} ")
    void quickSort() {
        //given
        Sort sort = new Sort();
        int[] exampleArrayToSort = {100, 16, 13, 5, 2, 6, 1, 4, 3};
        int[] expectedSortedArray = {1, 2, 3, 4, 5, 6, 13, 16, 100};
        final int start = 0;
        final int end = exampleArrayToSort.length - 1;
        //when
        int[] result = sort.quickSort(exampleArrayToSort, start, end);
        //then
        assertArrayEquals( expectedSortedArray, result);
    }
}