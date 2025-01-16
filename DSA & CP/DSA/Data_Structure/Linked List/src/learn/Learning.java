package src.learn;

public class Learning {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.add(0);
        dll.add(1);
        dll.add(2);
        dll.add(3);
        dll.add(4);
        dll.add(5);

        dll.display();

        dll.remove(0);
        dll.display();

        dll.reverse();
        dll.display();

    }
}
