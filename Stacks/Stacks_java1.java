
import java.util.*;

public class Stacks_java1 {

    //implementing stack with ArrayList
    @SuppressWarnings("unused")
    static class Stack {

        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty() {
            return list.isEmpty();
        }

        //push
        public static void push(int data) {
            list.add(data);
        }

        //pop 
        public static int pop() {
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        //peek
        public static int peek() {
            return list.get(list.size() - 1);
        }
    }

    //Implementing stack with LinkedList
    static  class StackB {

        static class Node {

            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        static class Stack {

            static Node head = null;

            public static boolean isEmpty() {
                return head == null;
            }

            //push
            public static void push(int data) {
                Node temp = new Node(data);

                if (isEmpty()) {
                    head = temp;
                    return;
                }
                temp.next = head;
                head = temp;
            }

            //pop
            public static int pop() {
                if (isEmpty()) {
                    return -1;
                }
                int top = head.data;
                head = head.next;
                return top;
            }
            
            //peek
            public static int peek(){
                if(isEmpty()){return  -1;}
                return head.data;
            }
        }
    }

    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        StackB.Stack s = new StackB.Stack();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        while (!s.isEmpty()) {
            System.out.print(s.peek() + " ");
            s.pop();
        }
    }
} 
