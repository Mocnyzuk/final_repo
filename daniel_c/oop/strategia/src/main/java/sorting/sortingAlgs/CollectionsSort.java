package sorting.sortingAlgs;

import sorting.SortingInterface;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsSort implements SortingInterface {
    @Override
    public long getAvgSortingTime(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        long time = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            list.add(arr[i]);
        }

        for (int i = 0; i < 10; i++) {
            long startTime = System.nanoTime();
            Collections.sort(list);
            long endTime = System.nanoTime();

            time = endTime - startTime;
        }

        return time / 10;
    }


}