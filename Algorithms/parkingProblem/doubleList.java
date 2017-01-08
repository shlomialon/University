package parkingProblem;

/**
 * Created by Shlomi Alon on 08/01/2017.
 */
public class doubleList {
    private Node head;
    private Node tail;
    private doubleList(){
        this.head = null;
        this.tail = null;
    }

    private void add(int item) {
        Node temp = new Node(item);
        if (this.head == null) {
            this.head = temp;
            this.tail = this.head;
        } else {
            this.tail.next = temp;
            temp.prev = this.tail;
            this.tail = temp;
        }
    }

    private static int parkingProblemWithLinearPart(doubleList list) {
        if(list == null || list.head == null) return 0;
        if(list.head.next == null) return 1;
        Node n = list.head.next, m = list.head.next.next;

        while (m != n && m != null){
            m = m.next;
            if (m != null)
                m = m.next;
            n = n.next;
        }

        if(m == null)
            return sizeOfList(list);

        int count = 0;
        m = list.head;
        while (m != n){
            m = m.next;
            n = n.next;
            count++;
        }

        m = m.next;
        count++;
        while (m != n) {
            m = m.next;
            count++;
        }
        return count;
    }

    private static int sizeOfList(doubleList list) {
        int count = 0;
        Node n = list.head;
        while(n != null) {
            n = n.next;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        doubleList list = new doubleList();
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(3);
        list.add(1);

        list.head.next.next.next.next.next.next = list.head.next.next;

        System.out.println(parkingProblemWithLinearPart(list));

    }
}
