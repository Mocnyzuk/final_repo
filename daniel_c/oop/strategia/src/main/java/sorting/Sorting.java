package sorting;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Sorting {
    int[] tab99;
    int[] tab999;
    int[] tab9999;

    public void doBubbleSort(SortingInterface sortingInterface) {
        System.out.println("BubbleSort:");

        doSort(sortingInterface, tab99);
        doSort(sortingInterface, tab999);
        doSort(sortingInterface, tab9999);
    }

    public void doSelectionSort(SortingInterface sortingInterface) {
        System.out.println("SelectionSort:");

        doSort(sortingInterface, tab99);
        doSort(sortingInterface, tab999);
        doSort(sortingInterface, tab9999);
    }

    public void doQuickSort(SortingInterface sortingInterface) {
        System.out.println("QuickSort:");

        doSort(sortingInterface, tab99);
        doSort(sortingInterface, tab999);
        doSort(sortingInterface, tab9999);
    }

    public void doCollectionsSort(SortingInterface sortingInterface) {
        System.out.println("CollectionsSort:");

        doSort(sortingInterface, tab99);
        doSort(sortingInterface, tab999);
        doSort(sortingInterface, tab9999);
    }

    private static void doSort(SortingInterface sortingInterface, int[] arr) {
        System.out.println(arr.length + " elements: " + sortingInterface.getAvgSortingTime(arr) + "ns");
    }

}
