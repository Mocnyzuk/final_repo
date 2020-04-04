package pl.accenture;

import java.util.ArrayList;
import java.util.List;


public class Sort {
    /**
     * Simple sorting method with time complexity O(n^2) and memory O(1)
     * @param list List to sort
     * @param <T> Type of elements in list which implements Comparable
     * @return New sorted list
     */
    public static <T extends Comparable<T>> List<T> bubbleSort(List<T> list){
        int size = list.size();
        T temp;
        List<T> sortedList = new ArrayList<>(list);

        for(int i = 0; i < size; i++) {
            for (int j = 1; j < size; j++) {
                if (sortedList.get(j - 1).compareTo(sortedList.get(j)) > 0) {
                    temp = sortedList.get(j - 1);
                    sortedList.set(j - 1, sortedList.get(j));
                    sortedList.set(j, temp);
                }
            }
        }
        return sortedList;
    }
}


