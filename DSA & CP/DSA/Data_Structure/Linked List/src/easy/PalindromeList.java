package src.easy;

import java.util.Stack;

public class PalindromeList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(1);

        if (isPalindrome(head))
            System.out.println("Palindrome");
        else
            System.out.println("Not a palindrome");
    }

    // For faster approach use arrays
    private static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        boolean isPalindrome = true;
        while (!stack.isEmpty()) {
            if (head.val != stack.peek().val) {
                isPalindrome = false;
                break;
            }
            head = head.next;
            stack.pop();
        }
        return isPalindrome;
    }
}
