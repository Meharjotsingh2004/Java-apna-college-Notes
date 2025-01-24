
import java.util.*;

public class Arrays_java1 {

    public static void update(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {

            arr[i] += arr[i];
        }

        for (int i = 0; i < n; i++) {
           
                System.out.print(arr[i] + " ");
            
        }System.out.println();
    }

public static int Largest(int  arr[]){
    int LargestV = Integer.MIN_VALUE;

    for(int i : arr){
        if(i > LargestV){
            LargestV  = i;
        }
    }
    return LargestV;
}
    public static void main(String[] args) {
        //Creating An Array
        int marks[] = new int[3];

        int number[] = {1, 2, 3};

        int moreNumbers[] = {4, 5, 6};

        String fruits[] = {"APPLE", "mango", "orange"};

        Scanner sc = new Scanner(System.in);

        marks[0] = sc.nextInt() ;
        marks[1] = sc.nextInt();
        marks[2] = sc.nextInt();

        update(marks);
        System.out.println(Largest(marks));
    }
}
