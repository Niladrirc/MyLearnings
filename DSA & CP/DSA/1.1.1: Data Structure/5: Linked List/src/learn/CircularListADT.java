package src.learn;

public class CircularListADT {
    private Node<Integer> head;
    private int size;

    public CircularListADT() {
        head = new Node<>();
        size = 0;
    }

    public void insert(int data, int pos) {
        if (pos < 0 || pos > size) {
            System.out.println("Invalid position");
            return;
        }
        Node<Integer> newNode = new Node<>(data);
        if (pos == 0) {
            newNode.next = head.next;
            head.next = newNode;
        } else {
            int index = 0;
            Node<Integer> current = head.next;
            while (index < pos - 1) {
                current = current.next;
                index++;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    public void add(int data) {
        Node<Integer> newNode = new Node<>(data);
        if (size == 0) {
            head.next = newNode;
            newNode.next = head;
        } else {
            Node<Integer> current = head.next;
            int index = 0;
            while (index < size - 1) {
                current = current.next;
                index++;
            }
            newNode.next = head;
            current.next = newNode;
        }
        size++;
    }

    public void display() {
        if (size == 0) {
            System.out.println("List is empty! Nothing to display");
            return;
        }
        Node<Integer> current = head.next; int index = 0;
        System.out.print("Circular List Data: [ ");
        while (index < size) {
            System.out.print(current.data);
            if (current.next != head) {
                System.out.print(", ");
            }
            current = current.next;
            index++;
        }
        System.out.println(" ]");
    }

    public Integer remove(int pos) {
        if (pos < 0 || pos >= size) {
            System.err.println("Invalid position");
            return -1;
        }
        Node<Integer> current = head.next;
        Node<Integer> prev = head;
        int index = 0;
        while (index < pos) {
            prev = current;
            current = current.next;
            index++;
        }
        Node<Integer> deletedNode = current;
        prev.next = current.next;
        size--;
        return deletedNode.data;
    }

    public Integer remove(Node<Integer> data) {
        if (size == 0) {
            System.out.println("List is empty! Nothing to remove");
            return -1;
        }
        Node<Integer> current = head.next;
        while (current.next != head) {
            if (current.next.data.equals(data.data)) {
                Node<Integer> deletedNode = current.next;
                current.next = current.next.next;
                size--;
                return deletedNode.data;
            }
        }
        System.out.println("Relevant Node not found");
        return -1;
    }
}
