
public class Arrays_java5 {

//bubble Sort O(n^2)
    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    //swap 
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        printArr(arr);
    }

//insertion sort  O(n^2)
    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;
            //finding corect position
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            //insertion
            arr[prev + 1] = curr;
        }
        printArr(arr);
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

//counting sort 
    public static void countSorting(int arr[]) {
        int largest = Integer.MIN_VALUE;

        for(int i=0 ; i< arr.length ; i++){
              largest = Math.max(largest, arr[i]);
        }
        int count[] = new int[largest+1];

        for(int i=0 ; i<arr.length ; i++ ){
            count[arr[i]]++;
        }
        //sorting

        int j=0;
        for(int i=0 ; i < count.length ; i++){
            while(count[i] > 0){
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
        printArr(arr);
    }

    public static void main(String[] args) {
        int arr[] = {5, 4, 1, 3, 2};
        bubbleSort(arr);
        int arr2[] = {5, 4, 1, 3, 2};
        insertionSort(arr2);
        // Arrays.sort(arr2, 0, 5);
        // Arrays.sort(arr2, Collections.reverseOrder());

        //printArr(arr2);
        int arr3[] = {5, 4, 1, 3, 2,1,1,1,99,78};
        countSorting(arr3);
    }
}
