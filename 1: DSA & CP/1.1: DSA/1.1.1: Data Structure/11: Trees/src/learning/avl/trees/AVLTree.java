package src.learning.avl.trees;

import src.learning.TreeNode;

public class AVLTree {
    private AVLNode root;

    public int treeHeight(AVLNode node) {
        int heightLeft = (node != null && node.left != null) ? node.left.height : 0;
        int heightRight = (node != null && node.right != null) ? node.right.height : 0;
        return Math.max(heightLeft, heightRight)+1;
    }

    private int getBalanceFactor(AVLNode node) {
        return treeHeight(node.left) - treeHeight(node.right);
    }


    public boolean isEmpty() {
        return root == null;
    }

    public boolean searchIterative(int key) {
        if (root == null) {
            return false;
        }
        AVLNode current = root;
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
        // Update height in return phase
        node.height = treeHeight(node);

        // Check bf and perform rotation if necessary
        /**
         * there will be 4 categories of rotation
         * 1. LL rotation -> currentNode's balance_factor = 2 & currentNode.left's balance_factor = 1
         * 2. RR rotation -> currentNode's balance_factor = -2 & currentNode.right's balance_factor = -1
         * 3. LR rotation -> currentNode's balance_factor = 2 & currentNode.right's balance_factor = -1
         * 4. RL rotation -> currentNode's balance_factor = -2 & currentNode.right's balance_factor = 1
         */
        if (getBalanceFactor(node) == 2 && getBalanceFactor(node.left) == 1) {//todo LL rotation logic }
        if (getBalanceFactor(node) == -2 && getBalanceFactor(node.left) == -1) { //todo RR rotation logic }
        if (getBalanceFactor(node) == 2 && getBalanceFactor(node.left) == -1) { // todo LR rotation logic }
        if (getBalanceFactor(node) == -2 && getBalanceFactor(node.left) == 1) { // todo RL rotation logic }
        return node;
    }

    public static void main(String[] args) {
    }
}
