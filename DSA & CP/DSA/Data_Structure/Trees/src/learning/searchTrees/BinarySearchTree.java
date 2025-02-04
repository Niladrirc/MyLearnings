package src.learning.searchTrees;

import src.learning.StackADT;
import src.learning.TreeNode;

import java.util.Scanner;

public class BinarySearchTree {

    private TreeNode root;

    public BinarySearchTree(int data) {
        this.root = new TreeNode(data);
    }

    public BinarySearchTree() {}

    public boolean search(int key) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Press 1 for recursive search and 2 for iterative search");
        int choice = scanner.nextInt();
        return switch (choice) {
            case 1 -> searchRecursive(root, key);
            case 2 -> searchIterative(root, key);
            default -> false;
        };
    }

    public void insert(int key) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Press 1 for recursive insert and 2 for iterative insert");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                insertRecursive(root, key);
                break;
            case 2:
                insertIterative(root, key);
                break;
            default:
                System.out.println("Wrong input. Try again.");
        }
    }

    public void delete(int key) {
        this.deleteIterative(root, key);
    }

    private boolean searchRecursive(TreeNode node, int key) {
        if (node == null) return false;
        if (node.data == key) return true;
        if (node.data > key) {
            return searchRecursive(node.left, key);
        } else {
            return searchRecursive(node.right, key);
        }
    }

    private boolean searchIterative(TreeNode node, int key) {
        if (node == null) return false;
        while (node != null) {
            if (node.data == key) return true;
            if (node.data > key) {
                node = node.left;
            }
            else {
                node = node.right;
            }
        }
        return false;
    }

    private void insertIterative(TreeNode node, int key) {
        TreeNode newNode = new TreeNode(key);
        if (node == null) {
            root = newNode;
            return;
        }
        TreeNode current = node;
        while(true) {
            if (current.data == key) {
                System.out.println("Key " + key + " already exists.");
                return;
            }
            if (key < current.data) {
                if (current.left == null) {
                    current.left = newNode;
                    return;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = newNode;
                    return;
                }
                current = current.right;
            }
        }
    }

    private TreeNode insertRecursive(TreeNode node, int key) {
        if (node == null) {
            return new TreeNode(key);
        }
        if (node.data == key) {
            System.out.println("Key already exists");
            return null;
        }
        if (node.data > key) {
            node.left = insertRecursive(node.left, key);
        } else {
            node.right = insertRecursive(node.right, key);
        }
        return node;
    }

    private void deleteIterative(TreeNode node, int key) {
        if (node == null) {
            System.out.println("Tree is empty");
            return;
        }
        TreeNode current = node;
        TreeNode parent = null;
        while (current != null) {
            if (current.data == key) {
                if (current.left == null && current.right == null) {
                    if (parent != null && parent.left == current) {
                        parent.left = null;
                    } else if (parent != null && parent.right == current) {
                        parent.right = null;
                    } else {
                        node = null;
                    }
                } else {
//                    TreeNode inOrderSuccessorNode = getInOrderSuccessor(current.right);
                    if (getTreeHeight(current.left) > getTreeHeight(current.right)) {
                        // get the leftmost leaf child of right subtree
                        current.data = getInOrderSuccessor(current.right);
                    } else {
                        // get the rightmost leaf child of left subtree
                        current.data = getInOrderPredecessor(current.left);
                    }
                }
            }
            parent = current;
            if (current.data > key)
                current = current.left;
            else
                current = current.right;
        }
        System.out.println("No match found");
    }

    private TreeNode deleteRecursive(TreeNode node, int key) {
        if (node == null) return null;
        if (node.left == null && node.right == null) {
            if (node == root) {
                root = null;
            }
            return null;
        }
        if (key > node.data) {
            node.right = deleteRecursive(node.right, key);
        } else if (key < node.data) {
            node.left = deleteRecursive(node.left, key);
        } else {
            if (getTreeHeight(node.left) > getTreeHeight(node.right)) {
                node.data = getInOrderPredecessor(node.left);
                node.left = deleteRecursive(node.left, node.data);
            } else {
                node.data = getInOrderSuccessor(node.right);
                node.right = deleteRecursive(node.right, node.data);
            }
        }
        return null;
    }

    private int getInOrderPredecessor(TreeNode left) {
        TreeNode current = left;
        TreeNode parent = null;
        TreeNode parentOfParent = null;
        while (current != null) {
            parentOfParent = parent;
            parent = current;
            current = current.right;
        }
        if (parent.left == null) {
            if (parent == parentOfParent.left) {
                parentOfParent.left = null;
            } else {
                parentOfParent.right = null;
            }
            return parent.data;
        } else {
            return getInOrderPredecessor(parent.left);
        }
    }

    private int getInOrderSuccessor(TreeNode right) {
        TreeNode current = right;
        TreeNode parent = null;
        TreeNode parentOfParent = null;
        while (current != null) {
            parentOfParent = parent;
            parent = current;
            current = current.left;
        }
        if (parent.right == null) {
            if (parent == parentOfParent.right) {
                parentOfParent.right = null;
            } else {
                parentOfParent.left = null;
            }
            return parent.data;
        } else {
            return getInOrderSuccessor(parent.right);
        }
    }

    private int getNodeCount(TreeNode node) {
        if (node == null) return 0;
        return (1 + getNodeCount(node.left) + getNodeCount(node.right));
    }

    public int getTreeHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(getTreeHeight(node.left), getTreeHeight(node.right));
    }

    public TreeNode insertWithPreorder(int[] preorder) {
        StackADT<TreeNode> stk = new StackADT<>();
        TreeNode present = root;
        TreeNode temp = null;
        for (int j : preorder) {
            temp = new TreeNode(j);
            if (root == null) {
                root = temp;
                present = root;
            } else if (temp.data < present.data) {
                present.left = temp;
                stk.push(present);
                present = temp;
            } else if (temp.data > present.data && temp.data < stk.peek().data) {
                present.right = temp;
                present = temp;
            } else {
                present = stk.pop();
            }
        }
        return root;
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        System.out.println(tree);
    }


}
