package src.learning;

import com.sun.source.tree.Tree;

import java.util.*;

class BinaryTree {
    private TreeNode root;
    private int size;

    public BinaryTree() {}
    public BinaryTree(int data) { root = new TreeNode(data); }



    public void createBinaryTree() {
        int data;
        QueueADT<TreeNode> q = new QueueADT<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter root data: ");
        data = sc.nextInt();
        TreeNode newNode = new TreeNode(data);
        root = newNode;
        q.enqueue(newNode);

        while (!q.isEmpty()) {
            TreeNode node = q.dequeue();

            System.out.print("Enter left child for " + node.data + ": ");
            data = sc.nextInt();
            if (data != -1) {
                TreeNode leftChild = new TreeNode(data);
                node.left = leftChild;
                q.enqueue(leftChild);
            }

            System.out.print("Enter right child for " + node.data + ": ");
            data = sc.nextInt();
            if (data != -1) {
                TreeNode rightChild = new TreeNode(data);
                node.right = rightChild;
                q.enqueue(rightChild);
            }
        }
        display();
    }

    public void display() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select traversal mechanism: ");
        System.out.println("1. Select 1 from pre-order traversal");
        System.out.println("2. Select 2 from in-order traversal");
        System.out.println("3. Select 3 from post-order traversal");
        System.out.println("4. Select 4 from level-order traversal");

        int choice = sc.nextInt();
        boolean cont = true;
        while (cont) {
            switch (choice) {
                case 1:
                    generatePreOrderView(root);
                    cont = false;
                    break;
                case 2:
                    generateInOrderView(root);
                    cont = false;
                    break;
                case 3:
                    generatePostOrderView(root);
                    cont = false;
                    break;
                case 4:
                    generateLevelOrderView(root);
                    cont = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void generatePreOrderView(TreeNode node) {
        // todo: Generate pre order view
        if (node == null) return;
        System.out.print(node.data + " ");
        generatePreOrderView(node.left);
        generatePreOrderView(node.right);
    }

    private void generatePreOrderViewIterative(TreeNode node) {
        StackADT<TreeNode> stk = new StackADT<>();

        while (node != null || !stk.isEmpty()) {
            if (node != null) {
                System.out.print(node.data + " ");
                stk.push(node);
                node = node.left;
            } else {
                node = stk.pop();
                node = node.right;
            }
        }
    }

    private void generateInOrderView(TreeNode node) {
        // todo: Generate in order view
        if (node == null) return;
        generateInOrderView(node.left);
        System.out.print(node.data + " ");
        generateInOrderView(node.right);
    }

    private void generateInOrderViewIterative(TreeNode node) {
        StackADT<TreeNode> stk = new StackADT<>();
        while (node != null || !stk.isEmpty()) {
            if (node != null) {
                stk.push(node);
                node = node.left;
            } else {
                node = stk.pop();
                System.out.print(node.data + " ");
                node = node.right;
            }
        }
    }

    private void generatePostOrderView(TreeNode node) {
        // todo: Generate post order view
        if (node == null) return;
        generatePostOrderView(node.left);
        generatePostOrderView(node.right);
        System.out.print(node.data + " ");
    }

    private void generatePostOrderViewIterative(TreeNode node) {
        StackADT<TreeNode> stk = new StackADT<>();
        while (node != null || !stk.isEmpty()) {
            if (node != null) {
                stk.push(node);
                node = node.left;
            } else {
                node = stk.pop();

            }
        }
    }

    private void generateLevelOrderView(TreeNode node) {
        // todo: Generate level order view
        QueueADT<TreeNode> q = new QueueADT<>();
        System.out.print(node.data + " ");
        q.enqueue(root);
        while (!q.isEmpty()) {
            TreeNode current = q.dequeue();
            if (current.left != null) {
                System.out.print(current.left.data + " ");
                q.enqueue(current.left);
            }
            if (current.right != null) {
                System.out.print(current.right.data + " ");
                q.enqueue(current.right);
            }
        }
    }

    public int getNodeCount(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int x = getNodeCount(node.left);
        int y = getNodeCount(node.right);
        return (x+y+1);
    }

    public int getTreeHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int x = getTreeHeight(node.left);
        int y = getTreeHeight(node.right);
        int max = Math.max(x, y);
        return (max+1);
    }

    public int getNodeCountWithDegreeTwo(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int x = getNodeCountWithDegreeTwo(node.left);
        int y = getNodeCountWithDegreeTwo(node.right);

        if (node.left != null && node.right != null) {
            return (x+y+1);
        } else {
            return (x+y);
        }
    }

    public int getNodeSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int x = getNodeSum(node.left);
        int y = getNodeSum(node.right);
        return (x + y + node.data);
    }

    public int getLeafNodeCount(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int x = getLeafNodeCount(node.left);
        int y = getLeafNodeCount(node.right);
        if (node.left == null && node.right == null) {
            return (x + y + 1);
        } else {
            return (x + y);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.createBinaryTree();
    }

}