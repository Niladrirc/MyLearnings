package src.leetcode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(1);
//        l1.next.next.next = new ListNode(9);
//        l1.next.next.next.next = new ListNode(9);
//        l1.next.next.next.next.next = new ListNode(9);
//        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
//        l2.next.next.next = new ListNode(9);

        Solution solution = new Solution();
        ListNode l3 = solution.addTwoNumbers(l1, l2);

        while (l3 != null) {
            System.out.print(l3.val + ", ");
            l3 = l3.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int newVal = 0, prevCarry = 0, carry = 0;
        ListNode head = null;
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            newVal = l1.val + l2.val + prevCarry;
            if (newVal > 9) {
                carry = newVal/10;
                newVal = newVal%10;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(newVal);
            prevCarry = carry;

            if (head == null) {
                head = node;
                temp = head;
            } else {
                temp.next = node;
                temp = temp.next;
            }
            l1 = l1.next; l2 = l2.next;
        }

        while (l1 != null) {
            newVal = l1.val + prevCarry;
            if (newVal > 9) {
                carry = newVal/10;
                newVal = newVal%10;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(newVal);
            prevCarry = carry;
            if (head == null) {
                head = node;
            } else {
                temp.next = node;
                temp = temp.next;
            }
            l1 = l1.next;
        }

        while (l2 != null) {
            newVal = l2.val + prevCarry;
            if (newVal > 9) {
                carry = newVal/10;
                newVal = newVal%10;
            } else {
                carry = 0;
            }
            ListNode node = new ListNode(newVal);
            prevCarry = carry;
            if (head == null) {
                head = node;
            } else {
                temp.next = node;
                temp = temp.next;
            }
            l2 = l2.next;
        }

        if (prevCarry > 0) {
            temp.next = new ListNode(prevCarry);
        }

        return head;
    }
}
