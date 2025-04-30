
public class BTracking_java1 {

    public static void changeArr(int arr[], int i, int val) {  //timecomplexity = O(n)
        //base case

        if (i == arr.length) {
            printArr(arr);
            return;
        }
        //recursion
        arr[i] = val;
        changeArr(arr, i + 1, val + 1);
        arr[i] = arr[i] - 2;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //Finding subsets of Strings
    public static void findSubsets(String str, String ans, int i) { //TC = O(n* n!)
        //base Case
        if (i == str.length()) { 
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }

            return;
        }

        //recurrsion
        //Yes Choice
        findSubsets(str, ans + str.charAt(i), i + 1);
        //No Choice
        findSubsets(str, ans, i + 1);
    }

    //Find Permutation for String 
    public static void findPermutation(String str , String ans){
        //base case

        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        //recurssion

        for(int i=0 ; i< str.length() ; i++){
            char curr = str.charAt(i);
            //"abcde" => "ab"+"de" = "abde"
            String newstr = str.substring(0,i) + str.substring(i+1);
            findPermutation(newstr, ans+curr);
        }
    }
    public static void main(String[] args) {
        int arr[] = new int[5];
        changeArr(arr, 0, 1);
        printArr(arr);
        System.out.println();

        //Finding subsets of Strings
        String str = "abc";
        findSubsets(str, "", 0);System.out.println();

        //finding Permutation
        findPermutation("abc", "");
    }

}
