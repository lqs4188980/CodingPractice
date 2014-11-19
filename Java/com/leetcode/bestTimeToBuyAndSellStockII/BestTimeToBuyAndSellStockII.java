package com.leetcode.bestTimeToBuyAndSellStockII;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0 || prices.length == 1){
            return 0;
        }
        // Get different from previous day;
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            int diff = prices[i] - prices[i - 1];
            if (diff > 0){
                profit += diff;
            }
        }
        return profit;
        
        
    }
}
