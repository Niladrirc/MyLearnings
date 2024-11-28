package src.learning;

import java.util.*;

class BinaryTree {
    private TreeNode root;
    private int size;

    public BinaryTree(int data) {
        root = new TreeNode(data);
    }

    public void createBinaryTree() {
        int data;
        QueueADT<TreeNode> q = new QueueADT<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter root data: ");
        data = sc.nextInt();
        TreeNode newNode = new TreeNode(data);
        root = newNode;
        q.enqueue(newNode);

        while (!q.isEmpty()) {
            TreeNode node = q.dequeue();

            System.out.println("Enter left child data: ");
            data = sc.nextInt();
            if (data != -1) {
                TreeNode leftChild = new TreeNode(data);
                node.left = leftChild;
                q.enqueue(leftChild);
            }

            System.out.println("Enter right child data: ");
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
                    generatePreOrderView();
                    cont = false;
                    break;
                case 2:
                    generateInOrderView();
                    cont = false;
                    break;
                case 3:
                    generatePostOrderView();
                    cont = false;
                    break;
                case 4:
                    generateLevelOrderView();
                    cont = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void generatePreOrderView() {
        // todo: Generate pre order view
    }

    private void generateInOrderView() {
        // todo: Generate in order view
    }

    private void generatePostOrderView() {
        // todo: Generate post order view
    }

    private void generateLevelOrderView() {
        // todo: Generate level order view
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
    }

}