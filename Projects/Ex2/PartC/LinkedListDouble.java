package PartC;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Created by Shlomi Alon on 22/12/2016.
 */
public class LinkedListDouble<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedListDouble() {
        this.tail = null;
        this.head = null;
        this.size = 0;
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
        return (size() < 0);
    }

    public int size() {
        return this.size;
    }

    public T remove(T item) {
        Node<T> current = head;
        while (!isEmpty()) {
            current = current.next;
            if (current.getData().equals(item)) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                size--;
                break;
            }
        }
        return current.getData();
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

    public ListIterator<T> listIterator(){
        return new ListIterator<T>(){
            Node<T> current;
            Node<T> currentTail;
            int indexPre;
            int indexPost;
            {
                current = head;
                currentTail = tail;
                indexPre = -1;
                indexPost = size;
            }
            @Override
            public boolean hasNext() {return current != null;}

            @Override
            public boolean hasPrevious() {return currentTail != null;}

            @Override
            public T next() {
                T tmp = current.getData();
                if(!hasNext()) {return null;}
                current = current.next;
                return tmp;
            }

            @Override
            public T previous() {
                T tmp = currentTail.getData();
                if(!hasPrevious()) { return null; }
                currentTail = currentTail.prev;
                return tmp;
            }

            @Override
            public int nextIndex() {return indexPre = indexPre+1;}

            @Override
            public int previousIndex() {return indexPost = indexPost-1;}

            @Override
            public void remove() {throw new RuntimeException();}

            @Override
            public void set(T t) {throw new RuntimeException();}

            @Override
            public void add(T t) {throw new RuntimeException();}
        };
    }
}
