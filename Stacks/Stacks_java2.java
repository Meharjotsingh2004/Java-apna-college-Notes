
import java.util.*;

public class Stacks_java2 {
//push At Bottom Of Stack

    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);

    }

//reversing a String using a Stack
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();

        int idx = 0;
        while (idx != str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder("");
        while (!s.isEmpty()) {
            result.append(s.pop());
        }
        return result.toString();
    }

//Reversing A Stack
    public static void reverseStack(Stack<Integer> s) {

        if (s.isEmpty()) {
            return;
        }
        int curr = s.pop();
        reverseStack(s);
        pushAtBottom(s, curr);
    }

    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>(); //Made Using java Collection Framework

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        pushAtBottom(s, 5);

        System.out.println(s);
        // while (!s.isEmpty()) {
        //     System.out.println(s.pop());
        // }
//reversing a  Stack
        reverseStack(s);
        printStack(s);

//reversing a String using a Stack
        System.out.println(reverseString("Meharjot Hello"));
        System.out.println();
    }
}
