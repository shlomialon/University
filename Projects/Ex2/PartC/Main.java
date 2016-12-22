package PartC;
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
        System.out.println(list.toString());
        list.remove(6);
        System.out.println(list.toString());
        System.out.println(list.contains("Shlomi"));
        System.out.println(list.isEmpty());
    }
}
