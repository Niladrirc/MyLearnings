package src.learning;

import java.util.*;

class BinaryTree {
    private TreeNode root;
    private final Scanner input = new Scanner(System.in);

    public TreeNode userCreate() {
        System.out.println("Asking user to create tree");

        System.out.println("Enter root node value");
        root = new TreeNode(input.nextInt());

        return root;
    }
}
public class BinaryTreeADT {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();

        // We can add elements to the queue
        // in various ways

        // Add at the last
        deque.add("Element 1 (Tail)");

        // Add at the first
        deque.addFirst("Element 2 (Head)");

        // Add at the last
        deque.addLast("Element 3 (Tail)");

        // Add at the first
        deque.push("Element 4 (Head)");

        // Add at the last
        deque.offer("Element 5 (Tail)");

        // Add at the first
        deque.offerFirst("Element 6 (Head)");

        System.out.println(deque + "\n");
    }
}
