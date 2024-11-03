package src.learn;

class ListADT<T> {
    private ListNode<T> head;
    private ListNode<T> tail;

    private int size;

    public int size(ListNode<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.next);
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) > 0;
    }

    private int indexOf(Object o) {
        ListNode<T> temp = head;
        if (o != null) {
            for (int i = 0; i < this.size(); i++) {
                if (temp.data.equals(o)) {
                    return i;
                }
                temp = temp.next;
            }
        } else {
            for (int i = 0; i < this.size(); i++) {
                if (temp == null) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean contains(ListNode<T> node, T target) {
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
        if (size == 0) {
            System.err.println("List is empty!");
            return;
        }
        ListNode<T> temp = this.head;
        System.out.print("List: [ ");
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
            if (temp != null) {
                System.out.print(", ");
            }
        }
        System.out.print(" ]\n");
    }

    public void display(ListNode<T> node) {
        if (node == null) {
            System.err.println("List is empty!");
            return;
        }
        ListNode<T> temp = node;
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

    public Object sum() {
        if (size == 0) {
            System.err.println("List is empty!");
            return null;
        }
        if (!(this.head.data instanceof Number)) {
            System.err.println("Summation not possible for non-numeric types.");
            return null;
        }
        ListNode<T> temp = this.head;
        double sum = 0.0;
        while (temp != null) {
            sum += ((Number) temp.data).doubleValue();
            temp = temp.next;
        }
        return sum;
    }

    public ListNode<T> largestNode() {
        if (size == 0) {
            System.err.println("List is empty!");
            return null;
        }
        if (!(head.data instanceof Number)) {
            System.err.println("Largest node not possible for non-numeric types.");
            return null;
        }
        ListNode<T> temp = this.head;
        double max = 0.0;
        ListNode<T> largest = this.head;
        while (temp != null) {
            if (((Number) temp.data).doubleValue() > max) {
                max = ((Number) temp.data).doubleValue();
                largest = temp;
            }
            temp = temp.next;
        }

        return largest;
    }

    public int findIndex(ListNode<T> node, T target) {
        if (node == null) {
            System.err.println("List is empty!");
            return -1;
        }
        ListNode<T> temp = node; int index = 0;
        while (temp != null) {
            if (temp.data.equals(target)) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    public int findIndex(T target) {
        if (size == 0) {
            System.err.println("List is empty!");
            return -1;
        }
        ListNode<T> temp = this.head; int index = 0;
        while (temp != null) {
            if (temp.data.equals(target)) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    public ListNode<T> find(ListNode<T> node, T target) {
        if (size == 0) {
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
        if (size == 0) {
            System.err.println("List is empty! Creating a new node.");
            head = newNode;
            tail = newNode;
            size = 1;
        }
        int listIndex = 0; ListNode<T> temp = head;
        if (index == 0) {
            // Insert at start
            newNode.next = head;
            head = newNode;
            size++;
        } else if (index == size-1) {
            while (temp.next != null) {
                temp = temp.next;
            }
            newNode.next = null;
            temp.next = newNode;
            tail = newNode;
            size++;
        } else if (0 < index && index < size-1) {
            while (listIndex < size - 1 && temp.next != null) {
                temp = temp.next;
                listIndex++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        } else {
            System.err.println("Invalid index provided");
        }
    }

    public void add(T data) {
        ListNode<T> newNode = new ListNode<>(data);
        if (size == 0) {
            head = newNode;
            tail = newNode;
            size = 1;
            return;
        }
        ListNode<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        tail = newNode;
        size++;
    }

    public ListNode<T> merge(ListADT<T> list) {
        if (list.head == null) {
            return this.head;
        } else if (this.size == 0) {
            this.head = list.head;
            int newListSize = size(list.head);
            if (newListSize == 0) {
                return null;
            }
            ListNode<T> temp = this.head;
            for (int i = 0; i < newListSize; i++) {
                temp = temp.next;
            }
            this.tail = temp;
            return this.head;
        } else {
            this.tail.next = list.head;
            ListNode<T> temp = list.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            this.tail = temp;
            return this.head;
        }
    }
}

public class ListLearning {
    public static void main(String[] args) {
        Integer[] A = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        Integer[] B = {15, 16, 17};

        ListADT<Integer> listA = new ListADT<>();
        ListADT<Integer> listB = new ListADT<>();

        listA.createList(A);
        listB.createList(B);

        listA.display();
        listB.display();

        listA.merge(listB);
        listA.display();
        listB.display();
    }
}
