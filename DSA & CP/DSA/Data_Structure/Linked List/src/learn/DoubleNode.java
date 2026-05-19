package src.learn;

public class DoubleNode<T> {
    private DoubleNode<T> prev;
    private T data;
    private DoubleNode<T> next;

    public DoubleNode(T data) {
        this.data = data;
    }

    public DoubleNode(DoubleNode<T> prev, T data, DoubleNode<T> next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }

    public void setPrev(DoubleNode<T> prev) {
        this.prev = prev;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    public DoubleNode<T> getPrev() {
        return prev;
    }

    public T getData() {
        return data;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

}
