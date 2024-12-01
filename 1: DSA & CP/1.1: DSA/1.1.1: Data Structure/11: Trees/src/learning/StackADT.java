package src.learning;

public class StackADT<T> {
    static class Node<E> {

        private final E data;
        private Node<E> next;
        public Node(E data) { this.data = data; }

    }

    private Node<T> top;
    private int size;

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            top = newNode;
            size = 1;
        } else {
            Node<T> temp = top;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            size += 1;
        }
    }

    public T peek() {
        return top.data;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        T data = top.data;
        top = top.next;
        size -= 1;
        return data;
    }
}
