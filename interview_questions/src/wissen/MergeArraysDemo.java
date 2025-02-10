package wissen; /******************************************************************************

 Given two sorted arrays, the task is to merge them in a sorted manner.

 Input: arr1[] = { 1, 3, 4, 5}, arr2[] = {2, 4, 6, 8}
 Output: arr3[] = {1, 2, 3, 4, 4, 5, 6, 8}

 Input: arr1[] = { 5, 8, 9}, arr2[] = {4, 7, 8}
 Output: arr3[] = {4, 5, 7, 8, 8, 9}

 *******************************************************************************/
import java.util.*;

public class MergeArraysDemo {
    public static void main(String[] args) {
        int[] arr1 = {5, 8, 9};

        int[] arr2 = {4, 7, 8};


        int[] arr3 = mergeArrays(arr1, arr2);

        System.out.println("Array after merging - " + Arrays.toString(arr3));

    }

    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int i=0, j=0, k=0;
        int[] result = new int[arr1.length + arr2.length];

        while (i<arr1.length && j<arr2.length) {
            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) { result[k++] = arr1[i++]; }
        while (j < arr2.length) { result[k++] = arr2[j++]; }

        return result;
    }

    public static int[] mergeArraysWithoutDuplicates(int[] arr1, int[] arr2) {
        HashSet<Integer> set1 = new HashSet<>(Arrays.stream(arr1).boxed().toList());
        HashSet<Integer> set2 = new HashSet<>(Arrays.stream(arr2).boxed().toList());

        set1.addAll(set2);

        return set1.stream().sorted().mapToInt(Number::intValue).toArray();
    }

}
