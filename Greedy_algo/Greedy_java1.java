
import java.util.*;

class Greedy_java1 {

    public static void main(String[] args) {
//Activity Selection-------->start

        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        //For Sorting
        int[][] activites = new int[start.length][3];
        for (int i = 0; i < start.length; i++) {
            activites[i][0] = i;
            activites[i][1] = start[i];
            activites[i][2] = end[i];
        }

        //lambda function --> shortForm
        Arrays.sort(activites, Comparator.comparingInt(o -> o[2]));

        //end time basis sort 
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();//arrayList to store Answer

        //1st activity
        maxAct = 1;
        ans.add(0);
        int lastEnd = end[0];
        for (int i = 1; i < end.length; i++) {
            if (start[i] >= lastEnd) {
                //activity;
                maxAct++;
                ans.add(i);
                lastEnd = end[i];
            }
        }
        System.out.println("Max Activites : " + maxAct);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
//Activity Selection-------->end

//Fraectional KnapSack ---->Start
        int val[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int WT = 50;

        double ratio[][] = new double[val.length][2];

        for (int i = 0; i < ratio.length; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) weight[i];
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = WT;
        int finalVal = 0;
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];
            if (capacity >= weight[idx]) { //including full time 
                finalVal += val[idx];
                capacity -= weight[idx];
            } else {
                //fractional item
                finalVal += (capacity * ratio[i][1]);
                capacity = 0;
                break;
            }
        }
        System.out.println("Final Value : " + finalVal);
//Fractional KnapSack ---->end

//Minimum absolute Difference Pairs //O(nlogn)
        int[] A = {4, 1, 8, 7};
        int[] B = {2, 3, 6, 5};

        Arrays.sort(A);
        Arrays.sort(B);
        int minDiff = 0;
        for(int i =0 ; i< A.length ; i++){
            minDiff += Math.abs(A[i]-B[i]);
        }
        System.out.println("Minimum Absolute Difference is : " + minDiff);
//Minimum absolute Difference Pairs
    }
}
