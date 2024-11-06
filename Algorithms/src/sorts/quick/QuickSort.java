package sorts.quick;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] A = {1,3,4,5,6,7,8,9};
        sort(A, 0, A.length-1);
        System.out.println(Arrays.toString(A));
    }


    private static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            sort(arr, low, pivot);
            sort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] a, int low, int high) {
        int pivot = a[low];
        int i = low, j = high;

        do {
            do { i++; } while (a[i] <= pivot);

            do { j--; } while (a[j] > pivot);

            if (i < j) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        } while (i < j);

        int tmp = a[low];
        a[low] = a[j];
        a[j] = tmp;
        return j;
    }
}
