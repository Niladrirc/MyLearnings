package src.learn;

public class DoublyLinkedList {
    private DoubleNode<Integer> head;
    private DoubleNode<Integer> tail;
    private int size;

    public void add(int data) {
        DoubleNode<Integer> newNode = new DoubleNode<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            size = 1;
        } else {
            DoubleNode<Integer> current = head;
            while (current.next != null) {
                current = current.next;
            }
            newNode.prev = current;
            current.next = newNode;
            tail = newNode;
            size++;
        }
    }

    public void add(int data, int pos) {
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException();
        }
        DoubleNode<Integer> newNode = new DoubleNode<>(data);
        if (pos == 0) {
            head = newNode;
            tail = newNode;
            size = 1;
        } else {
            DoubleNode<Integer> current = head;
            for (int i = 0; i < pos; i++) {
                current = current.next;
            }
            newNode.prev = current;
            current.next = newNode;
            tail = newNode;
            size++;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        DoubleNode<Integer> current = head;
        System.out.print("List: [ ");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println(" ]");
    }

    public void remove(Integer value) {
        if (head == null) {
            System.out.println("List is empty! Nothing to remove");
            return;
        }

        DoubleNode<Integer> current = head;
        while (current != null) {
            if (current.data.equals(value)) {
                if (current == head) {
                    head = current.next;
                    head.prev = null;
                } else {
                    current.prev.next = current.next;
                }
                size--;
                return;
            }
            current = current.next;
        }
    }

    public void reverse() {
        if (head == null) {
            System.out.println("List is empty! Nothing to reverse");
            return;
        }
        DoubleNode<Integer> current = head;
        while (current != null) {
            DoubleNode<Integer> temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        DoubleNode<Integer> temp = head;
        head  = tail;
        tail = temp;
    }
}
