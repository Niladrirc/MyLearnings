package src.easy;

import java.util.LinkedList;

public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
//        head.next.next.next = new ListNode(-4);
//        head.next.next.next.next = head.next;

        if (hasCycle(head))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }
}
