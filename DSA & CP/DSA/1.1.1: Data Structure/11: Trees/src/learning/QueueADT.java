package src.learning;

public class QueueADT<T> {
    private class Node<E> {
        E data;
        Node<E> next;
        public Node() {}
        public Node(E data) { this.data = data; this.next = null; }
    }
    private Node<T> first;
    private int size;

    public QueueADT() {
        first = null;
        size = 0;
    }
    public QueueADT(T data) {
        this.first = new Node<>(data);
        this.size = 1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            first = newNode;
            size = 1;
            return;
        }
        Node<T> temp = first;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        size += 1;
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        T data = first.data;
        first = first.next;
        size -= 1;
        return data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }
        Node<T> temp = first;
        System.out.print("[ ");
        while(temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(", ");
            }
            temp = temp.next;
        }
        System.out.println(" ]");
    }


}
