package sorting.sortingAlgs;

import sorting.SortingInterface;

public class QuickSort implements SortingInterface {
    @Override
    public long getAvgSortingTime(int[] arr) {
        long time, result = 0;

        for (int powtorz = 0; powtorz < 10; powtorz++) {
            long startTime = System.nanoTime();
            quickSortAlgorithm(arr, 0, arr.length - 1);
            long endTime = System.nanoTime();

            time = endTime - startTime;
            result += time;
        }

        return result / 10;
    }

    private static void quickSortAlgorithm(int[] arr, int arg1, int arg2) {
        int i = arg1, j = arg2, h;
        int x = arr[(arg1 + arg2) / 2];

        do {
            while (arr[i] < x) {
                i++;
            }
            while (arr[j] > x) {
                j--;
            }
            if (i <= j) {
                h = arr[i];
                arr[i] = arr[j];
                arr[j] = h;
                i++;
                j--;
            }
        } while (i <= j);

        if (x < j) {
            quickSortAlgorithm(arr, x, j);
        }

        if (i < arg2) {
            quickSortAlgorithm(arr, i, arg2);
        }

    }


}
