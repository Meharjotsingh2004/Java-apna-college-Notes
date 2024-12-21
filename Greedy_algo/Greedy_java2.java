
import java.util.*;

public class Greedy_java2 {

//Max Length chain Pairs ------->start O(nlogn)
    public static void main(String[] args) {
        int[][] pairs = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int chainLen = 1;
        int pairEnd = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > pairEnd) {
                pairEnd = pairs[i][1];
                chainLen++;
            }
        }
        System.out.println("Maximum Length of chain : " + chainLen);
//Max Length chain Pairs -------> ends

//Indian Coins -------->start
        int amount = 590;
        Integer[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 2000};

        Arrays.sort(coins, Comparator.reverseOrder());

        int countOfCoins = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                while (coins[i] <= amount) {
                    countOfCoins++;
                    amount -= coins[i];
                    ans.add(coins[i]);
                }
            }
        }
        System.out.println("Total no. of min coins Used : " + countOfCoins);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
//Indian Coins -------->end

//Jobs Sequencing -------> start
        int jobsInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};
        //Job class is also used
        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < jobsInfo.length; i++) {
           jobs.add(new  Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }
        Collections.sort(jobs , (obj1 , obj2)->obj2.profit-obj1.profit); //descending order 

        ArrayList<Integer> seq = new ArrayList<>();
        int time=0;
        for(int i=0 ; i< jobs.size() ; i++){
           Job curr = jobs.get(i);
           if(curr.deadline > time){
            seq.add(curr.id);
            time++;
           }
        }
        System.out.println("max Jobs That can be done : " + seq.size());
        for(int i=0 ; i<seq.size() ; i++){
            System.out.print(seq.get(i)+ " ");
        }System.out.println();


//Jobs Sequencing -------> end
    }

    static class Job {

        int deadline;
        int profit;
        int id;

        public Job(int i, int d, int p) {
            this.id = i;
            this.deadline = d;
            this.profit = p;
        }
    }
}
