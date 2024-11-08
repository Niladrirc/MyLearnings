package sorts.bin;

import utils.ListNode;

import java.util.Arrays;

public class BinSort {
    public static void main(String[] args) {
        int[] a = { 6,3,9,10,15,6,8,12,3,6 };
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void sort(int[] a) {
        int n = a.length, max = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] > max) max = a[i];
        }

        ListNode[] bin = new ListNode[max + 1];

        for (int i = 0; i < n; i++) {
            ListNode node = new ListNode(a[i]);
            if ( bin[a[i]] == null ) {
                bin[a[i]] = node;
            }
            else {
                ListNode temp = bin[a[i]];
                while (temp.next != null) temp = temp.next;
                temp.next = node;
            }
        }

        int index = 0;
        for (int i = 0; i < bin.length; i++) {
            if (bin[i] != null) {
                ListNode temp = bin[i];
                while (temp != null) {
                    a[index++] = temp.val;
                    temp = temp.next;
                }
            }
        }
    }
}
