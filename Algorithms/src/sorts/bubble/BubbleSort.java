package sorts.bubble;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] A = {8,5,7,3,2};
        sort(A);
        System.out.println(Arrays.toString(A));
    }

    private static void sort(int[] a) {
        int n = a.length;
        boolean swapped;

        for (int i = 1; i < n; i++) {
            swapped = false;
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j + 1]) {
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
