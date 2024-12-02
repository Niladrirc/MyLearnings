package sorts.insertion;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] A = {8, 5, 7, 3, 2};

        sort(A);

        System.out.println("Sorted Array: "+ Arrays.toString(A));
    }

    private static void sort(int[] a) {
        int n = a.length;

        for (int i = 1; i < n; i++) {
            int j = i-1; int target = a[i];
            while (j>=0 && a[j]>target) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = target;
        }
    }
}
