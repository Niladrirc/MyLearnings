package src.learn;

public class ListADT<T> {
    private ListNode<T> head;
    private ListNode<T> tail;

    private int size;

    public static void main(String[] args) {
        Integer[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        ListADT<Integer> listADT = new ListADT<>();
        listADT.createList(A);
        listADT.display();

        System.out.println("Number of nodes in the list: "+listADT.size());
    }

    public ListNode<T> createList(T[] arr) {
        for (T t : arr) {
            ListNode<T> newNode = new ListNode<>(t);
            if (head == null) {
                head = newNode;
                tail = newNode;
                this.size = 1;
            } else {
                tail.next = newNode;
                tail = newNode;
                this.size++;
            }
        }
        return head;
    }

    public void display() {
        if (head == null) {
            System.err.println("List is empty!");
            return;
        }

        ListNode<T> temp = head;
        System.out.print("List: [ ");
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
            if (temp != null) {
                System.out.print(", ");
            }
        }
        System.out.print(" ]");
        System.out.println();
    }

    public void display(ListNode<T> head) {
        if (head == null) {
            System.err.println("List is empty!");
            return;
        }
        ListNode<T> temp = head;
        System.out.print("List: [ ");
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
            if (temp != null) {
                System.out.print(", ");
            }
        }
        System.out.print(" ]");
        System.out.println();
    }

    public int size(ListNode<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.next);
    }

    public int size() {
        return this.size;
    }

    public Object sum(ListNode<T> node) {
        if (node == null) {
            System.err.println("List is empty!");
        }

        if (node != null && !(node.data instanceof Number)) {
            System.err.println("Summation not possible for non-numeric types.");
            return null;
        }

        ListNode<T> temp = node;
        double sum = 0.0;
        while (temp != null) {
            sum += ((Number) temp.data).doubleValue();
            temp = temp.next;
        }

        return sum;
    }

    public ListNode<T> largestNode(ListNode<T> node) {
        if (node == null) {
            System.err.println("List is empty!");
            return null;
        }

        if (!(node.data instanceof Number)) {
            System.err.println("Largest node not possible for non-numeric types.");
            return null;
        }

        ListNode<T> temp = node;
        double max = 0.0;
        ListNode<T> largest = node;
        while (temp != null) {
            if (((Number) temp.data).doubleValue() > max) {
                max = ((Number) temp.data).doubleValue();
                largest = temp;
            }
            temp = temp.next;
        }

        return largest;
    }

    public int searchForIndex(ListNode<T> node, T target) {
        if (node == null) {
            System.err.println("List is empty!");
            return -1;
        }

        ListNode<T> temp = node;
        int index = 0;
        while (temp != null) {
            if (!temp.data.equals(target)) {
                index++;
                temp = temp.next;
            } else {
                return index;
            }
        }
        return -1;
    }

    public boolean search(ListNode<T> node, T target) {
        if (node == null) {
            System.err.println("List is empty!");
            return false;
        }
        ListNode<T> temp = node;
        while (temp != null) {
            if (temp.data.equals(target)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public ListNode<T> find(ListNode<T> node, T target) {
        if (node == null) {
            System.err.println("List is empty!");
            return null;
        }
        ListNode<T> temp = node;
        while (temp != null) {
            if (temp.data.equals(target)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void insert(T data, int index) {
        ListNode<T> newNode = new ListNode<>(data);
        int nodeCount = size(newNode);
        
        if (head == null) {
            System.err.println("List is empty! Creating a new node.");
            head = newNode;
            tail = newNode;
        }
        int listIndex = 0; ListNode<T> temp = head;
        if (index == 0) {
            // Insert at start
            newNode.next = head;
            head = newNode;
        } else if (index == nodeCount-1) {
            while (temp.next != null) {
                temp = temp.next;
            }
            newNode.next = null;
            temp.next = newNode;
            tail = newNode;
        } else if (0 < index && index < nodeCount-1) {
            while (listIndex < nodeCount - 1 && temp.next != null) {
                temp = temp.next;
                listIndex++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        } else {
            System.err.println("Invalid index provided");
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
}
