package sort;

public class QuickSort {
    static int partition(int[] array, int start, int end) {
        int pivot = array[(start + end) / 2];

        while (start <= end) {
            while (array[start] < pivot) start++;
            while (array[end] > pivot) end--;
            if (start <= end) {
                int tmp = array[start];
                array[start] = array[end];
                array[end] = tmp;
                start++;
                end--;
            }
        }
        return start;
    }

    static int[] quickSort(int[] array, int start, int end) {
        int p = partition(array, start, end);
        if (start < p - 1) {
            quickSort(array, start, p - 1);
        }

        if (p < end) {
            quickSort(array, p, end);
        }

        return array;
    }
}
