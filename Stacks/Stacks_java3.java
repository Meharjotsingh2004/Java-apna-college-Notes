
import java.util.*;



public class Stacks_java3 {


// stock span problem 
    public static void stockSpan(int stocks [] , int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for(int i=1; i < stocks.length ; i++){
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice >= stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            }else{
                int prevHigh = s.peek();
                span[i] = i-prevHigh;
            }
            s.push(i);
        }
    }

    // Next Greater Element

    public static void main(String[] args) {
        int stocks[] = {100 , 80 , 60 , 70 , 60 , 85 , 100};
        int span []= new int[stocks.length];
        stockSpan(stocks , span);

        for(int i=0 ; i< span.length ; i++){
            System.out.print(span[i]+" ");
        }System.out.println();

        // Next Greater Element
        int arr[] = {6,8,0,1,3};
        Stack <Integer> s = new Stack<>();
        int nxtGreater[] = new int[arr.length];

        for(int i= arr.length -1 ; i>=0 ; i--){
            //1
            while(!s.isEmpty()  && arr[s.peek()] <= arr[i]){
                s.pop();
            }

            //2
            if(s.isEmpty()){
                nxtGreater[i] = -1;
            }else{
                nxtGreater[i]  = arr[s.peek()];
            }

            //3 
            s.push(i);
        }

        for(int i=0 ; i< arr.length ; i++){
            System.out.print(nxtGreater[i]+" ");
        }System.out.println();

        //nxt greater leftSide ;  more examples 
        //nxt greater rideSide;
        //nxt smaller right and left ;
    }    
}
