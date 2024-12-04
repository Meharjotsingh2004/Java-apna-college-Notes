

public class DP_java7 {


    //Matric chaim Multiplication with recusrion 
    public static int mcm(int arr[] , int i , int j){
        if(i==j){ //single Matrix CAse
            return  0;
        }
        int ans = Integer.MAX_VALUE;
        for(int k = i;k<=j-1 ; k++){
            int cost1 = mcm(arr, i, k); //Ai...Ak ==>arr[i-1]Xarr[k]
            int cost2 = mcm(arr, k+1, j); //Ak+1 ... Aj ==> arr[k]Xarr[j]
            int cost3 = arr[i-1] * arr[k] * arr[j];

            int finalCost = cost1 + cost2 + cost3;
            ans = Math.min(ans, finalCost);

        }
        return  ans;
    }
     
    //Matric chaim Multiplication with Memoization 
     public static int mcmMemoization(int arr[] , int i ,  int j , int dp[][]){
        if(i==j){
            return  0;
        }
        if(dp[i][j] != -1){
            return  dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i ; k <= j-1 ; k++ ){
            int cost1 = mcmMemoization(arr, i, k, dp);
            int cost2 = mcmMemoization(arr, k+1, j, dp);
            int cost3 = arr[i-1] * arr[k]*arr[j];
            ans = Math.min(ans,  cost3+cost1+cost2 );
        }
        return dp[i][j] = ans;
     }


      //Matric chaim Multiplication with Tabulation -->
      public static int mcmTabulation(int arr[]){
        int n = arr.length;
        int dp[][] = new int[n][n];

        //intiallizing
        for(int i=0 ; i< n ;i++){
            dp[i][i] = 0;
        }
        //bottom -up
        for(int len= 2 ;len <=n-1 ; len++ ){
            for(int i =1 ; i<=n-len ; i++){
                int j = i+len-1; //col
                dp[i][j] = Integer.MAX_VALUE;
                for(int k =i ;k<=j-1 ; k++){
                    int cost1 = dp[i][k];
                    int cost2 = dp[k+1][j];
                    int cost3 = arr[i-1]*arr[k]*arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost1+cost2+cost3);
                }
            }
        }
       return  dp[1][n-1];
      }
    public static void main(String[] args) {
      int arr[] = {1,2,3,4,3};
      int n = arr.length;

      System.out.println(mcm(arr, 1, n-1)); //Matric chaim Multiplication with recusrion 

      //Matric chaim Multiplication with Memoization 
      int dp[][]  = new int[n][n];
      for(int i =0; i< n; i++){
        for(int j=0; j< n ; j++){
            dp[i][j] = -1;
        }
      }
      System.out.println("With Memoization : "+ mcmMemoization(arr, 1, n-1, dp));

            //Matric chaim Multiplication with Tabulation -->
            System.out.println(mcmTabulation(arr));
    }


}
