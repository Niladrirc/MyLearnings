package src;

public class FindingDuplicates {
    /**
     * Finding repeating elements in an array of size n,
     * where, the elements of the array i.e. x follows,
     *      x ∈ [0,n−1] (means 0 ≤ x ≤ n−1)
     * @param arr
     * @param size
     */
    static void printRepeating(int[] arr, int size) {
        int i;
        System.out.println("The repeating elements are : ");

        for (i = 0; i < size; i++) {
            int j = Math.abs(arr[i]);
            if (arr[j] >= 0)
                arr[j] = -arr[j];
            else
                System.out.print(j + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 3, 6, 6 };
        int arr_size = arr.length;
        printRepeating(arr, arr_size);
    }
}
