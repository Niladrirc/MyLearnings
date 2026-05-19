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

    /* access methods */
    public T getFirst() {
        return head.getData();
    }

    public T getLast() {
        return tail.getData();
    }

    public T get(int index) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                String.format("Index %s is out-of-bounds for list of size %s", index, size));
        }

        DoubleNode<T> node;
        if (index < size/2) {
            node = head;
            for(int i = 0; i < index; i++) node = node.getNext();
        } else {
            node = tail;
            for (int i = size-1; i > index; i--) node = node.getPrev();
        }

        return node.getData();

    }

    public int getSize() {
        return size;
    }
}