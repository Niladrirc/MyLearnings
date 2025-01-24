package collect;

import java.util.*;

public class QueueInterfaceDemo {
    public static void main(String[] args) {
        // Rule of thumb
        // Whenever implementing Queue try to use LinkedList
        // Whenever implementing Stack use Stack
        // Whenever implementing Double ended queue use ArrayDequeue
        StackDemo stackDemo = new StackDemo();
        Thread stackDemoThread = new Thread(stackDemo, "stackDemo");
//        stackDemoThread.start();

        DoubleEndedQueueDemo dequeueDemo = new DoubleEndedQueueDemo();
        Thread dequeueThread = new Thread(dequeueDemo, "dequeueDemo");
//        dequeueThread.start();

        PriorityQueueDemo priorityQueueDemo = new PriorityQueueDemo();
        Thread priorityQueueDemoThread = new Thread(priorityQueueDemo, "priorityQueueDemo");
        priorityQueueDemoThread.start();
    }

    private static class QueueDemo implements Runnable {
        private final Queue<Integer> stack;
        private final int num;

        public QueueDemo(int num) {
            this.stack = new LinkedList<>();
            this.num = num;
        }

        @Override
        public void run() {
            for (int i = 0; i < num; i++) {
                stack.offer(i); // -> prefer this compared to add() as it does not throw IllegalState Exception when the internal data structure is full.
            }
        }
    }

    private static class StackDemo implements Runnable {

        @Override
        public void run() {
            System.out.println("Doing stack with ArrayDeque");
            Deque<Integer> stackWithQueue = new ArrayDeque<>();

            stackWithQueue.offerFirst(1);
            stackWithQueue.offerFirst(2);

            while (!stackWithQueue.isEmpty()) {
                System.out.println(stackWithQueue.pollFirst());
            }

            stackWithQueue.push(1);stackWithQueue.push(2);stackWithQueue.push(3);
            while (stackWithQueue.peek() != null) {
                System.out.println(stackWithQueue.pop());
            }

            System.out.println("Doing stack with Stack");
            Stack<Integer> stackWithStack = new Stack<>();

            stackWithStack.push(1);
            stackWithStack.push(2);
            stackWithStack.push(3);

            while (!stackWithStack.isEmpty()) {
                System.out.println(stackWithStack.pop());
            }
        }
    }

    private static class DoubleEndedQueueDemo implements Runnable {

        @Override
        public void run() {
            System.out.println("Implementing double ended queue with ArrayDequeue");

            Deque<Integer> deque = new ArrayDeque<>();

            deque.offerFirst(1); // -> added to the first of the queue
            deque.offerFirst(2); // -> added to the first of the queue
            deque.offerFirst(3); // -> added to the first of the queue
            deque.offerLast(4); // -> added to the last of the queue

            System.out.println(deque.pollFirst()); // -> element from first of the queue is returned
            System.out.println(deque.pollLast()); // -> element from last of the queue is returned
        }
    }

    private static class PriorityQueueDemo implements Runnable {

        @Override
        public void run() {


            PriorityQueue<StudentMarks> priorityQueue = new PriorityQueue<>(((o1, o2) -> (int) (o1.maths() - o2.maths())));
            priorityQueue.add(new StudentMarks("Prapti", 80, 80));
            priorityQueue.add(new StudentMarks("Niladri", 70, 35));
            priorityQueue.add(new StudentMarks("Susmita", 60, 1000));
            priorityQueue.add(new StudentMarks("Raj", 20, 30));
            priorityQueue.add(new StudentMarks("Rohit", 100, 80));

            /*
                Get the top 3 students
             */
            List<StudentMarks> top3 = new ArrayList<>();

            int index = 0;
            while (!priorityQueue.isEmpty()) {
                if (index >= 3)
                    break;
                top3.add(priorityQueue.poll());
                index++;
            }

            System.out.println(top3);

            PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            integerPriorityQueue.offer(2);
            integerPriorityQueue.offer(35);
            integerPriorityQueue.offer(11);
            integerPriorityQueue.offer(50);

            // get the top 2 elements
            index = 0;
            List<Integer> integerList = new ArrayList<>();
            while (!integerPriorityQueue.isEmpty()) {
                if (index >= 2)
                    break;
                integerList.add(integerPriorityQueue.poll());
                index++;
            }
            System.out.println(integerList);
        }
    }
}
