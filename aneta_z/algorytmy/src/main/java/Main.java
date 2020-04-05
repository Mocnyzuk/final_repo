import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> listToSort = new ArrayList<>(Arrays.asList(33, 0, 67, 5, 8, 9, -1, 29, 13));
        List<Integer> sortedList = QuickSort.quickSort(listToSort);
        System.out.println("Sorted list of: "
                + listToSort
                + " presents as below: "
                + sortedList);
    }
}