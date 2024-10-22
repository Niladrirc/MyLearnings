package src;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int len = arr.length;
        System.out.println("Array Before Reverse is : " + Arrays.toString(arr));

        reverseArray(arr, len);

        System.out.println("Array After Reverse is: " + Arrays.toString(arr));
    }

    private static void reverseArray(int[] arr, int len) {
        int start = 0, end = len-1;
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start ++;
            end --;
        }
    }
}
