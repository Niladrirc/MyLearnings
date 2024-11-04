package src.learn;

public class DoubleNode<E> {
    private final E data;
    private final DoubleNode<E> next;
    private final DoubleNode<E> prev;

    public DoubleNode(E data) { this.data = data; this.next = null; this.prev = null; }
    public DoubleNode() { this.data = null; this.next = null; this.prev = null; }
    public DoubleNode(E data, DoubleNode<E> next, DoubleNode<E> prev) { this.data = data; this.next = next; this.prev = prev; }

}
