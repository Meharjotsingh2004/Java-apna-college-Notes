
public class LLIst_java3 {

    static class Node {

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

    public void printLl(Node Head) {
        Node temp = Head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static boolean isCycle() { //Floyds Cycle finding method
        Node slow = Head;
        Node fast = Head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true; //cycyle exist 
            }
        }
        return false;

    }

    public static void removeCycle() {
        Node slow = Head;
        Node fast = Head;

        boolean cycle = false;
        while (fast != null && fast.next != null && !cycle) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                break;
            }
        }
        if (cycle == false) {
            return;
        }
        
        slow = Head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null ;
    }

    public static void main(String[] args) {
        LLIst_java3 ll = new LLIst_java3();

        Head = new Node(1);
        Head.next = new Node(10);
        Node temp = new Node(20);
        Head.next.next = temp;
        Head.next.next.next = new Node(14);
        Head.next.next.next.next = new Node(15);
        Head.next.next.next.next.next = temp;

        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());
    }
}
