package src.easy;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        ListNode newList = deleteDuplicates(head);

        while (newList != null) {
            System.out.print(newList.val + " ");
            newList = newList.next;
        }
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;

            } else
                temp = temp.next;
        }
        return head;
    }
}
