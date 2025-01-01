package src.learn;

public class Node<E> {
    E data;
    Node<E> next;
    public Node() {}
    public Node(E data) { this.data = data; this.next = null; }
    public Node(E data, Node<E> next) { this.data = data; this.next = next; }

//    @Override
//    public String toString() {
//        StringBuilder result = new StringBuilder();
//        result.append("ListNode [data=").append(data).append("]");
//
//        // Prevent infinite loop by only going one full circle
//        Node<E> current = this.next;
//        while (current != null && current != this) {
//            result.append(" -> ").append("ListNode [data=").append(current.data).append("]");
//            current = current.next;
//        }
//
//        // Indicate that we have looped back to the head
//        if (current == this) {
//            result.append(" -> [circular]");
//        }
//        return result.toString();
//    }
}
