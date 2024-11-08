package sorts.count;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] a = {6,3,9,10,15,6,8,12,3,6};

        sort(a);

        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a) {
        int n = a.length;
        int max = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        int[] H = new int[max+1];
        for (int i = 0; i < n; i++) {
            H[a[i]]++;
        }

        int index = 0;
        for (int i = 0; i < H.length; i++) {
            if (H[i] > 0) {
                for (int j = 1; j <= H[i]; j++) {
                    a[index++] = i;
                }
            }
        }
    }
}
