
public class DP_java2 {
//Calculate no of ways of climbing stiars
//With Memoization time complexity = O(n)

    public static int countWays(int n, int ways[]) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (ways[n] != 0) { //already claculated 
            return ways[n];
        }
        ways[n] = countWays(n - 1, ways) + countWays(n - 2, ways);
        return ways[n];
    }

//With Tabulation (Bottom up)  time complexity = O(n)
    public static int countWaysTabulation(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2 ; i<=n ; i++){
            dp[i] = dp[i-1]+ dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4; //Ans =8
        int ways[] = new int[n + 1];
        System.out.println(countWays(n, ways));
        System.out.println(countWaysTabulation(n));
    }

}
