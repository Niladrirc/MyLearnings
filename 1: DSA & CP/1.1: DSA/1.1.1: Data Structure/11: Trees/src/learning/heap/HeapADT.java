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

    public int delete() {
        int deletedElement = heapArray[1];

        heapArray[1] = heapArray[size];
        size -= 1;

        int index = 1;
        while (index <= size) {
            int swapIndex = heapArray[2*index] > heapArray[2*(index+1)] ? 2*index : 2*(index+1);
            if (heapArray[index] < heapArray[swapIndex]) {
                int temp = heapArray[index];
                heapArray[index] = heapArray[swapIndex];
                heapArray[swapIndex] = temp;
            }
            index = swapIndex;
        }

        return deletedElement;
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
