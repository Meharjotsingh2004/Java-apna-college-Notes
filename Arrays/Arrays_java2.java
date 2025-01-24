
public class Arrays_java2 {

//Binary Search In Sorted Array 
    public static int binarySearch(int number[], int key) {
        int start = 0;
        int end = number.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            //comparisons 
            if (number[mid] == key) {
                return mid;
            } else if (number[mid] > key) {

                end = mid - 1;
            } else if (number[mid] < key) {
                start = mid + 1;
            }

        }
        return -1;
    }

//Reversing an Array  with lower timcomplexity
    public static void reverseArray(int numbers[]) {
        int first = 0, last = numbers.length - 1;

        while (first < last) {
            int temp = numbers[last];
            numbers[last] = numbers[first];
            numbers[first] = temp;

            first++;
            last--;
        }
    }
//printing pairs
    public static void printPairs(int number[]) {
        int tp = 0;
        for (int i = 0; i < number.length; i++) {
            int curr = number[i];
            for (int j = i + 1; j < number.length; j++) {
                System.out.print("(" + curr + "," + number[j] + ")");
                tp++;
            }
            System.out.println();
        }
        System.out.println("Total Pairs :" + tp);
    }
//Printing subarrays
    public static void printSubarrays(int numbers[]) {
        int ts = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j < numbers.length; j++) {
                int start = i;
                int end = j;
                int sum=0;
                for (int k = start; k <= end; k++) {
                  sum+= numbers[k];
                    System.out.print(numbers[k] + " ");
                    ts++;
                }
                minSum = Math.min(minSum, sum);
                maxSum = Math.max(maxSum, sum);
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("total subArrays: " + ts);
        System.out.println("MIN SUM: " + minSum);
        System.out.println("MAX SUM: " + maxSum);
    }

    public static void main(String[] args) {
        int numbers[] = {2, 4, 6, 8, 10, 12, 14};
        int key = 10;

        System.out.println(binarySearch(numbers, key));

        reverseArray(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        int numbers2[] = {2, 4, 6, 8, 10};
        printPairs(numbers2);

        printSubarrays(numbers2);
    }

}
