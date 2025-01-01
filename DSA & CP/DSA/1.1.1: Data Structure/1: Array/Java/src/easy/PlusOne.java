package src.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlusOne {
    public static void main(String[] args) {
        int[] A = {9, 9, 9};

        System.out.println("Provided large integer: ");
        for(int i:A) {
            System.out.print(i);
        }
        System.out.println();

        A = plusOne(A);

        System.out.println("New large integer after adding one: ");
        for(int i:A) {
            System.out.print(i);
        }
    }

    private static int[] plusOne(int[] a) {
        int len = a.length;
        for(int i = len - 1; i >= 0; i--) {
            if (a[i] < 9) {
                a[i] += 1;
                return a;
            }
            a[i] = 0;
        }
        int[] newArray = new int[len + 1];
        newArray[0] = 1;
        System.arraycopy(a, 0, newArray, 1, len);
        return newArray;
    }
}
