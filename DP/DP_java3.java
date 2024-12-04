
public class DP_java3 {

    //Memoization Is used in this code(top down )- 0-1 knapsack
    public static int knapsacks(int val[], int wt[], int W, int n, int dp[][]) {
        //Memoization Is used in this code(top down )- knapsack
        if (W == 0 || n == 0) {
            return 0;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }
        if (wt[n - 1] <= W) {//valid
            //include
            int ans1 = val[n - 1] + knapsacks(val, wt, W - wt[n - 1], n - 1, dp);
            //exclude
            int ans2 = knapsacks(val, wt, W, n - 1, dp);

            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        } else {//not valid
            dp[n][W] = knapsacks(val, wt, W, n - 1, dp);
            return dp[n][W];
        }
    }

    //With tabulation method (Bottum up ) - 0-1 knapsack
    public static int knapsackTabulation(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < dp.length; i++) { //0th columns
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) { //0th row
            dp[0][i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int v = val[i - 1];// ith item ki value 
                int w = wt[i - 1]; // ith item ka weight 
                if (w <= j) { //valid ki condition
                    int incProfit = v + dp[i - 1][j - w];
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else { //invalid
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        return dp[n][W];
    }

    //O(n*sum) Print wheather the target sum is present or not 
    public static boolean targetSumSubsetTabulation(int val[], int target) {
        int rows = val.length + 1;
        int columns = target + 1;

        boolean dp[][] = new boolean[rows][columns];

        for (int i = 0; i < dp.length; i++) { //0th row intialised
            dp[i][0] = true;
        }
        for (int i = 1; i < dp[0].length; i++) {//0th column intialised
            dp[0][i] = false;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                int v = val[i - 1];
                if (v <= j) { //valid 
                    if (dp[i - 1][j - v] == true) { //include
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i - 1][j]; //exclude
                    }

                } else {
                    dp[i][j] = dp[i - 1][j]; //Not Valid --exclude 
                }
            }
        }
        return dp[rows - 1][columns - 1];
    }

    //Unbounded Knapsack O(n*W)
    public static int unboundedKnapsack(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < W + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (wt[i - 1] <= j) { //valid
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                } else {//invalid
                    dp[i][j] = dp[i-1][j] ;
                }
            }
        }
        return dp[n][W];
        // for (int i = 1; i < n + 1; i++) {
        //     for (int j = 1; j < W + 1; j++) {
        //         System.out.print(dp[i][j] +" ");
        //     }System.out.println();
        // }
    }

    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;
        int dp[][] = new int[val.length + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        int numbers[] = {4, 2, 7, 1, 3};
        int TargetSum1 = 12;

        System.out.println(knapsacks(val, wt, W, val.length, dp));

        System.out.println(knapsackTabulation(val, wt, W));
        System.out.println(targetSumSubsetTabulation(numbers, TargetSum1));
        System.out.println(unboundedKnapsack(val, wt, W));
        // unboundedKnapsack(val, wt, W);
    }
}
    