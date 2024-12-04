public class DP_java6 {

    //Wild Card Matching Question 
    //O(n*m)
    public static boolean isMatch(String s , String p){
        int n = s.length();
        int m = p.length();

        boolean dp [][] = new boolean[n+1][m+1];

        //intialize
        dp[0][0] = true;
        //patter =" "
        for(int i=1 ; i< n+1 ; i++){
            dp[i][0] = false;
        }
        for(int j=1 ; j< m+1 ; j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-1];
            }else{
                dp[0][j] = false;
            }
        }
//bottom-up
        for(int i=1 ; i<n+1 ; i++){
            for(int j=1 ; j< m+1 ; j++){
                //case-1
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) =='?'){
                    dp[i][j]= dp[i-1][j-1];
                }else if(p.charAt(j-1) =='*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }else{
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }
   
   //Catalans Number
   public static int catalanRecursion(int n){
    if(n==0 || n==1){
      return 1;  
    }
    int ans = 0;
    for(int i=0 ; i< n ; i++){
        ans += catalanRecursion(i) * catalanRecursion(n-i-1);
    }
    return  ans;
   }
    
   // Catalans Number with memoization
    public static int catalanMemoization(int n , int dp[]){
        if(n==0 || n==1 ){
            return  1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int ans =0;
        for(int i=0 ; i< n ;i++){
            ans += catalanMemoization(i, dp) * catalanMemoization(n-i-1, dp);
            
        }
         return  dp[n] = ans;
    }

    //catalan Number with tabulation
    public static int catalanTabulation(int n){
        int dp[] = new int[n+1];

        dp[0] = dp[1] = 1;

        for(int i=2; i<n+1 ; i++){
            for(int j=0 ; j< i ; j++){
                dp[i] += dp[j] * dp[i-j-1] ; //ci = cj*ci-j-1
            }
        }

        return  dp[n];
    }
    
    //Counting BST Trees --> it is Form of Catalan numbers
    public static int countBSTTREE(int  n){
        int dp[] = new int[n+1];

         dp[0] = dp[1] = 1;

         for(int i=2 ; i< n+1; i++){
            for(int j=0 ; j< i; j++){
                int left = dp[j];
                int right = dp[i-j-1];
                dp[i] += left * right;
            }
         }

        return dp[n];
    }
    

    //Mountain Ranges Question  --> also A concept of catalan Number O(n^2)
    public static int mountainRanges(int n){
        int dp[] = new int[n+1];

        dp[0] = dp[1] = 1;

        for(int i =2; i< n+1 ; i++){
            //for i pairs --> mountain ranges = Ci
            for(int j=0; j< i ; j++){
                int inside = dp[j];
                int outside = dp[i-j-1];
                dp[i] += inside * outside; //Ci = Cj*Ci-j-1

            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        
        String s = "abc";
        String p = "***?f";
        System.out.println(isMatch(s, p));

        //  Catalans Number
        int n = 4;
        System.out.println("Catalans Number with Recursion : "+catalanRecursion(n));

        int dp[] = new int[n+1];
        for(int i=0; i< n+1 ; i++){
            dp[i] = -1;
        }
        System.out.println(catalanMemoization(n, dp));

        System.out.println(catalanTabulation(3));
         //Counting BST Trees --> it is Form of Catalan numbers
         System.out.println("Counting BST Trees : "+ countBSTTREE(3));

         //Mountain Ranges Question  --> also A concept of catalan Number O(n^2)
         System.out.println("Mountain Ranges : " + mountainRanges(4));


    }

}
 