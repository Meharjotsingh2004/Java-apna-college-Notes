
import java.util.*;

public class LLIst_java4 {

    public static class Node {

        int data;
        Node next;

        public Node(int d) {
            this.data = d;
            this.next = null;
        }
    }

    public static Node getMidlOfLl(Node Head) {

        Node slow = Head;
        Node fast = Head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node merge(Node head1, Node head2) {

        Node mergeLL = new Node(-1);

        Node temp = mergeLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergeLL.next;
    }

    public static Node mergeSort(Node Head) {

        if (Head == null || Head.next == null) {
            return Head;
        }
        Node mid = getMidlOfLl(Head);

        //left & right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(Head);
        Node newRight = mergeSort(rightHead);

        //merge
        return merge(newLeft, newRight);
    }


    public static  void printLl(Node Head) {
        Node temp = Head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

  
    public static void main(String[] args) {
        //create
        LinkedList<Integer> ll = new LinkedList<>();

        //add
        ll.add(12);
        ll.add(13);
        ll.add(14);
        ll.add(15);
        ll.add(16);

        System.out.println(ll);
        //remove
        ll.removeLast();
        ll.removeFirst();
        System.out.println(ll + " ");

        Node Head = new Node(10);
        Head.next = new Node(9);
        Head.next.next = new Node(91);
        Head.next.next.next = new Node(0);
        Head.next.next.next.next = new Node(92);
        Head.next.next.next.next.next = new Node(100);
        Head.next.next.next.next.next.next = new Node(2);

        printLl(Head);
        Head = mergeSort(Head);
        printLl(Head);
      

        
    }
}
