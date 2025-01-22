package sorts.bubble;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] A = {8,5,7,3,10};
        sort(A);
        System.out.println(Arrays.toString(A));
    }

    private static void sort(int[] a) {
        int n = a.length;
        boolean swapped;

        for (int i = 0; i < n; i++) {
            swapped = false;
            for (int j = 0; j < n-1-i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
}
