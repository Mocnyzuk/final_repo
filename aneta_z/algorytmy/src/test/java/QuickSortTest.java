import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuickSortTest {
    @Test
    void quickSort() {
        //given
        List<Integer> unorderedList = new ArrayList<>(Arrays.asList(33, 0, 67, 5, 8, 9, -1, 29, 13));
        List<Integer> expectedList = new ArrayList<>(Arrays.asList(-1, 0, 5, 8, 9, 13, 29, 33, 67));

        //when
        List<Integer> sortedList = QuickSort.quickSort(unorderedList);

        //then
        assertEquals(expectedList, sortedList);
    }
}

