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
        if (getBalanceFactor(node) == 2 && getBalanceFactor(node.left) == 1) {
            return getLLRotatedSubtree(node);
        } else if (getBalanceFactor(node) == -2 && getBalanceFactor(node.left) == -1) {
            return getRRRotatedSubtree(node);
        } else if (getBalanceFactor(node) == 2 && getBalanceFactor(node.left) == -1) {
            return getLRRotatedSubtree(node);
        } else if (getBalanceFactor(node) == -2 && getBalanceFactor(node.left) == 1) {
            return getRLRotatedSubtree(node);
        }
        return node;
    }

    private AVLNode getLLRotatedSubtree(AVLNode p) {
        AVLNode pl = p.left;
        AVLNode plr = pl.right;

        p.left = plr;
        pl.right = p;

        p.height = treeHeight(p);
        pl.height = treeHeight(pl);

        if (root == p) {
            root = pl;
        }

        return pl;
    }

    private AVLNode getRRRotatedSubtree(AVLNode p) {
        AVLNode pr = p.right;
        AVLNode prr = pr.right;

        p.right = pr.left;
        pr.left = p;

        p.height = treeHeight(p);
        pr.height = treeHeight(pr);

        if (root == p) {
            root = pr;
        }
        return pr;
    }

    private AVLNode getLRRotatedSubtree(AVLNode p) {
        AVLNode pl = p.left;
        AVLNode plr = p.right;

        pl.right = plr.left;
        p.left = plr.right;

        plr.left = pl;
        plr.right = p;

        pl.height = treeHeight(pl);
        p.height = treeHeight(p);
        plr.height = treeHeight(plr);

        if (root == p) {
            root = plr;
        }

        return plr;
    }

    private AVLNode getRLRotatedSubtree(AVLNode node) {
        return null;
    }

    public static void main(String[] args) {
    }
}
