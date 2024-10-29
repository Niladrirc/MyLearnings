package src.study;

import java.util.Arrays;
import java.util.Scanner;

class Array {
    private int length;
    private int size;
    private int[] array;

    public Array(int size, int[] array) {
        this.length = 0;
        this.size = size;
        this.array = array;
    }

    public int getLength() {
        return this.length;
    }

    public int getSize() {
        return this.size;
    }

    public int[] getArray() {
        return array;
    }

    public void display() {
        System.out.println(Arrays.toString(this.array));
    }

    public void addElement(int value) {
        if (this.length == this.size) {
            throw new ArrayIndexOutOfBoundsException("Array is full");
        }
        this.array[this.length] = value;
        this.length++;
    }

    public void insertWithReplace(int index, int value) {
        if (index >= this.size) {
            throw new ArrayIndexOutOfBoundsException("Provided index out of bounds");
        }
        this.array[index] = value;
        this.length++;
        if (index > this.length) {
            for (int i = length; i < index; i++) {
                this.array[i] = 0;
            }
        }
    }

    public void insertWithoutReplace(int index, int value) {
        if (index >= this.size) {
            throw new ArrayIndexOutOfBoundsException("Provided index out of bounds");
        }

        if (index < this.length) {
            for (int i=length; i>index; i--) {
                array[i] = array[i-1];
            }
        } else {
            for (int i = length; i < index; i++) {
                this.array[i] = 0;
            }
        }
        this.array[index] = value;
        this.length++;
    }

    public int removeElement(int index) {
        if (index >= this.length) {
            throw new ArrayIndexOutOfBoundsException("Provided index out of bounds");
        }
        for (int i = index; i < this.length; i++) {
            array[i] = array[i+1];
        }
        this.length--;
        return array[index];
    }

    public int binarySearchLoop(int value) {
        int low = 0, high = this.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (this.array[mid] == value) {
                return mid;
            } else if (this.array[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int binarySearch(int value, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (this.array[mid] == value) {
            return mid;
        } else if (this.array[mid] > value) {
            return binarySearch(value, low, mid - 1);
        } else {
            return binarySearch(value, mid + 1, high);
        }
    }

    public int get(int index) {
        if (index >= this.length) {
            throw new ArrayIndexOutOfBoundsException("Provided index out of bounds");
        }
        return this.array[index];
    }

    public int min() {
        int min = this.array[0];
        for (int i = 0; i < this.length; i++) {
            if (this.array[i] < min) {
                min = this.array[i];
            }
        }
        return min;
    }

    public int max() {
        int max = this.array[0];
        for (int i = 0; i < this.length; i++) {
            if (this.array[i] > max) {
                max = this.array[i];
            }
        }
        return max;
    }

    public int[] reverse() {
        int[] reverse = new int[this.length];
        System.arraycopy(this.array, 0, reverse, 0, this.length);
        int low = 0, high = this.length - 1;
        while (low < high) {
            reverse[low] = reverse[high];
            low++; high--;
        }
        return reverse;
    }

    public int[] reverseInPlace() {
        int low = 0, high = this.length - 1;
        while (low < high) {
            array[low] = array[high];
            low++; high--;
        }
        return array;
    }

    public int[] leftShift() {
        for (int i = 0; i < length; i++) {
            array[i] = array[i+1];
        }
        length--;
        return array;
    }

    public int[] rightShift() {
        if (length == size) {
            throw new ArrayIndexOutOfBoundsException("Array is full. Cannot shift array to right");
        }
        for (int i = length; i > 0; i++) {
            array[i] = array[i-1];
        }
        length++;
        array[0] = 0;

        return array;
    }

    public int[] leftRotate() {
        int leftMostElement = this.array[0];
        for (int i = 1; i < length; i++) {
            array[i-1] = array[i];
        }
        array[length-1] = leftMostElement;
        return array;
    }

    public int[] rightRotate() {
        int rightMostElement = this.array[length-1];
        for (int i = length-1; i>0; i--) {
            array[i] = array[i-1];
        }
        array[0] = rightMostElement;
        return array;
    }

    public boolean isSorted() {
        for (int i = 0; i < this.length; i++) {
            if (this.array[i] > this.array[i+1]) {
                return false;
            }
        }
        return true;
    }

    public void sortInsert(int value) throws Exception {
        if (!this.isSorted()) {
            throw new Exception("Array is not sorted. This method is not allowed");
        }
        if (length == size) {
            throw new ArrayIndexOutOfBoundsException("Array is full. Cannot insert new element");
        }
        int index = length-1;
        while (value > array[index]) {
            index--;
        }
        array[index] = value;
    }

    public int[] merge(Array newArray) throws Exception {
        if (isSorted() && newArray.isSorted()) {
            return mergeWithSorting(newArray);
        } else {
            return append(newArray);
        }
    }

    private int[] mergeWithSorting(Array newArray) throws Exception {
        int[] mergedArray = new int[newArray.length + this.length];
        int thisArrayIndex = 0, newArrayIndex = 0, mergedArrayIndex = 0;
        while (thisArrayIndex<newArray.length && newArrayIndex<mergedArray.length) {
            if (array[thisArrayIndex] > array[newArrayIndex]) {
                mergedArray[mergedArrayIndex] = array[newArrayIndex];
                mergedArrayIndex++;
                newArrayIndex++;
            } else if (array[thisArrayIndex] < array[newArrayIndex]) {
                mergedArray[mergedArrayIndex] = array[thisArrayIndex];
                mergedArrayIndex++;
                thisArrayIndex++;
            } else {
                mergedArray[mergedArrayIndex] = array[thisArrayIndex];
                mergedArrayIndex++;
                thisArrayIndex++;
                mergedArray[mergedArrayIndex] = array[newArrayIndex];
                mergedArrayIndex++;
                newArrayIndex++;
            }
        }
        if (thisArrayIndex < length) {
            for (int i = thisArrayIndex; i < length; i++) {
                mergedArray[mergedArrayIndex] = array[i];
                mergedArrayIndex++;
            }
        }
        if (newArrayIndex < length) {
            for (int i = newArrayIndex; i < length; i++) {
                mergedArray[mergedArrayIndex] = array[i];
                mergedArrayIndex++;
            }
        }

        return mergedArray;
    }


    private int[] append(Array newArray) {
        int[] mergedArray = new int[newArray.length + this.length];
        System.arraycopy(array, 0, mergedArray, 0, newArray.length);
        System.arraycopy(newArray.getArray(), 0, mergedArray, newArray.length, newArray.length);
        return mergedArray;
    }
}

public class ArrayADT {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter array length: ");
        int n = input.nextInt();

        int[] arr = new int[n];
    }
}
