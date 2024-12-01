package src.learning.avl.trees;

public class AVLNode {
    public AVLNode left, right;
    int data;
    public int height;

    public AVLNode(int data) {
        this.data = data; this.height = 1;
    }
}
