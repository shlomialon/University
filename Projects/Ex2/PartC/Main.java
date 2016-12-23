package PartC;

import java.util.ListIterator;

/**
 * Created by Shlomi Alon on 22/12/2016.
 */
public class Main {
    public static void main(String[] args) {
        LinkedListDouble<Object> list = new LinkedListDouble<>();
        list.add(4);
        list.add("Shlomi");
        list.add(6);
        list.add(7.8);
        //TEST - hasNext()| next() | nextIndex()
         ListIterator<Object> iter1 = list.listIterator();
         while (iter1.hasNext()){
         System.out.println(iter1.next() + " - Index at: " + iter1.nextIndex());
        }
        System.out.println("/////////////////////////");
        //TEST - hasPrevious()| previous()
        ListIterator<Object> iter2 = list.listIterator();
        while (iter2.hasPrevious()) {
            System.out.println(iter2.previous() + " - Index at: " + iter1.previousIndex());
        }


    }
}
