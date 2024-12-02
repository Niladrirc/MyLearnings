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
            int index = i;
            while (index>0 && (newElement > arr[(index-1)/2])) {
                arr[index] = arr[(index-1)/2];
                index = (index-1)/2;
            }
            arr[index] = newElement;
        }
    }

    public int[] createHeap(int[] arr) {
        if (getSize() > 0) {
            System.out.println("Heap not empty. Cannot create a new Heap with given array");
            return null;
        }
        for (int i=0; i<arr.length; i++) {
            this.insert(arr[i]);
        }
        return arr;
    }

    public int delete() {
        int deletedElement = heapArray[1];

        heapArray[1] = heapArray[size];
        size -= 1;

        int index = 1;
        while ((2*index)+1 <= size) {
            int swapIndex = heapArray[2*index] > heapArray[(2*index)+1] ? 2*index : (2*index)+1;
            if (heapArray[index] < heapArray[swapIndex]) {
                int temp = heapArray[index];
                heapArray[index] = heapArray[swapIndex];
                heapArray[swapIndex] = temp;
            }
            index = swapIndex;
        }
        heapArray[size+1] = deletedElement;
        return deletedElement;
    }

    public int[] heapSort(int[] arr) {
        createHeap(arr);
        int heapSize = this.size;

        for (int i=0; i<arr.length; i++) {
            this.delete();
        }
        System.out.print("[ ");
        for (int i=1; i<=heapSize; i++) {
            if (i<heapSize)
                System.out.print(heapArray[i]+", ");
            else
                System.out.print(heapArray[i]+" ]");
        }
        System.out.println();
        return arr;
    }

    public static void main(String[] args) {
        HeapADT heap = new HeapADT();
        int[] arr = {10,20,30,25,5,40,35};
        heap.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
