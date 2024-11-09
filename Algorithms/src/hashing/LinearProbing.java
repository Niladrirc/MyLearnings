package hashing;

import java.util.Scanner;

public class LinearProbing {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int[] keys = { 8, 3, 6, 10, 15, 18, 4 };
        int[] hashTable = new int[10];
        for (int key : keys) {
            insert(hashTable, key);
        }
        System.out.print("Enter the key to be searched: ");
        int key = LinearProbing.input.nextInt();
        int location = searchFor(key, hashTable);

        if (location != -1) {
            System.out.println("Found at location " + location);
        } else
            System.out.println("Not found");
    }

    private static int getHash(int key, int index, int length) {
        return (key + index) % length;
    }

    private static void insert(int[] hashTable, int key) {
        int index = 0;
        index = getHash(key, index, hashTable.length);
        while (hashTable[index] != 0 && index < hashTable.length) {
            index = getHash(key, index+1, hashTable.length);
        }
        hashTable[index] = key;
    }

    private static int searchFor(int key, int[] hashTable) {
        int index = 0;
        index = getHash(key, index, hashTable.length);
        while (hashTable[index] != 0 && index < hashTable.length) {
            if (hashTable[index] == key) {
                return index;
            }
            index = getHash(key, index+1, hashTable.length);
        }
        return -1;
    }
}
