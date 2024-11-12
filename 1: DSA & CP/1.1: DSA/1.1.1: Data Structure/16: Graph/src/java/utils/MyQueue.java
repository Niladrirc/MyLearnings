package src.java.utils;

public class MyQueue {
    //Implemented using linked list as well as array
    private Node first;
    private int size;

    public MyQueue() { first = null; }

    public boolean isEmpty() { return first == null; }

    public int size() {
        return this.size;
    }

    public void enqueue(int value) {
        if (size == 0) {
            first = new Node(value);
            size = 1;
        } else {
            Node newNode = new Node(value);
            Node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            newNode.prev = temp;
            temp.next = newNode;
            size += 1;
        }
    }

    public int dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return -1;
        }
        Node temp = first;
        first = first.next;
        size -= 1;
        return temp.val;
    }

    public Node peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return first;
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "data=" + print() +
                ", size=" + size +
                '}';
    }

    private String print() {
        if (isEmpty()) {
            return "";
        }
        StringBuilder newStr = new StringBuilder();
        Node temp = first;
        newStr.append("[ ");
        while (temp != null) {
            newStr.append(temp.val);
            if (temp.next != null) {
                newStr.append(", ");
            }
            temp = temp.next;
        }
        newStr.append(" ]");

        return newStr.toString();
    }
}
