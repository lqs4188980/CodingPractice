package com.leetcode.bestTimeToBuyAndSellStockIII;

public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1){
            return 0;
        }
        
        int length = prices.length;
        int[] leftMax = new int[length];
        
        // Calculate max profit from 0 to i
        int lowest = prices[0];
        int maxProfit = 0;
        leftMax[0] = 0;
        
        for (int i = 1; i < length; i++){
            // Profit of current value is subtract lowest price from today's price, and update the leftMax table
            int profit = prices[i] - lowest;
            
            // Update max profit
            if (profit > maxProfit){
                maxProfit = profit;
            }
            
            // Update leftMax
            leftMax[i] = maxProfit;
            
            // Update lowest price
            if (lowest > prices[i]){
                lowest = prices[i];
            }
        }
        
        // Calculate max profit from i to n
        int highest = prices[length - 1];
        maxProfit = 0;
        // Total max is the max profit produced by two transactions
        int totalMax = leftMax[length - 1];
        
        for (int i = length - 2; i >= 0; i--){
            // Profit is subtract today's price from highest price
            int profit = highest - prices[i];
            
            // Update max profit
            if (profit > maxProfit){
                maxProfit = profit;
            }
            
            // Update highest price
            if (highest < prices[i]){
                highest = prices[i];
            }
            
            // Update total max profit: add leftMax corresponding to the current profit
            int total = leftMax[i] + maxProfit;
            if (total > totalMax){
                totalMax = total;
            }
            
        }
        
        return totalMax;
        
    }
}
