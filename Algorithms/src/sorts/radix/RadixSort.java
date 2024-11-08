package sorts.radix;

import utils.ListNode;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] a = {6,3,9,10,15,6,8,12,3,6};

        sort(a);

        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a) {
        int n = a.length, max = a[0];

        for (int i = 1; i < n; i++) {
            if (a[i] > max) max = a[i];
        }

        int divisor = 1;
        ListNode[] bin = new ListNode[10];

        while (divisor < max) {

            // Populate the bin[]
            for (int element : a) {
                int digit = (element / divisor) % 10;
                ListNode node = new ListNode(element);
                if (bin[digit] == null) {
                    bin[digit] = node;
                } else {
                    ListNode temp = bin[digit];
                    while (temp.next != null) temp = temp.next;
                    temp.next = node;
                }
            }

            // Empty out the bin[]
            int index = 0;
            for (int i = 0; i < 10; i++) {
                if (bin[i] != null) {
                    ListNode temp = bin[i];
                    while (temp != null) {
                        a[index++] = temp.val;
                        temp = temp.next;
                    }
                }
                bin[i] = null;
            }

            divisor *= 10;
        }
    }
}
