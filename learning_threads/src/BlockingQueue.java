import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    private final Queue<Integer> queue;
    private final int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        queue = new LinkedList<>();
    }

    public boolean add(int item) {
        synchronized (queue) {
            while (queue.size() == capacity) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            queue.add(item);
            queue.notifyAll();
            return true;
        }
    }

    public int remove() {
        synchronized (queue) {
            while (queue.isEmpty()) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            int element = queue.poll();
            queue.notifyAll();
            return element;
        }
    }
}
