package src.learn;

import java.util.Iterator;

public class Learning {
    public static void main(String[] args) {
//        DoublyLinkedList dll = new DoublyLinkedList();
        ListADT<Integer> list = new ListADT<>();

        list.add(1);
        list.add(2);
        list.add(5);

        for (Integer integer : list) {
            System.out.println(integer);
        }

//        dll.add(0);
//        dll.add(1);
//        dll.add(2);
//        dll.add(3);
//        dll.add(4);
//        dll.add(5);
//
//        dll.display();
//
//        dll.remove(0);
//        dll.display();
//
//        dll.reverse();
//        dll.display();

    }
}
