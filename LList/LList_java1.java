
public class LList_java1 {

    public static class Node {

        int data;
        Node next;

        public Node(int d) {
            this.data = d;
            this.next = null;
        }

    }
    public static Node Head;
    public static Node Tail;

    public void addFirst(int data) { //O(1)
        Node newNode = new Node(data);
        //step-2 newNpde next = head
        if (Head == null) {
            Head = Tail = newNode;
            return;
        }

        newNode.next = Head;

        //step3 - head == newNOde
        Head = newNode;
    }

    //add Last 
    public void addLast(int data){ //O(1)
        Node newNode = new Node(data);
        if(Head ==null){
            Head = Tail = newNode;
            return;
        }
        Tail.next = newNode ;
        Tail = newNode;
    }

    public  void printLl(Node Head){
        Node temp = Head;
        while (temp != null) {
            System.out.print(temp.data +"->");
            temp = temp.next;
        }System.out.print("null");
    }

    public static void main(String[] args) {
        LList_java1 ll = new LList_java1();
        ll.addFirst(1);
        ll.addFirst(12);
        ll.addFirst(13);
        ll.addFirst(15);
        ll.addLast(15);
        ll.addLast(120);

        ll.printLl(Head);
    }
}
  