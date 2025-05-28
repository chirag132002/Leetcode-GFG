class Solution {
    public int maxProfit(int[] arr) {
       int bestBuy = Integer.MAX_VALUE;
       int profit = 0;
       for(int i = 0; i< arr.length-1; i++){
        bestBuy = Math.min(bestBuy, arr[i]);
            profit = Math.max(profit, arr[i] - bestBuy);
       }
       return profit;
    }
}