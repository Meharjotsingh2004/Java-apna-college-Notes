import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class practice {
    
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

     public static int lcs(int arr[] , int arr2[]){
        int n = arr.length;
        int m = arr2.length;

        int dp[][] = new int[n+1][m+1];

        for(int i = 0 ; i< dp.length ; i++){
            dp[i][0] = 0;
        }
        for(int i = 0 ; i< dp[0].length ; i++){
            dp[0][1] = 0;
        }

        for(int i = 1 ; i< n+1 ; i++){
            for(int j= 1 ; j< m+1 ; j++){
                if(arr[i-1] == arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                   dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
     }
     

public static class Edge{
    int src;
    int dest;

    public Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }

  
}
     
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
     
    public static void main(String[] args) {

        List<List<Edge>> graph = new ArrayList<>();


        Edge e = new Edge(3,2);
        
        

    }
}