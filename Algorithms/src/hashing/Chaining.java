package hashing;

import utils.ListNode;

import java.util.Scanner;

public class Chaining {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int[] keys = { 8, 3, 6, 10, 15, 18, 4 };
        ListNode[] bin = new ListNode[10];
        for (int key : keys) {
            insert(bin, key);
        }
        System.out.print("Enter the key to be searched: ");
        int key = Chaining.input.nextInt();
        int location = searchFor(key, bin);

        if (location != -1) {
            System.out.println("Found at location " + location);
        } else
            System.out.println("Not found");
    }

    private static int searchFor(int key, ListNode[] bin) {
        int location = hashFunction(key);

        if (bin[location] != null) {
            ListNode current = bin[location];
            while (current != null && current.val < key) {
                current = current.next;
            }
            if (current == null) {
                return -1;
            }
            if (current.val == key) {
                return location;
            }
            return -1;
        }
        return -1;
    }

    private static void insert(ListNode[] bin, int key) {
        ListNode newNode = new ListNode(key);
        int location = hashFunction(key);

        if (bin[location] == null) {
            bin[location] = newNode;
        } else {
            ListNode temp = bin[location];
            ListNode prev = null;
            while (temp != null && temp.val < key) {
                prev = temp;
                temp = temp.next;
            }
            if (prev == null) {
                newNode.next = temp;
                bin[location] = newNode;
            } else {
                newNode.next = temp;
                prev.next = newNode;
            }
        }
    }

    private static int hashFunction(int key) {
        return key % 10;
    }
}
