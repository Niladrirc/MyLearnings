package src.learning.avl.trees;

import src.learning.TreeNode;

public class AVLTree {
    private TreeNode root;

    public int treeHeight(AVLNode node) {
        int heightLeft = (node != null && node.left != null) ? node.left.height : 0;
        int heightRight = (node != null && node.right != null) ? node.right.height : 0;
        return Math.max(heightLeft, heightRight)+1;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean searchIterative(int key) {
        if (root == null) {
            return false;
        }
        TreeNode current = root;
        while (current != null) {
            if (current.data == key) {
                return true;
            } else if (current.data > key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    public boolean searchRecursive(TreeNode node, int key) {
        if (node == null) {
            return false;
        } else if (node.data == key) {
            return true;
        } else if (node.data > key) {
            return searchRecursive(node.left, key);
        } else {
            return searchRecursive(node.right, key);
        }
    }

    public AVLNode insertRecursive(AVLNode node, int key) {
        if (node == null) {
            return new AVLNode(key);
        } else if (key < node.data) {
            node.left = insertRecursive(node.left, key);
        } else if (key > node.data) {
            node.right = insertRecursive(node.right, key);
        } else {
            return null;
        }

        node.height = treeHeight(node);
    }

    private TreeNode balancedTree() {

    }

//    public TreeNode insertRecursive(TreeNode node, int key) {
//
//    }

    public static void main(String[] args) {
    }
}
