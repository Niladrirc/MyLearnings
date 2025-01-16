package src.java.utils;

public class Node {
    public int val;
    public Node next;
    public Node prev;
    public Node() {}
    public Node(int val) { this.val = val; this.next = null; this.prev = null; }
    public Node(int val, Node next, Node prev) { this.val = val; this.next = next; this.prev = prev; }
}
