public class SynchronizationTest {
    public static void main(String[] args) {
        CustomStack stack = new CustomStack(5);

        new Thread(() -> {
            int counter = 0;
            while (++counter<5) {
                System.out.println("Pushed: " + stack.push(counter));
            }
        }, "Pusher").start();


        new Thread(() -> {
            int counter = 0;
            while (++counter < 5) {
                System.out.println("Popped: " + stack.pop());
            }
        }, "Popper").start();
    }
}
