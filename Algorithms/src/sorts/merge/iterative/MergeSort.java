package sorts.merge.iterative;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {11,13,7,12,16,9,24,5,10,3};

        sort(a);

        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a) {
        int pass;
        for (pass = 2; pass <= a.length; pass*=2) {
            for (int i=0; i+pass-1<a.length; i+=pass) {
                int low = i;
                int high = i+pass-1;
                int mid = (low + high) / 2;
                mergeSort(a, low, mid, high);
            }
        }

        if (pass/2 < a.length) {
            mergeSort(a, 0, (pass/2)-1, a.length-1);
        }
    }

    private static void mergeSort(int[] a, int low, int mid, int high) {
        int i = low, j = mid+1, k = low;
        int[] b = new int[high+1];

        while ( (i<=mid) && (j<=high) ) {
            if (a[i] < a[j]) {
                b[k++] = a[i++];
            } else {
                b[k++] = a[j++];
            }
        }

        while (i <= mid) b[k++] = a[i++];
        while (j <= high) b[k++] = a[j++];

        System.arraycopy(b, low, a, low, high-low+1);
    }
}
