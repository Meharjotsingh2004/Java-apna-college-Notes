
public class BItM_java1 {

    public static void oddOrEven(int n) {
        int bitMask = 1;
        if ((n & bitMask) == 0) {
            System.out.println("Number is even");
        } else {
            System.out.println("Number is Odd");
        }
    }

    //gettin ith Bit
    public static int getIthBit(int n, int i) {
        int bitmask = 1 << i;
        if ((n & bitmask) == 0) {
            return 0;
        } else {
            return 1;
        }
    }
    //set ith Bit

    public static int setIthBit(int n, int i) {
        int bitMask = 1 << i;

        return n | bitMask;
    }
//clear ith Bit

    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1 << i);

        return n & bitMask;
    }
//Update ith Bit

    public static int updateIthBit(int n, int i, int newBit) {
        // if(newBit == 0){
        //     return clearIthBit(n, i);
        // }else{
        //     return setIthBit(n, i);
        // }

        //2nd Approach
        n = clearIthBit(n, i);
        int Bitmask = newBit << i;
        return n | Bitmask;

    }
    //clear LAst I Bits

    public static int clearIbits(int n, int i) {
        int bitMask = (~0) << i;
        return n & bitMask;
    }

//clear Bits in range
    public static int clearBitsInRange(int n, int i, int j) {
        // int a = ((~0) << (j+1));
        // int  b= (1<<i)-1;
        // int bitMask = a|b;

//2nd Approach
        int m = n;
        for (int k = i; k <= j; k++) {
            m = clearIthBit(m, k);
        }

        return m;
    }

    public static void main(String[] args) {
        System.out.println(5 & 6); //AND
        System.out.println(5 | 6); //OR
        System.out.println(5 ^ 6); //XOR
        System.out.println(~5); //NOT
        System.out.println(2 << 1); //Left Shift
        System.out.println(6 >> 1); //Right Shift


        //Check If Number is Odd Or Even
        // oddOrEven(12);
        // oddOrEven(12+1);


        System.out.println(getIthBit(10, 1));  //gettin ith Bit
        System.out.println(setIthBit(10, 2));  //set ith Bit
        System.out.println(clearIthBit(10, 1)); //clear ith Bit
        System.out.println(updateIthBit(10, 2, 1)); //Update ith Bit
        System.out.println(clearIbits(15, 2));  //clear LAst I Bits
        System.out.println(clearBitsInRange(10, 2, 4));//clear Bits in range


    }

}
