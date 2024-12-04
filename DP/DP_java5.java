import java.util.*;




public class DP_java5 {

 //longestCommonSubString-->
    public static int longestCommonSubString(String a , String b) {
        int n = a.length();
        int m = b.length();
        int maxim = 0;
//Intializing --->
        int dp[][] = new int[n+1][m+1]; 
        for(int i=0 ; i< n+1; i++){
            for(int j=0; j< m+1 ; j++){
                dp[i][j] = 0;
            }
        }

        for(int i=1 ; i< n+1 ; i++){
            for(int j =1 ; j< m+1 ; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                    maxim = Math.max(dp[i][j], maxim);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return maxim;
    }


    //lcs for lis code
    public static int lcs(int arr1[] , int arr2[]){
        int n = arr1.length;
        int m = arr2.length;

        int dp[][] = new int[n+1][m+1];
        //intialize
        for(int i =0 ;i< n+1 ; i++){
            dp[i][0] = 0;
        }
        for(int i =0 ;i< m+1; i++){
            dp[0][i] = 0;
        }

        //bottom up
        for(int i=1 ; i< n+1 ; i++){
            for(int j=1 ; j< m+1 ; j++){
                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }
     //Longest Increasing Subsequence(LIS)
     public static int LIS(int arr[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i< arr.length ; i++){
            set.add(arr[i]);

        }
        int arr2[] = new int[set.size()];
        int i=0;
        for(int num : set){
            arr2[i] = num;
            i++;
        }

        Arrays.sort(arr2); //accesnding
        return lcs(arr , arr2);
     }
     
     
     //Edit Distance Problem -Given 2 Strings and return the number of operation to be performed
     //O(n*m)
     public static int editDistance(String str1 , String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];

        //intialize
        for(int i=0 ; i< n+1 ; i++){


            for(int j=0; j< m+1 ; j++){
                if(i==0){
                    dp[i][j] = j;
                }
                if(j==0){
                    dp[i][j] = i;
                }
            }
        }

        //bottom up
        for(int i=1; i< n+1 ; i++){
            for(int j=1 ; j< m+1 ; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int add = dp[i][j-1] +1;
                    int del = dp[i-1][j] +1;
                    int rep = dp[i-1][j-1] +1;
                    dp[i][j] = Math.min(add, Math.min(del, rep));
                }
            }
        }
        return dp[n][m];
     }

     //String Conversion delete and insert operations to be performed
     public  static  int stringConversion(String str1 , String str2){
        int lsc = longestCommonSubString(str1, str2);
        int noOfOperation = 0;
        noOfOperation = (str1.length()-lsc) + (str2.length()- lsc);

        return noOfOperation;
     }

     public static void main(String[] args) {
        //longestCommonSubString-->
        System.out.println("longestCommonSubString : " +longestCommonSubString("ABCDE", "ABGCE"));

        //Longest Increasing Subsequence
        int arr[]= {50,3,10,7,40,80};
        System.out.println("Longest Increasing Subsequence : " + LIS(arr));


         //Edit Distance Problem 
         String word1 = "intention";
         String word2 = "excecution";
         System.out.println("Edit Distance Problem : "+editDistance(word1, word2));

         System.out.println( "stringConversion : "+stringConversion("abc", "abcde"));
    }
}
