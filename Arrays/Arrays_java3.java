//import java.util.*;

public class Arrays_java3 {

//MAX subarray SUM O(n^3) -- brute force
    public static void maxSubbarray(int numbers[]) {
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j;
                curSum = 0;
                for (int k = start; k <= end; k++) {
                    curSum += numbers[k];
                }
                // System.out.println(curSum);
                if (maxSum < curSum) {
                    maxSum = curSum;
                }
            }
        }
        System.out.println("MAximum Sum :" + maxSum);
    }
//Prefix Sum Arrays Approach O(n^2)

    public static void prefixSum(int numbers[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefixSum[] = new int[numbers.length];
        prefixSum[0] = numbers[0];

        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + numbers[i];
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                currSum = i == 0 ? prefixSum[j] : prefixSum[j] - prefixSum[i - 1];
                if (maxSum < currSum) {
                    maxSum = currSum;
                }
            }
        }
        System.out.println("MAx Sum Using prefix Sum " + maxSum);
    }

//KADANES Algorithm
    public static void kadanes(int numbers[]) {
        int maxSum = Integer.MIN_VALUE;
        int cs = 0;

        for (int i = 0; i < numbers.length; i++) {
            cs = cs + numbers[i];
            if (cs < 0) {
                cs = 0;
            }
            maxSum = Math.max(maxSum, cs);
        }
        System.out.println("max subarray sum is: " + maxSum);
    }

    public static void main(String[] args) {
        int number[] = {1, -2, 6, -1, 3};
        int numbers[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        maxSubbarray(number);
        prefixSum(number);
        kadanes(numbers);
    }

}
