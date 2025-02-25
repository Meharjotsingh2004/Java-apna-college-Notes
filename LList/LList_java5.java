
public class LList_java5 {

    static public class Node{
        int data ;
        Node next;
        public Node (int d ){
            this.data = d;
            this.next = null;
        }
    }

    public static  void zigZagLList(Node head){
        //find Middle
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        //reverse Second HAlf
        Node curr = mid.next;
        mid.next = null;

        Node prev = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev ;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node  right = prev;

        Node nextL , nextR;
        while(left !=null && right != null){
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
        //alt Merge-zigzag
    }
public static void printLL(Node head){
    Node temp = head;

    while(temp !=null ){
        System.out.print( temp.data+"->");
        temp = temp.next;
    }System.out.println("null");
}
    public static void main(String[] args) {
        
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        printLL(head);
        zigZagLList(head);
        printLL(head);
    }
}
