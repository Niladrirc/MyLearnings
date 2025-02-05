package iterators;

import java.util.Iterator;

public class GenericList<T> implements Iterable<T> {
    private final T[] items;
    private int size;

    public GenericList() {
        this.items = (T[]) new Object[100];
        this.size = 0;
    }

    public boolean add(T value) {
        if (size == items.length) {
            System.out.println("List is full");
            return false;
        }
        items[size++] = value;
        return true;
    }

    public T getItemAtIndex(int index) {
        if (size < index) {
            System.out.println("ArrayIndexOutOfBounds");
            throw new ArrayIndexOutOfBoundsException();
        }

        return items[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new MyGenericIterator<T>(this);
    }




    private static class MyGenericIterator<E> implements Iterator<E> {

        private GenericList<E> list;
        private int index;

        public MyGenericIterator(GenericList<E> list) {
            this.list = list;
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return list.getItemAtIndex(index+1) != null;
        }

        @Override
        public E next() {
            return list.getItemAtIndex(index++);
        }
    }
}
