
public class Arrays_java4 {

    //Trapping RainWater O(n)  
    public static int trappedRAinwater(int height[]) {
        //calculate left MAx boundry -array
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];

        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        //calculate right MAx boundry -array
        int rightMax[] = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];

        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        //loop
        int trappedWater = 0;
        for (int i = 0; i < height.length; i++) {
            //waterlevel = min(leftmax , rightmax)
            int waterlevel = Math.min(leftMax[i], rightMax[i]);
            //trapped water = waterlevel -height[i]
            trappedWater += waterlevel - height[i];
        }

        return trappedWater;
    }
//Buy And Sel  Stocks

    public static int buyAndSell(int prices[]){
         int buyPrice = Integer.MAX_VALUE;
         int maxprofit = 0 ;
         for(int i=0 ; i< prices.length ; i++){
            if(buyPrice<prices[i]){
                int profit = prices[i] -buyPrice;
                maxprofit = Math.max(maxprofit, profit);
            }else{
                buyPrice = prices[i];
            }
         }

         return maxprofit;
    }

    public static void main(String[] args) {
        int height[] = {4, 2, 0, 6, 3, 2, 5};
        System.out.println(trappedRAinwater(height));

        int prices[] = {7,1,5,3,6,4}; //O(n^2)
        System.out.println(buyAndSell(prices));
    }
}


