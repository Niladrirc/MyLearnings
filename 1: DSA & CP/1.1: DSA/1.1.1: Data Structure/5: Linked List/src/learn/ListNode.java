package src.learn;

public class ListNode {
    int data;
    ListNode next;
    public ListNode() {}
    public ListNode(int data) { this.data = data; this.next = null; }
    public ListNode(int data, ListNode next) { this.data = data; this.next = next; }

    @Override
    public String toString() {
        return "ListNode [data=" + data + ", next=" + next + "]";
    }
}
