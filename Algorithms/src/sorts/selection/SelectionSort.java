package sorts.selection;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] A = {8,6,3,2,5,4};

        sort(A);

        System.out.println("Sorted Array: "+ Arrays.toString(A));
    }

    private static void sort(int[] a) {
        int n = a.length;
        for (int i=0; i<n; i++) {
            int j=i, k=i;
            while (j <= n-1) {
                if (a[j] < a[k])
                    k=j;
                j++;
            }
            if (k != i) {
                int temp = a[i];
                a[i] = a[k];
                a[k] = temp;
            }
        }
    }
}
