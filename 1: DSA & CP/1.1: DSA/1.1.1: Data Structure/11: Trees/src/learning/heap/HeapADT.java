package src.learning.heap;

import java.util.Arrays;

public class HeapADT {
    private int[] heapArray;
    private int size;

    public HeapADT() {
        heapArray = new int[10];
        size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public void insert(int value) {
        if (size == heapArray.length) {
            int[] newArray = new int[heapArray.length * 2];
            System.arraycopy(heapArray, 0, newArray, 0, heapArray.length);
        }
        heapArray[size+1] = value;
        readjustHeap();
    }

    private void readjustHeap() {
        int temp = heapArray[size+1];
        int index = size + 1;
        int parent = index / 2;
        while (parent > 0 && temp > heapArray[parent]) {
            heapArray[index] = heapArray[parent];
            index = index/2;
            parent = index/2;
        }
        heapArray[index] = temp;
        size += 1;
    }

    public void createHeapInPlace(int[] arr) {
        for (int i=1; i<arr.length; i++) {
            int newElement = arr[i];
            int index = i-1;
            while ((index/2)>0 && (newElement > arr[index/2])) {
                int correctedIndex = 
                arr[index+1] = arr[(index+1)/2];
                index /= 2;
            }
            arr[index] = newElement;
        }
    }

    public static void main(String[] args) {
        HeapADT heap = new HeapADT();
        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        heap.insert(40);

        int[] arr = {10,20,30,25,5,40,35};
        heap.createHeapInPlace(arr);
        System.out.println(Arrays.toString(arr));
    }
}
