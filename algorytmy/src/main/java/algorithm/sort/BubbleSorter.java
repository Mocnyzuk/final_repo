package algorithm.sort;

public class BubbleSorter {

    private BubbleSorter() {
    }

    public static void sort(int[] arrayToSort) {
        for (int i = 0; i < arrayToSort.length-1; i++) {
            for (int j = 0; j < arrayToSort.length - i - 1; j++) {
                if (arrayToSort[j] > arrayToSort[j + 1]) {
                    swapElements(arrayToSort, j, j + 1);
                }
            }
        }
    }

    static void swapElements(int[] arrayToSort, int indexOfElement1, int indexOfElement2) {
        int temp=arrayToSort[indexOfElement1];
        arrayToSort[indexOfElement1]=arrayToSort[indexOfElement2];
        arrayToSort[indexOfElement2]=temp;
    }
}
