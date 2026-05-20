import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyDequeImpl<T> implements MyDeque<T> {
    
    private MyDoublyLinkedList<T> list;

    public MyDequeImpl() {
        list = new MyDoublyLinkedList<>();
    }

    public MyDequeImpl(T data) {
        list = new MyDoublyLinkedList<>(data);
    }

    @Override
    public void addFirst(T data) {
       list.addFirst(data);
    }

    @Override
    public void addLast(T data) {
        list.addLast(data);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public boolean contains(T data) {
        return list.contains(data);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean offer(T data) {
        list.addLast(data);
        return true;
    }

    @Override
    public T peek() {
        try {
            return list.getFirst();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public T peekFirst() {
        try {
            return list.getFirst();
        } catch(Exception e) {
            return null;
        }
    }

    @Override
    public T peekLast() {
        try {
            return list.getLast();
        } catch(Exception e) {
            return null;
        }
    }

    @Override
    public T poll() {
        // retrieves and removes the element at the head of the queue.
        if (list.isEmpty()) {
            return null;
        }

        return list.removeFirst();
    }

    @Override
    public T pop() {
        return list.removeFirst();
    }

    @Override
    public void push(T data) {
        list.addFirst(data);
    }

    @Override
    public T removeFirst() {
        return list.removeFirst();
    }

    @Override
    public boolean removeFirstOccurrence(T data) {
        int index = 0;
        for(T value : list) {
            if (Objects.equals(value, data)) {
                list.removeAt(index);
                return true;
            } else {
                index ++;
            }
        }

        return false;
    }

    @Override
    public T removeLast() {
        return list.removeLast();
    }

    @Override
    public boolean removeLastOccurrence(T data) {
        int index = list.getSize() - 1;
        Iterator<T> it = list.descendingIterator();
        while (it.hasNext()) {
            T value = it.next();
            if (Objects.equals(data, value)) {
                list.removeAt(index);
                return true;
            }
            index--;
        }

        return false;
    }

    @Override
    public int size() {
        return list.getSize();
    }
    
}
