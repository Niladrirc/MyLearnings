package src.learn;

public class ListNode<E> {
    E data;
    ListNode<E> next;
    public ListNode() {}
    public ListNode(E data) { this.data = data; this.next = null; }
    public ListNode(E data, ListNode<E> next) { this.data = data; this.next = next; }

    @Override
    public String toString() {
        return "ListNode [data=" + data + ", next=" + next + "]";
    }
}
