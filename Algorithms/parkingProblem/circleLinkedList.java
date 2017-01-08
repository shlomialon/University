package parkingProblem;

/**
 * Created by Shlomi Alon on 08/01/2017.
 */
public class circleLinkedList {

    Node head;
    Node tail;

    public circleLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void add(int item) {
        if (head == null) {
            head = new Node(item);
            tail = head;
        } else {
            Node n = new Node(item);
            n.next = head;
            n.prev = tail;
            tail.next = n;
            head.prev = n;
            tail = tail.next;
        }
    }
        public static int parkingProblem(int[] arr) {
        int count = 0;
        int start = (int)(Math.random()*arr.length);
        arr[start] = 1;
        boolean flag = true;

        while(flag){
            count++;
            if(arr[(count+start)%arr.length] == 1)
                arr[(count+start)%arr.length] = 0;
            if(arr[start%arr.length] == 0)
                flag = false;
        }
        return count;
    }


    public static void main(String[] args) {

        circleLinkedList l = new circleLinkedList();
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(1);
        l.add(5);
        l.add(1);

        l.head.data = 1;
        Node temp = l.head.next;
        boolean flag = true;

        while (flag) {
            int count = 1;
            while (temp.data != 1){
                count++;
                temp = temp.next;
            }

            temp.data = 0;
            int ans = count;
            while (count != 0){
                count--;
                temp = temp.prev;
            }

            if(temp.data == 1)
                temp = temp.next;
            if(temp.data == 0){
                flag = false;
                System.out.println(ans);
            }
        }
        int arr[] = {3,4,5,1,2,4,5};
        System.out.println(parkingProblem(arr));
    }
}
