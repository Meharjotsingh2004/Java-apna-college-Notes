


public class LList_java2 {

    public static class Node {

        int data;
        Node next;

        public Node(int d) {
            this.data = d;
            this.next = null;
        }
    }

    public void addFirst(int data) { //O(1)
        Node newNode = new Node(data);
        size++;
        //step-2 newNpde next = head
        if (Head == null) {
            Head = Tail = newNode;
            return;
        }

        newNode.next = Head;

        //step3 - head == newNOde
        Head = newNode;
    }

    public void addInMiddle(int idx, int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = Head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

    }

    public static Node Head;
    public static Node Tail;
    public static int size;

    public void printLl(Node Head) {
        Node temp = Head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();

    }

    public int removeFirst() {
        if (size == 0) {
            System.out.println("LL is Empty");
            return Integer.MAX_VALUE;
        } else if (size == 1) {
            int val = Head.data;
            Head = Tail = null;
            size = 0;
            return val;
        }
        int val = Head.data;
        size--;
        Head = Head.next;
        return val;
    }

    public int removeLast() {
        if (size == 0) {
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = Head.data;
            Head = Tail = null;
            size = 0;
            return val;
        }
        //prev = i=size-2
        Node prev = Head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.data;
        prev.next = null;
        Tail = prev;
        size--;
        return val;
    }

    //search
    public int searchInLL(int key) {
        Node temp = Head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }
    
    
    //search in LL with Recursive
     public int searchRecusive(int key){
        return helper(Head , key);
     }

     public  int helper(Node Head , int key){
        if(Head==null){
            return -1;
        }
        if(Head.data == key){
            return 0;
        }
        int idx = helper(Head.next, key);
        if(idx ==-1){
            return -1;
        }
        return idx+1;
     }


     public  void deleteNthfromEnd(int n){
        int siz=0;
        Node temp = Head;
        while(temp!=null){
            temp = temp.next;
            siz++;
        }
        if(n== siz){
            Head = Head.next; //Remove Forst
            return;
        }
        //sz-n 
        int i=1;
        int iToFind = siz-n;
        Node prev = Head;
        while(i< iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;

     }
     //reversing the LinkedList
     public void reverse(){
        Node prev = null;
        Node curr = Tail = Head;
        Node next;
        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Head = prev;
     }


     public Node findMid(Node Head){  //Helper
        Node slow = Head;
        Node fast = Head;

        while(fast.next != null && fast != null ){
            slow = slow.next; //+1
            fast = fast.next.next; //+2
        }
        return slow;
     }

     public boolean checkPalindrome(){
        if(Head==null || Head.next ==null){
            return true;
        }
        //Step-1 find mide
        Node mideNode = findMid(Head);

        //Step-2 reverse 2nd half
        Node prev = null;
        Node curr = mideNode;
        Node next;
        while( curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev; //right half head
        Node left = Head;

        while (right != null) {
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right =  right.next;
        }
        return true;
     }
    public static void main(String[] args) {
        LList_java2 ll = new LList_java2();

        ll.addFirst(15);
        ll.addFirst(19);
        ll.addFirst(12);
        ll.addFirst(19);
        ll.addFirst(15);
       ll.addInMiddle(3, 1000);

        ll.printLl(Head);
        System.out.println(size);
        ll.removeFirst();
        ll.printLl(Head);
        System.out.println(size);
        ll.removeLast();
        ll.printLl(Head);
        System.out.println(size);
        System.out.println(ll.searchInLL(180));
        System.out.println(ll.searchRecusive( 1000));
        ll.reverse();
        ll.printLl(Head);
        ll.deleteNthfromEnd(2);
        ll.printLl(Head);
    

        System.out.println(ll.checkPalindrome());

    }
}
