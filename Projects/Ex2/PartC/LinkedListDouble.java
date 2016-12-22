package PartC;
import java.util.ListIterator;
/**
 * Created by Shlomi Alon on 22/12/2016.
 */
public class LinkedListDouble<T> implements ListIterator<T> {

    private Node<T> head;
    private Node<T> tail;
    private Node<T> iter;
    private int size;

    public LinkedListDouble() {
        this.tail = null;
        this.head = null;
        iter = head;
        this.size = 0;
    }

    public Node<T> getIter() {
        return iter;
    }

    @Override
    public boolean hasNext() {
        return (iter.getNext() != null);
    }

    @Override
    public T next() {
        if (hasNext())
            return iter.getNext().getData();
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return (iter.getPrev() != null);
    }

    @Override
    public T previous() {
        if(hasPrevious())
            return iter.getPrev().getData();
        return null;
    }

    @Override
    public int nextIndex() {
        return 0;
    }

    @Override
    public int previousIndex() {
        return 0;
    }

    @Override
    public void remove() {

    }

    @Override
    public void set(T t) {
        if (iter == null) throw new IllegalStateException();
        iter.setData(t);
    }

    public void add(T item) {
        Node<T> temp = new Node<>(item);
        if (head == null) {
            head = temp;
            tail = head;
        } else {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
        size++;
    }


    public boolean contains(T item) {
        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(item))
                return true;
            current = current.getNext();
        }
        return false;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        String ans = "";
        Node<T> current = head;
        while (current != null && current != tail) {
            ans += current.getData() + " --> ";
            current = current.getNext();
        }
        return ans + tail.getData();
    }


}