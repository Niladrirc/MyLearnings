import java.util.NoSuchElementException;
import java.util.Objects;

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

    /* mutation methods */
    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                String.format("Index %s is out-of-bounds for list of size %s", index, size));
        }

        DoubleNode<T> node = new DoubleNode<>(data);

        if (index == 0) {
            this.addFirst(data);
            return;
        }

        if (index == size) {
            this.addLast(data);
            return;
        }

        DoubleNode<T> currNode;
        if (index < size/2) {
            currNode = head;

            for(int i=0; i<index; i++) {
                currNode = currNode.getNext();
            }
        } else {
            currNode = tail;
            for(int i=size-1; i>index; i--) {
                currNode = currNode.getPrev();
            }
        }
        

        DoubleNode<T> prevNode = currNode.getPrev();
        // add between prevNode and currNode
        node.setPrev(prevNode);
        node.setNext(currNode);

        prevNode.setNext(node);
        currNode.setPrev(node);
        size++;

    }

    public void add(T data) {
        // Create a new double node
        DoubleNode<T> node = new DoubleNode<>(data);

        if (isEmpty()) {
            head = tail = node;
            size = 1;
            return;
        }

        tail.setNext(node);
        node.setPrev(tail);
        tail = node;
        size++;
    }

    public void addFirst(T data) {
        DoubleNode<T> node = new DoubleNode<>(data);

        if (isEmpty()) {
            head = tail = node;
            size = 1;
            return;
        }

        head.setPrev(node);
        node.setNext(head);
        head = node;
        size++;

    }

    public void addLast(T data) {
        this.add(data);
    }


    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove from empty list.");
        }

        if (size == 1) {
            T data = this.head.getData();
            head = tail = null;
            size = 0;
            return data;
        }
        T data = head.getData();
        head = head.getNext();
        head.setPrev(null);
        size--;
        return data;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove from empty list.");
        }

        if (size == 1) {
            T data = this.head.getData();
            head = tail = null;
            size = 0;
            return data;
        }

        T data = tail.getData();
        tail = tail.getPrev();
        tail.setNext(null);
        size--;
        return data;
    }

    public T remove(T data) {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove from empty list.");
        }

        if (size == 1 && !Objects.equals(head.getData(), data)) {
            throw new NoSuchElementException(data + " not present in the list");
        }

        DoubleNode<T> node = head;

        while (!Objects.equals(data, node.getData()) && node.getNext() != null) {
            node = node.getNext();
        }

        if (!Objects.equals(data, node.getData())) {
            throw new NoSuchElementException(data + " not present in the list");
        }

        if (node == head) {
            return this.removeFirst();
        }

        if (node == tail) {
            return removeLast();
        }

        DoubleNode<T> prevNode = node.getPrev();
        DoubleNode<T> nextNode = node.getNext();

        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);

        T dataToRemove = node.getData();
        node = null;
        size--;

        return dataToRemove;
    }

    public T removeAt(int index) {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove from empty list.");
        }

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                String.format("Index %s is out-of-bounds for list of size %s", index, size));
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == size-1) {
            return removeLast();
        }

        DoubleNode<T> node;
        if (index < size/2) {
            node = head;
            for (int i=0; i<index; i++) node = node.getNext();
        } else {
            node = tail;
            for (int i=size-1; i>index; i--) node = node.getPrev();
        }

        DoubleNode<T> prevNode = node.getPrev();
        DoubleNode<T> nextNode = node.getNext();

        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);

        size--;
        return node.getData();
    }

    /* utility methods */
    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head = tail = null;
    }

    public boolean contains(T data) {
        if (isEmpty()) {
            return false;
        }

        DoubleNode<T> node = head;
        while (node != null) {
            if (Objects.equals(data, node.getData())) {
                return true;
            }
            node = node.getNext();
        }

        return false;
    }

    public int indexOf(T data) {
        DoubleNode<T> node = head;
        int index = 0;

        while (node != null) {

            if (Objects.equals(data, node.getData())) {
                return index;
            }

            node = node.getNext();
            index++;
        }

        return -1;
    }
}