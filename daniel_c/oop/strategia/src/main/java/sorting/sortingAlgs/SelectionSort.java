package sorting.sortingAlgs;

import sorting.SortingInterface;

public class SelectionSort implements SortingInterface {
    @Override
    public long getAvgSortingTime(int[] arr) {
        long time, result = 0;

        for (int a = 0; a < 10; a++) {
            long startTime = System.nanoTime();
            int arrLength = arr.length;

            for (int i = 0; i < arrLength; i++) {
                int min = arr[i];
                int index = i;

                for (int j = i; j < arrLength; j++) {
                    if (arr[j] < min) {
                        index = j;
                    }
                }
                arr[index] = arr[i];
                arr[i] = min;
            }
            long endTime = System.nanoTime();
            time = endTime - startTime;
            result += time;
        }

        return result / 10;
    }


}
