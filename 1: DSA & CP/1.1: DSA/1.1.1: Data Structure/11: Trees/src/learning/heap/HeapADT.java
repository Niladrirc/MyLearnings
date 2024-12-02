package src.learning.heap;

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

    public void createHeap(int[] arr) {
        if (getSize() != 0) {
            System.out.println("Heap already has some elements.");
        }
    }

    public static void main(String[] args) {
        HeapADT heap = new HeapADT();
        heap.insert(10);
        heap.insert(20);
        heap.insert(30);
        heap.insert(40);
    }
}
