
public class DP_java4 {

    //Print 2-D Matrix 
    public static void Print2d(int arr[][]) {
        int row = arr[0].length;
        int col = arr.length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Coin_change  Tabulation Coede
    public static int coinChange(int coins[], int sum) {
        int row = coins.length;
        int col = sum;
        int dp[][] = new int[row + 1][col + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < col + 1; j++) {
                if (coins[i - 1] <= j) {//valid Condition
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else { //Invalid 
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[row][col];
    }

    //Rod Cutting Length=n 
    public static int rodCutting(int lengths[], int price[], int rodLength) {
        int row = lengths.length;
        int col = rodLength;
        int dp[][] = new int[row + 1][col + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < col + 1; j++) {
                if (lengths[i - 1] <= j) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - lengths[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[row][col];
    }

    // Longest Subsequence with recursion , worst time complexity
    public static int longestSubSequence(String a, String b, int n, int m) {

        if (n == 0 || m == 0) {
            return 0;
        }
        if (a.charAt(n - 1) == b.charAt(m - 1)) {
            return longestSubSequence(a, b, n - 1, m - 1) + 1;
        } else {
            int ans1 = longestSubSequence(a, b, n - 1, m);
            int ans2 = longestSubSequence(a, b, n, m - 1);
            return Math.max(ans1, ans2);
        }

    }
    
    // Longest Subsequence with memoization 
    public static int longestSubSequence2(String a, String b, int n, int m , int dp[][]) {

        if (n == 0 || m == 0) {
            return 0;
        }
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        if (a.charAt(n - 1) == b.charAt(m - 1)) {
            return dp[n][m] = longestSubSequence2(a, b, n - 1, m - 1 ,dp) + 1;
        } else {
            int ans1 = longestSubSequence2(a, b, n - 1, m , dp);
            int ans2 = longestSubSequence2(a, b, n, m - 1,dp);
            return dp[n][m] = Math.max(ans1, ans2);
        }

    }
   

    // Longest Subsequence with Tabulation 
    public static int longestSubSequence3(String a , String b) {
        int n = a.length();
        int m = b.length();

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
                }else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        int coins[] = {2, 5, 3, 6};
        int sum = 10;
        // int coins [] = {1,2,3};
        // int sum = 4;
        System.out.println("coinChange : " +coinChange(coins, sum));

        //RodCutting inputs--->
        int length[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int rodLenght = 8;

        System.out.println("RodCutting : " +rodCutting(length, price, rodLenght));

        //LSC  Longest Subsequence
        String str1 = "abcdge";
        String str2 = "abedg";
        System.out.println(longestSubSequence(str1, str2 , str1.length() , str2.length()));

        // Longest Subsequence 2
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        //intaializing -->
        for(int i=0 ; i< n+1 ; i++){
            for(int j=0 ; j< m+1 ; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(longestSubSequence2(str1, str2, n, m, dp));

        // Longest Subsequence with Tabulation 
        String str3 = "abcde";
        String str4 = "ace";
        System.out.println("Longest Subsequence with Tabulation : "+longestSubSequence3(str3, str4));

    }
}
