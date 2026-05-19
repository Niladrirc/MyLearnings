public class MyDoublyLinkedList<T> implements Iterable<T> {
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    int size;
    
    /* Creation methods */
    public MyDoublyLinkedList() {
        size = 0;
    }

    public MyDoublyLinkedList(T data) {
        head = tail = new DoubleNode<>(data);
        size = 1;
    }
}