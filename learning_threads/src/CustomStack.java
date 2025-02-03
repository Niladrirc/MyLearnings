public class CustomStack {
    private final int[] array;
    private int stackTop;
    private final Object lock1;
    private final Object lock2;

    public CustomStack(int size) {
        array = new int[size];
        stackTop = -1;
        lock1 = new Object();
        lock2 = "";
    }

    public boolean isEmpty() {
        return stackTop == -1;
    }

    public boolean isFull() {
        return stackTop == array.length - 1;
    }

    public boolean push(int element) {
        synchronized(lock1) {
            if (this.isFull()) return false;

            ++stackTop;

            try {
                Thread.sleep(1000);
            } catch (Exception ignored) {
            }

            array[stackTop] = element;
            return true;
        }
    }

    public int pop() {
        synchronized (lock2) {
            if (isEmpty()) return Integer.MIN_VALUE;
            int value = array[stackTop];
            array[stackTop] = Integer.MIN_VALUE;
            try {
                Thread.sleep(1000);
            } catch (Exception ignored) {
            }

            stackTop--;
            return value;
        }
    }
}
