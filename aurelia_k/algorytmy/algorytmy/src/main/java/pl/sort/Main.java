package pl.sort;

public class Main {
    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] exampleArrayToSort = {100, 16, 13, 5, 2, 6, 1, 4, 3};
        final int start = 0;
        final int end = exampleArrayToSort.length - 1;
        sort.quickSort(exampleArrayToSort, start, end);

        System.out.println("Sorted array: ");
        for (int index : exampleArrayToSort) {
            System.out.print(index + ", ");
        }
    }
}
