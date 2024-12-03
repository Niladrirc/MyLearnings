package sorts.heap;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {11,13,7,12,16,9,24,5,10,3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int[] heap = new int[arr.length+1];
        System.arraycopy(arr, 0, heap, 1, arr.length);
        heapify(heap);
        for (int i=heap.length; i-1>0; i--) {
            heapDelete(heap, i-1);
        }
        System.arraycopy(heap, 1, arr, 0, arr.length);
    }

    private static void heapDelete(int[] heap, int size) {
        int deletedElement = heap[1];
        heap[1] = heap[size];
        int index = 1;
        while ((2*index)+1 <= size) {
            int swapIndex = heap[2*index] > heap[(2*index)+1] ? 2*index : (2*index)+1;
            if (heap[index] < heap[swapIndex]) {
                int temp = heap[index];
                heap[index] = heap[swapIndex];
                heap[swapIndex] = temp;
            }
            index = swapIndex;
        }
        heap[size] = deletedElement;
    }

    private static void heapify(int[] arr) {
        for (int i=arr.length-1; i>0; i--) {
            int childOneIndex = 2*i;
            int childTwoIndex = (2*i)+1;

            int childOne = (childOneIndex<arr.length)?arr[childOneIndex]:0;
            int childTwo = (childTwoIndex<arr.length)?arr[childTwoIndex]:0;

            if (childOne > childTwo) {
                if (arr[i] < childOne) {
                    int tmp = arr[i];
                    arr[i] = arr[childOneIndex];
                    arr[childOneIndex] = tmp;
                }
            } else {
                if (arr[i] < childTwo) {
                    int tmp = arr[i];
                    arr[i] = arr[childTwoIndex];
                    arr[childTwoIndex] = tmp;
                }
            }
        }
    }
}
