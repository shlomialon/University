package PartC;

import java.util.ListIterator;

/**
 * Created by Shlomi Alon on 22/12/2016.
 */
public class Main {

    public static void TestLinkedListDouble() {
        LinkedListDouble<Integer> l1 = new LinkedListDouble<>();
        System.out.println("the list should be an empty ->\t" + l1.toString());
        //System.out.println("the head should be null ->\t"+l1.getHead());
        //System.out.println("the tail should be null ->\t"+l1.getTail());
        System.out.println();

        System.out.println("now we add only one node with data=10");
        l1.add(10);
        System.out.println("now we check all methods");

        System.out.println("let's print the list (should print \"10,\" ->\t" + l1.toString());

        System.out.println("now we print the size of the list shoule print 1 ->\t" + l1.size());

        System.out.println("check contains on 10");
        System.out.println("should return true ->\t" + l1.contains(10));
        System.out.println("check contains on null");
        System.out.println("should return false ->\t" + l1.contains(null));
        System.out.println("check contains on 11");
        System.out.println("should return false ->\t" + l1.contains(11));

        System.out.println("now we remove the element 12");
        System.out.println("the element 12 not exist should return null ->\t" + l1.remove(12));
        System.out.println("now we remove the element null");
        System.out.println("the element null not exist should return null ->\t" + l1.remove(null));
        System.out.println("now we remove the element 10");
        System.out.println("the element 10 exist should return 10 ->\t" + l1.remove(10));

        System.out.println("now we print the size of the list shoule print 0 ->\t" + l1.size());
        System.out.println("let's print the list (should print \"empty list\" ->\t" + l1.toString());

        System.out.println("now we add only one node with data=5");
        l1.add(5);
        System.out.println("let's print the list (should print \"5,\" ->\t" + l1.toString());
        System.out.println("now we print the size of the list shoule print 1 ->\t" + l1.size());

        System.out.println("now we add only one node with data=49");
        l1.add(49);
        System.out.println("let's print the list (should print \"5,49,\" ->\t" + l1.toString());
        System.out.println("now we print the size of the list shoule print 2 ->\t" + l1.size());

        System.out.println("now we add only one node with data=1");
        l1.add(1);
        System.out.println("let's print the list (should print \"5,49,1,\" ->\t" + l1.toString());
        System.out.println("now we print the size of the list shoule print 3 ->\t" + l1.size());
        System.out.println();

        System.out.println("now we add only one node with data=32");
        l1.add(32);
        System.out.println("let's print the list (should print \"5,49,1,32,\" ->\t" + l1.toString());
        System.out.println("now we print the size of the list shoule print 4 ->\t" + l1.size());
        System.out.println();

        System.out.println("now we add only one node with data=9");
        l1.add(9);
        System.out.println("let's print the list (should print \"5,49,1,32,9,\" ->\t" + l1.toString());
        System.out.println("now we print the size of the list shoule print 5 ->\t" + l1.size());
        System.out.println();

        System.out.println("check contains on \"1\" should return true ->\t" + l1.contains(1));
        System.out.println();

        System.out.println("now we remove \"9\" should return 9 ->\t" + l1.remove(9));
        System.out.println("let's print the list (should print \"5,49,1,32,\" ->\t" + l1.toString());
        System.out.println("now we print the size of the list shoule print 4 ->\t" + l1.size());
        System.out.println();

        System.out.println("now we remove \"49\" should return 49 ->\t" + l1.remove(49));
        System.out.println("let's print the list (should print \"5,1,32,\" ->\t" + l1.toString());
        System.out.println("now we print the size of the list shoule print 3 ->\t" + l1.size());
        System.out.println();

        System.out.println("now we remove \"1\" should return 1 ->\t" + l1.remove(1));
        System.out.println("let's print the list (should print \"5,32,\" ->\t" + l1.toString());
        System.out.println("now we print the size of the list shoule print 2 ->\t" + l1.size());
        System.out.println();

        System.out.println("check contains on \"1\" should return false ->\t" + l1.contains(1));
        System.out.println();

        System.out.println("----------------------------------------------------------");
        System.out.println("now we check the Iterator");
        l1.add(8);
        l1.add(99);
        l1.add(76);
        l1.add(61);

        System.out.println("now we run the list with th Iterator next and previous end print the element + index");
        System.out.println();
        System.out.println("please chack the element by following list \n  remember that first index is-'0' and last index is the list size");
        System.out.println(l1.toString());
        ListIterator<Integer> iterator = l1.listIterator();

        System.out.println("           ----Iiterator head to tail----");
        while (iterator.hasNext()) {
            System.out.print("should return the element  -> " + iterator.next() + ",\t");
            System.out.print("should return the index  -> " + iterator.nextIndex());
            System.out.println();
        }
        System.out.println();
        System.out.println("now we check the Exception on method next");
        System.out.println("should be an Exception \"NoSuchElementException\"");
//		iterator.next();

        System.out.println("----Iiterator tail to head----");
        while (iterator.hasPrevious()) {
            System.out.println("should return the element  ->" + iterator.previous());
            System.out.println("should return the index  ->" + iterator.previousIndex());
        }
        System.out.println();
        System.out.println("now we check the Exception on method next");
        System.out.println("should be an Exception \"NoSuchElementException\"");
//		iterator.previous();


        System.out.println("----------------------------------------------------------");
        System.out.println("now we check the Exceptions");
        System.out.println("should be an Exception \"RuntimeException\"");

        //iterator.add(null);
        //iterator.remove();
        //iterator.set(null);
    }

    public static void main(String[] args) {
//
//        LinkedListDouble<Object> list = new LinkedListDouble<>();
//        list.add(4);
//        list.add("Shlomi");
//        list.add(6);
//        list.add(7.8);
//        System.out.println(list.toString());
//        System.out.println(list.size());
        //TEST - hasNext()| next() | nextIndex()
//         ListIterator<Object> iter1 = list.listIterator();
//         while (iter1.hasNext()){
//         System.out.println(iter1.next() + " - Index at: " + iter1.nextIndex());
//        }
//        System.out.println("/////////////////////////");
//        //TEST - hasPrevious()| previous()
//        ListIterator<Object> iter2 = list.listIterator();
//        while (iter2.hasPrevious()) {
//            System.out.println(iter2.previous() + " - Index at: " + iter1.previousIndex());
//        }

        TestLinkedListDouble();

    }
}
