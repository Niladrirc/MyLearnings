package sorts.merge.recursive;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {11,13,7,12,16,9,24,5,10,3};

        sort(a, 0, a.length-1);

        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(a, low, mid);
            sort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    private static void merge(int[] a, int low, int mid, int high) {
        int i=low, j=mid+1, k=low;
        int[] b = new int[high+1];

        while ((i<=mid) && (j<=high)) {
            if (a[i] <= a[j])
                b[k++] = a[i++];
            else
                b[k++] = a[j++];
        }

        while (i<=mid) b[k++] = a[i++];
        while (j<=high) b[k++] = a[j++];

        for (int l=low; l<=high; l++) a[l] = b[l];
    }
}
