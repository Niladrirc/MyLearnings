package src.java.datastructures.hashtable;

import src.learning.StackADT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashTable {
    private final Node[] dataMap;
    private final int size = 7;

    static class Node {
        private String key;
        private int value;
        private Node next;

        public Node(String key, int value) {
            this.value = value;
            this.key = key;
        }

    }

    public HashTable() {
        this.dataMap = new Node[size];
    }

    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            if(dataMap[i] != null) {
                Node temp = dataMap[i];
                while (temp != null) {
                    System.out.println("   {" + temp.key + ", " + temp.value + "}");
                    temp = temp.next;
                }
            }
        }
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyArray = key.toCharArray();
        for (int i = 0; i < keyArray.length; i++) {
            int asciiValue = keyArray[i];
            hash = (hash + asciiValue * 23) % dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value) {
        int hashIndex = hash(key);
        Node newNode = new Node(key, value);
        if (dataMap[hashIndex] == null) {
            dataMap[hashIndex] = newNode;
        }
        else {
            Node current = dataMap[hashIndex];
            Node tail = null;
            while (current != null) {
                tail = current;
                current = current.next;
            }
            tail.next = newNode;
            newNode.next = current;
        }
    }

    public int get(String key) {
        int hashIndex = hash(key);

        if (dataMap[hashIndex] != null) {
            Node current = dataMap[hashIndex];
            while (current != null) {
                if (current.key == key) {
                    return current.value;
                }
                current = current.next;
            }
        }
        return 0;
    }

    public ArrayList keys() {
        ArrayList<String> keys = new ArrayList<>();
        for (Node current: dataMap) {
            if (current != null) {
                while (current != null) {
                    keys.add(current.key);
                    current = current.next;
                }
            }
        }
        return keys;
    }
}
