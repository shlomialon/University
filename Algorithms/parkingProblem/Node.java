package parkingProblem;

/**
 * Created by Shlomi Alon on 08/01/2017.
 */
public class Node {
    Node next;
    Node prev;
    int data;

    public Node(int data){
        next = null;
        prev = null;
        this.data = data;
    }

}
