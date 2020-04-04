package pl.sort;

public class Sort {
    public int[] quickSort(int array[], int low_index, int high_index) {

        int i = low_index;
        int j = high_index;
        int pivot = array[low_index + (high_index - low_index) / 2];
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swamp(array, i, j);
                i++;
                j--;
            }
        }
        if (low_index < j)
            quickSort(array, low_index, j);
        if (i < high_index)
            quickSort(array, i, high_index);
        return array;
    }


    private void swamp(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
