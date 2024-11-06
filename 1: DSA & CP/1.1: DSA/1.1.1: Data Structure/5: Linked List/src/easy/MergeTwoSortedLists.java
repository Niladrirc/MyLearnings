package src.easy;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(1);

        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = mergeTwoListsIterative(list1, list2);
        while (list3 != null) {
            System.out.print(list3.val+ " ");
            list3 = list3.next;
        }
    }

    private static ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list1.next = mergeTwoListsRecursive(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoListsRecursive(list1, list2.next);
                return list2;
            }
        }
        if (list1 == null) {
            return list2;
        }
        return list1;
    }

    private static ListNode mergeTwoListsIterative(ListNode list1, ListNode list2) {
        ListNode list3 = new ListNode(), last = list3;
        if (list1.val < list2.val) {
            list3 = last = list1;
            list1 = list1.next;
        } else {
            list3 = last = list2;
            list2 = list2.next;
        }
        last.next = null;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                last.next = list1;
                last = list1;
                list1 = list1.next;
            } else {
                last.next = list2;
                last = list2;
                list2 = list2.next;
            }
            last.next = null;
        }
        if (list1 != null) {
            last.next = list1;
        } else {
            last.next = list2;
        }

        return list3;
    }
}
