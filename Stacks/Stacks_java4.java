
import java.util.*;

public class Stacks_java4 {

    //valid Parentheses QUES    
    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for(int i=0 ;i<str.length() ; i++){
            char ch = str.charAt(i);

            if(ch=='(' || ch=='{' || ch =='['){ //opening
                s.push(ch);
            }else{//closing
                if(s.isEmpty()){
                    return false;
                }
                if((s.peek() == '(' && ch==')')  //()
                || (s.peek()=='{' && ch=='}') //{}
                ||(s.peek() =='[' && ch ==']')){ //[]
                    s.pop();
                }else{
                    return false;
                }
            }
        }
        return s.isEmpty();
    }

    //valid parentheses isvalid(Duplicate)

    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();
       
        for(int i=0 ;i<str.length() ; i++){
            char ch = str.charAt(i);

            //closing
            if(ch== ')'){
                int count =0 ;
                while( s.peek() !='('){
                    s.pop();
                    count++;
                }
                if(count <1){
                    return true ; //Duplicate
                }else{
                    s.pop(); //opening pair
                }
            }else{
                //opening 
                s.push(ch);
            }
        }

        return false;
    }

    //Max Possible area of Histogram
    public static void maxArea(int arr[]){

        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];


        //Next smaller Right
        Stack<Integer> s = new Stack<>();

        for(int i=arr.length-1 ; i>=0  ; i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop(); 
            }
            if(s.isEmpty()){
                //-1
                nsr [i] = arr.length;
            }else{
                //top
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        //Next smaller Left
         s = new Stack<>();

        for(int i=0 ; i< arr.length  ; i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop(); 
            }
            if(s.isEmpty()){
                //-1
                nsl [i] = -1;
            }else{
                //top
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        //current Area : width = nsr[i] -nsl[i]-1;
        for(int i=0 ; i< arr.length ; i++ ){
            int height = arr[i];
            int width = nsr[i] -nsl[i] -1;
            int currArea = height*width;
            maxArea = Math.max(currArea, maxArea);
        }

        System.out.println("Max Area In Histogram = " + maxArea);
    }
    public static void main(String[] args) {

        String str = "({})[]"; //True
        System.out.println(isValid(str));

        String st2 = "((a+b))"; //true
        String st3 = "(a-b)";  //false 

        System.out.println(isDuplicate(st3) ); 


        int arr[] = {2,1,5,6,2,3} ;// heights in Histogram

        maxArea(arr);
    }
}
