import java.util.ArrayList;
import java.util.List;

public class QuickSort {
    static List<Integer> quickSort(List<Integer> listToBeSorted) {
        if (listToBeSorted.size() <= 1) {
            return listToBeSorted;
        } else {
            List<Integer> unsorted = new ArrayList<Integer>(listToBeSorted);
            Integer pivot = unsorted.remove(0);
            List<Integer> sorted = new ArrayList();
            List<Integer> lower = new ArrayList();
            List<Integer> greater = new ArrayList<>();

            for (Integer i : listToBeSorted) {
                if (i < pivot) {
                    lower.add(i);
                } else if (i > pivot) {
                    greater.add(i);
                } else {
                    continue;
                }
            }

            lower = quickSort(lower);
            greater = quickSort(greater);

            sorted.addAll(lower);
            sorted.add(pivot);
            sorted.addAll(greater);

            return sorted;
        }
    }
}
