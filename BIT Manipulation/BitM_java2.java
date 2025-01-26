
public class BitM_java2 {

//check Weather number is power of two or not
    public static boolean isPowerTwo(int n) {

        return (n & (n - 1)) == 0;
    }

//Count of Set Bits in Given Number
    public static int countSetBITS(int n) {
        int count = 0;

        // while (n != 0) {
        //     if (n % 2 != 0) {
        //         count++;
        //         n = n >> 1;
        //     } else {
        //         n = n >> 1;
        //     }
        // }
        //2nd Approach
        while (n > 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

//fast Exponentiation
    public static int fastExpo(int a, int n) {
        int ans =1;

        while(n>0){
            if((n&1) !=0){ //check LSB
                ans = ans*a;
            }
            a = a*a;
           n= n>>1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(isPowerTwo(16));//check Weather number is power of two or not
        System.out.println(countSetBITS(31));//Count of Set Bits in Given Number
        System.out.println(fastExpo(5, 100));

    }
}
