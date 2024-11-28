package src.learning;

public class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode() {}
    public TreeNode(int data) { this.data = data; this.left = this.right = null; }
    public TreeNode(int data, TreeNode left, TreeNode right) { this.data = data; this.left = left; this.right = right; }
}
