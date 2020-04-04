package sorting.sortingAlgs;

import sorting.SortingInterface;

public class BubbleSort implements SortingInterface {
    @Override
    public long getAvgSortingTime(int[] arr) {
        long time, result = 0;

        for (int i = 0; i < 10; i++) {
            long startTime = System.nanoTime();
            int temp;
            boolean change = true;

            while (change) {
                change = false;

                for (int j = 0; j < arr.length - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        temp = arr[j + 1];
                        arr[j + 1] = arr[j];
                        arr[j] = temp;
                        change = true;
                    }
                }
            }

            long endTime = System.nanoTime();
            time = endTime - startTime;
            result += time;
        }

        return result/10;
    }


}
