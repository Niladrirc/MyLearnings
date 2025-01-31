package collect;

import java.util.*;

public class SetInterfaceDemo {
    public static void main(String[] args) {
        HashsetDemo hashsetDemo = new HashsetDemo();
        Thread t = new Thread(hashsetDemo);
        t.start();
    }

    private static class HashsetDemo implements Runnable {

        @Override
        public void run() {
            Set<Integer> setA = new HashSet<>();
            setA.add(1);
            setA.add(2);
            setA.add(3);
            setA.add(4);

            List<Integer> list= new ArrayList<>();
            list.add(10); list.add(20); list.add(3); list.add(4);
            Set<Integer> setB = new HashSet<>(list);
            System.out.print(setA);System.out.println(setB);

            // Intersection of 2 sets
            setA.retainAll(setB);
            System.out.println(setA);

            setA.add(1);setA.add(2);setA.add(3);setA.add(4);

            // Set Difference
            setA.removeAll(setB);
            System.out.println(setA);

            // Set Union setA.addAll(setB)

            setA.clear();
            System.out.println(setA);
        }
    }

    private static class TreeHashSetDemo implements Runnable {
        @Override
        public void run() {
            Set<Integer> treeSet = new TreeSet<>();
        }
    }
}
