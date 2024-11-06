package src.easy;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(1);

        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = mergeTwoLists(list1, list2);
        while (list3 != null) {
            System.out.println(list3.val);
            list3 = list3.next;
        }
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
        if (list1 == null) {
            return list2;
        }
        return list1;
    }
}
