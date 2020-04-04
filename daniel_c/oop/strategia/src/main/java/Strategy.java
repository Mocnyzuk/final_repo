import sorting.Sorting;
import sorting.SortingInterface;
import sorting.sortingAlgs.BubbleSort;
import sorting.sortingAlgs.CollectionsSort;
import sorting.sortingAlgs.QuickSort;
import sorting.sortingAlgs.SelectionSort;

import java.util.Random;

public class Strategy {

    public static void main(String[] args) {
        int[] tab99 = new int[99];
        int[] tab999 = new int[999];
        int[] tab9999 = new int[9999];

        fillArrayWithRandomNumbers(tab99);
        fillArrayWithRandomNumbers(tab999);
        fillArrayWithRandomNumbers(tab9999);

        Sorting sorting = new Sorting(tab99, tab999, tab9999);

        System.out.println("STRATEGY\n< 10x sort an array; return avg time in nanoseconds >\n");
        doSortings(sorting);
    }

    private static void doSortings(Sorting sorting) {
        SortingInterface sortingInterface;

        sortingInterface = new BubbleSort();
        sorting.doBubbleSort(sortingInterface);
        System.out.println();

        sortingInterface = new SelectionSort();
        sorting.doSelectionSort(sortingInterface);
        System.out.println();

        sortingInterface = new QuickSort();
        sorting.doQuickSort(sortingInterface);
        System.out.println();

        sortingInterface = new CollectionsSort();
        sorting.doCollectionsSort(sortingInterface);
        System.out.println();
    }

    private static void fillArrayWithRandomNumbers(int[] tab) {
        Random random = new Random();
        for (int i = 0; i < tab.length - 1; i++) {
            tab[i] = random.nextInt(99999999);
        }
    }


}