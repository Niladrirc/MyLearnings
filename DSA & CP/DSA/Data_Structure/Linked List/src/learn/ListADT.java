package src.learn;

import java.util.Iterator;

class ListADT<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public ListADT() {
        Node<T> newNode = new Node<>();
        head = tail = null;
        size = 0;
    }

    public ListADT(T value) {
        Node<T> newNode = new Node<>(value);
        head = newNode;
        tail = newNode;
        size = 1;
    }

    public int size(Node<T> node) {
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

    @Override
    public Iterator<T> iterator() {
        return new ListADTIterator<>(this);
    }


    private static class ListADTIterator<E> implements Iterator<E> {

        private final ListADT<E> list;
        private int index;

        public ListADTIterator(ListADT<E> list) {
            this.list = list;
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < list.size;
        }

        @Override
        public E next() {
            return list.get(index++).data;
        }
    }

    public Node<T> get(int index) {
        if (this.size() == 0) {
            System.err.println("List is empty!");
            return null;
        }
        Node<T> temp = head;
        int i=0;
        while (i<index) {
            temp = temp.next;
            i++;
        }
        return temp;
    }

    public void display() {
        if (size == 0) {
            System.err.println("List is empty!");
            return;
        }
        Node<T> temp = this.head;
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

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (size == 0) {
            head = newNode;
            tail = newNode;
            size = 1;
            return;
        }
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        newNode.next = null;
        temp.next = newNode;
        tail = newNode;
        size++;
    }

    private int indexOf(Object o) {
        Node<T> temp = head;
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

    public boolean contains(T target) {
        if (this.size() == 0) {
            System.err.println("List is empty!");
            return false;
        }
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(target)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public Object sum() {
        if (this.size() == 0) {
            System.err.println("List is empty!");
            return null;
        }
        if (!(this.head.data instanceof Number)) {
            System.err.println("Summation not possible for non-numeric types.");
            return null;
        }
        Node<T> temp = this.head;
        double sum = 0.0;
        while (temp != null) {
            sum += ((Number) temp.data).doubleValue();
            temp = temp.next;
        }
        return sum;
    }

    public Node<T> largestNode() {
        if (size == 0) {
            System.err.println("List is empty!");
            return null;
        }
        if (!(head.data instanceof Number)) {
            System.err.println("Largest node not possible for non-numeric types.");
            return null;
        }
        Node<T> temp = this.head;
        double max = 0.0;
        Node<T> largest = this.head;
        while (temp != null) {
            if (((Number) temp.data).doubleValue() > max) {
                max = ((Number) temp.data).doubleValue();
                largest = temp;
            }
            temp = temp.next;
        }

        return largest;
    }

    public int findIndex(T target) {
        if (size == 0) {
            System.err.println("List is empty!");
            return -1;
        }
        Node<T> temp = this.head; int index = 0;
        while (temp != null) {
            if (temp.data.equals(target)) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    public void insert(T data, int index) {
        Node<T> newNode = new Node<>(data);
        if (size == 0) {
            System.err.println("List is empty! Creating a new node.");
            head = newNode;
            tail = newNode;
            size = 1;
        }
        int listIndex = 0; Node<T> temp = head;
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

    public Node<T> merge(ListADT<T> list) {
        if (list.head == null) {
            return this.head;
        } else if (this.size == 0) {
            this.head = list.head;
            int newListSize = size(list.head);
            if (newListSize == 0) {
                return null;
            }
            Node<T> temp = this.head;
            for (int i = 0; i < newListSize; i++) {
                temp = temp.next;
            }
            this.tail = temp;
            return this.head;
        } else {
            this.tail.next = list.head;
            Node<T> temp = list.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            this.tail = temp;
            return this.head;
        }
    }

    public void remove(T o) {
        if (size == 0) {
            System.err.println("List is empty!");
            return;
        }
        Node<T> temp = head;
        Node<T> prev = null;
        while (temp != null) {
            if (temp.data.equals(o)) {
                if (prev == null) {
                    head = temp.next;
                } else {
                    prev.next = temp.next;
                }
                size--;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    public void remove(int index) {
        if (size == 0) {
            System.err.println("List is empty!");
        }

        Node<T> temp = head;
        Node<T> prev = null;
        int i=0;
        for (i = 0; i < index; i++) {
            prev = temp;
            temp = temp.next;
        }
        if (i == index) {
            if (prev == null) {
                head = temp.next;
            } else {
                prev.next = temp.next;
            }
            size--;
        }
    }

    public boolean isSorted() {
        if (!(head.data instanceof Comparable)) {
            System.err.println("Wrong type of list! Elements are not comparable.");
            return false;
        }
        if (size == 0 || size == 1) {
            System.err.println("Insufficient elements to determine sorting!");
            return false;
        }
        Node<T> current = head.next;
        Node<T> prev = head;
        while (current != null) {
            if (((Comparable<T>) prev.data).compareTo(current.data) > 0)
                return false;

            prev = current;
            current = current.next;
        }
        return true;
    }

    public void removeDuplicates() {
        if (size == 0) {
            System.err.println("List is empty!");
            return;
        }
        if (size == 1) {
            if (head.data.equals(head.next)) {
                head = head.next;
            }
            return;
        }
        if (isSorted()) {
            removeDuplicatesSorted();
        } else {
            removeDuplicatesUnsorted();
        }
    }

    private void removeDuplicatesUnsorted() {
        if (size == 0) {
            System.err.println("List is empty!");
        }

        Node<T> current = head;
        while (current != null) {
            Node<T> lead = current.next;
            Node<T> trail = current;
            while (lead != null) {
                if (lead.data.equals(current.data)) {
                    trail.next = lead.next;
                    size--;
                }
                trail = lead;
                lead = lead.next;
            }
            current = current.next;
        }
    }

    private void removeDuplicatesSorted() {
        Node<T> leading = this.head;
        Node<T> trailing = null;
        int duplicateCount = 0;
        while (leading != null) {
            if (trailing != null && leading.data.equals(trailing.data)) {
                trailing.next = leading.next;
                leading = leading.next;
                duplicateCount++;
            }
            trailing = leading;
            leading = leading.next;
        }
        size -= duplicateCount;
    }

    public void reverse() {
        if (size == 0) {
            System.out.println("List is empty!");
        }
        Node<T> A = null;
        Node<T> B = null;
        Node<T> C = head;
        while (C != null) {
            A = B;
            B = C;
            C = C.next;
            head = B;
            B.next = A;
        }
    }

    public Node<T> createList(T[] arr) {
        for (T t : arr) {
            Node<T> newNode = new Node<>(t);
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
}
