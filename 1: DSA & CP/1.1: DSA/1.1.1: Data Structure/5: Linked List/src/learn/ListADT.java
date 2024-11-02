package src.learn;

import java.util.List;

public class ListADT {
    private ListNode head;
    private ListNode tail;


    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        ListADT listADT = new ListADT();
        listADT.createList(A);
        listADT.display();

        System.out.println("Number of nodes in the list: "+listADT.nodeCount());
    }

    public ListNode createList(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            ListNode newNode = new ListNode(arr[i]);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    public void display() {
        if (head == null) {
            System.err.println("List is empty!");
        }

        ListNode temp = head;
        System.out.print("List: [ ");
        while (temp.next.next != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
        System.out.print(temp.next.data+" ]");
        System.out.println();
    }

    public void display(ListNode head) {
        if (head == null) {
            System.err.println("List is empty!");
        }

        ListNode temp = head;
        System.out.print("List: [ ");
        while (temp.next.next != null) {
            System.out.print(temp.data + ", ");
            temp = temp.next;
        }
        System.out.print(temp.next.data+" ]");
        System.out.println();
    }

    public int nodeCount(ListNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + nodeCount(node.next);
    }

    public int nodeCount() {
        if (head == null) {
            return 0;
        }
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
