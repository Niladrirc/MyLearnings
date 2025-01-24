package collect;

import java.util.*;

public class ListInterfaceDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main thread starts");
        VectorDemo vectors = new VectorDemo(1000);
        ArrayListDemo arrayListDemo = new ArrayListDemo(1000);

        Thread arrayListThread = new Thread(arrayListDemo, "ArrayListDemo");
        Thread vectorDemoThread = new Thread(vectors, "VectorDemo");

        long t1 = System.nanoTime();
        arrayListThread.start();
        arrayListThread.join();
        long t2 = System.nanoTime();
        System.out.println("Time to process array list thread " + (t2-t1));

        t1 = System.nanoTime();
        vectorDemoThread.start();
        vectorDemoThread.join();
        t2 = System.nanoTime();
        System.out.println("Time to process vector thread " + (t2-t1));



        LinkedListDemo linkedListDemo = new LinkedListDemo(10);
        Thread linkedListDemoThread = new Thread(linkedListDemo, "linkedListDemo");
        linkedListDemoThread.start();

        System.out.println("Main thread ends");

    }

    private static class VectorDemo implements Runnable {

        int num;
        List<Integer> list = new Vector<>();

        public VectorDemo(int num) {
            this.num = num;
        }

        @Override
        public void run() {
//            System.out.println("VectorDemo thread starts");
            for (int i = 0; i < num; i++) {
                list.add(i);
//                System.out.println("Vector demo running");
            }
//            System.out.println("VectorDemo ends");
        }
    }

    private static class ArrayListDemo implements Runnable {

        int num;
        List<Integer> list = new ArrayList<>();

        public ArrayListDemo(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            System.out.println("Arraylist thread starts: "+Thread.currentThread());
            for (int i = 0; i < num; i++) {
                list.add(i);
            }
            System.out.println("ArrayList ending");
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    private static class LinkedListDemo implements Runnable {

        private List<Integer> list;
        private final int num;

        public LinkedListDemo(int num) {
            this.list = new LinkedList<>();
            this.num = num;
        }

        @Override
        public void run() {
            // do something
            System.out.println("Starting thread "+Thread.currentThread());
            for (int i = 0; i < num; i++) {
                list.add(i);
            }

            ListIterator<Integer> listIterator = list.listIterator(num);
            while (listIterator.hasPrevious()) {
                System.out.println(listIterator.previous() + " ");
            }
        }
    }

}
